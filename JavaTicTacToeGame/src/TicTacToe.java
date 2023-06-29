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

		// Creating and adding our buttonPanel to our mainFrame
		buttonPanel.setLayout(new GridLayout(3, 3));
		buttonPanel.setBackground(new Color(150, 150, 150));

		mainFrame.add(buttonPanel);

		// Adding our JButtons in myButtons to our buttonPanel
		for (int i = 0; i < 9; i++) {
			myButtons[i] = new JButton();
			myButtons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
			myButtons[i].setFocusable(false);
			myButtons[i].addActionListener(this);

			buttonPanel.add(myButtons[i]);
		}

		mainFrame.setVisible(true);

		randomFirstTurn();

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		for (int i = 0; i < 9; i++) {
			if (arg0.getSource() == myButtons[i]) { // if any of our JButtons are pressed

				if (playerOneTurn) {
					// Check if the button clicked by the player is not yet taken
					if (myButtons[i].getText() == "") {
						myButtons[i].setForeground(new Color(255, 0, 0));
						myButtons[i].setText("X"); // set to X

						playerOneTurn = false;
						textFieldLabel.setText("O turn");

						checkWinner();

					}
				} else {

					if (myButtons[i].getText() == "") {
						myButtons[i].setForeground(new Color(0, 0, 255));
						myButtons[i].setText("O");

						playerOneTurn = true;
						textFieldLabel.setText("X turn");

						checkWinner();
					}

				}

			}
		}

	}

	public void randomFirstTurn() {

		// Pauses the program for 2 seconds
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Generating a random number between 0 and 1
		if (randomObj.nextInt(2) == 0) { // if 0, X turn
			playerOneTurn = true;
			textFieldLabel.setText("X turn");
		} else { // else, O turn
			playerOneTurn = false;
			textFieldLabel.setText("O turn");
		}

	}

	public void checkWinner() {

		// Check X win conditions
		// Horizontal lines
		if ((myButtons[0].getText() == "X") && (myButtons[1].getText() == "X") && (myButtons[2].getText() == "X")) {
			xWins(0, 1, 2);
		}
		if ((myButtons[3].getText() == "X") && (myButtons[4].getText() == "X") && (myButtons[5].getText() == "X")) {
			xWins(3, 4, 5);
		}
		if ((myButtons[6].getText() == "X") && (myButtons[7].getText() == "X") && (myButtons[8].getText() == "X")) {
			xWins(6, 7, 8);
		}
		// Vertical lines
		if ((myButtons[0].getText() == "X") && (myButtons[3].getText() == "X") && (myButtons[6].getText() == "X")) {
			xWins(0, 3, 6);
		}
		if ((myButtons[1].getText() == "X") && (myButtons[4].getText() == "X") && (myButtons[7].getText() == "X")) {
			xWins(1, 4, 7);
		}
		if ((myButtons[2].getText() == "X") && (myButtons[5].getText() == "X") && (myButtons[8].getText() == "X")) {
			xWins(2, 5, 8);
		}
		// Diagonal lines
		if ((myButtons[0].getText() == "X") && (myButtons[4].getText() == "X") && (myButtons[8].getText() == "X")) {
			xWins(0, 4, 8);
		}
		if ((myButtons[2].getText() == "X") && (myButtons[4].getText() == "X") && (myButtons[6].getText() == "X")) {
			xWins(2, 4, 6);
		}

		// Check y win conditions
		// Horizontal lines
		if ((myButtons[0].getText() == "O") && (myButtons[1].getText() == "O") && (myButtons[2].getText() == "O")) {
			oWins(0, 1, 2);
		}
		if ((myButtons[3].getText() == "O") && (myButtons[4].getText() == "O") && (myButtons[5].getText() == "O")) {
			oWins(3, 4, 5);
		}
		if ((myButtons[6].getText() == "O") && (myButtons[7].getText() == "O") && (myButtons[8].getText() == "O")) {
			oWins(6, 7, 8);
		}
		// Vertical lines
		if ((myButtons[0].getText() == "O") && (myButtons[3].getText() == "O") && (myButtons[6].getText() == "O")) {
			oWins(0, 3, 6);
		}
		if ((myButtons[1].getText() == "O") && (myButtons[4].getText() == "O") && (myButtons[7].getText() == "O")) {
			oWins(1, 4, 7);
		}
		if ((myButtons[2].getText() == "O") && (myButtons[5].getText() == "O") && (myButtons[8].getText() == "O")) {
			oWins(2, 5, 8);
		}
		// Diagonal lines
		if ((myButtons[0].getText() == "O") && (myButtons[4].getText() == "O") && (myButtons[8].getText() == "O")) {
			oWins(0, 4, 8);
		}
		if ((myButtons[2].getText() == "O") && (myButtons[4].getText() == "O") && (myButtons[6].getText() == "O")) {
			oWins(2, 4, 6);
		}

	}

	public void xWins(int a, int b, int c) {
		myButtons[a].setBackground(Color.GREEN);
		myButtons[b].setBackground(Color.GREEN);
		myButtons[c].setBackground(Color.GREEN);

		for (int i = 0; i < 9; i++) {
			myButtons[i].setEnabled(false);
		}
		textFieldLabel.setText("X wins");
	}

	public void oWins(int a, int b, int c) {
		myButtons[a].setBackground(Color.GREEN);
		myButtons[b].setBackground(Color.GREEN);
		myButtons[c].setBackground(Color.GREEN);

		for (int i = 0; i < 9; i++) {
			myButtons[i].setEnabled(false);
		}
		textFieldLabel.setText("O wins");

	}

}
