
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MyFrame extends JFrame implements ActionListener {

	JButton buttonMain;
	JLabel labelMain;

	public MyFrame() {
		this.setTitle("[JColorChooser]");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());

		buttonMain = new JButton("[Select A Color]");
		buttonMain.addActionListener(this);
		buttonMain.setFocusable(false);

		labelMain = new JLabel();
		labelMain.setOpaque(true);
		labelMain.setBackground(new Color(0, 128, 128));
		labelMain.setForeground(Color.WHITE);
		labelMain.setText("This is some text :D");
		labelMain.setFont(new Font("MV Bole", Font.PLAIN, 32));

		this.add(buttonMain);
		this.add(labelMain);
		this.pack();
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource() == buttonMain) {
			JColorChooser colorChooser = new JColorChooser();

			// Storing chosen color in userColor
			Color userColor = JColorChooser.showDialog(null, "Pick A Color", Color.WHITE); // parent component, title,
																							// starting color

			// Changing the font color of labelMain using to our new chosen color
//			labelMain.setForeground(userColor);

			// Changing the background of our labelMain
			labelMain.setBackground(userColor);
		}

	}

}
