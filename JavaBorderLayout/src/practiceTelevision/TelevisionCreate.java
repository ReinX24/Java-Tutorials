package practiceTelevision;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TelevisionCreate extends JFrame {

	public TelevisionCreate() {
		this.setTitle("[Television Frame]");
		this.setSize(1000, 1000);
		this.setResizable(false);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.getContentPane().setBackground(Color.BLACK);
		this.setLayout(new BorderLayout(50, 50)); // 4 pixels of spaces between contents (horizontally and vertically)

		// Creating JPanels for our JFrame
		JPanel northPanel = new JPanel();
		JPanel westPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		JPanel eastPanel = new JPanel();
		JPanel southPanel = new JPanel();

		// Setting colors for each of our panels
		northPanel.setBackground(new Color(210, 105, 30));
		westPanel.setBackground(new Color(222, 184, 135));
		centerPanel.setBackground(new Color(255, 248, 220));
		eastPanel.setBackground(new Color(222, 184, 135));
		southPanel.setBackground(new Color(218, 165, 32));

		// Setting dimensions for our JPanels
		northPanel.setPreferredSize(new Dimension(300, 150));
		westPanel.setPreferredSize(new Dimension(100, 200));
		centerPanel.setPreferredSize(new Dimension(600, 200));
		eastPanel.setPreferredSize(new Dimension(100, 200));
		southPanel.setPreferredSize(new Dimension(300, 150));

		// Adding JPanels to our JFrame
		this.add(northPanel, BorderLayout.NORTH);
		this.add(westPanel, BorderLayout.WEST);
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(eastPanel, BorderLayout.EAST);
		this.add(southPanel, BorderLayout.SOUTH);

		// Creating JPanels for the centerPanel, sub panels
		JPanel northSubPanel = new JPanel();
		JPanel westSubPanel = new JPanel();
		JPanel centerSubPanel = new JPanel();
		JPanel eastSubPanel = new JPanel();
		JPanel southSubPanel = new JPanel();

		// Setting colors for each sub panel
		northSubPanel.setBackground(Color.RED);
		westSubPanel.setBackground(Color.DARK_GRAY);
		centerSubPanel.setBackground(Color.GREEN);
		eastSubPanel.setBackground(Color.GRAY);
		southSubPanel.setBackground(Color.BLUE);

		// Setting centerPanel layout to BorderLayout
		centerPanel.setLayout(new BorderLayout(10, 10));

		// Setting sized / dimensions for our sub panels
		// centerPanel is 600 x 200
		northSubPanel.setPreferredSize(new Dimension(200, 190));
		westSubPanel.setPreferredSize(new Dimension(50, 200));
		centerSubPanel.setPreferredSize(new Dimension(80, 200));
		eastSubPanel.setPreferredSize(new Dimension(50, 200));
		southSubPanel.setPreferredSize(new Dimension(200, 190));

		// Adding subPanels to centerPanel
		centerPanel.add(northSubPanel, BorderLayout.NORTH);
		centerPanel.add(westSubPanel, BorderLayout.WEST);
		centerPanel.add(centerSubPanel, BorderLayout.CENTER);
		centerPanel.add(eastSubPanel, BorderLayout.EAST);
		centerPanel.add(southSubPanel, BorderLayout.SOUTH);
		
	}

}
