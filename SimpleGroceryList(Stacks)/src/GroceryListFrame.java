import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GroceryListFrame extends JFrame implements ActionListener {

	JPanel mainPanel;
	JLabel titleLabel;

	JButton addButton;
	JButton deleteButton;
	JButton searchButton;

	JPanel listTextPanel;

	public GroceryListFrame() {
		this.setTitle("Simple Grocery List");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/* Creating our JPanel and setting its attributes */
		mainPanel = new JPanel();
		mainPanel.setPreferredSize(new Dimension(1024, 768));
		mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
		mainPanel.setBackground(new Color(29, 35, 38));

		this.add(mainPanel);

		/* Adding our title label and setting its attributes */
		titleLabel = new JLabel("Simple Grocery List (Stacks)");
		titleLabel.setForeground(new Color(191, 163, 138));
		titleLabel.setFont(new Font(null, Font.BOLD, 44));

		mainPanel.add(titleLabel);

		/* Adding our JButton and setting their attributes */
		addButton = new JButton("Add New Item");
		deleteButton = new JButton("Delete Last Added Item");
		searchButton = new JButton("Search Item");

		addButton.setFocusable(false);
		deleteButton.setFocusable(false);
		searchButton.setFocusable(false);

		addButton.setPreferredSize(new Dimension(250, 50));
		deleteButton.setPreferredSize(new Dimension(250, 50));
		searchButton.setPreferredSize(new Dimension(250, 50));

		addButton.addActionListener(this);
		deleteButton.addActionListener(this);
		searchButton.addActionListener(this);

		addButton.setBackground(new Color(29, 35, 38));
		addButton.setForeground(new Color(191, 163, 138));
		addButton.setBorder(BorderFactory.createLineBorder(new Color(191, 163, 138)));

		deleteButton.setBackground(new Color(29, 35, 38));
		deleteButton.setForeground(new Color(191, 163, 138));
		deleteButton.setBorder(BorderFactory.createLineBorder(new Color(191, 163, 138)));

		searchButton.setBackground(new Color(29, 35, 38));
		searchButton.setForeground(new Color(191, 163, 138));
		searchButton.setBorder(BorderFactory.createLineBorder(new Color(191, 163, 138)));

		mainPanel.add(addButton);
		mainPanel.add(deleteButton);
		mainPanel.add(searchButton);

		/* Creating and adding our JPanel which will hold our stack elements*/
		listTextPanel = new JPanel();
		listTextPanel.setPreferredSize(new Dimension(850, 400));
		listTextPanel.setLayout(new GridLayout(5, 2)); // 5 rows and 2 columns for now
		listTextPanel.add(new JLabel("Test"));
		listTextPanel.add(new JLabel("Test"));
		listTextPanel.add(new JLabel("Test"));
		
		mainPanel.add(listTextPanel);

		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
