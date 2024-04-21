package main.java.project.havrlik.soft.smlib.other;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import main.java.project.havrlik.soft.smlib.SmLib;
import main.java.project.havrlik.soft.smlib.message.MessageList;
import main.java.project.havrlik.soft.smlib.message.MessageType;

/**
 * variables:
 * https://www.baeldung.com/java-system-get-property-vs-system-getenv
 */


public class AppProperties {
	
	protected SmLib smLib;
	
	protected Properties properties_var = null;
	
	
	public AppProperties(SmLib smLib) {
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
	
	
	protected void constructor3() {}
	protected void constructor4_sub() {  }
	protected void constructor5() {  }
	protected void constructor6_sub() {  }
	
	
	public void setup1() {
		loadProperties_var();
	}
	
	
	public void setup2_sub() {  }
	public void setup3() {  }
	public void setup4_sub() {  }
	
	
	private void loadProperties_var() {
		properties_var = new Properties();
		
		try {
			FileInputStream fis = new FileInputStream(smLib.introduction.customValues.propertiesPath_var);
			properties_var.load(fis);
		}
		catch (FileNotFoundException ex) {
			smLib.messageReceiver.message(MessageType.N3_FAIL, 
					MessageList.assemblePlacement(this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName()), 
					"FileNotFoundException:  " + ex.toString()
			);
			properties_var = null;
			return;
		}
		catch (IOException ex) {
			smLib.messageReceiver.message(MessageType.N3_FAIL, 
					MessageList.assemblePlacement(this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName()), 
					"IOException:  " + ex.toString()
			);
			properties_var = null;
			return;
		}
	}
	
	
	// How to use:  String myValue = smLib.introduction.appProperties.get_properties_var().getProperty("<MY_KEY>");
	public Properties get_properties_var() {
		if (properties_var == null) {
			smLib.messageReceiver.message(MessageType.N3_FAIL, 
					MessageList.assemblePlacement(this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName()), 
					"Properties file 'properties_var' did not load."
			);
		}
		
		return properties_var;
	}
	
	public String get_properties_var_getProperty(String key) {
		return get_properties_var().getProperty(key);
	}

}
