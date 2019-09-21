package touchfishlavel3;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class LifeLavel4 {

	public static long timeBetween_lifelavel3 = ControlLavel4.secInNanosec / 2;
	public static long last_lifelavel3 = 0;
	public static int[][] lifelavel3_Lines = { { ControlLavel4.frameWidth, (int) (ControlLavel4.frameHeight * 0.60), -5, 20 },
			{ ControlLavel4.frameWidth, (int) (ControlLavel4.frameHeight * 0.65), -6, 30 },
			{ ControlLavel4.frameWidth, (int) (ControlLavel4.frameHeight * 0.70), -7, 40 },
			{ ControlLavel4.frameWidth, (int) (ControlLavel4.frameHeight * 0.78), -8, 50 } };
	public static int nextlifelavel3Lines = 0;
	public int x;
	public int y;
	private int speed;
	public int score;
	public BufferedImage lifelavel3Img;

	public LifeLavel4(int x, int y, int speed, int score, BufferedImage lifelavel3Img) {
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.score = score;
		this.lifelavel3Img = lifelavel3Img;
	}

	public void Update() {
		x += speed;
	}

	public void Draw(Graphics2D g2d) {
		g2d.drawImage(lifelavel3Img, x, y, null);
	}
}
