package touchfishlavel1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import touchfishlavel0.MainMenu;
import touchfishlavel0.ShowTitlePage;
import touchfishlavel0.ControlLavel1.GameState;
import touchfishlavel2.ShowTitlePageThree;

public class ControlLavel2 extends ActionLavel2 {

	private static final long serialVersionUID = 1L;
	Font font = new Font("monospaced", Font.BOLD, 18);
	Font font1 = new Font("monospaced", Font.BOLD, 38);
	public static int frameWidth;
	public static int frameHeight;
	public static final long secInNanosec = 1000000000L;
	public static final long secInNanosec_s = 1000000000L;
	public static final long milisecInNanosec = 1000000L;
	private final int GAME_FPS = 60;
	private final long GAME_UPDATE_PERIOD = secInNanosec / GAME_FPS;

	MainMenu mainboard;
	ShowTitlePageThree showtitlepage_three;

	public static enum GameState {
		STARTING, VISUALIZING, GAME_CONTENT_LOADING, MAIN_MENU, OPTIONS, PLAYING, GAMEOVER, DESTROYED
	}

	public static GameState gameState;
	private long gameTime;
	// It is used for calculating elapsed time.
	private long lastTime;
	// The actual game
	private GameLavel2 game;
	private BufferedImage shootTheDuckMenuImg;

	public ControlLavel2() {
		super();
		gameState = GameState.VISUALIZING;

		// We start game in new thread.
		Thread gameThread = new Thread() {
			@Override
			public void run() {
				GameLoop();
			}
		};
		gameThread.start();
	}

	private void Initialize() {

	}

	private void LoadContent() {
		try {
			URL shootTheDuckMenuImgUrl = this.getClass().getResource("/touchfishlavel1/resources/menu.jpg");
			shootTheDuckMenuImg = ImageIO.read(shootTheDuckMenuImgUrl);
		} catch (IOException ex) {
			Logger.getLogger(ControlLavel2.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void GameLoop() {
		long visualizingTime = 0, lastVisualizingTime = System.nanoTime();
		long beginTime, timeTaken, timeLeft;
		while (true) {
			beginTime = System.nanoTime();
			switch (gameState) {
			case PLAYING:
				// gameTime += System.nanoTime() - lastTime;
				// game.UpdateGame_another(gameTime, mousePosition());

				game.UpdateGame(gameTime, mousePosition());
				lastTime = System.nanoTime();
				// mu.sagerstop();

				break;
			case GAMEOVER:
				// ...
				break;
			case MAIN_MENU:
				// ...
				break;
			case OPTIONS:
				// ...
				break;
			case GAME_CONTENT_LOADING:
				// ...
				break;
			case STARTING:

				Initialize();

				LoadContent();

				gameState = GameState.MAIN_MENU;
				break;
			case VISUALIZING:

				if (this.getWidth() > 1 && visualizingTime > secInNanosec) {
					frameWidth = this.getWidth();
					frameHeight = this.getHeight();

					// When we get size of frame we change status.
					gameState = GameState.STARTING;
				} else {
					visualizingTime += System.nanoTime() - lastVisualizingTime;
					lastVisualizingTime = System.nanoTime();
				}
				break;
			}

			// Repaint the screen.
			repaint();

			timeTaken = System.nanoTime() - beginTime;
			timeLeft = (GAME_UPDATE_PERIOD - timeTaken) / milisecInNanosec; // In
																			// milliseconds

			if (timeLeft < 10)
				timeLeft = 10; // set a minimum
			try {

				Thread.sleep(timeLeft);
			} catch (InterruptedException ex) {
			}
		}
	}

	@Override
	public void Draw(Graphics2D g2d) {
		switch (gameState) {
		case PLAYING:
			game.Draw(g2d, mousePosition());
			break;
		case GAMEOVER:
			game.DrawGameOver(g2d, mousePosition());
			break;

		case DESTROYED:
			game.DrawGameWin(g2d, mousePosition());
			break;

		case MAIN_MENU:
			g2d.drawImage(shootTheDuckMenuImg, 0, 0, frameWidth, frameHeight, null);
			g2d.setFont(font1);
			g2d.setColor(Color.black);
			g2d.drawString("Lavel 2", ControlLavel2.frameWidth / 2 - 59, (int) (ControlLavel2.frameHeight * 0.63) + 1);
			g2d.setFont(font);
			g2d.setColor(Color.black);
			g2d.drawString("Use left mouse Button To Touch The Fish.", frameWidth / 2 - 190,
					(int) (frameHeight * 0.69));
			g2d.setFont(font);
			g2d.drawString("Press ESC or 3 any time to Go To  the MainMenu.", frameWidth / 2 - 220,
					(int) (frameHeight * 0.73));
			g2d.setFont(font);
			g2d.drawString("Click with left mouse button to start the Game.", frameWidth / 2 - 220,
					(int) (frameHeight * 0.77));
			g2d.setColor(Color.white);
			

			break;
		case OPTIONS:
			// ...
			break;
		case GAME_CONTENT_LOADING:
			g2d.setFont(font);
			g2d.setColor(Color.white);
			g2d.drawString("GAME IS LOADING.....", frameWidth / 2 - 150, frameHeight / 2);
			break;
		}
	}

	/**
	 * Starts new game.
	 */
	private void newGame() {

		gameTime = 0;
		lastTime = System.nanoTime();

		game = new GameLavel2();
	}

	private void restartGame() {

		gameTime = 0;
		lastTime = System.nanoTime();

		game.RestartGame();

		// We change game status so that the game can start.
		gameState = GameState.PLAYING;
	}

	private Point mousePosition() {
		try {
			Point mp = this.getMousePosition();

			if (mp != null)
				return this.getMousePosition();
			else
				return new Point(0, 0);
		} catch (Exception e) {
			return new Point(0, 0);
		}
	}

	@SuppressWarnings("incomplete-switch")
	@Override
	public void keyReleasedFramework(KeyEvent e) {
		switch (gameState) {
		case GAMEOVER:
			if (e.getKeyCode() == KeyEvent.VK_HOME) {
				this.setVisible(false);
				ShowTitlepageTwo.destroytitlepage_two();
				mainboard = new MainMenu();
			} else if (e.getKeyCode() == KeyEvent.VK_SPACE)
				restartGame();
			break;
		
			
			
		case PLAYING:
			if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
				gameState = GameState.MAIN_MENU;
			break;
		case MAIN_MENU:
			if (e.getKeyCode() == KeyEvent.VK_3)
			this.setVisible(false);
			ShowTitlepageTwo.destroytitlepage_two();
			mainboard = new MainMenu();
			break;
			case DESTROYED:
			if (e.getKeyCode() == KeyEvent.VK_P) {
				showtitlepage_three = new ShowTitlePageThree();
				ShowTitlepageTwo.destroytitlepage_two();
				this.setVisible(false);

			} else if (e.getKeyCode() == KeyEvent.VK_HOME) {
				this.setVisible(false);
				ShowTitlepageTwo.destroytitlepage_two();
				mainboard = new MainMenu();

			}
			break;

		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		switch (gameState) {
		case MAIN_MENU:
			if (e.getButton() == MouseEvent.BUTTON1)
				newGame();
			break;
		}
	}
}
