package touchfishlavel3;

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

import touchfishlavel0.Music;

public class GameLavel4 {
	Font font1 = new Font("monospaced", Font.BOLD, 18);
	public int needtouchfish = 25;
	private Music music = new Music();

	private Random random;
	@SuppressWarnings("unused")
	private Random random1;
	public int counter = 0;
	public int counter_two = 0;
	public int totalcounter = 0;
	public int lifecounter = 0;
	public int lifecounter2 = 0;
	// life counter
	public int sudden_lifecounter = 0;
	public int sudden_lifecounter1 = 0;
	// life counter
	public int life = 5;

	@SuppressWarnings("unused")
	private long lastTime;

	private ArrayList<EnemyTwo> enemytwo;
	private Random random_enemytwo;
	@SuppressWarnings("unused")
	private int runway_enemytwo;
	private BufferedImage ememyImg;

	private ArrayList<LifeLavel4> lifelavel3;
	private Random random_lifelavel3;
	@SuppressWarnings("unused")
	private int runway_lifelavel3;
	private BufferedImage lifelavel3Img;

	@SuppressWarnings("unused")
	private Font font;
	private ArrayList<FishLavel4> ducks;
	private ArrayList<Dangerous> dan = new ArrayList<Dangerous>();
	private int runawayDucks;
	@SuppressWarnings("unused")
	private int runawaydan;

	private int killedDucks;
	private int score;
	private int shoots;
	private long lastTimeShoot;
	private long timeBetweenShots;

	// life remove from the list

	private int killlife;
	private int lifescore;
	private int click_touch;
	private long lastTime_touch;
	private long timebettween_touch;

	// life remove from the list

	private BufferedImage backgroundImg;
	private BufferedImage grassImg;
	private BufferedImage duckImg;
	private BufferedImage danImg;
	private BufferedImage sightImg;
	private int sightImgMiddleWidth;
	private int sightImgMiddleHeight;

	public GameLavel4() {
		ControlLavel4.gameState = ControlLavel4.GameState.GAME_CONTENT_LOADING;

		Thread threadForInitGame = new Thread() {
			@Override
			public void run() {
				// Sets variables and objects for the game.
				Initialize();
				// Load game files (images, sounds, ...)
				LoadContent();

				ControlLavel4.gameState = ControlLavel4.GameState.PLAYING;
			}
		};
		threadForInitGame.start();
	}

	private void Initialize() {
		random = new Random();
		random1 = new Random();
		font = new Font("monospaced", Font.BOLD, 28);
		ducks = new ArrayList<FishLavel4>();
		dan = new ArrayList<Dangerous>();

		random_enemytwo = new Random();
		enemytwo = new ArrayList<EnemyTwo>();
		runway_enemytwo = 0;

		// lifelavel3

		lifelavel3 = new ArrayList<LifeLavel4>();
		random_lifelavel3 = new Random();
		runway_lifelavel3 = 0;

		// lifelavel3

		runawaydan = 0;
		runawayDucks = 0;

		lifecounter = 0;
		score = 0;
		shoots = 0;
		counter = 0;
		counter_two = 0;
		lastTimeShoot = 0;

		timeBetweenShots = ControlLavel4.secInNanosec / 3;
		killedDucks = 0;

		killlife = 0;
		lifescore = 0;
		click_touch = 0;
		lastTime_touch = 0;
		timebettween_touch = ControlLavel4.secInNanosec / 3;

	}

