package practiceJavaKeyBindings;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class KeyBindingsFrame extends JFrame {

	// Creating Action objects
	Action upAction;
	Action downAction;
	Action leftAction;
	Action rightAction;

	// Creating a JLabel for our JFrame
	JLabel mainLabel;

	public KeyBindingsFrame() {

		this.setTitle("[Key Bindings Practice]");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(0, 128, 128));
		this.setLayout(null);

		mainLabel = new JLabel();
		mainLabel.setOpaque(true);
		mainLabel.setBackground(new Color(255, 128, 0));
		mainLabel.setBounds(200, 150, 100, 100);

		// Finish creating our Action objects
		upAction = new upAction();
		downAction = new downAction();
		leftAction = new leftAction();
		rightAction = new rightAction();

		mainLabel.getInputMap().put(KeyStroke.getKeyStroke("UP"), "upAction");
		mainLabel.getActionMap().put("upAction", upAction);

		mainLabel.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "downAction");
		mainLabel.getActionMap().put("downAction", downAction);

		mainLabel.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "leftAction");
		mainLabel.getActionMap().put("leftAction", leftAction);

		mainLabel.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "rightAction");
		mainLabel.getActionMap().put("rightAction", rightAction);

		this.add(mainLabel);
		this.setVisible(true);

	}

	public class upAction extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			mainLabel.setLocation(mainLabel.getX(), mainLabel.getY() - 10);
		}

	}

	public class downAction extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			mainLabel.setLocation(mainLabel.getX(), mainLabel.getY() + 10);
		}

	}

	public class leftAction extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			mainLabel.setLocation(mainLabel.getX() - 10, mainLabel.getY());
		}

	}

	public class rightAction extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			mainLabel.setLocation(mainLabel.getX() + 10, mainLabel.getY());
		}

	}

}
