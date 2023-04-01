import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.FontUIResource;

public class SliderDemo implements ChangeListener {

	JFrame mainFrame;
	JPanel panelOne;
	JLabel labelOne;
	JSlider mainSlider;

	public SliderDemo() {
		mainFrame = new JFrame("[Slider Demo]");
		panelOne = new JPanel();
		labelOne = new JLabel();

		// Min, Max, Start Num
		mainSlider = new JSlider(0, 100, 50); // parenthesis consists of range of choices, 0 - 100
		mainSlider.setPreferredSize(new Dimension(400, 200));

		// Adding ticks to our slider, little marks below the slider

		// Adding small ticks
		mainSlider.setPaintTicks(true);
		mainSlider.setMinorTickSpacing(10); // adds a tick for each interval of 10

		// Adding large ticks
		mainSlider.setPaintTrack(true);
		mainSlider.setMajorTickSpacing(25); // adds a large tick for each interval of 25

		// Adding the numbers
		mainSlider.setPaintLabels(true); // shows major tick intervals
		mainSlider.setFont(new Font("Arial", Font.PLAIN, 16));

		// Changing the slider bar to vertical
		mainSlider.setOrientation(SwingConstants.VERTICAL);
//		mainSlider.setOrientation(SwingConstants.HORIZONTAL);

		// Setting the content of our JLabel, labelOne
		labelOne.setText("°C : " + mainSlider.getValue());
		labelOne.setFont(new Font("Arial", Font.BOLD, 32));

		// Recording the actions that we do with our mainSlider
		mainSlider.addChangeListener(this); // when changing the slider position, changes labelOne text

		// Adding the slider to our panel
		panelOne.add(mainSlider);
		panelOne.add(labelOne); // label will be under slider, to be used to show temperatures

		mainFrame.add(panelOne);
		mainFrame.setSize(400, 400);
		mainFrame.setVisible(true);

	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		labelOne.setText("°C : " + mainSlider.getValue()); // changes value of labelOne
	}

}
