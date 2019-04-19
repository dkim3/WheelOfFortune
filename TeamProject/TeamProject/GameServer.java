package TeamProject;

import java.awt.Color;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;

public class GameServer extends AbstractServer
{
  private Database database;
  private String[] category;
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
  }
  
  public GameServer(int port) {
    super(port);
    clientList = new ArrayList<ConnectionToClient>();
  }

  protected void handleMessageFromClient(Object arg0, ConnectionToClient arg1)
  {
    // CREATE ACCOUNT
    if (arg0 instanceof CreateAccountData)
    {
      try
      {
        String username = ((CreateAccountData) arg0).getUsername();
        String password = ((CreateAccountData) arg0).getPassword();
        if (database.addAccount(username, password))
        {
          arg1.sendToClient("Account Created");
        } else
        {
          arg1.sendToClient("Same Username");
        }
      } catch (IOException | SQLException e)
      {
        e.printStackTrace();
      }
    }

    // LOGIN
    else if (arg0 instanceof LoginData)
    {
      String username = ((LoginData) arg0).getUsername();
      String password = ((LoginData) arg0).getPassword();
      System.out.println("Login data is: " + username + " " + password);
      try
      {
        if (database.verifyAccount(username, password))
        {
          arg1.sendToClient("Valid");
        } else
        {
          arg1.sendToClient("Invalid");
        }


      } catch (IOException | SQLException e)
      {
        e.printStackTrace();
      }
    }
    else if (arg0 instanceof CategoryData)
    {
      serverCategoryData = (CategoryData) arg0;
      category[numCategory] = serverCategoryData.getCategory();
      numCategory++;

      if (numCategory == 2)
      {
        int rand = (int) (Math.random() * ((1 - 0) + 1)) + 0; // choose number between 0 and 1
        String choosenCategory = category[rand]; // choose random category between 2 players

        try
        {
          serverCategoryData.setWord(database.chooseWord(choosenCategory));
        } catch (SQLException e1)
        {
          // TODO Auto-generated catch block
          e1.printStackTrace();
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

    /*if (this.isListening())
    {
      log.append("Server not Listening\n");
      status.setText("Not Connected");
      status.setForeground(Color.RED);
    }*/
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

  //Hook method = invoked by underlined system
  public void serverClosed()
  {
    log.append("Server and all current clients are closed - Press Listen to Restart\n");
    status.setText("Close");
    status.setForeground(Color.red);
  }


}
