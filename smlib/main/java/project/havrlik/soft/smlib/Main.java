package main.java.project.havrlik.soft.smlib;

import javax.swing.SwingUtilities;

/**
 * Author: 'havrlik', created on 03.10.2017.
 * 
 * About author and project: Developed mostly with basic self-learned knowledges about programming.
 */


public abstract class Main {
	
//	protected SmLib smLib;
//	protected G0_Introduction g0_Introduction;
	
	
	protected Main() {
		setup();
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				setupGuiSwing();
				startupFunctions();
				playground();
			}
		});
	}
	
	
	protected abstract void setup();  // Here initialize your project.
//	{
//		smLib = new SmLib();
//	}
	
	
	protected abstract void setupGuiSwing();  // Here initialize your GUI.
//	{
//		g0_Introduction = new G0_Introduction(smLib);
//	}
	
	
	protected void startupFunctions() {
		// Developing space.
		
		// Open current work in progress.
	}
	
	
	protected void playground() {
	}

}
