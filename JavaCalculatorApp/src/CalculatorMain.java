import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorMain implements ActionListener {

	JFrame mainFrame;
	JTextField mainField;
	JButton[] numberButtons = new JButton[10]; // array that will hold our number buttons
	JButton[] functionButtons = new JButton[9]; // array that will hold our function buttons

	// Creating our JButtons for our functionButtons array
	JButton addButton, subButton, mulButton, divButton;
	JButton decButton, equButton, delButton, clrButton, negButton;

	// JPanel that will hold all of our buttons
	JPanel buttonPanel;

	// Creating our custom font so that we could reuse it easily for our program
	Font myFont = new Font("Arial", Font.BOLD, 18);

	// double values that will store the first entered number, second entered
	// number, and our result
	double num1 = 0, num2 = 0, numResult = 0;
	// char to store the user's operator
	char myOperator;

	// Constructor for our class
	public CalculatorMain() {

		// Creating our JFrame / mainFrame
		mainFrame = new JFrame();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setTitle("[Java Calculator App]");
		mainFrame.setSize(420, 550);
		mainFrame.setLayout(null);

		// Creating our JTextField / mainField
		mainField = new JTextField();
		mainField.setBounds(50, 25, 300, 50);
		mainField.setFont(myFont); // using declared Font
		mainField.setEditable(false);

		mainFrame.add(mainField);

		// Creating our JButtons for our functionButtons array
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("Delete");
		clrButton = new JButton("Clr");
		negButton = new JButton("(-)");

		// Adding our buttons to functionButtons, for easier modification
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = negButton;

		// Adding ActionListeners to each of our buttons, also setFont and setFocusable
		for (int i = 0; i < 9; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
		}

		// Adding numbers to our numberButtons array
		for (int i = 0; i < 10; i++) {
			// Create button and set text to i
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
		}

		// negButton, delButton, and clrButton will have their own custom bounds and
		// will be at the bottom of our mainFrame
		negButton.setBounds(50, 430, 100, 50);
		delButton.setBounds(150, 430, 100, 50);
		clrButton.setBounds(250, 430, 100, 50);

		mainFrame.add(negButton);
		mainFrame.add(delButton);
		mainFrame.add(clrButton);

		// Creating our JPanel to hold our different buttons
		buttonPanel = new JPanel();
		buttonPanel.setBounds(50, 100, 300, 300);
		buttonPanel.setLayout(new GridLayout(4, 4, 10, 20)); // rows, columns, x (between columns), y (between rows)
//		buttonPanel.setBackground(Color.GRAY);

		// Adding functionButtons and numberButtons to our JPanel
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

	public void actionPerformed(ActionEvent arg0) {

		// Check if the user pressed any of our number buttons
		for (int i = 0; i < 10; i++) {
			if (arg0.getSource() == numberButtons[i]) {
				// Adding our pressed button to our mainField
				mainField.setText(mainField.getText().concat(String.valueOf(i)));
			}
		}

		if (arg0.getSource() == decButton) {
			// Adding a dot to our mainField contents
			mainField.setText(mainField.getText().concat("."));
		}

		if (arg0.getSource() == addButton) {
			// Set num1 to current number in our mainField
			num1 = Double.parseDouble(mainField.getText());
			// Set our operator to '+'
			myOperator = '+';
			// Reset the contents of our mainField
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

		if (arg0.getSource() == equButton) {
			// Set num2 to current mainField contents
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
			num1 = numResult; // replace num1 with current result, for subsequent usage

		}

		if (arg0.getSource() == clrButton) {
			mainField.setText("");
		}

		if (arg0.getSource() == delButton) {
			String tempString = mainField.getText();
			mainField.setText("");
			// iterating through our current String, stops before the last character
			for (int i = 0; i < tempString.length() - 1; i++) {
				mainField.setText(mainField.getText() + tempString.charAt(i));
			}
		}

		if (arg0.getSource() == negButton) {
			// Making currently entered number into a negative number
			double tempNum = Double.parseDouble(mainField.getText());
			tempNum *= -1;
			mainField.setText(String.valueOf(tempNum));
		}

	}

	public static void main(String[] args) {

		// Calling the constructor for the class that we are in right now
		new CalculatorMain();

	}

}
