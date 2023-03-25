package practiceColorCaterpillar;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class ColorCaterpillarMain {

	public static void main(String[] args) {

		JFrame mainFrame = new JFrame();
		mainFrame.setTitle("[Color Caterpillar]");
		mainFrame.setSize(1000, 1000);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		mainFrame.getContentPane().setBackground(new Color(255, 128, 0));
		mainFrame.setLayout(null);

		JLayeredPane mainLayeredPane = new JLayeredPane();
		mainLayeredPane.setBounds(50, 50, 900, 900);
		mainLayeredPane.setLayout(null);
		mainLayeredPane.setOpaque(true); // need to setOpaue to true to change background color
		mainLayeredPane.setBackground(new Color(0, 128, 128));
		mainLayeredPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

		// Creating JLabels to be added to our JLayeredPane
		JLabel whiteLabel = new JLabel();
		whiteLabel.setBounds(10, 10, 100, 100);
		whiteLabel.setOpaque(true);
		whiteLabel.setBackground(Color.WHITE);

		JLabel yellowLabel = new JLabel();
		yellowLabel.setBounds(20, 20, 100, 100);
		yellowLabel.setOpaque(true);
		yellowLabel.setBackground(Color.YELLOW);

		JLabel magentaLabel = new JLabel();
		magentaLabel.setBounds(30, 30, 100, 100);
		magentaLabel.setOpaque(true);
		magentaLabel.setBackground(Color.MAGENTA);

		JLabel cyanLabel = new JLabel();
		cyanLabel.setBounds(40, 40, 100, 100);
		cyanLabel.setOpaque(true);
		cyanLabel.setBackground(Color.CYAN);

		JLabel redLabel = new JLabel();
		redLabel.setBounds(50, 50, 100, 100);
		redLabel.setOpaque(true);
		redLabel.setBackground(Color.RED);

		JLabel greenLabel = new JLabel();
		greenLabel.setBounds(60, 60, 100, 100);
		greenLabel.setOpaque(true);
		greenLabel.setBackground(Color.GREEN);

		// Adding JLabels to our JLayeredPane
		/*
		 * Add Colors:
		 * Red X
		 * Green X
		 * Blue
		 * Yellow X
		 * Cyan X
		 * Magenta X
		 * White X
		 * Black
		 * Gray
		 * Light Gray
		 * Dark Gray
		 * Orange
		 * Pink
		 * 
		 * */
		mainLayeredPane.add(whiteLabel, Integer.valueOf(0));
		mainLayeredPane.add(yellowLabel, Integer.valueOf(1));
		mainLayeredPane.add(magentaLabel, Integer.valueOf(2));
		mainLayeredPane.add(cyanLabel, Integer.valueOf(3));
		mainLayeredPane.add(redLabel, Integer.valueOf(4));
		mainLayeredPane.add(greenLabel, Integer.valueOf(5)); // you can go beyond 5 components

		mainFrame.add(mainLayeredPane);
		mainFrame.setVisible(true);
	}

}
