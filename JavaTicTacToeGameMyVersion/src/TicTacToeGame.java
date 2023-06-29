import java.awt.*;
import java.awt.event.*;
import java.io.UTFDataFormatException;
import java.util.*;
import javax.swing.*;

public class TicTacToeGame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	JLabel titleLabel = new JLabel();

	JButton[] buttonsArr = new JButton[9];
	JPanel buttonsPanel = new JPanel();

	boolean playerOneTurn;

	Random randomNumberGen = new Random();

	public TicTacToeGame() {

		this.setTitle("Java Tic Tac Toe Game");
		this.setSize(900, 1000);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		titleLabel.setText("Tic Tac Toe");
		titleLabel.setPreferredSize(new Dimension(900, 100));
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setFont(new Font(null, Font.BOLD, 70));
		titleLabel.setForeground(Color.GREEN);
		titleLabel.setBackground(Color.BLACK);
		titleLabel.setOpaque(true);

		this.add(titleLabel, BorderLayout.NORTH);

		buttonsPanel.setPreferredSize(new Dimension(900, 900));
		buttonsPanel.setBackground(Color.GRAY);
		buttonsPanel.setLayout(new GridLayout(3, 3));

		this.add(buttonsPanel);

		for (int i = 0; i < buttonsArr.length; i++) {
			buttonsArr[i] = new JButton();
			buttonsArr[i].addActionListener(this);
			buttonsArr[i].setFocusable(false);
			buttonsArr[i].setFont(new Font(null, Font.BOLD, 70));

			buttonsPanel.add(buttonsArr[i]);
		}

		buttonsPanel.setVisible(false); // will show buttonsPanel after 2 seconds

		this.setVisible(true);

		chooseRandomFirstPlayer();

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		for (int i = 0; i < buttonsArr.length; i++) {

			if (playerOneTurn) {

				if (arg0.getSource() == buttonsArr[i] && buttonsArr[i].getText() == "") {
					buttonsArr[i].setText("X");
					playerOneTurn = false;
					// TODO: change titleLabel text after each turn
				}

			} else {
				
				if (arg0.getSource() == buttonsArr[i] && buttonsArr[i].getText() == "") {
					buttonsArr[i].setText("O");
					playerOneTurn = true;
				}
				
			}

		}

	}

	public void chooseRandomFirstPlayer() {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			buttonsPanel.setVisible(true);
		}

		// Generates a random number between 0 and 1
		// 0 : X first, 1 : O first
		if (randomNumberGen.nextInt(2) == 0) {
			titleLabel.setText("X turn");
			playerOneTurn = true;
		} else {
			titleLabel.setText("O turn");
			playerOneTurn = false;
		}

	}

	public void checkIfWin() {

	}

	public void xWin() {

	}

	public void oWin() {

	}

}
