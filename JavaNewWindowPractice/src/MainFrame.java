import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame implements ActionListener {

	JButton newWindowButton;

	public MainFrame() {
		this.setTitle("[New Window Practice]");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(0, 128, 128));
		this.setLayout(null);

		newWindowButton = new JButton("[Open New Window]");
		newWindowButton.setBounds(100, 150, 300, 100);
		newWindowButton.setFocusable(false);
		newWindowButton.addActionListener(this);

		this.add(newWindowButton);
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == newWindowButton) {
			System.out.println("Button Pressed!");
			this.dispose(); // closes current JFrame
			new NewFrame(); // opens a new JFrame
		}
	}

}
