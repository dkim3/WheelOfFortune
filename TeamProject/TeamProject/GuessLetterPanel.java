package TeamProject;

import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;

public class GuessLetterPanel extends JPanel
{
	
	public GuessLetterPanel(CardLayout cl, JPanel container) {
		setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(225, 5, 0, 0);
		add(label);
		
		JLabel lblSelectACategory = new JLabel("Select A Category To Begin");
		lblSelectACategory.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		lblSelectACategory.setBounds(92, 16, 255, 29);
		add(lblSelectACategory);
		
		JButton btnAnimals = new JButton("Animals");
		btnAnimals.setFont(new Font("Berlin Sans FB", Font.PLAIN, 11));
		btnAnimals.setBounds(164, 75, 89, 23);
		add(btnAnimals);
		
		JButton btnMovies = new JButton("Movies");
		btnMovies.setFont(new Font("Berlin Sans FB", Font.PLAIN, 11));
		btnMovies.setBounds(164, 123, 89, 23);
		add(btnMovies);
		
		JButton btnBrand = new JButton("Brand");
		btnBrand.setFont(new Font("Berlin Sans FB", Font.PLAIN, 11));
		btnBrand.setBounds(164, 173, 89, 23);
		add(btnBrand);
		
		JButton btnCountries = new JButton("Countries");
		btnCountries.setFont(new Font("Berlin Sans FB", Font.PLAIN, 11));
		btnCountries.setBounds(164, 224, 89, 23);
		add(btnCountries);
		
	
  
}
}

