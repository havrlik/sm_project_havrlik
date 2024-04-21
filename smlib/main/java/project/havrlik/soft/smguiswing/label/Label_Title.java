package main.java.project.havrlik.soft.smguiswing.label;

import javax.swing.JLabel;

import main.java.project.havrlik.soft.smguiswing.font.Font_Title_H1;

public class Label_Title extends JLabel {
	
	private static final long serialVersionUID = -4970843269732654407L;
	
	
	public Label_Title(String text, int width_leftEdge, int width_rightEdge) {
		super(text);
		
		this.setFont(new Font_Title_H1());
		this.setBounds(width_leftEdge, 10, width_rightEdge - width_leftEdge, 21);  // setBounds(x position, y position, x width, y height)
	}
	
	
	// Set space at left for button.
	public Label_Title(String text, int width_rightEdge) {
		this(text, 90, width_rightEdge);
	}

}
