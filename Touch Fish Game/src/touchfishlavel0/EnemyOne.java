package touchfishlavel0;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class EnemyOne {

	public static long timeBetween_EnemyOne = ControlLavel1.secInNanosec / 2;
	public static long last_EnemyOneTime = 0;
	public static int[][] EnemyOneLines = {
			{ ControlLavel1.frameWidth, (int) (ControlLavel1.frameHeight * 0.60), -2, 20 },
			{ ControlLavel1.frameWidth, (int) (ControlLavel1.frameHeight * 0.65), -3, 30 },
			{ ControlLavel1.frameWidth, (int) (ControlLavel1.frameHeight * 0.70), -4, 40 },
			{ ControlLavel1.frameWidth, (int) (ControlLavel1.frameHeight * 0.78), -5, 50 } };
	public static int nextenemyOneLines = 0;
	public int x;
	public int y;
	private int speed;
	public int score;
	BufferedImage EnemyOneImg;

	public EnemyOne(int x, int y, int speed, int score, BufferedImage EnemyOneImg) {
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.score = score;
		this.EnemyOneImg = EnemyOneImg;
	}

	public void Update() {
		x += speed;
	}

	public void Draw(Graphics2D g2d) {
		g2d.drawImage(EnemyOneImg, x, y, null);
	}
}
