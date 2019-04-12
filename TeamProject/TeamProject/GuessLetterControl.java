package TeamProject;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.*;

public class GuessLetterControl implements ActionListener {

	// private CardLayout cl;
	private JPanel container;
	private PlayerClient client;

	private GuessLetterData data;
	private JLabel lblWrong;
	private JTextField GuessedLetter;

	private ArrayList<Character> wordToDisplay;
	private String lbl;
	private String errMsg;
	private JLabel guessinglbl;

	public JLabel getguessinglbl() {
		return guessinglbl;
	}

	public void setguessinglbl(JLabel guessinglbl) {
		this.guessinglbl = guessinglbl;
	}
	
	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
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

				GuessLetterData data = new GuessLetterData(GuessedLetter.getText().charAt(0),
						guessLetterPanel.getPrice());
				setWord(data);
				
				try {
					client.sendToServer(data);
				} catch (IOException e) {
					e.printStackTrace();
				}

				guessinglbl.setText(wordToDisplay.toString());



			} else if (guessLetterPanel.getLetter() == "") {
				lblWrong.setText("Please enter a letter"); 

			} else if (guessLetterPanel.getLetter().length() > 1) {
				
				
			}
		}
	}

	public void display(GuessLetterData Data) {
		GuessLetterPanel guessLetterPannel = (GuessLetterPanel) container.getComponent(2);

		guessLetterPannel.setTextField_Price(data.getPrizeMoney());
	}

}