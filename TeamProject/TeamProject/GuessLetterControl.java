package TeamProject;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;



public class GuessLetterControl implements ActionListener
{
	//Private data field for storing the container.
	private JPanel container;
	private PlayerClient client;

	// Constructor for the login controller.
	public GuessLetterControl(JPanel container, PlayerClient client)
	{
		this.container = container;
		this.client = client;
	}

	// Handle button clicks.
	public void actionPerformed(ActionEvent ae)
	{
		// Get the name of the button clicked.
		String command = ae.getActionCommand();

		if (command.equals("Animals"))
		{
			//get animals panel
			//      SelectCatgoryPanel selectCatgoryPanel = (SelectCatgoryPanel)container.getComponent(5);
			//      selectCatgoryPanel.setError("");
			//      CardLayout cardLayout = (CardLayout)container.getLayout(5);
			//      cardLayout.show(container, "6");
		}
		else if(command.equals("Brands")) {
			//get animals panel
			//      SelectCatgoryPanel selectCatgoryPanel = (SelectCatgoryPanel)container.getComponent(5);
			//      selectCatgoryPanel.setError("");
			//      CardLayout cardLayout = (CardLayout)container.getLayout(5);
			//      cardLayout.show(container, "6");
		}
		else if(command.equals("Countries")) {
			//get animals panel
			//      SelectCatgoryPanel selectCatgoryPanel = (SelectCatgoryPanel)container.getComponent(5);
			//      selectCatgoryPanel.setError("");
			//        CardLayout cardLayout = (CardLayout)container.getLayout(5);
			//        cardLayout.show(container, "6");
		}
		else if(command.equals("Movies")) {
			//get animals panel
			//      SelectCatgoryPanel selectCatgoryPanel = (SelectCatgoryPanel)container.getComponent(5);
			//      selectCatgoryPanel.setError("");
			//        CardLayout cardLayout = (CardLayout)container.getLayout(5);
			//        cardLayout.show(container, "6");
		}


	}

	public void updateDisplay(GuessLetterData tempGess) {
		GuessLetterPanel guessLetterPanel = (GuessLetterPanel) container.getComponent(2);
		createPanel.setuserName("");
		createPanel.setPassword("");
		createPanel.setverifyPassword("");

		CardLayout cardLayout = (CardLayout)container.getLayout();
		cardLayout.show(container, "2");

	}
}
