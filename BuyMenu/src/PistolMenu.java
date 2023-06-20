
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.net.URL;

public class PistolMenu extends JFrame implements ActionListener, KeyListener, MouseListener {

	private static final long serialVersionUID = 1L;
	JPanel gunButtonsPanel;
	JPanel descPanel;

	JButton glockButton;
	JButton uspButton;
	JButton p228Button;
	JButton deagleButton;
	JButton fiveSevenButton;
	JButton dualEliteButton;
	JButton exitButton;

	JButton[] gunArray = new JButton[7];

	JLabel gunOrderLabel;

	JPanel gunPriceAndModelPanel;

	ImageIcon gunIcon;
	JLabel gunIconLabel;
	JLabel gunNamePriceLabel;

	DecimalFormat decimalFormat;

	BuyMenuFrame mainBuyMenu;

	final URL PISTOL_MENU_ICON_URL = getClass().getResource("glockPhoto.png");
	final URL GLOCK_ICON_URL = getClass().getResource("glockPhoto.png");
	final URL USP_ICON_URL = getClass().getResource("usp45Photo.png");
	final URL P228_ICON_URL = getClass().getResource("p228Photo.png");
	final URL DESERT_EAGLE_ICON_URL = getClass().getResource("deserteaglePhoto.png");
	final URL FIVE_SEVEN_ICON_URL = getClass().getResource("fivesevenPhoto.png");
	final URL ELITE_BERETTAS_ICON_URL = getClass().getResource("elitesPhoto.png");

	PistolMenu() {

		mainBuyMenu = new BuyMenuFrame();

		this.setTitle("PISTOL MENU");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(1, 2));
		this.setResizable(false);
		this.addKeyListener(this);
		this.setIconImage(new ImageIcon(PISTOL_MENU_ICON_URL).getImage());

		gunButtonsPanel = new JPanel();
		gunButtonsPanel.setPreferredSize(new Dimension(500, 775));
		gunButtonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 20));
		gunButtonsPanel.setBorder(new EmptyBorder(25, 75, 25, 25));
		gunButtonsPanel.setBackground(new Color(129, 133, 137, 128));

		glockButton = new JButton("1. GLOCK 18");
		uspButton = new JButton("2. USP TACTICAL");
		p228Button = new JButton("3. P228");
		deagleButton = new JButton("4. DESERT EAGLE");
		fiveSevenButton = new JButton("5. FN FIVE-SEVEN");
		dualEliteButton = new JButton("6. DUAL G96 ELITE BERETTAS");
		exitButton = new JButton("0. CANCEL");

		gunArray[0] = glockButton;
		gunArray[1] = uspButton;
		gunArray[2] = p228Button;
		gunArray[3] = deagleButton;
		gunArray[4] = fiveSevenButton;
		gunArray[5] = dualEliteButton;
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
			mainBuyMenu.buyGunAudio();
			if (e.getSource() == glockButton) {
				pistolOrder("GLOCK", 400);
			} else if (e.getSource() == uspButton) {
				pistolOrder("USP TACTICAL", 500);
			} else if (e.getSource() == p228Button) {
				pistolOrder("P228", 600);
			} else if (e.getSource() == deagleButton) {
				pistolOrder("DESERT EAGLE", 650);
			} else if (e.getSource() == fiveSevenButton) {
				pistolOrder("FN FIVE-SEVEN", 750);
			} else if (e.getSource() == dualEliteButton) {
				pistolOrder("DUAL 96G ELITE BERETTAS", 800);
			}
		}

	}

	public void pistolOrder(String gunModel, int gunPrice) {

		if (BuyMenuFrame.itemsBoughtTracker == BuyMenuFrame.maxBuyItems) {
			JOptionPane.showMessageDialog(this, "Buy Limit Reached!", "Buy Limit Message", JOptionPane.WARNING_MESSAGE);
		} else {
			// Adding gunModel and gunPrice to Main Menu pistolOrderLabel and userTotal
			decimalFormat = new DecimalFormat("#.##");
			decimalFormat.setGroupingUsed(true);
			decimalFormat.setGroupingSize(3);

			gunOrderLabel = new JLabel(gunModel + " : $" + decimalFormat.format(gunPrice));
			gunOrderLabel.setFont(BuyMenuFrame.CUSTOM_FONT);
			gunOrderLabel.setForeground(BuyMenuFrame.FONT_COLOR);

			BuyMenuFrame.addWeaponPrice(gunPrice);
			BuyMenuFrame.addWeaponOrder(gunOrderLabel);

			this.dispose();
			mainBuyMenu.createBuyMenuFrame();
		}

	}

	public void keyPressed(KeyEvent e) {

	}

	public void keyReleased(KeyEvent e) {

		switch (e.getKeyChar()) {

		case '1':
			glockButton.doClick();
			break;

		case '2':
			uspButton.doClick();
			break;

		case '3':
			p228Button.doClick();
			break;

		case '4':
			deagleButton.doClick();
			break;

		case '5':
			fiveSevenButton.doClick();
			break;

		case '6':
			dualEliteButton.doClick();
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
		if (e.getComponent() == glockButton) {
			gunIcon = new ImageIcon(GLOCK_ICON_URL);
			gunNamePriceLabel.setText("GLOCK : $400");
			changeIconLabel();
		}

		if (e.getComponent() == uspButton) {
			gunIcon = new ImageIcon(USP_ICON_URL);
			gunNamePriceLabel.setText("USP TACTICAL : $500");
			changeIconLabel();
		}

		if (e.getComponent() == p228Button) {
			gunIcon = new ImageIcon(P228_ICON_URL);
			gunNamePriceLabel.setText("P228 : $600");
			changeIconLabel();
		}

		if (e.getComponent() == deagleButton) {
			gunIcon = new ImageIcon(DESERT_EAGLE_ICON_URL);
			gunNamePriceLabel.setText("DESERT EAGLE : $650");
			changeIconLabel();
		}

		if (e.getComponent() == fiveSevenButton) {
			gunIcon = new ImageIcon(FIVE_SEVEN_ICON_URL);
			gunNamePriceLabel.setText("FN FIVE SEVEN : $750");
			changeIconLabel();
		}

		if (e.getComponent() == dualEliteButton) {
			gunIcon = new ImageIcon(ELITE_BERETTAS_ICON_URL);
			gunNamePriceLabel.setText("DUAL 96G ELITE BERETTAS : $800");
			changeIconLabel();
		}

	}

	public void mouseExited(MouseEvent e) {

		if (e.getComponent() == glockButton) {
			resetIconLabel(glockButton);
		}

		if (e.getComponent() == uspButton) {
			resetIconLabel(uspButton);
		}

		if (e.getComponent() == p228Button) {
			resetIconLabel(p228Button);
		}

		if (e.getComponent() == deagleButton) {
			resetIconLabel(deagleButton);
		}

		if (e.getComponent() == fiveSevenButton) {
			resetIconLabel(fiveSevenButton);
		}

		if (e.getComponent() == dualEliteButton) {
			resetIconLabel(dualEliteButton);
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

}