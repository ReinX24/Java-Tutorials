import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class JOptionPaneMain {

	public static void main(String[] args) {
		// JOptionPane = pop up a standard dialog box that prompts users for a value
		// or informs them of something.

		// null, message in pane, title of pane, kind of pane
//		JOptionPane.showMessageDialog(null, "This is some useless information", "[Title]", JOptionPane.PLAIN_MESSAGE);

		// Message that has an 'i' at the left side of the pane
//		JOptionPane.showMessageDialog(null, "Information Message!", "[Information Message]",
//				JOptionPane.INFORMATION_MESSAGE);

		// '?' at the left side of the pane
//		JOptionPane.showMessageDialog(null, "Question Message!", "[Question Message]", JOptionPane.QUESTION_MESSAGE);

		// '!' at the left side of the pane
//		JOptionPane.showMessageDialog(null, "Warning Message!", "[Warning Message]", JOptionPane.WARNING_MESSAGE);

		// 'x' at the left side of the pane
//		JOptionPane.showMessageDialog(null, "Error Message!", "[Error Message]", JOptionPane.ERROR_MESSAGE);

		// Asking user for responses
//		int answerNum = JOptionPane.showConfirmDialog(null, "Bro do you even code?", "[Message Title]",
//				JOptionPane.YES_NO_CANCEL_OPTION);
		// 0 : Yes, 1 : No, 2 : Cancel

//		String userName = JOptionPane.showInputDialog("What is your name?: ");
//		System.out.println("Hello " + userName);

//		JOptionPane.showOptionDialog(null, "You are awesome!", "[Secret Message]", JOptionPane.YES_NO_CANCEL_OPTION,
//				JOptionPane.INFORMATION_MESSAGE, null, null, 0);

		// Adding an icon to our JOptionPane
		ImageIcon iconOne = new ImageIcon("warriorSword.png");
		// Replaces the button values in our OptionDialog
		String[] responsesArr = { "No, you're aweseome", "Thank you!", "*blush*" };

		JOptionPane.showOptionDialog(null, "You are awesome!", "[Secret Message]", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.INFORMATION_MESSAGE, iconOne, responsesArr, 0);
	}

}
