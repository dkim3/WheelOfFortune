package TeamProject;

import java.awt.Color;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


import javax.swing.JLabel;
import javax.swing.JTextArea;
import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;

import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class GameServer extends AbstractServer
{
	private Database database;
	private ArrayList<String> category;
	private CategoryData serverCategoryData;
	private GuessLetterData guessLetterData;
	private SwitchPlayer SwitchPlayer;
	private Integer numCategory = 0;
	private ArrayList<ConnectionToClient> clientList;

	private JTextArea log;
	private JLabel status;

	//Constructor
	public GameServer() {
		super(8300);
		clientList = new ArrayList<ConnectionToClient>();
		category = new ArrayList<String>();


	}

	public GameServer(int port) {
		super(port);
		clientList = new ArrayList<ConnectionToClient>();
		category = new ArrayList<String>();
	}

	protected void handleMessageFromClient(Object arg0, ConnectionToClient arg1)
	{
		System.out.println("inside server" + arg0.toString());

		// CREATE ACCOUNT
		if (arg0 instanceof LoginData)
		{
			LoginData loginData = (LoginData)arg0;
			String userPassPair = loginData.getUsername() + '/' + loginData.getPassword();

			try {
				if(   database.verifyAccount(loginData.getUsername(), loginData.getPassword())  )	
				{
					arg1.sendToClient(loginData);
				}
				else
				{
					System.out.println("Fail to Login");
					loginData.setUsername("");
					try
					{
						arg1.sendToClient(loginData);
					} catch (IOException e)
					{e.printStackTrace();}
				}
			} catch (SQLException | IOException e) {
				e.printStackTrace();}

		}
		else if (arg0 instanceof CreateAccountData)
		{
			CreateAccountData accountData = (CreateAccountData) arg0;
			System.out.println("Username/Password for account data"
					+ accountData.getUsername() + " " + accountData.getPassword());
			try {
				if( database.addAccount(accountData.getUsername(), accountData.getPassword())  )
				{
					try
					{
						arg1.sendToClient(accountData);

					} catch (IOException e)
					{e.printStackTrace();}

				}
				else
				{
					System.out.println("Fail to add ");
					accountData.setUsername("");
					try
					{
						arg1.sendToClient(accountData);
					} catch (IOException e)
					{	e.printStackTrace();}

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (arg0 instanceof CategoryData)
		{
			System.out.println("inside CategoryData-server ");

			serverCategoryData = (CategoryData) arg0;

			category.add(serverCategoryData.getCategory());

			numCategory++;


			if (numCategory%2 ==0)
			{

				System.out.println("inside if numCategory =2");

				int random = (int)(Math.random() * (  (numCategory - numCategory-2) + 1) + numCategory-2 ); // choose number between 0 and 1
				String choosenCategory = category.get(random); // choose random category between 2 players
				numCategory=0;
				String wordToGuess = "";
				try
				{
					wordToGuess = database.chooseWord(choosenCategory);
					String a[] = wordToGuess.split("/");

					wordToGuess = a[0];
					serverCategoryData.setWord(wordToGuess);
				} catch (SQLException e1)
				{	e1.printStackTrace(); }

				GuessLetterData tempGuessData =  new GuessLetterData();
				tempGuessData.setwordToGuess(wordToGuess);
				
				SwitchPlayer tempswitchPlayer =  new SwitchPlayer();
//				guessLetterData.setWordToGuess(wordToGuess);
				
				for (ConnectionToClient client : clientList)
				{
					try
					{
						if (client.equals(arg1))
						{//for some reason the socket disappear if send guessData to client
							client.sendToClient(serverCategoryData);
						}
						else
							client.sendToClient(tempGuessData);
					} catch (IOException e)
					{e.printStackTrace();	}

				}
			}
		}
		else if (arg0 instanceof GuessLetterData)
		{
			GuessLetterData tempGuessData = (GuessLetterData) arg0;
			// send the same Data to all clients connected
			for (ConnectionToClient client : clientList)
			{
				if (!client.equals(arg1))
				{
					try
					{
						client.sendToClient(tempGuessData);
					} catch (IOException e)
					{
						e.printStackTrace();
					}
				}
			}
		} else if (arg0 instanceof SwitchPlayer)
		{
			System.out.println("going to send switch player to client");
			SwitchPlayer = (SwitchPlayer) arg0;
			// server received SwitchPlayer from client and process by switch the player
			for (ConnectionToClient client : clientList)
			{
				try
				{
					client.sendToClient(SwitchPlayer);
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}



	public void setLog(JTextArea log)
	{
		this.log = log;
	}

	public JTextArea getLog()
	{
		return log;
	}

	public void setStatus(JLabel status)
	{
		this.status = status;
	}

	public JLabel getStatus()
	{
		return status;
	}
	public void clientConnected(ConnectionToClient client)
	{
		clientList.add(client);
		log.append("Client "+ client.getId() +" Connected\n");
		try {
			client.sendToClient("username: Client-" + client.getId());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void listeningException(Throwable exception) 
	{
		//Display info about the exception
		System.out.println("Listening Exception:" + exception);
		exception.printStackTrace();
		System.out.println(exception.getMessage());


	}

	//Hook method = invoked by underlined system
	//run when an exception occurs while the Server is listening for clients to connect
	public void serverStarted() 
	{
		log.setText("Server Started\n");
		status.setText("Listening");
		status.setForeground(Color.green);
	}

	//Hook method = invoked by underlined system
	public void serverStopped()
	{
		log.append("Server Stopped Accepting New Clients - Press Listen to Start Accepting New Clients\n");
		status.setText("Stopped");
		status.setForeground(Color.red);
	}

	public Database getDatabase() {
		return database;
	}

	public void setDatabase(Database database) {
		this.database = database;
	}

	public ArrayList<String> getCategory() {
		return category;
	}

	public void setCategory(ArrayList<String> category) {
		this.category = category;
	}

	public CategoryData getServerCategoryData() {
		return serverCategoryData;
	}

	public void setServerCategoryData(CategoryData serverCategoryData) {
		this.serverCategoryData = serverCategoryData;
	}

	public GuessLetterData getGuessLetterData() {
		return guessLetterData;
	}

	public void setGuessLetterData(GuessLetterData guessLetterData) {
		this.guessLetterData = guessLetterData;
	}

	public SwitchPlayer getSwitchPlayer() {
		return SwitchPlayer;
	}

	public void setSwitchPlayer(SwitchPlayer switchPlayer) {
		SwitchPlayer = switchPlayer;
	}

	public Integer getNumCategory() {
		return numCategory;
	}

	public void setNumCategory(Integer numCategory) {
		this.numCategory = numCategory;
	}

	public ArrayList<ConnectionToClient> getClientList() {
		return clientList;
	}

	public void setClientList(ArrayList<ConnectionToClient> clientList) {
		this.clientList = clientList;
	}

	//Hook method = invoked by underlined system
	public void serverClosed()
	{
		log.append("Server and all current clients are closed - Press Listen to Restart\n");
		status.setText("Close");
		status.setForeground(Color.red);
	}


}
