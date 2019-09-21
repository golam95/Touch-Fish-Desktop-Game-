package touchfishlavel0;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Looading extends JFrame {

	private DrawingPanel pan_draw = new DrawingPanel();
	private static final long serialVersionUID = 1L;
	Dimension screen_slash = Toolkit.getDefaultToolkit().getScreenSize();
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screen = kit.getScreenSize();
	protected int screenheith = screen.height;
	protected int screedwidth = screen.width;
	private JPanel pan = new JPanel();
	Border thick_sager_Border = new LineBorder(Color.decode("#022248"), 30);//
	Border thick_sager_Border3 = new LineBorder(Color.decode("#875A3C"), 10);
	Border thick_sager_Border4 = new LineBorder(Color.decode("#875A3C"), 5);
	Font font = new Font("Garamond", Font.BOLD, 20);
	Font font1 = new Font("Impact", Font.BOLD, 120);
	Font font3 = new Font("Garamond", Font.BOLD, 40);
	private JLabel txt_third = new JLabel(new ImageIcon("images/Treasure.png"));/// Treasure.png
	private JLabel txt_forth = new JLabel(new ImageIcon("images/Treasure.png"));/// Treasure.png
	private JLabel txt_first = new JLabel(new ImageIcon("images/Treasure.png"));/// Treasure.png
	private JLabel txt_second = new JLabel(new ImageIcon("images/Treasure.png"));/// Treasure.png
	JLabel lbl_sound = new JLabel("Game Loading....");

	// style
	Music music = new Music();

	@SuppressWarnings("static-access")
	public Looading() {

		this.setExtendedState(this.MAXIMIZED_BOTH);
		this.setTitle("Touch Fish");
		this.setLayout(null);
		this.setResizable(true);
		this.setLocation(screenheith / 4, screedwidth / 16);
		pan.setBounds(0, 0, 1368, 748);
		pan.setBorder(thick_sager_Border);
		pan.setBackground(Color.decode("#002367"));
		pan.setLayout(null);
		JLabel lbl_mainmenu = new JLabel(new ImageIcon("images/mainmenu.png"));
		JLabel lbl_title = new JLabel("TOUCH FISH");
		lbl_title.setBounds(375, 38, 640, 120);
		txt_first.setBounds(50, 37, 150, 120);
		txt_second.setBounds(210, 37, 150, 120);
		txt_third.setBounds(1020, 37, 150, 120);
		txt_forth.setBounds(1170, 37, 150, 120);
		lbl_title.setForeground(Color.WHITE);
		lbl_title.setFont(font1);
		pan.add(lbl_title);
		pan.add(txt_first);
		pan.add(txt_second);
		pan.add(txt_third);
		pan.add(txt_forth);
		lbl_mainmenu.setBounds(100, 20, 432, 70);
		lbl_sound.setFont(font3);
		lbl_sound.setForeground(Color.pink);
		lbl_sound.setBounds(580, 250, 300, 50);
		pan.add(lbl_sound);
		this.add(pan);
		this.setVisible(true);
		pan_draw.setBounds(500, 300, 500, 310);
		pan_draw.setBackground(Color.decode("#002367"));
		this.add(pan_draw);

		new Thread(new Runnable() {

			public void run() {
				for (int sager = 1; sager <= 100; sager++) {
					try {
						pan_draw.UpdateProgress(sager);
						pan_draw.repaint();
						Thread.sleep(90);
					} catch (InterruptedException ex) {
						Logger.getLogger(Looading.class.getName()).log(Level.SEVERE, null, ex);
					}
				}

				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				music.backgroundLoop_second();
				@SuppressWarnings("unused")
				MainMenu menu = new MainMenu();
				sager();

			}

		}).start();

		this.setVisible(true);
	}

	public static void main(String[] arg) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		@SuppressWarnings("unused")
		Looading looading = new Looading();

	}

	public void sager() {
		this.setVisible(false);
		this.dispose();
	}

}
