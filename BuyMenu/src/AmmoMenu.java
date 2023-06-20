import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.net.URL;

public class AmmoMenu extends JFrame implements ActionListener, KeyListener, MouseListener {

	private static final long serialVersionUID = 1L;
	JPanel gunButtonsPanel;
	JPanel descPanel;

	JButton pistolAmmoButton;
	JButton shotgunAmmoButton;
	JButton smgAmmoButton;
	JButton rifleAmmoButton;
	JButton lmgAmmoButton;
	JButton sniperAmmoButton;

	JButton exitButton;

	JButton[] gunArray = new JButton[7];

	JLabel gunOrderLabel;

	JPanel gunPriceAndModelPanel;

	ImageIcon gunIcon;
	JLabel gunIconLabel;
	JLabel gunNamePriceLabel;

	DecimalFormat decimalFormat;

	int gunAmmoAmount;
	SpinnerModel ammoSpinnerValues;
	JSpinner ammoSpinner;

	BuyMenuFrame mainBuyMenu;

	final URL AMMO_MENU_ICON_URL = getClass().getResource("rifleAmmoPhoto.png");
	final URL PISTOL_AMMO_URL = getClass().getResource("pistolAmmoPhoto.png");
	final URL SHOTGUN_AMMO_URL = getClass().getResource("shotgunAmmoPhoto.png");
	final URL SMG_AMMO_URL = getClass().getResource("smgAmmoPhoto.png");
	final URL RIFLE_AMMO_URL = getClass().getResource("rifleAmmoPhoto.png");
	final URL LMG_AMMO_URL = getClass().getResource("lmgAmmoPhoto.png");
	final URL SNIPER_AMMO_URL = getClass().getResource("sniperAmmoPhoto.png");

	AmmoMenu() {

		mainBuyMenu = new BuyMenuFrame();

		this.setTitle("AMMO MENU");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(1, 2));
		this.setResizable(false);
		this.addKeyListener(this);
		this.setIconImage(new ImageIcon(AMMO_MENU_ICON_URL).getImage());

