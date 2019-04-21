
package TeamProject;

import java.io.Serializable;
import java.util.ArrayList;

public class SwitchPlayer implements Serializable {
	private PlayerClient currentPlayer;
	private PlayerClient nextPlayer;
	private ArrayList<Character> lettersSoFar;

	public SwitchPlayer() {
		lettersSoFar = new ArrayList<Character>();
	}

	public SwitchPlayer(PlayerClient currentPlayer, PlayerClient nextPlayer) {
		lettersSoFar = new ArrayList<Character>();
		this.currentPlayer = currentPlayer;
		this.nextPlayer = nextPlayer;
	}

	public PlayerClient getCurrentPlayer() {
		return currentPlayer;
	}

	public PlayerClient getNextPlayer() {
		return nextPlayer;
	}

	public void setCurrentPlayer(PlayerClient CurrentPlayer) {
		this.currentPlayer = CurrentPlayer;
	}

	public void setNextPlayer(PlayerClient nextPlayer) {
		this.nextPlayer = nextPlayer;
	}
	
	public ArrayList<Character> getLettersSoFar() {
		return lettersSoFar;
	}

	public void setLettersSoFar(ArrayList<Character> lettersSoFar) {
		this.lettersSoFar = lettersSoFar;
	}
}
