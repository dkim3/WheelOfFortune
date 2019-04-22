package TeamProject;
import java.net.Socket;


import ocsf.client.AbstractClient;

public class PlayerClient extends AbstractClient
{
	private InitialControl InitialControl;

	private LoginControl loginControl;
	private CreateAccountControl createAccountControl;
	private GuessLetterControl guessLetterControl;
	private SpinWheelControl spinWheelControl;
	private ChooseCategoryControl chooseCategoryControl;
	private ResultControl resultControl;
	
	private SwitchPlayer players;


	//Constructor
	public PlayerClient() {
		super("localhost",8300);
	}
	public PlayerClient(String host, int port) {
		super(host,port);
	}

	public InitialControl getInitialControl() {
		return InitialControl;
	}
	public void setInitialControl(InitialControl initialControl) {
		InitialControl = initialControl;
	}

	public LoginControl getLoginControl() {
		return loginControl;
	}
	public void setLoginControl(LoginControl loginControl) {
		this.loginControl = loginControl;
	}

	public CreateAccountControl getCreateAccountControl() {
		return createAccountControl;
	}
	public void setCreateAccountControl(CreateAccountControl createAccountControl) {
		this.createAccountControl = createAccountControl;
	}

	public GuessLetterControl getGuessLetterControl() {
		return guessLetterControl;
	}
	public void setGuessLetterControl(GuessLetterControl guessLetterControl) {
		this.guessLetterControl = guessLetterControl;
	}

	public SpinWheelControl getSpinWheelControl() {
		return spinWheelControl;
	}
	public void setSpinWheelControl(SpinWheelControl spinWheelControl) {
		this.spinWheelControl = spinWheelControl;
	}

	public ChooseCategoryControl getChooseCategoryControl() {
		return chooseCategoryControl;
	}
	public void setChooseCategoryControl(ChooseCategoryControl chooseCategoryControl) {
		this.chooseCategoryControl = chooseCategoryControl;
	}

	public ResultControl getResultControl() {
		return resultControl;
	}
	public void setResultControl( ResultControl resultControl ) {
		this.resultControl = resultControl;
	}



	protected void handleMessageFromServer(Object arg0)
	{
		//LOGIN
		if (arg0 instanceof LoginData)
		{
			LoginData loginData = (LoginData) arg0;

			if(loginData.getUsername().equals(""))
			{
				System.out.println("Server Message sent to Client fail to login");
				loginControl.displayError("The username and password are incorrect");
			}
			else
			{
				System.out.println("Server Message sent to Client succed to login");
				loginControl.loginSuccess();
			}
		}
		else if( arg0 instanceof CreateAccountData)
		{
			CreateAccountData accountData = (CreateAccountData) arg0;
			if(accountData.getUsername().equals(""))
			{
				System.out.println("Server Message sent to Client fail to add account");
				createAccountControl.displayError("Username is already being used");
			}

			else
			{
				System.out.println("Server Message sent to Client added account");
				createAccountControl.addSuccess();

			}
		}

		else if(arg0 instanceof CategoryData) {
			System.out.println("got a categoryData from server");
			CategoryData tempcategory = (CategoryData) arg0;
			GuessData tempGuessData = new GuessData();
			tempGuessData.setWordToGuess(tempcategory.getWord());      

			spinWheelControl.setGld(tempGuessData);
			spinWheelControl.startSpin();

			guessLetterControl.setGuessedLetterData(tempGuessData);
			
		}
		//"WORD DATA" FROM SERVER
		else if (arg0 instanceof GuessData)
		{ 			
			System.out.println("got a GuessData from server");

			GuessData tempGuessData = (GuessData) arg0;
			
			int a = tempGuessData.getLetterLeft();
			
			if (a == 0)
			{
				resultControl.loser(tempGuessData);
			}
			//when player receive GuessData which mean he get it wrong
			guessLetterControl.waitScreen();

			guessLetterControl.updateDisplay(tempGuessData); 
		}

		//HANDLE SWITCH PLAYER REQUEST FROM SERVER
		else if (arg0 instanceof SwitchPlayer)
		{
			SwitchPlayer tempSwitch = (SwitchPlayer) arg0;
			spinWheelControl.startSpin();

		}


	}
}
