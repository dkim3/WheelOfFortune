package TeamProject;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ResultControl {

	// Private data fields for the container and chat client.
		private JPanel container;
		private PlayerClient client;
		private JLabel Winner;
	  private JLabel Player1Score;
	  private JLabel Player2Score;

		// Constructor for the login controller.
		public ResultControl(JPanel container, PlayerClient client)
		{
			this.container = container;
			this.client = client;
		}
		
		 // Handle button clicks.
	  public void actionPerformed(ActionEvent ae)
	  {
	    // Get the name of the button clicked.
	    String command = ae.getActionCommand();


	    if (command.equals("Play Again"))
	    {
	      //Send the user back to the Choose Category Panel
	      CardLayout cardLayout = (CardLayout) container.getLayout();
	      cardLayout.show(container, "4");
	    }
	    else if(command.equals("Exit"))
	    {
	      //Exit the program
	      System.exit(0);
	    }
	  }
	  ResultPanel resultPanel = (ResultPanel)container.getComponent(7);
	  
	  
}
