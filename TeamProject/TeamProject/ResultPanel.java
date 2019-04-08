package TeamProject;

import javax.swing.*;
import java.awt.*;


public class ResultPanel extends JPanel
{



	public ResultPanel(CardLayout cl, JPanel container) {
		setLayout(null);
		
		JLabel TopLable = new JLabel("Winner is :");
		TopLable.setForeground(Color.RED);
		TopLable.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		TopLable.setBounds(130, 11, 90, 27);
		add(TopLable);
		
		JLabel Winner = new JLabel("TBD");
		Winner.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		Winner.setBounds(230, 18, 46, 14);
		add(Winner);
		
		JLabel Scores = new JLabel("Scores");
		Scores.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		Scores.setBounds(184, 82, 78, 14);
		add(Scores);
		
		JLabel Player1 = new JLabel("Player 1");
		Player1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		Player1.setBounds(155, 159, 46, 14);
		add(Player1);
		
		JLabel Player1Score = new JLabel("TBD");
		Player1Score.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		Player1Score.setBounds(230, 160, 46, 14);
		add(Player1Score);
		
		JLabel Player2 = new JLabel("Player 2");
		Player2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		Player2.setBounds(155, 212, 65, 14);
		add(Player2);
		
		JLabel Player2Score = new JLabel("TBD");
		Player2Score.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		Player2Score.setBounds(230, 213, 46, 14);
		add(Player2Score);
		
		JButton btnPlayAgain = new JButton("Play Again");
		btnPlayAgain.setBounds(67, 311, 105, 23);
		add(btnPlayAgain);
		
		JButton btnQuit = new JButton("Exit");
		btnQuit.setBounds(251, 311, 105, 23);
		add(btnQuit);








	}
}









