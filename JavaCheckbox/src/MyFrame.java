import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.HttpRetryException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class MyFrame extends JFrame implements ActionListener {

	JButton mainButton;
	JCheckBox checkBoxMain;

	public MyFrame() {
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());

		mainButton = new JButton();
		mainButton.setText("[Submit]");
		mainButton.addActionListener(this);

		checkBoxMain = new JCheckBox();
		checkBoxMain.setText("[I'm not a robot]");
		checkBoxMain.setFocusable(false);
		checkBoxMain.setFont(new Font("Arial", Font.PLAIN, 32));

		// Setting custom check and x marks for check box
		ImageIcon redIcon = new ImageIcon("redColor.png");
		ImageIcon greenIcon = new ImageIcon("greenColor.png");

		// Default icon
		checkBoxMain.setIcon(redIcon);

		// Selected icon
		checkBoxMain.setSelectedIcon(greenIcon);

		this.add(mainButton);
		this.add(checkBoxMain);
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mainButton) {
			checkBoxMain.isSelected(); // returns either true or false
			System.out.println(checkBoxMain.isSelected());
		}
	}

}
