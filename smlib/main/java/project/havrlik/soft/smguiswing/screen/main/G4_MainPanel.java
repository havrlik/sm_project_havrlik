package main.java.project.havrlik.soft.smguiswing.screen.main;

import java.awt.CardLayout;

import javax.swing.JPanel;

import main.java.project.havrlik.soft.smlib.SmLib;

public class G4_MainPanel extends JPanel {
	
	private static final long serialVersionUID = 3916621300570791406L;
	
	protected SmLib smLib;
	
	protected CardLayout cardLayout_main;
	
	protected G4a_Home g4a_Home;
	protected final String cons_g4a_Home = "g4a_Home";
	protected G4b_Info g4b_Info;
	protected final String cons_g4b_Info = "g4b_Info";
	protected G4c_Messages g4c_Messages;
	protected final String cons_g4c_Messages = "g4c_Messages";
	protected G4d_MainTabs g4d_MainTabs;
	protected final String cons_g4d_MainTabs = "g4d_MainTabs";
	
	
	public G4_MainPanel(SmLib smLib) {
		this.smLib = smLib;
		
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
	
	
	protected void constructor3() {
		cardLayout_main = new CardLayout();
		this.setLayout(cardLayout_main);
		
		initializeFeatures();
		
		this.add(g4a_Home.mainPanel, cons_g4a_Home);
		this.add(g4b_Info.mainPanel, cons_g4b_Info);
		this.add(g4c_Messages.mainPanel, cons_g4c_Messages);
		this.add(g4d_MainTabs, cons_g4d_MainTabs);
	}
	
	
	protected void constructor4_sub() {  }
	protected void constructor5_super() {  }
	protected void constructor6_sub() {  }
	
	
	protected void initializeFeatures() {
		g4a_Home = new G4a_Home(smLib);
		g4b_Info = new G4b_Info(smLib);
		g4c_Messages = new G4c_Messages(smLib);
		g4d_MainTabs = new G4d_MainTabs(smLib);
	}
	
	
	public G4d_MainTabs get_g4d_MainTabs() { return g4d_MainTabs; }
	
	
	public void showPanel_g4a_Home() {
		cardLayout_main.show(this, cons_g4a_Home);
	}
	
	
	public void showPanel_g4b_Info() {
		cardLayout_main.show(this, cons_g4b_Info);
	}
	
	
	public void showPanel_g4c_Messages() {
		cardLayout_main.show(this, cons_g4c_Messages);
	}
	
	
	public void showPanel_g4d_MainTabs() {
		cardLayout_main.show(this, cons_g4d_MainTabs);
	}
	
}
