
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BillingFrame extends JFrame implements ActionListener {

	JLabel titleLabel;
	JPanel leftPanel;
	JPanel rightPanel;

	JLabel orderLabel;
	JTextField orderField;

	JLabel customerLabel;
	JTextField customerField;

	JLabel quantityLabel;
	JTextField quantityField;

	JLabel pizzaTypeLabel;
	JPanel pizzaTypePanel;

	ButtonGroup typeButtonGroup;
	JRadioButton panButton;
	JRadioButton stuffedButton;
	JRadioButton regularButton;

	JLabel rateLabel;
	JTextField rateField;

	JLabel amountLabel;
	JTextField amountField;

	JLabel toppingLabel;
	JTextField toppingField;

	JLabel toppingPanelLabel;
	JPanel toppingPanel;

	JCheckBox onionBox;
	JCheckBox cheeseBox;
	JCheckBox tomatoBox;
	JCheckBox cornBox;

	JButton billButton;
	JButton clearButton;

	JTextArea billArea;

	public BillingFrame() {
		this.setTitle("[Pizza Billing Calculator]");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		this.getContentPane().setBackground(new Color(0, 128, 128));

		titleLabel = new JLabel("Pizza Bill Calculator");
		titleLabel.setBounds(100, 10, 300, 20);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		titleLabel.setOpaque(true);
		titleLabel.setForeground(Color.BLACK);
		titleLabel.setBackground(Color.WHITE);

		leftPanel = new JPanel();
		leftPanel.setBounds(5, 40, 240, 260);
		leftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		leftPanel.setLayout(null);

		orderLabel = new JLabel("Order No:");
		orderLabel.setBounds(10, 10, 80, 20);

		orderField = new JTextField();
		orderField.setBounds(100, 10, 90, 20);

		leftPanel.add(orderLabel);
		leftPanel.add(orderField);

		customerLabel = new JLabel("Customer Name:");
		customerLabel.setBounds(10, 40, 120, 20);

		customerField = new JTextField();
		customerField.setBounds(135, 40, 90, 20);

		leftPanel.add(customerLabel);
		leftPanel.add(customerField);

		quantityLabel = new JLabel("Quantity:");
		quantityLabel.setBounds(10, 70, 80, 20);

		quantityField = new JTextField();
		quantityField.setBounds(100, 70, 100, 20);

		leftPanel.add(quantityLabel);
		leftPanel.add(quantityField);

		pizzaTypeLabel = new JLabel("Pizza Type");
		pizzaTypeLabel.setBounds(10, 100, 80, 20);

		pizzaTypePanel = new JPanel();
		pizzaTypePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		pizzaTypePanel.setBounds(10, 130, 220, 110);
		pizzaTypePanel.setLayout(new GridLayout(3, 1));

		typeButtonGroup = new ButtonGroup();

		panButton = new JRadioButton("Pan Pizza");
		panButton.setFocusable(false);

		stuffedButton = new JRadioButton("Stuffed Crust");
		stuffedButton.setFocusable(false);

		regularButton = new JRadioButton("Regular");
		regularButton.setFocusable(false);

		typeButtonGroup.add(panButton);
		typeButtonGroup.add(stuffedButton);
		typeButtonGroup.add(regularButton);

		pizzaTypePanel.add(panButton);
		pizzaTypePanel.add(stuffedButton);
		pizzaTypePanel.add(regularButton);

		leftPanel.add(pizzaTypeLabel);
		leftPanel.add(pizzaTypePanel);

		rightPanel = new JPanel();
		rightPanel.setBounds(255, 40, 240, 260);
		rightPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		rightPanel.setLayout(null);

		rateLabel = new JLabel("Rate:");
		rateLabel.setBounds(10, 10, 80, 20);

		rateField = new JTextField();
		rateField.setBounds(60, 10, 90, 20);

		rightPanel.add(rateLabel);
		rightPanel.add(rateField);

		amountLabel = new JLabel("Amount:");
		amountLabel.setBounds(10, 40, 120, 20);

		amountField = new JTextField();
		amountField.setBounds(80, 40, 100, 20);

		rightPanel.add(amountLabel);
		rightPanel.add(amountField);

		toppingLabel = new JLabel("Cost Of Toppings:");
		toppingLabel.setBounds(10, 70, 140, 20);

		toppingField = new JTextField();
		toppingField.setBounds(140, 70, 70, 20);

		rightPanel.add(toppingLabel);
		rightPanel.add(toppingField);

		toppingPanelLabel = new JLabel("Toppings");
		toppingPanelLabel.setBounds(10, 100, 80, 20);

		toppingPanel = new JPanel();
		toppingPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		toppingPanel.setBounds(10, 130, 220, 110);
		toppingPanel.setLayout(new GridLayout(4, 1));

		onionBox = new JCheckBox("Onion");
		onionBox.setFocusable(false);

		cheeseBox = new JCheckBox("Cheese");
		cheeseBox.setFocusable(false);

		tomatoBox = new JCheckBox("Tomato");
		tomatoBox.setFocusable(false);

		cornBox = new JCheckBox("Baby Corn");
		cornBox.setFocusable(false);

		toppingPanel.add(onionBox);
		toppingPanel.add(cheeseBox);
		toppingPanel.add(tomatoBox);
		toppingPanel.add(cornBox);

		rightPanel.add(toppingPanelLabel);
		rightPanel.add(toppingPanel);

		billButton = new JButton("Generate Bill");
		billButton.setBounds(5, 310, 160, 30);
		billButton.setFocusable(false);
		billButton.addActionListener(this);

		clearButton = new JButton("Clear");
		clearButton.setBounds(335, 310, 160, 30);
		clearButton.setFocusable(false);
		clearButton.addActionListener(this);

		billArea = new JTextArea();
		billArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		billArea.setBounds(5, 345, 490, 120);

		this.add(titleLabel);
		this.add(leftPanel);
		this.add(rightPanel);

		this.add(billButton);
		this.add(clearButton);

		this.add(billArea);

		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == clearButton) {
			billArea.setText("");
		} else if (arg0.getSource() == billButton) {

			String pizzaType = "";

			if (panButton.isSelected()) {
				pizzaType = panButton.getText();
			} else if (stuffedButton.isSelected()) {
				pizzaType = stuffedButton.getText();
			} else if (regularButton.isSelected()) {
				pizzaType = regularButton.getText();
			}

			String orderInfo = "";

			orderInfo += "\nOrder Number: " + orderField.getText();
			orderInfo += "\nCustomer Name: " + customerField.getText();
			orderInfo += "\nQuantity: " + quantityField.getText();
			orderInfo += "\nPizza Type: " + pizzaType;
			orderInfo += "\nRate Amount: " + rateField.getText();
			orderInfo += "\nAmount: " + amountField.getText();
			orderInfo += "\nCost Of Toppings: " + toppingField.getText();

			billArea.setText(orderInfo);

		}
	}

}
