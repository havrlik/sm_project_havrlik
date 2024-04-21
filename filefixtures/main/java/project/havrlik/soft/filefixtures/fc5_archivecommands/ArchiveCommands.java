package main.java.project.havrlik.soft.filefixtures.fc5_archivecommands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import main.java.project.havrlik.soft.filefixtures.smlib.SmLib;
import main.java.project.havrlik.soft.smguiswing.other.Gui_Table_Dto;
import main.java.project.havrlik.soft.smlib.data.Data_StringSmList;
import main.java.project.havrlik.soft.smlib.file.DirectoriesAndFiles;
import main.java.project.havrlik.soft.smlib.message.MessageList;
import main.java.project.havrlik.soft.smlib.message.MessageType;
import main.java.project.havrlik.soft.smlib.smlist.SmList_1D_String;
import main.java.project.havrlik.soft.smlib.smlist.SmList_Size;

/**
 * Intended to assemble commands for archive.
 * 
 * You can fetch from file list of your folders to be archived. The list has relative paths of folders for multiple archives which you need.
 * In the app you can connect the relative paths with your base directory for both input and output. 
 * The app can prepare the same name of a archive as folder which is archived, and add some suffix.
 */
public class ArchiveCommands {
	
	private SmLib smLib;
	
	private ArchiveCommands_Gui gui;
	
