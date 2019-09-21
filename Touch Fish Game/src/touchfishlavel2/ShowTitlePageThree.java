package touchfishlavel2;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ShowTitlePageThree {
	public static JFrame frm_pagethree = new JFrame();

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public ShowTitlePageThree() {
		frm_pagethree.setTitle("Touch Fish");
		if (true) {
			frm_pagethree.setUndecorated(true);
			frm_pagethree.setExtendedState(frm_pagethree.MAXIMIZED_BOTH);
		} else // Window mode
		{
			frm_pagethree.setSize(800, 600);
			frm_pagethree.setLocationRelativeTo(null);
			frm_pagethree.setResizable(false);
		}

		frm_pagethree.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm_pagethree.setContentPane(new ControlLavel3());
		frm_pagethree.setVisible(true);
	}

	public static void destroytitlepage_three() {
		frm_pagethree.setVisible(false);
		frm_pagethree.dispose();
	}

}
