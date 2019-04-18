package TeamProject;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.*;

public class GuessLetterControl implements ActionListener {

	// Private Data Fields
	private JPanel container;
	private PlayerClient client;
	private GuessLetterData data;
	private SwitchPlayer switchPlayer;
	private ArrayList<Character> wordToDisplay;

	private JTextField textField_Score;
	private JTextField opponent_Score;
	private JTextField textField_Price;
	private JTextField textFieldOponent;
	private JTextField GuessedLetter;

	private String lbl;
	private String errMsg;

	private JLabel turnLabel;
	private JLabel lblLettersSoFar;
	private JLabel guessinglbl;
	private JLabel lblError;

	// setters and getters
	public JTextField getTextField_Score() {
		return textField_Score;
	}

	public void setTextField_Score(JTextField textField_Score) {
		this.textField_Score = textField_Score;
	}

	public JTextField getOpponent_Score() {
		return opponent_Score;
	}

	public void setOpponent_Score(JTextField opponent_Score) {
		this.opponent_Score = opponent_Score;
	}

	public JLabel getlblLettersSoFar() {
		return lblLettersSoFar;
	}

	public void setlblLettersSoFar(JLabel lblLettersSoFar) {
		this.lblLettersSoFar = lblLettersSoFar;
	}

	public JLabel getGuessinglbl() {
		return guessinglbl;
	}

	public void setGuessinglbl(JLabel guessinglbl) {
		this.guessinglbl = guessinglbl;
	}

	public JLabel getlblError() {
		return lblError;
	}

	public void setlblError(JLabel errLbl) {
		this.lblError = errLbl;
	}

	public void setWord(GuessLetterData Data) {

		ArrayList<Character> letters = Data.getchosenLetter();
		String answer = Data.getwordToGuess();

		ArrayList<Character> displayAnswer = new ArrayList<>();
		Character correctletter = letters.get(letters.size());

		Integer index = answer.indexOf(letters.get(letters.size()).toString());
		if (letters.size() == 0) {
			for (int x = 0; x < answer.length(); x++) {
				displayAnswer.add('_');
			}
		} else if (answer.contains(letters.get(letters.size()).toString())) {

			displayAnswer.set(index, correctletter);
		} else {
			displayAnswer = wordToDisplay;

		}

		this.wordToDisplay = displayAnswer;

	}

	public ArrayList<Character> getWord() {
		return wordToDisplay;
	}

	public void setGuessedLetterData(GuessLetterData Data) {
		this.data = Data;
	}

	public void setJTextField(JTextField guess) {
		this.GuessedLetter = guess;
	}

	public GuessLetterControl(JPanel container, PlayerClient client) {
		// this.cl = cl;
		this.container = container;
		this.client = client;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		// Get the username and password the user entered.
		GuessLetterPanel guessLetterPanel = (GuessLetterPanel) container.getComponent(4);

		String command = arg0.getActionCommand();

		if (command == "Guess") {
			if (guessLetterPanel.getLetter().length() == 1) {
				// GuessTxtField.getT
				lblError.setVisible(false);

				if (data.getwordToGuess().contains(guessLetterPanel.getLetter())) {
					data.setScore(data.getPrizeMoney() + data.getScore());
					data.setLetterLeft(data.getLetterLeft() - 1);
					try {
						client.sendToServer(data);
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else
					try {
						client.sendToServer(switchPlayer);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				lbl = wordToDisplay.toString();
				guessinglbl.setText(lbl);
				guessinglbl.setForeground(Color.WHITE);
				guessinglbl.setFont(new Font("Tahoma", Font.BOLD, 36));
				guessinglbl.setVisible(true);

				// displayPanel.add(guessinglbl,BorderLayout.CENTER);
			} else if (guessLetterPanel.getLetter() == "") {
				lblError.setText("Please enter a letter");
				lblError.setVisible(true);
				GuessedLetter.setText("");

			} else if (guessLetterPanel.getLetter().length() > 1) {
				lblError.setText("Please enter only one letter");
				lblError.setVisible(true);
				GuessedLetter.setText("");
			}

		}
	}

	//
	public void updateDisplay(GuessLetterData Data) {

		setWord(data);

		textField_Score.setText(Data.getScore().toString());
		textField_Price.setText(Data.getPrizeMoney().toString());
		textFieldOponent.setText(Data.getScore().toString());

		// set the word with the right guessed letters so far
		guessinglbl.setText(Data.getwordToGuess().toString());
		lblLettersSoFar.setText(Data.getchosenLetter().toString());
		lblLettersSoFar.setVisible(true);

		GuessLetterPanel guessLetterPannel = (GuessLetterPanel) container.getComponent(2);

		guessLetterPannel.setTextField_Price(data.getPrizeMoney());

	}

	public void waitScreen(GuessLetterData Data) {
		// Show the results. The winner.
		textField_Score.setText(Data.getScore().toString());
		opponent_Score.setText(Data.getScore_2().toString());

	}

}
