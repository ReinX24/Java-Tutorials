import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PracticeMain {

	public static void main(String[] args) {

		// JFrame to hold the JPanels
		JFrame mainFrame = new JFrame();
		mainFrame.setVisible(true);
		mainFrame.setTitle("[ Political Compass Meme Technology ]");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(1000, 1000);
		mainFrame.setResizable(false);
		mainFrame.getContentPane().setBackground(Color.GRAY);
		mainFrame.setLayout(null); // setting the bounds of our JPanels individually

		// Creating JPanels that are going to be added to our JFrame
		JPanel authoritarianLeft = new JPanel();
		authoritarianLeft.setSize(400, 400);
		authoritarianLeft.setBackground(Color.RED);
		authoritarianLeft.setLayout(new BorderLayout());

		JPanel authoritorianRight = new JPanel();
		authoritorianRight.setSize(400, 400);
		authoritorianRight.setBackground(Color.BLUE);
		authoritorianRight.setLayout(new BorderLayout());

		JPanel libertarianLeft = new JPanel();
		libertarianLeft.setSize(400, 400);
		libertarianLeft.setBackground(Color.GREEN);
		libertarianLeft.setLayout(new BorderLayout());

		JPanel libertarianRight = new JPanel();
		libertarianRight.setSize(400, 400);
		libertarianRight.setBackground(Color.YELLOW);
		libertarianRight.setLayout(new BorderLayout());

		// Adding the JPanels to our JFrame
		mainFrame.add(authoritarianLeft);
		mainFrame.add(authoritorianRight);
		mainFrame.add(libertarianLeft);
		mainFrame.add(libertarianRight);

		// Setting the bounds of our JPanels
		authoritarianLeft.setBounds(100, 100, 400, 400);
		authoritorianRight.setBounds(500, 100, 400, 400);
		libertarianLeft.setBounds(100, 500, 400, 400);
		libertarianRight.setBounds(500, 500, 400, 400);

		// Creating JLabels for each of our JPanels
		JLabel authLeftLabel = new JLabel();
		authLeftLabel.setText("[ Authoritarian Left ]");

		JLabel authRightLabel = new JLabel();
		authRightLabel.setText("[ Authoritarian Right ]");

		JLabel libLeftLabel = new JLabel();
		libLeftLabel.setText("[ Libertarian Left ]");

		JLabel libRightLabel = new JLabel();
		libRightLabel.setText("[ Libertarian Right ]");

		// Adding our JLabels to our JPanels
		authoritarianLeft.add(authLeftLabel);
		authoritorianRight.add(authRightLabel);
		libertarianLeft.add(libLeftLabel);
		libertarianRight.add(libRightLabel);

		// Moving each JLabel to the center of JPanels
		authLeftLabel.setHorizontalAlignment(JLabel.CENTER);
		authLeftLabel.setVerticalAlignment(JLabel.CENTER);

		authRightLabel.setHorizontalAlignment(JLabel.CENTER);
		authRightLabel.setVerticalAlignment(JLabel.CENTER);

		libLeftLabel.setHorizontalAlignment(JLabel.CENTER);
		libLeftLabel.setVerticalAlignment(JLabel.CENTER);

		libRightLabel.setHorizontalAlignment(JLabel.CENTER);
		libRightLabel.setVerticalAlignment(JLabel.CENTER);

		// Changing the font of each JLabel
		authLeftLabel.setFont(new Font("Arial", Font.BOLD, 20));
		authLeftLabel.setForeground(Color.WHITE);
		authRightLabel.setFont(new Font("Arial", Font.BOLD, 20));
		authRightLabel.setForeground(Color.WHITE);
		libLeftLabel.setFont(new Font("Arial", Font.BOLD, 20));
		libRightLabel.setFont(new Font("Arial", Font.BOLD, 20));

		// Adding photos to each JLabel
		ImageIcon authLeftPhoto = new ImageIcon("authLeftPhoto.png");
		authLeftLabel.setIcon(authLeftPhoto);

		ImageIcon authRightPhoto = new ImageIcon("authRightPhoto.png");
		authRightLabel.setIcon(authRightPhoto);

		ImageIcon libLeftPhoto = new ImageIcon("libLeftPhoto.png");
		libLeftLabel.setIcon(libLeftPhoto);

		ImageIcon libRightPhoto = new ImageIcon("libRightPhoto.png");
		libRightLabel.setIcon(libRightPhoto);

		// Moving the text of each JLabel
		authLeftLabel.setHorizontalTextPosition(JLabel.CENTER);
		authLeftLabel.setVerticalTextPosition(JLabel.TOP);
		authLeftLabel.setIconTextGap(20);

		authRightLabel.setHorizontalTextPosition(JLabel.CENTER);
		authRightLabel.setVerticalTextPosition(JLabel.TOP);
		authRightLabel.setIconTextGap(20);

		libLeftLabel.setHorizontalTextPosition(JLabel.CENTER);
		libLeftLabel.setVerticalTextPosition(JLabel.TOP);
		libLeftLabel.setIconTextGap(20);

		libRightLabel.setHorizontalAlignment(JLabel.CENTER);
		libRightLabel.setVerticalTextPosition(JLabel.TOP);
		libRightLabel.setIconTextGap(20);

		// Adding borders to each of our JLabels
		Border labelBorder = BorderFactory.createLineBorder(Color.BLACK, 2);
		authLeftLabel.setBorder(labelBorder);
		authRightLabel.setBorder(labelBorder);
		libLeftLabel.setBorder(labelBorder);
		libRightLabel.setBorder(labelBorder);

		// Changing the Icon of our program
		ImageIcon programIcon = new ImageIcon("greenFrog.png");
		mainFrame.setIconImage(programIcon.getImage());

	}

}
