package main.java.project.havrlik.soft.smlib.introduction;

import main.java.project.havrlik.soft.smlib.SmLib;

public class Intoduction_CustomValues {
	
	protected SmLib smLib;
	
	
	public String application_name = "OOI";  // Ideas for project name: 'Simple Maker', 'Ocean of inspiration'.
	public String application_nameShort = "OOI";
	public String application_version = "v0.0";
	
	public static int defaultFileNameLengthLimit = 255;
	public String propertiesPath_var = "./var.properties";
	
	// Device.
	public CustomValuesDevice customValuesDevice = null;
	public String defaultWorkspaceDirectory = null;
	
	
	public Intoduction_CustomValues(SmLib smLib) {
		this.smLib = smLib;
		
		call_constructorContinues();
	}
	
	
	protected void call_constructorContinues() {
		// Recommended to disable this method by overriding by empty method in your sub class 
		// and call method bellow at the end of your constructor.
		constructorContinues();
	}
	
	
	protected void constructorContinues() {
		constructor3();
		constructor4_sub();
		constructor5();
		constructor6_sub();
	}
	
	
	protected void constructor3() {}
	protected void constructor4_sub() {  }
	protected void constructor5() {  }
	protected void constructor6_sub() {  }
	
	
	public void setup1() {
		setCustomValues();
	}
	
	
	protected void setCustomValues() {
		setCustomValues_sub();
	}
	
	
	protected void setCustomValues_sub() {  }
	
	
	public void setup2_sub() {  }
	public void setup3() {  }
	public void setup4_sub() {  }

}