	private void LoadContent() {
		try {
			URL backgroundImgUrl = this.getClass().getResource("/touchfishlavel3/resources/background.jpg");
			backgroundImg = ImageIO.read(backgroundImgUrl);

			URL grassImgUrl = this.getClass().getResource("/touchfishlavel3/resources/grass.png");
			grassImg = ImageIO.read(grassImgUrl);

			URL duckImgUrl = this.getClass().getResource("/touchfishlavel3/resources/dan.png");
			duckImg = ImageIO.read(duckImgUrl);

			URL duckImgUrl_sager = this.getClass().getResource("/touchfishlavel3/resources/octo.png");
			danImg = ImageIO.read(duckImgUrl_sager);

			URL duckImgUrl_enemytwo = this.getClass().getResource("/touchfishlavel3/resources/cakra.png");
			ememyImg = ImageIO.read(duckImgUrl_enemytwo);

			URL duckImgUrl_lifelavel3 = this.getClass().getResource("/touchfishlavel3/resources/life.png");
			lifelavel3Img = ImageIO.read(duckImgUrl_lifelavel3);

			URL sightImgUrl = this.getClass().getResource("/touchfishlavel3/resources/sight.png");
			sightImg = ImageIO.read(sightImgUrl);
			sightImgMiddleWidth = sightImg.getWidth() / 2;
			sightImgMiddleHeight = sightImg.getHeight() / 2;
		} catch (IOException ex) {
			Logger.getLogger(GameLavel4.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * Restart game - reset some variables.
	 */
	public void RestartGame() {
		// Removes all of the ducks from this list.
		ducks.clear();
		dan.clear();
		enemytwo.clear();
		lifelavel3.clear();

		// We set last duckt time to zero.
		FishLavel4.lastDuckTime = 0;
		EnemyTwo.last_EnemyTwoTime = 0;
		LifeLavel4.last_lifelavel3 = 0;
		runway_lifelavel3 = 0;

		runway_enemytwo = 0;
		runawayDucks = 0;
		runawaydan = 0;
		killedDucks = 0;
		// score = 0;
		shoots = 0;
		counter = 0;
		counter_two = 0;
		lastTimeShoot = 0;
		lifecounter = 0;
		life = 5;

		killlife = 0;
		lifescore = 0;
		click_touch = 0;
		lastTime_touch = 0;

	}

	@SuppressWarnings("static-access")
	public void UpdateGame(long gameTime, Point mousePosition) {
		// Creates a new duck, if it's the time, and add it to the array list.
		if (System.nanoTime() - FishLavel4.lastDuckTime >= FishLavel4.timeBetweenDucks) {

			// Here we create new duck and add it to the array list.
			ducks.add(new FishLavel4(FishLavel4.duckLines[FishLavel4.nextDuckLines][0] + random.nextInt(200),
					FishLavel4.duckLines[FishLavel4.nextDuckLines][1],
					FishLavel4.duckLines[FishLavel4.nextDuckLines][2],
					FishLavel4.duckLines[FishLavel4.nextDuckLines][3], duckImg));

			dan.add(new Dangerous(Dangerous.dangerious[Dangerous.nextdangerous][0] + random.nextInt(200),
					Dangerous.dangerious[Dangerous.nextdangerous][1], Dangerous.dangerious[Dangerous.nextdangerous][2],
					Dangerous.dangerious[Dangerous.nextdangerous][3], danImg));

			enemytwo.add(
					new EnemyTwo(EnemyTwo.EnemyTwoLines[EnemyTwo.nextenemytwoLines][0] + random_enemytwo.nextInt(200),
							EnemyTwo.EnemyTwoLines[EnemyTwo.nextenemytwoLines][1],
							EnemyTwo.EnemyTwoLines[EnemyTwo.nextenemytwoLines][2],
							EnemyTwo.EnemyTwoLines[EnemyTwo.nextenemytwoLines][3], ememyImg));

			lifelavel3.add(new LifeLavel4(
					LifeLavel4.lifelavel3_Lines[LifeLavel4.nextlifelavel3Lines][0] + random_enemytwo.nextInt(200),
					LifeLavel4.lifelavel3_Lines[LifeLavel4.nextlifelavel3Lines][1],
					LifeLavel4.lifelavel3_Lines[LifeLavel4.nextlifelavel3Lines][2],
					LifeLavel4.lifelavel3_Lines[LifeLavel4.nextlifelavel3Lines][3], lifelavel3Img));

			LifeLavel4.nextlifelavel3Lines++;
			FishLavel4.nextDuckLines++;
			EnemyTwo.nextenemytwoLines++;
			Dangerous.nextdangerous++;
			if (FishLavel4.nextDuckLines >= FishLavel4.duckLines.length)
				FishLavel4.nextDuckLines = 0;
			FishLavel4.lastDuckTime = System.nanoTime();

			if (Dangerous.nextdangerous >= Dangerous.dangerious.length)
				Dangerous.nextdangerous = 0;
			Dangerous.lastDuckTime = System.nanoTime();

			if (EnemyTwo.nextenemytwoLines >= EnemyTwo.EnemyTwoLines.length)
				EnemyTwo.nextenemytwoLines = 0;
			EnemyTwo.last_EnemyTwoTime = System.nanoTime();

			if (LifeLavel4.nextlifelavel3Lines >= LifeLavel4.lifelavel3_Lines.length)
				LifeLavel4.nextlifelavel3Lines = 0;
			LifeLavel4.last_lifelavel3 = System.nanoTime();

			for (int sager = 0; sager < dan.size(); sager++) {
				Dangerous eh = dan.get(sager);
				eh.Update();
				Rectangle player1 = new Rectangle(eh.xCordinate, eh.yCordinate, eh.dangerousImg.getWidth(),
						eh.dangerousImg.getHeight());
				Rectangle player2 = new Rectangle(mousePosition.x, mousePosition.y, sightImg.getWidth(),
						sightImg.getHeight());
				if (player1.intersects(player2)) {
					counter++;
					lifecounter++;
					if (lifecounter == 1) {
						life -= lifecounter;
						// Music.backgroundLoopa();

					}

					lifecounter = 0;
					totalcounter = counter + counter_two;
					System.out.println("Upper counter=== " + totalcounter);
					if (totalcounter == 5) {
						music.backgroundLoop_lose();
						ControlLavel4.gameState = ControlLavel4.GameState.GAMEOVER;
						break;

					}

				}

			}

			for (int golam = 0; golam < enemytwo.size(); golam++) {
				EnemyTwo getloop = enemytwo.get(golam);
				getloop.Update();
				Rectangle player1 = new Rectangle(getloop.x, getloop.y, getloop.EnemyTwoImg.getWidth(),
						getloop.EnemyTwoImg.getHeight());
				Rectangle player2 = new Rectangle(mousePosition.x, mousePosition.y, sightImg.getWidth(),
						sightImg.getHeight());
				if (player1.intersects(player2)) {
					music.backgroundLoop_death();
					counter_two++;
					lifecounter2++;
					if (lifecounter2 == 1) {
						life -= lifecounter2;
						// Music.backgroundLoopa();

					}

					lifecounter2 = 0;

					totalcounter = counter + counter_two;
					System.out.println("Down =" + totalcounter);

					if (totalcounter == 5) {
						music.backgroundLoop_lose();
						ControlLavel4.gameState = ControlLavel4.GameState.GAMEOVER;

						break;

					}

				}

			}

			// life lavel 3 so what so what and what are you doing

			for (int golamnobi = 0; golamnobi < lifelavel3.size(); golamnobi++) {
				LifeLavel4 getloop = lifelavel3.get(golamnobi);
				getloop.Update();
				Rectangle player1 = new Rectangle(getloop.x, getloop.y, getloop.lifelavel3Img.getWidth(),
						getloop.lifelavel3Img.getHeight());
				Rectangle player2 = new Rectangle(mousePosition.x, mousePosition.y, sightImg.getWidth(),
						sightImg.getHeight());
				if (player1.intersects(player2)) {
					music.backgroundLoop_death();
					sudden_lifecounter++;
					sudden_lifecounter1++;

					if (sudden_lifecounter == 1 && life < 5) {
						life += sudden_lifecounter;
						// Music.backgroundLoopa();

					}

					sudden_lifecounter = 0;

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

		for (int i = 0; i < dan.size(); i++) {
			// Move the duck.
			dan.get(i).Update();

			// Checks if the duck leaves the screen and remove it if it does.
			if (dan.get(i).xCordinate < 0 - danImg.getWidth()) {
				dan.remove(i);
				runawaydan++;
			}
		}

		for (int i = 0; i < enemytwo.size(); i++) {
			// Move the duck.
			enemytwo.get(i).Update();

			// Checks if the duck leaves the screen and remove it if it does.
			if (enemytwo.get(i).x < 0 - ememyImg.getWidth()) {
				enemytwo.remove(i);
				runway_enemytwo++;
			}
		}

		for (int i = 0; i < lifelavel3.size(); i++) {
			// Move the duck.
			lifelavel3.get(i).Update();

			// Checks if the duck leaves the screen and remove it if it does.
			if (lifelavel3.get(i).x < 0 - lifelavel3Img.getWidth()) {
				lifelavel3.remove(i);
				runway_lifelavel3++;
			}
		}

		// Does player shoots?
		if (ActionLavel4.mouseButtonState(MouseEvent.BUTTON1)) {
			// Checks if it can shoot again.
			if (System.nanoTime() - lastTimeShoot >= timeBetweenShots) {
				shoots++;
				click_touch++;
				for (int i = 0; i < ducks.size(); i++) {
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
				}

				for (int i = 0; i < lifelavel3.size(); i++) {
					if (new Rectangle(lifelavel3.get(i).x + 18, lifelavel3.get(i).y, 27, 30).contains(mousePosition)
							|| new Rectangle(lifelavel3.get(i).x + 30, lifelavel3.get(i).y + 30, 88, 25)
									.contains(mousePosition)) {

						lifelavel3.remove(i);
						break;
					}
				}

				lastTimeShoot = System.nanoTime();
				lastTime_touch = System.nanoTime();

			}

		}

		// When 200 ducks runaway, the game ends.
		if (runawayDucks >= 100) {
			music.backgroundLoop_lose();
			ControlLavel4.gameState = ControlLavel4.GameState.GAMEOVER;
		}
		if (killedDucks == 6) {
			music.backgroundLoop_ownthegame();
			ControlLavel4.gameState = ControlLavel4.GameState.GAMEOVER;

		}
	}

	public void Draw(Graphics2D g2d, Point mousePosition) {
		g2d.drawImage(backgroundImg, 0, 0, ControlLavel4.frameWidth, ControlLavel4.frameHeight, null);

		// Here we draw all the ducks.
		for (int i = 0; i < ducks.size(); i++) {
			ducks.get(i).Draw(g2d);
		}
		for (int i = 0; i < dan.size(); i++) {
			dan.get(i).Draw(g2d);
		}

		for (int i = 0; i < enemytwo.size(); i++) {
			enemytwo.get(i).Draw(g2d);
		}

		if (runawayDucks == 5 || runawayDucks == 6 || runawayDucks == 7 || runawayDucks == 7) {
			for (int i = 0; i < lifelavel3.size(); i++) {
				lifelavel3.get(i).Draw(g2d);
			}

		}

		g2d.drawImage(grassImg, 0, ControlLavel4.frameHeight - grassImg.getHeight(), ControlLavel4.frameWidth,
				grassImg.getHeight(), null);

		g2d.drawImage(sightImg, mousePosition.x - sightImgMiddleWidth, mousePosition.y - sightImgMiddleHeight, null);
		g2d.setFont(font1);
		g2d.setColor(Color.WHITE);

		g2d.drawString("Passing Fish: " + runawayDucks, 10, 21);
		g2d.drawString("Touch Fish: " + killedDucks, 300, 21);
		g2d.drawString("Trying Touch Fish: " + shoots, 510, 21);
		g2d.drawString("Need Touch Fish: " + needtouchfish, 880, 21);
		g2d.drawString("SCORE: " + score, 1000, 21);
		g2d.drawString("Life: " + life, 1100, 21);

	}

	public void DrawGameOver(Graphics2D g2d, Point mousePosition) {
		Draw(g2d, mousePosition);
		g2d.setColor(Color.RED);
		g2d.setFont(font1);
		g2d.drawString("You Lose !!!!", ControlLavel4.frameWidth / 2 - 39,
				(int) (ControlLavel4.frameHeight * 0.65) + 1);
		g2d.drawString("Press space for Retry or Press Home To Go MainMenu.", ControlLavel4.frameWidth / 2 - 249,
				(int) (ControlLavel4.frameHeight * 0.70) + 1);

	}

	public void DrawGameover_final(Graphics2D g2d, Point mousePosition) {
		Draw(g2d, mousePosition);
		g2d.setColor(Color.RED);
		g2d.setFont(font1);
		g2d.drawString("GAME IS OVER!!!!", ControlLavel4.frameWidth / 2 - 39,
				(int) (ControlLavel4.frameHeight * 0.65) + 1);
		g2d.drawString("Press Home To Go MainMenu and see the score.", ControlLavel4.frameWidth / 2 - 249,
				(int) (ControlLavel4.frameHeight * 0.70) + 1);

	}

	public void DrawGameWin(Graphics2D g2d, Point mousePosition) {
		Draw(g2d, mousePosition);
		// The first text is used for shade.
		g2d.setFont(font1);
		g2d.setColor(Color.RED);
		g2d.drawString("You Won This Level", ControlLavel4.frameWidth / 2 - 39,
				(int) (ControlLavel4.frameHeight * 0.65) + 1);
		g2d.drawString("Press P To Continue or Press Home Return MainMenu.", ControlLavel4.frameWidth / 2 - 249,
				(int) (ControlLavel4.frameHeight * 0.70) + 1);

	}

}
