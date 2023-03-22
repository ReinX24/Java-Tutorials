package practiceKeyboardNumpad;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class KeyboardNumpadMain {

	public static void main(String[] args) {

		// Creating a JFrame to hold our program's components
		JFrame mainFrame = new JFrame();
		mainFrame.setTitle("[Keyboard Numpad]");
		mainFrame.setSize(900, 900);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		mainFrame.getContentPane().setBackground(Color.GRAY);
		mainFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

		// Creating a JPanel to add to our JFrame
		JPanel numberPanel = new JPanel();
		numberPanel.setPreferredSize(new Dimension(800, 800)); // new Dimension for FlowLayouts
		numberPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));

		// Creating buttons for our JPanel
		JButton numLock = new JButton("<html> Num <br/> Lock </html>");
		numLock.setPreferredSize(new Dimension(100, 100));
		numberPanel.add(numLock);
		
		JButton slashButton = new JButton("/");
		slashButton.setPreferredSize(new Dimension(100, 100));
		numberPanel.add(slashButton);
		
		JButton asteriskButton = new JButton("*");
		asteriskButton.setPreferredSize(new Dimension(100, 100));
		numberPanel.add(asteriskButton);

		// Adding our JPanel to our JFrame
		mainFrame.add(numberPanel);

		mainFrame.setVisible(true);

	}

}
