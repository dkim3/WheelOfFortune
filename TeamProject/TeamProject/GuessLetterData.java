package TeamProject;

public class GuessLetterData
{
	private Integer prizeMoney;
	private String wordToGuess;
	private Character chosenLetter;
	
	public void setPrizeMoney(Integer prizeMoney) {
		this.prizeMoney = prizeMoney;		
	}
	public void setwordToGuess(String wordToGuess) {
		this.wordToGuess = wordToGuess;		
	}
	public void setchosenLetter(Character chosenLetter) {
		this.chosenLetter = chosenLetter;		
	}
	
	public Integer getPrizeMoney() {
		return prizeMoney;
	}
	public String getwordToGuess() {
		return wordToGuess;
	}
	public Character getchosenLetter() {
		return chosenLetter;
	}
	
	
}
