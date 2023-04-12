package practiceMouseListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseListenerPracticeFrame extends JFrame implements MouseListener {

	JLabel mainLabel;

	ImageIcon smileIcon;
	ImageIcon nervousIcon;
	ImageIcon painIcon;
	ImageIcon dizzyIcon;

	public MouseListenerPracticeFrame() {
		this.setTitle("MouseListener Practice");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(0, 128, 128));
		this.setLayout(null);

		smileIcon = new ImageIcon("smileImage.png");

		mainLabel = new JLabel(smileIcon);
		mainLabel.setBounds(100, 75, 300, 300);
		mainLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		mainLabel.setOpaque(true);
		mainLabel.setBackground(Color.WHITE);
		mainLabel.addMouseListener(this);

		this.add(mainLabel);
		this.setVisible(true);

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// When the user clicks and releases their mouse
		dizzyIcon = new ImageIcon("dizzyImage.png");
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// When the cursor hovers over the area with a MouseListener
		nervousIcon = new ImageIcon("nervousImage.png");
		mainLabel.setIcon(nervousIcon);
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// When the user's cursor exits the area with a MouseListener
		smileIcon = new ImageIcon("smileImage.png");
		mainLabel.setIcon(smileIcon);
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// When the user clicks and holds down their mouse
		painIcon = new ImageIcon("painImage.png");
		mainLabel.setIcon(painIcon);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// When the user releases the mouse
		dizzyIcon = new ImageIcon("dizzyImage.png");
		mainLabel.setIcon(dizzyIcon);
	}

}
