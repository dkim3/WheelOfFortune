//Shiraj Manandhar

package TeamProject;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CreateAccountControl implements ActionListener {
	private CardLayout cl;
	private JPanel container;

	//Constructor
	public CreateAccountControl(CardLayout cl, JPanel container) {
		this.cl = cl;
		this.container = container;
	}

	//Event Handler
	@Override
	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();

		if (command.equals("Create Account")) {
			System.out.println("Create Account button pressed");
		} else if (command.equals("Cancel")) {
			cl.show(container, "1");
		}
	}

}
