package TeamProject;
import java.net.Socket;


import ocsf.client.AbstractClient;

public class PlayerClient extends AbstractClient
{
	private LoginControl loginControl;
	private CreateAccountControl createAccountControl;
	private GuessLetterControl guessLetterControl;
	private SpinWheelControl spinWheelControl;
	private ChooseCategoryControl chooseCategoryControl;
	private InitialControl InitialControl;
	private SwitchPlayer SwitchPlayer;

	//Constructor
	public PlayerClient() {super("localhost",8300);}
	public PlayerClient(String host, int port) {super(host,port);}

	public void setAccount(CreateAccountControl createAccountControl) {
		this.createAccountControl = createAccountControl;
	}
	
	public void setLogin(LoginControl loginControl) {
		this.loginControl = loginControl;
	}
	public void setguessLetterControl(GuessLetterControl guessLetterControl) {this.guessLetterControl = guessLetterControl;}
	public void setSwitchPlayer(SwitchPlayer SwitchPlayer) {this.SwitchPlayer = SwitchPlayer;}


	protected void handleMessageFromServer(Object arg0)
	{
		//LOGIN
		if (((String) arg0).equals("Account Created")) 
		{
			createAccountControl.addSuccess();
			loginControl.displayError("Account Successfully Created. Please Login.");
		}
		else if (((String) arg0).equals("Same Username")) 
		{
			createAccountControl.displayError("Username has already been selected.");
		}
		else if (((String) arg0).equals("Valid")) 
		{
			loginControl.loginSuccess();   //Login -> SelectCategory screen
		}
		else if (((String) arg0).equals("Invalid")) 
		{
			loginControl.displayError("Username/Password is incorrect");
		}  
		//"WORD DATA" FROM SERVER
		else if (arg0 instanceof GuessLetterData)
		{
			GuessLetterData tempGess = (GuessLetterData) arg0;

			guessLetterControl.setGuessLetterData(tempGess); 

		}

		//HANDLE SWITCH PLAYER REQUEST FROM SERVER
		else if (arg0 instanceof SwitchPlayer)
		{
			SwitchPlayer tempSwitch = (SwitchPlayer) arg0;
			spinWheelControl.setSwitchPlayer(SwitchPlayer);   

		}




	}
}
