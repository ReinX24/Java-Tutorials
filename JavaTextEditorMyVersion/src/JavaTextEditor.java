
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
import java.net.URL;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.StyleConstants;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyledDocument;

public class JavaTextEditor extends JFrame implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;
	JMenuBar editorMenuBar;
	JMenu fileMenu;

	JMenuItem openFile;
	JMenuItem saveFile;
	JMenuItem exitFile;

	JScrollPane mainScrollPane; // contains mainTextPane
	JTextPane mainTextPane; // contains mainTextArea
	JTextArea mainTextArea; // where our text will be stored

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

	JLabel widthLabel;
	SpinnerNumberModel widthValues;
	JSpinner scrollPaneWidthSpinner;

	JLabel heightLabel;
	SpinnerModel heightValues;
	JSpinner scrollPaneHeightSpinner;

	JPanel mainTextPanel;

	int editorTextAreaWidth = 450;
	int editorTextAreaHeight = 450;

	URL programIcon;

	StyledDocument docStyle;
	SimpleAttributeSet attributeSet;

	JComboBox<String> textAlignmentBox;

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
		 * - DONE: Change the size of the JTextArea / JScrollPane
		 * 
		 * - DONE: Change how text is aligned in the JTextArea / JScrollPane
		 * 
		 * - DONE: Change icon for our program
		 * 
		 * - TODO: Debug all functionalities before exporting to a jar file
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
		setImageIcon();

		createMenuBar();
		createMainTextArea();
		createScrollPane();

		createFontSizeLabelSpinner();
		createChangeColorButton();

		createFontTypeBox();
		createFontStyleBox();
		createAlignmentBox();

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

		this.add(textAlignmentBox);

		this.add(widthLabel);
		this.add(scrollPaneWidthSpinner);

		this.add(heightLabel);
		this.add(scrollPaneHeightSpinner);

		this.add(mainTextPanel);
		// TODO: these counters are not working, debug and fix
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

	public void setImageIcon() {
		programIcon = getClass().getResource("textEditor.png");
		this.setIconImage(new ImageIcon(programIcon).getImage());
	}

	public void createMainTextArea() {
		/* ------------------- Adding mainTextArea in our JFrame ------------------- */

		mainTextArea = new JTextArea();
		mainTextArea.setLineWrap(true);
		mainTextArea.setWrapStyleWord(true);

		mainTextPane = new JTextPane();
		mainTextPane.setFont(new Font("DejaVu Sans Mono", Font.PLAIN, 20));
		mainTextPane.addKeyListener(this);
		// For aligning text in our textPane
		docStyle = mainTextPane.getStyledDocument();
		attributeSet = new SimpleAttributeSet();
		StyleConstants.setAlignment(attributeSet, StyleConstants.ALIGN_LEFT);
		docStyle.setParagraphAttributes(0, docStyle.getLength(), attributeSet, false);

		mainTextPane.setText(mainTextArea.getText());

	}

	public void createScrollPane() {
		/* ------------------- JScrollPane for our JTextArea ------------------- */

		mainTextPanel = new JPanel();
		mainTextPanel.setPreferredSize(new Dimension(1240, 600));

		mainScrollPane = new JScrollPane(mainTextPane); // reason for text not saving
		mainScrollPane.setPreferredSize(new Dimension(editorTextAreaWidth, editorTextAreaHeight));
//		mainScrollPane.setSize(1200, 580);
//		mainScrollPane.setPreferredSize(new Dimension(1200, 580));
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
				mainTextPane.setFont(
						new Font((String) fontTypeBox.getSelectedItem(), Font.PLAIN, (int) fontSizeSpinner.getValue()));
			}
		});
	}

	public void createChangeColorButton() {
		/* --------------- Adding JButton for changing font color --------------- */
		changeFontColorButton = new JButton("Change Font Color");
		changeFontColorButton.addActionListener(this);
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

	public void createAlignmentBox() {
		String[] alignmentChoices = { "Left", "Center", "Right", "Justify" };
		textAlignmentBox = new JComboBox<String>(alignmentChoices);
		textAlignmentBox.setPreferredSize(new Dimension(100, 25));
		textAlignmentBox.addActionListener(this);
	}

	public void createChangeWidthSpinner() {

		widthLabel = new JLabel("Width: ");

		widthValues = new SpinnerNumberModel(editorTextAreaWidth, // initial value
				editorTextAreaWidth, // min
				1200, // max
				10); // increments
		scrollPaneWidthSpinner = new JSpinner(widthValues);
		scrollPaneWidthSpinner.setPreferredSize(new Dimension(100, 25));
		scrollPaneWidthSpinner.setEditor(new JSpinner.DefaultEditor(scrollPaneWidthSpinner));
		scrollPaneWidthSpinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				mainScrollPane.setPreferredSize(
						new Dimension((int) scrollPaneWidthSpinner.getValue(), mainScrollPane.getHeight()));
				revalidate(); // validates changed components
				repaint(); // repaints components
			}
		});
	}

	public void createChangeHeightSpinner() {

		heightLabel = new JLabel("Height: ");

		heightValues = new SpinnerNumberModel(editorTextAreaHeight, editorTextAreaHeight, 580, 10);

		scrollPaneHeightSpinner = new JSpinner(heightValues);
		scrollPaneHeightSpinner.setPreferredSize(new Dimension(100, 25));
		scrollPaneHeightSpinner.setEditor(new JSpinner.DefaultEditor(scrollPaneHeightSpinner));
		scrollPaneHeightSpinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				mainScrollPane.setPreferredSize(
						new Dimension(mainScrollPane.getWidth(), (int) scrollPaneHeightSpinner.getValue()));
				revalidate();
				repaint();
			}
		});

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
			mainTextPane.setForeground(newFontColor);
		}

		if (arg0.getSource() == fontTypeBox) {
			mainTextPane.setFont(
					new Font((String) fontTypeBox.getSelectedItem(), Font.PLAIN, mainTextPane.getFont().getSize()));
		}

		if (arg0.getSource() == fontStyleBox) {
			if (fontStyleBox.getSelectedIndex() == 0) { // Font.PLAIN
				mainTextPane.setFont(
						new Font((String) fontTypeBox.getSelectedItem(), Font.PLAIN, mainTextPane.getFont().getSize()));
			} else if (fontStyleBox.getSelectedIndex() == 1) { // Font.BOLD
				mainTextPane.setFont(
						new Font((String) fontTypeBox.getSelectedItem(), Font.BOLD, mainTextPane.getFont().getSize()));
			} else if (fontStyleBox.getSelectedIndex() == 2) { // Font.ITALIC
				mainTextPane.setFont(new Font((String) fontTypeBox.getSelectedItem(), Font.ITALIC,
						mainTextPane.getFont().getSize()));
			}

		}

		if (arg0.getSource() == textAlignmentBox) {
			if (textAlignmentBox.getSelectedItem() == "Left") {
				StyleConstants.setAlignment(attributeSet, StyleConstants.ALIGN_LEFT);
				docStyle.setParagraphAttributes(0, docStyle.getLength(), attributeSet, false);
			} else if (textAlignmentBox.getSelectedItem() == "Center") {
				StyleConstants.setAlignment(attributeSet, StyleConstants.ALIGN_CENTER);
				docStyle.setParagraphAttributes(0, docStyle.getLength(), attributeSet, false);
			} else if (textAlignmentBox.getSelectedItem() == "Right") {
				StyleConstants.setAlignment(attributeSet, StyleConstants.ALIGN_RIGHT);
				docStyle.setParagraphAttributes(0, docStyle.getLength(), attributeSet, false);
			} else if (textAlignmentBox.getSelectedItem() == "Justify") {
				StyleConstants.setAlignment(attributeSet, StyleConstants.ALIGN_JUSTIFIED);
				docStyle.setParagraphAttributes(0, docStyle.getLength(), attributeSet, false);
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
						mainTextPane.setText(mainTextArea.getText());
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
					writeFile.println(mainTextPane.getText());
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
		charAmount = mainTextPane.getText().replaceAll("\\s", "").toCharArray().length; // replaces whitespace in
		charCountLabel.setText("Characters: " + charAmount);

		/* --------------- Count Amount of entered words --------------- */
		// [^ ] replaces all non white space characters in a String
		wordAmount = mainTextPane.getText().split(" ").length; // count amount of words separated space
		wordCountLabel.setText("Words: " + wordAmount); // updating wordCountLabel

		if (charAmount == 0) { // if there are no characters, reset word amount
			wordAmount = 0;
			wordCountLabel.setText("Words: " + wordAmount);
		}

		/* --------------- Count Amount of entered sentences --------------- */
		// Removing all the periods in mainTextArea and subtracting them to the original
		// String length
		sentenceAmount = mainTextPane.getText().length() - mainTextPane.getText().replaceAll("[.?!]", "").length();
		sentenceCountLabel.setText("Sentences: " + sentenceAmount);

	}

	@Override
	public void keyReleased(KeyEvent arg0) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

}