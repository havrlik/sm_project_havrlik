package main.java.project.havrlik.soft.filefixtures.smguiswing.main;

import javax.swing.JFrame;

import main.java.project.havrlik.soft.filefixtures.smlib.SmLib;


public class G1_MainFrame extends main.java.project.havrlik.soft.smguiswing.screen.main.G1_MainFrame {
	
	private static final long serialVersionUID = 6253423998719431202L;
	
	protected SmLib smLib;
	
	protected G2_Main g2_Main;


	public G1_MainFrame(SmLib smLib) {
		super(smLib);
		this.smLib = smLib;
		
		constructor2_sub();
		
		constructorContinues();
	}
	
	
	@Override
	protected void call_constructorContinues() {  }
	
	
	protected void constructor2_sub() {
		GuiAppFrame_name = smLib.introduction.customValues.application_name;
		GuiAppFrame_dimension = smLib.introduction.guiSwing_Dimension.get_guiFrameDimension().getDimensions();
		appFrame_setDefaultCloseOperation = JFrame.EXIT_ON_CLOSE;  // DO_NOTHING_ON_CLOSE ; EXIT_ON_CLOSE ; 
		
//		setExitBehavior();
	}
	
	
	@Override
	protected void initializeFeatures() {
		g2_Main = new G2_Main(smLib);
		this.add(g2_Main);
	}

}
