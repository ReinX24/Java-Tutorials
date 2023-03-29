package practiceJOptionPane;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		/*
		 * Summary: showMessageDialog : message only
		 * 
		 * showConfirmDialog : yes, no, cancel
		 * 
		 * showInputDialog : enter info in the box
		 * 
		 * showOptionDialog : yes, no, cancel, change icon, change dialog box type,
		 * custom responses
		 * 
		 */

		// null, message content, title of dialog box, the type of dialog box (adds and
		// changes icon at the left side of the box)

		// Plain message
//		JOptionPane.showMessageDialog(null, "Simple Dialog Message!", "[Simple Message]", JOptionPane.PLAIN_MESSAGE);

		// Information message
//		JOptionPane.showMessageDialog(null, "Information Dialog Message!", "[Information Message]",
//				JOptionPane.INFORMATION_MESSAGE);

		// Question message
//		JOptionPane.showMessageDialog(null, "Question Dialog Message!", "[Question Message]",
//				JOptionPane.QUESTION_MESSAGE);

		// Warning message
//		JOptionPane.showMessageDialog(null, "Warning Dialog Message!", "[Warning Message]",
//				JOptionPane.WARNING_MESSAGE);

		// Error message
//		JOptionPane.showMessageDialog(null, "Error Dialog Message!", "[Error Message]", JOptionPane.ERROR_MESSAGE);

		// Asking user for responses

		// Yes, No, Cancel
//		int userResponse = JOptionPane.showConfirmDialog(null, "Input Dialog", "[Input Dialog Box]",
//				JOptionPane.YES_NO_CANCEL_OPTION);
//		System.out.println(userResponse);

		// String
//		String userName = JOptionPane.showInputDialog("Enter your name: ");
//		JOptionPane.showMessageDialog(null, "Hello " + userName, "[Hello Dialog Box]", JOptionPane.PLAIN_MESSAGE);

		// null, dialog box message, dialog box title, type of choices (yes, no,
		// cancel), type of dialog box, icon for box, custom responses, default value
//		JOptionPane.showOptionDialog(null, "Are you cringe?", "[Cringe Check]", JOptionPane.YES_NO_CANCEL_OPTION,
//				JOptionPane.QUESTION_MESSAGE, null, null, 0);

		// Adding custom icon & custom responses to our OptionDialog

		ImageIcon dialogBoxIcon = new ImageIcon("warriorSword.png");
		String[] customResponses = { "I like cake!", "The cake is a lie!", "No" };

		JOptionPane.showOptionDialog(null, "Do you like cake?", "[Ask Cake]", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, dialogBoxIcon, customResponses, 0);

	}

}
