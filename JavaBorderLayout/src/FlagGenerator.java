import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlagGenerator {

	public static void main(String[] args) {

		// Program that asks which flag the user wants to generate, it will then
		// generate that flag

		// Creating our mainFrame
		JFrame mainFrame = new JFrame();
		mainFrame.setSize(900, 900);
		mainFrame.setTitle("[Flag Generator]");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		mainFrame.getContentPane().setBackground(new Color(0, 128, 128));
		mainFrame.setVisible(true);
		
		// Settting mainFrame border layout
		mainFrame.setLayout(null);

		// Creating buttons for each flag choices
		JButton germanFlag = new JButton();
		germanFlag.setText("[German Flag]");
		germanFlag.setBounds(25, 400, 250, 100);
		germanFlag.setFocusable(false);
		germanFlag.setHorizontalAlignment(JButton.LEFT);
		germanFlag.setVerticalAlignment(JButton.CENTER);
		germanFlag.setHorizontalTextPosition(JButton.CENTER);
		
		// TODO: Center button text & add other buttons

		mainFrame.add(germanFlag);

	}

}
