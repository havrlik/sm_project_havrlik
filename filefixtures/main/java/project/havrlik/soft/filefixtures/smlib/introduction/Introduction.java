package main.java.project.havrlik.soft.filefixtures.smlib.introduction;

import main.java.project.havrlik.soft.filefixtures.smlib.SmLib;
import main.java.project.havrlik.soft.smlib.introduction.PlatformOs;
import main.java.project.havrlik.soft.smlib.other.AppProperties;

public class Introduction extends main.java.project.havrlik.soft.smlib.introduction.Introduction {
	
	protected SmLib smLib;
	
	public Intoduction_CustomValues customValues;
	public Intoduction_GuiSwing_Dimension guiSwing_Dimension;
	
	
	public Introduction(SmLib smLib) {
		super(smLib);
		this.smLib = smLib;
		
		constructor2_sub();
		
		constructorContinues();
		initializeFeatures();
	}
	
	
	@Override
	protected void call_constructorContinues() {  }
	@Override
	protected void call_initializeFeatures() {  }
	
	
	protected void constructor2_sub() {
		PLATFORM_OS = PlatformOs.LINUX;
	}
	
	
	@Override
	protected void initFeat() {
		customValues = new Intoduction_CustomValues(smLib);
		super.customValues = customValues;
		
		appProperties = new AppProperties(smLib);
		
		guiSwing_Dimension = new Intoduction_GuiSwing_Dimension(smLib);
		super.guiSwing_Dimension = guiSwing_Dimension;
	}

}
