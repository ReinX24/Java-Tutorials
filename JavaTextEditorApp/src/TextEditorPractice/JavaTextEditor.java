package TextEditorPractice;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class JavaTextEditor extends JFrame implements ActionListener {

	JMenuBar editorMenuBar;
	JMenu fileMenu;

	JMenuItem openFile;
	JMenuItem saveFile;
	JMenuItem exitFile;

	JSpinner fontSizeSpinner;
	JTextArea mainTextArea;

	public static void main(String[] args) {
		new JavaTextEditor();
	}

	public JavaTextEditor() {
		this.setTitle("Java Text Editor");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
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
		/* ------------------- Adding JMenuBar and its components ------------------- */

		/* ------------------- Adding mainTextArea in our JFrame ------------------- */
		mainTextArea = new JTextArea();
		mainTextArea.setPreferredSize(new Dimension(450, 450));
		mainTextArea.setLineWrap(true);
		mainTextArea.setWrapStyleWord(true);
		/* ------------------- Adding mainTextArea in our JFrame ------------------- */

		/* --------------- Adding JSpinner for changing font size --------------- */
		fontSizeSpinner = new JSpinner();
		fontSizeSpinner.setPreferredSize(new Dimension(50, 25));
		fontSizeSpinner.setValue(20);
		fontSizeSpinner.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				mainTextArea.setFont(
						new Font(mainTextArea.getFont().getFamily(), Font.PLAIN, (int) fontSizeSpinner.getValue()));
			}
		});
		

		/* --------------- Adding JSpinner for changing font size --------------- */
		
		this.setJMenuBar(editorMenuBar);
		this.add(fontSizeSpinner);
		this.add(mainTextArea);

		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

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

}
