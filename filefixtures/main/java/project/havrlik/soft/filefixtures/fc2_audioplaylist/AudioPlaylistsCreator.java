package main.java.project.havrlik.soft.filefixtures.fc2_audioplaylist;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.java.project.havrlik.soft.filefixtures.smlib.SmLib;
import main.java.project.havrlik.soft.smlib.data.Data_StringSmList;
import main.java.project.havrlik.soft.smlib.file.DirectoriesAndFiles;
import main.java.project.havrlik.soft.smlib.file.DirectoriesAndFiles_File;
import main.java.project.havrlik.soft.smlib.file.DirectoriesAndFiles_Unit;
import main.java.project.havrlik.soft.smlib.file.FileListCustomize;
import main.java.project.havrlik.soft.smlib.message.MessageList;
import main.java.project.havrlik.soft.smlib.message.MessageType;
import main.java.project.havrlik.soft.smlib.smlist.SmList_1D_String;
import main.java.project.havrlik.soft.smlib.smlist.SmList_Size;

/**
 * Created by 'Havrlik on 2018'.
 * 
 * Create palylist file in selected directory. Insert files which is containing the directory.
 */


public class AudioPlaylistsCreator {
	
	private SmLib smLib;
	
	private AudioPlaylistsCreator_Gui gui;
	
	String fileExtensionPlaylist = ".m3u";
	String[] allowedFileEnds = {
			
			// Uncompressed audio formats.
			".wav",
			".wave",
			".aiff",
			".aif",
			".aifc",
			".au",
			".snd",
			".raw",
			".pcm",
			".sam",
			
			// Formats with lossless compression.
			".flac",
			".ape",
			".wv",
			".wvc",
			".tta",
			".aa3",
			".oma",
			".at3",
			".at9",
			".m4a",
			".caf",
			".wma",
			".shn",
			
			// Formats with lossy compression.
			".opus",
			".mp3",
			".ogg",
			".mpc",
			".mp+",
			".mpp",
			".aac",
			".3gp",
			".m4b",
			".m4p",
			".m4r",
			".m4v",
			".aa3",
			".oma",
	};
	
	boolean checkBox1_excludeNotAllowedFiles = false;
	
