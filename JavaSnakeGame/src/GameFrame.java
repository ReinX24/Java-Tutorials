import javax.swing.*;

public class GameFrame extends JFrame {

	public GameFrame() {

		this.setTitle("Snake");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.add(new GamePanel());
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	}

}
