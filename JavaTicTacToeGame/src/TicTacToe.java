import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {

	Random randomObj = new Random();
	JFrame mainFrame = new JFrame();
	JPanel titlePanel = new JPanel();

	JPanel buttonPanel = new JPanel();
	JLabel textFieldLabel = new JLabel();

	JButton[] myButtons = new JButton[9];

	boolean playerOneTurn;
	boolean playerTwoTurn;

	public TicTacToe() {

		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(800, 800);
		mainFrame.getContentPane().setBackground(new Color(50, 50, 50));
		mainFrame.setLayout(new BorderLayout());

		// JLabel that will hold our title
		textFieldLabel.setBackground(new Color(25, 25, 25));
		textFieldLabel.setForeground(new Color(25, 255, 0));
		textFieldLabel.setFont(new Font("Ink Free", Font.BOLD, 75));
		textFieldLabel.setHorizontalAlignment(JLabel.CENTER);
		textFieldLabel.setText("Tic Tac Toe");
		textFieldLabel.setOpaque(true);

		// JPanel that will hold our JLabel that shows the game title
		titlePanel.setLayout(new BorderLayout());
		titlePanel.setBounds(0, 0, 800, 100);

		titlePanel.add(textFieldLabel);
		
		mainFrame.add(titlePanel, BorderLayout.NORTH);

		buttonPanel.setLayout(new GridLayout(3, 3));
		buttonPanel.setBackground(new Color(150, 150, 150));
		
		mainFrame.add(buttonPanel);
		
		// TODO: resume at 13:30

		mainFrame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

	public void randomFirstTurn() {

	}

	public void checkWinner() {

	}

	public void xWins(int a, int b, int c) {

	}

	public void yWins(int a, int b, int c) {

	}

}
