package practiceFlagGenerator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CreateFrenchFlag extends JFrame {

	public CreateFrenchFlag() {
		this.setTitle("[French Flag]");
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		this.setBackground(Color.GRAY);
		this.setLayout(new BorderLayout());

		JPanel leftPanel = new JPanel();
		JPanel middlePanel = new JPanel();
		JPanel rightPanel = new JPanel();

		leftPanel.setPreferredSize(new Dimension(200, 600));
		middlePanel.setPreferredSize(new Dimension(200, 600));
		rightPanel.setPreferredSize(new Dimension(200, 600));

		leftPanel.setBackground(Color.BLUE);
		middlePanel.setBackground(Color.WHITE);
		rightPanel.setBackground(Color.RED);

		this.add(leftPanel, BorderLayout.WEST);
		this.add(middlePanel, BorderLayout.CENTER);
		this.add(rightPanel, BorderLayout.EAST);
	}

}
