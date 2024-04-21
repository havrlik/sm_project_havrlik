package main.java.project.havrlik.soft.smlib.file;

import main.java.project.havrlik.soft.smlib.SmLib;
import main.java.project.havrlik.soft.smlib.data.Data_StringSmList;
import main.java.project.havrlik.soft.smlib.data.Data_byte_SmList;
import main.java.project.havrlik.soft.smlib.data.Data_byte_array;
import main.java.project.havrlik.soft.smlib.message.MessageReceiver;
import main.java.project.havrlik.soft.smlib.other.ListPerform;
import main.java.project.havrlik.soft.smlib.other.ValuePerform;
import main.java.project.havrlik.soft.smlib.smlist.SmList_Size;

public class FileIo_Gateway {
	
	protected SmLib smLib;
	protected ValuePerform valuePerform;
	protected ListPerform listPerform;
	protected MessageReceiver messageReceiver;
	protected FileDirectoryAndNameCustomize fileDirectoryAndNameCustomize;
	
	public FileIo_General fileReaderAndWriter_General;
	
	
	public FileIo_Gateway(SmLib smLib) {
		this.smLib = smLib;
		valuePerform = smLib.valuePerform;
		listPerform = smLib.listPerform;
		messageReceiver = smLib.messageReceiver;
		fileDirectoryAndNameCustomize = smLib.fileDirectoryAndNameCustomize;
		
		call_constructorContinues();
		call_initializeFeatures();
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
		initFeat();
		initFeat_sub();
	}
	
	
	protected void initFeat() {
		fileReaderAndWriter_General = new FileIo_General(smLib);
	}
	
	
	protected void initFeat_sub() {  }
	
	
	public void setup1() {  }
	public void setup2_sub() {  }
	public void setup3() {  }
	public void setup4_sub() {  }
	
	
	// FileReaderAndWriter_General.
	public Data_StringSmList read_smList1DString(Data_StringSmList data, SmList_Size useListSize) {
		return fileReaderAndWriter_General.read_smList1DString(data, useListSize);
	}
	public Data_StringSmList read_smList1DString(Data_StringSmList data) {
		return fileReaderAndWriter_General.read_smList1DString(data);
	}
	public Data_StringSmList read_partOfFile_beginning_smList1DString(Data_StringSmList data, int readBeginningRows, SmList_Size useListSize) {
		return fileReaderAndWriter_General.read_partOfFile_beginning_smList1DString(data, readBeginningRows, useListSize);
	}
	public Data_StringSmList read_partOfFile_beginning_smList1DString(Data_StringSmList data, int readBeginningRows) {
		return fileReaderAndWriter_General.read_partOfFile_beginning_smList1DString(data, readBeginningRows);
	}
	public Data_StringSmList read_partOfFile_end_smList1DString(Data_StringSmList data, int readLastBites, SmList_Size useListSize) {
		return fileReaderAndWriter_General.read_partOfFile_end_smList1DString(data, readLastBites, useListSize);
	}
	public Data_StringSmList read_partOfFile_end_smList1DString(Data_StringSmList data, int readLastBites) {
		return fileReaderAndWriter_General.read_partOfFile_end_smList1DString(data, readLastBites);
	}
	public Data_StringSmList write_smList1DString(Data_StringSmList data) {
		return fileReaderAndWriter_General.write_smList1DString(data);
	}
	
	public Data_byte_array read_smList1DByte(Data_byte_array data) {
		return fileReaderAndWriter_General.read_smList1DByte(data);
	}
	public Data_byte_array read_partOfFile_beginning_smList1DByte(Data_byte_array data, int readbeginningRows) {
		return fileReaderAndWriter_General.read_partOfFile_beginning_smList1DByte(data, readbeginningRows);
	}
	public Data_byte_SmList write_smList1DByte(Data_byte_SmList data) {
		return fileReaderAndWriter_General.write_smList1DByte(data);
	}

}
