import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TextEditor extends JFrame implements ActionListener {

	// JTextArea for our JFrame
	JTextArea textArea;
	JScrollPane scrollPane;
	JLabel fontSizeLabel;
	JSpinner fontSizeSpinner;
	JButton fontColorButton;
	JComboBox<String> fontStyleBox;

	JMenuBar editorMenuBar;
	JMenu editorFileMenu;
	JMenuItem openItem;
	JMenuItem saveItem;
	JMenuItem exitItem;

	public TextEditor() {
		this.setTitle("Java Text Editor");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setLayout(new FlowLayout());
		this.setLocationRelativeTo(null); // makes JFrame appear in the center

		textArea = new JTextArea();
		textArea.setLineWrap(true); // makes text go to next line
		textArea.setWrapStyleWord(true); // makes entire word wrap instead of just characters
		textArea.setFont(new Font("Arial", Font.PLAIN, 20));

		// So that we could scroll through text if it exceeds textArea size
		scrollPane = new JScrollPane(textArea);
		scrollPane.setPreferredSize(new Dimension(450, 450));
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		fontSizeLabel = new JLabel("Font Size: ");

		// Creating a JSpinner to change font size
		fontSizeSpinner = new JSpinner();
		fontSizeSpinner.setPreferredSize(new Dimension(50, 25));
		fontSizeSpinner.setValue(20); // default value
		fontSizeSpinner.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				textArea.setFont(
						new Font(textArea.getFont().getFamily(), Font.PLAIN, (int) fontSizeSpinner.getValue()));
			}
		});

		// Adding a JButton for changing font color
		fontColorButton = new JButton("Font Color");
		fontColorButton.addActionListener(this);

		// Getting all available fonts in Java
		String[] javaFonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

		fontStyleBox = new JComboBox<String>(javaFonts);
		fontStyleBox.addActionListener(this);
		fontStyleBox.setSelectedItem("Arial");

		// Creating our JMenuBar for saving, opening, and exiting files

		editorMenuBar = new JMenuBar();
		editorFileMenu = new JMenu("File"); // a tab in JMenuBar

		openItem = new JMenuItem("Open");
		openItem.addActionListener(this);

		saveItem = new JMenuItem("Save");
		saveItem.addActionListener(this);

		exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(this);

		editorFileMenu.add(openItem);
		editorFileMenu.add(saveItem);
		editorFileMenu.add(exitItem);

		editorMenuBar.add(editorFileMenu);

		// End of JMenuBar

		this.setJMenuBar(editorMenuBar);
		this.add(fontSizeLabel);
		this.add(fontSizeSpinner);
		this.add(fontColorButton);
		this.add(fontStyleBox);
		this.add(scrollPane);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource() == fontColorButton) {
			JColorChooser colorChooser = new JColorChooser();
			Color newFontColor = colorChooser.showDialog(null, "Change Font Color", Color.BLACK);
			textArea.setForeground(newFontColor);
		}

		if (arg0.getSource() == fontStyleBox) {
			textArea.setFont(
					new Font((String) fontStyleBox.getSelectedItem(), Font.PLAIN, textArea.getFont().getSize()));
		}

		if (arg0.getSource() == openItem) {
			JFileChooser openFileChooser = new JFileChooser();
			openFileChooser.setCurrentDirectory(new File("."));
			// title of filter in dialog box, extension
			FileNameExtensionFilter textFilter = new FileNameExtensionFilter("Text File", "txt");
			openFileChooser.setFileFilter(textFilter);

			int openResponse = openFileChooser.showOpenDialog(null);

			if (openResponse == JFileChooser.APPROVE_OPTION) {
				File openFile = new File(openFileChooser.getSelectedFile().getAbsolutePath());
				Scanner scanFile = null;

				try {
					scanFile = new Scanner(openFile);

					// Checking if the current file is a file
					if (openFile.isFile()) {
						// Reading selected file
						while (scanFile.hasNextLine()) {
							// Reads each line and breaks into a new line
							String eachLine = scanFile.nextLine() + "\n";
							textArea.append(eachLine);
						}
					}

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} finally {
					scanFile.close();
				}

			}
		}

		if (arg0.getSource() == saveItem) {
			JFileChooser saveFileChooser = new JFileChooser();
			saveFileChooser.setCurrentDirectory(new File(".")); // default will be the current project folder

			int saveResponse = saveFileChooser.showSaveDialog(null);

			if (saveResponse == JFileChooser.APPROVE_OPTION) { // 0, if the user chooses to save their file
				// Get our current file in saveFileChooser
				File saveFile = new File(saveFileChooser.getSelectedFile().getAbsolutePath());
				PrintWriter writeFile = null;

				// Writing our current file
				try {
					writeFile = new PrintWriter(saveFile);
					writeFile.println(textArea.getText());
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} finally {
					writeFile.close();
				}
			}
		}

		if (arg0.getSource() == exitItem) {
			System.exit(0);
		}

	}

}
