import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class JOptionPanePracticeMain {

	public static void main(String[] args) {

//		JOptionPane.showMessageDialog(null, "This is a plain message!", "[Plain Message]", JOptionPane.PLAIN_MESSAGE);

//		JOptionPane.showMessageDialog(null, "This is an information message!", "[Information Message]", JOptionPane.INFORMATION_MESSAGE);

//		JOptionPane.showMessageDialog(null, "This is a questiom message!", "[Question Message]",
//				JOptionPane.QUESTION_MESSAGE);

//		JOptionPane.showMessageDialog(null, "This is a warning message!", "[Warning Message]",
//				JOptionPane.WARNING_MESSAGE);

//		JOptionPane.showMessageDialog(null, "This is an error message!", "[Error Message]", JOptionPane.ERROR_MESSAGE);

//		String userNameString = JOptionPane.showInputDialog("[Enter your name]");
//		JOptionPane.showMessageDialog(null, "Hello " + userNameString + "!", "[Greeting Box]",
//				JOptionPane.INFORMATION_MESSAGE);

//		int userChoice = JOptionPane.showConfirmDialog(null, "[Do you like programming?]", "[Programming Query]",
//				JOptionPane.YES_NO_CANCEL_OPTION);
//		switch (userChoice) {
//		case 0:
//			JOptionPane.showMessageDialog(null, "I like programming too! :D", "[Happy Response]",
//					JOptionPane.INFORMATION_MESSAGE);
//			break;
//
//		case 1:
//			JOptionPane.showMessageDialog(null, "Aw man :(", "[Sad Response]", JOptionPane.ERROR_MESSAGE);
//			break;
//
//		case 2:
//			JOptionPane.showMessageDialog(null, "Ok then, keep your secrets", "[Cancal Response]",
//					JOptionPane.QUESTION_MESSAGE);
//			break;
//
//		default:
//			JOptionPane.showMessageDialog(null, "Exited window!", "[Exit Response]", JOptionPane.WARNING_MESSAGE);
//			break;
//		}

		// Adding an ImageIcon for our JOptionPane.showOptionDialog
		ImageIcon dialogIcon = new ImageIcon(
				"/home/rein/repos/Bro-Code-Java-Tutorial/JavaJOptionPane/warriorSword.png");

		// Adding an array of possible choices,
		String[] responseArr = { "I accept!", "No, goodbye", "Maybe later", "Who are you?" };

		JOptionPane.showOptionDialog(null, "Do you accept the challenge?", "[Challenge]",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, dialogIcon, responseArr, 0);

	}

}
