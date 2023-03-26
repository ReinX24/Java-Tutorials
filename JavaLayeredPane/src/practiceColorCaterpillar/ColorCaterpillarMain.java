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
		
		JLabel blueLabel = new JLabel();
		blueLabel.setBounds(70, 70, 100, 100);
		blueLabel.setOpaque(true);
		blueLabel.setBackground(Color.BLUE);
		
		JLabel blackLabel = new JLabel();
		blackLabel.setBounds(80, 80, 100, 100);
		blackLabel.setOpaque(true);
		blackLabel.setBackground(Color.BLACK);

		JLabel grayLabel = new JLabel();
		grayLabel.setBounds(90, 90, 100, 100);
		grayLabel.setOpaque(true);
		grayLabel.setBackground(Color.GRAY);
		
		JLabel lightGrayLabel = new JLabel();
		lightGrayLabel.setBounds(100, 100, 100, 100);
		lightGrayLabel.setOpaque(true);
		lightGrayLabel.setBackground(Color.LIGHT_GRAY);
		
		JLabel darkGrayLabel = new JLabel();
		darkGrayLabel.setBounds(110, 110, 100, 100);
		darkGrayLabel.setOpaque(true);
		darkGrayLabel.setBackground(Color.DARK_GRAY);
		
		JLabel orangeLabel = new JLabel();
		orangeLabel.setBounds(120, 120, 100, 100);
		orangeLabel.setOpaque(true);
		orangeLabel.setBackground(Color.ORANGE);

		JLabel pinkLabel = new JLabel();
		pinkLabel.setBounds(130, 130, 100, 100);
		pinkLabel.setOpaque(true);
		pinkLabel.setBackground(Color.PINK);
		
		// Adding JLabels to our JLayeredPane
		/*
		 * Add Colors:
		 * Red X
		 * Green X
		 * Blue X
		 * Yellow X
		 * Cyan X
		 * Magenta X
		 * White X
		 * Black X
		 * Gray X
		 * Light Gray X
 		 * Dark Gray X
		 * Orange X
		 * Pink X
		 * 
		 */
		mainLayeredPane.add(whiteLabel, Integer.valueOf(0));
		mainLayeredPane.add(yellowLabel, Integer.valueOf(1));
		mainLayeredPane.add(magentaLabel, Integer.valueOf(2));
		mainLayeredPane.add(cyanLabel, Integer.valueOf(3));
		mainLayeredPane.add(redLabel, Integer.valueOf(4));
		mainLayeredPane.add(greenLabel, Integer.valueOf(5)); // you can go beyond 5 components
		mainLayeredPane.add(blueLabel, Integer.valueOf(6));
		mainLayeredPane.add(blackLabel, Integer.valueOf(7));
		mainLayeredPane.add(grayLabel, Integer.valueOf(8));
		mainLayeredPane.add(lightGrayLabel, Integer.valueOf(9));
		mainLayeredPane.add(darkGrayLabel, Integer.valueOf(10));
		mainLayeredPane.add(orangeLabel, Integer.valueOf(11));
		mainLayeredPane.add(pinkLabel, Integer.valueOf(12));
		
		mainFrame.add(mainLayeredPane);
		mainFrame.setVisible(true);
	}

}
