package practiceMoveLocationKeyListener;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MoveLocationFrame extends JFrame implements KeyListener {

	JLabel mainLabel;
	ImageIcon mainIcon;

	JLabel destinationLabel;

	public MoveLocationFrame() {
		this.setTitle("[Move Location KeyListener]");
		this.setSize(1000, 1000);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(0, 128, 128));
		this.setLayout(null);

		mainLabel = new JLabel();
		mainLabel.setOpaque(true);
		mainLabel.setBackground(new Color(255, 128, 0));
		mainLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		mainLabel.setBounds(0, 0, 136, 136);

		mainIcon = new ImageIcon("rocketPhoto.png");
		mainLabel.setIcon(mainIcon);

		destinationLabel = new JLabel();
		destinationLabel.setOpaque(true);
		destinationLabel.setBackground(Color.WHITE);
		destinationLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		destinationLabel.setBounds(500, 500, 200, 200);

		this.add(mainLabel);
		this.add(destinationLabel);

		this.addKeyListener(this);
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

		case 'w':
			mainLabel.setLocation(mainLabel.getX(), mainLabel.getY() - 10);
			break;

		case 's':
			mainLabel.setLocation(mainLabel.getX(), mainLabel.getY() + 10);
			break;

		case 'q':
			int userChoice = JOptionPane.showConfirmDialog(null,
					"Land?\n\n[Coordinates]\n" + "X: " + mainLabel.getX() + "\nY: " + mainLabel.getY()
							+ "\n\n[Target Coordinates]" + "\nX: " + destinationLabel.getX() + "\nY: "
							+ destinationLabel.getY());

			switch (userChoice) {

			case JOptionPane.YES_OPTION:
				if (mainLabel.getX() >= 500 && mainLabel.getY() >= 500) {
					JOptionPane.showMessageDialog(null, "Arrived at destination!");
				} else {
					JOptionPane.showMessageDialog(null, "Not at destination!");
				}
				break;

			case JOptionPane.NO_OPTION:
				JOptionPane.showMessageDialog(null, "Continuing search...");
				break;

			case JOptionPane.CANCEL_OPTION:
				JOptionPane.showMessageDialog(null, "Landing cancelled!");
				break;

			}

			break;

		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

}
