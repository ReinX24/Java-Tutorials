import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.JOptionPane;

public class SoundEffects {

	URL giveTicketSoundURL = getClass().getResource("giveTicketSound.wav");
	URL nextTicketSoundURL = getClass().getResource("nextTicketSound.wav");
	URL noTicketSoundURL = getClass().getResource("noTicketSound.wav");
	URL askResetSoundURL = getClass().getResource("askResetSound.wav");
	URL resetComfirmSound = getClass().getResource("resetConfirmSound.wav");

	AudioInputStream audioInputStream;
	Clip audioClip;
	FloatControl floatControl;

	public void playGiveTicketSound() {
		playSound(giveTicketSoundURL);
	}

	public void playNextTicketSound() {
		playSound(nextTicketSoundURL);
	}

	public void playNoTicketSound() {
		playSound(noTicketSoundURL);
	}
	
	public void playAskResetSound() {
		playSound(askResetSoundURL);
	}
	
	public void playResetConfirmedSound() {
		playSound(resetComfirmSound);
	}

	public void playSound(URL playSound) {
		try {
			audioInputStream = AudioSystem.getAudioInputStream(playSound);
			audioClip = AudioSystem.getClip();
			audioClip.open(audioInputStream);
			floatControl = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
			floatControl.setValue(-24.0f);
			audioClip.start();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Sound effect not found!", "Sound Effect Error Message",
					JOptionPane.WARNING_MESSAGE);
		}
	}

}
