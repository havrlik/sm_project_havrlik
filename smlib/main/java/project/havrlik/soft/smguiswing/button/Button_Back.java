package main.java.project.havrlik.soft.smguiswing.button;

import java.awt.Insets;

import javax.swing.JButton;

public class Button_Back extends JButton {
	
	private static final long serialVersionUID = -6620005446225565489L;
	
	
	public Button_Back() {
		super("← Back");
		
		this.setMargin(new Insets(1, 1, 1, 1));
		this.setBounds(10, 6, 60, 26);
	}

}
