package main.java.project.havrlik.soft.smlib.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

import main.java.project.havrlik.soft.smlib.SmLib;
import main.java.project.havrlik.soft.smlib.data.Data_StringSmList;
import main.java.project.havrlik.soft.smlib.data.Data_byte_SmList;
import main.java.project.havrlik.soft.smlib.data.Data_byte_array;
import main.java.project.havrlik.soft.smlib.data.ProcessResult;
import main.java.project.havrlik.soft.smlib.smlist.SmList_1D_byte;
import main.java.project.havrlik.soft.smlib.smlist.SmList_Size;
import main.java.project.havrlik.soft.smlib.smlist.SmList_Util;

public class FileIo_General extends FileIo_Super {
	
	
	public FileIo_General(SmLib smLib) {
		super(smLib);
	}
	
	
	// Read characters from file.
	
	Data_StringSmList read_smList1DString(Data_StringSmList data, SmList_Size useListSize) {
		if (!check_isSuccess(data)) { return data; }
		String fileDirectoryAndName = data.return_connectFileDirectoryAndName();
		if (!check_fileDirectoryAndName(data, fileDirectoryAndName)) { return data; }
		if (!check_existsFileInDirectory(data, fileDirectoryAndName)) { return data; }
		
		if (useListSize == null) {
			useListSize = SmList_Size.SMALL_512;
		}
		data.rowNumber_fileData = 0;
		data.rowNumber_fileOverall = 0;
		data.initContent(useListSize);
		
		try (BufferedReader br = new BufferedReader(new FileReader(fileDirectoryAndName))) {
			String readedLine;
			while ((readedLine = br.readLine()) != null) {
				data.rowNumber_fileData++;
				data.addRow(readedLine);
			}
		}
		catch (FileNotFoundException ex) {
			exception_N1Fatal(data, "File read.", ex);
			return data;
		}
		catch (IOException ex) {
			exception_N1Fatal(data, "File read.", ex);
			return data;
		}
		catch (Exception ex) {
			exception_N1Fatal(data, "File read.", ex);
			return data;
		}
		
		data.rowNumber_fileOverall += data.rowNumber_fileData;
		if (!check_numberRowsOfDataCompareSizeOfContent(data)) { return data; }

		return data;
	}
	
	
	Data_StringSmList read_smList1DString(Data_StringSmList data) {
		return read_smList1DString(data, null);
	}
	
	
	// Used 'FileInputStream' without 'try-with-resources'.
//	int read_String(String fileDirectory, String fileName) {
//		clearVariables();
//		int rowNumber_data;
//		SmList_1D_String smList1D_string;
//		String data_string = "";
//		
//		String fileDirectoryAndName = fileDirectoryAndNameCustomize.return_connectFileDirectoryAndName(fileDirectory, fileName);
//		if (fileDirectoryAndName == null) {
//			data.set_process_successful(ProcessSuccess.N2_ERROR);
//			data.add_processMessages(
//					this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName(), 
//					"received 'fileDirectoryAndName == null'.");
//			return data.get_process_successful_int();
//		}
//		else if (!fileDirectoryAndNameCustomize.is_existDirectoryOrFileInDirectory(fileDirectoryAndName)) {
//			data.set_process_successful(ProcessSuccess.N2_ERROR);
//			data.add_processMessages(
//					this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName(), 
//					"This file cannot read, because not exists:", 
//					fileDirectoryAndName);
//			return data.get_process_successful_int();
//		}
//		
//		rowNumber_data = 0;  // Means inserted rows, like size of list. Not last inserted row.
//		smList1D_string = new SmList_1D_String(SmList_Size.TINY_16);
//		data_string = "";
//		
//        try {
//    		FileInputStream stream;
//    		int prectenyZnak;
//    		try {
//    			stream = new FileInputStream(fileDirectoryAndName);
//    		}
//    		catch (FileNotFoundException ex) {
//    			messageReceiver.message(MessageType.N1_FATAL, 
//    					MessageList.assemblePlacement(this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName()), 
//    					"FileNotFoundException:  " + ex.toString());
//    			data.set_process_successful(ProcessSuccess.N1_FATAL);
//    			return data.get_process_successful_int();
//    		}
//            try {
//            	while ((prectenyZnak = stream.read()) != -1) {
//            		data_string += (char) prectenyZnak;
//                }
//            }
//    		catch (IOException ex) {
//    			messageReceiver.message(MessageType.N1_FATAL, 
//    					MessageList.assemblePlacement(this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName()), 
//    					"IOException read():  " + ex.toString());
//    			data.set_process_successful(ProcessSuccess.N1_FATAL);
//    			return data.get_process_successful_int();
//    		}
//            finally {
//                try {
//                	stream.close();
//                }
//        		catch (IOException ex) {
//        			messageReceiver.message(MessageType.N1_FATAL, 
//        					MessageList.assemblePlacement(this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName()), 
//        					"IOException close():  " + ex.toString());
//        			data.set_process_successful(ProcessSuccess.N1_FATAL);
//        			return data.get_process_successful_int();
//        		}
//            }
//        }
//		catch (Exception ex) {
//			messageReceiver.message(MessageType.N1_FATAL, 
//					MessageList.assemblePlacement(this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName()), 
//					"Exception:  " + ex.toString());
//			data.set_process_successful(ProcessSuccess.N1_FATAL);
//			return data.get_process_successful_int();
//		}
//        
//		rowNumber_data = 1;
//		data.set_process_successful(ProcessSuccess.O1_OK);
//		data.rowNumber_data = rowNumber_data;
//		smList1D_string.addValue(data_string);
//		data.smList1D_string = smList1D_string;
//		
//		return rowNumber_data;
//	}
	
	
	Data_StringSmList read_partOfFile_beginning_smList1DString(Data_StringSmList data, int readBeginningRows, SmList_Size useListSize) {
		if (!check_isSuccess(data)) { return data; }
		String fileDirectoryAndName = data.return_connectFileDirectoryAndName();
		if (!check_fileDirectoryAndName(data, fileDirectoryAndName)) { return data; }
		if (!check_existsFileInDirectory(data, fileDirectoryAndName)) { return data; }
		
		if (readBeginningRows < 1) {
			data.add_processMessages(
					ProcessResult.N2_ERROR, 
					this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName(), 
					"Issue: 'readbeginningRows < 1', readbeginningRows: '" + readBeginningRows + "'."
//					buildFileDirectoryAndNameForMessages(data)
			);
			return data;
		}
		
		if (useListSize == null) {
			useListSize = SmList_Util.return_recommendedSmListSizeName(readBeginningRows);
		}
		data.rowNumber_fileData = 0;
		data.rowNumber_fileOverall = 0;
		data.initContent(useListSize);
		
		try (BufferedReader br = new BufferedReader(new FileReader(fileDirectoryAndName))) {
			String readedLine;
			while (data.rowNumber_fileData < readBeginningRows && (readedLine = br.readLine()) != null) {
				data.rowNumber_fileData++;
				data.addRow(readedLine);
			}
		}
		catch (FileNotFoundException ex) {
			exception_N1Fatal(data, "File read.", ex);
			return data;
		}
		catch (IOException ex) {
			exception_N1Fatal(data, "File read.", ex);
			return data;
		}
		catch (Exception ex) {
			exception_N1Fatal(data, "File read.", ex);
			return data;
		}
		
		data.rowNumber_fileOverall += data.rowNumber_fileData;
		if (!check_numberRowsOfDataCompareSizeOfContent(data)) { return data; }

		return data;
	}
	
	
	Data_StringSmList read_partOfFile_beginning_smList1DString(Data_StringSmList data, int readBeginningRows) {
		return read_partOfFile_beginning_smList1DString(data, readBeginningRows, null);
	}
	
	
	Data_StringSmList read_partOfFile_end_smList1DString(Data_StringSmList data, int readLastBites, SmList_Size useListSize) {
		// If you want to read last line(s) in file with md, recommend is readLastBites = 1000.
		// First readed - usually incomplete line throw away.
		if (!check_isSuccess(data)) { return data; }
		String fileDirectoryAndName = data.return_connectFileDirectoryAndName();
		if (!check_fileDirectoryAndName(data, fileDirectoryAndName)) { return data; }
		if (!check_existsFileInDirectory(data, fileDirectoryAndName)) { return data; }
		
		if (readLastBites < 1) {
			data.add_processMessages(
					ProcessResult.N2_ERROR, 
					this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName(), 
					"Issue: 'readLastBites < 1', readLastBites: '" + readLastBites + "'."
//					buildFileDirectoryAndNameForMessages(data)
			);
			return data;
		}
		
		if (useListSize == null) {
			useListSize = SmList_Util.return_recommendedSmListSizeName(readLastBites);
		}
		data.rowNumber_fileData = 0;
		data.rowNumber_fileOverall = 0;
		data.initContent(useListSize);
		
//		File fi = new File(fileDirectoryAndName);
//		long fileLength = fi.length();
		long fileLength = fileDirectoryAndNameCustomize.return_fileSize(fileDirectoryAndName);
		long filePoiontToSeek = 0;
		if (fileLength > readLastBites) {
			filePoiontToSeek = fileLength - readLastBites;
		}
		
		try (RandomAccessFile raf = new RandomAccessFile(fileDirectoryAndName, "r")) {
			raf.seek(filePoiontToSeek);
			String readedLine = raf.readLine();  // Incomplete line, do not use.
			while ((readedLine = raf.readLine()) != null) {
				data.rowNumber_fileData++;
				data.addRow(readedLine);
			}
		}
		catch (FileNotFoundException ex) {
			exception_N1Fatal(data, "File read.", ex);
			return data;
		}
		catch (IOException ex) {
			exception_N1Fatal(data, "File read.", ex);
			return data;
		}
		catch (Exception ex) {
			exception_N1Fatal(data, "File read.", ex);
			return data;
		}
		
		data.rowNumber_fileOverall += data.rowNumber_fileData;
		if (!check_numberRowsOfDataCompareSizeOfContent(data)) { return data; }
		
		return data;
	}
	
	
	Data_StringSmList read_partOfFile_end_smList1DString(Data_StringSmList data, int readLastBites) {
		return read_partOfFile_end_smList1DString(data, readLastBites, null);
	}
	
	
	// Write characters to file.
	
