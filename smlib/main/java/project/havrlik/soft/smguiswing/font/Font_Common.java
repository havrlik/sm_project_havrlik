package main.java.project.havrlik.soft.smguiswing.font;

import java.awt.Font;

/**
 * 
 * 
 * UIManager.put("swing.boldMetal", Boolean.FALSE);  // Disable all text bold.
 * 
 * Font - set:
 * label.setFont(new Font("", Font.PLAIN, 12));
 * label.setFont(new Font(label1.getFont().getName(), Font.PLAIN, 18));  // Swing default font: 'Dialog'.
 * 
 * Available fonts:
 * Font.MONOSPACED
 * Font.SERIF
 * Font.SANS_SERIF
 * Font.DIALOG
 * "Arial"
 */


public class Font_Common extends Font {
	
	private static final long serialVersionUID = -1760912232721081594L;

	public Font_Common() {
//		super("Dialog", Font.PLAIN, 12);  // Setup before 2019-12.
		super("Arial", Font.PLAIN, 12);
	}

}
