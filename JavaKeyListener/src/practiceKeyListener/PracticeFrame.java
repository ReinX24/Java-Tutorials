package practiceKeyListener;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PracticeFrame extends JFrame implements KeyListener {

	JLabel mainLabel;
	ImageIcon mainIcon;

	public PracticeFrame() {
		this.setTitle("[KeyListener Practice]");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		this.getContentPane().setBackground(new Color(0, 128, 128));
		this.addKeyListener(this);

		mainLabel = new JLabel();
		mainLabel.setOpaque(true);
		mainLabel.setBackground(new Color(255, 128, 0));
		mainLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		mainLabel.setBounds(0, 0, 136, 136);

		mainIcon = new ImageIcon("rocketPhoto.png");

		mainLabel.setIcon(mainIcon);

		this.add(mainLabel);
		this.setVisible(true);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {

		switch (arg0.getKeyChar()) {

		case 'a':
			mainLabel.setLocation(mainLabel.getX() - 10, mainLabel.getY());
			break;

		case 'd':
			mainLabel.setLocation(mainLabel.getX() + 10, mainLabel.getY());
			break;

		case 's':
			mainLabel.setLocation(mainLabel.getX(), mainLabel.getY() + 10);
			break;

		case 'w':
			mainLabel.setLocation(mainLabel.getX(), mainLabel.getY() - 10);
			break;

		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		System.out.println("Pressed Keychar: " + arg0.getKeyChar());
		System.out.println("Keycode: " + (int) arg0.getKeyChar());
	}

}
