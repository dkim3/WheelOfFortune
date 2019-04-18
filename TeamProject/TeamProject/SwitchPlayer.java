    
package TeamProject;

public class SwitchPlayer
{
  private PlayerClient currentPlayer;
  private PlayerClient nextPlayer;
  private Integer score;
  private Integer score_2;

  public Integer getScore()
  {
    return score;
  }

  public void setScore(Integer score)
  {
    this.score = score;
  }

  public Integer getScore_2()
  {
    return score_2;
  }

  public void setScore_2(Integer score_2)
  {
    this.score_2 = score_2;
  }

  public SwitchPlayer (PlayerClient currentPlayer, PlayerClient nextPlayer)
  {
    this.currentPlayer = currentPlayer;
    this.nextPlayer = nextPlayer;
  }

  public PlayerClient getCurrentPlayer () {
    return currentPlayer;
  }
  public PlayerClient getNextPlayer () {
    return nextPlayer;
  }
  public void setCurrentPlayer (PlayerClient CurrentPlayer)
  {
    this.currentPlayer= CurrentPlayer;
  }
  public void setNextPlayer (PlayerClient nextPlayer)
  {
    this.nextPlayer= nextPlayer;
  }
}
