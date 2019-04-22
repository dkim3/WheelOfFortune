package TeamProject;

import java.awt.Color;
import java.io.IOException;
import java.net.ServerSocket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

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
	private GuessData GuessData;
	private SwitchPlayer SwitchPlayer;
	private Integer numCategory = 0;
	
	private ArrayList<ConnectionToClient> clientList;
//	private ArrayList<ServerSocket> socketList;

	private SwitchPlayer players;
//	private ServerSocket listener;


	private JTextArea log;
	private JLabel status;

	//Constructor
	public GameServer() throws IOException {
		super(8300);
		clientList = new ArrayList<ConnectionToClient>();
		category = new ArrayList<String>();
//		listener = new ServerSocket(8300);
//		socketList = new ArrayList<ServerSocket>();

	}

	public GameServer(int port) throws IOException {
		super(port);
		clientList = new ArrayList<ConnectionToClient>();
		category = new ArrayList<String>();
//		listener = new ServerSocket(8300);
//		socketList = new ArrayList<ServerSocket>();


	}

	protected void handleMessageFromClient(Object arg0, ConnectionToClient arg1)
	{
		System.out.println("inside server" + arg0.toString());
	    Thread[] clientThreadList = getClientConnections();
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
//				numCategory=0;
				String wordToGuess = "";
				try
				{
					wordToGuess = database.chooseWord(choosenCategory);
					String a[] = wordToGuess.split("/");

					wordToGuess = a[0];
					serverCategoryData.setWord(wordToGuess);
				} catch (SQLException e1)
				{	e1.printStackTrace(); }

				GuessData tempGuessData =  new GuessData();
				tempGuessData.setwordToGuess(wordToGuess);
				
				GuessData tempswitchPlayer =  new GuessData();
//				GuessData.setWordToGuess(wordToGuess);
				tempswitchPlayer.setWordToGuess(wordToGuess);
//				TempData tempData =  new TempData();

				int clientlistsize = clientList.size();
				for(int i = clientlistsize-2; i< clientlistsize; i++)
				{
//					ConnectionToClient tempclient = new ConnectionToClient(clientList.get(i).getThreadGroup(),clientList.get(i).);
//					tempclient = clientList.get(i);
					ConnectionToClient tempclient = clientList.get(i);
	

					try
					{
						if (tempclient.equals(arg1))
						{
							//for some reason the socket disappear if send guessData to client
							tempclient.sendToClient(serverCategoryData);
						}
						else {
							Thread c = new Thread (clientThreadList[i]);
							
					        ((ConnectionToClient)clientThreadList[i]).sendToClient(tempswitchPlayer);


						}
					} catch (IOException e)
					{e.printStackTrace();	}
				}
			}
		}
		else if (arg0 instanceof GuessData)
		{
			GuessData tempGuessData = (GuessData) arg0;
			// send the same Data to all clients connected
			
			
			SwitchPlayer tempswitchPlayer =  new SwitchPlayer();
//			GuessData.setWordToGuess(wordToGuess);
			tempswitchPlayer.setWordToGuess(tempGuessData.getWordToGuess());
			tempswitchPlayer.setChosenLetter(tempGuessData.getChosenLetter());
			tempswitchPlayer.setLetterLeft(tempGuessData.getLetterLeft());
			tempswitchPlayer.setPrizeMoney(tempGuessData.getPrizeMoney());
			tempswitchPlayer.setScore(tempGuessData.getScore());
			tempswitchPlayer.setScore_2(tempGuessData.getScore());

			
			int clientlistsize = clientThreadList.length;

			for(int i = clientlistsize-2; i< clientlistsize; i++)
			{
				ConnectionToClient c = ((ConnectionToClient)clientThreadList[i]);
				try
				{
					if (!c.equals(arg1))
					{
				        c.sendToClient(tempswitchPlayer);
					}
				} catch (IOException e)
				{e.printStackTrace();	}
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
//		try {
//			socketList.addAll((Collection<? extends ServerSocket>) listener.accept());
//			
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
        
		clientList.add(client);

//		
//		Object portNum = tempclient.getInfo("blocker");
//		
//		tempclient_2.setInfo("Socket", tempclient.getInfo("Socket"));

		
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

	public GuessData getGuessData() {
		return GuessData;
	}

	public void setGuessData(GuessData GuessData) {
		this.GuessData = GuessData;
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
