package practiceFlagGenerator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CreateGermanFlag extends JFrame {

	public CreateGermanFlag() {
		this.setTitle("[German Flag]");
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		this.setBackground(Color.GRAY);
		this.setLayout(new BorderLayout());

		// Creating 3 JPanels for our German Flag
		JPanel topPanel = new JPanel();
		JPanel middlePanel = new JPanel();
		JPanel bottomPanel = new JPanel();

		topPanel.setPreferredSize(new Dimension(600, 200));
		middlePanel.setPreferredSize(new Dimension(600, 200));
		bottomPanel.setPreferredSize(new Dimension(600, 200));

		topPanel.setBackground(Color.BLACK);
		middlePanel.setBackground(Color.RED);
		bottomPanel.setBackground(Color.YELLOW);

		this.add(topPanel, BorderLayout.NORTH);
		this.add(middlePanel, BorderLayout.CENTER);
		this.add(bottomPanel, BorderLayout.SOUTH);

	}

}
