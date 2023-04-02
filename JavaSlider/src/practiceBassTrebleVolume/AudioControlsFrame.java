package practiceBassTrebleVolume;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AudioControlsFrame extends JFrame implements ChangeListener {

	JPanel bassPanel;
	JPanel treblePanel;
	JPanel volumePanel;

	JSlider bassSlider;
	JSlider trebleSlider;
	JSlider volumeSlider;

	JLabel bassLabel;
	JLabel trebleLabel;
	JLabel volumeLabel;

	public AudioControlsFrame() {
		this.setTitle("[Audio Controls]");
		this.setSize(900, 900);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(0, 128, 128));
		this.setLayout(null);

		bassPanel = new JPanel();
		bassPanel.setBounds(25, 40, 250, 800);
		bassPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		bassSlider = new JSlider(0, 100, 50);
		bassSlider.setPreferredSize(new Dimension(200, 500));

		bassSlider.setPaintTicks(true);
		bassSlider.setMinorTickSpacing(10);

		bassSlider.setPaintTrack(true);
		bassSlider.setMajorTickSpacing(25);

		bassSlider.setPaintLabels(true);
		bassSlider.setOrientation(JSlider.VERTICAL);
		bassSlider.addChangeListener(this);

		bassLabel = new JLabel();
		bassLabel.setText("Bass: " + bassSlider.getValue());
		bassLabel.setHorizontalAlignment(JLabel.CENTER);
		bassLabel.setFont(new Font("Arial", Font.BOLD, 16));

		bassPanel.add(bassSlider);
		bassPanel.add(bassLabel);

		treblePanel = new JPanel();
		treblePanel.setBounds(325, 40, 250, 800);
		treblePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		trebleSlider = new JSlider(0, 100, 50);
		trebleSlider.setPreferredSize(new Dimension(200, 500));

		trebleSlider.setPaintTicks(true);
		trebleSlider.setMinorTickSpacing(10);

		trebleSlider.setPaintTrack(true);
		trebleSlider.setMajorTickSpacing(25);

		trebleSlider.setPaintLabels(true);
		trebleSlider.setOrientation(JSlider.VERTICAL);
		trebleSlider.addChangeListener(this);

		trebleLabel = new JLabel();
		trebleLabel.setText("Treble: " + trebleSlider.getValue());
		trebleLabel.setHorizontalAlignment(JLabel.CENTER);
		trebleLabel.setFont(new Font("Arial", Font.BOLD, 16));

		treblePanel.add(trebleSlider);
		treblePanel.add(trebleLabel);

		volumePanel = new JPanel();
		volumePanel.setBounds(625, 40, 250, 800);
		volumePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		volumeSlider = new JSlider(0, 100, 50);

		volumeSlider.setPaintTicks(true);
		volumeSlider.setMinorTickSpacing(10);

		volumeSlider.setPaintTrack(true);
		volumeSlider.setMajorTickSpacing(25);

		// TODO: finish creating volumeSlider & volumeLabel

		this.add(bassPanel);
		this.add(treblePanel);
		this.add(volumePanel);
		this.setVisible(true);
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		bassLabel.setText("Bass: " + bassSlider.getValue());
		trebleLabel.setText("Treble: " + trebleSlider.getValue());
	}

}
