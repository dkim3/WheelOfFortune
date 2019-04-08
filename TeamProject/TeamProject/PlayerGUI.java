package TeamProject;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class PlayerGUI extends JFrame
{
  private PlayerClient clients;
  
  // Constructor that creates the client GUI.
  public PlayerGUI()
  {
    
    // Set the title and default close operation.
    this.setTitle("Client");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    clients = new PlayerClient(); 


    try
    {
      clients.openConnection();
      
    } catch (IOException e)
    {
    	e.printStackTrace();
    }

        
    // Create the card layout container.
    CardLayout cardLayout = new CardLayout();
    JPanel container = new JPanel(cardLayout);
    
    //Create the Controllers next
    //Next, create the Controllers
    InitialControl ic = new InitialControl(container); 
    LoginControl lc = new LoginControl(container, clients); //Probably will want to pass in ChatClient here
    CreateAccountControl cac = new CreateAccountControl(container, clients);
    ContactControl cc = new ContactControl(container);
    GuessLetterControl cc = new GuessLetterControl(container);
    
    
    
    // Create the four views. (need the controller to register with the Panels
    JPanel view1 = new InitialPanel(ic);
    JPanel view2 = new LoginPanel(lc);
    JPanel view3 = new CreateAccountPanel(cac);
    JPanel view4 = new ContactPanel(cc);
//    JPanel view4 = new ContactPanel();


    
    
    // Add the views to the card layout container.
    container.add(view1, "1");
    container.add(view2, "2");
    container.add(view3, "3");
    container.add(view4, "4");
    
    // Show the initial view in the card layout.
    cardLayout.show(container, "1");
    
    // Add the card layout container to the JFrame.
    this.add(container, BorderLayout.CENTER);

    // Show the JFrame.
    this.setSize(550, 400);
    this.setVisible(true);
  }

  // Main function that creates the client GUI when the program is started.
  public static void main(String[] args)
  {
    new PlayerGUI();
  }
}
