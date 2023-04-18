package practiceSimpleMaze;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MazeFrame extends JFrame {

	// Creating our Action objects
	Action upAction;
	Action downAction;
	Action leftAction;
	Action rightAction;

	// Other components to be added to our frame
	JLabel xLabel;
	JLabel yLabel;
	JLabel mainLabel;

	public MazeFrame() {

		this.setTitle("[Simple Maze Game]");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(0, 128, 128));
		this.setLayout(null);

		mainLabel = new JLabel();
		mainLabel.setOpaque(true);
		mainLabel.setBackground(Color.RED);
		mainLabel.setBounds(0, 0, 50, 50);

		// Finish creating our Action objects
		upAction = new UP_MOVE();
		downAction = new DOWN_MOVE();
		leftAction = new LEFT_MOVE();
		rightAction = new RIGHT_MOVE();

		// Creating and adding key binds to our mainLabel
		mainLabel.getInputMap().put(KeyStroke.getKeyStroke("W"), "UP_MOVE");
		mainLabel.getActionMap().put("UP_MOVE", upAction);

		mainLabel.getInputMap().put(KeyStroke.getKeyStroke("S"), "DOWN_MOVE");
		mainLabel.getActionMap().put("DOWN_MOVE", downAction);

		mainLabel.getInputMap().put(KeyStroke.getKeyStroke("A"), "LEFT_MOVE");
		mainLabel.getActionMap().put("LEFT_MOVE", leftAction);

		mainLabel.getInputMap().put(KeyStroke.getKeyStroke("D"), "RIGHT_MOVE");
		mainLabel.getActionMap().put("RIGHT_MOVE", rightAction);

		// TODO: Add x and y lanes
		xLabel = new JLabel();
		xLabel.setOpaque(true);
		xLabel.setBackground(Color.WHITE);
		xLabel.setBounds(0, 0, 100, 400);

		yLabel = new JLabel();
		yLabel.setOpaque(true);
		yLabel.setBackground(Color.WHITE);
		yLabel.setBounds(100, 300, 400, 100);

		this.add(mainLabel);
		this.add(xLabel);
		this.add(yLabel);
		this.setVisible(true);

	}

	public class UP_MOVE extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			mainLabel.setLocation(mainLabel.getX(), mainLabel.getY() - 10);

			if (mainLabel.getX() > 60 && mainLabel.getY() < 300) {
				JOptionPane.showMessageDialog(null, "[Out Of Bounds!]");
				mainLabel.setLocation(0, 0);
			}
		}

	}

	public class DOWN_MOVE extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			mainLabel.setLocation(mainLabel.getX(), mainLabel.getY() + 10);

			if (mainLabel.getY() > 350) {
				JOptionPane.showMessageDialog(null, "[Out Of Bounds!]");
				mainLabel.setLocation(0, 0);
			}
		}

	}

	public class LEFT_MOVE extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			mainLabel.setLocation(mainLabel.getX() - 10, mainLabel.getY());
		}

	}

	public class RIGHT_MOVE extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			mainLabel.setLocation(mainLabel.getX() + 10, mainLabel.getY());

			if (mainLabel.getX() > 50 && mainLabel.getY() < 300) {
				JOptionPane.showMessageDialog(null, "[Out Of Bounds!]");
				mainLabel.setLocation(0, 0);
			}

		}

	}

}
