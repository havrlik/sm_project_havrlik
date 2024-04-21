package main.java.project.havrlik.soft.filefixtures.fc1_filelist;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.java.project.havrlik.soft.filefixtures.smlib.SmLib;
import main.java.project.havrlik.soft.smlib.data.Data_StringSmList;
import main.java.project.havrlik.soft.smlib.data.ProcessResult;
import main.java.project.havrlik.soft.smlib.file.DirectoriesAndFiles;
import main.java.project.havrlik.soft.smlib.file.DirectoriesAndFiles_Unit;
import main.java.project.havrlik.soft.smlib.message.MessageList;
import main.java.project.havrlik.soft.smlib.message.MessageType;
import main.java.project.havrlik.soft.smlib.other.MarkLabelStringEtc;
import main.java.project.havrlik.soft.smlib.smlist.SmList_1D_String;
import main.java.project.havrlik.soft.smlib.smlist.SmList_Size;

/**
 * Created by 'Havrlik on 2018'.
 * 
 * Application ask for target directory, then load file names and directories inside. The result will save to new text file.
 * 
 * In the new text file are writed desctiptions, then all directories, 
 * and finally in separated paragraphs for each directory are his full path, folders inside and file names inside, optionally with file sizes.
 * List includes also empty directories.
 */


public class FilesInDirectories {
	
	private SmLib smLib;
	
	private FilesInDirectories_Gui gui;
	
	private final int RECURSIONDEPTH = 50;
	private String fileNameExtension;
	
