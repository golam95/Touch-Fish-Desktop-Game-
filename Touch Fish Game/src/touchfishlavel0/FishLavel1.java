package touchfishlavel0;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class FishLavel1 {
	public static long timeBetweenDucks = ControlLavel1.secInNanosec / 2;
	public static long lastDuckTime = 0;
	public static int[][] duckLines = { { ControlLavel1.frameWidth, (int) (ControlLavel1.frameHeight * 0.60), -3, 20 },
			{ ControlLavel1.frameWidth, (int) (ControlLavel1.frameHeight * 0.65), -4, 30 },
			{ ControlLavel1.frameWidth, (int) (ControlLavel1.frameHeight * 0.70), -5, 40 },
			{ ControlLavel1.frameWidth, (int) (ControlLavel1.frameHeight * 0.78), -6, 50 } };

	
	
	
	
	
	
	public static int nextDuckLines = 0;
	public int x;
	public int y;
	private int speed;
	public int score;
	private BufferedImage duckImg;

	public FishLavel1(int x, int y, int speed, int score, BufferedImage duckImg) {
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
