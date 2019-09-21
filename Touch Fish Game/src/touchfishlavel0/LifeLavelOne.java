package touchfishlavel0;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
public class LifeLavelOne {
	public static long timeBetween_lifelavel1 = ControlLavel1.secInNanosec / 2;
	public static long last_lifelavel1 = 0;
	public static int[][] lifelavel1_Lines = {
			{ ControlLavel1.frameWidth, (int) (ControlLavel1.frameHeight * 0.60), -5, 20 },
			{ ControlLavel1.frameWidth, (int) (ControlLavel1.frameHeight * 0.65), -6, 30 },
			{ ControlLavel1.frameWidth, (int) (ControlLavel1.frameHeight * 0.70), -7, 40 },
			{ ControlLavel1.frameWidth, (int) (ControlLavel1.frameHeight * 0.78), -8, 50 } };
	public static int nextlifelavel1Lines = 0;
	public int x;
	public int y;
	private int speed;
	public int score;
	BufferedImage lifelavel1Img;

	public LifeLavelOne(int x, int y, int speed, int score, BufferedImage lifelavel1Img) {
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.score = score;
		this.lifelavel1Img = lifelavel1Img;
	}

	public void Update() {
		x += speed;
	}

	public void Draw(Graphics2D g2d) {
		g2d.drawImage(lifelavel1Img, x, y, null);
	}
}
