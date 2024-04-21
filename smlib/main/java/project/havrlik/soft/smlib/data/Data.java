package main.java.project.havrlik.soft.smlib.data;

import main.java.project.havrlik.soft.smlib.SmLib;
import main.java.project.havrlik.soft.smlib.message.MessageList;

public class Data {

	protected SmLib smLib;
	
	protected ProcessResult processResult;
	protected MessageList processMessages;
	
	private String fileName = null;
	private String fileDirectory = null;
	
	public int rowNumber_fileOverall = 0;  // Like size, (size = index + 1).
	public int rowNumber_fileData = 0;  // Like size, (size = index + 1). Related to content - main data.
	
	
	public Data(SmLib smLib) {
		this.smLib = smLib;
		
		processResult = ProcessResult.O1_OK;
		processMessages = new MessageList();
	}
	
	
	public void set_processResult(ProcessResult processResult) { this.processResult = processResult; }
	public void set_processResult_null() { this.processResult = ProcessResult.U0_NULL; }
	public void set_processResult_success() { this.processResult = ProcessResult.O1_OK; }
	
	
	public void set_fileName(String fileName) {
		if (this.fileName == null || !this.fileName.equals(fileName)) {
			add_processMessages(
					this.getClass().getName(), 
					"File name: '" + fileName + "'."
			);
		}
		
		this.fileName = fileName;
	}
	
	
	public void set_fileDirectory(String fileDirectory) {
		if (this.fileDirectory == null || !this.fileDirectory.equals(fileDirectory)) {
			add_processMessages(
					this.getClass().getName(), 
					"Directory: '" + fileDirectory + "'."
			);
		}
		
		this.fileDirectory = fileDirectory;
	}
	
	
	public ProcessResult get_ProcessResult() { return processResult; }
	public boolean isSuccess() { return processResult.get_isSuccess(); }
	public boolean isFailed() { return !processResult.get_isSuccess(); }
	public MessageList get_processMessages() { return processMessages; }  // Override when using objects registering own process_failMessages, add to this.
	public MessageList getAndClear_processMessages() {
		MessageList processMessages_temp = get_processMessages();
		processMessages = new MessageList();
		return processMessages_temp;
	}
	
	
	public String get_fileName() { return fileName; }
	public String get_fileDirectory() { return fileDirectory; }
	public String return_connectFileDirectoryAndName() {
		return smLib.fileDirectoryAndNameCustomize.return_connectFileDirectoryAndName(get_fileDirectory(), get_fileName());
	}
	
	
	public int sizeOfContent() { throw new RuntimeException("Can not use this method."); }  // Related to content - main data. To be override, if needed.
	
	
	protected void add_processMessages(String placement, String ... messages) {
		processMessages.add(placement, messages);
	}
	public void add_processMessages(Class<?> clazz, String methodName, String ... messages) {
		processMessages.add(clazz, methodName, messages);
	}
	public void add_processMessages(ProcessResult processResult, Class<?> clazz, String methodName, String ... messages) {
		set_processResult(processResult);
		processMessages.add(clazz, methodName, messages);
	}
	public void add_processMessages(ProcessResult processResult, MessageList processMessagesAdd, Class<?> clazz, String methodName, String ... messages) {
		set_processResult(processResult);
		processMessages.add(clazz, methodName, messages);
		processMessages.add_wholeBlock(processMessagesAdd);
	}
	public void add_processMessages(ProcessResult processResult, Data data_processMessages, Class<?> clazz, String methodName, String ... messages) {
		set_processResult(processResult);
		processMessages.add(clazz, methodName, messages);
		processMessages.add_wholeBlock(data_processMessages.getAndClear_processMessages());
	}

}
