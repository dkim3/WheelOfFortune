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
	private GuessData data;

	private SwitchPlayer switchPlayer;
	private ArrayList<Character> wordToDisplay;
	private ArrayList<Character> lettersSoFar;

	private JTextField textField_Score;
	private JTextField opponent_Score;
	private JTextField textField_Price;

	private JTextField GuessedLetter;

	private String lbl;
	private String errMsg;

	private JLabel turnLabel;
	private JLabel lblLettersSoFar;
	private JLabel guessinglbl;
	private JLabel lblError;

	private JButton guessButton;

	// setters and getters
	public GuessData getData() {
		return data;
	}

	public void setData(GuessData data) {
		this.data = data;
	}

	public JTextField getTextField_Price() {
		return textField_Price;
	}

	public void setTextField_Price(JTextField textField_Price) {
		this.textField_Price = textField_Price;
	}

	public JLabel getTurnLabel() {
		return turnLabel;
	}

	public void setTurnLabel(JLabel turnLabel) {
		this.turnLabel = turnLabel;
	}

	public JButton getGuessButton() {
		return guessButton;
	}

	public void setGuessButton(JButton guessButton) {
		this.guessButton = guessButton;
	}

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

	public void setWord(GuessData Data) {

		ArrayList<Character> letters = Data.getchosenLetter();
		String answer = Data.getwordToGuess();

		ArrayList<Character> displayAnswer = new ArrayList<>();
		Character correctletter = letters.get(letters.size()-1);

		Integer index = answer.indexOf(correctletter)+1;
		
		for(int i = 0; i< answer.length();i++)
		{
			char a = answer.charAt(i);
			if(letters.contains(a))
				displayAnswer.add(a);
			else
				displayAnswer.add('_');
		}


		this.wordToDisplay = displayAnswer;

	}

	public ArrayList<Character> getWord() {
		return wordToDisplay;
	}

	public void setGuessedLetterData(GuessData Data) {
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

	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		// Get the username and password the user entered.
		GuessLetterPanel guessLetterPanel = (GuessLetterPanel) container.getComponent(5);
		data.setPrizeMoney(guessLetterPanel.getPrice());
		String command = arg0.getActionCommand();

		if (command == "Guess") {

			//if player didn't enter anything
			if (guessLetterPanel.getLetter() == "") {
				lblError.setText("Please enter a letter");
				lblError.setVisible(true);
				GuessedLetter.setText("");
			}
			//if player entered more than one character
			else if (guessLetterPanel.getLetter().length() > 1) {
				lblError.setText("Please enter only one letter");
				lblError.setVisible(true);
				GuessedLetter.setText("");
			}
			//if player entered on character
			else if (guessLetterPanel.getLetter().length() == 1) {

				// GuessTxtField.getT
				turnLabel.setText("Your Turn!");
				guessButton.setVisible(true);
				Character tempLetter = guessLetterPanel.getLetter().charAt(0);

				//check if the input is not a character
				if(! Character.isLetter(tempLetter) )
				{
					lblError.setText("Please enter a valid character (a-z)");
					lblError.setVisible(true);
					GuessedLetter.setText("");
				}
				//input is a valid character
				else {
					//if the character is already been chosen before
					if(data.getchosenLetter().contains(tempLetter) )
					{
						lblError.setText("Letter "+ tempLetter+ " is already guessed before ");
						lblError.setVisible(true);
						GuessedLetter.setText("");
					}
					//input is a new character
					else {
						data.setchosenLetter(tempLetter);
						
						//input is right
						if (data.getwordToGuess().contains(tempLetter.toString() )) {
							lblError.setVisible(true);
							lblError.setText("Wowww your guess it right ");
							
							GuessedLetter.setText("");

							data.setScore(data.getPrizeMoney() + data.getScore());
							data.setLetterLeft(data.getLetterLeft() - 1);
							
							updateDisplay(data);
							
							
							try {
								Thread.sleep(3000);
								client.sendToServer(data);
							} catch (IOException | InterruptedException e) {
								e.printStackTrace();
							}
							
							// user have to spin the wheel again
							SpinWheelPanel spinPanel = (SpinWheelPanel) container.getComponent(4);
							spinPanel.startSpin();

							CardLayout cardLayout = (CardLayout) container.getLayout(); 
							cardLayout.show(container, "5");
						}
						
						//input is wrong and going to switch user
						else
						{
							lblError.setText("Too bad you are wrong");

							GuessedLetter.setText("");
							updateDisplay(data);
							waitScreen();

							try {
								SwitchPlayer tempswitchPlayer = new SwitchPlayer();
								
//								tempswitchPlayer.setLettersSoFar(data.getchosenLetter());
								System.out.println("going to send switch plaer from client to server");
								client.sendToServer(tempswitchPlayer);
//								Thread.currentThread().();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}

				}

			}
		}

	}

	//
	public void updateDisplay(GuessData Data) {

		setWord(Data);

		textField_Score.setText(Data.getScore().toString());
		opponent_Score.setText(Data.getScore_2().toString());

		textField_Price.setText(Data.getPrizeMoney().toString());


		lbl = wordToDisplay.toString();
		guessinglbl.setVisible(true);

		// set the word with the right guessed letters so far
		guessinglbl.setText(wordToDisplay.toString());
		
		lblLettersSoFar.setText(Data.getchosenLetter().toString());
		lblLettersSoFar.setVisible(true);



	}

	public void waitScreen() {

		CardLayout cardLayout = (CardLayout) container.getLayout(); // send user to guess letter panel
		cardLayout.show(container, "6");

		guessButton.setVisible(false);
		GuessedLetter.setEditable(false);
		
		turnLabel.setText("Opponent Turn");
	}

}
