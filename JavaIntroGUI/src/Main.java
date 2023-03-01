import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		// Creating a basic GUI (Graphical User Interface) program

		// Asking for a name
		String userName = JOptionPane.showInputDialog("Enter your name");
		JOptionPane.showMessageDialog(null, "Hello " + userName);

		// Asking for an age
		// showInputDialog returns a String, we need to use parseInt to get the integer
		int userAge = Integer.parseInt(JOptionPane.showInputDialog("Enter your age"));
		JOptionPane.showMessageDialog(null, "You are " + userAge + " years old");

		// Asking for height
		double userHeight = Double.parseDouble(JOptionPane.showInputDialog("Enter your height"));
		JOptionPane.showMessageDialog(null, "You are " + userHeight + " cm tall");

	}

}
