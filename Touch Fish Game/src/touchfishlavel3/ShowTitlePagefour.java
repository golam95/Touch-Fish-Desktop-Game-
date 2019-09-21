package touchfishlavel3;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ShowTitlePagefour {
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	public static JFrame frm_pagefour = new JFrame();



	@SuppressWarnings("unused")
	public ShowTitlePagefour() {
		frm_pagefour.setTitle("Touch Fish");
		if (true) {
			frm_pagefour.setUndecorated(true);
			frm_pagefour.setExtendedState(frm_pagefour.MAXIMIZED_BOTH);
		} else // Window mode
		{
			frm_pagefour.setSize(800, 600);
			frm_pagefour.setLocationRelativeTo(null);
			frm_pagefour.setResizable(false);
		}

		frm_pagefour.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm_pagefour.setContentPane(new ControlLavel4());
		frm_pagefour.setVisible(true);
	}

	public static void destroytitlepage_four() {
		frm_pagefour.setVisible(false);
		frm_pagefour.dispose();
	}

}
