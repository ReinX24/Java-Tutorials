import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class SnakeGamePanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	final int SCREEN_WIDTH = 600;
	final int SCREEN_HEIGHT = 600;
	final int UNIT_SIZE = 25; // how much squares our program will have, a larger number will result in larger
								// squares
	final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE; // 144 squares
	final int TIME_DELAY = 75;

	// Snake head and body coordinates, arrays will contain coordinates for our snake
	final int[] x = new int[GAME_UNITS];
	final int[] y = new int[GAME_UNITS];

	public SnakeGamePanel() {
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

}
