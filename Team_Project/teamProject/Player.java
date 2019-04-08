package teamProject;

import javax.swing.JPasswordField;

public class Player
{
  private String username;
  private int score;
  private JPasswordField passwordField;

  //Setters and Getters
  public void setUsername(String username)
  {
    this.username = username;
  }
  
  public String getUsername()
  {
    return username;
  }f
  
  
  public int getScore()
  {
    return score;
  }
  
  public void setScore(int score)
  {
    this.score = score;
  }
  
  public JPasswordField getPasswordField()
  {
    return passwordField;
  }
  
  public void setPasswordField(JPasswordField passwordField)
  {
    this.passwordField = passwordField;
  }
}
