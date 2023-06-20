import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.net.URL;

public class SubMachineGunMenu extends JFrame implements ActionListener, KeyListener, MouseListener {

	private static final long serialVersionUID = 1L;
	JPanel gunButtonsPanel;
	JPanel descPanel;

	JButton mac10Button;
	JButton tmpButton;
	JButton mp5NavyButton;
	JButton umpButton;
	JButton p90Button;

	JButton exitButton;

	JButton[] gunArray = new JButton[6];

	JLabel gunOrderLabel;

	JPanel gunPriceAndModelPanel;

	ImageIcon gunIcon;
	JLabel gunIconLabel;
	JLabel gunNamePriceLabel;

	DecimalFormat decimalFormat;

	BuyMenuFrame mainBuyMenu;

	final URL SMG_MENU_ICON_URL = getClass().getResource("tmpPhoto.png");
	final URL MAC10_ICON_URL = getClass().getResource("mac10Photo.png");
	final URL TMP_ICON_URL = getClass().getResource("tmpPhoto.png");
	final URL MP5_ICON_URL = getClass().getResource("mp5Photo.png");
	final URL UMP_ICON_URL = getClass().getResource("ump45Photo.png");
	final URL P90_ICON_URL = getClass().getResource("p90Photo.png");

	SubMachineGunMenu() {

		mainBuyMenu = new BuyMenuFrame();

		this.setTitle("SMG MENU");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(1, 2));
		this.setResizable(false);
		this.addKeyListener(this);
		this.setIconImage(new ImageIcon(SMG_MENU_ICON_URL).getImage());

		gunButtonsPanel = new JPanel();
		gunButtonsPanel.setPreferredSize(new Dimension(500, 775));
		gunButtonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 20));
		gunButtonsPanel.setBorder(new EmptyBorder(25, 75, 25, 25));
		gunButtonsPanel.setBackground(new Color(129, 133, 137, 128));

		mac10Button = new JButton("1. MAC 10");
		tmpButton = new JButton("2. TMP");
		mp5NavyButton = new JButton("3. MP5 NAVY");
		umpButton = new JButton("4. UMP");
		p90Button = new JButton("5. P90");
		exitButton = new JButton("0. CANCEL");

		gunArray[0] = mac10Button;
		gunArray[1] = tmpButton;
		gunArray[2] = mp5NavyButton;
		gunArray[3] = umpButton;
		gunArray[4] = p90Button;
		gunArray[5] = exitButton;

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
			if (e.getSource() == mac10Button) {
				gunOrder("MAC 10", 1400);
			} else if (e.getSource() == tmpButton) {
				gunOrder("TMP", 1250);
			} else if (e.getSource() == mp5NavyButton) {
				gunOrder("MP5 NAVY", 1500);
			} else if (e.getSource() == umpButton) {
				gunOrder("UMP", 1700);
			} else if (e.getSource() == p90Button) {
				gunOrder("P90", 2350);
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
			mac10Button.doClick();
			break;

		case '2':
			tmpButton.doClick();
			break;

		case '3':
			mp5NavyButton.doClick();
			break;

		case '4':
			umpButton.doClick();
			break;

		case '5':
			p90Button.doClick();
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
		if (e.getComponent() == mac10Button) {
			gunIcon = new ImageIcon(MAC10_ICON_URL);
			gunNamePriceLabel.setText("MAC10 : $1,400");
			changeIconLabel();
		}

		if (e.getComponent() == tmpButton) {
			gunIcon = new ImageIcon(TMP_ICON_URL);
			gunNamePriceLabel.setText("TMP : $1,250");
			changeIconLabel();
		}

		if (e.getComponent() == mp5NavyButton) {
			gunIcon = new ImageIcon(MP5_ICON_URL);
			gunNamePriceLabel.setText("MP5 NAVY : $1,500");
			changeIconLabel();
		}

		if (e.getComponent() == umpButton) {
			gunIcon = new ImageIcon(UMP_ICON_URL);
			gunNamePriceLabel.setText("UMP : $1,700");
			changeIconLabel();
		}

		if (e.getComponent() == p90Button) {
			gunIcon = new ImageIcon(P90_ICON_URL);
			gunNamePriceLabel.setText("P90 : $2,350");
			changeIconLabel();
		}

	}

	public void mouseExited(MouseEvent e) {

		if (e.getComponent() == mac10Button) {
			resetIconLabel(mac10Button);
		}

		if (e.getComponent() == tmpButton) {
			resetIconLabel(tmpButton);
		}

		if (e.getComponent() == mp5NavyButton) {
			resetIconLabel(mp5NavyButton);
		}

		if (e.getComponent() == umpButton) {
			resetIconLabel(umpButton);
		}

		if (e.getComponent() == p90Button) {
			resetIconLabel(p90Button);
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

}