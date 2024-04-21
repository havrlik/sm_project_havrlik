package main.java.project.havrlik.soft.smlib.file;

import main.java.project.havrlik.soft.smlib.smlist.SmList_1D_Gnrc;
import main.java.project.havrlik.soft.smlib.smlist.SmList_1D_String;
import main.java.project.havrlik.soft.smlib.smlist.SmList_Size;

/**
 * Files and directories related to certain directory.
 */


public class DirectoriesAndFiles_Unit {
	
	private SmList_Size listDepth = SmList_Size.TINY_16;  // Size of items in single directory. Assign default.
	public String directory = null;
	public SmList_1D_String folders = null;
	public SmList_1D_Gnrc<DirectoriesAndFiles_File> files;
	
	
	public DirectoriesAndFiles_Unit() {
	}
	
	
	public DirectoriesAndFiles_Unit(SmList_Size listDepth) {
		this.listDepth = listDepth;
	}
	
	
	public SmList_Size get_listDepth() {
		return listDepth;
	}
	
	
	public void putDirectory(String directory) {
		this.directory = directory;
	}
	
	
	public void addFolder(String folder) {
		initializeIfNotYet_folders();
		
		this.folders.addValue(folder);
	}
	
	
	public void addFile(DirectoriesAndFiles_File file) {
		initializeIfNotYet_files();
		
		this.files.addValue(file);
	}
	
	
	public void addFile(String file) {
		addFile(new DirectoriesAndFiles_File(file));
	}
	
	
	public void addFile(String file, long file_size) {
		addFile(new DirectoriesAndFiles_File(file, file_size));
	}
	
	
//	public void putFileSize(int rowNumber, long file_size) {
//		files.getValue(rowNumber).file_size = file_size;
//	}
	
	
	public String getFolder(int index) {
		return folders.getValue(index);
	}
	
	
	public String getFile(int index) {
		return files.getValue(index).file;
	}
	
	
	public long getFileSize(int index) {
		return files.getValue(index).file_size;
	}
	
	
	private void initializeIfNotYet_folders() {
		if (this.folders == null) {
			this.folders = new SmList_1D_String(listDepth);
		}
	}
	
	
	private void initializeIfNotYet_files() {
		if (this.files == null) {
			this.files = new SmList_1D_Gnrc<DirectoriesAndFiles_File>(listDepth);
		}
	}

}
