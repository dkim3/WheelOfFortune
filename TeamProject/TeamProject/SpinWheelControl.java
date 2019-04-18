package TeamProject;

import javax.swing.JPanel;

public class SpinWheelControl {
  // Private data fields for the container and chat client.
    private JPanel container;
    private PlayerClient client;


    // Constructor for the login controller.
    public SpinWheelControl(JPanel container, PlayerClient client)
    {
      this.container = container;
      this.client = client;
    }


    public void switchPlayer(SwitchPlayer tempSwitch) {
      
      //if it's my turn
      if( tempSwitch.getCurrentPlayer() == client)
      {
        
      }
      else //if it's opponents turn
      {
        
      }
      
    }
    
    public void startSpin() {
      
    }


}
