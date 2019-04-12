package TeamProject;

import java.util.ArrayList;

public class GuessLetterData {
	private Integer prizeMoney;
	private String wordToGuess;
	private ArrayList<Character> chosenLetter;
	private Integer score;

	public void setScore(Integer score) {
		this.score = score;
	}

	public GuessLetterData(char charAt, Integer price) {
		chosenLetter = new ArrayList<Character>();

		this.chosenLetter.add(charAt);
		this.prizeMoney = price;
	}

	public void setPrizeMoney(Integer prizeMoney) {
		this.prizeMoney = prizeMoney;
	}

	public void setwordToGuess(String wordToGuess) {
		this.wordToGuess = wordToGuess;
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

}
