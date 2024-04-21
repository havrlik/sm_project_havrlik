package main.java.project.havrlik.soft.smguiswing.screen.main;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;

import main.java.project.havrlik.soft.smlib.SmLib;
import main.java.project.havrlik.soft.smlib.message.MessageType;
import main.java.project.havrlik.soft.smlib.other.ValuePerform;

/*
 * From: http://www.java2s.com/Code/Java/Swing-JFC/ComprehensiveMenuDemo.htm
 */

public class G3_MenuBar extends JMenuBar {
	
	private static final long serialVersionUID = 5796373839017658356L;
	
	protected SmLib smLib;
	
	protected Color menuBar_colorBackground_default;
	protected JButton button1_home;
	protected JButton button2_info;
	protected JButton button3_messages;
	protected JButton button4_tabs;
	
	protected boolean isSelected_gui5Messages = false;
	protected int messageType_highestPriority;  // Lower integer means higher priority.
	
	
	public G3_MenuBar(SmLib smLib) {
		this.smLib = smLib;
		
		constructor1();
		
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
	
	
	protected void constructor1() {
		setDefault_messageType_highestPriority();
		
		menuBar_colorBackground_default = this.getBackground();
		
		addButtonsToBar();
	}
	
	
	protected void constructor3() {  }
	protected void constructor4_sub() {  }
	
	
	public void addButtonsToBar() {
		// Add buttons to menu bar.
		
		// Space.
		this.add(new JLabel("  "));
		// Tabs panel.
		button4_tabs = new JButton("Main Tabs");
		button4_tabs.setFocusPainted(false);
		button4_tabs.setMargin(new Insets(2, 16, 2, 16));
		button4_tabs.setBackground(return_buttonColor());
		button4_tabs.setMnemonic(KeyEvent.VK_T);
		this.add(button4_tabs);
		// Space.
		this.add(new JLabel("  "));
		// Event logs panel.
		button3_messages = new JButton("Events");
		button3_messages.setMargin(new Insets(2, 4, 2, 4));
		button3_messages.setBackground(return_buttonColor());
		button3_messages.setMnemonic(KeyEvent.VK_E);
		this.add(button3_messages);
		// Space.
		this.add(new JLabel("  "));
		// Info panel.
		button2_info = new JButton("Info");
		button2_info.setFocusPainted(false);
		button2_info.setMargin(new Insets(2, 4, 2, 4));
		button2_info.setBackground(return_buttonColor());
		button2_info.setMnemonic(KeyEvent.VK_I);
		this.add(button2_info);
		// Space.
		this.add(new JLabel("  "));
		// Home panel.
		button1_home = new JButton("Home");
		button1_home.setFocusPainted(false);
		button1_home.setMargin(new Insets(2, 4, 2, 4));
		button1_home.setBackground(return_buttonColor());
		button1_home.setMnemonic(KeyEvent.VK_H);
		this.add(button1_home);
		// Space.
		this.add(new JLabel("  "));
	}
	
	
	private void setButtonColor_allNoSelected() {
		button1_home.setBackground(return_buttonColor());
		button2_info.setBackground(return_buttonColor());
		if (!smLib.messageReceiver.get_isNewUnseenMessage()) {
			button3_messages.setBackground(return_buttonColor());
		}
		button4_tabs.setBackground(return_buttonColor());
	}
	
	
	public Color return_menuBarColorBackground_default() { return menuBar_colorBackground_default; }
	public Color return_buttonColor() { return new Color(225, 225, 225); }
	public Color return_buttonColor_active() { return new Color(200, 220, 250); }
	
	public Color return_buttonColor_0unknown() { return new Color(245, 245, 245); }
	public Color return_menuBarColorBackground_0unknown() { return new Color(250, 250, 250); }
	public Color return_buttonColor_1fatal() { return new Color(240, 160, 140); }
	public Color return_menuBarColorBackground_1fatal() { return new Color(250, 200, 180); }
	public Color return_buttonColor_2error() { return new Color(255, 233, 236); }  // (200, 180, 230)
	public Color return_menuBarColorBackground_2error() { return new Color(255, 241, 245); }  // (220, 200, 240)
	public Color return_buttonColor_3fail() { return new Color(170, 153, 189); }
	public Color return_menuBarColorBackground_3fail() { return new Color(189, 171, 211); }
	public Color return_buttonColor_4warn() { return new Color(225, 205, 246); }
	public Color return_menuBarColorBackground_4warn() { return new Color(230, 219, 247); }
	public Color return_buttonColor_11infoBlue() { return new Color(205, 220, 230); }
	public Color return_menuBarColorBackground_11infoBlue() { return new Color(210, 225, 240); }
	public Color return_buttonColor_21another() { return new Color(227, 195, 114); }
	public Color return_menuBarColorBackground_21another() { return new Color(235, 211, 114); }
	public Color return_buttonColor_91developerDebug() { return new Color(250, 200, 180); }
	public Color return_menuBarColorBackground_91developerDebug() { return new Color(210, 120, 110); }
	
	
	public void setButtonColor_selectButton1() {
		isSelected_gui5Messages = false;
		setButtonColor_allNoSelected();
		button1_home.setBackground(return_buttonColor_active());
	}
	
	
	public void setButtonColor_selectButton2() {
		isSelected_gui5Messages = false;
		setButtonColor_allNoSelected();
		button2_info.setBackground(return_buttonColor_active());
	}
	
	
	public void setButtonColor_selectButton3() {
		setButtonColor_allNoSelected();
		button3_messages.setBackground(return_buttonColor_active());
		isSelected_gui5Messages = true;
	}
	
	
	public void setButtonColor_selectButton4() {
		isSelected_gui5Messages = false;
		setButtonColor_allNoSelected();
		button4_tabs.setBackground(return_buttonColor_active());
	}
	
	
	public void setMenuBarBackgroundColor_default() {
		this.setBackground(return_menuBarColorBackground_default());
	}
	
	
	public void setButtonColor_button4_0unknown() {
		button3_messages.setBackground(return_buttonColor_0unknown());
		this.setBackground(return_menuBarColorBackground_0unknown());
	}
	
	
	public void setButtonColor_button4_1fatal() {
		button3_messages.setBackground(return_buttonColor_1fatal());
		this.setBackground(return_menuBarColorBackground_1fatal());
	}
	
	
	public void setButtonColor_button4_2error() {
		button3_messages.setBackground(return_buttonColor_2error());
		this.setBackground(return_menuBarColorBackground_2error());
	}
	
	
	public void setButtonColor_button4_3fail() {
		button3_messages.setBackground(return_buttonColor_3fail());
		this.setBackground(return_menuBarColorBackground_3fail());
	}
	
	
	public void setButtonColor_button4_4warn() {
		button3_messages.setBackground(return_buttonColor_4warn());
		this.setBackground(return_menuBarColorBackground_4warn());
	}
	
	
	public void setButtonColor_button4_11infoBlue() {
		button3_messages.setBackground(return_buttonColor_11infoBlue());
		this.setBackground(return_menuBarColorBackground_11infoBlue());
	}
	
	
	public void setButtonColor_button4_21another() {
		button3_messages.setBackground(return_buttonColor_21another());
		this.setBackground(return_menuBarColorBackground_21another());
	}
	
	
	public void setButtonColor_button4_91developerDebug() {
		button3_messages.setBackground(return_buttonColor_91developerDebug());
		this.setBackground(return_menuBarColorBackground_91developerDebug());
	}
	
	
	public void setButtonColor_button4_92developerFast() {
		button3_messages.setBackground(return_buttonColor_91developerDebug());
		this.setBackground(return_menuBarColorBackground_91developerDebug());
	}
	
	
	public void setButtonColor_button4_xxNoColor() {
	}
	
	
	public void gui5_tableRefreshed() {
		if (isSelected_gui5Messages) {
			setDefault_messageType_highestPriority();
			setButtonColor_selectButton3();
			setMenuBarBackgroundColor_default();
		}
	}
	
	
	public void setDefault_messageType_highestPriority() {
		messageType_highestPriority = ValuePerform.INT_highest;
	}
	
	
	public void setMenuBarBackgroundColor_alert(MessageType messageType) {
		// Lower integer means higher priority.
		if (messageType_highestPriority > messageType.get_priority()) {
			messageType_highestPriority = messageType.get_priority();
			
			switch (messageType) {
			case N0_UNKNOWN:
				setButtonColor_button4_0unknown();
				break;
			case N1_FATAL:
				setButtonColor_button4_1fatal();
				break;
			case N2_ERROR:
				setButtonColor_button4_2error();
				break;
			case N3_FAIL:
				setButtonColor_button4_3fail();
				break;
			case N4_WARN:
				setButtonColor_button4_4warn();
				break;
			case N11_INFO:
				setButtonColor_button4_11infoBlue();
				break;
			case N12_INFONOREFER:
				setButtonColor_button4_xxNoColor();
				break;
			case N13_APP:
				setButtonColor_button4_xxNoColor();
				break;
			case N14_USER:
				setButtonColor_button4_xxNoColor();
				break;
			case N21_ANOTHER:
				setButtonColor_button4_21another();
				break;
			case N91_DEVELOPER:
				setButtonColor_button4_91developerDebug();
				break;
			case N92_DEVELOPER_FAST:
				setButtonColor_button4_92developerFast();
				break;
				
			default:
				setButtonColor_button4_0unknown();
				break;
			}
		}
	}

}
