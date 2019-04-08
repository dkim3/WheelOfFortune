//Shiraj Manandhar

package TeamProject;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

public class InitialPanel extends JPanel {

	private JPanel jp;
	private JLabel jlabel;
	private JButton button1;
	private JButton button2;
	
	
	
	//Constructor
	InitialPanel(CardLayout cl, JPanel container) {

		InitialControl idc = new InitialControl(cl, container);
		setLayout(null);
		button2 = new JButton("Create");
		button2.setBounds(157, 243, 98, 23);
		add(button2);
		
				button1 = new JButton("Login");
				button1.setBounds(157, 174, 98, 23);
				add(button1);
				
						jlabel = new JLabel("Account Information");
						jlabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
						jlabel.setBounds(118, 89, 220, 30);
						add(jlabel);
				
						button1.addActionListener(idc);
		button2.addActionListener(idc);
		return;

	}

	//Create first view
	public static JPanel createView(CardLayout cl, JPanel container) {
		InitialControl idc = new InitialControl(cl, container);
		JPanel jp = new JPanel();
		JPanel inner = new JPanel(new GridLayout(3, 1));

		JLabel jlabel = new JLabel("Choose to login or create login data");
		jp.add(jlabel);

		JButton button1 = new JButton("Login");
		JButton button2 = new JButton("Create");

		button1.addActionListener(idc);
		button2.addActionListener(idc);

		inner.add(jlabel);
		inner.add(button1);
		inner.add(button2);
		jp.add(inner);

		return jp;
	}
}
