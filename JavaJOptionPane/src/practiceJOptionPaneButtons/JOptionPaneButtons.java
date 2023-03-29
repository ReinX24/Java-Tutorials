package practiceJOptionPaneButtons;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class JOptionPaneButtons implements ActionListener {

	JButton plainMessageButton;
	JButton informationButton;
	JButton questionButton;
	JButton warningButton;
	JButton errorButton;

	JButton confirmButton;
	JButton inputButton;
	JButton optionDialogPlain;
	JButton optionDialogIcon;

	JOptionPaneButtons() {

		JFrame mainFrame = new JFrame();
		mainFrame.setTitle("[JOption Pane Practice]");
		mainFrame.setSize(1000, 500);
		mainFrame.setResizable(false);
		mainFrame.getContentPane().setBackground(new Color(0, 128, 128));
		mainFrame.setLayout(null);

		JLabel buttonTitleLabel = new JLabel("[Message Dialog Generator]");
		buttonTitleLabel.setBounds(350, 50, 300, 50);
		buttonTitleLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		buttonTitleLabel.setBackground(Color.WHITE);
		buttonTitleLabel.setForeground(Color.BLACK);
		buttonTitleLabel.setOpaque(true);
		buttonTitleLabel.setHorizontalAlignment(JLabel.CENTER);

		// Adding buttons that show the different showMessageDialogs
		plainMessageButton = new JButton("[Plain]");
		plainMessageButton.setBounds(25, 150, 150, 100);
		plainMessageButton.addActionListener(this);
		plainMessageButton.setFocusable(false);

		informationButton = new JButton("[Information]");
		informationButton.setBounds(225, 150, 150, 100);
		informationButton.addActionListener(this);
		informationButton.setFocusable(false);

		questionButton = new JButton("[Question]");
		questionButton.setBounds(425, 150, 150, 100);
		questionButton.addActionListener(this);
		questionButton.setFocusable(false);

		warningButton = new JButton("[Warning]");
		warningButton.setBounds(625, 150, 150, 100);
		warningButton.addActionListener(this);
		warningButton.setFocusable(false);

		errorButton = new JButton("[Error]");
		errorButton.setBounds(825, 150, 150, 100);
		errorButton.addActionListener(this);
		errorButton.setFocusable(false);

		inputButton = new JButton("[Input Dialog]");
		inputButton.setBounds(25, 300, 200, 100);
		inputButton.addActionListener(this);
		inputButton.setFocusable(false);

		confirmButton = new JButton("[Confirm Dialog]");
		confirmButton.setBounds(275, 300, 200, 100);
		confirmButton.addActionListener(this);
		confirmButton.setFocusable(false);

		optionDialogPlain = new JButton("[Option Dialog Plain]");
		optionDialogPlain.setBounds(525, 300, 200, 100);
		optionDialogPlain.addActionListener(this);
		optionDialogPlain.setFocusable(false);

		optionDialogIcon = new JButton("[Option Dialog Icon]");
		optionDialogIcon.setBounds(775, 300, 200, 100);
		optionDialogIcon.addActionListener(this);
		optionDialogIcon.setFocusable(false);

		mainFrame.add(buttonTitleLabel);
		mainFrame.add(plainMessageButton);
		mainFrame.add(informationButton);
		mainFrame.add(questionButton);
		mainFrame.add(warningButton);
		mainFrame.add(errorButton);

		mainFrame.add(confirmButton);
		mainFrame.add(inputButton);
		mainFrame.add(optionDialogPlain);
		mainFrame.add(optionDialogIcon);

		mainFrame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == plainMessageButton) {
			JOptionPane.showMessageDialog(null, "This is a plain message!", "[Plain Message]",
					JOptionPane.PLAIN_MESSAGE);
		} else if (arg0.getSource() == informationButton) {
			JOptionPane.showMessageDialog(null, "This is an information message!", "[Information Message]",
					JOptionPane.INFORMATION_MESSAGE);
		} else if (arg0.getSource() == questionButton) {
			JOptionPane.showMessageDialog(null, "This is a question message!", "[Question Message]",
					JOptionPane.QUESTION_MESSAGE);
		} else if (arg0.getSource() == warningButton) {
			JOptionPane.showMessageDialog(null, "This is a warning message!", "[Warning Message]",
					JOptionPane.WARNING_MESSAGE);
		} else if (arg0.getSource() == errorButton) {
			JOptionPane.showMessageDialog(null, "This is an error message!", "[Error Message]",
					JOptionPane.ERROR_MESSAGE);
		} else if (arg0.getSource() == inputButton) {
			String userInput = JOptionPane.showInputDialog(null, "This is an input dialog!", "[Input Dialog]",
					JOptionPane.INFORMATION_MESSAGE);
			JOptionPane.showMessageDialog(null, "You entered: " + userInput, "[Input Message]",
					JOptionPane.INFORMATION_MESSAGE);
		} else if (arg0.getSource() == confirmButton) {
			int userChoice = JOptionPane.showConfirmDialog(null, "This is confirm dialog!", "[Confirm Dialog]",
					JOptionPane.YES_NO_CANCEL_OPTION);
			switch (userChoice) {
			case 0:
				JOptionPane.showMessageDialog(null, "You clicked 'Yes'!", "[Yes Message]",
						JOptionPane.INFORMATION_MESSAGE);
				break;

			case 1:
				JOptionPane.showMessageDialog(null, "You clicked 'No'!", "[No Message]",
						JOptionPane.INFORMATION_MESSAGE);
				break;

			case 2:
				JOptionPane.showMessageDialog(null, "You clicked 'Cancel'", "[Cancel Message]",
						JOptionPane.INFORMATION_MESSAGE);
				break;

			default:
				JOptionPane.showMessageDialog(null, "Exited window!", "[Exit Message]", JOptionPane.ERROR_MESSAGE);
				break;
			}
		} else if (arg0.getSource() == optionDialogPlain) {
			int userChoice = JOptionPane.showOptionDialog(null, "This is a plain option dialog",
					"[Option Dialog Plain]", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
					null, 0);
			switch (userChoice) {
			case 0:
				JOptionPane.showMessageDialog(null, "You clicked 'Yes'!", "[Yes Message]",
						JOptionPane.INFORMATION_MESSAGE);
				break;

			case 1:
				JOptionPane.showMessageDialog(null, "You clicked 'No'!", "[No Message]", JOptionPane.WARNING_MESSAGE);
				break;

			case 2:
				JOptionPane.showMessageDialog(null, "You clicked 'Cancel'!", "[Cancel Message]",
						JOptionPane.QUESTION_MESSAGE);
				break;

			default:
				JOptionPane.showMessageDialog(null, "Exited window!", "[Exit Message]", JOptionPane.ERROR_MESSAGE);
				break;
			}
		} else if (arg0.getSource() == optionDialogIcon) {
			// Creating an ImageIcon for our Option Dialog
			ImageIcon dialogIcon = new ImageIcon(
					"/home/rein/repos/Bro-Code-Java-Tutorial/JavaJOptionPane/warriorSword.png");
			// Adding different custom responses through a String array
			String[] customResponses = { "I accept your challenge!", "I decline your challenge!", "Maybe later",
					"Seriously?" };

			// Creating our Option Dialog
			int userChoice = JOptionPane.showOptionDialog(null, "Do you accept my challenge?", "[Warrior Challenge]",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, dialogIcon, customResponses, 0);

			switch (userChoice) {
			case 0:
				JOptionPane.showMessageDialog(null, "Challenge Accepted!", "[Accept Message]",
						JOptionPane.INFORMATION_MESSAGE);
				break;

			case 1:
				JOptionPane.showMessageDialog(null, "Challenge Declined!", "[Decline Message]",
						JOptionPane.INFORMATION_MESSAGE);
				break;

			case 2:
				JOptionPane.showMessageDialog(null, "Challenge Delayed!", "[Delay Message]",
						JOptionPane.WARNING_MESSAGE);
				break;

			case 3:
				JOptionPane.showMessageDialog(null, "Challenger Angered!", "[Anger Message]",
						JOptionPane.WARNING_MESSAGE);
				break;

			default:
				JOptionPane.showMessageDialog(null, "Exited Window!", "[Exit Message]", JOptionPane.ERROR_MESSAGE);
				break;
			}
		}

	}

}
