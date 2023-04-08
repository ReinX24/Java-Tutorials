package practiceJavaColorChooser;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ColorChooserFrame extends JFrame implements ActionListener {

	JButton pickColorButton;
	JLabel pickColorLabel;

	public ColorChooserFrame() {
		this.setTitle("[Color Chooser Practice]");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());

		pickColorButton = new JButton("[Pick Color]");
		pickColorButton.setFocusable(false);
		pickColorButton.setPreferredSize(new Dimension(200, 50));
		pickColorButton.addActionListener(this);

		pickColorLabel = new JLabel();
		pickColorLabel.setOpaque(true);
		pickColorLabel.setForeground(Color.BLACK);
		pickColorLabel.setBackground(Color.WHITE);
		pickColorLabel.setText("This is some sample text!");
		pickColorLabel.setFont(new Font("MV Boli", Font.PLAIN, 32));

		this.add(pickColorButton);
		this.add(pickColorLabel);
		this.pack();
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == pickColorButton) {

			Color userColor = JColorChooser.showDialog(null, "Pick A Color", Color.WHITE);

			String[] choiceArr = { "Text", "Background", "Cancel" };

			int userChoice = JOptionPane.showOptionDialog(null, "Pick Component", "[Change Color]",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null /* ImageIcon */, choiceArr,
					0);

			switch (userChoice) {
			case 0:
				pickColorLabel.setForeground(userColor);
				break;

			case 1:
				pickColorLabel.setBackground(userColor);
				break;

			case 2:
				JOptionPane.showMessageDialog(null, "Color Change Cancelled!", "[Cancel Message]",
						JOptionPane.INFORMATION_MESSAGE);
				break;
			}

		}
	}

}
