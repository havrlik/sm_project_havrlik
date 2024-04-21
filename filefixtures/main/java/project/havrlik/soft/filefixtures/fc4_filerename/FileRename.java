package main.java.project.havrlik.soft.filefixtures.fc4_filerename;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.java.project.havrlik.soft.filefixtures.smlib.SmLib;
import main.java.project.havrlik.soft.smguiswing.other.Gui_Table_Dto;
import main.java.project.havrlik.soft.smlib.file.DirectoriesAndFiles;
import main.java.project.havrlik.soft.smlib.file.FileListCustomize;
import main.java.project.havrlik.soft.smlib.message.MessageList;
import main.java.project.havrlik.soft.smlib.message.MessageType;
import main.java.project.havrlik.soft.smlib.other.ListPerform;
import main.java.project.havrlik.soft.smlib.other.MarkLabelStringEtc;

public class FileRename {
	
	private SmLib smLib;
	
	private FileRename_Gui gui;
	private int modeOption_selected = 0;
	
	
	public FileRename(SmLib smLib) {
		this.smLib = smLib;
		
		gui = new FileRename_Gui(smLib);
		clear();
		
		gui.get_button1_fetch().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				process1_fetch();
			}
		});
		gui.get_button3_perform().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				process2_perform();
			}
		});
		
		table_init();
	}
	
	
	public FileRename_Gui return_gui() { return gui; }
	
	
	private void clear() {
		gui.get_label_state().setText("You can start.");
		gui.get_table_fileList().get_tableDto().rows = null;
		gui.get_table_fileList().refresh();
	}
	
	
	private void process1_fetch() {
		try {
			// Get selected mode option.
			modeOption_selected = ListPerform.returnRow_1DArray(FileRename_Gui.modeOption, gui.get_jComboBox_modeOption().getSelectedItem().toString());
			if (modeOption_selected < 1) {
				gui.get_label_state().setText("Select mode.");
				return;
			}
			
			// Open and load file names.
			DirectoriesAndFiles fileList = null;
			if (gui.get_rb_group_rb1().isSelected()) {
				fileList = smLib.fileDialogSm.fileDialog_load_multipleFiles(null, null);
			}
			else if (gui.get_rb_group_rb2().isSelected()) {
				fileList = smLib.fileDialogSm.fileChooser_chooseDirectoryAndReturnAllFilesInsideThisDirectory(null);
			}
			else if (gui.get_rb_group_rb3().isSelected()) {
				fileList = smLib.fileDialogSm.fileChooser_chooseDirectoryAndReturnAllFilesInsideThisAndLowerDirectories(null, null);
			}
			if (fileList == null || fileList.isEmpty()) {
				return;
			}
			
			clear();
			
			// UI.
			gui.get_checkBox1().setSelected(false);
			gui.get_checkBox1().setEnabled(true);
			gui.get_button3_perform().setEnabled(false);
			
			// Sort fetched directories and filenames.
			FileListCustomize.sortAsc_insertion(fileList);
			
			// Init table, pass data.
			gui.get_table_fileList().get_tableDto().rows = smLib.fileListCustomize.return_array2D_fileListCollection(fileList, 4);
			gui.get_table_fileList().refresh();
			suggestChanges();
			gui.get_table_fileList().refresh();
			
			gui.get_label_state().setText("Fetched. Check table.");
		}
		catch (Exception ex) {
			gui.get_label_state().setText("NOK, Exception:  '" + ex.toString() + "'.");
			smLib.messageReceiver.message(
					MessageType.N1_FATAL, 
					MessageList.assemblePlacement(this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName()), 
					"Exception:  '" + ex.toString() + "'."
			);
		}
	}
	
	
	private void suggestChanges() {
		switch (modeOption_selected) {
		case 1:
			suggestChanges_mode1();
			break;
		}
	}
	
	
	private void suggestChanges_mode1() {
		String[][] table = gui.get_table_fileList().get_tableDto().rows;
		
		for (int i1 = 0; i1 < table.length; i1++) {
			String newFilename = "";
			for (int j1 = 0; j1 < table[i1][1].length(); j1++) {
				if (table[i1][1].charAt(j1) == ':') {
					newFilename += '-';
				}
				else {
					newFilename += table[i1][1].charAt(j1);
				}
			}
			// Insert suggested filename, if is different from origin.
			if (!table[i1][1].equals(newFilename)) {
				table[i1][2] = newFilename;
			}
		}
	}
	
	
	private void process2_perform() {
		// Rename files.
		if (!gui.get_checkBox1().isSelected()) {
			return;
		}
		String[][] table = gui.get_table_fileList().get_tableDto().rows;
		if (table == null || table.length == 0 || table[0][0] == null || table[0][0].length() == 0) {
			return;
		}
		
		try {
			for (int i1 = 0; i1 < table.length; i1++) {
				// Skip if suggested filename is not inserted, or there exists some note in 4th column
				if (
						(table[i1][2] == null || table[i1][2].length() == 0) || 
						(table[i1][3] != null && table[i1][3].length() != 0)
				) {
					continue;
				}
				if (smLib.fileDirectoryAndNameCustomize.renameFile(
						smLib.fileDirectoryAndNameCustomize.return_connectFileDirectoryAndName(table[i1][0], table[i1][1]), 
						smLib.fileDirectoryAndNameCustomize.return_connectFileDirectoryAndName(table[i1][0], table[i1][2])
				)) {
					table[i1][3] = MarkLabelStringEtc.MARK_ok;
				}
				else {
					table[i1][3] = MarkLabelStringEtc.MARK_NOK;
				}
			}
			
			// Display result, count issues.
			int issues = 0;
			for (int j1 = 0; j1 < table.length; j1++) {
				if (
						table[j1][2] != null && table[j1][2].length() > 0 && 
						table[j1][3] != null && table[j1][3].length() > 0 && table[j1][3].equals(MarkLabelStringEtc.MARK_ok)
				) {
					issues++;
				}
			}
			if (issues > 0) {
				gui.get_label_state().setText("Finished. Issues: " + Integer.toString(issues) + ".");
			}
			else {
				gui.get_label_state().setText("Finished, OK.");
			}
			gui.get_table_fileList().refresh();
		}
		catch (Exception ex) {
			gui.get_table_fileList().refresh();
			gui.get_label_state().setText("NOK, Exception:  '" + ex.toString() + "'.");
			smLib.messageReceiver.message(
					MessageType.N1_FATAL, 
					MessageList.assemblePlacement(this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName()), 
					"Exception:  '" + ex.toString() + "'."
			);
		}
	}
	
	
	private void table_init() {
		String[] fileList_tableColumns = new String[] {"Directory", "File name", "Suggested new name", "Note"};
		int[] fileList_tableColumns_width = new int[] {280, 280, 280, 60};  // Sum 900 for window width 960.
		String[][] fileList_tableRows = new String[][] {
			{"", "<empty>", "", ""}
		};
		
		Gui_Table_Dto fileList_DtoForPanel = new Gui_Table_Dto(fileList_tableColumns, fileList_tableColumns_width, fileList_tableRows);
		gui.get_table_fileList().refresh(fileList_DtoForPanel);
	}

}
