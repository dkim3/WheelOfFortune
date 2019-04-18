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




	//Constructor
	public PlayerClient() {super("localhost",8300);}
	public PlayerClient(String host, int port) {super(host,port);}

	public InitialControl getInitialControl() {return InitialControl;}
	public void setInitialControl(InitialControl initialControl) {
		InitialControl = initialControl;}
	
	public LoginControl getLoginControl() {return loginControl;}
	public void setLoginControl(LoginControl loginControl) {
		this.loginControl = loginControl;}
	
	public CreateAccountControl getCreateAccountControl() {return createAccountControl;	}
	public void setCreateAccountControl(CreateAccountControl createAccountControl) {
		this.createAccountControl = createAccountControl;}
	
	public GuessLetterControl getGuessLetterControl() {return guessLetterControl;}
	public void setGuessLetterControl(GuessLetterControl guessLetterControl) {
		this.guessLetterControl = guessLetterControl;}
	
	public SpinWheelControl getSpinWheelControl() {return spinWheelControl;}
	public void setSpinWheelControl(SpinWheelControl spinWheelControl) {
		this.spinWheelControl = spinWheelControl;}
	
	public ChooseCategoryControl getChooseCategoryControl() {return chooseCategoryControl;}
	public void setChooseCategoryControl(ChooseCategoryControl chooseCategoryControl) {
		this.chooseCategoryControl = chooseCategoryControl;}
	
	public ResultControl getResultControl() {return resultControl;}
	public void setResultControl( ResultControl resultControl ) {
		this.resultControl = resultControl;}
	
	

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
		
		else if(arg0 instanceof CategoryData) {
			CategoryData tempcategory = (CategoryData) arg0;
			spinWheelControl
		}
		//"WORD DATA" FROM SERVER
		else if (arg0 instanceof GuessLetterData)
		{	
			GuessLetterData tempGuessData = (GuessLetterData) arg0;
			if (tempGuessData.getLetterLeft() == 0)
			{
				resultControl.display(tempGuessData);
			}
			  //when player receive GuessLetterData which mean he get it wrong
			guessLetterControl.waitScreen(tempGuessData);
			guessLetterControl.updateDisplay(tempGuessData); 
		}
		//HANDLE SWITCH PLAYER REQUEST FROM SERVER
		else if (arg0 instanceof SwitchPlayer)
		{
			SwitchPlayer tempSwitch = (SwitchPlayer) arg0;
			spinWheelControl.switchPlayer(tempSwitch);
		}


	}
}
