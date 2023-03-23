import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RandomColorCreate extends JFrame implements ActionListener {

	JButton randomColorButton;
	JPanel colorPanel;
	Random randNum = new Random();

	public RandomColorCreate() {
		this.setTitle("[Random Color Generator]");
		this.setResizable(false);
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(0, 128, 128));
		this.setLayout(null);

		randomColorButton = new JButton("[Generate Random Color]");
		randomColorButton.setBounds(100, 50, 300, 100);
		randomColorButton.setFocusable(false);
		randomColorButton.addActionListener(this);
		randomColorButton.setBackground(Color.WHITE);
		randomColorButton.setBorder(BorderFactory.createEtchedBorder());
		this.add(randomColorButton);

		colorPanel = new JPanel();
//		Random randNum = new Random();
//		int randomValOne = randNum.nextInt(0, 256);
//		int randomValTwo = randNum.nextInt(0, 256);
//		int randomValThree = randNum.nextInt(0, 256);
//
//		System.out.println(randomValOne);
//		System.out.println(randomValTwo);
//		System.out.println(randomValThree);

//		JLabel colorValues = new JLabel();
//		colorValues.setText(randomValOne + ", " + randomValTwo + ", " + randomValThree);
//		colorValues.setForeground(Color.WHITE);

		colorPanel.setBounds(125, 200, 250, 250);
//		colorPanel.setBackground(new Color(randomValOne, randomValTwo, randomValThree));
		colorPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		colorPanel.setVisible(false);
		this.add(colorPanel);

		this.setVisible(true); // should be at the end of the program
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == randomColorButton) {
			System.out.println("[Button Pressed!]");
			JLabel colorValues = new JLabel();

//			colorPanel = new JPanel();
//			Random randNum = new Random();
			int randomValOne = randNum.nextInt(0, 256);
			int randomValTwo = randNum.nextInt(0, 256);
			int randomValThree = randNum.nextInt(0, 256);
			colorPanel.setBackground(new Color(randomValOne, randomValTwo, randomValThree));

//			System.out.println(randomValOne);
//			System.out.println(randomValTwo);
//			System.out.println(randomValThree);
//
//			colorValues.setText(randomValOne + ", " + randomValTwo + ", " + randomValThree);

//			colorPanel.setBounds(125, 200, 250, 250);
//			colorPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
//			colorPanel.add(colorValues);

//			colorPanel.setVisible(true);
//			this.add(colorPanel);

//			JLabel colorValues = new JLabel();
//			colorValues.setText(randomValOne + ", " + randomValTwo + ", " + randomValThree);
//			colorValues.setForeground(Color.WHITE);

			colorPanel.setVisible(true);
		}
	}
}
