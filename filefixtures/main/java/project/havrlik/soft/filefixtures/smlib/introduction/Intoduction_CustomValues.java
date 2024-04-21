package main.java.project.havrlik.soft.filefixtures.smlib.introduction;

import main.java.project.havrlik.soft.filefixtures.smlib.SmLib;

public class Intoduction_CustomValues extends main.java.project.havrlik.soft.smlib.introduction.Intoduction_CustomValues {
	
	protected SmLib smLib;
	
	
	public Intoduction_CustomValues(SmLib smLib) {
		super(smLib);
		this.smLib = smLib;
		
		constructorContinues();
	}
	
	
	@Override
	protected void call_constructorContinues() {  }
	
	
	@Override
	protected void setCustomValues_sub() {
		application_name = "File fixturest";
		application_nameShort = "FileFixtures";
		application_version = "v1.0";
		
//		deviceName = "xxxx";
	}

}
