import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorPractice implements ActionListener {

	JFrame mainFrame;
	JTextField mainField;

	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[9];

	JPanel buttonPanel;

	JButton addButton, subButton, mulButton, divButton;
	JButton decButton, equButton, delButton, clrButton, negButton;

	Font myFont = new Font("Arial", Font.BOLD, 16);

	double num1, num2, numResult;
	char myOperator;

	public CalculatorPractice() {

		mainFrame = new JFrame();
		mainFrame.setTitle("[Calculator Practice]");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(500, 550);
		mainFrame.setLayout(null);

		mainField = new JTextField();
		mainField.setBounds(50, 25, 400, 75);
		mainField.setEditable(false);
		mainField.setFont(myFont);

		mainFrame.add(mainField);

		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("Del");
		clrButton = new JButton("Clear");
		negButton = new JButton("(-)");

		// Adding to functionButtons array
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = negButton;

		// Adding ActionLiseners to each of our functionButtons
		for (int i = 0; i < 9; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFocusable(false);
			functionButtons[i].setFont(myFont);
		}

		// Adding numbers to our numberButtons
		for (int i = 0; i < 10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFocusable(false);
			numberButtons[i].setFont(myFont);
		}

		// Adding negButton, delButton, and clrButton at the end
		negButton.setBounds(50, 420, 100, 50);
		delButton.setBounds(150, 420, 100, 50);
		clrButton.setBounds(250, 420, 100, 50);

		mainFrame.add(negButton);
		mainFrame.add(delButton);
		mainFrame.add(clrButton);

		// Creating our buttonPanel to hold our JButtons
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));
		buttonPanel.setBounds(50, 110, 400, 300);
//		buttonPanel.setBackground(Color.GRAY);

		buttonPanel.add(numberButtons[1]);
		buttonPanel.add(numberButtons[2]);
		buttonPanel.add(numberButtons[3]);
		buttonPanel.add(addButton);
		buttonPanel.add(numberButtons[4]);
		buttonPanel.add(numberButtons[5]);
		buttonPanel.add(numberButtons[6]);
		buttonPanel.add(subButton);
		buttonPanel.add(numberButtons[7]);
		buttonPanel.add(numberButtons[8]);
		buttonPanel.add(numberButtons[9]);
		buttonPanel.add(mulButton);
		buttonPanel.add(decButton);
		buttonPanel.add(numberButtons[0]);
		buttonPanel.add(equButton);
		buttonPanel.add(divButton);

		mainFrame.add(buttonPanel);

		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		for (int i = 0; i < numberButtons.length; i++) {
			if (arg0.getSource() == numberButtons[i]) {
				mainField.setText(mainField.getText().concat(String.valueOf(i)));
			}
		}

		if (arg0.getSource() == addButton) {
			num1 = Double.parseDouble(mainField.getText());
			myOperator = '+';
			mainField.setText("");
		}

		if (arg0.getSource() == subButton) {
			num1 = Double.parseDouble(mainField.getText());
			myOperator = '-';
			mainField.setText("");
		}

		if (arg0.getSource() == mulButton) {
			num1 = Double.parseDouble(mainField.getText());
			myOperator = '*';
			mainField.setText("");
		}

		if (arg0.getSource() == divButton) {
			num1 = Double.parseDouble(mainField.getText());
			myOperator = '/';
			mainField.setText("");
		}

		if (arg0.getSource() == decButton) {
			mainField.setText(mainField.getText().concat("."));
		}

		if (arg0.getSource() == equButton) {

			num2 = Double.parseDouble(mainField.getText());

			switch (myOperator) {

			case '+':
				numResult = num1 + num2;
				break;

			case '-':
				numResult = num1 - num2;
				break;

			case '*':
				numResult = num1 * num2;
				break;

			case '/':
				numResult = num1 / num2;
				break;

			}

			mainField.setText(String.valueOf(numResult));
			num1 = numResult; // store numResult in num1, for follow up calculations

		}

		if (arg0.getSource() == delButton) {
			String tempString = mainField.getText();
			mainField.setText("");
			for (int i = 0; i < tempString.length() - 1; i++) {
				mainField.setText(mainField.getText() + tempString.charAt(i));
			}
		}

		if (arg0.getSource() == clrButton) {
			mainField.setText("");
		}

		if (arg0.getSource() == negButton) {
			double negNum = Double.parseDouble(mainField.getText());
			negNum *= -1;
			mainField.setText(String.valueOf(negNum));
		}

	}

	public static void main(String[] args) {
		new CalculatorPractice();
	}

}
