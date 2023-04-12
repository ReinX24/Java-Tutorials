
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
		leftPanel.setBounds(10, 40, 240, 350);
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
		customerField.setBounds(135, 40, 100, 20);

		leftPanel.add(customerLabel);
		leftPanel.add(customerField);
		
		quantityLabel = new JLabel("Quantity:");
		quantityLabel.setBounds(10, 70, 80, 20);
		
		quantityField = new JTextField();
		quantityField.setBounds(100, 70, 100, 20);
		
		leftPanel.add(quantityLabel);
		leftPanel.add(quantityField);
		
		rightPanel = new JPanel();
		rightPanel.setBounds(260, 40, 230, 350);
		rightPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		this.add(titleLabel);
		this.add(leftPanel);
		this.add(rightPanel);

		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {

	}

}
