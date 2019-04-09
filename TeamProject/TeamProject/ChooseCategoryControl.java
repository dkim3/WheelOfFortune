package TeamProject;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JPanel;



public class ChooseCategoryControl implements ActionListener
{
  //Private data field for storing the container.
  private JPanel container;
	private PlayerClient client;

  
  public ChooseCategoryControl(JPanel container, PlayerClient client)
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
    	CategoryData category = new CategoryData("Animals","");
    	try {
			client.sendToServer(category);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	
    	
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
  
  
  
  
}