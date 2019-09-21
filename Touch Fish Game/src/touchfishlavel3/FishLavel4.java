package touchfishlavel3;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class FishLavel4 {

	public static long timeBetweenDucks = ControlLavel4.secInNanosec / 2;
	public static long lastDuckTime = 0;
	public static int[][] duckLines = { { ControlLavel4.frameWidth, (int) (ControlLavel4.frameHeight * 0.60), -2, 20 },
			{ ControlLavel4.frameWidth, (int) (ControlLavel4.frameHeight * 0.65), -3, 30 },
			{ ControlLavel4.frameWidth, (int) (ControlLavel4.frameHeight * 0.70), -4, 40 },
			{ ControlLavel4.frameWidth, (int) (ControlLavel4.frameHeight * 0.78), -5, 50 } };
	public static int nextDuckLines = 0;
	public int x;
	public int y;
	private int speed;
	public int score;
	private BufferedImage duckImg;

	public FishLavel4(int x, int y, int speed, int score, BufferedImage duckImg) {
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.score = score;
		this.duckImg = duckImg;
	}

	public void Update() {
		x += speed;
	}

	public void Draw(Graphics2D g2d) {
		g2d.drawImage(duckImg, x, y, null);
	}
}
