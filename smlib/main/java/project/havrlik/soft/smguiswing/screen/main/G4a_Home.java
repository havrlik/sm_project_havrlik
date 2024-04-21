package main.java.project.havrlik.soft.smguiswing.screen.main;

import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import main.java.project.havrlik.soft.smguiswing.label.Label_Title;
import main.java.project.havrlik.soft.smlib.SmLib;
import main.java.project.havrlik.soft.smlib.introduction.Intoduction_GuiSwing_Dimension;

public class G4a_Home {
	
	protected SmLib smLib;
	protected Intoduction_GuiSwing_Dimension guiDimension;
	
	protected String thisFunctionnalityName;
	protected String thisFunctionnalityName_short;
	
	protected JScrollPane mainPanel;
	
	protected JButton button0_toTabs;
	protected JButton button1;
	
	
	public G4a_Home(SmLib smLib) {
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
		thisFunctionnalityName = "Home";
		thisFunctionnalityName_short = "Home";
	}
	
	
	protected void content() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		header(panel);
		
		int layoutPosition_y = 50;
		
//		JLabel label1 = new JLabel("1) Template functionnality");
//		label1.setBounds(15, layoutPosition_y, 680, 20);
//		panel.add(label1);
//		
//		button1 = new JButton("Go");
//		button1.setBounds(700, layoutPosition_y, 180, 22);
//		panel.add(button1);
//		layoutPosition_y += 35;
		
		// Set main panel.
		panel.setPreferredSize(new Dimension(guiDimension.width_panelScrolling, layoutPosition_y + 5));  // Set dimensions according to content.
		mainPanel = new JScrollPane(panel);
		mainPanel.setBorder(null);
	}
	
	
	protected JPanel header(JPanel panel) {
		Label_Title label_title = new Label_Title(thisFunctionnalityName, guiDimension.width_leftPadding + 10, guiDimension.width_rightEdge - 60);
		panel.add(label_title);
		
		button0_toTabs = new JButton("→ Tabs");
		button0_toTabs.setMargin(new Insets(1, 1, 1, 1));
		button0_toTabs.setBounds(guiDimension.width_rightEdge - 60, 6, 60, 26);
		panel.add(button0_toTabs);
		
		return panel;
	}

}
