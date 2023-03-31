package practiceRadioButtons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class MyFrame extends JFrame implements ActionListener {

	JLabel chooseLabel;
	JLabel chooseInstructions;

	JRadioButton authLeftButton;
	JRadioButton authRightButton;
	JRadioButton libLeftButton;
	JRadioButton libRightButton;

	public MyFrame() {
		this.setTitle("[Radio Buttons Practice]");
		this.setSize(500, 500);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(0, 128, 128));
		this.setLayout(new GridLayout(3, 2, 20, 20));

		chooseLabel = new JLabel("[Choose Your Fighter]");
//		chooseLabel.setPreferredSize(new Dimension(200, 100));
		chooseLabel.setOpaque(true);
		chooseLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		chooseLabel.setBackground(Color.WHITE);
		chooseLabel.setForeground(Color.BLACK);
		chooseLabel.setHorizontalAlignment(JLabel.CENTER);

		chooseInstructions = new JLabel("<html>* Choose which fighter <br> suits your playstyle *</html>");
		chooseInstructions.setOpaque(true);
		chooseInstructions.setBackground(Color.WHITE);
		chooseInstructions.setForeground(Color.BLACK);
		chooseInstructions.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		chooseInstructions.setHorizontalAlignment(JLabel.CENTER);

		// Finish creating our JRadioButtons
		authLeftButton = new JRadioButton("Authoritarian Left");
		authLeftButton.setFocusable(false);
		authLeftButton.setBackground(Color.WHITE);
		authLeftButton.setForeground(Color.BLACK);
		authLeftButton.addActionListener(this);

		authRightButton = new JRadioButton("Authoritarian Right");
		authRightButton.setFocusable(false);
		authRightButton.setBackground(Color.WHITE);
		authRightButton.setForeground(Color.BLACK);
		authRightButton.addActionListener(this);

		libLeftButton = new JRadioButton("Libertarian Left");
		libLeftButton.setFocusable(false);
		libLeftButton.setBackground(Color.WHITE);
		libLeftButton.setForeground(Color.BLACK);
		libLeftButton.addActionListener(this);

		libRightButton = new JRadioButton("Libertarian Right");
		libRightButton.setFocusable(false);
		libRightButton.setBackground(Color.WHITE);
		libRightButton.setForeground(Color.BLACK);
		libRightButton.addActionListener(this);

		// Setting custom ImageIcons to each of our Radio Buttons
		ImageIcon authLeftIcon = new ImageIcon("authLeftPhoto.png");
		ImageIcon authRightIcon = new ImageIcon("authRightPhoto.png");
		ImageIcon libLeftIcon = new ImageIcon("libLeftPhoto.png");
		ImageIcon libRightIcon = new ImageIcon("libRightPhoto.png");

		authLeftButton.setIcon(authLeftIcon);
		authRightButton.setIcon(authRightIcon);
		libLeftButton.setIcon(libLeftIcon);
		libRightButton.setIcon(libRightIcon);

		/*
		 * We add these buttons to a Button group so that only one of them can be chosen
		 */
		ButtonGroup choiceButtons = new ButtonGroup();
		choiceButtons.add(authLeftButton);
		choiceButtons.add(authRightButton);
		choiceButtons.add(libLeftButton);
		choiceButtons.add(libRightButton);

		this.add(chooseLabel);
		this.add(chooseInstructions);

		this.add(authLeftButton);
		this.add(authRightButton);
		this.add(libLeftButton);
		this.add(libRightButton);

		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == authLeftButton) {
			JOptionPane.showMessageDialog(null, "Authoritarian Left Chosen!", "[Authoritarian Left]",
					JOptionPane.INFORMATION_MESSAGE);
		} else if (arg0.getSource() == authRightButton) {
			JOptionPane.showMessageDialog(null, "Authoritarian Right Chosen!", "[Authoritarian Right]",
					JOptionPane.INFORMATION_MESSAGE);
		} else if (arg0.getSource() == libLeftButton) {
			JOptionPane.showMessageDialog(null, "Libertarian Left Chosen!", "[Libertarian Left]",
					JOptionPane.INFORMATION_MESSAGE);
		} else if (arg0.getSource() == libRightButton) {
			JOptionPane.showMessageDialog(null, "Libertarian Right Chosen!", "[Libertarian Right]",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
