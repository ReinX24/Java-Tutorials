import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

public class QuizGame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	String[] quizQuestions = { "When was Valorant first released for beta testing?",
			"What is the biggest map made for Valorant?",
			"Who were the first two agents added to the Valorant Protocol?",
			"What is the name of the free gun given once your agent spawns?",
			"What team won in Masters Reykjavík in 2021?" };

	String[][] quizQuestionsChoices = { // A, D, B, C
			{ "April 7, 2020", "August 12, 2020", "January 23, 2020", "December 27, 2019" },
			{ "Bind", "Ascent", "Haven", "Breeze" },
			{ "Phoenix and Killjoy", "Brimstone and Viper", "Sova and Omen", "Raze and Jett" },
			{ "Pea Shooter", "Glock", "Classic", "Hand Gun" },
			{ "Sentinels", "FNATIC", "Gambit Esports", "Team Envy" } };

	char[] quizChoicesAnswers = { 'A', 'D', 'B', 'C', 'A' };

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

			if (secondsNum > 0 && secondsNum <= 3) {
				playLastThreeSecondsSound();
				secondsLeftLabel.setForeground(Color.RED); // changes number color to red if there are 3 seconds left
			}

			if (secondsNum <= 0) {
				// If there is not time left, display the answer and go to the next question
				// automatically
				displayAnswer();
			}
		}
	});

	JButton tryAgainButton = new JButton("Try Again");
	JButton exitQuizButton = new JButton("Exit Quiz");

	Random randomIndexSelector = new Random();

	AudioInputStream streamAudio;
	Clip audioClip;
	FloatControl gainControl;

	URL correctAnswerSoundURL = getClass().getResource("correctAnswerSound.wav");
	URL wrongAnswerSoundURL = getClass().getResource("wrongAnswerSound.wav");
	URL lastThreeSecondsSoundURL = getClass().getResource("lastThreeSecondsSound.wav");
	URL tryAgainSoundURL = getClass().getResource("tryAgainSound.wav");
	URL exitConfirmSoundURL = getClass().getResource("exitConfirmSound.wav");
	// TODO: add no time left URL

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

		shuffleQuestions();
		nextQuestion();

	}

	public void shuffleQuestions() {
		// When starting our program, shuffle the order of questions and their answers
		for (int i = 0; i < quizQuestions.length; i++) {
			// Generates a random index between 0 and quizQuestions array length
			int randomIndexSwap = randomIndexSelector.nextInt(quizQuestions.length);
			// Stores selected element in a String variable
			String tempQuestion = quizQuestions[randomIndexSwap];
			// Reassign index of random selected element to current iterated element
			quizQuestions[randomIndexSwap] = quizQuestions[i];
			quizQuestions[i] = tempQuestion;

			// For question choices
			String[] tempChoices = quizQuestionsChoices[randomIndexSwap];
			quizQuestionsChoices[randomIndexSwap] = quizQuestionsChoices[i];
			quizQuestionsChoices[i] = tempChoices;

			// For the answers for each question
			char tempAnswer = quizChoicesAnswers[randomIndexSwap];
			quizChoicesAnswers[randomIndexSwap] = quizChoicesAnswers[i];
			quizChoicesAnswers[i] = tempAnswer;

		}
	}

	public void nextQuestion() {

		// If we are out of questions, display results
		if (currentQuestionIndex >= totalQuestions) {
			displayResults();
		} else { 
			// Reset timer number color
			secondsLeftLabel.setForeground(timeLeftMessageLabel.getForeground());
			
			// If we still have remaining questions, display question and choices
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
				playCorrectAnswerSound();
				correctGuesses++;
			} else {
				playWrongAnswerSound();
			}
		}

		if (arg0.getSource() == answerButtonB) {
			userAnswer = 'B';
			if (userAnswer == quizChoicesAnswers[currentQuestionIndex]) {
				playCorrectAnswerSound();
				correctGuesses++;
			} else {
				playWrongAnswerSound();
			}
		}

		if (arg0.getSource() == answerButtonC) {
			userAnswer = 'C';
			if (userAnswer == quizChoicesAnswers[currentQuestionIndex]) {
				playCorrectAnswerSound();
				correctGuesses++;
			} else {
				playWrongAnswerSound();
			}
		}

		if (arg0.getSource() == answerButtonD) {
			userAnswer = 'D';
			if (userAnswer == quizChoicesAnswers[currentQuestionIndex]) {
				playCorrectAnswerSound();
				correctGuesses++;
			} else {
				playWrongAnswerSound();
			}
		}

		if (arg0.getSource() == tryAgainButton) {
			playTryAgainSound();
			this.dispose();
			currentQuestionIndex = 0; // reset index to 0 to avoid out of bounds exception
			new QuizGame();
		}

		if (arg0.getSource() == exitQuizButton) {
			System.exit(0);
		}

		displayAnswer();

	}

	public void displayAnswer() {

		quizTimer.stop();

		answerButtonA.setEnabled(false);
		answerButtonB.setEnabled(false);
		answerButtonC.setEnabled(false);
		answerButtonD.setEnabled(false);

		// If the answer is the wrong answer, make label text red
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

		// If the answer is the right answer, make the text green
		if (quizChoicesAnswers[currentQuestionIndex] == 'A') {
			choicesLabelA.setForeground(Color.GREEN);
		}

		if (quizChoicesAnswers[currentQuestionIndex] == 'B') {
			choicesLabelB.setForeground(Color.GREEN);
		}

		if (quizChoicesAnswers[currentQuestionIndex] == 'C') {
			choicesLabelC.setForeground(Color.GREEN);
		}

		if (quizChoicesAnswers[currentQuestionIndex] == 'D') {
			choicesLabelD.setForeground(Color.GREEN);
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

		mainPanel.removeAll();
		mainPanel.revalidate();
		mainPanel.repaint();

		questionNumberField.setText("Quiz Over!");

		mainPanel.add(questionNumberField);

		questionStringArea.setText("Results:");

		mainPanel.add(questionStringArea);

		correctAnswersAmountField.setPreferredSize(new Dimension(900, 200));
		correctAnswersAmountField.setBorder(BorderFactory.createBevelBorder(0));
		correctAnswersAmountField.setText("Score: " + correctGuesses + "/" + quizQuestions.length);
		correctAnswersAmountField.setHorizontalAlignment(SwingConstants.CENTER);
		correctAnswersAmountField.setEditable(false);
		correctAnswersAmountField.setFont(new Font(null, Font.BOLD, 30));

		mainPanel.add(correctAnswersAmountField);

		correctAnswersPercentageField.setPreferredSize(new Dimension(900, 200));
		correctAnswersPercentageField.setBorder(BorderFactory.createBevelBorder(0));

		int correctAnswersPercentage = (int) (((double) correctGuesses / quizQuestions.length) * 100);

		if (correctAnswersPercentage < 25) {
			// Below 25%
			correctAnswersAmountField.setForeground(new Color(227, 34, 39)); // red color
		} else if (correctAnswersPercentage < 50) {
			// Below 50%
			correctAnswersAmountField.setForeground(new Color(255, 102, 0)); // orange color
		} else if (correctAnswersPercentage < 75) {
			// Below 75%
			correctAnswersAmountField.setForeground(new Color(255, 196, 12)); // yellow color
		} else if (correctAnswersPercentage >= 75) {
			// Greater than or equal to 75
			correctAnswersAmountField.setForeground(new Color(120, 190, 33)); // green color
		}

		correctAnswersPercentageField.setText("Percentage: " + correctAnswersPercentage + "%");
		correctAnswersPercentageField.setHorizontalAlignment(SwingConstants.CENTER);
		correctAnswersPercentageField.setEditable(false);
		correctAnswersPercentageField.setFont(new Font(null, Font.BOLD, 30));

		mainPanel.add(correctAnswersPercentageField);

		// DONE: style tryAgainButton and exitQuizButton
		tryAgainButton.addActionListener(this);
		tryAgainButton.setPreferredSize(new Dimension(450, 75));
		tryAgainButton.setBorder(BorderFactory.createRaisedBevelBorder());
		tryAgainButton.setFocusable(false);
		tryAgainButton.setBackground(new Color(120, 190, 33));
		tryAgainButton.setForeground(Color.WHITE);
		tryAgainButton.setFont(new Font(null, Font.BOLD, 26));

		mainPanel.add(tryAgainButton);

		exitQuizButton.addActionListener(this);
		exitQuizButton.setPreferredSize(new Dimension(450, 75));
		exitQuizButton.setBorder(BorderFactory.createRaisedBevelBorder());
		exitQuizButton.setFocusable(false);
		exitQuizButton.setBackground(new Color(227, 34, 39));
		exitQuizButton.setForeground(Color.WHITE);
		exitQuizButton.setFont(new Font(null, Font.BOLD, 26));

		mainPanel.add(exitQuizButton);

	}

	public void playCorrectAnswerSound() {
		try {
			streamAudio = AudioSystem.getAudioInputStream(correctAnswerSoundURL);
			audioClip = AudioSystem.getClip();
			audioClip.open(streamAudio);

			gainControl = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-6.0f);

			audioClip.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void playWrongAnswerSound() {
		try {
			streamAudio = AudioSystem.getAudioInputStream(wrongAnswerSoundURL);
			audioClip = AudioSystem.getClip();
			audioClip.open(streamAudio);

			gainControl = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-6.0f);

			audioClip.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void playTryAgainSound() {
		try {
			streamAudio = AudioSystem.getAudioInputStream(tryAgainSoundURL);
			audioClip = AudioSystem.getClip();
			audioClip.open(streamAudio);

			gainControl = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-6.0f);

			audioClip.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void playLastThreeSecondsSound() {
		try {
			streamAudio = AudioSystem.getAudioInputStream(lastThreeSecondsSoundURL);
			audioClip = AudioSystem.getClip();
			audioClip.open(streamAudio);

			gainControl = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-6.0f);

			audioClip.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}
	
	public void playNoTimeLeftSound() {
		try {
			streamAudio = AudioSystem.getAudioInputStream(exitConfirmSoundURL);
			audioClip = AudioSystem.getClip();
			audioClip.open(streamAudio);

			gainControl = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-6.0f);

			audioClip.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}
	
	// TODO: Add a message dialog asking the user to confirm their exit from the quiz game
	public void playExitConfirmSound() {
		try {
			streamAudio = AudioSystem.getAudioInputStream(exitConfirmSoundURL);
			audioClip = AudioSystem.getClip();
			audioClip.open(streamAudio);

			gainControl = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-6.0f);

			audioClip.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

}
