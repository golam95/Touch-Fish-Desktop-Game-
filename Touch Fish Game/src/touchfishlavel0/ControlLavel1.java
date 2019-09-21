package touchfishlavel0;

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
import javax.swing.JOptionPane;

import touchfishlavel1.ShowTitlepageTwo;

public class ControlLavel1 extends ActionLavel1 {
	MainMenu mainboard;

	Music music;
	ShowTitlepageTwo w;
	Font font = new Font("monospaced", Font.BOLD, 18);
	Font font1 = new Font("monospaced", Font.BOLD, 38);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Music mu = new Music();
	public static int frameWidth;
	public static int frameHeight;
	public static final long secInNanosec = 1000000000L;
	public static final long secInNanosec_s = 2000000000L;
	public static final long milisecInNanosec = 1000000L;
	private final int GAME_FPS = 60;
	private final long GAME_UPDATE_PERIOD = secInNanosec / GAME_FPS;

	public static enum GameState {
		STARTING, VISUALIZING, GAME_CONTENT_LOADING, MAIN_MENU, OPTIONS, PLAYING, GAMEOVER, DESTROYED
	}

	public static GameState gameState;
	private long gameTime;
	@SuppressWarnings("unused")
	private long lastTime;
	private GameLavel1 game;
	private BufferedImage shootTheDuckMenuImg;

	public ControlLavel1() {
		super();

		gameState = GameState.VISUALIZING;
		music = new Music();

		// We start game in new thread.
		Thread gameThread = new Thread() {
			@Override
			public void run() {
				GameLoop();
				restartGame();
			}
		};
		gameThread.start();
	}

	// private void Initialize() {
	//
	// }

	private void LoadContent() {
		try {
			URL shootTheDuckMenuImgUrl = this.getClass().getResource("/touchfishlavel0/resource/menu.jpg");
			shootTheDuckMenuImg = ImageIO.read(shootTheDuckMenuImgUrl);
		} catch (IOException ex) {
			Logger.getLogger(ControlLavel1.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@SuppressWarnings("incomplete-switch")
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
				// Sets variables and objects.
				// Initialize();
				// Load files - images, sounds, ...
				LoadContent();

				// When all things that are called above finished, we change
				// game status to main menu.
				gameState = GameState.MAIN_MENU;
				break;
			case VISUALIZING:

				if (this.getWidth() > 1 && visualizingTime > secInNanosec) {
					frameWidth = this.getWidth();
					frameHeight = this.getHeight();
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

	@SuppressWarnings("incomplete-switch")
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
			g2d.drawString("Lavel 1", ControlLavel1.frameWidth / 2 - 59,
					(int) (ControlLavel1.frameHeight * 0.63) + 1);
			g2d.setFont(font);
			g2d.setColor(Color.black);
			g2d.drawString("Use left mouse Button To Touch The Fish.", frameWidth / 2 - 190, (int) (frameHeight * 0.69));
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
			g2d.setColor(Color.white);
			g2d.setFont(font1);
			g2d.drawString("GAME IS LOADING.....", frameWidth / 2 - 140, frameHeight / 2);
			break;
		}
	}

	/**
	 * Starts new game.
	 */
	private void newGame() {

		gameTime = 0;
		lastTime = System.nanoTime();

		game = new GameLavel1();
	}

	private void restartGame() {

		gameTime = 0;
		lastTime = System.nanoTime();

		game.RestartGame();

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
				ShowTitlePage.garamashi();
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
			ShowTitlePage.garamashi();
			mainboard = new MainMenu();
			break;
		case DESTROYED:
			if (e.getKeyCode() == KeyEvent.VK_P) {
				w = new ShowTitlepageTwo();
				this.setVisible(false);
				ShowTitlePage.garamashi();
				break;

			} else if (e.getKeyCode() == KeyEvent.VK_HOME) {
				this.setVisible(false);
				ShowTitlePage.garamashi();
				mainboard = new MainMenu();
				break;

			}
		

		}
	}

	@SuppressWarnings("incomplete-switch")
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
