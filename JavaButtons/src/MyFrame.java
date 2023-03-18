import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame implements ActionListener { // extends JFrame & implements ActionListener

	JButton buttonOne;

	public MyFrame() {
		this.setVisible(true);
		this.setSize(1000, 1000);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.GRAY);
		this.setResizable(false);
		this.setTitle("[ MyFrame : JFrame ]");
		this.setLayout(null);

		// Creating a button
		buttonOne = new JButton();
		buttonOne.setBounds(300, 400, 400, 200);
		buttonOne.addActionListener(this); // we need this so that the button executes its function

		// Adding button to our JFrame
		this.add(buttonOne);
	}

	// From implementing ActionListener
	@Override
	public void actionPerformed(ActionEvent buttonAction) {
		if (buttonAction.getSource() == buttonOne) {
			System.out.println("[Button Pressed]");
		}
	}

}
