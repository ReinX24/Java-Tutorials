import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Game {

	// Creating Action objects
	Action upAction;
	Action downAction;
	Action leftAction;
	Action rightAction;

	// Creating our JFrame
	JFrame mainFrame;
	JLabel mainLabel;

	public Game() {

		mainFrame = new JFrame("Key Binding Demo");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(500, 500);
		mainFrame.setLayout(null);

		mainLabel = new JLabel();
		mainLabel.setOpaque(true);
		mainLabel.setBackground(Color.RED);
		mainLabel.setBounds(100, 100, 100, 100);

		// Finish creating our Action objects
		upAction = new UpAction();
		downAction = new DownAction();
		leftAction = new LeftAction();
		rightAction = new RightAction();

		// Setting keystrokes
		mainLabel.getInputMap().put(KeyStroke.getKeyStroke("W"), "upAction"); // Keyboard char, Key Action name
		mainLabel.getActionMap().put("upAction", upAction); // Key Action name, Action object

		mainLabel.getInputMap().put(KeyStroke.getKeyStroke("A"), "downAction");
		mainLabel.getActionMap().put("downAction", downAction);

		mainLabel.getInputMap().put(KeyStroke.getKeyStroke("S"), "leftAction");
		mainLabel.getActionMap().put("leftAction", leftAction);

		mainLabel.getInputMap().put(KeyStroke.getKeyStroke("D"), "rightAction");
		mainLabel.getActionMap().put("rightAction", rightAction);

		mainFrame.add(mainLabel);
		mainFrame.setVisible(true);

	}

	public class UpAction extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			mainLabel.setLocation(mainLabel.getX(), mainLabel.getY() - 10);
		}

	}

	public class DownAction extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			mainLabel.setLocation(mainLabel.getX(), mainLabel.getY() + 10);
		}

	}

	public class LeftAction extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			mainLabel.setLocation(mainLabel.getX() - 10, mainLabel.getY());
		}

	}

	public class RightAction extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			mainLabel.setLocation(mainLabel.getX() + 10, mainLabel.getY());
		}

	}

}
