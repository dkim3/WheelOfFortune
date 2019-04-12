package TeamProject;

public class SwitchPlayer
{
	private PlayerClient currentPlayer;
	private PlayerClient nextPlayer;

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
