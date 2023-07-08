import javax.swing.*;

public class SnakeGameFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public SnakeGameFrame() {
		this.setTitle("Java Snake Game");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		this.add(new SnakeGamePanel());

		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null); // this must be at the end for it to work properly
	}

}
