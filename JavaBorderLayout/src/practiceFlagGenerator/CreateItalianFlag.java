package practiceFlagGenerator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CreateItalianFlag extends JFrame {

	public CreateItalianFlag() {
		this.setTitle("[Italian Flag]");
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		this.setBackground(Color.BLUE);
		this.setLayout(new BorderLayout(200, 0));

		JPanel leftPanel = new JPanel();
		JPanel centerpPanel = new JPanel();
		JPanel rightPanel = new JPanel();

		leftPanel.setPreferredSize(new Dimension(200, 600));
		centerpPanel.setPreferredSize(new Dimension(200, 600));
		rightPanel.setPreferredSize(new Dimension(200, 600));

		leftPanel.setBackground(Color.GREEN);
		centerpPanel.setBackground(Color.WHITE);
		rightPanel.setBackground(Color.RED);

		this.add(leftPanel, BorderLayout.WEST);
		this.add(centerpPanel, BorderLayout.CENTER);
		this.add(rightPanel, BorderLayout.EAST);

	}

}
