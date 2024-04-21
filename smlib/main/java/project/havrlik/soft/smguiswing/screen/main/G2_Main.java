package main.java.project.havrlik.soft.smguiswing.screen.main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import main.java.project.havrlik.soft.smguiswing.listener.MessagesListener_Interface;
import main.java.project.havrlik.soft.smguiswing.listener.MessagesListener_coloring_Interface;
import main.java.project.havrlik.soft.smlib.SmLib;
import main.java.project.havrlik.soft.smlib.message.MessageReceiver;

public class G2_Main extends JPanel {
	
	private static final long serialVersionUID = -7747789536204261182L;
	
	protected SmLib smLib;
	protected MessageReceiver messageReceiver;
	
//	protected GUI8_Options gui8_Options;
	
	protected G3_MenuBar g3_MenuBar;
	protected G4_MainPanel g4_MainPanel;
	
	
	public G2_Main(SmLib smLib) {
		this.smLib = smLib;
		messageReceiver = smLib.messageReceiver;
		
		call_constructorContinues();
	}
	
	
	protected void call_constructorContinues() {
		// Recommended disable by overriding empty method and call 'constructorContinues()' at the end of your sub class.
		constructorContinues();
	}
	
	
	protected void constructorContinues() {
		constructor3();
		constructor4_sub();
		constructor5();
		constructor6_sub();
	}
	
	
	protected void constructor3() {
		messageReceiver.addListener(new MessagesListener_Interface() {
			@Override
			public void messageEvent() {
				// Event to color menu bar to alert colors (red, blue, ...).
				messageReceiver_menuBarColor_alert();
			}
		});
		
		initializeFeatures();
		actions_menuBar_MainButtons();
		perform_g4aHome_Buttons();
		
		
		this.setLayout(new BorderLayout());
		
		g4_MainPanel.g4c_Messages.addListener(new MessagesListener_coloring_Interface() {
			@Override
			public void coloringEvent() {
				// Event to color menu bar to default colors.
				gui5_Messages_menuBarColor_tableRefreshed();
			}
		});
		
		this.add(g3_MenuBar, BorderLayout.PAGE_START);
		this.add(g4_MainPanel, BorderLayout.CENTER);
	}
	
	
	protected void constructor4_sub() {  }
	
	
	protected void constructor5() {
		showOnStartup();
	}
	
	
	protected void constructor6_sub() {  }
	
	
	protected void initializeFeatures() {
//		gui8_Options = new GUI8_Options_Super(conditionMain);
		
		g3_MenuBar = new G3_MenuBar(smLib);
		g4_MainPanel = new G4_MainPanel(smLib);
	}
	
	
	protected void actions_menuBar_MainButtons() {
		// GUI1c_MenuBar (Menu bar):
		// Menu bar - buttons:
		g3_MenuBar.button1_home.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				showPanel_g4a_Home();
			}
		});
		g3_MenuBar.button2_info.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				showPanel_g4b_Info();
			}
		});
		g3_MenuBar.button3_messages.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {  }
			@Override
			public void mousePressed(MouseEvent e) {
				showPanel_g4c_Messages();
			}
			@Override
			public void mouseReleased(MouseEvent e) {  }
			@Override
			public void mouseEntered(MouseEvent e) {  }
			@Override
			public void mouseExited(MouseEvent e) {  }
		});
		g3_MenuBar.button3_messages.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {  }
			@Override
			public void mousePressed(MouseEvent e) {  }
			@Override
			public void mouseReleased(MouseEvent e) {
				g4_MainPanel.g4c_Messages.scrollTable_scrollDown();
			}
			@Override
			public void mouseEntered(MouseEvent e) {  }
			@Override
			public void mouseExited(MouseEvent e) {  }
		});
		g3_MenuBar.button4_tabs.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				showPanel_g4d_MainTabs();
			}
		});
	}
	
	
	public void perform_g4aHome_Buttons() {
		g4_MainPanel.g4a_Home.button0_toTabs.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				showPanel_g4d_MainTabs();
			}
		});
	}
	
	
	// Switch panels.
	
	public void gui5_Messages_menuBarColor_tableRefreshed() {
		g3_MenuBar.gui5_tableRefreshed();
	}
	
	
	public void showPanel_g4a_Home() {
		g4_MainPanel.showPanel_g4a_Home();
		g3_MenuBar.setButtonColor_selectButton1();
	}
	
	
	public void showPanel_g4b_Info() {
		g4_MainPanel.showPanel_g4b_Info();
		g3_MenuBar.setButtonColor_selectButton2();
	}
	
	
	public void showPanel_g4c_Messages() {
		g4_MainPanel.showPanel_g4c_Messages();
		g3_MenuBar.setButtonColor_selectButton3();
		g4_MainPanel.g4c_Messages.refreshTable();
	}
	
	
	public void showPanel_g4d_MainTabs() {
		g4_MainPanel.showPanel_g4d_MainTabs();
		g3_MenuBar.setButtonColor_selectButton4();
	}
	
	
	public void messageReceiver_menuBarColor_alert() {
		g3_MenuBar.setMenuBarBackgroundColor_alert(messageReceiver.return_messageType());
	}
	
	
	// Others.
	
	protected void showOnStartup() {
		showPanel_g4a_Home();  // Show this panel on startup.
	}
	
}