	Data_StringSmList write_smList1DString(Data_StringSmList data) {
		/*
		 * Write lines from received data, using list 'SM_List_1D_String content'.
		 * Can be used for random data content.
		 * At the end of file is not added empty row (Linux). Recommended already added empty row to list.
		 */
		if (!check_isSuccess(data)) { return data; }
		String fileDirectoryAndName = data.return_connectFileDirectoryAndName();
		if (!check_fileDirectoryAndName(data, fileDirectoryAndName)) { return data; }
		if (!check_fileDirectoryAndNameCharacters(data)) { return data; }
		if (!check_notExistsFileInDirectory(data, fileDirectoryAndName)) { return data; }
		if (!check_contentExists(data)) { return data; }
		
		data.rowNumber_fileData = 0;
		data.rowNumber_fileOverall = 0;
		
		checkIfExistsFolderAndCreateIt(data);
//		String fileName2 = fileDirectoryAndNameCustomize.return_checkExistSameFileNameAndReturnDifferent(data.get_fileDirectory(), data.get_fileName());
//		fileDirectoryAndName = fileDirectoryAndNameCustomize.return_connectFileDirectoryAndName(data.get_fileDirectory(), fileName2);
//		if (!check_fileDirectoryAndName(data, fileDirectoryAndName)) { return data; }
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileDirectoryAndName))) {
			for (int i1 = 0; i1 < data.get_content().size(); i1++) {
				data.rowNumber_fileData++;
				bw.write(data.get_content().getValue(i1));
				bw.newLine();
			}
			bw.flush();
		}
		catch (IOException ex) {
			exception_N1Fatal(data, "Write to file.", ex);
			return data;
		}
		catch (Exception ex) {
			exception_N1Fatal(data, "Write to file.", ex);
			return data;
		}
		
		data.rowNumber_fileOverall += data.rowNumber_fileData;
		if (!check_numberRowsOfDataCompareSizeOfContent(data)) { return data; }
		
		return data;
	}
	
	
	// Read binary files.
	
	Data_byte_array read_smList1DByte(Data_byte_array data) {
		if (!check_isSuccess(data)) { return data; }
		String fileDirectoryAndName = data.return_connectFileDirectoryAndName();
		if (!check_fileDirectoryAndName(data, fileDirectoryAndName)) { return data; }
		if (!check_existsFileInDirectory(data, fileDirectoryAndName)) { return data; }
		
		data.rowNumber_fileData = 0;
		data.rowNumber_fileOverall = 0;
		data.dropContent();
		
		try (
				BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileDirectoryAndName));
		) {
			
//			// First version.
//			byte by;
//			while ((by = (byte) bis.read()) != -1) {
//				content.addValue(by);
//				rowNumber_data++;
//			}
			
			int fileSize = (int) new File(fileDirectoryAndName).length();
			data.initContent(fileSize);
			
			while (bis.read(data.get_content()) != -1);
			data.rowNumber_fileData = fileSize;
		}
		catch (FileNotFoundException ex) {
			exception_N1Fatal(data, "File read.", ex);
			return data;
		}
		catch (IOException ex) {
			exception_N1Fatal(data, "File read.", ex);
			return data;
		}
		catch (Exception ex) {
			exception_N1Fatal(data, "File read.", ex);
			return data;
		}
		
		data.rowNumber_fileOverall += data.rowNumber_fileData;
		if (!check_numberRowsOfDataCompareSizeOfContent(data)) { return data; }

		return data;
	}
	
	
	Data_byte_array read_partOfFile_beginning_smList1DByte(Data_byte_array data, int readBeginningBytes) {
		if (!check_isSuccess(data)) { return data; }
		String fileDirectoryAndName = data.return_connectFileDirectoryAndName();
		if (!check_fileDirectoryAndName(data, fileDirectoryAndName)) { return data; }
		if (!check_existsFileInDirectory(data, fileDirectoryAndName)) { return data; }
		
		if (readBeginningBytes < 1) {
			data.add_processMessages(
					ProcessResult.N2_ERROR, 
					this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName(), 
					"Issue: 'readBeginningBytes < 1', readBeginningBytes: '" + readBeginningBytes + "'."
//					buildFileDirectoryAndNameForMessages(data)
			);
			return data;
		}
		
		data.rowNumber_fileData = 0;
		data.rowNumber_fileOverall = 0;
		data.initContent(readBeginningBytes);
		
//		// First version.
//		try (
//				BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileDirectoryAndName));
//		) {
//			byte by;
//			while ((by = (byte) bis.read()) != -1) {
//				content.addValue(by);
//				rowNumber_data++;
//				
//				if (rowNumber_data >= readbeginningBytes) {
//					break;
//				}
//			}
//		}
		
		try (
				BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileDirectoryAndName));
		) {
			while (bis.read(data.get_content()) != -1);
			data.rowNumber_fileData = readBeginningBytes;
		}
		catch (FileNotFoundException ex) {
			exception_N1Fatal(data, "File read.", ex);
			return data;
		}
		catch (IOException ex) {
			exception_N1Fatal(data, "File read.", ex);
			return data;
		}
		catch (Exception ex) {
			exception_N1Fatal(data, "File read.", ex);
			return data;
		}
		
		data.rowNumber_fileOverall += data.rowNumber_fileData;
		if (!check_numberRowsOfDataCompareSizeOfContent(data)) { return data; }

		return data;
	}
	
	
	// Write binary files.
	
	Data_byte_SmList write_smList1DByte(Data_byte_SmList data) {
		if (!check_isSuccess(data)) { return data; }
		String fileDirectoryAndName = data.return_connectFileDirectoryAndName();
		if (!check_fileDirectoryAndName(data, fileDirectoryAndName)) { return data; }
		if (!check_fileDirectoryAndNameCharacters(data)) { return data; }
		if (!check_notExistsFileInDirectory(data, fileDirectoryAndName)) { return data; }
		if (!check_contentExists(data)) { return data; }
		
		data.rowNumber_fileData = 0;
		data.rowNumber_fileOverall = 0;
		
		checkIfExistsFolderAndCreateIt(data);
//		String fileName2 = fileDirectoryAndNameCustomize.return_checkExistSameFileNameAndReturnDifferent(data.get_fileDirectory(), data.get_fileName());
//		fileDirectoryAndName = fileDirectoryAndNameCustomize.return_connectFileDirectoryAndName(data.get_fileDirectory(), fileName2);
//		if (!check_fileDirectoryAndName(data, fileDirectoryAndName)) { return data; }
		
		try (
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileDirectoryAndName));
		) {
//			bos.write(byte);
			
			SmList_1D_byte content = data.get_content();
			
			// Write by a chunk of bytes.
			int chunkSize = 1024 * 4;
			int i1 = 0;
			byte[] chunk;
			for (; i1 + chunkSize < content.size(); i1 += chunkSize) {
				chunk = new byte[chunkSize];
				for (int i2 = 0; i2 < chunkSize; i2++) {
					chunk[i2] = content.getValue(i1 + i2);
					data.rowNumber_fileData++;
				}
				bos.write(chunk);
			}
			if (content.size() - i1 > 0) {
				chunk = new byte[content.size() - i1];
				int i3 = 0;
				for (; i1 < content.size(); i1++) {
					chunk[i3] = content.getValue(i1);
					i3++;
					data.rowNumber_fileData++;
				}
				bos.write(chunk);
			}
			
			bos.flush();
		}
		catch (IOException ex) {
			exception_N1Fatal(data, "Write to file.", ex);
			return data;
		}
		catch (Exception ex) {
			exception_N1Fatal(data, "Write to file.", ex);
			return data;
		}
		
		data.rowNumber_fileOverall += data.rowNumber_fileData;
		if (!check_numberRowsOfDataCompareSizeOfContent(data)) { return data; }
		
		return data;
	}

}