	boolean wereAnyFileExcluded = false;
	
	
	public AudioPlaylistsCreator(SmLib smLib) {
		this.smLib = smLib;
		
		gui = new AudioPlaylistsCreator_Gui(smLib);
		clearVariables();
		
		gui.label_state.setText("You can start.");
		gui.textField1.setText("");
		
		gui.button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				process1();
			}
		});
		gui.checkBox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
	
	
	public AudioPlaylistsCreator_Gui return_gui() { return gui; }
	
	
	private void clearVariables() {
		wereAnyFileExcluded = false;
	}
	
	
	private void process1() {
		try {
			
			String fileNamePrefix = gui.textField1.getText();
			if (fileNamePrefix != null && fileNamePrefix.length() > 40) {
				gui.label_state.setText("File name prefix too long.");
				gui.label_directory.setText("[FAILED]");
				return;
			}
			DirectoriesAndFiles directory = smLib.fileDialogSm.fileChooser_chooseDirectoryAndReturnAllFilesInsideThisDirectory(null);
			if (directory == null || directory.isEmpty()) {
				return;
			}
			
			clearVariables();
			checkBox1_excludeNotAllowedFiles = gui.checkBox1.isSelected();
			
			// Sort.
			FileListCustomize.sortAsc_insertion(directory);
			
			DirectoriesAndFiles_Unit list = directory.get_directoryUnit(0);
			SmList_1D_String fileContent = null;
			
			String thisFolderName = smLib.fileDirectoryAndNameCustomize.return_nameFromDirectory_last(directory.getSingle_directory());
			String playlistFileName = fileNamePrefix + thisFolderName + fileExtensionPlaylist;
			if (playlistFileName.length() > 62) {
				playlistFileName = playlistFileName.substring(0, 62);
			}
			
			// Remove non-audio files in list.
			if (checkBox1_excludeNotAllowedFiles) {
				excludeNotAllowedFiles(list);
			}
			
			// Create file content.
			fileContent = createPlaylistContent(list, thisFolderName);
			if (fileContent == null) {
				gui.label_state.setText("Did not created - no one valid file in the directory found.");
				gui.label_directory.setText("[FAILED]  '" + directory.getSingle_directory() + "'");
				return;
			}
			
			// Save.
			Data_StringSmList data = new Data_StringSmList(smLib);
			data.set_content(fileContent);
			data.set_fileDirectory(directory.getSingle_directory());
			data.set_fileName(playlistFileName);
			smLib.fileIo.write_smList1DString(data);
			if (data.isFailed()) {
				gui.label_state.setText("File write failed.");
				smLib.messageReceiver.message(MessageType.N2_ERROR, data, 
						this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName(), 
						"File write failed."
				);
			}
			
			if (wereAnyFileExcluded) {
				smLib.messageReceiver.n12_infoNoRefer(
						MessageList.assemblePlacement(this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName()), 
						"FYI: Some not allowed files were excluded from palylist."
				);
			}
			
			gui.label_state.setText("Created.");
			gui.label_directory.setText("'" + directory.getSingle_directory() + "'");
			smLib.messageReceiver.n12_infoNoRefer(
					MessageList.assemblePlacement(this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName()), 
					"Playlist created. Target directory: '" + directory.getSingle_directory() + "'"
			);
		}
		catch (Exception ex) {
			gui.label_state.setText("Some error occured.");
			smLib.messageReceiver.n1_fatal(
					MessageList.assemblePlacement(this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName()), 
					"Exception:  " + ex.toString()
			);
			ex.printStackTrace();
		}
	}
	
	
	private void excludeNotAllowedFiles(DirectoriesAndFiles_Unit directoryUnit) {
		if (directoryUnit == null || directoryUnit.files == null || directoryUnit.files.size() == 0) {
			return;
		}
		
		for (int i1 = 0; i1 < directoryUnit.files.size(); i1++) {
			// Check file name extension.
			String fileName = directoryUnit.getFile(i1);
			String fileExtension = smLib.fileDirectoryAndNameCustomize.return_fileNameExtension(fileName);
			boolean foundAsValid = false;
			
			if (fileExtension != null && fileExtension.length() > 0) {
				for (int i2 = 0; i2 < allowedFileEnds.length; i2++) {
					if (allowedFileEnds[i2].equals(fileExtension.toLowerCase())) {
						foundAsValid = true;
						break;
					}
				}
			}
			
			if (!foundAsValid) {
				directoryUnit.files.putValue(i1, null);
				wereAnyFileExcluded = true;
			}
		}
	}
	
	
	private SmList_1D_String createPlaylistContent(DirectoriesAndFiles_Unit directoryUnit, String comment) {
		if (directoryUnit == null || directoryUnit.files == null || directoryUnit.files.size() == 0) {
			return null;
		}
		
		SmList_1D_String fileContent = new SmList_1D_String(SmList_Size.SMALL_64);
		boolean addedAnyRecord = false;
		
		fileContent.addValue("#EXTM3U");
		if (comment != null && comment.length() > 0) {
			fileContent.addValue("# Note: " + comment);
		}
		fileContent.addValue("");
		
		for (int i1 = 0; i1 < directoryUnit.files.size(); i1++) {
			DirectoriesAndFiles_File fileUnit = directoryUnit.files.getValue(i1);
			if (fileUnit == null) {
				continue;
			}
			String row = fileUnit.get_file();
			if (row == null || row.length() == 0) {
				continue;
			}
			fileContent.addValue(row);
			addedAnyRecord = true;
		}
		
		fileContent.addValue("");
		
		if (!addedAnyRecord) 
			return null;
		
		return fileContent;
	}

}
