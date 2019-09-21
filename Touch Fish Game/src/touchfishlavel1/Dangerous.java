package touchfishlavel1;

//import java.awt.Graphics2D;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Dangerous {

	public static long timeBetweenDucks = ControlLavel2.secInNanosec_s / 2;
	public static long lastDuckTime = 0;
	public static int[][] dangerious = { { ControlLavel2.frameWidth, (int) (ControlLavel2.frameHeight * 0.58), -3, 10 },
			{ ControlLavel2.frameWidth, (int) (ControlLavel2.frameHeight * 0.65), -4, 20 },
			{ ControlLavel2.frameWidth, (int) (ControlLavel2.frameHeight * 0.70), -5, 30 },
			{ ControlLavel2.frameWidth, (int) (ControlLavel2.frameHeight * 0.78), -6, 40 } };
	public static int nextdangerous = 0;
	public int xCordinate;
	public int yCordinate;
	private int speed;
	public int score;
	public static BufferedImage dangerousImg;

	public void sager(int xCordinate, int yCordinate) {
		this.xCordinate = xCordinate;
		this.yCordinate = yCordinate;

	}

	public Dangerous(int xCordinate, int yCordinate, int speed, int score, BufferedImage danImg) {
		this.xCordinate = xCordinate;
		this.yCordinate = yCordinate;
		this.speed = speed;
		this.score = score;
		this.dangerousImg = danImg;
	}

	public void Update() {
		xCordinate += speed;
	}

	public void Draw(Graphics2D g2d) {
		g2d.drawImage(dangerousImg, xCordinate, yCordinate, null);
	}
}
