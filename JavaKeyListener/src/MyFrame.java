import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MyFrame extends JFrame implements KeyListener {

	JLabel mainLabel;

	public MyFrame() {
		this.setTitle("[Java KeyListener]");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(0, 128, 128));
		this.setLayout(null);
		this.addKeyListener(this);

		mainLabel = new JLabel();
		mainLabel.setBounds(0, 0, 100, 100);
		mainLabel.setOpaque(true);
		mainLabel.setBackground(new Color(255, 128, 0));

		this.add(mainLabel);
		this.setVisible(true);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// keyPressed : Invoked when a physical key is pressed down. Uses KeyCode,
		// returns an int

		switch (arg0.getKeyChar()) {

		case 'a': // move to the left
			mainLabel.setLocation(mainLabel.getX() - 10, mainLabel.getY());
			break;

		case 'w': // move to the north
			mainLabel.setLocation(mainLabel.getX(), mainLabel.getY() - 10);
			break;

		case 'd': // move to the right
			mainLabel.setLocation(mainLabel.getX() + 10, mainLabel.getY());
			break;

		case 's': // move to the south
			mainLabel.setLocation(mainLabel.getX(), mainLabel.getY() + 10);

		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// keyReleased : Called whenever a button is released
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// keyTyped : Invoked when a key is typed. Uses KeyChar, returns a char
		System.out.println("You released key char: " + arg0.getKeyChar()); // gets the character itself
		System.out.println("You released key code: " + (int) arg0.getKeyChar()); // gets the code of that character
		// Instead of using getKeyCode which only returns 0 (I don't know why), we
		// instead convert the char into an integer which basically does the same thing
	}

}
