import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class MainQueueProgram extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	int currentTicket = 1;

	JPanel mainPanel;
	JLabel titleLabel;
	JLabel currentServingTicketLabel;
	JLabel nextServingTicketLabel;
	JTextArea pendingTicketsArea;
	JPanel buttonsPanel;
	JButton giveTicketButton;
	JButton nextTicketButton;
	JButton resetTicketsButton;

	Queue<Integer> queueNumber = new LinkedList<>();

	SoundEffects soundEffects = new SoundEffects(); // custom SoundEffects class for various sound effects

	URL programIconURL = getClass().getResource("queuePhoto.png");

	public MainQueueProgram() {

		try {
			// Set System L&F
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
		} catch (Exception e) {
			// Do nothing
		}

		// DONE: set icon for program
		this.setTitle("Registrar Queue Program");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setIconImage(new ImageIcon(programIconURL).getImage());

		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(0x000468));
		mainPanel.setPreferredSize(new Dimension(1024, 768));
		mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

		titleLabel = new JLabel("Registrar Queue");
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setPreferredSize(new Dimension(1024, 64));
		titleLabel.setFont(new Font(null, Font.BOLD, 32));
		titleLabel.setHorizontalAlignment(JLabel.CENTER);

		mainPanel.add(titleLabel);

		currentServingTicketLabel = new JLabel("Current Ticket: " + 0);
		currentServingTicketLabel.setForeground(Color.WHITE);
		currentServingTicketLabel.setBackground(new Color(0x062A80));
		currentServingTicketLabel.setOpaque(true);
		currentServingTicketLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		currentServingTicketLabel.setPreferredSize(new Dimension(384, 96));
		currentServingTicketLabel.setFont(new Font(null, Font.PLAIN, 32));
		currentServingTicketLabel.setHorizontalAlignment(JLabel.CENTER);

		mainPanel.add(currentServingTicketLabel);

		nextServingTicketLabel = new JLabel("Next Ticket: " + 0);
		nextServingTicketLabel.setForeground(Color.WHITE);
		nextServingTicketLabel.setBackground(new Color(0x062A80));
		nextServingTicketLabel.setOpaque(true);
		nextServingTicketLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		nextServingTicketLabel.setPreferredSize(new Dimension(384, 96));
		nextServingTicketLabel.setFont(new Font(null, Font.PLAIN, 32));
		nextServingTicketLabel.setHorizontalAlignment(JLabel.CENTER);

		mainPanel.add(nextServingTicketLabel);

		pendingTicketsArea = new JTextArea();
		pendingTicketsArea.setForeground(Color.WHITE);
		pendingTicketsArea.setBackground(new Color(0x062A80));
		pendingTicketsArea.setOpaque(true);
		pendingTicketsArea.setBorder(BorderFactory.createDashedBorder(Color.WHITE));
		pendingTicketsArea.setPreferredSize(new Dimension(768, 384));
		pendingTicketsArea.setFont(new Font(null, Font.PLAIN, 32));
		pendingTicketsArea.setLineWrap(true);
		pendingTicketsArea.setEditable(false);
		pendingTicketsArea.setText("Pending Tickets: " + queueNumber.toString());

		mainPanel.add(pendingTicketsArea);

		// DONE: style buttons to look better
		buttonsPanel = new JPanel();
		buttonsPanel.setForeground(Color.WHITE);
		buttonsPanel.setBackground(new Color(0x062A80));
		buttonsPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		buttonsPanel.setPreferredSize(new Dimension(768, 128));
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 16, 16));

		mainPanel.add(buttonsPanel);

		giveTicketButton = new JButton("GIVE TICKET");
		giveTicketButton.setFocusable(false);
		giveTicketButton.addActionListener(this);
		giveTicketButton.setPreferredSize(new Dimension(224, 96));
		giveTicketButton.setFont(new Font(null, Font.BOLD, 16));

		buttonsPanel.add(giveTicketButton);

		nextTicketButton = new JButton("NEXT TICKET");
		nextTicketButton.setFocusable(false);
		nextTicketButton.addActionListener(this);
		nextTicketButton.setPreferredSize(new Dimension(224, 96));
		nextTicketButton.setFont(new Font(null, Font.BOLD, 16));

		buttonsPanel.add(nextTicketButton);

		resetTicketsButton = new JButton("RESET TICKETS");
		resetTicketsButton.setFocusable(false);
		resetTicketsButton.addActionListener(this);
		resetTicketsButton.setPreferredSize(new Dimension(224, 96));
		resetTicketsButton.setFont(new Font(null, Font.BOLD, 16));

		buttonsPanel.add(resetTicketsButton);

		this.add(mainPanel);

		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource() == giveTicketButton) {
			queueNumber.offer(currentTicket);
			currentTicket++;
			pendingTicketsArea.setText("Pending Tickets: " + queueNumber.toString());
			nextServingTicketLabel.setText("Next Ticket: " + String.valueOf(queueNumber.peek()));
			soundEffects.playGiveTicketSound();
		}

		if (arg0.getSource() == nextTicketButton) {
			// If the user clicks the next ticket button but there is none pending, print a
			// message that says that there are no more tickets
			if (queueNumber.isEmpty()) {
				soundEffects.playNoTicketSound();
				JOptionPane.showMessageDialog(null, "No Pending Tickets!", "No Tickets Message",
						JOptionPane.INFORMATION_MESSAGE);
				currentServingTicketLabel.setText("Current Ticket: " + 0);
				nextServingTicketLabel.setText("Next Ticket: " + 0);
			} else {
				soundEffects.playNextTicketSound();
				// If the queue does have an element within, update ticket labels
				// Showing and removing the head of the queue
				currentServingTicketLabel.setText("Current Ticket: " + String.valueOf(queueNumber.poll()));
				// If there are no next tickets, set to 0
				if (queueNumber.isEmpty()) {
					nextServingTicketLabel.setText("Next Ticket: " + 0);
				} else {
					nextServingTicketLabel.setText("Next Ticket: " + String.valueOf(queueNumber.peek()));
				}
				// Updating the contents of pending tickets and the next ticket
				pendingTicketsArea.setText("Pending Tickets: " + queueNumber.toString());
			}
		}

		if (arg0.getSource() == resetTicketsButton) {
			soundEffects.playAskResetSound();
			int confirmReset = JOptionPane.showConfirmDialog(null,
					"Reset ticket numbers?\nWill remove current and pending tickets.", "Reset Confirmation Message",
					JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if (confirmReset == JOptionPane.YES_OPTION) {
				soundEffects.playResetConfirmedSound();
				// Clears all elements stored in queueNumber
				queueNumber.clear();
				currentTicket = 1;
				currentServingTicketLabel.setText("Current Ticket: " + 0);
				nextServingTicketLabel.setText("Next Ticket: " + 0);
				pendingTicketsArea.setText("Pending Tickets: " + queueNumber.toString());
			}
		}
	}

	public static void main(String[] args) {
		new MainQueueProgram();
	}

}
