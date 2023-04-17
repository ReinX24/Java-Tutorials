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
		mainLabel.setBounds(100, 100, 50, 50);

		// Finish creating our Action objects
		upAction = new UP_MOVE();
		downAction = new DOWN_MOVE();
		leftAction = new LEFT_MOVE();
		rightAction = new RIGHT_MOVE();

		// Creating and adding key binds to our mainLabel
		mainLabel.getInputMap().put(KeyStroke.getKeyStroke("W"), "UP_MOVE");
		mainLabel.getActionMap().put("UP_MOVE", upAction);
		
		// TODO: Add other key binds (down, left, right)
		
		// TODO: Add x and y lanes
		
		this.add(mainLabel);
		this.setVisible(true);

	}

	public class UP_MOVE extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			mainLabel.setLocation(mainLabel.getX(), mainLabel.getY() - 10);
		}

	}

	public class DOWN_MOVE extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			mainLabel.setLocation(mainLabel.getX(), mainLabel.getY() + 10);
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
		}

	}

}
