package TeamProject;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;

public class GameServer extends AbstractServer
{
	private Database database;
	
	private CategoryData serverCategoryData;
	private GuessLetterData guessLetterData;
	private SwitchPlayer SwitchPlayer;	
	private Integer numCategory =0;	
	
    private ArrayList<ConnectionToClient> clientList;

	//Constructor
	public GameServer(int port) {
		super(port);
        clientList = new ArrayList<ConnectionToClient>();

	}

	public void clientConnected(ConnectionToClient client)
	{
		clientList.add(client);
	}

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
				if (database.addAccount(username, password))
				{
					System.out.println("acc created success");
					arg1.sendToClient("Account Created");
				} else
				{
					System.out.println("erro or same username");
					arg1.sendToClient("Same Username");
					System.out.println("same username/pass");
				}
			} catch (IOException | SQLException e)
			{  e.printStackTrace();}
		}

		//LOGIN
		else if (arg0 instanceof LoginData)
		{
			String username = ((LoginData) arg0).getUsername();
			String password = ((LoginData) arg0).getPassword();
			System.out.println("Login data is: " + username + " " + password);
			try
			{
				if ( database.verifyAccount(username, password))
				{
					arg1.sendToClient("Valid");
				}
				else
				{
					arg1.sendToClient("Invalid");  
				}

			} catch (IOException | SQLException e)
			{e.printStackTrace();}
		}

		else if (arg0 instanceof CategoryData)
		{
			serverCategoryData = (CategoryData) arg0;			
			String category = serverCategoryData.getCategory();			
			serverCategoryData.setWord(database.chooseWord(category));			
			numCategory++;		
			if(numCategory ==2)
			{
				//send the same Data to all clients connected
				for(ConnectionToClient client:clientList){
					try {
						client.sendToClient(serverCategoryData);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				numCategory=0;
			}
			else
				numCategory++;						
		}

		else if (arg0 instanceof GuessLetterData)
		{
			GuessLetterData tempGuessData = (GuessLetterData) arg0;
			//send the same Data to all clients connected
			for(ConnectionToClient client:clientList){
				try {
					client.sendToClient(tempGuessData);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}                  
		}
		else if (arg0 instanceof SwitchPlayer)
		{
			SwitchPlayer = (SwitchPlayer) arg0;
			//server received SwitchPlayer from client and process by switch the player 			
			for(ConnectionToClient client:clientList){
				try {
					client.sendToClient(SwitchPlayer);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		

	}

}


