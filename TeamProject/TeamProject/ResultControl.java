package TeamProject;

import javax.swing.JPanel;

public class ResultControl {

	// Private data fields for the container and chat client.
		private JPanel container;
		private PlayerClient client;


		// Constructor for the login controller.
		public ResultControl(JPanel container, PlayerClient client)
		{
			this.container = container;
			this.client = client;
		}

}
