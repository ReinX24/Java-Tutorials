import java.awt.*;
import javax.swing.*;
import java.util.*;

public class AnonymousObjectsMain {

	public static void main(String[] args) {

		JFrame mainFrame = new JFrame("Java Anonymous Objects");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(500, 500);
		mainFrame.setLayout(new FlowLayout());

		ArrayList<JLabel> myList = new ArrayList<JLabel>();

		for (int i = 1; i <= 52; i++) {
			myList.add(new JLabel(new ImageIcon("src/myImages/" + i + ".png")));
			mainFrame.add(myList.get(i - 1));
		}

		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);

	}

}
