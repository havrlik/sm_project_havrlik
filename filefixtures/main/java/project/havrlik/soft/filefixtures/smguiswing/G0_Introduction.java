package main.java.project.havrlik.soft.filefixtures.smguiswing;

import main.java.project.havrlik.soft.filefixtures.smguiswing.main.G1_MainFrame;
import main.java.project.havrlik.soft.filefixtures.smlib.SmLib;


public class G0_Introduction extends main.java.project.havrlik.soft.smguiswing.screen.G0_Introduction {
	
	protected SmLib smLib;
	
	
	public G0_Introduction(SmLib smLib) {
		super(smLib);
		this.smLib = smLib;
		
		constructorContinues();
	}
	
	
	@Override
	protected void initializeFeatures() {
		g1_MainFrame = new G1_MainFrame(smLib);
	}

}
