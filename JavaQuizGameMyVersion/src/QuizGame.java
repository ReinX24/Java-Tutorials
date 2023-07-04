import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class QuizGame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	String[] quizQuestions = {
								"When was Valorant first released for beta testing?",
								"What is the biggest map for Valorant?",
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

	JTextField correctAnswersAmoungField = new JTextField();
	JTextField correctAnswersPercentageField = new JTextField();

	Timer quizTimer = new Timer(1000, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			secondsNum--; // -1 second for every second
			secondsLeftLabel.setText(String.valueOf(secondsNum));

			if (secondsNum <= 0) {
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

		questionNumberField.setPreferredSize(new Dimension(900, 60));
		questionNumberField.setBackground(Color.GRAY);
		questionNumberField.setForeground(Color.WHITE);
		questionNumberField.setFont(new Font(null, Font.BOLD, 30));
		questionNumberField.setBorder(BorderFactory.createBevelBorder(1));
		questionNumberField.setHorizontalAlignment(JTextField.CENTER);
		questionNumberField.setEditable(false);

		mainPanel.add(questionNumberField);

		questionStringArea.setPreferredSize(new Dimension(900, 60));
		questionStringArea.setBackground(Color.GRAY);
		questionStringArea.setForeground(Color.WHITE);
		questionStringArea.setFont(new Font(null, Font.BOLD, 30));
		questionStringArea.setBorder(BorderFactory.createBevelBorder(1));
		questionStringArea.setEditable(false);
		questionStringArea.setLineWrap(true);
		questionStringArea.setWrapStyleWord(true);

		mainPanel.add(questionStringArea);

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
		choicesLabelA.setText("A choice");

		mainPanel.add(choicesLabelA);

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
		choicesLabelB.setText("B choice");

		mainPanel.add(choicesLabelB);

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
		choicesLabelC.setText("C choice");

		mainPanel.add(choicesLabelC);

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
		choicesLabelD.setText("D choice");

		mainPanel.add(choicesLabelD);

		this.add(mainPanel);

		this.pack();
		this.setVisible(true);
		
		nextQuestion();

	}

	public void nextQuestion() {
		
		questionNumberField.setText("Question #" + (currentQuestionIndex + 1));
		questionStringArea.setText(quizQuestions[currentQuestionIndex]);

	}

	public void displayAnswer() {

	}

	public void displayResults() {

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

}
