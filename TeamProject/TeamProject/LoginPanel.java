//Shiraj Manandhar

package TeamProject;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import java.awt.*;

public class LoginPanel extends JPanel {
	private JTextField Uernametxt;
	private JTextField Passwordtxt;
	  private JLabel errorLabel;


	// Getter for the text in the verifyPassword field.
	public void setuserName(String userName)
	{
		Uernametxt.setText(userName);
	}
	public void setPassword(String passoword)
	{
		Passwordtxt.setText(passoword);
	}

	// Getter for the text in the username field.
	public String getUsername()
	{
		return Uernametxt.getText();
	}

	// Getter for the text in the password field.
	public String getPassword()
	{
		return Passwordtxt.getText();
	}
	
	 public void setError(String error)
	  {
	    errorLabel.setText(error);
	  }

	
	//Constructor
	public LoginPanel(LoginControl lc) {
		setLayout(null);

		JLabel TopLable = new JLabel("Enter Username/Password");
		TopLable.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		TopLable.setBounds(71, 34, 259, 29);
		add(TopLable);

		JLabel Username = new JLabel("Username:");
		Username.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		Username.setBounds(51, 132, 110, 14);
		add(Username);

		Uernametxt = new JTextField();
		Uernametxt.setBounds(123, 130, 185, 20);
		add(Uernametxt);
		Uernametxt.setColumns(10);

		JLabel Password = new JLabel("Password:");
		Password.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		Password.setBounds(51, 177, 71, 14);
		add(Password);

		Passwordtxt = new JTextField();
		Passwordtxt.setBounds(123, 175, 185, 20);
		add(Passwordtxt);
		Passwordtxt.setColumns(10);

		JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(lc);
		submitButton.setBounds(51, 271, 89, 23);
		add(submitButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(lc);
		cancelButton.setBounds(219, 271, 89, 23);
		add(cancelButton);



	}

}
