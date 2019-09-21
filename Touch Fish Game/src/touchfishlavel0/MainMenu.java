package touchfishlavel0;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class MainMenu extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Dimension screen_slash = Toolkit.getDefaultToolkit().getScreenSize();
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screen = kit.getScreenSize();
	protected int screenheith = screen.height;
	protected int screedwidth = screen.width;

	String sMSGBOX_TITLE = "TOUCH FISH GAME";
	private JPanel pan = new JPanel();
	private JPanel pan1 = new JPanel();
	Border thick_sager_Border = new LineBorder(Color.decode("#022248"), 30);//
	Border thick_sager_Border3 = new LineBorder(Color.decode("#875A3C"), 10);
	Border thick_sager_Border4 = new LineBorder(Color.decode("#875A3C"), 5);

	Border thick_sager_Border5 = new LineBorder(Color.decode("#875A3C"), 5);

	JLabel lbl_image = new JLabel(new ImageIcon("images/img1.jpg"));
	JLabel lbl_image1 = new JLabel(new ImageIcon("images/img1.jpg"));

	JButton btn_startgame = new JButton("Start Game");
	private JButton btn_Selectlavel = new JButton("Lavel");
	private JButton btn_rules = new JButton("Rules");
	private JButton btn_setting = new JButton("Settings");
	private JButton btn_author = new JButton("Author");
	JButton btn_highsource = new JButton("High Score");
	private JButton btn_exit = new JButton("Exit");

	Font font = new Font("Garamond", Font.BOLD, 20);
	Font font1 = new Font("Impact", Font.BOLD, 120);
	Font font3 = new Font("Garamond", Font.BOLD, 40);

	Font font4 = new Font("Garamond", Font.BOLD, 20);

	private JLabel txt_third = new JLabel(new ImageIcon("images/Treasure.png"));/// Treasure.png
	private JLabel txt_forth = new JLabel(new ImageIcon("images/Treasure.png"));/// Treasure.png
	private JLabel txt_first = new JLabel(new ImageIcon("images/Treasure.png"));/// Treasure.png
	private JLabel txt_second = new JLabel(new ImageIcon("images/Treasure.png"));/// Treasure.png

	// star field
	private JLabel txt_star1 = new JLabel(new ImageIcon("images/20.png"));
	private JLabel txt_star2 = new JLabel(new ImageIcon("images/20.png"));
	private JLabel txt_star3 = new JLabel(new ImageIcon("images/20.png"));
	private JLabel txt_star4 = new JLabel(new ImageIcon("images/20.png"));
	private JLabel txt_star5 = new JLabel(new ImageIcon("images/20.png"));
	private JLabel txt_star6 = new JLabel(new ImageIcon("images/20.png"));
	private JLabel txt_star7 = new JLabel(new ImageIcon("images/20.png"));
	private JLabel txt_side_star1 = new JLabel(new ImageIcon("images/20.png"));
	private JLabel txt_side_star2 = new JLabel(new ImageIcon("images/20.png"));
	private JLabel txt_side_star3 = new JLabel(new ImageIcon("images/20.png"));
	private JLabel txt_side_star4 = new JLabel(new ImageIcon("images/20.png"));
	private JLabel txt_side_star5 = new JLabel(new ImageIcon("images/20.png"));
	private JLabel txt_side_star6 = new JLabel(new ImageIcon("images/20.png"));
	private JLabel txt_side_star7 = new JLabel(new ImageIcon("images/20.png"));
	// lavel
	JPanel pan_lavel1 = new JPanel();

	JLabel btn_lavel2 = new JLabel(new ImageIcon("images/lavel1.jpg"));
	JLabel btn_lavel3 = new JLabel(new ImageIcon("images/lavel2.jpg"));
	JLabel btn_lavel4 = new JLabel(new ImageIcon("images/lavel3.jpg"));
	JLabel btn_lavel5 = new JLabel(new ImageIcon("images/lavel4.jpg"));

	private JLabel lbl_lavelselect = new JLabel("Total Lavel");
	private JLabel lbl_authorselect = new JLabel("Authors Details");
	private JButton lbl_back = new JButton("Back");

	// Author

	JPanel pan_lavel2 = new JPanel();
	JLabel lbl_author1 = new JLabel(new ImageIcon("images/khalid.jpg"));
	JLabel lbl_author2 = new JLabel(new ImageIcon("images/golam.jpg"));
	JLabel lbl_author3 = new JLabel(new ImageIcon("images/seam.jpg"));
	JLabel lbl_campus = new JLabel("Works at Daffodil Internation Academy");
	JLabel lbl_batch = new JLabel("L5DC 68Batch");
	// sound setting

	private JCheckBox check_on = new JCheckBox("ON");
	private JCheckBox check_off = new JCheckBox("OFF");
	JLabel lbl_sound = new JLabel("Sound Settings");

	// style
	JPanel txt_1 = new JPanel();
	JLabel txt_2 = new JLabel(new ImageIcon("images/new.png"));
	JLabel txt_3 = new JLabel(new ImageIcon("images/new.png"));
	JLabel txt_4 = new JLabel(new ImageIcon("images/new.png"));
	JLabel txt_5 = new JLabel(new ImageIcon("images/new.png"));
	JLabel txt_6 = new JLabel(new ImageIcon("images/new.png"));
	JLabel txt_7 = new JLabel(new ImageIcon("images/new.png"));
	JLabel txt_8 = new JLabel(new ImageIcon("images/new.png"));
	JLabel txt_9 = new JLabel(new ImageIcon("images/new.png"));
	JLabel txt_10 = new JLabel(new ImageIcon("images/new.png"));
	JLabel txt_11 = new JLabel(new ImageIcon("images/new.png"));

	// about game

	JLabel txt_no1 = new JLabel("Game Rules");
	JLabel txt_no2 = new JLabel("User left mouse to start the game");
	JLabel txt_no3 = new JLabel("User left mouse to touch the fish");
	JLabel txt_no4 = new JLabel("User Esc or 3 to go the mainmenu");
	JLabel txt_no5 = new JLabel("This game has 4 lavel");

	JLabel txt_no2_st = new JLabel(new ImageIcon("images/20.png"));
	JLabel txt_no3_st = new JLabel(new ImageIcon("images/20.png"));
	JLabel txt_no4_st = new JLabel(new ImageIcon("images/20.png"));
	JLabel txt_no5_st = new JLabel(new ImageIcon("images/20.png"));
	JLabel txt_no6_st = new JLabel(new ImageIcon("images/20.png"));
	JLabel txt_no7_st = new JLabel(new ImageIcon("images/20.png"));

	// about game

	private ShowTitlePage w;
	private Music music = new Music();

	public MainMenu() {
		try {
			this.play();

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString());

		}

	}

	public void play() {
		try {
			this.setExtendedState(this.MAXIMIZED_BOTH);
			this.setTitle("Touch Fish");
			this.setLayout(null);
			this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					UnloadWindow();
				}
			});

			this.setLocation(screenheith / 4, screedwidth / 16);
			pan.setBounds(0, 0, 1368, 748);
			pan.setBorder(thick_sager_Border);
			pan.setBackground(Color.decode("#002367"));
			pan.setLayout(null);

			pan1.setBorder(thick_sager_Border3);

			pan1.setBackground(Color.decode("#C8A064"));
			pan1.setLayout(null);
			JLabel lbl_mainmenu = new JLabel(new ImageIcon("images/mainmenu.png"));
			JLabel lbl_title = new JLabel("TOUCH FISH");
			pan1.setBounds(365, 250, 620, 463);
			lbl_image.setBounds(30, 250, 355, 463);
			lbl_image1.setBounds(984, 250, 355, 463);

			lbl_title.setBounds(375, 38, 640, 120);
			txt_first.setBounds(50, 37, 150, 120);
			txt_second.setBounds(210, 37, 150, 120);
			txt_third.setBounds(1020, 37, 150, 120);
			txt_forth.setBounds(1170, 37, 150, 120);

			txt_1.setLayout(new GridLayout(0, 10));
			txt_1.setBounds(210, 175, 940, 75);
			// txt_1.setBackground(Color.decode("#"));
			txt_1.add(txt_2);
			txt_1.add(txt_3);
			txt_1.add(txt_4);
			txt_1.add(txt_5);
			txt_1.add(txt_6);
			txt_1.add(txt_7);
			txt_1.add(txt_8);
			txt_1.add(txt_9);
			txt_1.add(txt_10);
			txt_1.add(txt_11);
			txt_1.setBackground(Color.decode("#875A3C"));

			txt_1.setBorder(thick_sager_Border5);
			pan.add(txt_1);

			lbl_image1.setBorder(thick_sager_Border3);
			lbl_image.setBorder(thick_sager_Border3);
			lbl_title.setForeground(Color.white);
			lbl_title.setFont(font1);
			pan.add(lbl_title);
			pan.add(txt_first);
			pan.add(txt_second);
			pan.add(txt_third);
			pan.add(txt_forth);
			pan.add(lbl_image1);
			pan.add(lbl_image);
			lbl_mainmenu.setBounds(100, 20, 432, 70);
			lbl_lavelselect.setFont(font3);
			lbl_lavelselect.setForeground(Color.pink);
			lbl_lavelselect.setBounds(580, 280, 250, 30);

			lbl_campus.setBounds(550, 535, 360, 30);
			lbl_batch.setBounds(650, 565, 200, 30);

			lbl_authorselect.setFont(font3);
			lbl_authorselect.setForeground(Color.pink);
			lbl_authorselect.setBounds(580, 280, 300, 30);

			txt_no1.setFont(font3);
			txt_no1.setForeground(Color.pink);
			txt_no1.setBounds(580, 280, 250, 30);

			txt_no2.setBounds(510, 350, 650, 30);
			txt_no3.setBounds(510, 400, 650, 30);
			txt_no4.setBounds(510, 450, 650, 30);
			txt_no5.setBounds(510, 500, 650, 30);

			txt_no2_st.setBounds(470, 357, 20, 20);
			txt_no3_st.setBounds(470, 407, 20, 20);
			txt_no4_st.setBounds(470, 457, 20, 20);
			txt_no5_st.setBounds(470, 507, 20, 20);
			txt_no6_st.setBounds(470, 557, 20, 20);
			txt_no7_st.setBounds(470, 607, 20, 20);

			txt_no2.setFont(font4);
			txt_no2.setForeground(Color.WHITE);

			txt_no3.setFont(font4);
			txt_no3.setForeground(Color.WHITE);
			txt_no4.setFont(font4);
			txt_no4.setForeground(Color.WHITE);
			txt_no5.setFont(font4);
			txt_no5.setForeground(Color.WHITE);

			pan.add(txt_no2_st);
			pan.add(txt_no3_st);
			pan.add(txt_no4_st);
			pan.add(txt_no5_st);
			pan.add(txt_no6_st);
			pan.add(txt_no7_st);

			pan.add(txt_no1);
			pan.add(txt_no2);
			pan.add(txt_no3);
			pan.add(txt_no4);
			pan.add(txt_no5);

			lbl_sound.setFont(font3);
			check_on.setFont(font);
			check_off.setFont(font);
			lbl_sound.setForeground(Color.pink);
			lbl_sound.setBounds(580, 280, 300, 50);

			check_on.setBounds(650, 400, 80, 30);
			check_off.setBounds(650, 450, 80, 30);

			check_on.setForeground(Color.RED);
			check_off.setForeground(Color.RED);
			ButtonGroup group = new ButtonGroup();
			group.add(check_off);
			group.add(check_on);

			check_on.setBackground(Color.blue);
			check_off.setBackground(Color.blue);

			check_on.addActionListener(this);
			check_off.addActionListener(this);

			pan.add(check_on);
			pan.add(check_off);
			pan.add(lbl_sound);

			// txt_batch.setBounds(400, 485, 100, 30);
			lbl_back.setFont(font);
			lbl_back.setBounds(630, 665, 130, 30);
			pan_lavel1.setBounds(300, 350, 780, 290);
			pan_lavel1.setLayout(new GridLayout(0, 2));
			pan_lavel1.setBackground(Color.gray);
			pan_lavel1.setBorder(thick_sager_Border4);
			pan_lavel2.setBounds(300, 350, 780, 170);
			pan_lavel2.setLayout(new GridLayout(0, 3));
			pan_lavel2.setBackground(Color.gray);
			lbl_author1.setBorder(thick_sager_Border4);
			lbl_author2.setBorder(thick_sager_Border4);
			lbl_author3.setBorder(thick_sager_Border4);

			pan_lavel2.add(lbl_author1);
			pan_lavel2.add(lbl_author2);
			pan_lavel2.add(lbl_author3);

			pan_lavel2.setBorder(thick_sager_Border4);
			lbl_campus.setForeground(Color.ORANGE);
			lbl_batch.setForeground(Color.ORANGE);
			lbl_campus.setFont(font);
			lbl_batch.setFont(font);
			pan.add(lbl_campus);
			pan.add(lbl_batch);
			btn_lavel2.setBorder(thick_sager_Border4);
			btn_lavel3.setBorder(thick_sager_Border4);
			btn_lavel4.setBorder(thick_sager_Border4);
			btn_lavel5.setBorder(thick_sager_Border4);

			btn_lavel2.setToolTipText("Lavel 1");
			btn_lavel3.setToolTipText("Lavel 2");
			btn_lavel4.setToolTipText("Lavel 3");
			btn_lavel5.setToolTipText("Lavel 4");

			pan_lavel1.add(btn_lavel2);
			pan_lavel1.add(btn_lavel3);
			pan_lavel1.add(btn_lavel4);
			pan_lavel1.add(btn_lavel5);

			pan.add(pan_lavel1);
			pan.add(pan_lavel2);

			btn_startgame.setBounds(190, 110, 220, 30);
			btn_Selectlavel.setBounds(190, 160, 220, 30);
			btn_rules.setBounds(190, 210, 220, 30);
			btn_setting.setBounds(190, 260, 220, 30);
			btn_author.setBounds(190, 310, 220, 30);
			btn_highsource.setBounds(190, 360, 220, 30);
			btn_exit.setBounds(190, 410, 220, 30);

			txt_star1.setBounds(172, 115, 20, 20);
			txt_star2.setBounds(172, 165, 20, 20);
			txt_star3.setBounds(172, 215, 20, 20);
			txt_star4.setBounds(172, 265, 20, 20);
			txt_star5.setBounds(172, 315, 20, 20);
			txt_star6.setBounds(172, 365, 20, 20);
			txt_star7.setBounds(172, 410, 20, 20);

			txt_side_star1.setBounds(408, 115, 20, 20);
			txt_side_star2.setBounds(408, 165, 20, 20);
			txt_side_star3.setBounds(408, 215, 20, 20);
			txt_side_star4.setBounds(408, 265, 20, 20);
			txt_side_star5.setBounds(408, 315, 20, 20);
			txt_side_star6.setBounds(408, 365, 20, 20);
			txt_side_star7.setBounds(408, 410, 20, 20);

			btn_startgame.setBackground(Color.decode("#38707F"));// 5B3331
			btn_Selectlavel.setBackground(Color.decode("#38707F"));
			btn_rules.setBackground(Color.decode("#38707F"));
			btn_setting.setBackground(Color.decode("#38707F"));
			btn_author.setBackground(Color.decode("#38707F"));
			btn_exit.setBackground(Color.decode("#38707F"));
			btn_highsource.setBackground(Color.decode("#38707F"));
			btn_startgame.addActionListener(this);
			btn_Selectlavel.addActionListener(this);
			btn_rules.addActionListener(this);
			btn_setting.addActionListener(this);
			btn_author.addActionListener(this);
			btn_exit.addActionListener(this);
			btn_highsource.addActionListener(this);
			btn_startgame.setForeground(Color.white);
			btn_Selectlavel.setForeground(Color.white);
			btn_rules.setForeground(Color.white);
			btn_setting.setForeground(Color.white);
			btn_author.setForeground(Color.white);
			btn_exit.setForeground(Color.white);
			btn_highsource.setForeground(Color.white);
			btn_startgame.setFont(font);
			btn_Selectlavel.setFont(font);
			btn_rules.setFont(font);
			btn_setting.setFont(font);
			btn_author.setFont(font);
			btn_exit.setFont(font);
			btn_highsource.setFont(font);
			pan1.add(txt_side_star1);
			pan1.add(txt_side_star2);
			pan1.add(txt_side_star3);
			pan1.add(txt_side_star4);
			pan1.add(txt_side_star5);
			pan1.add(txt_side_star6);
			pan1.add(txt_side_star7);
			pan1.add(txt_star1);
			pan1.add(txt_star2);
			pan1.add(txt_star3);
			pan1.add(txt_star4);
			pan1.add(txt_star5);
			pan1.add(txt_star6);
			pan1.add(txt_star7);
			pan1.add(lbl_mainmenu);
			pan1.add(btn_rules);
			pan1.add(btn_setting);
			pan1.add(btn_author);
			pan1.add(btn_exit);
			pan1.add(btn_highsource);
			pan1.add(btn_Selectlavel);
			pan1.add(btn_startgame);
			pan.add(pan1);
			// for lavel
			check_on.setEnabled(false);
			lbl_back.addActionListener(this);
			pan.add(lbl_lavelselect);
			pan.add(lbl_authorselect);
			pan.add(lbl_back);
			this.add(pan);
			mainmenu();

			this.setVisible(true);
		} catch (Exception ex1) {
			JOptionPane.showMessageDialog(null, ex1.toString());

		}

	}

	private void UnloadWindow() {

		int j = JOptionPane.showConfirmDialog(null, "Do you want to Exit ?");
		if (j == 0) {
			music.stop_second();
			this.setVisible(false);
			dispose();

		}

	}// Close the Windows

	public void author() {
		try {
			pan1.setVisible(false);
			lbl_image.setVisible(false);
			lbl_image1.setVisible(false);
			pan_lavel1.setVisible(false);
			check_on.setVisible(false);
			check_off.setVisible(false);
			lbl_sound.setVisible(false);

			lbl_authorselect.setVisible(true);
			lbl_back.setVisible(true);
			pan_lavel2.setVisible(true);
			lbl_campus.setVisible(true);
			lbl_batch.setVisible(true);

			txt_no1.setVisible(false);
			txt_no2.setVisible(false);
			txt_no3.setVisible(false);
			txt_no4.setVisible(false);

			txt_no5.setVisible(false);

			txt_no2_st.setVisible(false);
			txt_no3_st.setVisible(false);
			txt_no4_st.setVisible(false);
			txt_no5_st.setVisible(false);
			txt_no6_st.setVisible(false);
			txt_no7_st.setVisible(false);

		} catch (Exception ex2) {
			JOptionPane.showMessageDialog(null, ex2.toString());

		}
	}

	public void rules() {
		try {
			pan1.setVisible(false);
			lbl_image.setVisible(false);
			lbl_image1.setVisible(false);
			lbl_batch.setVisible(false);
			lbl_campus.setVisible(false);
			lbl_authorselect.setVisible(false);
			pan_lavel2.setVisible(false);
			pan_lavel1.setVisible(false);
			lbl_lavelselect.setVisible(false);
			check_on.setVisible(false);
			check_off.setVisible(false);
			lbl_sound.setVisible(false);

			lbl_back.setVisible(true);

			txt_no1.setVisible(true);
			txt_no2.setVisible(true);
			txt_no3.setVisible(true);
			txt_no4.setVisible(true);
			txt_no5.setVisible(true);

			txt_no2_st.setVisible(true);
			txt_no3_st.setVisible(true);
			txt_no4_st.setVisible(true);
			txt_no5_st.setVisible(true);
			txt_no6_st.setVisible(true);
			txt_no7_st.setVisible(true);

		} catch (Exception ex2) {
			JOptionPane.showMessageDialog(null, ex2.toString());

		}
	}

	public void settings() {
		try {

			pan1.setVisible(false);
			lbl_image.setVisible(false);
			lbl_image1.setVisible(false);
			lbl_batch.setVisible(false);
			lbl_campus.setVisible(false);
			lbl_authorselect.setVisible(false);
			pan_lavel2.setVisible(false);
			pan_lavel1.setVisible(false);
			lbl_lavelselect.setVisible(false);
			lbl_back.setVisible(true);
			check_on.setVisible(true);
			check_off.setVisible(true);
			lbl_sound.setVisible(true);

			txt_no1.setVisible(false);
			txt_no2.setVisible(false);
			txt_no3.setVisible(false);
			txt_no4.setVisible(false);

			txt_no5.setVisible(false);

			txt_no2_st.setVisible(false);
			txt_no3_st.setVisible(false);
			txt_no4_st.setVisible(false);
			txt_no5_st.setVisible(false);
			txt_no6_st.setVisible(false);
			txt_no7_st.setVisible(false);

		} catch (Exception ex2) {
			JOptionPane.showMessageDialog(null, ex2.toString());

		}
	}

	public void selectlevel() {
		try {
			pan1.setVisible(false);
			lbl_image.setVisible(false);
			lbl_image1.setVisible(false);
			pan_lavel2.setVisible(false);
			lbl_authorselect.setVisible(false);
			lbl_campus.setVisible(false);
			lbl_batch.setVisible(false);
			check_on.setVisible(false);
			check_off.setVisible(false);
			lbl_sound.setVisible(false);
			lbl_lavelselect.setVisible(true);
			lbl_back.setVisible(true);
			pan_lavel1.setVisible(true);

			txt_no1.setVisible(false);
			txt_no2.setVisible(false);
			txt_no3.setVisible(false);
			txt_no4.setVisible(false);

			txt_no5.setVisible(false);

			txt_no2_st.setVisible(false);
			txt_no3_st.setVisible(false);
			txt_no4_st.setVisible(false);
			txt_no5_st.setVisible(false);
			txt_no6_st.setVisible(false);
			txt_no7_st.setVisible(false);

		} catch (Exception ex2) {
			JOptionPane.showMessageDialog(null, ex2.toString());

		}
	}

	public void mainmenu() {
		try {
			pan1.setVisible(true);
			lbl_image.setVisible(true);
			lbl_image1.setVisible(true);

			lbl_batch.setVisible(false);
			lbl_campus.setVisible(false);
			lbl_authorselect.setVisible(false);
			pan_lavel2.setVisible(false);
			pan_lavel1.setVisible(false);
			lbl_lavelselect.setVisible(false);
			lbl_back.setVisible(false);
			check_on.setVisible(false);
			check_off.setVisible(false);
			lbl_sound.setVisible(false);

			txt_no1.setVisible(false);
			txt_no2.setVisible(false);
			txt_no3.setVisible(false);
			txt_no4.setVisible(false);

			txt_no5.setVisible(false);

			txt_no2_st.setVisible(false);
			txt_no3_st.setVisible(false);
			txt_no4_st.setVisible(false);
			txt_no5_st.setVisible(false);
			txt_no6_st.setVisible(false);
			txt_no7_st.setVisible(false);

		} catch (Exception ex2) {
			JOptionPane.showMessageDialog(null, ex2.toString());

		}
	}

	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		if (source.equals(btn_exit)) {
			int j = JOptionPane.showConfirmDialog(null, "Do you want to Exit ?");
			if (j == 0) {
				music.stop_second();
				this.setVisible(false);
				dispose();

			}

		} else if (source.equals(btn_author)) {
			author();
		} else if (source.equals(btn_startgame)) {
			w = new ShowTitlePage();
			this.setVisible(false);

		} else if (source.equals(btn_rules)) {
			rules();
		} else if (source.equals(btn_setting)) {
			settings();
		} else if (source.equals(btn_Selectlavel)) {
			selectlevel();

		} else if (source.equals(lbl_back)) {
			mainmenu();

		} else if (source.equals(check_on)) {
			music.backgroundLoop_second();
			check_on.setEnabled(false);
			check_off.setEnabled(true);

		} else if (source.equals(check_off)) {
			music.stop_second();
			check_on.setEnabled(true);
			check_off.setEnabled(false);
		}

	}

}
