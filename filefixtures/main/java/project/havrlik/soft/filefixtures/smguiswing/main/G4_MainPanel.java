package main.java.project.havrlik.soft.filefixtures.smguiswing.main;

import main.java.project.havrlik.soft.smguiswing.screen.main.G4b_Info;
import main.java.project.havrlik.soft.smguiswing.screen.main.G4c_Messages;
import main.java.project.havrlik.soft.smguiswing.screen.main.G4d_MainTabs;
import main.java.project.havrlik.soft.smlib.SmLib;


public class G4_MainPanel extends main.java.project.havrlik.soft.smguiswing.screen.main.G4_MainPanel {
	
	private static final long serialVersionUID = 2783000901410527931L;
	
	public G4a_Home g4a_Home;
//	public G4b_Info_Sm g4b_Info;
//	public G4c_Messages_Sm g4c_Messages;
//	public G4d_MainTabs_Sm g4d_MainTabs;
	
	
	public G4_MainPanel(SmLib smLib) {
		super(smLib);
		
		constructorContinues();
	}
	
	
	@Override
	protected void call_constructorContinues() {  }
	
	
	@Override
	protected void constructor4_sub() {
	}
	
	
	@Override
	protected void initializeFeatures() {
		g4a_Home = new G4a_Home(smLib);
		super.g4a_Home = g4a_Home;
		g4b_Info = new G4b_Info(smLib);
//		super.g4b_Info = g4b_Info;
		g4c_Messages = new G4c_Messages(smLib);
//		super.g4c_Messages = g4c_Messages;
		g4d_MainTabs = new G4d_MainTabs(smLib);
//		super.g4d_MainTabs = g4d_MainTabs;
	}

}
