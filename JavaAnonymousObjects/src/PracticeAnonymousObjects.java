import javax.swing.*;
import java.awt.*;
import java.util.*;

public class PracticeAnonymousObjects {

	public static void main(String[] args) {

		JFrame mainFrame = new JFrame("[Java Anonymous Objects Practice]");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(500, 500);
		mainFrame.setLayout(new FlowLayout()); // our mainFrame will have a FlowLayout manager

		ArrayList<JLabel> myImages = new ArrayList<JLabel>(); // ArrayList where we will store our objects

		// Adding JLabels with ImageIcons to our mainFrame
		for (int i = 1; i <= 52; i++) {
			// adding JLabels with ImageIcons to our ArrayList
			myImages.add(new JLabel(new ImageIcon("src/myImages/" + i + ".png"))); 
			// adding our ArrayList elements to our mainFrame
			mainFrame.add(myImages.get(i - 1));
		}

		mainFrame.setLocationRelativeTo(null); // window will be at the center
		mainFrame.setVisible(true); // mainFrame will appear to the user
	}

}
