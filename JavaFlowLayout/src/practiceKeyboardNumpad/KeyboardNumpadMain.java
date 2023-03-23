package practiceKeyboardNumpad;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class KeyboardNumpadMain {

	public static void main(String[] args) {

		// Creating a JFrame to hold our program's components
		JFrame mainFrame = new JFrame();
		mainFrame.setTitle("[Keyboard Numpad]");
		mainFrame.setSize(900, 900);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		mainFrame.getContentPane().setBackground(Color.GRAY);
		mainFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

		// Creating a JPanel to add to our JFrame
		JPanel numberPanel = new JPanel();
		numberPanel.setPreferredSize(new Dimension(800, 800)); // new Dimension for FlowLayouts
		numberPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 100, 10));

		// Creating buttons for our JPanel
		JButton numLock = new JButton("<html> Num <br> Lock </html>");
		numLock.setPreferredSize(new Dimension(100, 100));
		numberPanel.add(numLock);
		
		JButton slashButton = new JButton("/");
		slashButton.setPreferredSize(new Dimension(100, 100));
		numberPanel.add(slashButton);
		
		JButton asteriskButton = new JButton("*");
		asteriskButton.setPreferredSize(new Dimension(100, 100));
		numberPanel.add(asteriskButton);
		
		JButton dashButton = new JButton("-");
		dashButton.setPreferredSize(new Dimension(100 ,100));
		numberPanel.add(dashButton);
		
		JButton sevenHomeButton = new JButton("<html> 7 <br> Home </html>");
		sevenHomeButton.setPreferredSize(new Dimension(100, 100));
		numberPanel.add(sevenHomeButton);
		
		JButton eightUpArrowButton = new JButton("<html> 8 <br> ⬆️ </html>");
		eightUpArrowButton.setPreferredSize(new Dimension(100, 100));
		numberPanel.add(eightUpArrowButton);
		
		JButton ninePageUpButton = new JButton("<html> 9 <br> Pg Up </html>");
		ninePageUpButton.setPreferredSize(new Dimension(100, 100));
		numberPanel.add(ninePageUpButton);
		
		JButton plusButton = new JButton("+");
		plusButton.setPreferredSize(new Dimension(100, 200));
		numberPanel.add(plusButton);
		
		JButton fourLeftArrowButton = new JButton("<html> 4 <br> ⬅️ </html>");
		fourLeftArrowButton.setPreferredSize(new Dimension(100, 100));
		numberPanel.add(fourLeftArrowButton);
		
		JButton fiveButton = new JButton("5");
		fiveButton.setPreferredSize(new Dimension(100, 100));
		numberPanel.add(fiveButton);
		
		JButton sixRightArrowButton = new JButton("<html> 6 <br> ➡️ </html>");
		sixRightArrowButton.setPreferredSize(new Dimension(100, 100));
		numberPanel.add(sixRightArrowButton);
		
		JButton enterButton = new JButton("Enter");
		enterButton.setPreferredSize(new Dimension(100, 200));
		numberPanel.add(enterButton);
		
		JButton oneEndButton = new JButton("<html> 1 <br> End </html>");
		oneEndButton.setPreferredSize(new Dimension(100, 100));
		numberPanel.add(oneEndButton);
		
		JButton twoDownArrowButton = new JButton("<html> 2 <br> ⬇️ </html>");
		twoDownArrowButton.setPreferredSize(new Dimension(100, 100));
		numberPanel.add(twoDownArrowButton);
		
		JButton threePageDownButton = new JButton("<html> 3 <br> Pg Dn </html>");
		threePageDownButton.setPreferredSize(new Dimension(100, 100));
		numberPanel.add(threePageDownButton);
		
		JButton zeroInsertButton = new JButton("<html> 0 <br> Ins </html>");
		zeroInsertButton.setPreferredSize(new Dimension(300, 100));
		numberPanel.add(zeroInsertButton);
		
		JButton deletePeriodButton = new JButton("<html> . <br> Del </html>");
		deletePeriodButton.setPreferredSize(new Dimension(100, 100));
		numberPanel.add(deletePeriodButton);
		
		// Adding our JPanel to our JFrame
		mainFrame.add(numberPanel);

		mainFrame.setVisible(true);

	}

}
