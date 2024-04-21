package main.java.project.havrlik.soft.smguiswing.screen;

import java.awt.Font;
import java.util.Enumeration;

import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import main.java.project.havrlik.soft.smguiswing.screen.main.G1_MainFrame;
import main.java.project.havrlik.soft.smlib.SmLib;

/**
 * Author: 'Havrlik', created on 03.10.2017.
 * 
 * About author and project: Developed mostly with basic self-learned knowledges about programming.
 * 
 * For your simple applications with GUI you can use Java Swing, which is included in Java SE already, it is easy to use.
 * My approach tested on Linux and MS Windows. On Apple Mac OS do not look so fine.
 */


public abstract class G0_Introduction {
	
	protected SmLib smLib;
	
	protected G1_MainFrame g1_MainFrame;
	
	
	public G0_Introduction(SmLib smLib) {
		this.smLib = smLib;
		
		constructor1();
	}
	
	
	protected void constructorContinues() {  // Required(??) to be called from your subclass.
		constructor3();
		constructor4_sub();
	}
	
	
	protected void constructor1() {
		setGui();
	}
	
	
	protected void constructor3() {
		initializeFeatures();
	}
	
	
	protected void constructor4_sub() {  }
	
	
	protected void initializeFeatures() {
		g1_MainFrame = new G1_MainFrame(smLib);
	}
	
	
	public G1_MainFrame get_g1_MainFrame() { return g1_MainFrame; }
	
	
	protected void setGui() {
		setGuiFont(new FontUIResource("Arial", Font.PLAIN, 12));  // Set default font.
	}
	
	
	protected static void setGuiFont(FontUIResource f) {
		Enumeration<Object> keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get (key);
			if (value instanceof FontUIResource)
				UIManager.put (key, f);
		}
	}

}
