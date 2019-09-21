package touchfishlavel0;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Music {
	private static boolean mute1 = false;
	private static boolean mute_touch = false;
	private static boolean mute_death = false;
	private static boolean mute_lose = false;
	private static boolean mute_ownthegame = false;
	private static Clip clip1;
	public static Clip touch;
	public static Clip death;
	public static Clip lose;
	public static Clip ownthegame;

	public static void backgroundLoop_death() {// Death the game
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("audio/crash.wav"));
			death = AudioSystem.getClip();
			death.open(audioStream);
			FloatControl volumeControl = (FloatControl) death.getControl(FloatControl.Type.MASTER_GAIN); // new
			volumeControl.setValue(-5.0f); // Reduce volume by 5 decibels.
			muteSetting_death();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public static void backgroundLoop_lose() {// Game lose the game
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("audio/gameover.wav"));
			lose = AudioSystem.getClip();
			lose.open(audioStream);
			FloatControl volumeControl = (FloatControl) lose.getControl(FloatControl.Type.MASTER_GAIN); // new
			volumeControl.setValue(-5.0f); // Reduce volume by 5 decibels.
			muteSetting_lose();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public static void backgroundLoop_ownthegame() {// Game own the game
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("audio/winthegame.wav"));
			ownthegame = AudioSystem.getClip();
			ownthegame.open(audioStream);
			FloatControl volumeControl = (FloatControl) ownthegame.getControl(FloatControl.Type.MASTER_GAIN); // new
			volumeControl.setValue(-5.0f); // Reduce volume by 5 decibels.
			muteSetting_mute_ownthegame();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public static void backgroundLoop_touch() {// touch the game
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("audio/touch.wav"));
			touch = AudioSystem.getClip();
			touch.open(audioStream);
			FloatControl volumeControl = (FloatControl) touch.getControl(FloatControl.Type.MASTER_GAIN); // new
			volumeControl.setValue(-5.0f); // Reduce volume by 5 decibels.
			muteSetting_touch();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public static void backgroundLoop_second() {

		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("audio/music.wav"));
			clip1 = AudioSystem.getClip();
			clip1.open(audioStream);
			FloatControl volumeControl = (FloatControl) clip1.getControl(FloatControl.Type.MASTER_GAIN); // new
			volumeControl.setValue(-5.0f); // Reduce volume by 5 decibels.
			muteSetting_second();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	// death fish
	public static void muteSetting_lose() {
		if (!isMute_lose()) {
			lose.start();
		} else {
			lose.stop();
		}
	}

	public static boolean isMute_lose() {
		return mute_lose;
	}

	public static void setMute_lose(boolean mute) {
		Music.mute_lose = mute;
	}

	// death fish

	// death fish
	public static void muteSetting_death() {
		if (!isMute_death()) {
			death.start();
		} else {
			death.stop();
		}
	}

	public static boolean isMute_death() {
		return mute_death;
	}

	public static void setMute_death(boolean mute) {
		Music.mute_death = mute;
	}

	// death fish

	// own ownthegame

	public static void muteSetting_mute_ownthegame() {
		if (!isMute_mute_ownthegame()) {
			ownthegame.start();
		} else {
			ownthegame.stop();
		}
	}

	public static boolean isMute_mute_ownthegame() {
		return mute_ownthegame;
	}

	public static void setMute_mute_ownthegame(boolean mute) {
		Music.mute_ownthegame = mute;
	}

	// own ownthegame
	// touch fish
	public static void muteSetting_touch() {
		if (!isMute_touch()) {
			touch.start();
		} else {
			touch.stop();
		}
	}

	public static boolean isMute_touch() {
		return mute_touch;
	}

	public static void setMute_touch(boolean mute) {
		Music.mute_touch = mute;
	}

	// touch fish

	// =============================================

	public static void muteSetting_second() {
		if (!isMute_second()) {
			clip1.start();
			clip1.loop(Clip.LOOP_CONTINUOUSLY);
		} else {
			clip1.stop();
		}
	}

	public static boolean isMute_second() {
		return mute1;
	}

	public static void setMute_second(boolean mute) {
		Music.mute1 = mute;
	}

	// =============================================
	public void stop_second() {
		clip1.stop();
	}
}
