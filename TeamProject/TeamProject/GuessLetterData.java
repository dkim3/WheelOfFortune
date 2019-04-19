package TeamProject;

import java.util.ArrayList;

public class GuessLetterData {
	private Integer prizeMoney;
	private String wordToGuess;
	private ArrayList<Character> chosenLetter;
	private Integer score;
	private Integer score_2;
	private Integer letterLeft;

	public GuessLetterData() {
		chosenLetter = new ArrayList<Character>();
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
