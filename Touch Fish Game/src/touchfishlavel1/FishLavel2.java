package touchfishlavel1;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class FishLavel2 {

	public static long timeBetweenDucks = ControlLavel2.secInNanosec / 2;
	public static long lastDuckTime = 0;
	public static int[][] duckLines = { { ControlLavel2.frameWidth, (int) (ControlLavel2.frameHeight * 0.60), -5, 20 },
			{ ControlLavel2.frameWidth, (int) (ControlLavel2.frameHeight * 0.65), -6, 30 },
			{ ControlLavel2.frameWidth, (int) (ControlLavel2.frameHeight * 0.70), -7, 40 },
			{ ControlLavel2.frameWidth, (int) (ControlLavel2.frameHeight * 0.78), -8, 50 } };
	public static int nextDuckLines = 0;
	public int x;
	public int y;
	private int speed;
	public int score;
	private BufferedImage duckImg;

	public FishLavel2(int x, int y, int speed, int score, BufferedImage duckImg) {
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
