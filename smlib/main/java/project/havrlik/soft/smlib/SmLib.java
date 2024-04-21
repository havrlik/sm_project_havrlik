package main.java.project.havrlik.soft.smlib;

import main.java.project.havrlik.soft.smlib.data.Data_Util;
import main.java.project.havrlik.soft.smlib.file.FileDialogSm;
import main.java.project.havrlik.soft.smlib.file.FileDirectoryAndNameCheck;
import main.java.project.havrlik.soft.smlib.file.FileDirectoryAndNameCustomize;
import main.java.project.havrlik.soft.smlib.file.FileIo_Gateway;
import main.java.project.havrlik.soft.smlib.file.FileListCustomize;
import main.java.project.havrlik.soft.smlib.introduction.Introduction;
import main.java.project.havrlik.soft.smlib.message.MessageList;
import main.java.project.havrlik.soft.smlib.message.MessageReceiver;
import main.java.project.havrlik.soft.smlib.message.MessageType;
import main.java.project.havrlik.soft.smlib.other.List;
import main.java.project.havrlik.soft.smlib.other.ListPerform;
import main.java.project.havrlik.soft.smlib.other.MarkLabelStringEtc;
import main.java.project.havrlik.soft.smlib.other.TimePerform;
import main.java.project.havrlik.soft.smlib.other.ValuePerform;

/**
 * Author: 'havrlik', created on 03.10.2017.
 * 
 * About author and project: Developed mostly with basic self-learned knowledges about programming.
 */


public class SmLib {
	
	public Introduction introduction;
	public ValuePerform valuePerform;
	public ListPerform listPerform;
	public MarkLabelStringEtc markLabelStringEtc;
	public Data_Util data_Util;
	public TimePerform timePerform;
	public List list;
	public MessageReceiver messageReceiver;
//	public Data_DataName data_DataName;
//	public Data_MetaData data_MetaData;
	public FileDirectoryAndNameCustomize fileDirectoryAndNameCustomize;
	public FileDirectoryAndNameCheck fileDirectoryAndNameCheck;
	public FileListCustomize fileListCustomize;
	public FileDialogSm fileDialogSm;
	public FileIo_Gateway fileIo;
	
//	public OptionMain optionMain;
	
	
	public SmLib() {
		
		call_constructorContinues();
		call_initializeFeatures();
		call_initializeCheck();
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
	
	
	protected void constructor3() {  }
	protected void constructor4_sub() {  }
	protected void constructor5() {  }
	protected void constructor6_sub() {  }
	
	
	protected void call_initializeFeatures() {
		// Recommended to disable this method by overriding by empty method in your sub class 
		// and call method bellow at the end of your constructor (2).
		initializeFeatures();
	}
	
	
	protected void initializeFeatures() {
		initFeat_introduction();
		initFeat();
		initFeat_sub();
		
		setup1();
		setup2_sub();
		setup3();
		setup4_sub();
	}
	
	
	protected void initFeat_introduction() {
		introduction = new Introduction(this);
	}
	
	
	protected void initFeat() {
		valuePerform = new ValuePerform(this);
		listPerform = new ListPerform(this);
		markLabelStringEtc = new MarkLabelStringEtc(this);
		data_Util = new Data_Util(this);
		timePerform = new TimePerform(this);
		list = new List(this);
		messageReceiver = new MessageReceiver(this);
		fileDirectoryAndNameCustomize = new FileDirectoryAndNameCustomize(this);
		fileDirectoryAndNameCheck = new FileDirectoryAndNameCheck(this);
		fileListCustomize = new FileListCustomize(this);
		fileDialogSm = new FileDialogSm(this);
		fileIo = new FileIo_Gateway(this);
		
//		optionsMain = new OptionsMain(this);
	}
	
	
	protected void initFeat_sub() {  }
	
	
	protected void setup1() {
		
		introduction.setup1();
		introduction.setup2_sub();
		valuePerform.setup1();
		valuePerform.setup2_sub();
		listPerform.setup1();
		listPerform.setup2_sub();
		markLabelStringEtc.setup1();
		markLabelStringEtc.setup2_sub();
		data_Util.setup1();
		data_Util.setup2_sub();
		timePerform.setup1();
		timePerform.setup2_sub();
		list.setup1();
		list.setup2_sub();
		messageReceiver.setup1();
		messageReceiver.setup2_sub();
		fileDirectoryAndNameCustomize.setup1();
		fileDirectoryAndNameCustomize.setup2_sub();
		fileDirectoryAndNameCheck.setup1();
		fileDirectoryAndNameCheck.setup2_sub();
		fileListCustomize.setup1();
		fileListCustomize.setup2_sub();
		fileDialogSm.setup1();
		fileDialogSm.setup2_sub();
		fileIo.setup1();
		fileIo.setup2_sub();
	}
	
	
	protected void setup2_sub() {  }
	
	
	protected void setup3() {
		
		introduction.setup3();
		introduction.setup4_sub();
//		valuePerform.setup3();
//		valuePerform.setup4_sub();
//		listPerform.setup3();
//		listPerform.setup4_sub();
//		markLabelStringEtc.setup3();
//		markLabelStringEtc.setup4_sub();
//		data_Util.setup3();
//		data_Util.setup4_sub();
//		timePerform.setup3();
//		timePerform.setup4_sub();
//		list.setup3();
//		list.setup4_sub();
//		messageReceiver.setup3();
//		messageReceiver.setup4_sub();
//		fileDirectoryAndNameCustomize.setup3();
//		fileDirectoryAndNameCustomize.setup4_sub();
//		fileListCustomize.setup3();
//		fileListCustomize.setup4_sub();
//		fileDialogSm.setup3();
//		fileDialogSm.setup4_sub();
//		fileIo.setup3();
//		fileIo.setup4_sub();
	}
	
	
	protected void setup4_sub() {  }
	
	
	protected void call_initializeCheck() {
		// Recommended to disable this method by overriding by empty method in your sub class 
		// and call method bellow at the end of your constructor (3).
		initializeCheck();
	}
	
	
	protected void initializeCheck() {
		initCheck();
		initCheck_sub();
	}
	
	
	protected void initCheck() {
		if (introduction.get_PLATFORM_OS() == null) {
			messageReceiver.message(MessageType.N1_FATAL, 
					MessageList.assemblePlacement(this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName()), 
					"Application '" + introduction.customValues.application_name + "' error message: " + 
							"Please set your platform and slash type at your class which inherits '" + 
							Introduction.class.getClass().getName() + "'. Or missing implementation.");
		}
		
		messageReceiver.message(MessageType.N13_APP, 
				"Application '" + 
				introduction.customValues.application_name + 
				"' version '" + introduction.customValues.application_version + 
				"' start up.");
	}
	
	
	protected void initCheck_sub() {  }

}
