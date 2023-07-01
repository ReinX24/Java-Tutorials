import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Quiz implements ActionListener {

	// Array that contains the questions for our program
	String[] questionsArr = {
			"Which company created Java?",
			"Which year was Java created?",
			"What was Java originally called?",
			"Who is credited with creating Java?"
	};

	// 2D array that contains the different choices for each question
	String[][] optionsArr = {
			{"Sun Microsystems", "Starbucks", "Microsoft", "Alphabet"},
			{"1989", "1996", "1972", "1492"},
			{"Apple", "Latte", "Oak", "Koffing"},
			{"Steve Jobs", "Bill Gates", "James Gosling", "Mark Zuckerberg"}
	};

	// Array containing the letter of the correct answers for each question
	char[] answerArr = {
			'A', 
			'B', 
			'C',
			'C'
	};
	
	char userGuess;
	char questionAnswer;
	int indexNum;
	int correctGuesses = 0;
	int totalQuestions = questionsArr.length;
	int resultNum;
	int secondNum = 10; // 10 seconds

	JFrame mainFrame = new JFrame();
	JTextField questionField = new JTextField();
	JTextArea questionArea = new JTextArea();

	JButton buttonA = new JButton();
	JButton buttonB = new JButton();
	JButton buttonC = new JButton();
	JButton buttonD = new JButton();

	JLabel answerLabelA = new JLabel();
	JLabel answerLabelB = new JLabel();
	JLabel answerLabelC = new JLabel();
	JLabel answerLabelD = new JLabel();

	JLabel timerLabel = new JLabel();
	JLabel secondsLeftLabel = new JLabel();
	JTextField numberRightAnswerField = new JTextField();
	JTextField percentageCorrectField = new JTextField();

	public Quiz() {
		mainFrame.setTitle("Java Quiz Game");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(650, 650);
		mainFrame.getContentPane().setBackground(new Color(50, 50, 50));
		mainFrame.setLayout(null);
		mainFrame.setResizable(false);

		questionField.setBounds(0, 0, 650, 50);
		questionField.setBackground(new Color(25, 25, 25, 25));
		questionField.setForeground(new Color(25, 255, 0));
		questionField.setFont(new Font("Ink Free", Font.PLAIN, 30));
		questionField.setBorder(BorderFactory.createBevelBorder(1));
		questionField.setHorizontalAlignment(JTextField.CENTER);
		questionField.setEditable(false);

		mainFrame.add(questionField);

		questionArea.setBounds(0, 50, 650, 50);
		questionArea.setLineWrap(true);
		questionArea.setWrapStyleWord(true);
		questionArea.setBackground(new Color(25, 25, 25, 25));
		questionArea.setForeground(new Color(25, 255, 0));
		questionArea.setFont(new Font("MV Boli", Font.PLAIN, 30));
		questionArea.setBorder(BorderFactory.createBevelBorder(1));
		questionArea.setEditable(false);

		mainFrame.add(questionArea);

		buttonA.setBounds(0, 100, 100, 100);
		buttonA.setFont(new Font("MV Boli", Font.BOLD, 35));
		buttonA.setFocusable(false);
		buttonA.addActionListener(this);
		buttonA.setText("A");

		buttonB.setBounds(0, 200, 100, 100);
		buttonB.setFont(new Font("MV Boli", Font.BOLD, 35));
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		buttonB.setText("B");

		buttonC.setBounds(0, 300, 100, 100);
		buttonC.setFont(new Font("MV Boli", Font.BOLD, 35));
		buttonC.setFocusable(false);
		buttonC.addActionListener(this);
		buttonC.setText("C");

		buttonD.setBounds(0, 400, 100, 100);
		buttonD.setFont(new Font("MV Boli", Font.BOLD, 35));
		buttonD.setFocusable(false);
		buttonD.addActionListener(this);
		buttonD.setText("D");

		mainFrame.add(buttonA);
		mainFrame.add(buttonB);
		mainFrame.add(buttonC);
		mainFrame.add(buttonD);

		answerLabelA.setBounds(125, 100, 500, 100);
		answerLabelA.setBackground(new Color(50, 50, 50, 50));
		answerLabelA.setForeground(new Color(25, 255, 0));
		answerLabelA.setFont(new Font("MV Boli", Font.PLAIN, 35));

		answerLabelB.setBounds(125, 200, 500, 100);
		answerLabelB.setBackground(new Color(50, 50, 50, 50));
		answerLabelB.setForeground(new Color(25, 255, 0));
		answerLabelB.setFont(new Font("MV Boli", Font.PLAIN, 35));

		answerLabelC.setBounds(125, 300, 500, 100);
		answerLabelC.setBackground(new Color(50, 50, 50, 50));
		answerLabelC.setForeground(new Color(25, 255, 0));
		answerLabelC.setFont(new Font("MV Boli", Font.PLAIN, 35));

		answerLabelD.setBounds(125, 400, 500, 100);
		answerLabelD.setBackground(new Color(50, 50, 50, 50));
		answerLabelD.setForeground(new Color(25, 255, 0));
		answerLabelD.setFont(new Font("MV Boli", Font.PLAIN, 35));

		mainFrame.add(answerLabelA);
		mainFrame.add(answerLabelB);
		mainFrame.add(answerLabelC);
		mainFrame.add(answerLabelD);

		secondsLeftLabel.setBounds(535, 510, 100, 100);
		secondsLeftLabel.setBackground(new Color(25, 25, 25, 25));
		secondsLeftLabel.setForeground(new Color(255, 0, 0));
		secondsLeftLabel.setFont(new Font("Ink Free", Font.BOLD, 60));
		secondsLeftLabel.setBorder(BorderFactory.createBevelBorder(1));
		secondsLeftLabel.setOpaque(true);
		secondsLeftLabel.setHorizontalAlignment(JTextField.CENTER);
		secondsLeftLabel.setText(String.valueOf(secondNum));
		
		mainFrame.add(secondsLeftLabel);
		// TODO: resume at 35:24

		mainFrame.setVisible(true);
	}

	public void nextQuestion() {

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

	public void displayAnswer() {

	}

	public void displayResults() {

	}

}
