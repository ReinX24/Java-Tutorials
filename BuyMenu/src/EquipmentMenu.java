
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.net.URL;

public class EquipmentMenu extends JFrame implements ActionListener, KeyListener, MouseListener {

    private static final long serialVersionUID = 1L;
	JPanel gunButtonsPanel;
    JPanel descPanel;

    JButton kevlarVestButton;
    JButton kevlarVestAndHelmetButton;
    JButton grenadeButton;
    JButton smokeButton;
    JButton flashbangButon;
    JButton nightVisionButton;

    JButton exitButton;

    JButton[] gunArray = new JButton[7];

    JLabel gunOrderLabel;

    JPanel gunPriceAndModelPanel;

    ImageIcon gunIcon;
    JLabel gunIconLabel;
    JLabel gunNamePriceLabel;

    DecimalFormat decimalFormat;

    BuyMenuFrame mainBuyMenu;

    final URL EQUIPMENT_MENU_ICON_URL = getClass().getResource("kevlarVestPhoto.png");
    final URL KEVLAR_ICON_URL = getClass().getResource("kevlarVestPhoto.png");
    final URL KEVLAR_HELMET_ICON_URL = getClass()
            .getResource("kevlarVestAndHelmetPhoto.png");
    final URL HE_GRENADE_ICON_URL = getClass().getResource("grenadePhoto.png");
    final URL SMOKE_GRENADE_ICON_URL = getClass().getResource("smokePhoto.png");
    final URL FLASH_GRENADE_ICON_URL = getClass().getResource("flashPhoto.png");
    final URL NIGHT_VISION_URL = getClass().getResource("nightVisionPhoto.png");

    EquipmentMenu() {

        mainBuyMenu = new BuyMenuFrame();

        this.setTitle("EQUIPMENT MENU");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(1, 2));
        this.setResizable(false);
        this.addKeyListener(this);
        this.setIconImage(new ImageIcon(EQUIPMENT_MENU_ICON_URL).getImage());

        gunButtonsPanel = new JPanel();
        gunButtonsPanel.setPreferredSize(new Dimension(500, 775));
        gunButtonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 20));
        gunButtonsPanel.setBorder(new EmptyBorder(25, 75, 25, 25));
        gunButtonsPanel.setBackground(new Color(129, 133, 137, 128));

        kevlarVestButton = new JButton("1. KEVLAR VEST");
        kevlarVestAndHelmetButton = new JButton("2. KEVLAR VEST AND HELMET");
        grenadeButton = new JButton("3. H.E. GRENADE");
        smokeButton = new JButton("4. SMOKE GRENADE");
        flashbangButon = new JButton("5. FLASHBANG");
        nightVisionButton = new JButton("6. NIGHTVISION GOGGLES");
        exitButton = new JButton("0. CANCEL");

        gunArray[0] = kevlarVestButton;
        gunArray[1] = kevlarVestAndHelmetButton;
        gunArray[2] = grenadeButton;
        gunArray[3] = smokeButton;
        gunArray[4] = flashbangButon;
        gunArray[5] = nightVisionButton;
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
            mainBuyMenu.buyEquipmentAudio();
            if (e.getSource() == kevlarVestButton) {
                pistolOrder("KEVLAR VEST", 650);
            } else if (e.getSource() == kevlarVestAndHelmetButton) {
                pistolOrder("KEVLAR VEST AND HELMET", 1000);
            } else if (e.getSource() == grenadeButton) {
                pistolOrder("H.E. GRENADE", 300);
            } else if (e.getSource() == smokeButton) {
                pistolOrder("SMOKE GRENADE", 200);
            } else if (e.getSource() == flashbangButon) {
                pistolOrder("FLASHBANG", 200);
            } else if (e.getSource() == nightVisionButton) {
                pistolOrder("NIGHTVISION GOGGLES", 1250);
            }
        }

    }

    public void pistolOrder(String gunModel, int gunPrice) {

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
                kevlarVestButton.doClick();
                break;

            case '2':
                kevlarVestAndHelmetButton.doClick();
                break;

            case '3':
                grenadeButton.doClick();
                break;

            case '4':
                smokeButton.doClick();
                break;

            case '5':
                flashbangButon.doClick();
                break;

            case '6':
                nightVisionButton.doClick();
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
        if (e.getComponent() == kevlarVestButton) {
            gunIcon = new ImageIcon(KEVLAR_ICON_URL);
            gunNamePriceLabel.setText("KEVLAR VEST : $650");
            changeIconLabel();
        }

        if (e.getComponent() == kevlarVestAndHelmetButton) {
            gunIcon = new ImageIcon(KEVLAR_HELMET_ICON_URL);
            gunNamePriceLabel.setText("KEVLAR VEST AND HELMET : $1,000");
            changeIconLabel();
        }

        if (e.getComponent() == grenadeButton) {
            gunIcon = new ImageIcon(HE_GRENADE_ICON_URL);
            gunNamePriceLabel.setText("H.E. GRENADE : $300");
            changeIconLabel();
        }

        if (e.getComponent() == smokeButton) {
            gunIcon = new ImageIcon(SMOKE_GRENADE_ICON_URL);
            gunNamePriceLabel.setText("SMOKE GRENADE : $300");
            changeIconLabel();
        }

        if (e.getComponent() == flashbangButon) {
            gunIcon = new ImageIcon(FLASH_GRENADE_ICON_URL);
            gunNamePriceLabel.setText("FLASHBANG : $200");
            changeIconLabel();
        }

        if (e.getComponent() == nightVisionButton) {
            gunIcon = new ImageIcon(NIGHT_VISION_URL);
            gunNamePriceLabel.setText("NIGHTVISION GOGGLES : $1,250");
            changeIconLabel();
        }

    }

    public void mouseExited(MouseEvent e) {

        if (e.getComponent() == kevlarVestButton) {
            resetIconLabel(kevlarVestButton);
        }

        if (e.getComponent() == kevlarVestAndHelmetButton) {
            resetIconLabel(kevlarVestAndHelmetButton);
        }

        if (e.getComponent() == grenadeButton) {
            resetIconLabel(grenadeButton);
        }

        if (e.getComponent() == smokeButton) {
            resetIconLabel(smokeButton);
        }

        if (e.getComponent() == flashbangButon) {
            resetIconLabel(flashbangButon);
        }

        if (e.getComponent() == nightVisionButton) {
            resetIconLabel(nightVisionButton);
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

}