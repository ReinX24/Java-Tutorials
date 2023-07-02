import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Quiz implements ActionListener {

	// Array that contains the questions for our program
	String[] questionsArr = {
			"Which company created Java?",
			"Which year was Java created?",
			"What was Java originally called?",
			"Who is credited with creating Java?",
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
	char userAnswer;
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

	Timer quizTimer = new Timer(1000, new ActionListener() {

		// Executes every second (1000ms)
		@Override
		public void actionPerformed(ActionEvent arg0) {
			secondNum--;
			secondsLeftLabel.setText(String.valueOf(secondNum));

			if (secondNum <= 0) {
				displayAnswer(); // displays the answer and disables all buttons, also automatically moves to the
									// next question
			}
		}
	});

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

		timerLabel.setBounds(535, 475, 100, 100);
		timerLabel.setBackground(new Color(50, 50, 50));
		timerLabel.setForeground(new Color(255, 0, 0));
		timerLabel.setFont(new Font("MV Boli", Font.PLAIN, 16));
		timerLabel.setHorizontalAlignment(JLabel.CENTER);
		timerLabel.setText("Timer >:D");

		mainFrame.add(timerLabel);

		// Shows the number of questions that we got right
		numberRightAnswerField.setBounds(225, 225, 200, 100);
		numberRightAnswerField.setBackground(new Color(25, 25, 25));
		numberRightAnswerField.setForeground(new Color(25, 255, 0));
		numberRightAnswerField.setFont(new Font("Ink Free", Font.BOLD, 50));
		numberRightAnswerField.setBorder(BorderFactory.createBevelBorder(1));
		numberRightAnswerField.setHorizontalAlignment(JTextField.CENTER);
		numberRightAnswerField.setEditable(false);

		// Shows the percentage of how much correct answers we got
		percentageCorrectField.setBounds(225, 325, 200, 100);
		percentageCorrectField.setBackground(new Color(25, 25, 25));
		percentageCorrectField.setForeground(new Color(25, 255, 0));
		percentageCorrectField.setFont(new Font("Ink Free", Font.BOLD, 50));
		percentageCorrectField.setBorder(BorderFactory.createBevelBorder(1));
		percentageCorrectField.setHorizontalAlignment(JTextField.CENTER);
		percentageCorrectField.setEditable(false);

		mainFrame.setVisible(true);

		nextQuestion();
	}

	public void nextQuestion() {
		if (indexNum >= totalQuestions) {
			displayResults();
		} else {
			questionField.setText("Question " + (indexNum + 1));
			// Getting the current iterated question in questionsArr
			questionArea.setText(questionsArr[indexNum]);

			// Getting the corresponding choices of the question in questionArea
			answerLabelA.setText(optionsArr[indexNum][0]);
			answerLabelB.setText(optionsArr[indexNum][1]);
			answerLabelC.setText(optionsArr[indexNum][2]);
			answerLabelD.setText(optionsArr[indexNum][3]);

			quizTimer.start(); // timer starts once the programs is ran or the nextQuestion method is called
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		// Disables all the buttons when we click on a button that we choose as our
		// answer
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);

		// Checks if the button that the user pressed is the answer to the current
		// question
		if (arg0.getSource() == buttonA) {
			userAnswer = 'A';
			if (userAnswer == answerArr[indexNum]) {
				correctGuesses++;
			}
		}

		if (arg0.getSource() == buttonB) {
			userAnswer = 'B';
			if (userAnswer == answerArr[indexNum]) {
				correctGuesses++;
			}
		}

		if (arg0.getSource() == buttonC) {
			userAnswer = 'C';
			if (userAnswer == answerArr[indexNum]) {
				correctGuesses++;
			}
		}

		if (arg0.getSource() == buttonD) {
			userAnswer = 'D';
			if (userAnswer == answerArr[indexNum]) {
				correctGuesses++;
			}
		}

		displayAnswer();

	}

	public void displayAnswer() {

		quizTimer.stop(); // the timer stops once the user chooses an answer

		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);

		// if the current answer is not A, change the foreground / text color to red
		if (answerArr[indexNum] != 'A') {
			answerLabelA.setForeground(new Color(255, 0, 0));
		}

		if (answerArr[indexNum] != 'B') {
			answerLabelB.setForeground(new Color(255, 0, 0));
		}

		if (answerArr[indexNum] != 'C') {
			answerLabelC.setForeground(new Color(255, 0, 0));
		}

		if (answerArr[indexNum] != 'D') {
			answerLabelD.setForeground(new Color(255, 0, 0));
		}

		// Timer object for pausing the program after displaying the correct answer
		Timer pauseTimer = new Timer(2000, new ActionListener() {

			// After 2 seconds (2000), perform the function below
			@Override
			public void actionPerformed(ActionEvent arg0) {
				answerLabelA.setForeground(new Color(25, 255, 0));
				answerLabelB.setForeground(new Color(25, 255, 0));
				answerLabelC.setForeground(new Color(25, 255, 0));
				answerLabelD.setForeground(new Color(25, 255, 0));

				userAnswer = ' ';
				secondNum = 10;
				secondsLeftLabel.setText(String.valueOf(secondNum));

				buttonA.setEnabled(true);
				buttonB.setEnabled(true);
				buttonC.setEnabled(true);
				buttonD.setEnabled(true);
				indexNum++;
				nextQuestion();
			}
		});

		pauseTimer.setRepeats(false); // makes sure that pauseTimer only runs once
		pauseTimer.start();

	}

	public void displayResults() {

		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);

		resultNum = (int) ((correctGuesses / (double) totalQuestions) * 100);

		questionField.setText("RESULTS!");
		questionArea.setText("");

		answerLabelA.setText("");
		answerLabelB.setText("");
		answerLabelC.setText("");
		answerLabelD.setText("");

		numberRightAnswerField.setText("(" + correctGuesses + "/" + totalQuestions + ")");
		percentageCorrectField.setText(resultNum + "%");

		mainFrame.add(numberRightAnswerField);
		mainFrame.add(percentageCorrectField);

	}

}
