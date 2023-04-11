
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame implements MouseListener {

	JLabel mainLabel;
	ImageIcon smileImage; // not hovering
	ImageIcon nervousImage; // hovering
	ImageIcon painImage; // clicked
	ImageIcon dizzyImage; // released

	public MyFrame() {
		this.setTitle("[Java Mouse Listener]");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());

		smileImage = new ImageIcon("smileImage.png");

		nervousImage = new ImageIcon("nervousImage.png");

		painImage = new ImageIcon("painImage.png");

		dizzyImage = new ImageIcon("dizzyImage.png");

		mainLabel = new JLabel();
		mainLabel.setIcon(smileImage);
		mainLabel.addMouseListener(this);

//		mainLabel = new JLabel();
//		mainLabel.setBounds(0, 0, 100, 100);
//		mainLabel.setBackground(Color.RED);
//		mainLabel.setOpaque(true);
//		this.addMouseListener(this);
//		this.add(mainLabel);

		this.add(mainLabel);
		this.setLocationRelativeTo(null);
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// Triggers when mouse is clicked (pressed and released)
//		System.out.println("You clicked the mouse!"); // prints when clicking on our mainLabel
		// Prints after we release our click
		mainLabel.setIcon(dizzyImage);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// When the mouse enters a component
		System.out.println("You entered mainLabel!");
//		mainLabel.setBackground(Color.PINK);
		mainLabel.setIcon(nervousImage);
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// When the mouse exits a component
//		mainLabel.setBackground(Color.RED);
		mainLabel.setIcon(smileImage);
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// Triggers when a mouse button has been pressed on a component, when button is
		// held down
//		System.out.println("You pressed the mouse!"); // when the user pressed but does not release
//		mainLabel.setBackground(Color.GREEN);
		mainLabel.setIcon(painImage);

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// Triggers when a mouse has been released on a component
//		System.out.println("You released the mouse!");
//		mainLabel.setBackground(Color.ORANGE);
		mainLabel.setIcon(dizzyImage);
	}

}
