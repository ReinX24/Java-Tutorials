import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.net.URL;

public class ShotgunMenu extends JFrame implements ActionListener, KeyListener, MouseListener {

	private static final long serialVersionUID = 1L;
	JPanel gunButtonsPanel;
	JPanel descPanel;

	JButton super90Button;
	JButton xm1014Button;

	JButton exitButton;

	JButton[] gunArray = new JButton[3];

	JLabel gunOrderLabel;

	JPanel gunPriceAndModelPanel;

	ImageIcon gunIcon;
	JLabel gunIconLabel;
	JLabel gunNamePriceLabel;

	DecimalFormat decimalFormat;

	BuyMenuFrame mainBuyMenu;

	final URL SHOTGUN_MENU_ICON_URL = getClass().getResource("m3Photo.png");
	final URL M3_ICON_URL = getClass().getResource("m3Photo.png");
	final URL XM_ICON_URL = getClass().getResource("xm1014Photo.png");

	ShotgunMenu() {

		mainBuyMenu = new BuyMenuFrame();

		this.setTitle("SHOTGUN MENU");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(1, 2));
		this.setResizable(false);
		this.addKeyListener(this);
		this.setIconImage(new ImageIcon(SHOTGUN_MENU_ICON_URL).getImage());

		gunButtonsPanel = new JPanel();
		gunButtonsPanel.setPreferredSize(new Dimension(500, 775));
		gunButtonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 20));
		gunButtonsPanel.setBorder(new EmptyBorder(25, 75, 25, 25));
		gunButtonsPanel.setBackground(new Color(129, 133, 137, 128));

		super90Button = new JButton("1. M3 Super 90");
		xm1014Button = new JButton("2. XM1014");
		exitButton = new JButton("0. CANCEL");

		gunArray[0] = super90Button;
		gunArray[1] = xm1014Button;
		gunArray[2] = exitButton;

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
			if (e.getSource() == super90Button) {
				gunOrder("M3 Super 90", 2350);
			} else if (e.getSource() == xm1014Button) {
				gunOrder("XM 1014", 3000);
			}
		}

	}

	public void gunOrder(String gunModel, int gunPrice) {

		if (BuyMenuFrame.itemsBoughtTracker == BuyMenuFrame.maxBuyItems) {
			JOptionPane.showMessageDialog(this, "Buy Limit Reached!", "Buy Limit Message", JOptionPane.WARNING_MESSAGE);
		} else {
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
			super90Button.doClick();
			break;

		case '2':
			xm1014Button.doClick();
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
		if (e.getComponent() == super90Button) {
			gunIcon = new ImageIcon(M3_ICON_URL);
			gunNamePriceLabel.setText("M3 SUPER 90 : $2,350");
			changeIconLabel();
		}

		if (e.getComponent() == xm1014Button) {
			gunIcon = new ImageIcon(XM_ICON_URL);
			gunNamePriceLabel.setText("XM 1014 : $3,000");
			changeIconLabel();
		}

	}

	public void mouseExited(MouseEvent e) {

		if (e.getComponent() == super90Button) {
			resetIconLabel(super90Button);
		}

		if (e.getComponent() == xm1014Button) {
			resetIconLabel(xm1014Button);
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

}