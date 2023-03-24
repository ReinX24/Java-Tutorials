package practiceKeyboardNumpad;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class KeyboardNumpadCreate extends JFrame {

	private static final long serialVersionUID = 8414173422912858300L;

	public KeyboardNumpadCreate() {
		this.setTitle("Keyboard Numpad");
		this.setSize(1000, 1000);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setResizable(true);
//		this.setLayout(new GridLayout(4, 3, 10, 10)); // rows, columns, x elements margins, y elements margins
		this.setLayout(null);

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(4, 3, 10, 10));
		mainPanel.setBounds(0, 0, 790, 790);
		mainPanel.add(new JButton("Num Lk"));
		mainPanel.add(new JButton("/"));
		mainPanel.add(new JButton("*"));
		mainPanel.add(new JButton("<html> 7 <br> Home </html>"));
		mainPanel.add(new JButton("<html> 8 <br> ⬆️ </html>"));
		mainPanel.add(new JButton("<html> 9 <br> PgUp </html>"));
		mainPanel.add(new JButton("<html> 4 <br> ⬅️ </html>"));
		mainPanel.add(new JButton("5"));
		mainPanel.add(new JButton("<html> 6 <br> ➡️ </html>"));
		mainPanel.add(new JButton("<html> 1 <br> End </html>"));
		mainPanel.add(new JButton("<html> 2 <br> ⬇️ </html>"));
		mainPanel.add(new JButton("<html> 3 <br> PgDn </html>"));

		this.add(mainPanel);

		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BorderLayout(10, 10));
		rightPanel.setBounds(800, 0, 200, 1000);

		JButton minusButton = new JButton("-");
		minusButton.setPreferredSize(new Dimension(200, 190));
		rightPanel.add(minusButton, BorderLayout.NORTH);

		JButton plusButton = new JButton("+");
		plusButton.setPreferredSize(new Dimension(200, 300));
		rightPanel.add(plusButton, BorderLayout.CENTER);

		JButton enterButton = new JButton("Enter");
		enterButton.setPreferredSize(new Dimension(200, 400));
		rightPanel.add(enterButton, BorderLayout.SOUTH);

		this.add(rightPanel);

		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new BorderLayout(10, 10));
		bottomPanel.setBounds(0, 800, 790, 200);

		JButton zeroInsertButton = new JButton("<html> 0 <br> Ins </html>");
		zeroInsertButton.setPreferredSize(new Dimension(523, 190));
		bottomPanel.add(zeroInsertButton, BorderLayout.WEST);

		JButton periodDeleteButton = new JButton("<html> . <br> Del </html>");
		periodDeleteButton.setPreferredSize(new Dimension(257, 190));
		bottomPanel.add(periodDeleteButton, BorderLayout.EAST);

		this.add(bottomPanel);

		this.setVisible(true);
	}

}
