import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConverterFrame extends JFrame implements ActionListener {

	JTextArea userArea;

	JButton convertButton;

	JLabel convertedArea;

	public ConverterFrame() {

		this.setTitle("[Insulting Tone Converter]");
		this.setSize(500, 1000);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(0, 128, 128));
		this.setResizable(false);
		this.setLayout(null);
		
		userArea = new JTextArea(5, 10);
		userArea.setLineWrap(true); // makes sure the buttons do not overflow
		userArea.setBounds(10, 10, 480, 280);
		
		// TODO: Add convert button, converted JTextArea and main program functionality
		
		this.add(userArea);
		this.setVisible(true);

	}

	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource() == convertButton) {
			JOptionPane.showMessageDialog(null, "Text Converted!", "[Convert Message]", JOptionPane.INFORMATION_MESSAGE);
		}

	}

}
