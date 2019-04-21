package TeamProject;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

public class GuessLetterPanel extends JPanel {
	private JTextField GuessTxtField;
	private JTextField textField_Score;
	private JTextField textField_Price;
	private JTextField textFieldOponent;

	private JLabel turnLabel;
	private JLabel guessinglbl;
	private JLabel lblError;
	private JLabel lblLettersSoFar;
	private JButton btnGuess;

	private JPanel Word_Panel;

	public String getLetter() {
		return GuessTxtField.getText();
	}

	public Integer getPrice() {
		return Integer.parseInt(textField_Price.getText());
	}

	public JTextField getGuessTxtField() {
		return GuessTxtField;
	}

	public void setGuessTxtField(String guessText) {
		GuessTxtField.setText(guessText);
	}

	public JTextField getTextField_Score() {
		return textField_Score;
	}

	public void setTextField_Score(String text) {
		this.textField_Score.setText(text);
	}

	public JTextField getTextField_Price() {
		return textField_Price;
	}

	public void setTextField_Price(Integer textField_Price) {
		this.textField_Price.setText(textField_Price.toString());
	}

	public GuessLetterPanel(GuessLetterControl cc) {
		setLayout(null);

		JLabel lblGuessALetter = new JLabel("Guess a Letter:-");
		lblGuessALetter.setForeground(Color.BLACK);
		lblGuessALetter.setFont(new Font("Tarzan", Font.PLAIN, 16));
		lblGuessALetter.setBounds(139, 10, 139, 26);
		add(lblGuessALetter);

		GuessTxtField = new JTextField();
		GuessTxtField.setFont(new Font("Tahoma", Font.PLAIN, 29));
		GuessTxtField.setBounds(104, 125, 71, 64);
		add(GuessTxtField);
		GuessTxtField.setColumns(10);
		cc.setJTextField(GuessTxtField);

		btnGuess = new JButton("Guess");
		btnGuess.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		btnGuess.setBounds(207, 125, 85, 64);
		cc.setGuessButton(btnGuess);
		add(btnGuess);
		btnGuess.addActionListener(cc);

		JLabel lblScore = new JLabel("Score:-");
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setForeground(Color.RED);
		lblScore.setFont(new Font("Tarzan", Font.PLAIN, 17));
		lblScore.setBounds(21, 269, 96, 26);
		add(lblScore);

		JLabel lblPrice = new JLabel("Price:-");
		lblPrice.setForeground(Color.RED);
		lblPrice.setFont(new Font("Tarzan", Font.PLAIN, 17));
		lblPrice.setBounds(296, 269, 62, 26);
		add(lblPrice);

		textField_Score = new JTextField();
		textField_Score.setForeground(Color.BLACK);
		textField_Score.setFont(new Font("Tahoma", Font.PLAIN, 29));
		textField_Score.setBounds(21, 305, 96, 64);
		textField_Score.setEditable(false);
		cc.setTextField_Score(textField_Score);
		add(textField_Score);
		textField_Score.setColumns(10);

		textField_Price = new JTextField();
		textField_Price.setForeground(Color.BLACK);
		textField_Price.setFont(new Font("Tahoma", Font.PLAIN, 26));
		textField_Price.setColumns(10);
		textField_Price.setBounds(296, 305, 96, 64);
		cc.setTextField_Price(textField_Price);
		add(textField_Price);

		Word_Panel = new JPanel();
		Word_Panel.setBackground(Color.GRAY);
		Word_Panel.setBounds(27, 208, 353, 54);
		add(Word_Panel);
		Word_Panel.setLayout(new BorderLayout());

		JLabel lblChoosenLettes = new JLabel("Choosen Lettes:-");
		lblChoosenLettes.setFont(new Font("Tarzan", Font.PLAIN, 13));
		lblChoosenLettes.setForeground(Color.RED);
		lblChoosenLettes.setBounds(21, 379, 126, 26);
		add(lblChoosenLettes);

		lblLettersSoFar = new JLabel("letters");
		lblLettersSoFar.setForeground(new Color(0, 0, 0));
		lblLettersSoFar.setFont(new Font("Roland", Font.PLAIN, 18));
		lblLettersSoFar.setBounds(31, 407, 361, 33);
		cc.setlblLettersSoFar(lblLettersSoFar);
		add(lblLettersSoFar);

		guessinglbl = new JLabel("Word with correct letters");
		guessinglbl.setForeground(Color.WHITE);
		guessinglbl.setFont(new Font("Tahoma", Font.BOLD, 36));
		cc.setGuessinglbl(guessinglbl);
		Word_Panel.add(guessinglbl, BorderLayout.CENTER);

		lblError = new JLabel();
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setForeground(Color.RED);
		lblError.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblError.setBounds(30, 47, 328, 33);
//		lblError.setVisible(false);
		cc.setlblError(lblError);
		add(lblError);

		JLabel lblOponentScore = new JLabel("Oponent Score:-");
		lblOponentScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblOponentScore.setForeground(Color.RED);
		lblOponentScore.setFont(new Font("Tarzan", Font.PLAIN, 15));
		lblOponentScore.setBounds(127, 270, 143, 26);
		add(lblOponentScore);

		textFieldOponent = new JTextField();
		textFieldOponent.setForeground(Color.BLACK);
		textFieldOponent.setFont(new Font("Tahoma", Font.PLAIN, 29));
		textFieldOponent.setColumns(10);
		textFieldOponent.setBounds(137, 305, 96, 64);
		cc.setOpponent_Score(textFieldOponent);
		add(textFieldOponent);

		turnLabel = new JLabel("Who's turn?");
		turnLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		turnLabel.setForeground(Color.RED);
		turnLabel.setHorizontalAlignment(SwingConstants.CENTER);
		turnLabel.setBounds(56, 80, 296, 35);
		cc.setTurnLabel(turnLabel);
		add(turnLabel);

		JLabel label = new JLabel("'money$ ");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 34));
		label.setForeground(Color.BLACK);
		label.setBounds(274, 302, 18, 67);
		add(label);
	}
}
