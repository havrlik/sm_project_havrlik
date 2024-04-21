package main.java.project.havrlik.soft.smlib.introduction;

import main.java.project.havrlik.soft.smlib.SmLib;
import main.java.project.havrlik.soft.smlib.other.AppProperties;

public class Introduction {
	
	protected SmLib smLib;
	
	public Intoduction_CustomValues customValues;
	public AppProperties appProperties;
	public Intoduction_GuiSwing_Dimension guiSwing_Dimension;
	
	
	// Preset platforms and operate systems properties.
	
	public static final PlatformOs PLATFORM_OS_MSWindows = PlatformOs.MSWINDOWS;
	public static final char PLATFORM_slashType_MSWindows = '\\';
	
	public static final PlatformOs PLATFORM_OS_Linux = PlatformOs.LINUX;
	public static final char PLATFORM_slashType_Linux = '/';
	
//	public static final String PLATFORM_OS_AppleMacOs = PlatformOs.APPLEMACOS;
//	public static final char PLATFORM_slashType_AppleMacOs = '/';  // ??
	
	
	// Current properties.
	
	protected PlatformOs PLATFORM_OS = PlatformOs.LINUX;
	protected char platform_slashType = PLATFORM_slashType_Linux;
	
	
	public Introduction(SmLib smLib) {
		this.smLib = smLib;
		
		call_constructorContinues();
		call_initializeFeatures();
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
	
	
	protected void constructor3() {  }
	protected void constructor4_sub() {  }
	protected void constructor5() {  }
	protected void constructor6_sub() {  }
	
	
	protected void call_initializeFeatures() {
		// Recommended to disable this method by overriding by empty method in your sub class 
		// and call method bellow at the end of your constructor (2).
		initializeFeatures();
	}
	
	
	protected void initializeFeatures() {
		initFeat();
		initFeat_sub();
	}
	
	
	protected void initFeat() {
		customValues = new Intoduction_CustomValues(smLib);
		
		appProperties = new AppProperties(smLib);
		
		guiSwing_Dimension = new Intoduction_GuiSwing_Dimension(smLib);
	}
	
	
	protected void initFeat_sub() {  }
	
	
	public void setup1() {
		if (PLATFORM_OS.equals(PLATFORM_OS_MSWindows)) {
			platform_slashType = PLATFORM_slashType_MSWindows;
		}
		else if (PLATFORM_OS.equals(PLATFORM_OS_Linux)) {
			platform_slashType = PLATFORM_slashType_Linux;
		}
		else {
			// Mistake.
			PLATFORM_OS = null;
			platform_slashType = 0;
			System.out.println("!! Application 'SM Lib' error message: Please set platform OS and slash type at your class which inherits '" + 
					this.getClass().getName() + "'. Maybe there is missing implementation.");
		}
		
		customValues.setup1();
		appProperties.setup1();
		guiSwing_Dimension.setup1();
		
		customValues.setup2_sub();
		appProperties.setup2_sub();
		guiSwing_Dimension.setup2_sub();
	}
	
	
	public void setup2_sub() {  }
	
	
	public void setup3() {
		
		customValues.setup3();
		appProperties.setup3();
		guiSwing_Dimension.setup3();
		
		customValues.setup4_sub();
		appProperties.setup4_sub();
		guiSwing_Dimension.setup4_sub();
	}
	
	
	public void setup4_sub() {  }
	
	
	public PlatformOs get_PLATFORM_OS() { return PLATFORM_OS; }
	public char get_platform_slashType() { return platform_slashType; }

}
