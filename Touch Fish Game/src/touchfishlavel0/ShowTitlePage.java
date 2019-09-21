package touchfishlavel0;

import javax.swing.JFrame;

public class ShowTitlePage  {
	public static JFrame fram=new JFrame();
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings({ "unused", "static-access" }) ShowTitlePage() {
		fram.setTitle("Touch Fish");
		if (true) {

			fram.setUndecorated(true);

			fram.setExtendedState(fram.MAXIMIZED_BOTH);
		} else // Window mode
		{
			fram.setSize(800, 600);
			fram.setLocationRelativeTo(null);
			fram.setResizable(true);
		}
		fram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fram.setContentPane(new ControlLavel1());
		fram.setVisible(true);
	}
	public static void garamashi(){
		fram.setVisible(false);
		fram.dispose();
		
	}


	
}
