package main.java.project.havrlik.soft.smguiswing.screen.main;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import main.java.project.havrlik.soft.smguiswing.font.Font_Title_H1;
import main.java.project.havrlik.soft.smlib.SmLib;
import main.java.project.havrlik.soft.smlib.introduction.Intoduction_GuiSwing_Dimension;

public class G4b_Info {
	
	protected SmLib smLib;
	protected Intoduction_GuiSwing_Dimension guiDimension;
	
	protected String thisFunctionnalityName;
	protected String thisFunctionnalityName_short;
	
	protected JScrollPane mainPanel;
	
	
	public G4b_Info(SmLib smLib) {
		this.smLib = smLib;
		guiDimension = smLib.introduction.guiSwing_Dimension;
		
		constructor1();
		
		call_constructorContinues();
	}
	
	
	protected void call_constructorContinues() {
		// Recommended disable by overriding empty method and call 'constructorContinues()' at the end of your sub class.
		constructorContinues();
	}
	
	
	protected void constructorContinues() {
		constructor3();
		constructor4_sub();
	}
	
	
	protected void constructor1() {
		set_thisFunctionnalityNames();
		
		content();
	}
	
	
	protected void constructor3() {  }
	protected void constructor4_sub() {  }
	
	
	protected void set_thisFunctionnalityNames() {
		thisFunctionnalityName = "App info";
		thisFunctionnalityName_short = "Info";
	}
	
	
	protected void content() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		header(panel);
		
		int layoutPosition_y = 50;
		
		JLabel label2 = new JLabel("some info");
		label2.setBounds(15, 45, 1085, 20);
		panel.add(label2);
		
		// Set main panel.
		panel.setPreferredSize(new Dimension(guiDimension.width_panelScrolling, layoutPosition_y + 5));  // Set dimensions according to content.
		mainPanel = new JScrollPane(panel);
		mainPanel.setBorder(null);
	}
	
	
	protected JPanel header(JPanel panel) {
		JLabel label0 = new JLabel(thisFunctionnalityName);
		label0.setFont(new Font_Title_H1());
		label0.setBounds(20, 10, 980, 22);  // setBounds(x position, y position, x width, y height)
		panel.add(label0);
		
		return panel;
	}

}
