import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.*;

public class GroceryListFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	JPanel mainPanel;
	JLabel titleLabel;

	JButton addButton;
	JButton deleteButton;
	JButton searchButton;

	JTextArea listTextArea;
	JScrollPane listScrollPane;

	Stack<String> listItemsStack = new Stack<String>();

	URL groceryListIconURL = getClass().getResource("groceryList.png");

	public GroceryListFrame() {
		this.setTitle("Simple Grocery List");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(new ImageIcon(groceryListIconURL).getImage());

		/* Creating our JPanel and setting its attributes */
		mainPanel = new JPanel();
		mainPanel.setPreferredSize(new Dimension(1024, 768));
		mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
		mainPanel.setBackground(new Color(29, 35, 38));

		this.add(mainPanel);

		/* Adding our title label and setting its attributes */
		titleLabel = new JLabel("Simple Grocery List (Stacks)", JLabel.CENTER);
		titleLabel.setForeground(new Color(191, 163, 138));
		titleLabel.setFont(new Font(null, Font.BOLD, 48));
		titleLabel.setPreferredSize(new Dimension(850, 100));
		titleLabel.setBorder(BorderFactory.createDashedBorder(new Color(191, 163, 138)));

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

		/* Creating and adding our JPanel which will hold our stack elements */
		listTextArea = new JTextArea(12, 20);
		listTextArea.setBackground(new Color(29, 35, 38));
		listTextArea.setForeground(new Color(191, 163, 138));
		listTextArea.setBorder(BorderFactory.createDashedBorder(new Color(191, 163, 138)));
		listTextArea.setFont(new Font(null, Font.BOLD, 24));
		listTextArea.setEditable(false);
		listTextArea.setLineWrap(true);

		/* JScrollPane that will hold our JTextArea */
		listScrollPane = new JScrollPane(listTextArea);
		listScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		listScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		mainPanel.add(listScrollPane);

		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == addButton) {
			try {
				String newItem = JOptionPane.showInputDialog(null, "Enter item name to be added", "Add Item",
						JOptionPane.PLAIN_MESSAGE);

				if (newItem.length() == 0 || newItem == null) {
					JOptionPane.showMessageDialog(null, "Enter new item name!", "No Item Name",
							JOptionPane.WARNING_MESSAGE);
				} else {
					listItemsStack.add(newItem);

					listTextArea.setText("");
					for (int i = listItemsStack.size() - 1; i >= 0; i--) {
						listTextArea.append("   - " + listItemsStack.elementAt(i) + "\n");
					}
				}
			} catch (Exception e) {
				// Do nothing
			}
		}

		if (arg0.getSource() == deleteButton) {

			int confirmDelete = JOptionPane.showConfirmDialog(null, "Delete last added item?", "Confirm Delete",
					JOptionPane.WARNING_MESSAGE);

			if (confirmDelete == JOptionPane.YES_OPTION) {
				if (listItemsStack.size() == 0) {
					JOptionPane.showMessageDialog(null, "No items in list!", "No Items", JOptionPane.WARNING_MESSAGE);
				} else {
					listItemsStack.pop();

					listTextArea.setText("");
					for (int i = listItemsStack.size() - 1; i >= 0; i--) {
						listTextArea.append("   - " + listItemsStack.elementAt(i) + "\n");
					}
				}
			}

		}

		if (arg0.getSource() == searchButton) {
			try {
				String searchItem = JOptionPane.showInputDialog(null, "Enter item name", "Search Item",
						JOptionPane.PLAIN_MESSAGE);
				if (searchItem.length() == 0 || searchItem == null) {
					JOptionPane.showMessageDialog(null, "No item name entered", "No Item Name",
							JOptionPane.WARNING_MESSAGE);
				} else {
					if (listItemsStack.contains(searchItem)) {
						JOptionPane.showMessageDialog(null, "Item found in list!", "Item Found",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Item not found in list!", "Item Not Found",
								JOptionPane.WARNING_MESSAGE);
					}
				}
			} catch (Exception e) {
				// Do nothing
			}
		}
	}

}
