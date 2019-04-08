package TeamProject;
import java.net.Socket;

import ocsf.client.AbstractClient;

public class PlayerClient extends AbstractClient
{
	private LoginControl LoginControl;
	private CreateAccountControl CreateAccountControl;
	private GuessLetterControl guessLetterControl;
	private SpinWheelControl spinWheelControl;
	private ChooseCategoryControl chooseCategoryControl;
	private InitialControl InitialControl;
	private SwitchPlayer SwitchPlayer;

	//Constructor
	public PlayerClient() {super("localhost",8300);}
	public PlayerClient(String host, int port) {super(host,port);}
	
	
	public void setguessLetterControl(SwitchPlayer SwitchPlayer) {this.guessLetterControl = guessLetterControl;}
	public void setSwitchPlayer(SwitchPlayer SwitchPlayer) {this.SwitchPlayer = SwitchPlayer;}


	protected void handleMessageFromServer(Object arg0)
	{
		//LOGIN
		if (((String) arg0).equals("Account Created")) 
		{
			CreateAccountControl.createAccountSuccess();
			LoginControl.displayError("Account Successfully Created. Please Login.");
		}
		else if (((String) arg0).equals("Same Username")) 
		{
			CreateAccountControl.displayError("Username has already been selected.");
		}
		else if (((String) arg0).equals("Valid")) 
		{
			cl.show(container, "4");    //Login -> SelectCategory screen
		}
		else if (((String) arg0).equals("Invalid")) 
		{
			LoginControl.displayError("Username/Password is incorrect");
		}  
		//"WORD DATA" FROM SERVER
		else if (arg0 instanceof GuessLetterData)
		{
			guessLetterControl.setGuessLetterData(GuessLetterData); 
			//after the letter is guessed, send back the guessed letter to server
			this.sendToServer(GuessLetterData); 
		}

		//HANDLE SWITCH PLAYER REQUEST FROM SERVER
		else if (arg0 instanceof SwitchPlayer)
		{
			spinWheelControl.setSwitchPlayer(SwitchPlayer);   
			//after that player turn, send back the player turn info to server so server can switch player. 
			this.sendToServer(SwitchPlayer);
		}




	}

