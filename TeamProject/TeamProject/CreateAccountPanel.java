//Shiraj Manandhar

package TeamProject;

import javax.swing.*;
import java.awt.*;

public class CreateAccountPanel extends JPanel {
	private JTextField textFieldUsername;
	private JTextField textFieldPassword;
	private JTextField textFieldConfirmP;


	//Constructor
	public CreateAccountPanel(CardLayout cl, JPanel container) {
		CreateAccountControl alu = new CreateAccountControl(cl, container);
		setLayout(null);
		
		JLabel lblEnterUsernamepassword = new JLabel("Enter Username/Password");
		lblEnterUsernamepassword.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		lblEnterUsernamepassword.setBounds(93, 50, 234, 23);
		add(lblEnterUsernamepassword);
		
		JLabel lblUsername = new JLabel("Username: ");
		lblUsername.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblUsername.setBounds(93, 135, 85, 14);
		add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblPassword.setBounds(93, 171, 69, 14);
		add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password: ");
		lblConfirmPassword.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblConfirmPassword.setBounds(51, 209, 132, 14);
		add(lblConfirmPassword);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(179, 133, 154, 20);
		add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(179, 169, 154, 20);
		add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		textFieldConfirmP = new JTextField();
		textFieldConfirmP.setBounds(179, 207, 154, 20);
		add(textFieldConfirmP);
		textFieldConfirmP.setColumns(10);
		
		JButton CreateAccount = new JButton("Create Account");
		CreateAccount.addActionListener(alu);
		
		CreateAccount.setBounds(39, 298, 123, 23);
		add(CreateAccount);
		
		JButton CancelButton = new JButton("Cancel");
CancelButton.addActionListener(alu);
		CancelButton.setBounds(223, 298, 123, 23);
		add(CancelButton);

		
		
	}

}

