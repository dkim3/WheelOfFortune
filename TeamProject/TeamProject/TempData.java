
package TeamProject;

import java.io.Serializable;
import java.util.ArrayList;

public class TempData implements Serializable {
	private PlayerClient currentPlayer;
	private PlayerClient nextPlayer;
	private ArrayList<Character> lettersSoFar;

	private Integer prizeMoney;
	private String wordToGuess;
	private ArrayList<Character> chosenLetter;
	private Integer score;
	private Integer score_2;
	private Integer letterLeft;

	public TempData() {
		prizeMoney =0;
		wordToGuess="";
		score=0;
		score_2=0;

		chosenLetter = new ArrayList<Character>();
	}

	public TempData(PlayerClient currentPlayer, PlayerClient nextPlayer) {
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
	
	public String getWordToGuess()
	{
		return wordToGuess;
	}
	public void setWordToGuess(String wordToGuess)
	{
		this.wordToGuess = wordToGuess;
	}
	public ArrayList<Character> getChosenLetter()
	{
		return chosenLetter;
	}
	public void setChosenLetter(ArrayList<Character> chosenLetter)
	{
		this.chosenLetter = chosenLetter;
	}
	public Integer getScore_2()
	{
		return score_2;
	}
	public void setScore(Integer score)
	{
		this.score = score;
	}
	public void setLetterLeft(Integer letterLeft)
	{
		this.letterLeft = letterLeft;
	}
	public void setScore_2(Integer score_2) {
		this.score_2 = score_2;	
	}

	public void setPrizeMoney(Integer prizeMoney) {
		this.prizeMoney = prizeMoney;
	}

	public void setwordToGuess(String wordToGuess) {
		this.wordToGuess = wordToGuess;
		this.letterLeft = (int) wordToGuess.chars().distinct().count();

	}

	public void setchosenLetter(Character chosenLetter) {
		this.chosenLetter.add(chosenLetter);
	}

	public Integer getPrizeMoney() {
		return prizeMoney;
	}

	public Integer getScore() {
		return score;
	}

	public String getwordToGuess() {
		return wordToGuess;
	}

	public ArrayList<Character> getchosenLetter() {
		return chosenLetter;
	}
	public Integer getLetterLeft() {
		return letterLeft;
	}

}
