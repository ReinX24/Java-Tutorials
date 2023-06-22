package TextEditorPractice;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class JavaTextEditor extends JFrame implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;
	JMenuBar editorMenuBar;
	JMenu fileMenu;

	JMenuItem openFile;
	JMenuItem saveFile;
	JMenuItem exitFile;

	JScrollPane mainScrollPane;
	JTextArea mainTextArea;

	JLabel fontSizeLabel;
	JSpinner fontSizeSpinner;

	JComboBox<String> fontStyleBox;
	JButton changeFontColorButton;

	JLabel charCountLabel;
	int charAmount;

	JLabel wordCountLabel;
	int wordAmount;

	JLabel sentenceCountLabel;
	int sentenceAmount;

	JComboBox<String> fontTypeBox;

	public static void main(String[] args) {
		/*
		 * Ideas for features to be added:
		 * 
		 * - Character counter, word counter, and sentence counter
		 * 
		 * - TODO: Create methods that separates creating components and functions
		 * 
		 * - TODO: Change font to bold, italic, or plain
		 * 
		 * - TODO: Change the size of the JTextArea / JScrollPane
		 * 
		 * - TODO: Change how text is aligned in the JTextArea / JScrollPane
		 * 
		 */
		new JavaTextEditor();
	}

	public JavaTextEditor() {
		this.setTitle("Java Text Editor");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 600);
		this.setLocationRelativeTo(null);
		this.setLayout(new FlowLayout());

		/* ------------------- Adding JMenuBar and its components ------------------- */
		editorMenuBar = new JMenuBar();

		fileMenu = new JMenu("File");

		openFile = new JMenuItem("Open");
		openFile.addActionListener(this);

		saveFile = new JMenuItem("Save");
		saveFile.addActionListener(this);

		exitFile = new JMenuItem("Exit");
		exitFile.addActionListener(this);

		fileMenu.add(openFile);
		fileMenu.add(saveFile);
		fileMenu.add(exitFile);

		editorMenuBar.add(fileMenu);

		/* ------------------- Adding mainTextArea in our JFrame ------------------- */
		mainTextArea = new JTextArea();
		mainTextArea.setFont(new Font("Arial", Font.PLAIN, 20));
		mainTextArea.setLineWrap(true);
		mainTextArea.setWrapStyleWord(true);
		mainTextArea.addKeyListener(this);

		/* ------------------- JScrollPane for our JTextArea ------------------- */
		mainScrollPane = new JScrollPane(mainTextArea);
		mainScrollPane.setPreferredSize(new Dimension(450, 450));
		mainScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		/* --------------- JLabel before JSpinner --------------- */
		fontSizeLabel = new JLabel("Font Size: ");

		/* --------------- Adding JSpinner for changing font size --------------- */
		fontSizeSpinner = new JSpinner();
		fontSizeSpinner.setPreferredSize(new Dimension(50, 25));
		fontSizeSpinner.setValue(20);
		fontSizeSpinner.setEditor(new JSpinner.DefaultEditor(fontSizeSpinner)); // JSpinner contents are not editable
		fontSizeSpinner.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				mainTextArea.setFont(
						new Font(mainTextArea.getFont().getFamily(), Font.PLAIN, (int) fontSizeSpinner.getValue()));
			}
		});

		/* --------------- Adding JComboBox for changing font style --------------- */
		String[] javaFonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		fontTypeBox = new JComboBox<String>(javaFonts);
		fontTypeBox.addActionListener(this);
		fontTypeBox.setSelectedItem("Arial");

		/* --------------- Adding JComboBox for changing font type --------------- */
		String[] fontTypes = { "Plain", "Bold", "Italic" };
		fontStyleBox = new JComboBox<String>(fontTypes);
		fontStyleBox.addActionListener(this);
		fontStyleBox.setSelectedItem("Plain");

		/* --------------- Adding JButton for changing font color --------------- */
		changeFontColorButton = new JButton("Change Font Color");
		changeFontColorButton.addActionListener(this);

		/* --------------- Adding String & JLabel for char amount --------------- */
		charAmount = 0;
		charCountLabel = new JLabel("Characters: " + charAmount);

		/* --------------- Adding JLabel for word amount --------------- */
		wordAmount = 0;
		wordCountLabel = new JLabel("Words: " + wordAmount);

		/* --------------- Adding JLabel for sentence amount --------------- */
		sentenceAmount = 0;
		sentenceCountLabel = new JLabel("Sentences: " + sentenceAmount);

		/* --------------- Adding different components for our JFrame --------------- */
		this.setJMenuBar(editorMenuBar);
		this.add(fontSizeLabel);
		this.add(fontSizeSpinner);
		this.add(changeFontColorButton);
		this.add(fontTypeBox);
		this.add(fontStyleBox);
		this.add(mainScrollPane);

		this.add(charCountLabel);
		this.add(wordCountLabel);
		this.add(sentenceCountLabel);

		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource() == changeFontColorButton) {
			Color newFontColor = JColorChooser.showDialog(null, "Change Font Color", Color.BLACK);
			mainTextArea.setForeground(newFontColor);
		}

		if (arg0.getSource() == fontTypeBox) {
			mainTextArea.setFont(
					new Font((String) fontTypeBox.getSelectedItem(), Font.PLAIN, mainTextArea.getFont().getSize()));
		}

		if (arg0.getSource() == fontStyleBox) {
			// TODO: finish creating the function for this JComboBox
//			mainTextArea.setFont(new Font((String) fontTypeBox.getSelectedItem(), (String) fontStyleBox.getSelectedItem());
		}

		if (arg0.getSource() == openFile) {

			JFileChooser openFileChooser = new JFileChooser();
			openFileChooser.setCurrentDirectory(new File(".")); // current project folder

			FileNameExtensionFilter textFileFilter = new FileNameExtensionFilter("Text Files", "txt");
			openFileChooser.setFileFilter(textFileFilter);

			int openFileResponse = openFileChooser.showOpenDialog(null);

			if (openFileResponse == JFileChooser.APPROVE_OPTION) {
				File openedFile = new File(openFileChooser.getSelectedFile().getAbsolutePath());
				Scanner scanFile = null;

				try {
					scanFile = new Scanner(openedFile);
					if (openedFile.isFile()) {
						mainTextArea.setText(""); // removes current text in JTextArea
						while (scanFile.hasNextLine()) {
							String eachLine = scanFile.nextLine() + "\n";
							mainTextArea.append(eachLine);
						}
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} finally {
					scanFile.close();
				}
			}

		}

		if (arg0.getSource() == saveFile) {

			JFileChooser saveFileChooser = new JFileChooser();
			saveFileChooser.setCurrentDirectory(new File("."));

			int saveFileResponse = saveFileChooser.showSaveDialog(null);

			if (saveFileResponse == JFileChooser.APPROVE_OPTION) {
				File savedFile = new File(saveFileChooser.getSelectedFile().getAbsolutePath());
				PrintWriter writeFile = null;

				try {
					writeFile = new PrintWriter(savedFile);
					writeFile.println(mainTextArea.getText());
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} finally {
					writeFile.close();
				}
			}

		}

		if (arg0.getSource() == exitFile) {
			int confirmExit = JOptionPane.showConfirmDialog(null, "Exit Text Editor?", "Exit Confirmation",
					JOptionPane.YES_NO_OPTION);

			if (confirmExit == JOptionPane.YES_OPTION) { // 0
				System.exit(0);
			}
		}

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		/* --------------- Count Amount of entered characters --------------- */
		charAmount = mainTextArea.getText().replaceAll("\\s", "").toCharArray().length; // replaces whitespace in
		charCountLabel.setText("Characters: " + charAmount);

		/* --------------- Count Amount of entered words --------------- */
		// [^ ] replaces all non white space characters in a String
		wordAmount = mainTextArea.getText().split(" ").length; // count amount of words separated space
		wordCountLabel.setText("Words: " + wordAmount); // updating wordCountLabel

		if (charAmount == 0) { // if there are no characters, reset word amount
			wordAmount = 0;
			wordCountLabel.setText("Words: " + wordAmount);
		}

		/* --------------- Count Amount of entered sentences --------------- */
		// Removing all the periods in mainTextArea and subtracting them to the original
		// String length
		sentenceAmount = mainTextArea.getText().length() - mainTextArea.getText().replaceAll("[.]", "").length();
		sentenceCountLabel.setText("Sentences: " + sentenceAmount);

	}

	@Override
	public void keyReleased(KeyEvent arg0) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

}
