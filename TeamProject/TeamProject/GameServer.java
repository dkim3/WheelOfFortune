package TeamProject;

import java.io.IOException;
import java.util.ArrayList;

import lab7out.CreateAccountData;
import lab7out.LoginData;
import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;

public class GameServer extends AbstractServer
{
	private PlayerDB PlayerDB;
	private CategoryData serverCategoryData;
	private GuessLetterData guessLetterData;
	private SwitchPlayer SwitchPlayer;


	//Constructor
	public GameServer(int port) {super(port);}

	protected void handleMessageFromClient(Object arg0, ConnectionToClient arg1)
	{
		//CREATE ACCOUNT
		if (arg0 instanceof CreateAccountData)
		{
			System.out.println("chatserver createdata");
			try
			{
				System.out.println("trying to create acc");
				String username = ((CreateAccountData) arg0).getUsername();
				String password = ((CreateAccountData) arg0).getPassword();
				if (database.executeDML("insert into User values('" + username + "', aes_encrypt('" + password + "','key'));"))
				{
					System.out.println("acc created success");
					arg1.sendToClient("Account Created");
				} else
				{
					System.out.println("erro or same username");

					arg1.sendToClient("Same Username");
					System.out.println("same username/pass");
				}
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		//LOGIN
		else if (arg0 instanceof LoginData)
		{
			String username = ((LoginData) arg0).getUsername();
			String password = ((LoginData) arg0).getPassword();
			System.out.println("Login data is: " + username + " " + password);

			try
			{   
				ArrayList <String> query_result = new ArrayList<String>();
				query_result = database.query("Select * FROM user WHERE username = '" + username + "' and aes_decrypt(password,'key') = '" + password + "';");

				if (!query_result.isEmpty())
				{
					arg1.sendToClient("Valid");
				}
				else
				{
					arg1.sendToClient("Invalid");  
				}

			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		else if (arg0 instanceof CategoryData)
		{
			CategoryData tempCate = (CategoryData) arg0;
			serverCategoryData.setCategoryData(tempCate);  //client sent selected category
			String word = serverCategoryData.getWord();         //server decide what category & word to use
			arg1.sendToClient(word);                            //server sends chosen word to client
		}

		else if (arg0 instanceof GuessLetterData)
		{
			GuessLetterData tempGuess = (GuessLetterData) arg0;
			guessLetterData	 =tempGuess;
			arg1.sendToClient(tempGuess);                   //server send the processed GuessLetterData back to client
		}
		else if (arg0 instanceof SwitchPlayer)
		{
			SwitchPlayer.setSwitchPlayer (SwitchPlayer);        //server received SwitchPlayer from client and process by switch the player 
			arg1.sendToClient(SwitchPlayer);                    //server send the processed SwitchPlayer back to client
		}


	}

}


