package main.java.project.havrlik.soft.smlib.file;

import main.java.project.havrlik.soft.smlib.SmLib;
import main.java.project.havrlik.soft.smlib.data.Data;
import main.java.project.havrlik.soft.smlib.data.ProcessResult;
import main.java.project.havrlik.soft.smlib.message.MessageReceiver;
import main.java.project.havrlik.soft.smlib.message.MessageType;
import main.java.project.havrlik.soft.smlib.other.ValuePerform;

public abstract class FileIo_Super {
	
	protected SmLib smLib;
	protected ValuePerform valuePerform;
	protected MessageReceiver messageReceiver;
	protected FileIo_Gateway fileIo;
	protected FileDirectoryAndNameCustomize fileDirectoryAndNameCustomize;
	
	
	protected FileIo_Super(SmLib smLib) {
		this.smLib = smLib;
		valuePerform = smLib.valuePerform;
		messageReceiver = smLib.messageReceiver;
		fileIo = smLib.fileIo;
		fileDirectoryAndNameCustomize = smLib.fileDirectoryAndNameCustomize;
	}
	
	
	/**
	 * Check of data.
	 * @return 'false' meams an issue.
	 */
	
//	protected String buildFileDirectoryAndNameForMessages(Data data) {
//		return "File: '" + data.get_fileDirectory() + "  " + data.get_fileName() + "'.";
//	}
	
	
	protected boolean check_isSuccess(Data data) {
		if (data.isFailed()) {
			data.add_processMessages(
					ProcessResult.N2_ERROR, 
					this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName(), 
					"Issue: 'data.isFailed()', result: '" + data.get_ProcessResult().name() + "'."
//					buildFileDirectoryAndNameForMessages(data)
			);
			return false;
		}
		
		return true;
	}
	
	
	protected boolean check_fileDirectoryAndName(Data data, String fileDirectoryAndName) {
		if (fileDirectoryAndName == null) {
			data.add_processMessages(
					ProcessResult.N2_ERROR, 
					this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName(), 
					"Issue: 'fileDirectoryAndName == null'."
//					buildFileDirectoryAndNameForMessages(data)
			);
			return false;
		}
		
		return true;
	}
	
	
	protected boolean check_existsFileInDirectory(Data data, String fileDirectoryAndName) {
		// Check for file read.
		if (!fileDirectoryAndNameCustomize.is_existDirectoryOrFileInDirectory(fileDirectoryAndName)) {
			data.add_processMessages(
					ProcessResult.N3_FAIL, 
					this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName(), 
					"Issue: '!fileDirectoryAndNameCustomize.is_existDirectoryOrFileInDirectory(fileDirectoryAndName)'."
//					buildFileDirectoryAndNameForMessages(data)
			);
			return false;
		}
		
		return true;
	}
	
	
	protected boolean check_notExistsFileInDirectory(Data data, String fileDirectoryAndName) {
		// Check for file write.
		if (fileDirectoryAndNameCustomize.is_existDirectoryOrFileInDirectory(fileDirectoryAndName)) {
			data.add_processMessages(
					ProcessResult.N3_FAIL, 
					this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName(), 
					"Issue: 'fileDirectoryAndNameCustomize.is_existDirectoryOrFileInDirectory(fileDirectoryAndName)'."
//					buildFileDirectoryAndNameForMessages(data)
			);
			return false;
		}
		
		return true;
	}
	
	
	protected boolean check_fileDirectoryAndNameCharacters(Data data) {
		String message = null;
		message = smLib.fileDirectoryAndNameCheck.check_directory(data.get_fileDirectory());
		if (message != null) {
			data.add_processMessages(
					ProcessResult.N3_FAIL, 
					this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName(), 
					"Issue - file name/directory characters: '" + message + "'"
//					buildFileDirectoryAndNameForMessages(data)
			);
			return false;
		}
		message = smLib.fileDirectoryAndNameCheck.check_directory_pattern(data.get_fileDirectory());
		if (message != null) {
			data.add_processMessages(
					ProcessResult.N3_FAIL, 
					this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName(), 
					"Issue - file name/directory characters: '" + message + "'"
//					buildFileDirectoryAndNameForMessages(data)
			);
			return false;
		}
		message = smLib.fileDirectoryAndNameCheck.check_filename(data.get_fileName());
		if (message != null) {
			data.add_processMessages(
					ProcessResult.N3_FAIL, 
					this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName(), 
					"Issue - file name/directory characters: '" + message + "'"
//					buildFileDirectoryAndNameForMessages(data)
			);
			return false;
		}
		message = smLib.fileDirectoryAndNameCheck.check_filename_pattern(data.get_fileName());
		if (message != null) {
			data.add_processMessages(
					ProcessResult.N3_FAIL, 
					this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName(), 
					"Issue - file name/directory characters: '" + message + "'"
//					buildFileDirectoryAndNameForMessages(data)
			);
			return false;
		}
		
		return true;
	}
	
	
	protected void checkIfExistsFolderAndCreateIt(Data data) {
		fileDirectoryAndNameCustomize.checkIfExistsFolderAndCreateIt(data.get_fileDirectory());
	}
	
	
	protected boolean check_contentExists(Data data) {
		if (data.sizeOfContent() < 1) {
			data.add_processMessages(
					ProcessResult.N2_ERROR, 
					this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName(), 
					"Issue: 'data.sizeOfContent() < 1': '" + data.sizeOfContent() + "'."
//					buildFileDirectoryAndNameForMessages(data)
			);
			return false;
		}
		
		return true;
	}
	
	
	protected void exception_N1Fatal(Data data, String processDescription, Exception ex) {
		data.add_processMessages(
				ProcessResult.N1_FATAL, 
				this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName(), 
//				buildFileDirectoryAndNameForMessages(data), 
				processDescription, 
				"Rows done: data '" + data.rowNumber_fileData + "', overall '" + data.rowNumber_fileOverall + "'.", 
				"'" + ex.toString() + "'."
		);
		messageReceiver.message(
				MessageType.N1_FATAL, 
				data.getAndClear_processMessages()
		);
	}
	
	
	protected void exception_N2Error(Data data, String processDescription, Exception ex) {
		data.add_processMessages(
				ProcessResult.N2_ERROR, 
				this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName(), 
//				buildFileDirectoryAndNameForMessages(data), 
				processDescription, 
				"Rows done: data '" + data.rowNumber_fileData + "', overall '" + data.rowNumber_fileOverall + "'.", 
				"'" + ex.toString() + "'."
		);
		messageReceiver.message(
				MessageType.N2_ERROR, 
				data.getAndClear_processMessages()
		);
	}
	
	
	protected boolean check_numberRowsOfDataCompareSizeOfContent(Data data) {
		if (data.sizeOfContent() < 1 || data.sizeOfContent() != data.rowNumber_fileData) {
			data.add_processMessages(
					ProcessResult.N2_ERROR, 
					this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName(), 
					"Issue: 'data.rowNumber_fileData < 1 || data.sizeOfContent() != data.rowNumber_fileData'."
//					buildFileDirectoryAndNameForMessages(data)
			);
			return false;
		}
		
		return true;
	}

}
