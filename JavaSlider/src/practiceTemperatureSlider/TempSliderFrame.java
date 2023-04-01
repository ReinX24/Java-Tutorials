package practiceTemperatureSlider;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TempSliderFrame extends JFrame implements ChangeListener {

	JPanel mainPanel;
	JLabel tempLabel;

	JSlider tempSlider;

	public TempSliderFrame() {
		this.setTitle("[Temperature Slider]");
		this.setSize(300, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(250, 249, 246));
		this.setLocationRelativeTo(null); // JFrame will appear at the center of the screen

		// Finish creating our JSlider
		tempSlider = new JSlider(0, 100, 50);
		tempSlider.setPreferredSize(new Dimension(300, 300));

		// Small ticks
		tempSlider.setPaintTicks(true);
		tempSlider.setMinorTickSpacing(10);

		// Large ticks
		tempSlider.setPaintTrack(true);
		tempSlider.setMajorTickSpacing(25);

		// Adding the numbers to the slider
		tempSlider.setPaintLabels(true);

		// Slider orientation
		tempSlider.setOrientation(JSlider.VERTICAL);

		// Record the slider position changes
		tempSlider.addChangeListener(this);

		tempLabel = new JLabel();
		tempLabel.setText("°C : " + tempSlider.getValue());
		tempLabel.setFont(new Font("Arial", Font.BOLD, 32));

		mainPanel = new JPanel();
		
		mainPanel.add(tempSlider);
		mainPanel.add(tempLabel);

		this.add(mainPanel);
		this.setVisible(true);
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		// Changes the value of our tempLabel when the slider is moved
		tempLabel.setText("°C : " + tempSlider.getValue());
	}

}
