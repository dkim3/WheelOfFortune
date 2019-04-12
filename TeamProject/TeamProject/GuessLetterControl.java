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
	
	private JTextField textField_Score;
	private JTextField textField_Price;
	private JTextField textFieldOponent;

	private GuessLetterData data;
	private JLabel lblWrong;
	private JTextField GuessedLetter;
	private JPanel displayPanel;
	private ArrayList<Character> wordToDisplay;
	private String lbl;
	private String errMsg;
	private JLabel turnLabel;

	public JLabel getErrlbl() {
		return lblWrong;
	}

	public void setErrlbl(JLabel errLbl) {
		this.lblWrong = errLbl;
	}

	public JPanel getDisplayPanel() {
		return displayPanel;
	}

	public void setDisplayPanel(JPanel displayPanel) {
		this.displayPanel = displayPanel;
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
				lblWrong.setVisible(false);

				GuessLetterData data = new GuessLetterData(GuessedLetter.getText().charAt(0),
						guessLetterPanel.getPrice());

				try {
					client.sendToServer(data);
				} catch (IOException e) {
					e.printStackTrace();
				}

				lbl = wordToDisplay.toString();
				JLabel label = new JLabel(lbl);
				label.setForeground(Color.WHITE);
				label.setFont(new Font("Tahoma", Font.BOLD, 36));
				displayPanel.add(new JLabel(lbl));
			} else if (guessLetterPanel.getLetter() == "") {
				lblWrong.setText("Please enter a letter");
				lblWrong.setVisible(true);
				GuessedLetter.setText("");

			} else if (guessLetterPanel.getLetter().length() > 1) {
				lblWrong.setText("Please enter only one letter");
				lblWrong.setVisible(true);
				GuessedLetter.setText("");
			}
		}
	}

	public void updateDisplay(GuessLetterData Data) {
		
		setWord(data);

		textField_Score.setText(Data.get);
		textField_Price.setText(Data.getPrizeMoney().toString());
		textFieldOponent.setText(Data.get);

		
		guessinglbl.setText(Data.getwordToGuess().toString());

		GuessLetterPanel guessLetterPannel = (GuessLetterPanel) container.getComponent(2);

		guessLetterPannel.setTextField_Price(data.getPrizeMoney());
		
	}

}
