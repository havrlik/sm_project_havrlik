package main.java.project.havrlik.soft.smlib;

import main.java.project.havrlik.soft.smlib.message.MessageList;
import main.java.project.havrlik.soft.smlib.message.MessageType;

public class Playground {
	
	SmLib smLib;
	
	
	public Playground(SmLib smLib) {
		this.smLib = smLib;
	}
	
	
	public void setup1() {
		notifyMe();
		setup2_sub();
	}
	
	
	protected void setup2_sub() {
		// To be override.
		foo1();
	}
	
	
	protected void notifyMe() {
		smLib.messageReceiver.message(MessageType.N21_ANOTHER, 
				MessageList.assemblePlacement(
						this.getClass(), MessageList.CONSTRUCTOR), 
				"Playground initialized.");
	}
	
	
	public void foo1() {
		try {
		}
		catch (Exception e1) {
			return;
		}
	}

}
