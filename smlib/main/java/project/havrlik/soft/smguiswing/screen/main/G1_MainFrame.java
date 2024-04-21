package main.java.project.havrlik.soft.smguiswing.screen.main;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import main.java.project.havrlik.soft.smlib.SmLib;

public class G1_MainFrame extends JFrame {
	
	private static final long serialVersionUID = 7195975680189508492L;
	
	protected SmLib smLib;

	protected static String GuiAppFrame_name = "Essential application";
	protected static int[] GuiAppFrame_dimension = {1280, 960};
	protected int appFrame_setDefaultCloseOperation = JFrame.EXIT_ON_CLOSE;  // DO_NOTHING_ON_CLOSE ; EXIT_ON_CLOSE ; 
	
	protected G2_Main g2_Main;

	
	public G1_MainFrame(SmLib smLib) {
		super(GuiAppFrame_name);
		this.smLib = smLib;
		
		call_constructorContinues();
	}
	
	
	protected void call_constructorContinues() {
		// Recommended disable by overriding empty method and call 'constructorContinues()' at the end of your sub class.
		constructorContinues();
	}
	
	
	protected void constructorContinues() {
		constructor3();
		constructor4_sub();
	}
	
	
	protected void constructor3() {
		setFrameProperties();
		initializeFeatures();
		this.setVisible(true);
	}
	
	
	protected void constructor4_sub() {  }
	
	
	protected void setFrameProperties() {
		this.setTitle(GuiAppFrame_name);
		this.setSize(GuiAppFrame_dimension[0], GuiAppFrame_dimension[1]);
		this.setDefaultCloseOperation(appFrame_setDefaultCloseOperation);
	}
	
	
	protected void initializeFeatures() {
		g2_Main = new G2_Main(smLib);
		this.add(g2_Main);
	}
	
	
	protected void setExitBehavior() {
		// Click on exit behavior.
		this.addWindowListener((WindowListener) new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int i = JOptionPane.showConfirmDialog(null, "Exit application?", "Confirm exit application", JOptionPane.OK_CANCEL_OPTION);
				if (i == 0) {
					e.getWindow().dispose();
					//System.exit(0);
				}
			}
		});
	}

}
