package main.java.project.havrlik.soft.smlib.introduction;

import java.awt.Dimension;

import main.java.project.havrlik.soft.smlib.SmLib;
import main.java.project.havrlik.soft.smlib.other.GuiFrameDimension;

public class Intoduction_GuiSwing_Dimension {
	
	protected SmLib smLib;
	
	protected GuiFrameDimension guiFrameDimension_origin = GuiFrameDimension.SIZE_1280x860;
	protected GuiFrameDimension guiFrameDimension = guiFrameDimension_origin;
	public int windowFrame_width;
	public int windowFrame_height;
	
	public int width_leftPadding;
	public int width_rightPadding;
	public int width_rightPaddingScrollBar;
	public int width_panelScrolling;
	public int width_content;
	public int width_rightEdge;
	public int height_topBars;
	public int height_panelScrolling;
	
	public Dimension dimensions_tabScreen = new Dimension(1270, 870);  // For 'SIZE_1280x860'.
	
	
	public Intoduction_GuiSwing_Dimension(SmLib smLib) {
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
	
	
	protected void constructor3() {
		setValues();
	}
	
	
	protected void constructor4_sub() {  }
	protected void constructor5() {  }
	protected void constructor6_sub() {  }
	
	
	public void setup1() {  }
	public void setup2_sub() {  }
	public void setup3() {  }
	public void setup4_sub() {  }
	
	
	protected void setValues() {
		guiFrameDimension = guiFrameDimension_origin;
		
		windowFrame_width = guiFrameDimension.getWidth();
		windowFrame_height = guiFrameDimension.getHeight();
		
		// Dimensions.
		width_leftPadding = 10;
		width_rightPadding = 10;
		width_rightPaddingScrollBar = 30;
		width_panelScrolling = windowFrame_width - width_rightPaddingScrollBar;
		width_content = width_panelScrolling - width_leftPadding - width_rightPadding;
		width_rightEdge = width_content + width_leftPadding;
		height_topBars = 100;
		height_panelScrolling = windowFrame_height - height_topBars;
		
		setValues_sub();
	}
	
	
	protected void setValues_sub() {  }
	
	
	public GuiFrameDimension get_guiFrameDimension() { return guiFrameDimension; }

}