		gunButtonsPanel = new JPanel();
		gunButtonsPanel.setPreferredSize(new Dimension(500, 775));
		gunButtonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 20));
		gunButtonsPanel.setBorder(new EmptyBorder(25, 75, 25, 25));
		gunButtonsPanel.setBackground(new Color(129, 133, 137, 128));

		pistolAmmoButton = new JButton("1. PISTOL AMMO");
		shotgunAmmoButton = new JButton("2. SHOTGUN AMMO");
		smgAmmoButton = new JButton("3. SMG AMMO");
		rifleAmmoButton = new JButton("4. RIFLE AMMO");
		lmgAmmoButton = new JButton("5. LMG AMMO");
		sniperAmmoButton = new JButton("6. SNIPER AMMO");

		exitButton = new JButton("0. CANCEL");

		gunArray[0] = pistolAmmoButton;
		gunArray[1] = shotgunAmmoButton;
		gunArray[2] = smgAmmoButton;
		gunArray[3] = rifleAmmoButton;
		gunArray[4] = lmgAmmoButton;
		gunArray[5] = sniperAmmoButton;

		gunArray[6] = exitButton;

		for (int i = 0; i < gunArray.length; i++) {
			gunArray[i].setPreferredSize(new Dimension(400, 40));
			gunArray[i].addActionListener(this);
			gunArray[i].setHorizontalAlignment(JButton.LEFT);
			gunArray[i].setFocusable(false);
			gunArray[i].setBackground(new Color(129, 133, 137, 255));
			gunArray[i].setForeground(new Color(255, 195, 0));
			gunArray[i].setFont(BuyMenuFrame.CUSTOM_FONT);
			gunArray[i].addMouseListener(this);
			gunButtonsPanel.add(gunArray[i]);
		}

		this.add(gunButtonsPanel);

		descPanel = new JPanel();
		descPanel.setPreferredSize(new Dimension(500, 775));
		descPanel.setBackground(new Color(129, 133, 137, 128));
		descPanel.setBorder(new EmptyBorder(40, 0, 0, 0));

		gunPriceAndModelPanel = new JPanel();
		gunPriceAndModelPanel.setLayout(new GridLayout(2, 1)); // 2 rows, 1 column
		gunPriceAndModelPanel.setPreferredSize(new Dimension(400, 580));
		gunPriceAndModelPanel.setBackground(new Color(129, 133, 137, 255));

		// Adding ImageIcon that will hold our gun icons
		gunIcon = new ImageIcon();
		gunIconLabel = new JLabel(gunIcon);

		gunPriceAndModelPanel.add(gunIconLabel);

		// Adding JLabel that will contain name and price of gun
		gunNamePriceLabel = new JLabel("", JLabel.CENTER);
		gunNamePriceLabel.setFont(BuyMenuFrame.CUSTOM_FONT);
		gunNamePriceLabel.setForeground(new Color(255, 195, 0));

		gunPriceAndModelPanel.add(gunNamePriceLabel);

		// Adding our JPanel that contains an ImageIcon and JLabel to our descPanel
		descPanel.add(gunPriceAndModelPanel);

		this.add(descPanel);

		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == exitButton) {
			mainBuyMenu.buttonPressedAudio();
			this.dispose();
			mainBuyMenu.createBuyMenuFrame();
		} else {
			if (e.getSource() == pistolAmmoButton) {
				askAmmoAmount("PISOL", 1, "bullet"); // 1 dollar per bullet
			} else if (e.getSource() == shotgunAmmoButton) {
				askAmmoAmount("SHOTGUN", 3, "shell"); // 3 dollars per shell
			} else if (e.getSource() == smgAmmoButton) {
				askAmmoAmount("SMG", 2, "bullet"); // 2 dollars per bullet
			} else if (e.getSource() == rifleAmmoButton) {
				askAmmoAmount("RIFLE", 3, "bullet"); // 3 dollars per bullet
			} else if (e.getSource() == lmgAmmoButton) {
				askAmmoAmount("LMG", 4, "bullet");// 4 dollars per bullet
			} else if (e.getSource() == sniperAmmoButton) {
				askAmmoAmount("SNIPER", 5, "bullet"); // 5 dollars per bullet
			}
		}

	}

	public void askAmmoAmount(String ammoType, int perBulletPrice, String ammoModel) {

		ammoSpinnerValues = new SpinnerNumberModel(1, 1, 1000, 1);
		ammoSpinner = new JSpinner(ammoSpinnerValues);

		String[] ammoSpinnerChoices = { "Confirm", "Cancel" };
		int ammoAmountChoice = JOptionPane.showOptionDialog(this, ammoSpinner, "Ammo Amount",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, ammoSpinnerChoices, null);

		gunAmmoAmount = (int) ammoSpinner.getValue();

		if (ammoAmountChoice == JOptionPane.YES_OPTION) {
			ammoOrder(ammoType + " AMMO", gunAmmoAmount * perBulletPrice, gunAmmoAmount);
		}
	}

	public void ammoOrder(String ammoType, int ammoPrice, int ammoAmount) {

		if (BuyMenuFrame.itemsBoughtTracker == BuyMenuFrame.maxBuyItems) {
			JOptionPane.showMessageDialog(this, "Buy Limit Reached!", "Buy Limit Message", JOptionPane.WARNING_MESSAGE);
		} else {
			decimalFormat = new DecimalFormat("#.##");
			decimalFormat.setGroupingUsed(true);
			decimalFormat.setGroupingSize(3);

			gunOrderLabel = new JLabel(ammoType + " (" + ammoAmount + ") : $" + decimalFormat.format(ammoPrice));
			gunOrderLabel.setFont(BuyMenuFrame.CUSTOM_FONT);
			gunOrderLabel.setForeground(BuyMenuFrame.FONT_COLOR);

			BuyMenuFrame.addWeaponPrice(ammoPrice);
			BuyMenuFrame.addWeaponOrder(gunOrderLabel);

			mainBuyMenu.buyAmmoAudio();
			this.dispose();
			mainBuyMenu.createBuyMenuFrame();
		}

	}

	public void invalidInputMessage() {
		JOptionPane.showMessageDialog(this, "Invalid Ammo Input!", "Invalid Message", JOptionPane.INFORMATION_MESSAGE);
	}

	public void keyPressed(KeyEvent e) {

	}

	public void keyReleased(KeyEvent e) {

		switch (e.getKeyChar()) {

		case '1':
			pistolAmmoButton.doClick();
			break;

		case '2':
			shotgunAmmoButton.doClick();
			break;

		case '3':
			smgAmmoButton.doClick();
			break;

		case '4':
			rifleAmmoButton.doClick();
			break;

		case '5':
			lmgAmmoButton.doClick();
			break;

		case '6':
			sniperAmmoButton.doClick();
			break;

		case '0':
			exitButton.doClick();
			break;

		}

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	// Changes the ImageIcon of our pistolIconLabel
	public void changeIconLabel() {
		gunIconLabel.setIcon(gunIcon);
	}

	// Resets our pistolIconLabel and pistolNamePriceLabel
	public void resetIconLabel(JButton paraButton) {
		gunIcon = new ImageIcon();
		gunIconLabel.setIcon(gunIcon);
		gunNamePriceLabel.setText("");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getComponent() == pistolAmmoButton) {
			gunIcon = new ImageIcon(PISTOL_AMMO_URL);
			gunNamePriceLabel.setText("PISTOL AMMO : $1 per bullet");
			changeIconLabel();
		}

		if (e.getComponent() == shotgunAmmoButton) {
			gunIcon = new ImageIcon(SHOTGUN_AMMO_URL);
			gunNamePriceLabel.setText("SHOTGUN AMMO: $3 per shell");
			changeIconLabel();
		}

		if (e.getComponent() == smgAmmoButton) {
			gunIcon = new ImageIcon(SMG_AMMO_URL);
			gunNamePriceLabel.setText("SMG AMMO : $2 per bullet");
			changeIconLabel();
		}

		if (e.getComponent() == rifleAmmoButton) {
			gunIcon = new ImageIcon(RIFLE_AMMO_URL);
			gunNamePriceLabel.setText("RIFLE AMMO : $3 per bullet");
			changeIconLabel();
		}

		if (e.getComponent() == lmgAmmoButton) {
			gunIcon = new ImageIcon(LMG_AMMO_URL);
			gunNamePriceLabel.setText("LMG AMMO : $4 per bullet");
			changeIconLabel();
		}

		if (e.getComponent() == sniperAmmoButton) {
			gunIcon = new ImageIcon(SNIPER_AMMO_URL);
			gunNamePriceLabel.setText("SNIPER AMMO : $5 per bullet");
			changeIconLabel();
		}

	}

	public void mouseExited(MouseEvent e) {

		if (e.getComponent() == pistolAmmoButton) {
			resetIconLabel(pistolAmmoButton);
		}

		if (e.getComponent() == shotgunAmmoButton) {
			resetIconLabel(shotgunAmmoButton);
		}

		if (e.getComponent() == smgAmmoButton) {
			resetIconLabel(smgAmmoButton);
		}

		if (e.getComponent() == rifleAmmoButton) {
			resetIconLabel(rifleAmmoButton);
		}

		if (e.getComponent() == lmgAmmoButton) {
			resetIconLabel(lmgAmmoButton);
		}

		if (e.getComponent() == sniperAmmoButton) {
			resetIconLabel(sniperAmmoButton);
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

}