package main.java.project.havrlik.soft.filefixtures.smlib.introduction;

import java.awt.Dimension;

import main.java.project.havrlik.soft.filefixtures.smlib.SmLib;
import main.java.project.havrlik.soft.smlib.other.GuiFrameDimension;

public class Intoduction_GuiSwing_Dimension extends main.java.project.havrlik.soft.smlib.introduction.Intoduction_GuiSwing_Dimension {
	
	protected SmLib smLib;
	
	
	public Intoduction_GuiSwing_Dimension(SmLib smLib) {
		super(smLib);
		this.smLib = smLib;
		
		constructor2_sub();
		
		constructorContinues();
	}
	
	
	@Override
	protected void call_constructorContinues() {  }
	
	
	protected void constructor2_sub() {
		guiFrameDimension_origin = GuiFrameDimension.SIZE_960x640;  // SIZE_960x640 ; SIZE_1150x680 ; SIZE_1280x860 ; 
		
		dimensions_tabScreen = new Dimension(950, 550);  // For 'SIZE_960x640'.
	}

}
