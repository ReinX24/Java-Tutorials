import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextFieldButton {

	public static void main(String[] args) {

		// Creating JFrame for our program
		JFrame mainFrame = new JFrame();
		mainFrame.setTitle("Java Application");
		mainFrame.setSize(450, 450);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		mainFrame.getContentPane().setBackground(new Color(0, 128, 128));
		mainFrame.setLayout(null);

		// Creating JTextField for our program
		JTextField mainField = new JTextField();
		mainField.setBounds(30, 30, 220, 50);
		mainField.setText("Please Click B");
		mainField.setFont(new Font("Arial", Font.PLAIN, 24));

		// Creating 2 JButtons for our program

		// Click Me! button
		JButton clickMeButton = new JButton("Click Me!");
		clickMeButton.setHorizontalAlignment(JButton.LEFT);
		clickMeButton.setBounds(30, 110, 150, 50);
		clickMeButton.setFont(new Font("Arial", Font.PLAIN, 24));
		clickMeButton.setFocusable(false);
		clickMeButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Button Clicked!");
			}
		});

		// Delete button
		JButton deleteButton = new JButton("Delete");
		deleteButton.setHorizontalAlignment(JButton.LEFT);
		deleteButton.setBounds(30, 180, 150, 50);
		deleteButton.setFont(new Font("Arial", Font.PLAIN, 24));
		deleteButton.setFocusable(false);
		deleteButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Field Cleared!");
				mainField.setText("");
			}

		});

		// Adding our components to our mainFrame
		mainFrame.add(mainField);
		mainFrame.add(clickMeButton);
		mainFrame.add(deleteButton);

		// Setting our mainFrame to be visible
		mainFrame.setVisible(true);

	}

}
