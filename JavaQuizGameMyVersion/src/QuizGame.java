import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class QuizGame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	String[] quizQuestions = {
								"When was Valorant first released for beta testing?",
								"What is the biggest map made for Valorant?",
								"Who were the first two agents added to the Valorant Protocol?",
								"What is the name of the free gun given once your agent spawns?"
	};
	
	String[][] quizQuestionsChoices = { // A, D, B, C
								{"April 7, 2020", "August 12, 2020", "January 23, 2020", "December 27, 2019"},
								{"Bind", "Ascent", "Haven", "Breeze"},
								{"Phoenix and Killjoy", "Brimstone and Viper", "Sova and Omen", "Raze and Jett"},
								{"Pea Shooter", "Glock", "Classic", "Hand Gun"}
	};
	
	char[] quizChoicesAnswers = {
							'A',
							'D',
							'B',
							'C'
	};
	
	char userAnswer;
	int currentQuestionIndex;
	int correctGuesses = 0;
	int totalQuestions = quizQuestions.length;
	int resultNum;
	int secondsNum = 10;

	JPanel mainPanel = new JPanel();

	JTextField questionNumberField = new JTextField();
	JTextArea questionStringArea = new JTextArea();

	JButton answerButtonA = new JButton("A");
	JButton answerButtonB = new JButton("B");
	JButton answerButtonC = new JButton("C");
	JButton answerButtonD = new JButton("D");

	JLabel choicesLabelA = new JLabel();
	JLabel choicesLabelB = new JLabel();
	JLabel choicesLabelC = new JLabel();
	JLabel choicesLabelD = new JLabel();

	JLabel timeLeftMessageLabel = new JLabel();
	JLabel secondsLeftLabel = new JLabel();

	JTextField correctAnswersAmountField = new JTextField();
	JTextField correctAnswersPercentageField = new JTextField();

	Timer quizTimer = new Timer(1000, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			secondsNum--; // -1 second for every second
			secondsLeftLabel.setText(String.valueOf(secondsNum));

			if (secondsNum <= 3) {
				secondsLeftLabel.setForeground(Color.RED); // changes number color to red if there are 3 seconds left
			}

			if (secondsNum <= 0) {
				// If there is not time left, display the answer and go to the next question
				// automatically
				displayAnswer();
			}
		}
	});

	public QuizGame() {

		this.setTitle("Java Quiz Game (Valorant Edition)");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		mainPanel.setPreferredSize(new Dimension(1024, 768));
		mainPanel.setBackground(Color.LIGHT_GRAY);
		mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

		questionNumberField.setPreferredSize(new Dimension(900, 100));
		questionNumberField.setBackground(Color.GRAY);
		questionNumberField.setForeground(Color.WHITE);
		questionNumberField.setFont(new Font(null, Font.BOLD, 30));
		questionNumberField.setBorder(BorderFactory.createBevelBorder(1));
		questionNumberField.setHorizontalAlignment(JTextField.CENTER);
		questionNumberField.setEditable(false);

		mainPanel.add(questionNumberField);

		questionStringArea.setPreferredSize(new Dimension(900, 100));
		questionStringArea.setBackground(Color.GRAY);
		questionStringArea.setForeground(Color.WHITE);
		questionStringArea.setFont(new Font(null, Font.BOLD, 30));
		questionStringArea.setBorder(BorderFactory.createBevelBorder(1));
		questionStringArea.setEditable(false);
		questionStringArea.setLineWrap(true);
		questionStringArea.setWrapStyleWord(true);

		mainPanel.add(questionStringArea);

		answerButtonA.addActionListener(this);
		answerButtonA.setPreferredSize(new Dimension(200, 100));
		answerButtonA.setFocusable(false);
		answerButtonA.setBackground(new Color(0, 128, 128));
		answerButtonA.setForeground(Color.WHITE);
		answerButtonA.setBorder(BorderFactory.createRaisedBevelBorder());
		answerButtonA.setFont(new Font(null, Font.BOLD, 26));

		mainPanel.add(answerButtonA);

		choicesLabelA.setPreferredSize(new Dimension(700, 100));
		choicesLabelA.setBackground(Color.GRAY);
		choicesLabelA.setForeground(Color.WHITE);
		choicesLabelA.setOpaque(true);
		choicesLabelA.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		choicesLabelA.setFont(new Font(null, Font.BOLD, 26));
		choicesLabelA.setHorizontalAlignment(JLabel.CENTER);

		mainPanel.add(choicesLabelA);

		answerButtonB.addActionListener(this);
		answerButtonB.setPreferredSize(new Dimension(200, 100));
		answerButtonB.setFocusable(false);
		answerButtonB.setBackground(new Color(255, 128, 0));
		answerButtonB.setForeground(Color.WHITE);
		answerButtonB.setBorder(BorderFactory.createRaisedBevelBorder());
		answerButtonB.setFont(new Font(null, Font.BOLD, 26));

		mainPanel.add(answerButtonB);

		choicesLabelB.setPreferredSize(new Dimension(700, 100));
		choicesLabelB.setBackground(Color.GRAY);
		choicesLabelB.setForeground(Color.WHITE);
		choicesLabelB.setOpaque(true);
		choicesLabelB.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		choicesLabelB.setFont(new Font(null, Font.BOLD, 26));
		choicesLabelB.setHorizontalAlignment(JLabel.CENTER);

		mainPanel.add(choicesLabelB);

		answerButtonC.addActionListener(this);
		answerButtonC.setPreferredSize(new Dimension(200, 100));
		answerButtonC.setFocusable(false);
		answerButtonC.setBackground(new Color(227, 34, 39));
		answerButtonC.setForeground(Color.WHITE);
		answerButtonC.setBorder(BorderFactory.createRaisedBevelBorder());
		answerButtonC.setFont(new Font(null, Font.BOLD, 26));

		mainPanel.add(answerButtonC);

		choicesLabelC.setPreferredSize(new Dimension(700, 100));
		choicesLabelC.setBackground(Color.GRAY);
		choicesLabelC.setForeground(Color.WHITE);
		choicesLabelC.setOpaque(true);
		choicesLabelC.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		choicesLabelC.setFont(new Font(null, Font.BOLD, 26));
		choicesLabelC.setHorizontalAlignment(JLabel.CENTER);

		mainPanel.add(choicesLabelC);

		answerButtonD.addActionListener(this);
		answerButtonD.setPreferredSize(new Dimension(200, 100));
		answerButtonD.setFocusable(false);
		answerButtonD.setBackground(new Color(255, 215, 0));
		answerButtonD.setForeground(Color.WHITE);
		answerButtonD.setBorder(BorderFactory.createRaisedBevelBorder());
		answerButtonD.setFont(new Font(null, Font.BOLD, 26));

		mainPanel.add(answerButtonD);

		choicesLabelD.setPreferredSize(new Dimension(700, 100));
		choicesLabelD.setBackground(Color.GRAY);
		choicesLabelD.setForeground(Color.WHITE);
		choicesLabelD.setOpaque(true);
		choicesLabelD.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		choicesLabelD.setFont(new Font(null, Font.BOLD, 26));
		choicesLabelD.setHorizontalAlignment(JLabel.CENTER);

		mainPanel.add(choicesLabelD);

		timeLeftMessageLabel.setText("TIME LEFT: ");
		timeLeftMessageLabel.setFont(new Font(null, Font.BOLD, 30));
		timeLeftMessageLabel.setPreferredSize(new Dimension(850, 50));
		timeLeftMessageLabel.setHorizontalAlignment(JLabel.RIGHT);

		mainPanel.add(timeLeftMessageLabel);

		secondsLeftLabel.setText(String.valueOf(secondsNum));
		secondsLeftLabel.setFont(new Font(null, Font.BOLD, 30));
		secondsLeftLabel.setPreferredSize(new Dimension(50, 50));
		secondsLeftLabel.setHorizontalAlignment(JLabel.RIGHT);

		mainPanel.add(secondsLeftLabel);

		this.add(mainPanel);

		this.pack();
		this.setVisible(true);

		nextQuestion();

	}

	public void nextQuestion() {
		
//		displayResults(); // TODO: remove later, for debugging
		
		// If we are out of questions, display results
		if (currentQuestionIndex >= totalQuestions) {
			displayResults();
		} else { // If we still have remaining questions, display question and choices
			questionNumberField.setText("Question #" + (currentQuestionIndex + 1));
			questionStringArea.setText(quizQuestions[currentQuestionIndex]);

			choicesLabelA.setText(quizQuestionsChoices[currentQuestionIndex][0]);
			choicesLabelB.setText(quizQuestionsChoices[currentQuestionIndex][1]);
			choicesLabelC.setText(quizQuestionsChoices[currentQuestionIndex][2]);
			choicesLabelD.setText(quizQuestionsChoices[currentQuestionIndex][3]);

			quizTimer.start(); // starts 10 second timer
		}

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		// Disable all buttons when a button is pressed
		answerButtonA.setEnabled(false);
		answerButtonB.setEnabled(false);
		answerButtonC.setEnabled(false);
		answerButtonD.setEnabled(false);

		if (arg0.getSource() == answerButtonA) {
			userAnswer = 'A';
			if (userAnswer == quizChoicesAnswers[currentQuestionIndex]) {
				correctGuesses++;
			}
		}

		if (arg0.getSource() == answerButtonB) {
			userAnswer = 'B';
			if (userAnswer == quizChoicesAnswers[currentQuestionIndex]) {
				correctGuesses++;
			}
		}

		if (arg0.getSource() == answerButtonC) {
			userAnswer = 'C';
			if (userAnswer == quizChoicesAnswers[currentQuestionIndex]) {
				correctGuesses++;
			}
		}

		if (arg0.getSource() == answerButtonD) {
			userAnswer = 'D';
			if (userAnswer == quizChoicesAnswers[currentQuestionIndex]) {
				correctGuesses++;
			}
		}

		displayAnswer();

	}

	public void displayAnswer() {

		quizTimer.stop();

		answerButtonA.setEnabled(false);
		answerButtonB.setEnabled(false);
		answerButtonC.setEnabled(false);
		answerButtonD.setEnabled(false);

		if (quizChoicesAnswers[currentQuestionIndex] != 'A') {
			choicesLabelA.setForeground(Color.RED);
		}

		if (quizChoicesAnswers[currentQuestionIndex] != 'B') {
			choicesLabelB.setForeground(Color.RED);
		}

		if (quizChoicesAnswers[currentQuestionIndex] != 'C') {
			choicesLabelC.setForeground(Color.RED);
		}

		if (quizChoicesAnswers[currentQuestionIndex] != 'D') {
			choicesLabelD.setForeground(Color.RED);
		}

		// After it displays the answers, pause for 2 seconds before going to the next
		// question
		Timer pauserTimer = new Timer(2000, new ActionListener() {

			// After 2 seconds, execute actionPerformed method
			@Override
			public void actionPerformed(ActionEvent arg0) {
				choicesLabelA.setForeground(Color.WHITE);
				choicesLabelB.setForeground(Color.WHITE);
				choicesLabelC.setForeground(Color.WHITE);
				choicesLabelD.setForeground(Color.WHITE);

				userAnswer = ' '; // resets user's answer
				secondsNum = 10; // reset timer to 10
				secondsLeftLabel.setText(String.valueOf(secondsNum));

				answerButtonA.setEnabled(true);
				answerButtonB.setEnabled(true);
				answerButtonC.setEnabled(true);
				answerButtonD.setEnabled(true);
				currentQuestionIndex++; // go to next question
				nextQuestion();
			}
		});

		pauserTimer.setRepeats(false);
		pauserTimer.start();

	}

	public void displayResults() {
		
		// TODO: when showing results, remove all components with 2 textfields showing score and score percentage
		mainPanel.remove(answerButtonA);
		mainPanel.remove(choicesLabelA);

		correctAnswersAmountField.setPreferredSize(new Dimension(450, 50));
		correctAnswersAmountField.setBorder(BorderFactory.createLineBorder(Color.RED));
		correctAnswersAmountField.setText("Score: " + correctGuesses + "/" + quizQuestions.length);
		correctAnswersAmountField.setHorizontalAlignment(SwingConstants.CENTER);
		correctAnswersAmountField.setEditable(false);
		correctAnswersAmountField.setFont(new Font(null, Font.BOLD, 30));

		mainPanel.add(correctAnswersAmountField);
		
		correctAnswersPercentageField.setPreferredSize(new Dimension(450, 50));
		correctAnswersPercentageField.setBorder(BorderFactory.createLineBorder(Color.RED));
		
		String correctAnswersPercentageString = String.valueOf((int)(((double) correctGuesses / quizQuestions.length) * 100));
		
		correctAnswersPercentageField.setText("Percentage: " + correctAnswersPercentageString + "%");
		correctAnswersPercentageField.setHorizontalAlignment(SwingConstants.CENTER);
		correctAnswersPercentageField.setEditable(false);
		correctAnswersPercentageField.setFont(new Font(null, Font.BOLD, 30));
		
		mainPanel.add(correctAnswersPercentageField);

	}

}
