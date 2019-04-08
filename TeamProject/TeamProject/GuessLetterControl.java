package TeamProject;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;



public class GuessLetterControl implements ActionListener
{
  //Private data field for storing the container.
  private JPanel container;

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
}
