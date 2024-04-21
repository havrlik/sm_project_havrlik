package main.java.project.havrlik.soft.filefixtures;

import javax.swing.SwingUtilities;

import main.java.project.havrlik.soft.filefixtures.smguiswing.G0_Introduction;
import main.java.project.havrlik.soft.filefixtures.smlib.SmLib;

/**
 * Author: 'Havrlik', created on 11.12.2018.
 * 
 * About author and project: Developed mostly with basic self-learned knowledges about programming.
 */


public class Main_FileFixtures extends  main.java.project.havrlik.soft.smlib.Main {
	
	protected SmLib smLib;
	protected G0_Introduction g0_Introduction;
	
	
	protected Main_FileFixtures() {
		super();
	}
	
	
	@Override
	protected void setup() {  }
	
	
	@Override
	protected void setupGuiSwing() {
		smLib = new SmLib();
		
		g0_Introduction = new G0_Introduction(smLib);
	}


	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Main_FileFixtures();
			}
		});
	}

}
