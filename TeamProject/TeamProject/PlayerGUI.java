//shiraj manandhar

package TeamProject;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class PlayerGUI extends JFrame {
	private JPanel view1; 
	private JPanel view2;
	private JPanel view3;
	private JPanel view4;
	private JPanel view5;
	private JPanel view6;
	private JPanel view7;


	private CardLayout cl = new CardLayout(); 
	private JPanel container = new JPanel(cl);

	public PlayerGUI() {
		//client.setHost("localhost");
		//client.setPort(server.getPort());
		//
		//		try {
		//			//client.openConnection();
		//		} catch (IOException e) {
		//			System.err.println("Refused to connect. Run the ServerGUI first");
		//			e.printStackTrace();
		//		}

		//setting up card layout panel
		container = new JPanel(cl);

		//creating different views
		view1 = new InitialPanel(cl, container);
		view2 = new LoginPanel(cl, container);
		view3 = new CreateAccountPanel(cl, container);
		view4 = new GuessLetterPanel(cl, container);
		view5 = new SpinWheelPanel(cl, container);
		//	view6 = new GuessLetterPanel(cl, container);
		view7 = new ResultPanel(cl, container);

		//adding different views to the card layout container
		container.add(view1, "1");
		container.add(view2, "2");
		container.add(view3, "3");
		container.add(view4,"4" );
		container.add(view5, "5");
		//		container.add(view4, "6");
		container.add(view7,"7");
		// Default: showing the first view
		cl.show(container, "1");


		JFrame window = new JFrame();

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(new JPanel(new BorderLayout()), BorderLayout.CENTER);
		window.add(container,BorderLayout.CENTER);
		window.setResizable(true);
		window.setSize(410, 450);
		this.pack();
		window.setVisible(true);
		window.setTitle("Wheel Of Fortune");
		window.setLocationRelativeTo(null);

	}

	public static void main(String[] args) throws Exception {
		new PlayerGUI();
	}

}
