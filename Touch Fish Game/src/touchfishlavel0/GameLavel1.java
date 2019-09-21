package touchfishlavel0;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class GameLavel1 {
	private Random random;
	private Music music = new Music();
	@SuppressWarnings("unused")
	private Random random1;
	@SuppressWarnings("unused")
	private int runawaysecondfish;
	private int killedDucks;
	@SuppressWarnings("unused")
	private BufferedImage secondfishImg;
	public int counter = 0;
	public int needtouchfish = 25;
	public int needtouchfish_counter = 0;
	public int lifecounter = 0;
	public int life = 5;
	@SuppressWarnings("unused")
	private long lastTime;
	private Font font;
	@SuppressWarnings("unused")
	private Font font1;
	private ArrayList<FishLavel1> ducks;
	private int runawayDucks;
	private ArrayList<EnemyOne> enemyOne;
	private Random random_enemyOne;
	@SuppressWarnings("unused")
	private int runway_enemyOne;
	private BufferedImage ememyOneImg;
	private ArrayList<LifeLavelOne> lifelavelone;
	private Random random_lifelavelone;
	@SuppressWarnings("unused")
	private int runway_lifelavelone;
	private BufferedImage lifelaveloneImg;
	public int counter_one = 0;
	public int counter_two = 0;
	public int counter_three = 0;
	public int counter_four = 0;
	public static int score;
	private int shoots;
	private long lastTimeShoot;
	private long timeBetweenShots;
	private BufferedImage backgroundImg;
	private BufferedImage grassImg;
	private BufferedImage duckImg;
	private BufferedImage sightImg;
	private int sightImgMiddleWidth;
	private int sightImgMiddleHeight;

	public GameLavel1() {
		ControlLavel1.gameState = ControlLavel1.GameState.GAME_CONTENT_LOADING;
		Thread threadForInitGame = new Thread() {
			@Override
			public void run() {
				// Sets variables and objects for the game.
				Initialize();
				// Load game files (images, sounds, ...)
				LoadContent();
				ControlLavel1.gameState = ControlLavel1.GameState.PLAYING;
			}
		};
		threadForInitGame.start();
	}

	private void Initialize() {
		random = new Random();
		random1 = new Random();
		font = new Font("monospaced", Font.BOLD, 18);
		font1 = new Font("monospaced", Font.BOLD, 28);
		ducks = new ArrayList<FishLavel1>();

		counter_one = 0;
		counter_two = 0;
		counter_three = 0;
		counter_four = 0;

		runawaysecondfish = 0;
		runawayDucks = 0;
		killedDucks = 0;
		lifecounter = 0;
		score = 0;
		shoots = 0;
		counter = 0;
		lastTimeShoot = 0;
		timeBetweenShots = ControlLavel1.secInNanosec / 3;

		random_enemyOne = new Random();
		enemyOne = new ArrayList<EnemyOne>();
		runway_enemyOne = 0;

		random_lifelavelone = new Random();
		lifelavelone = new ArrayList<LifeLavelOne>();
		runway_lifelavelone = 0;

	}

	private void LoadContent() {
		try {
			URL backgroundImgUrl = this.getClass().getResource("/touchfishlavel0/resource/background.jpg");
			backgroundImg = ImageIO.read(backgroundImgUrl);
			URL grassImgUrl = this.getClass().getResource("/touchfishlavel0/resource/grass.png");
			grassImg = ImageIO.read(grassImgUrl);
			URL duckImgUrl = this.getClass().getResource("/touchfishlavel0/resource/dan.png");
			duckImg = ImageIO.read(duckImgUrl);

			URL enemyOne_image = this.getClass().getResource("/touchfishlavel0/resource/cakra.png");
			ememyOneImg = ImageIO.read(enemyOne_image);

			URL lifelavelOne_image = this.getClass().getResource("/touchfishlavel0/resource/life.png");
			lifelaveloneImg = ImageIO.read(lifelavelOne_image);

			URL sightImgUrl = this.getClass().getResource("/touchfishlavel0/resource/sight.png");
			sightImg = ImageIO.read(sightImgUrl);
			sightImgMiddleWidth = sightImg.getWidth() / 2;
			sightImgMiddleHeight = sightImg.getHeight() / 2;
		} catch (IOException ex) {
			Logger.getLogger(GameLavel1.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void RestartGame() {
		// Removes all of the ducks from this list.
		ducks.clear();
		enemyOne.clear();
		// We set last duckt time to zero.
		FishLavel1.lastDuckTime = 0;
		EnemyOne.last_EnemyOneTime = 0;
		LifeLavelOne.last_lifelavel1 = 0;
		counter_one = 0;
		counter_two = 0;
		counter_three = 0;
		counter_four = 0;
		runway_lifelavelone = 0;
		runawayDucks = 0;
		killedDucks = 0;
		// score = 0;
		shoots = 0;
		counter = 0;
		runway_enemyOne = 0;
		lastTimeShoot = 0;
		lifecounter = 0;
		life = 5;
	}

	@SuppressWarnings("static-access")
	public void UpdateGame(long gameTime, Point mousePosition) {
		// Creates a new duck, if it's the time, and add it to the array list.
		if (System.nanoTime() - FishLavel1.lastDuckTime >= FishLavel1.timeBetweenDucks) {
			// Here we create new duck and add it to the array list.
			ducks.add(new FishLavel1(FishLavel1.duckLines[FishLavel1.nextDuckLines][0] + random.nextInt(200),
					FishLavel1.duckLines[FishLavel1.nextDuckLines][1],
					FishLavel1.duckLines[FishLavel1.nextDuckLines][2],
					FishLavel1.duckLines[FishLavel1.nextDuckLines][3], duckImg));

			enemyOne.add(
					new EnemyOne(EnemyOne.EnemyOneLines[EnemyOne.nextenemyOneLines][0] + random_enemyOne.nextInt(200),
							EnemyOne.EnemyOneLines[EnemyOne.nextenemyOneLines][1],
							EnemyOne.EnemyOneLines[EnemyOne.nextenemyOneLines][2],
							EnemyOne.EnemyOneLines[EnemyOne.nextenemyOneLines][3], ememyOneImg));

			lifelavelone.add(new LifeLavelOne(
					LifeLavelOne.lifelavel1_Lines[LifeLavelOne.nextlifelavel1Lines][0]
							+ random_lifelavelone.nextInt(200),
					LifeLavelOne.lifelavel1_Lines[LifeLavelOne.nextlifelavel1Lines][1],
					LifeLavelOne.lifelavel1_Lines[LifeLavelOne.nextlifelavel1Lines][2],
					LifeLavelOne.lifelavel1_Lines[LifeLavelOne.nextlifelavel1Lines][3], lifelaveloneImg));

			LifeLavelOne.nextlifelavel1Lines++;
			EnemyOne.nextenemyOneLines++;
			FishLavel1.nextDuckLines++;

			if (FishLavel1.nextDuckLines >= FishLavel1.duckLines.length)
				FishLavel1.nextDuckLines = 0;
			FishLavel1.lastDuckTime = System.nanoTime();

			if (EnemyOne.nextenemyOneLines >= EnemyOne.EnemyOneLines.length)
				EnemyOne.nextenemyOneLines = 0;
			EnemyOne.last_EnemyOneTime = System.nanoTime();

			if (LifeLavelOne.nextlifelavel1Lines >= LifeLavelOne.lifelavel1_Lines.length)
				LifeLavelOne.nextlifelavel1Lines = 0;
			LifeLavelOne.last_lifelavel1 = System.nanoTime();

			for (int golam = 0; golam < enemyOne.size(); golam++) {
				EnemyOne getloop = enemyOne.get(golam);
				getloop.Update();
				Rectangle player1 = new Rectangle(getloop.x, getloop.y, getloop.EnemyOneImg.getWidth(),
						getloop.EnemyOneImg.getHeight());
				Rectangle player2 = new Rectangle(mousePosition.x, mousePosition.y, sightImg.getWidth(),
						sightImg.getHeight());
				if (player1.intersects(player2)) {
					music.backgroundLoop_death();
					counter_two++;
					if (counter_two == 1) {
						life -= counter_two;
						if (life <= 0) {
							music.backgroundLoop_lose();
							ControlLavel1.gameState = ControlLavel1.GameState.GAMEOVER;
							break;

						}
					}

					counter_two = 0;

				}

			}

			// life lavel 3 so what so what and what are you doing

			for (int golamnobi = 0; golamnobi < lifelavelone.size(); golamnobi++) {
				LifeLavelOne getloop = lifelavelone.get(golamnobi);
				getloop.Update();
				Rectangle player1 = new Rectangle(getloop.x, getloop.y, getloop.lifelavel1Img.getWidth(),
						getloop.lifelavel1Img.getHeight());
				Rectangle player2 = new Rectangle(mousePosition.x, mousePosition.y, sightImg.getWidth(),
						sightImg.getHeight());
				if (player1.intersects(player2)) {
					counter_three++;

					if (counter_three == 1 && life < 5) {
						life += counter_three;

					}

					counter_three = 0;

				}

			}

		}
		// Update all of the ducks.
		for (int i = 0; i < ducks.size(); i++) {
			// Move the duck.
			ducks.get(i).Update();

			// Checks if the duck leaves the screen and remove it if it does.
			if (ducks.get(i).x < 0 - duckImg.getWidth()) {
				ducks.remove(i);
				runawayDucks++;
			}
		}

		for (int i = 0; i < enemyOne.size(); i++) {
			// Move the duck.
			enemyOne.get(i).Update();

			// Checks if the duck leaves the screen and remove it if it does.
			if (enemyOne.get(i).x < 0 - ememyOneImg.getWidth()) {
				enemyOne.remove(i);
				runway_enemyOne++;
			}
		}

		for (int i = 0; i < lifelavelone.size(); i++) {
			// Move the duck.
			lifelavelone.get(i).Update();

			// Checks if the duck leaves the screen and remove it if it does.
			if (lifelavelone.get(i).x < 0 - lifelaveloneImg.getWidth()) {
				lifelavelone.remove(i);
				runway_lifelavelone++;
			}
		}

		if (ActionLavel1.mouseButtonState(MouseEvent.BUTTON1)) {
			// Checks if it can shoot again.
			if (System.nanoTime() - lastTimeShoot >= timeBetweenShots) {
				shoots++;
				for (int i = 0; i < ducks.size(); i++) {
					// We check, if the mouse was over ducks head or body, when
					// player has shot.
					if (new Rectangle(ducks.get(i).x + 18, ducks.get(i).y, 27, 30).contains(mousePosition)
							|| new Rectangle(ducks.get(i).x + 30, ducks.get(i).y + 30, 88, 25)
									.contains(mousePosition)) {
						killedDucks++;
						music.backgroundLoop_touch();
						score += ducks.get(i).score;

						// Remove the duck from the array list.
						ducks.remove(i);

						break;
					}
					System.out.println("Add Database Score " + score);
				}

				for (int i = 0; i < lifelavelone.size(); i++) {
					if (new Rectangle(lifelavelone.get(i).x + 18, lifelavelone.get(i).y, 27, 30).contains(mousePosition)
							|| new Rectangle(lifelavelone.get(i).x + 30, lifelavelone.get(i).y + 30, 88, 25)
									.contains(mousePosition)) {

						lifelavelone.remove(i);
						break;
					}
				}

				lastTimeShoot = System.nanoTime();
			}

		}

		if (runawayDucks == 50) {
			music.backgroundLoop_lose();
			ControlLavel1.gameState = ControlLavel1.GameState.GAMEOVER;

		}
		if (killedDucks == 10) {
			music.backgroundLoop_ownthegame();
			ControlLavel1.gameState = ControlLavel1.GameState.DESTROYED;

		}

	}

	public void Draw(Graphics2D g2d, Point mousePosition) {
		g2d.drawImage(backgroundImg, 0, 0, ControlLavel1.frameWidth, ControlLavel1.frameHeight, null);
		// Here we draw all the ducks.
		for (int i = 0; i < ducks.size(); i++) {
			ducks.get(i).Draw(g2d);
		}
		for (int i = 0; i < enemyOne.size(); i++) {
			enemyOne.get(i).Draw(g2d);
		}

		if (runawayDucks == 7 || runawayDucks == 8 || runawayDucks == 9 || runawayDucks == 10) {
			for (int i = 0; i < lifelavelone.size(); i++) {
				lifelavelone.get(i).Draw(g2d);
			}
		} else if (runawayDucks == 17 || runawayDucks == 18 || runawayDucks == 19 || runawayDucks == 20) {
			for (int i = 0; i < lifelavelone.size(); i++) {
				lifelavelone.get(i).Draw(g2d);
			}

		} else if (runawayDucks == 30 || runawayDucks == 31 || runawayDucks == 32 || runawayDucks == 33) {
			for (int i = 0; i < lifelavelone.size(); i++) {
				lifelavelone.get(i).Draw(g2d);
			}
		} else if (runawayDucks == 40 || runawayDucks == 41 || runawayDucks == 42 || runawayDucks == 43) {
			for (int i = 0; i < lifelavelone.size(); i++) {
				lifelavelone.get(i).Draw(g2d);
			}
		}

		g2d.drawImage(grassImg, 0, ControlLavel1.frameHeight - grassImg.getHeight(), ControlLavel1.frameWidth,
				grassImg.getHeight(), null);
		g2d.drawImage(sightImg, mousePosition.x - sightImgMiddleWidth, mousePosition.y - sightImgMiddleHeight, null);

		g2d.setFont(font);
		g2d.setColor(Color.BLACK);
		g2d.drawString("Passing Fish: " + runawayDucks, 10, 21);
		g2d.drawString("KILLS: " + killedDucks, 210, 21);
		g2d.drawString("Trying Touch Fish: " + shoots, 320, 21);
		g2d.drawString("Need Touch Fish: " + needtouchfish, 590, 21);
		g2d.drawString("SCORE: " + score, 850, 21);
		g2d.drawString("Life: " + life, 1030, 21);

	}

	public void DrawGameOver(Graphics2D g2d, Point mousePosition) {
		Draw(g2d, mousePosition);
		// The first text is used for shade.
		g2d.setColor(Color.RED);
		g2d.setFont(font1);
		g2d.drawString("You Lose !!!!", ControlLavel1.frameWidth / 2 - 39,
				(int) (ControlLavel1.frameHeight * 0.65) + 1);
		g2d.drawString("Press space for Retry or Press Home To Go MainMenu.", ControlLavel1.frameWidth / 2 - 249,
				(int) (ControlLavel1.frameHeight * 0.70) + 1);

	}

	public void DrawGameWin(Graphics2D g2d, Point mousePosition) {
		Draw(g2d, mousePosition);
		// The first text is used for shade.
		g2d.setFont(font1);
		g2d.setColor(Color.RED);
		g2d.drawString("You Won This Level", ControlLavel1.frameWidth / 2 - 39,
				(int) (ControlLavel1.frameHeight * 0.65) + 1);
		g2d.drawString("Press P To Continue or Press Home Return MainMenu.", ControlLavel1.frameWidth / 2 - 249,
				(int) (ControlLavel1.frameHeight * 0.70) + 1);

	}

}
