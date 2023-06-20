import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.net.URL;

public class BuyMenuFrame extends JFrame implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;
	JPanel weaponPanel;
	JPanel pricePanel;
	static JPanel weaponOrderPanel = new JPanel();
	// ^ in order for components to be saved, must be static and instantiated
	// immediately
	JPanel totalPanel;

	JButton[] weaponButtons = new JButton[10];

	JButton pistolButton;
	JButton shotgunButton;
	JButton smgButton;
	JButton rifleButton;
	JButton lmgButton;
	JButton ammoButton;
	JButton equipmentButton;
	JButton sniperButton;
	JButton buyButton;
	JButton exitButton;

	static JLabel totalLabel;
	static double userTotal = 0;
	String userGun;
	Double userGunPrice;

	static int maxBuyItems = 20;
	static int itemsBoughtTracker = 0;

	final static Font CUSTOM_FONT = new Font("Arial", Font.BOLD, 14);
	final static Color FONT_COLOR = new Color(255, 195, 0);
	final Color BUTTON_BACKGROUND_COLOR = new Color(129, 133, 137, 255);
	final Color BACKGROUND_COLOR = Color.LIGHT_GRAY;

	static DecimalFormat decimalFormat;

	JPanel extraButtonsPanel;

	JButton[] extraButtons = new JButton[4];

	JButton clearButton;
	JButton undoButton;
	JButton discountButton;
	JButton installmentButton;

	SpinnerModel discountSpinnerValues;
	JSpinner discountSpinner;
	double discountAmount;

	SpinnerModel installmentSpinnerValues;
	JSpinner installmentSpinner;
	int installmentAmount;

	double interestAmount = 0.0;

	static AudioInputStream streamAudio;
	static Clip audioClip;
	static FloatControl gainControl;

	final URL BUTTON_PRESSED_AUDIO_URL = getClass().getResource("Computer Boop - Sound Effect.wav");
	final URL NO_ITEMS_AUDIO_URL = getClass().getResource("Error \uFF5C Sound Effects (No Copyright).wav");
	final URL BUY_GUN_AUDIO_URL = getClass()
			.getResource("Item Pick up (Counter Strike Source) - Sound Effect for editing.wav");
	final URL BUY_BULLETS_AUDIO_URL = getClass().getResource(
			"Bullet falling \uFF5C Top Bullets \uFF5C Bullet sounds \uFF5C Bullet \uFF5C Sound Effect HD.wav");
	final URL BUY_EQUIPMENT_AUDIO_URL = getClass()
			.getResource("Ammo Pick up (Counter Strike Source) - Sound Effect for editing.wav");
	final URL MENU_BACKGROUND_AUDIO_URL = getClass().getResource("Counter Strike\uFF1A Theme Song (1.6 Main Menu).wav");

	final URL BUY_MENU_ICON_URL = getClass().getResource("buyMenuIcon.png");

	// ArrayList that will contain the orders of users
	static ArrayList<JLabel> weaponOrderLabels = new ArrayList<JLabel>();
	static ArrayList<Integer> weaponOrderPrices = new ArrayList<Integer>();

	public BuyMenuFrame() {

	}

	public void createBuyMenuFrame() {
		// Setting up our JFrame
		this.setTitle("BUY MENU : COUNTER STRIKE");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(1, 2));
		this.setResizable(false);
		this.addKeyListener(this);
		this.setIconImage(new ImageIcon(BUY_MENU_ICON_URL).getImage());

		// Creating our JPanel that will contain our Gun Menu Buttons
		weaponPanel = new JPanel();
		weaponPanel.setPreferredSize(new Dimension(500, 775));
		weaponPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
		weaponPanel.setBorder(new EmptyBorder(25, 75, 25, 25));
		weaponPanel.setBackground(BACKGROUND_COLOR); // r, g, b, alpha value

		// Instantiating our JButtons
		exitButton = new JButton("0. EXIT");
		buyButton = new JButton("9. BUY");
		pistolButton = new JButton("1. PISTOLS");
		shotgunButton = new JButton("2. SHOTGUNS");
		smgButton = new JButton("3. SMGS");
		rifleButton = new JButton("4. RIFLES");
		sniperButton = new JButton("5. SNIPERS");
		lmgButton = new JButton("6. LMGS");
		ammoButton = new JButton("7. AMMO");
		equipmentButton = new JButton("8. EQUIPMENTS");

		// Adding our weapon buttons to our weaponButtons array
		weaponButtons[0] = pistolButton;
		weaponButtons[1] = shotgunButton;
		weaponButtons[2] = smgButton;
		weaponButtons[3] = rifleButton;
		weaponButtons[4] = sniperButton;
		weaponButtons[5] = lmgButton;
		weaponButtons[6] = ammoButton;
		weaponButtons[7] = equipmentButton;
		weaponButtons[8] = buyButton;
		weaponButtons[9] = exitButton;

		// Adding different settings to our JButtons
		for (int i = 0; i < weaponButtons.length; i++) {
			weaponButtons[i].setPreferredSize(new Dimension(400, 40));
			weaponButtons[i].addActionListener(this);
			weaponButtons[i].setHorizontalAlignment(JButton.LEFT);
			weaponButtons[i].setFocusable(false);
			weaponButtons[i].setBackground(BUTTON_BACKGROUND_COLOR);
			weaponButtons[i].setForeground(FONT_COLOR);
			weaponButtons[i].setFont(CUSTOM_FONT);
			weaponPanel.add(weaponButtons[i]);
		}

		// For Clear, Undo, and Discount functionalities
		extraButtonsPanel = new JPanel();
		extraButtonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));
		extraButtonsPanel.setPreferredSize(new Dimension(400, 100));
		extraButtonsPanel.setBackground(Color.LIGHT_GRAY);

		clearButton = new JButton("<html><u>C</u>LEAR</html>");
		undoButton = new JButton("<html><u>U</u>NDO</html>");
		discountButton = new JButton("<html><u>D</u>ISCOUNT</html>");
		installmentButton = new JButton("<html><u>I</u>NSTALLMENT</html>");

		extraButtons[0] = clearButton;
		extraButtons[1] = undoButton;
		extraButtons[2] = discountButton;
		extraButtons[3] = installmentButton;

		for (int i = 0; i < extraButtons.length; i++) {
			extraButtons[i].addActionListener(this);
			extraButtons[i].setFocusable(false);
			extraButtons[i].setPreferredSize(new Dimension(170, 40));
			extraButtons[i].setFont(CUSTOM_FONT);
			extraButtons[i].setForeground(FONT_COLOR);
			extraButtons[i].setBackground(BUTTON_BACKGROUND_COLOR);
			extraButtonsPanel.add(extraButtons[i]);
		}

		// Adding extraButtonsPanel to oue weaponPanel, at bottom of weaponPanel
		weaponPanel.add(extraButtonsPanel);

		// Adding our weaponPanel to our JFrame
		this.add(weaponPanel);

		// JPanel that will contain another JPanel of user guns and prices
		pricePanel = new JPanel();
		pricePanel.setPreferredSize(new Dimension(500, 700));
		pricePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 45));
		pricePanel.setBackground(BACKGROUND_COLOR);

		// Creating a JLabel that contains user guns and prices
		weaponOrderPanel.setPreferredSize(new Dimension(400, 450));
		weaponOrderPanel.setBackground(new Color(129, 133, 137, 255));
		weaponOrderPanel.setBorder(new EmptyBorder(25, 25, 25, 25));
		weaponOrderPanel.setLayout(new GridLayout(20, 1));

		pricePanel.add(weaponOrderPanel);

		// JPanel that will contains the total of our user's gun orders
		totalPanel = new JPanel();
		totalPanel.setBackground(new Color(129, 133, 137, 255));
		totalPanel.setPreferredSize(new Dimension(400, 85));
		totalPanel.setLayout(new BorderLayout());

		// JLabel that will show user's total amount

		decimalFormat = new DecimalFormat("#.##");
		decimalFormat.setGroupingUsed(true);
		decimalFormat.setGroupingSize(3);

		totalLabel = new JLabel("TOTAL: $" + decimalFormat.format(userTotal));
		totalLabel.setFont(CUSTOM_FONT);
		totalLabel.setForeground(FONT_COLOR);
		totalLabel.setBorder(new EmptyBorder(0, 25, 0, 0));

		// Adding our JLabel containing user total to our JPanel
		totalPanel.add(totalLabel);

		// Adding our totalPanel to our pricePanel
		pricePanel.add(totalPanel);

		// Adding our pricePanel to our JFrame
		this.add(pricePanel);

		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void buttonPressedAudio() {
		try {
			streamAudio = AudioSystem.getAudioInputStream(BUTTON_PRESSED_AUDIO_URL);
			audioClip = AudioSystem.getClip();
			audioClip.open(streamAudio);

			gainControl = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-6.0f);

			audioClip.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void noItemsAudio() {
		try {
			streamAudio = AudioSystem.getAudioInputStream(NO_ITEMS_AUDIO_URL);
			audioClip = AudioSystem.getClip();
			audioClip.open(streamAudio);

			gainControl = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-6.0f);

			audioClip.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void buyGunAudio() {
		try {
			streamAudio = AudioSystem.getAudioInputStream(BUY_GUN_AUDIO_URL);
			audioClip = AudioSystem.getClip();
			audioClip.open(streamAudio);

			gainControl = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-6.0f);

			audioClip.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void buyAmmoAudio() {
		try {
			streamAudio = AudioSystem.getAudioInputStream(BUY_BULLETS_AUDIO_URL);
			audioClip = AudioSystem.getClip();
			audioClip.open(streamAudio);

			gainControl = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-6.0f);

			audioClip.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void buyEquipmentAudio() {
		try {
			streamAudio = AudioSystem.getAudioInputStream(BUY_EQUIPMENT_AUDIO_URL);
			audioClip = AudioSystem.getClip();
			audioClip.open(streamAudio);

			gainControl = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-32.0f);

			audioClip.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void menuBackgroundAudio() {
		try {
			streamAudio = AudioSystem.getAudioInputStream(MENU_BACKGROUND_AUDIO_URL);
			audioClip = AudioSystem.getClip();
			audioClip.open(streamAudio);

			gainControl = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-32.0f);

			audioClip.loop(Clip.LOOP_CONTINUOUSLY); // makes clip loop continuously
			audioClip.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		buttonPressedAudio();

		if (arg0.getSource() == pistolButton) {
			new PistolMenu(); // PistolMenu constructor
			this.dispose();
		} else if (arg0.getSource() == shotgunButton) {
			new ShotgunMenu();
			this.dispose();
		} else if (arg0.getSource() == smgButton) {
			new SubMachineGunMenu();
			this.dispose();
		} else if (arg0.getSource() == rifleButton) {
			new RifleMenu();
			this.dispose();
		} else if (arg0.getSource() == sniperButton) {
			new SniperMenu();
			this.dispose();
		} else if (arg0.getSource() == lmgButton) {
			new LargeMachineGunMenu();
			this.dispose();
		} else if (arg0.getSource() == ammoButton) {
			new AmmoMenu();
			this.dispose();
		} else if (arg0.getSource() == equipmentButton) {
			new EquipmentMenu();
			this.dispose();
		} else if (arg0.getSource() == buyButton) {
			confirmBuy();
		} else if (arg0.getSource() == clearButton) {
			confirmClear();
		} else if (arg0.getSource() == undoButton) {
			confirmUndo();
		} else if (arg0.getSource() == discountButton) {
			askDiscount();
		} else if (arg0.getSource() == installmentButton) {
			askInstallmentPlan();
		} else if (arg0.getSource() == exitButton) {
			confirmClose();
		}

	}

	// Method that adds a comma after thousands place
	public static void formatPriceNumbers() {
		decimalFormat = new DecimalFormat("#.##");
		decimalFormat.setGroupingUsed(true);
		decimalFormat.setGroupingSize(3);
	}

	public void noItemsMessage() {
		noItemsAudio();
		JOptionPane.showMessageDialog(this, "No Items In Order!", "No Items", JOptionPane.WARNING_MESSAGE);
	}

	public void confirmBuy() {

		if (itemsBoughtTracker <= 0) {
			noItemsMessage();
		} else {
			formatPriceNumbers();
			int confirmBuyChoice = JOptionPane.showConfirmDialog(this,
					"Buy Orders for $" + decimalFormat.format(userTotal), "Buy Confirmation",
					JOptionPane.YES_NO_OPTION);
			if (confirmBuyChoice == JOptionPane.YES_OPTION) {
				buyGunAudio();
				JOptionPane.showMessageDialog(this, "Paid $" + decimalFormat.format(userTotal), "Paid Message",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public void confirmClose() {
		int confirmCloseChoice = JOptionPane.showConfirmDialog(this, "Exit Buy Menu?", "Exit Confirmation",
				JOptionPane.YES_NO_OPTION);
		if (confirmCloseChoice == JOptionPane.YES_OPTION) {
			this.dispose();
		}
	}

	public void confirmClear() {
		if (itemsBoughtTracker <= 0) {
			noItemsMessage();
		} else {
			int confirmClearChoice = JOptionPane.showConfirmDialog(this, "Clear Weapon Order/s?", "Clear Confirmation",
					JOptionPane.YES_NO_OPTION);
			if (confirmClearChoice == JOptionPane.YES_OPTION) {

				weaponOrderPrices.clear();
				weaponOrderLabels.clear();
				itemsBoughtTracker = 0;
				userTotal = 0;

				formatPriceNumbers();

				totalLabel.setText("TOTAL: $" + decimalFormat.format(userTotal));
				weaponOrderPanel.removeAll();
				this.repaint();
			}
		}
	}

	public void confirmUndo() {
		if (itemsBoughtTracker <= 0) {
			noItemsMessage();
		} else {
			int confirmUndoChoice = JOptionPane.showConfirmDialog(this, "Undo Last Entered Order?", "Undo Confirmation",
					JOptionPane.YES_NO_OPTION);
			if (confirmUndoChoice == JOptionPane.YES_OPTION) {
				undoLastAddedOrder();
			}
		}
	}

	public void undoLastAddedOrder() {
		itemsBoughtTracker--;

		weaponOrderPanel.removeAll();
		weaponOrderLabels.remove(weaponOrderLabels.size() - 1);

		for (JLabel eachWeaponOrder : weaponOrderLabels) {
			weaponOrderPanel.add(eachWeaponOrder);
		}

		// Subtracts last added order price from userTotal
		userTotal = userTotal - weaponOrderPrices.get(weaponOrderPrices.size() - 1); // subtracts userTotal
		totalLabel.setText("TOTAL: $" + decimalFormat.format(userTotal));
		weaponOrderPrices.remove(weaponOrderPrices.size() - 1);

		weaponOrderPanel.repaint();
	}

	public void askDiscount() {
		if (itemsBoughtTracker <= 0) {
			noItemsMessage();
		} else {
			discountSpinnerValues = new SpinnerNumberModel(5, 5, 100, 5); // increments of 5
			discountSpinner = new JSpinner(discountSpinnerValues);
			discountSpinner.setEditor(new JSpinner.DefaultEditor(discountSpinner));

			String[] discountSpinnerChoices = { "Confirm", "Cancel" };
			int discountAmountChoice = JOptionPane.showOptionDialog(this, discountSpinner, "Enter Discount Percentage",
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, discountSpinnerChoices, null);

			if (discountAmountChoice == 0) {
				discountAmount = (int) discountSpinner.getValue();
				showDiscount();
			}
		}

	}

	public void showDiscount() {
		JOptionPane.showMessageDialog(this,
				"Discounted Total Price (" + (int) discountAmount + "%): $"
						+ (userTotal - userTotal * (discountAmount / 100)),
				"Display Discount", JOptionPane.INFORMATION_MESSAGE);
	}

	public void askInstallmentPlan() {
		if (itemsBoughtTracker <= 0) {
			noItemsMessage();
		} else {
			installmentSpinnerValues = new SpinnerNumberModel(6, 6, 24, 6); // increments of 6
			installmentSpinner = new JSpinner(installmentSpinnerValues);
			installmentSpinner.setEditor(new JSpinner.DefaultEditor(installmentSpinner));

			String[] installmentSpinnerChoices = { "Confirm", "Cancel" };
			int installmentAmountChoice = JOptionPane.showOptionDialog(this, installmentSpinner,
					"Enter Installment Plan Months", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
					installmentSpinnerChoices, null);

			if (installmentAmountChoice == 0) {
				installmentAmount = (int) installmentSpinner.getValue();
				calculateInstallmentPlan();
			}
		}
	}

	public void calculateInstallmentPlan() {

		interestAmount = installmentAmount / 6;
		/* 1% (6 months), 2% (12 months), 3% (18 months), 4% (24 months) */

		JOptionPane.showMessageDialog(this,
				"Payment per month for " + installmentAmount + " months with " + interestAmount + "% interest: "
						+ Math.ceil((userTotal / installmentAmount) + (userTotal * (interestAmount / 100))),
				"Installment Monthly Payment", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void addWeaponPrice(Integer orderPrice) {
		userTotal += orderPrice;
		weaponOrderPrices.add(orderPrice);
	}

	public static void addWeaponOrder(JLabel orderDetails) {
		weaponOrderPanel.removeAll(); // removes all components
		weaponOrderLabels.add(orderDetails); // adds newly added orderDetails to our ArrayList

		formatPriceNumbers();

		totalLabel.setText("TOTAL: $" + decimalFormat.format(userTotal));
		itemsBoughtTracker += 1;

		// Add each element in our ArrayList to our weaponOrderPanel
		for (JLabel eachWeaponOrder : weaponOrderLabels) {
			weaponOrderPanel.add(eachWeaponOrder);
		}
		// Repaint weaponOrderPanel w/ ArrayList elements
		weaponOrderPanel.repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

		switch (e.getKeyChar()) {

		case '1':
			pistolButton.doClick();
			break;

		case '2':
			shotgunButton.doClick();
			break;

		case '3':
			smgButton.doClick();
			break;

		case '4':
			rifleButton.doClick();
			break;

		case '5':
			sniperButton.doClick();
			break;

		case '6':
			lmgButton.doClick();
			break;

		case '7':
			ammoButton.doClick();
			break;

		case '8':
			equipmentButton.doClick();
			break;

		case '9':
			buyButton.doClick();
			break;

		case '0':
			exitButton.doClick();
			break;

		case 'b':
			buyButton.doClick();
			break;

		case 'c':
			clearButton.doClick();
			break;

		case 'u':
			undoButton.doClick();
			break;

		case 'd':
			discountButton.doClick();
			break;

		case 'i':
			installmentButton.doClick();
			break;

		}

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}