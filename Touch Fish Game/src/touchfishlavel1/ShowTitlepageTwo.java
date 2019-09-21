package touchfishlavel1;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ShowTitlepageTwo {
	public static JFrame fr_pageTwo = new JFrame();


	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public ShowTitlepageTwo() {
		fr_pageTwo.setTitle("Touch Fish");
		if (true) {
			fr_pageTwo.setUndecorated(true);
			fr_pageTwo.setExtendedState(fr_pageTwo.MAXIMIZED_BOTH);
		} else // Window mode
		{
			fr_pageTwo.setSize(800, 600);
			fr_pageTwo.setLocationRelativeTo(null);
			fr_pageTwo.setResizable(false);
		}

		fr_pageTwo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr_pageTwo.setContentPane(new ControlLavel2());
		fr_pageTwo.setVisible(true);
	}

	public static  void destroytitlepage_two() {
		fr_pageTwo.setVisible(false);
		fr_pageTwo.dispose();

	}
	

}
