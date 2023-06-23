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

import javax.swing.*;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
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

	JSpinner scrollPaneWidthSpinner;
	JSpinner scrollPaneHeightSpinner;

	JPanel mainTextPanel;

	int editorTextAreaWidth = 450;
	int editorTextAreaHeight = 450;

	public static void main(String[] args) {
		/*
		 * Ideas for features to be added:
		 * 
		 * - DONE: Character counter, word counter, and sentence counter
		 * 
		 * - DONE: Create methods that separates creating components and functions
		 * 
		 * - DONE: Change font to bold, italic, or plain
		 * 
		 * - TODO: Change the size of the JTextArea / JScrollPane
		 * 
		 * - TODO: Change how text is aligned in the JTextArea / JScrollPane
		 * 
		 * - TODO: Change icon for our program
		 * 
		 * - TODO: Add sound effects when typing on keyboard
		 * 
		 */
		new JavaTextEditor();
	}

	public JavaTextEditor() {
		this.setTitle("Java Text Editor");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1280, 720);
		this.setLocationRelativeTo(null);
		this.setLayout(new FlowLayout());

		/* --------------- Instantiating components for our JFrame --------------- */
		setLookAndFeel();
		createMenuBar();
		createMainTextArea();
		createScrollPane();
		createFontSizeLabelSpinner();
		createFontTypeBox();
		createFontStyleBox();
		createChangeColorButton();
		createChangeWidthSpinner();
		createChangeHeightSpinner();
		createCharCountLabel();
		createWordCountLabel();
		createSentenceCountLabel();

		/* --------------- Adding different components for our JFrame --------------- */
		this.setJMenuBar(editorMenuBar);
		this.add(fontSizeLabel);
		this.add(fontSizeSpinner);
		this.add(changeFontColorButton);
		this.add(fontTypeBox);
		this.add(fontStyleBox);
		this.add(scrollPaneWidthSpinner);
		// TODO: add height JSpinner
//		this.add(mainScrollPane);
		this.add(mainTextPanel);

		this.add(charCountLabel);
		this.add(wordCountLabel);
		this.add(sentenceCountLabel);

		this.setVisible(true);

	}

	public void createMenuBar() {
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
	}

	public void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}

	public void createMainTextArea() {
		/* ------------------- Adding mainTextArea in our JFrame ------------------- */
		mainTextArea = new JTextArea();
		mainTextArea.setFont(new Font("DejaVu Sans Mono", Font.PLAIN, 20));
		mainTextArea.setLineWrap(true);
		mainTextArea.setWrapStyleWord(true);
		mainTextArea.addKeyListener(this);
//		mainTextArea.setComponentOrientation();
	}

	public void createScrollPane() {
		/* ------------------- JScrollPane for our JTextArea ------------------- */

		mainTextPanel = new JPanel();
		mainTextPanel.setPreferredSize(new Dimension(1280, 600));

		mainScrollPane = new JScrollPane(mainTextArea);
		mainScrollPane.setPreferredSize(new Dimension(450, 450));
		mainScrollPane.setSize(1000, 1000);
		mainScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		mainTextPanel.add(mainScrollPane);
	}

	public void createFontSizeLabelSpinner() {
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
	}

	public void createFontTypeBox() {
		/* --------------- Adding JComboBox for changing font type --------------- */
		String[] javaFonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		fontTypeBox = new JComboBox<String>(javaFonts);
		fontTypeBox.addActionListener(this);
		fontTypeBox.setSelectedItem("DejaVu Sans Mono");
	}

	public void createFontStyleBox() {
		/* --------------- Adding JComboBox for changing font style --------------- */
		String[] fontTypes = { "Plain", "Bold", "Italic" };
		fontStyleBox = new JComboBox<String>(fontTypes);
		fontStyleBox.addActionListener(this);
		fontStyleBox.setSelectedItem("Plain");
	}

	public void createChangeColorButton() {
		/* --------------- Adding JButton for changing font color --------------- */
		changeFontColorButton = new JButton("Change Font Color");
		changeFontColorButton.addActionListener(this);
	}

	public void createChangeWidthSpinner() {

		SpinnerModel widthValues = new SpinnerNumberModel(editorTextAreaWidth, // initial value
				editorTextAreaWidth, // min
				1200, // max
				10);
		// TODO: debug this JSpinner
		scrollPaneWidthSpinner = new JSpinner(widthValues);
		scrollPaneWidthSpinner.setPreferredSize(new Dimension(100, 25));
//		scrollPaneWidthSpinner.setValue(editorTextAreaWidth);
		scrollPaneWidthSpinner.setEditor(new JSpinner.DefaultEditor(scrollPaneWidthSpinner));
		scrollPaneWidthSpinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				mainScrollPane.setPreferredSize(
						new Dimension((int) scrollPaneWidthSpinner.getValue(), mainScrollPane.getHeight()));
			}
		});
	}

	public void createChangeHeightSpinner() {

	}

	public void createCharCountLabel() {
		/* --------------- Adding String & JLabel for char amount --------------- */
		charAmount = 0;
		charCountLabel = new JLabel("Characters: " + charAmount);
	}

	public void createWordCountLabel() {
		/* --------------- Adding JLabel for word amount --------------- */
		wordAmount = 0;
		wordCountLabel = new JLabel("Words: " + wordAmount);
	}

	public void createSentenceCountLabel() {
		/* --------------- Adding JLabel for sentence amount --------------- */
		sentenceAmount = 0;
		sentenceCountLabel = new JLabel("Sentences: " + sentenceAmount);
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
			if (fontStyleBox.getSelectedIndex() == 0) { // Font.PLAIN
				mainTextArea.setFont(
						new Font((String) fontTypeBox.getSelectedItem(), Font.PLAIN, mainTextArea.getFont().getSize()));
			} else if (fontStyleBox.getSelectedIndex() == 1) { // Font.BOLD
				mainTextArea.setFont(
						new Font((String) fontTypeBox.getSelectedItem(), Font.BOLD, mainTextArea.getFont().getSize()));
			} else if (fontStyleBox.getSelectedIndex() == 2) { // Font.ITALIC
				mainTextArea.setFont(new Font((String) fontTypeBox.getSelectedItem(), Font.ITALIC,
						mainTextArea.getFont().getSize()));
			}

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
		sentenceAmount = mainTextArea.getText().length() - mainTextArea.getText().replaceAll("[.?!]", "").length();
		sentenceCountLabel.setText("Sentences: " + sentenceAmount);

	}

	@Override
	public void keyReleased(KeyEvent arg0) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

}