	private final String fileEnds_txt = ".txt";
	private final String extension_7z = ".7z";
	private final String extension_7z001 = ".7z.001";
	private SmList_1D_String fileContent;
	private SmList_1D_String list;
	
	
	public ArchiveCommands(SmLib smLib) {
		this.smLib = smLib;
		
		gui = new ArchiveCommands_Gui(smLib);
		clear();
		
		gui.get_button8_clear().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clear();
				gui.get_label_state().setText("Cleared.");
			}
		});
		gui.get_button1_fetch().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				button1_fetch();
			}
		});
		gui.get_button2_perform().addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {  }
			@Override
			public void mousePressed(MouseEvent e) {
				gui.get_label_state().setText("...");
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button2_perform();
			}
			@Override
			public void mouseEntered(MouseEvent e) {  }
			@Override
			public void mouseExited(MouseEvent e) {  }
		});
		gui.get_button7_save().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				button7_save();
			}
		});
		
		table_init();
	}
	
	
	public ArchiveCommands_Gui return_gui() { return gui; }
	
	
	private void clear() {
		gui.get_label_state().setText("You can start.");
		gui.get_textField1_password().setText("");
		gui.get_textField2_path1().setText("");
		gui.get_textField3_path2().setText("");
		
		gui.get_table_list().get_tableDto().rows = null;
		gui.get_table_list().refresh();
		
		fileContent = null;
		list = null;
	}
	
	
	private void table_init() {
		String[] table_tableColumns = new String[] { "Command" };
		int[] table_tableColumns_width = new int[] { 900 };  // Sum 900 for window width 960.
		String[][] table_tableRows = null;
		
		Gui_Table_Dto table_DtoForPanel = new Gui_Table_Dto(table_tableColumns, table_tableColumns_width, table_tableRows);
		gui.get_table_list().refresh(table_DtoForPanel);
	}
	
	
	private void button1_fetch() {
		// Choose file.
		DirectoriesAndFiles fileList = smLib.fileDialogSm.fileDialog_load_oneFile(null, fileEnds_txt);
		if (fileList == null || fileList.size() == 0) {
			return;
		}
		
		// If not cancelled the GUI file dialog, continue. Clear variables.
		gui.get_table_list().get_tableDto().rows = null;
		gui.get_table_list().refresh();
		fileContent = null;
		list = null;
		
		// Load.
		Data_StringSmList dataFile = new Data_StringSmList(smLib);
		dataFile.set_fileDirectory(fileList.getSingle_directory());
		dataFile.set_fileName(fileList.getSingle_fileInDirectory());
		smLib.fileIo.read_smList1DString(dataFile);
		if (dataFile.isFailed() || dataFile.rowNumber_fileData < 1) {
			MessageList process_failMessages = new MessageList(
					this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName(), 
					"IO read failed at file '" + dataFile.get_fileDirectory() + "  " + dataFile.get_fileName() + "'."
			);
			process_failMessages.add_wholeBlock(dataFile.getAndClear_processMessages());
			smLib.messageReceiver.message(MessageType.N2_ERROR, process_failMessages);
			gui.get_label_state().setText("NOK, file read failed.");
			return;
		}
		fileContent = dataFile.get_content();
		
		gui.get_label_state().setText("Fetched.");
	}
	
	
	private void button2_perform() {
		list = new SmList_1D_String(SmList_Size.SMALL_64);
		list.addValue("");
		boolean bypass = false;  // Add fake value to 'fileContent' if is null. Helps to simper process.
		
		if (
				(gui.get_textField2_path1().getText() == null || gui.get_textField2_path1().getText().length() == 0) && 
				fileContent == null
		) {
			gui.get_label_state().setText("NOK, missing 'Path 1' or 'fetch folders from file'.");
			return;
		}
		if (fileContent == null) {
			fileContent = new SmList_1D_String(SmList_Size.TINY_16);
			fileContent.addValue("");
			bypass = true;
		}
		// Update 'bypass' if recurring perform.
		if (fileContent != null && fileContent.size() == 1 && fileContent.getValue(0).length() == 0) {
			bypass = true;
		}
		
		
		String fileContent_row;
		String command;
		
		String textField1_password = null;
		String textField2_path1 = null;
		String textField3_path2 = null;
		String textField4_suffix = null;
		if (gui.get_textField1_password().getText() != null && gui.get_textField1_password().getText().length() > 0) {
			textField1_password = gui.get_textField1_password().getText();
		}
		if (gui.get_textField2_path1().getText() != null && gui.get_textField2_path1().getText().length() > 0) {
			textField2_path1 = gui.get_textField2_path1().getText();
		}
		if (gui.get_textField3_path2().getText() != null && gui.get_textField3_path2().getText().length() > 0) {
			textField3_path2 = gui.get_textField3_path2().getText();
		}
		if (gui.get_textField4_suffix().getText() != null && gui.get_textField4_suffix().getText().length() > 0) {
			textField4_suffix = gui.get_textField4_suffix().getText();
		}
		
		for (int i1 = 0; i1 < fileContent.size(); i1++) {
			fileContent_row = fileContent.getValue(i1);
			command = "";
			
			// Skip empty rows.
			if ((
					fileContent_row == null ||
					fileContent_row.length() == 0
			) && !bypass) {
				continue;
			}
			
			command += gui.get_label1_program().getText();
			
			String type = gui.get_jComboBox1_option()[gui.get_jComboBox1_command().getSelectedIndex()];
			command += " " + type;
			
			// Create.
			if (type.equals("a")) {
				if (
						textField3_path2 == null && 
						fileContent == null
				) {
					gui.get_label_state().setText("NOK, missing 'Path 2' or 'fetch folders from file'.");
					return;
				}
				
				if (gui.get_checkBox1_volumes().isSelected()) {
					command += " " + gui.get_checkBox1_volumes().getText();
				}
				
				if (gui.get_checkBox2_compression().isSelected()) {
					command += " " + gui.get_checkBox2_compression().getText();
				}
				
				if (gui.get_checkBox3_password().isSelected()) {
					command += " " + gui.get_checkBox3_password().getText();
					if (textField1_password != null) {
						command += "'" + textField1_password + "'";
					}
				}
				
				if (gui.get_checkBox4_headerEncription().isSelected()) {
					command += " " + gui.get_checkBox4_headerEncription().getText();
				}
				
				// Output path ('path1'): part 1, part 2, copy folder name, suffix, extension.
				String path1;
				if (textField2_path1 == null) {
					path1 = fileContent_row;
				}
				else {
					path1 = smLib.fileDirectoryAndNameCustomize.return_connectFileDirectories(
							textField2_path1, fileContent_row);
				}
				if (gui.get_checkBox9_copyLastFolder().isSelected()) {
					String path1b = smLib.fileDirectoryAndNameCustomize.return_changeDirectory_cutBegin_keepEnd(path1, 1);
					path1 = smLib.fileDirectoryAndNameCustomize.return_connectFileDirectories(path1, path1b);
				}
				command += " '" + path1;
				if (gui.get_checkBox8_suffix().isSelected() && textField4_suffix != null) {
					command += textField4_suffix;
				}
				if (
						gui.get_checkBox5_extension_7z().isSelected() || 
						gui.get_checkBox7_extension_7z001().isSelected()
				) {
					command += extension_7z + "'";
				}
				else {
					command += "'";
				}
				
				// Input path ('path2'): part 1, part 2.
				if (textField3_path2 == null) {
					command += " '" + fileContent_row + "'";
				}
				else {
					command += " '" + smLib.fileDirectoryAndNameCustomize.return_connectFileDirectories(
							textField3_path2, fileContent_row) + "'";
				}
			}
			
			// Test.
			else if (type.equals("t")) {
				// Input path ('path1'): part 1, part 2, copy folder name, suffix, extension.
				String path1;
				if (textField2_path1 == null) {
					path1 = fileContent_row;
				}
				else {
					path1 = smLib.fileDirectoryAndNameCustomize.return_connectFileDirectories(
							textField2_path1, fileContent_row);
				}
				if (gui.get_checkBox9_copyLastFolder().isSelected()) {
					String path1b = smLib.fileDirectoryAndNameCustomize.return_changeDirectory_cutBegin_keepEnd(path1, 1);
					path1 = smLib.fileDirectoryAndNameCustomize.return_connectFileDirectories(path1, path1b);
				}
				command += " '" + path1;
				if (gui.get_checkBox8_suffix().isSelected() && textField4_suffix != null) {
					command += textField4_suffix;
				}
				// Prefer 'extension_7z001'.
				if (gui.get_checkBox7_extension_7z001().isSelected()) {
					command += extension_7z001;
				}
				else if (gui.get_checkBox5_extension_7z().isSelected()) {
					command += extension_7z;
				}
				command += "'";
			}
			
			// Extract.
			else if (type.equals("x")) {
				// Input path ('path1'): part 1, part 2, suffix, extension.
				String path1;
				if (textField2_path1 == null) {
					path1 = fileContent_row;
				}
				else {
					path1 = smLib.fileDirectoryAndNameCustomize.return_connectFileDirectories(
							textField2_path1, fileContent_row);
				}
				if (gui.get_checkBox9_copyLastFolder().isSelected()) {
					String path1b = smLib.fileDirectoryAndNameCustomize.return_changeDirectory_cutBegin_keepEnd(path1, 1);
					path1 = smLib.fileDirectoryAndNameCustomize.return_connectFileDirectories(path1, path1b);
				}
				command += " '" + path1;
				if (gui.get_checkBox8_suffix().isSelected() && textField4_suffix != null) {
					command += textField4_suffix;
				}
				// Prefer 'extension_7z001'.
				if (gui.get_checkBox7_extension_7z001().isSelected()) {
					command += extension_7z001;
				}
				else if (gui.get_checkBox5_extension_7z().isSelected()) {
					command += extension_7z;
				}
				command += "'";
				
				// Output path ('path2'): part 1, part 2, remove last folder.
				String outputPath;
				if (textField3_path2 == null) {
					outputPath = smLib.fileDirectoryAndNameCustomize.return_FileNameAndExtensionDto(fileContent_row).fileNameWithoutExtension;
				}
				else {
					outputPath = smLib.fileDirectoryAndNameCustomize.return_FileNameAndExtensionDto(
							smLib.fileDirectoryAndNameCustomize.return_connectFileDirectories(textField3_path2, fileContent_row)
							).fileNameWithoutExtension;
				}
				if (gui.get_checkBox6_removeFolder().isSelected()) {
					outputPath = smLib.fileDirectoryAndNameCustomize.return_changeDirectory_cutEnd(outputPath, 1);
				}
				command += " -o'" + outputPath + "'";
			}
			
			list.addValue(command);
		}
		
		list.addValue("");
		
		// Add date to output list.
		list.addValue("Created on: " + smLib.timePerform.get_str_sdf_actualDateTime_withSeparators_twoSpaces_descending());
		list.addValue("");
		
		table_insertRows(list);
		gui.get_label_state().setText("Perform done.");
	}
	
	
	private void table_insertRows(SmList_1D_String list) {
		String[][] rows = new String[list.size()][1];
		
		for (int i1 = 0; i1 < list.size(); i1++) {
			rows[i1][0] = list.getValue(i1);
		}
		
		gui.get_table_list().get_tableDto().rows = rows;
		gui.get_table_list().refresh();
	}
	
	
	private void button7_save() {
		// Choose output.
		DirectoriesAndFiles fileList = smLib.fileDialogSm.fileDialog_save_chooseDirectoryAndFileName(null, fileEnds_txt);
		if (fileList == null || fileList.size() == 0) {
			return;
		}
		
		// Save.
		Data_StringSmList data = new Data_StringSmList(smLib);
		data.set_content(list);
		data.set_fileDirectory(fileList.getSingle_directory());
		data.set_fileName(fileList.getSingle_fileInDirectory());
		smLib.fileIo.write_smList1DString(data);
		if (data.isFailed()) {
			gui.get_label_state().setText("File write failed.");
			smLib.messageReceiver.message(MessageType.N2_ERROR, data, 
					this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName(), 
					"File write failed."
			);
			return;
		}
		
		gui.get_label_state().setText("Saved.");
	}

}
