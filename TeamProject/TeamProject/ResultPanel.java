package TeamProject;

import javax.swing.*;
import java.awt.*;


public class ResultPanel extends JPanel
{
  private JLabel TopLable;
  private JLabel Winner;
  private JLabel Scores;
  private JLabel Player1;
  private JLabel Player1Score;
  private JLabel Player2;
  private JLabel Player2Score;
  private JButton btnPlayAgain;
  private JButton btnQuit;
  
  //Getter and Setters
  public JLabel getWinner()
  {
    return Winner;
  }

  public void setWinner(JLabel winner)
  {
    Winner = winner;
  }

  public JLabel getPlayer1Score()
  {
    return Player1Score;
  }

  public void setPlayer1Score(JLabel player1Score)
  {
    Player1Score = player1Score;
  }

  public JLabel getPlayer2Score()
  {
    return Player2Score;
  }

  public void setPlayer2Score(JLabel player2Score)
  {
    Player2Score = player2Score;
  }

  
	public ResultPanel(ResultControl rc) {
		setLayout(null);
		
		TopLable = new JLabel("TBD");
		TopLable.setForeground(Color.RED);
		TopLable.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		TopLable.setBounds(130, 11, 90, 27);
		add(TopLable);
		
//		Winner = new JLabel("TBD");
//		Winner.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
//		Winner.setBounds(230, 18, 46, 14);
//		add(Winner);
		
		Scores = new JLabel("Scores");
		Scores.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		Scores.setBounds(184, 82, 78, 14);
		add(Scores);
		
		Player1 = new JLabel("Player 1");
		Player1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		Player1.setBounds(155, 159, 46, 14);
		add(Player1);
		
		Player1Score = new JLabel("TBD");
		Player1Score.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		Player1Score.setBounds(230, 160, 46, 14);
		add(Player1Score);
		
		Player2 = new JLabel("Player 2");
		Player2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		Player2.setBounds(155, 212, 65, 14);
		add(Player2);
		
		Player2Score = new JLabel("TBD");
		Player2Score.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		Player2Score.setBounds(230, 213, 46, 14);
		add(Player2Score);
		
		btnPlayAgain = new JButton("Play Again");
		btnPlayAgain.setBounds(67, 311, 105, 23);
		add(btnPlayAgain);
		
		btnQuit = new JButton("Exit");
		btnQuit.setBounds(251, 311, 105, 23);
		add(btnQuit);
	}
}
