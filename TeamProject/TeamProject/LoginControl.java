//Shiraj Manandhar

package TeamProject;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class LoginControl implements ActionListener {
	private CardLayout cl;
	private JPanel container;
//	private ChatClient client;

	//Constructor
	public LoginControl(CardLayout cl, JPanel container) {
		this.cl = cl;
		this.container = container;
//		this.client = client;
	}

	//Event Handler
	@Override
	public void actionPerformed(ActionEvent ae) {

		String command = ae.getActionCommand();

		
		if (command.equals("Submit")) {
		

				System.out.println("Submit button pressed");
				
			

					
					
		}
		else if (command.equals("Cancel")) {
			

			cl.show(container, "1");
			
	

				
				
	}

	}
}
