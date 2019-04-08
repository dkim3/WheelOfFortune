package TeamProject;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;

public class SpinWheelPanel extends JPanel {
	private JTextField txtScoreToBe;
	public SpinWheelPanel(CardLayout cl, JPanel container){
		setLayout(null);
		
		JLabel lblWheelOfFortune = new JLabel("Wheel OF Fortune");
		lblWheelOfFortune.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		lblWheelOfFortune.setBounds(114, 17, 173, 23);
		add(lblWheelOfFortune);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SpinWheelPanel.class.getResource("/TeamProject/WheelOfFortune.png")));
		lblNewLabel.setBounds(67, 51, 238, 223);
		add(lblNewLabel);
		
		JButton btnSpinTheWheel = new JButton("Spin The Wheel");
		btnSpinTheWheel.setBounds(20, 343, 130, 23);
		add(btnSpinTheWheel);
		
		JButton btnGuessLetter = new JButton("Guess Letter");
		btnGuessLetter.setBounds(237, 343, 122, 23);
		add(btnGuessLetter);
		
		txtScoreToBe = new JTextField();
		txtScoreToBe.setText("Score to be updated");
		txtScoreToBe.setBounds(140, 287, 116, 20);
		add(txtScoreToBe);
		txtScoreToBe.setColumns(10);
	}
}
