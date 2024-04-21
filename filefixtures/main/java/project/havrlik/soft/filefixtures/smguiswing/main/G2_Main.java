package main.java.project.havrlik.soft.filefixtures.smguiswing.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.java.project.havrlik.soft.filefixtures.fc1_filelist.FilesInDirectories;
import main.java.project.havrlik.soft.filefixtures.fc2_audioplaylist.AudioPlaylistsCreator;
import main.java.project.havrlik.soft.filefixtures.fc4_filerename.FileRename;
import main.java.project.havrlik.soft.filefixtures.fc5_archivecommands.ArchiveCommands;
import main.java.project.havrlik.soft.filefixtures.smlib.SmLib;
import main.java.project.havrlik.soft.smguiswing.screen.main.G3_MenuBar;


public class G2_Main extends main.java.project.havrlik.soft.smguiswing.screen.main.G2_Main {
	
	private static final long serialVersionUID = 7643591618106388829L;
	
	protected SmLib smLib;
	
//	protected G3_MenuBar g3_MenuBar;
	protected G4_MainPanel g4_MainPanel;
	
	
	public G2_Main(SmLib smLib) {
		super(smLib);
		this.smLib = smLib;
		
		constructorContinues();
	}
	
	
	@Override
	protected void call_constructorContinues() {  }
	
	
	@Override
	protected void constructor4_sub() {
//		performMenuButtons_sub();
		perform_g4aHome_Buttons_sub();
	}
	
	
	@Override
	protected void initializeFeatures() {
		g3_MenuBar = new G3_MenuBar(smLib);
//		super.g3_MenuBar = g3_MenuBar;
		g4_MainPanel = new G4_MainPanel(smLib);
		super.g4_MainPanel = g4_MainPanel;
	}
	
	
	// Add tabbed panes.
	
	public void perform_g4aHome_Buttons_sub() {
		g4_MainPanel.g4a_Home.get_button1().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				f1();
			}
		});
		g4_MainPanel.g4a_Home.get_button2().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				f2();
			}
		});
//		g4_MainPanel.g4a_Home.get_button3().addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				f3();
//			}
//		});
		g4_MainPanel.g4a_Home.get_button4().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				f4();
			}
		});
		g4_MainPanel.g4a_Home.get_button5().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				f5();
			}
		});
	}
	
	
	public void f1() {
		showPanel_g4d_MainTabs();
		FilesInDirectories fc = new FilesInDirectories(smLib);
		g4_MainPanel.get_g4d_MainTabs().addNewTab(
				fc.return_gui().thisFunctionnalityName_short, 
				fc.return_gui().return_panel1());
	}
	
	
	public void f2() {
		showPanel_g4d_MainTabs();
		AudioPlaylistsCreator fc = new AudioPlaylistsCreator(smLib);
		g4_MainPanel.get_g4d_MainTabs().addNewTab(
				fc.return_gui().thisFunctionnalityName_short, 
				fc.return_gui().return_panel1());
	}
	
	
//	public void f3() {
//		showPanel_g4d_MainTabs();
//		FakeFileMagicNumber fc = new FakeFileMagicNumber(smLib);
//		g4_MainPanel.get_g4d_MainTabs().addNewTab(
//				fc.return_gui().thisFunctionnalityName_short, 
//				fc.return_gui().return_panel1());
//	}
	
	
	public void f4() {
		showPanel_g4d_MainTabs();
		FileRename fc = new FileRename(smLib);
		g4_MainPanel.get_g4d_MainTabs().addNewTab(
				fc.return_gui().thisFunctionnalityName_short, 
				fc.return_gui().return_panel1());
	}
	
	
	public void f5() {
		showPanel_g4d_MainTabs();
		ArchiveCommands fc = new ArchiveCommands(smLib);
		g4_MainPanel.get_g4d_MainTabs().addNewTab(
				fc.return_gui().thisFunctionnalityName_short, 
				fc.return_gui().return_panel1());
	}

}