	private DirectoriesAndFiles targetDirectory;
	private DirectoriesAndFiles list_files_fetchedData;
	private SmList_1D_String list_files_resultData;
	private DirectoriesAndFiles savePath;
	
	
	public FilesInDirectories(SmLib smLib) {
		this.smLib = smLib;
		
		gui = new FilesInDirectories_Gui(smLib);
		clearVariables();
		fileNameExtension = MarkLabelStringEtc.FILENAMEEXTENSION_dotTxt;
		targetDirectory = null;
		list_files_fetchedData = null;
		list_files_resultData = null;
		savePath = null;
		
		gui.label_state.setText("You can start.");
		gui.label_details.setText(
				"Preset operating system: '" + smLib.introduction.get_PLATFORM_OS().name() + "'. " + 
				"Maximal folders depth: '" + Integer.toString(RECURSIONDEPTH) + "'. ");
		gui.button2.setEnabled(false);
		
		gui.button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				button1_selectDirectory();
			}
		});
		gui.button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				button2_fetchNames();
			}
		});
		gui.button4_checkFilenames.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				button4_check();
			}
		});
		gui.button4_checkFilenames_pattern.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				button4_checkFilenames_pattern();
			}
		});
		gui.button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				button3_saveToFile();
			}
		});
	}
	
	
	public FilesInDirectories_Gui return_gui() { return gui; }
	
	
	private void clearVariables() {
		targetDirectory = null;
		list_files_fetchedData = null;
		list_files_resultData = null;
		savePath = null;
		
		gui.label_resuldSavedToDirectory.setText("-");
		gui.textField1.setText("");
		gui.button4_checkFilenames.setEnabled(false);
		gui.button4_checkFilenames_pattern.setEnabled(false);
		gui.button3.setEnabled(false);
	}
	
	
	private void button1_selectDirectory() {
		try {
			DirectoriesAndFiles targetDirectory_temp = smLib.fileDialogSm.fileChooser_chooseDirectory(null);
			if (targetDirectory_temp == null || targetDirectory_temp.isEmpty()) {
				return;
			}
			
			clearVariables();
			targetDirectory = targetDirectory_temp;
			
			gui.label_targetDirectory.setText(targetDirectory.getSingle_directory());
			gui.label_state.setText("Target directory is selected now [1)].");
			gui.button2.setEnabled(true);
		}
		catch (Exception ex) {
			gui.label_state.setText("Exception during '1)'. See app events.");
			smLib.messageReceiver.message(
					MessageType.N1_FATAL, 
					MessageList.assemblePlacement(this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName()), 
					"Exception:  " + ex.toString()
			);
			ex.printStackTrace();
		}
	}
	
	
	private void button2_fetchNames() {
		try {
			if ((targetDirectory == null || targetDirectory.isEmpty()) || list_files_fetchedData != null) {
				gui.label_state.setText("Before '2)' you need to start with '1)'.");
				return;
			}
			
			list_files_fetchedData = smLib.fileDialogSm.return_allFilesInsideThisAndLowerDirectories(
					targetDirectory.getSingle_directory(), true, null, RECURSIONDEPTH, true);
			gui.label_state.setText(
					"All names readed to the application [2)]. This is '" + list_files_fetchedData.size() + "' directories."
			);
			
			if (smLib.fileDialogSm.get_recursionAllowedDepthExceeded()) {
				gui.label_state.setText(gui.label_state.getText() + "    	WARNING: directories depth exceeded !!!");
				smLib.messageReceiver.message(
						MessageType.N3_FAIL, 
						MessageList.assemblePlacement(this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName()), 
						"Directories depth exceeded, during target directory '" + targetDirectory.getSingle_directory() + "'."
				);
			}
			smLib.fileDialogSm.setDefault_recursionAllowedDepthExceeded();
			
			if (gui.checkBox1.isSelected()) {
				smLib.fileDirectoryAndNameCustomize.return_fileSize(list_files_fetchedData);
			}
			
			gui.button4_checkFilenames.setEnabled(true);
			gui.button4_checkFilenames_pattern.setEnabled(true);
			gui.button3.setEnabled(true);
			
			
			// Debug, print to console.
//			printToConsole();
		}
		catch (Exception ex) {
			gui.label_state.setText("Exception during '2)'. See app events.");
			smLib.messageReceiver.message(
					MessageType.N1_FATAL, 
					MessageList.assemblePlacement(this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName()), 
					"Exception:  " + ex.toString()
			);
			ex.printStackTrace();
		}
	}
	
	
	protected void printToConsole() {  // private access modifier.
		System.out.println("---- FilesInDirectories list begin.");
		
		DirectoriesAndFiles_Unit directoryUnit;
		for (int i1 = 0; i1 < list_files_fetchedData.size(); i1++) {
			System.out.println();
			
			directoryUnit = list_files_fetchedData.get_directoryUnit(i1);
			
			System.out.println(directoryUnit.directory);
			
			if (directoryUnit.folders != null) {
				for (int i2 = 0; i2 < directoryUnit.folders.size(); i2++) {
					System.out.println(directoryUnit.folders.getValue(i2));
				}
			}
			
			if (directoryUnit.files != null) {
				for (int i2 = 0; i2 < directoryUnit.files.size(); i2++) {
					System.out.println(directoryUnit.getFile(i2));
					long fileSize = directoryUnit.getFileSize(i2);
					if (fileSize != 0) {
						System.out.println(fileSizeFormat(fileSize));
					}
				}
			}
			
		}
		System.out.println();
		System.out.println("---- FilesInDirectories list end.");
		System.out.println();
	}
	
	
	private void button4_check() {
		try {
			if (targetDirectory == null || targetDirectory.size() == 0) {
				gui.label_state.setText("Before '3)' you need to start with '1)'.");
				return;
			}
			else if ((list_files_fetchedData == null || list_files_fetchedData.size() == 0)) {
				gui.label_state.setText("Before '3)' you need to continue with '2)'.");
				return;
			}
			
			String message = null;
			boolean someIssue = false;
			
			message = smLib.fileDirectoryAndNameCheck.check_directory(list_files_fetchedData.get_directoryUnit(0).directory);
			if (message != null) {
				someIssue = true;
				smLib.messageReceiver.message(
						MessageType.N4_WARN, 
						"File list: name check - 'directoy' found:", 
						"'" + list_files_fetchedData.get_directoryUnit(0).directory + "'", 
						"Issue: '" + message + "'"
				);
			}
			
			for (int i1 = 0; i1 < list_files_fetchedData.size(); i1++) {
				DirectoriesAndFiles_Unit directoryUnit = list_files_fetchedData.get_directoryUnit(i1);
				
				if (directoryUnit.folders != null) {
					for (int j1 = 0; j1 < directoryUnit.folders.size(); j1++) {
						message = smLib.fileDirectoryAndNameCheck.check_filename(directoryUnit.getFolder(j1));
						if (message != null) {
							someIssue = true;
							smLib.messageReceiver.message(
									MessageType.N4_WARN, 
									"File list: name check - 'folder' found:", 
									"Issue: '" + message + "'", 
									"'" + directoryUnit.getFolder(j1) + "'", 
									"At '" + directoryUnit.directory + "'."
							);
						}
					}
				}
				
				if (directoryUnit.files != null) {
					for (int i2 = 0; i2 < directoryUnit.files.size(); i2++) {
						message = smLib.fileDirectoryAndNameCheck.check_filename(directoryUnit.getFile(i2));
						if (message != null) {
							someIssue = true;
							smLib.messageReceiver.message(
									MessageType.N4_WARN, 
									"File list: name check - 'file' found:", 
									"Issue: '" + message + "'", 
									"'" + directoryUnit.getFile(i2) + "'", 
									"At '" + directoryUnit.directory + "'."
							);
						}
					}
				}
			}
			
			if (!someIssue) {
				gui.label_state.setText("'3)' finished.");
			}
			else {
				gui.label_state.setText("'3)' finished with some messages, see 'Events'.");
			}
			smLib.messageReceiver.message(
					MessageType.N12_INFONOREFER, 
					"File list: name check finished."
			);
		}
		catch (Exception ex) {
			gui.label_state.setText("Exception during '3)'. See 'Events'.");
			smLib.messageReceiver.message(
					MessageType.N1_FATAL, 
					MessageList.assemblePlacement(this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName()), 
					"Exception:  " + ex.toString()
			);
			ex.printStackTrace();
		}
	}
	
	
	private void button4_checkFilenames_pattern() {
		try {
			if (targetDirectory == null || targetDirectory.size() == 0) {
				gui.label_state.setText("Before '3)' you need to start with '1)'.");
				return;
			}
			else if ((list_files_fetchedData == null || list_files_fetchedData.size() == 0)) {
				gui.label_state.setText("Before '3)' you need to continue with '2)'.");
				return;
			}
			
			String message = null;
			boolean someIssue = false;
			
			message = smLib.fileDirectoryAndNameCheck.check_directory_pattern(list_files_fetchedData.get_directoryUnit(0).directory);
			if (message != null) {
				someIssue = true;
				smLib.messageReceiver.message(
						MessageType.N4_WARN, 
						"File list: name check-pattern - 'directoy' found:", 
						"'" + list_files_fetchedData.get_directoryUnit(0).directory + "'", 
						"Issue: '" + message + "'"
				);
			}
			
			for (int i1 = 0; i1 < list_files_fetchedData.size(); i1++) {
				DirectoriesAndFiles_Unit directoryUnit = list_files_fetchedData.get_directoryUnit(i1);
				
				if (directoryUnit.folders != null) {
					for (int j1 = 0; j1 < directoryUnit.folders.size(); j1++) {
						message = smLib.fileDirectoryAndNameCheck.check_filename_pattern(directoryUnit.getFolder(j1));
						if (message != null) {
							someIssue = true;
							smLib.messageReceiver.message(
									MessageType.N4_WARN, 
									"File list: name check-pattern - 'folder' found:", 
									"Issue: '" + message + "'", 
									"'" + directoryUnit.getFolder(j1) + "'", 
									"At '" + directoryUnit.directory + "'."
							);
						}
					}
				}
				
				if (directoryUnit.files != null) {
					for (int j2 = 0; j2 < directoryUnit.files.size(); j2++) {
						message = smLib.fileDirectoryAndNameCheck.check_filename_pattern(directoryUnit.getFile(j2));
						if (message != null) {
							someIssue = true;
							smLib.messageReceiver.message(
									MessageType.N4_WARN, 
									"File list: name check-pattern - 'file' found:", 
									"Issue: '" + message + "'", 
									"'" + directoryUnit.getFile(j2) + "'", 
									"At '" + directoryUnit.directory + "'."
							);
						}
					}
				}
			}
			
			if (!someIssue) {
				gui.label_state.setText("'3)b)' finished.");
			}
			else {
				gui.label_state.setText("'3)b)' finished with some messages, see 'Events'.");
			}
			smLib.messageReceiver.message(
					MessageType.N12_INFONOREFER, 
					"File list: name check-pattern finished."
			);
		}
		catch (Exception ex) {
			gui.label_state.setText("Exception during '3)b)'. See 'Events'.");
			smLib.messageReceiver.message(
					MessageType.N1_FATAL, 
					MessageList.assemblePlacement(this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName()), 
					"Exception:  " + ex.toString()
			);
			ex.printStackTrace();
		}
	}
	
	
	private void button3_saveToFile() {
		try {
			if (targetDirectory == null || targetDirectory.size() == 0) {
				gui.label_state.setText("Before '4)' you need to start with '1)'.");
				return;
			}
			else if ((list_files_fetchedData == null || list_files_fetchedData.size() == 0)) {
				gui.label_state.setText("Before '4)' you need to continue with '2)'.");
				return;
			}
			
			savePath = smLib.fileDialogSm.fileDialog_save_chooseDirectoryAndFileName(null, fileNameExtension);
			if (savePath == null || savePath.isEmpty()) {
				return;
			}
			gui.label_resuldSavedToDirectory.setText(savePath.getSingle_directory() + "  " + savePath.getSingle_fileInDirectory());
			
			performToFileContent();
			
			Data_StringSmList data = new Data_StringSmList(smLib);
			data.set_content(list_files_resultData);
			data.set_fileDirectory(savePath.getSingle_directory());
			data.set_fileName(savePath.getSingle_fileInDirectory());
			smLib.fileIo.write_smList1DString(data);
			
			if (data.isFailed()) {
				gui.label_state.setText("NOK, dataWrited fail. Exception during '4)'.");
				data.add_processMessages(
						ProcessResult.N4_WARN, 
						this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName(), 
						"NOK, dataWrited fail."
				);
				smLib.messageReceiver.n2_error(data.getAndClear_processMessages());
			}
			else {
				gui.label_state.setText("Finished [4)]. OK.");
				smLib.messageReceiver.message(
						MessageType.N12_INFONOREFER, 
						MessageList.assemblePlacement(this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName()), 
						"Successfully saved to file. Target directory: '" + targetDirectory.getSingle_directory() + "'."
				);
			}
		}
		catch (Exception ex) {
			gui.label_state.setText("Exception during '4)'. See app events.");
			smLib.messageReceiver.message(
					MessageType.N1_FATAL, 
					MessageList.assemblePlacement(this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName()), 
					"Exception:  '" + ex.toString() + "'."
			);
			ex.printStackTrace();
		}
	}
	
	
	private void performToFileContent() {
		String line_divideContent = 
				"----------------------------------------------------------------"
				+ "----------------------------------------------------------------";
		
		
		list_files_resultData = new SmList_1D_String(SmList_Size.MEDIUM_4K);
		
		// Header, FIY.
		list_files_resultData.addValue("");
		list_files_resultData.addValue("");
		list_files_resultData.addValue(line_divideContent);
		list_files_resultData.addValue("TITLE: 1) File type");
		list_files_resultData.addValue("");
		list_files_resultData.addValue("EN: List of files in selected directory.");
		list_files_resultData.addValue("");
		list_files_resultData.addValue("CZ: Tento soubor obsahuje výpis všech souborů určité složky.");
		list_files_resultData.addValue("Čast [3)] obsahuje výpis všech directories. Poté v hlavní části [4)] je pro každou složku zapsána "
				+ "její celá cesta, jména složek uvnitř, a jména souborů uvnitř (a případně velikost každého souboru). Kažký takový výpis "
				+ "složky je oddělen prázdným řádkem. Vypíše i prázdné složky.");
		list_files_resultData.addValue("");
		list_files_resultData.addValue("");
		list_files_resultData.addValue(line_divideContent);
		
		// Header, info.
		list_files_resultData.addValue("TITLE: 2) Content details");
		list_files_resultData.addValue("");
		list_files_resultData.addValue("Created on: ");
		list_files_resultData.addValue("'" + smLib.timePerform.get_str_sdf_actualDateTime_withSeparators_twoSpaces_descending() + "'");
		list_files_resultData.addValue("");
		list_files_resultData.addValue("Selected root directory: ");
		list_files_resultData.addValue("'" + targetDirectory.getSingle_directory() + "'");
		list_files_resultData.addValue("");
		list_files_resultData.addValue("Number of directories, root included: ");
		list_files_resultData.addValue("'" + Integer.toString(list_files_fetchedData.size()) + "'");
		list_files_resultData.addValue("");
		
		int filesQuantity = 0;
		for (int i1 = 0; i1 < list_files_fetchedData.size(); i1++) {
			DirectoriesAndFiles_Unit directoryUnit = list_files_fetchedData.get_directoryUnit(i1);
			if (directoryUnit.files != null) {
				filesQuantity += directoryUnit.files.size();
			}
		}
		list_files_resultData.addValue("Number of files: ");
		list_files_resultData.addValue("'" + Integer.toString(filesQuantity) + "'");
		list_files_resultData.addValue("");
		list_files_resultData.addValue("Custom notes: ");
		list_files_resultData.addValue("'" + gui.textField1.getText() + "'");
		list_files_resultData.addValue("");
		list_files_resultData.addValue("");
		list_files_resultData.addValue(line_divideContent);
		
		// Content.
		list_files_resultData.addValue("TITLE: 3) List of directories");
		list_files_resultData.addValue("");
		list_files_resultData.addValue("");
		
		for (int i1 = 0; i1 < list_files_fetchedData.size(); i1++) {
			list_files_resultData.addValue(list_files_fetchedData.get_directoryUnit(i1).directory);
		}
		
		list_files_resultData.addValue("");
		list_files_resultData.addValue("");
		list_files_resultData.addValue("");
		list_files_resultData.addValue("");
		list_files_resultData.addValue("");
		list_files_resultData.addValue(line_divideContent);
		
		String title4 = "TITLE: 4) Main content: directory, folders in directory, files in directory (and size of each file)";
		list_files_resultData.addValue(title4);
		list_files_resultData.addValue("");
		list_files_resultData.addValue("");
		
		for (int i1 = 0; i1 < list_files_fetchedData.size(); i1++) {
			DirectoriesAndFiles_Unit directoryUnit = list_files_fetchedData.get_directoryUnit(i1);
			
			list_files_resultData.addValue(directoryUnit.directory);
			
			if (directoryUnit.folders != null) {
				for (int i2 = 0; i2 < directoryUnit.folders.size(); i2++) {
					list_files_resultData.addValue(smLib.introduction.get_platform_slashType() + directoryUnit.getFolder(i2));
				}
			}
			
			if (directoryUnit.files != null) {
				for (int i3 = 0; i3 < directoryUnit.files.size(); i3++) {
					list_files_resultData.addValue(directoryUnit.getFile(i3));
					long fileSize = directoryUnit.getFileSize(i3);
					if (fileSize != 0) {
						list_files_resultData.addValue(fileSizeFormat(fileSize));
					}
				}
			}
			
			list_files_resultData.addValue("");
		}
		
		list_files_resultData.addValue("");
		list_files_resultData.addValue("");
		list_files_resultData.addValue("");
		list_files_resultData.addValue("");
		list_files_resultData.addValue(line_divideContent);
		
		list_files_resultData.addValue("");
		list_files_resultData.addValue("");
	}
	
	
	private String fileSizeFormat(long fileSize) {
		String fileSize_str = Long.toString(fileSize);
		String formated = "";
		
		for (int i1 = fileSize_str.length() - 1; i1 >= 0; i1--) {
			if ((fileSize_str.length() - 1 - i1) % 3 == 0 && fileSize_str.length() - 1 - i1 != 0) {
				formated = " " + formated;
			}
			formated = fileSize_str.charAt(i1) + formated;
		}
		
		formated = MarkLabelStringEtc.CHARS_spaces32 + "Size: " + formated + " B.";
		
		return formated;
	}

}
