package TeamProject;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

public class GuessLetterPanel extends JPanel {
	private JTextField GuessTxtField;
	private JTextField textField_Score;
	private JTextField textField_Price;
	private String word;
	private String lbl;
	private JTextField textFieldOponent;
	private String errmsg;

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

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getLbl() {
		return lbl;
	}

	public void setLbl(String lbl) {
		this.lbl = lbl;
	}

	public GuessLetterPanel(GuessLetterControl cc) {
		setLayout(null);

		JLabel lblGuessALetter = new JLabel("Guess a Letter:-");
		lblGuessALetter.setForeground(Color.BLACK);
		lblGuessALetter.setFont(new Font("Tarzan", Font.PLAIN, 16));
		lblGuessALetter.setBounds(139, 10, 139, 26);
		add(lblGuessALetter);

		GuessTxtField = new JTextField();
		GuessTxtField.setBounds(106, 89, 71, 64);
		add(GuessTxtField);
		GuessTxtField.setColumns(10);
		cc.setJTextField(GuessTxtField);

		JButton btnGuess = new JButton("Guess");
		btnGuess.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		btnGuess.setBounds(207, 89, 85, 64);
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
		textField_Score.setBounds(21, 305, 96, 64);
		add(textField_Score);
		textField_Score.setColumns(10);

		textField_Price = new JTextField();
		textField_Price.setColumns(10);
		textField_Price.setBounds(296, 305, 96, 64);
		add(textField_Price);

		JPanel Word_Panel = new JPanel();
		Word_Panel.setBackground(Color.GRAY);
		Word_Panel.setBounds(21, 175, 353, 54);
		add(Word_Panel);
		Word_Panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		cc.setDisplayPanel(Word_Panel);

		JLabel lblChoosenLettes = new JLabel("Choosen Lettes:-");
		lblChoosenLettes.setFont(new Font("Tarzan", Font.PLAIN, 13));
		lblChoosenLettes.setForeground(Color.RED);
		lblChoosenLettes.setBounds(21, 379, 126, 26);
		add(lblChoosenLettes);

		JLabel lblWrongLetters = new JLabel("letters");
		lblWrongLetters.setForeground(new Color(0, 0, 0));
		lblWrongLetters.setFont(new Font("Roland", Font.PLAIN, 18));
		lblWrongLetters.setBounds(31, 407, 244, 33);
		add(lblWrongLetters);
		lbl = cc.getWord().toString();
		JLabel label = new JLabel(lbl);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 36));
		Word_Panel.add(new JLabel(lbl));

		JLabel lblError = new JLabel("Error Messages");
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setForeground(Color.RED);
		lblError.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblError.setBounds(46, 46, 328, 33);
		lblError.setVisible(false);
		cc.setErrlbl(lblError);

		// cc.setDisplayPanel(Word_Panel);

		add(lblError);

		JLabel lblOponentScore = new JLabel("Oponent Score:-");
		lblOponentScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblOponentScore.setForeground(Color.RED);
		lblOponentScore.setFont(new Font("Tarzan", Font.PLAIN, 15));
		lblOponentScore.setBounds(127, 270, 143, 26);
		add(lblOponentScore);

		textFieldOponent = new JTextField();
		textFieldOponent.setColumns(10);
		textFieldOponent.setBounds(137, 305, 96, 64);
		add(textFieldOponent);
	}

}
