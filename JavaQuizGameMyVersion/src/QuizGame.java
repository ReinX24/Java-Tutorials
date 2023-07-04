import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class QuizGame extends JFrame implements ActionListener {

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

	JLabel questionNumberLabel = new JLabel();
	JLabel questionStringLabel = new JLabel();

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

	JTextField correctNumbersAnswersField = new JTextField();

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

}
