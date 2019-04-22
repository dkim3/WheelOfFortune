package TeamProject;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ResultControl {

	// Private data fields for the container and chat client.
		private JPanel container;
	  private JLabel Player1Score;
	  private JLabel Player2Score;
	  private JLabel TopLabel;
	  private PlayerClient client;

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
	  
	  public void winner(GuessData gld) {
	   Player1Score.setText(Integer.toString(gld.getScore())); 
	   Player2Score.setText(Integer.toString(gld.getScore_2()));
	   TopLabel.setText("You are the Winner!");
	  }
	  
	  public void loser(GuessData gld) {
	     Player1Score.setText(Integer.toString(gld.getScore_2())); 
	     Player2Score.setText(Integer.toString(gld.getScore()));
	     TopLabel.setText("You are the Loser!");
	    }
}
