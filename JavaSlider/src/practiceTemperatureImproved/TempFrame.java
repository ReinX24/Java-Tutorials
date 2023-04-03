package practiceTemperatureImproved;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TempFrame extends JFrame implements ChangeListener {

	JPanel tempPanel;
	JSlider tempSlider;
	JLabel titleLabel;
	JLabel celcTempLabel;
	JLabel fahrTempLabel;

	public TempFrame() {
		this.setTitle("[Thermometer]");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(0, 128, 128));

		tempPanel = new JPanel();
		tempPanel.setPreferredSize(new Dimension(300, 700));
		tempPanel.setBackground(new Color(255, 253, 208));
		titleLabel = new JLabel();
		titleLabel.setText("[Thermometer]");
		titleLabel.setPreferredSize(new Dimension(400, 50));
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
		titleLabel.setOpaque(true);
		titleLabel.setBackground(new Color(250, 249, 246));
		titleLabel.setForeground(Color.BLACK);
		titleLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		tempSlider = new JSlider(0, 50, 25);
		tempSlider.setPreferredSize(new Dimension(300, 500));

		tempSlider.setPaintTicks(true);
		tempSlider.setMinorTickSpacing(1);

		tempSlider.setPaintTrack(true);
		tempSlider.setMajorTickSpacing(5);

		tempSlider.setPaintLabels(true);
		tempSlider.setOrientation(JSlider.VERTICAL);
		tempSlider.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		tempSlider.addChangeListener(this);

		celcTempLabel = new JLabel();
		celcTempLabel.setText("Celcius: " + tempSlider.getValue());
		celcTempLabel.setHorizontalAlignment(JLabel.CENTER);
		celcTempLabel.setFont(new Font("Arial", Font.BOLD, 24));

		fahrTempLabel = new JLabel();
		fahrTempLabel.setText("Fahrenheit: " + Math.round(tempSlider.getValue() * 1.8 + 32));
		fahrTempLabel.setHorizontalAlignment(JLabel.CENTER);
		fahrTempLabel.setFont(new Font("Arial", Font.BOLD, 24));

		tempPanel.add(titleLabel);
		tempPanel.add(tempSlider);
		tempPanel.add(celcTempLabel);
		tempPanel.add(fahrTempLabel);

		this.add(tempPanel);
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		celcTempLabel.setText("Celcius: " + tempSlider.getValue());
		fahrTempLabel.setText("Fahrenheit: " + Math.round(tempSlider.getValue() * 1.8 + 32));
	}

}
