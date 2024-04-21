package main.java.project.havrlik.soft.smlib.file;

import main.java.project.havrlik.soft.smlib.smlist.SmList_1D_Gnrc;
import main.java.project.havrlik.soft.smlib.smlist.SmList_1D_String;
import main.java.project.havrlik.soft.smlib.smlist.SmList_Size;

/**
 * Allows hold file name and its directory.
 * Also multiple directories, and in each multiple files in the directory and multiple folders in the directory.
 * 
 * Be careful when removing values. SmList don't update size of list when removing items.
 */


public class DirectoriesAndFiles {
	
	private SmList_1D_Gnrc<DirectoriesAndFiles_Unit> list;
	
	private SmList_Size listSize = SmList_Size.TINY_16;  // Size of directories.
	private SmList_Size listDepth = SmList_Size.TINY_16;  // Size of items in single directory.
	
	
	public DirectoriesAndFiles() {
		clear();
	}
	
	
	public DirectoriesAndFiles(SmList_Size listSize, SmList_Size listDepth) {
		if (listSize != null) {
			this.listSize = listSize;
		}
		if (listDepth != null) {
			this.listDepth = listDepth;
		}
		clear();
	}
	
	
	public void clear() {
		list = new SmList_1D_Gnrc<DirectoriesAndFiles_Unit>(listSize);
	}
	
	
	public void add(DirectoriesAndFiles_Unit unit) {
		list.addValue(unit);
	}
	
	
	public void add(String directory, String folder, String file) {
		DirectoriesAndFiles_Unit unit = new DirectoriesAndFiles_Unit(listDepth);
		
		unit.putDirectory(directory);
		if (folder != null) {
			unit.addFolder(folder);
		}
		if (file != null) {
			unit.addFile(file);
		}
		
		list.addValue(unit);
	}
	
	
//	public void add(String directory, ArrayList<String> folders, ArrayList<String> files) {
//		DirectoriesAndFiles_Unit unit = new DirectoriesAndFiles_Unit(listWidth);
//		
//		unit.addDirectory(directory);
//		if (folders != null && folders.size() > 0) {
//			unit.addFolders(folders);
//		}
//		if (files != null && files.size() > 0) {
//			unit.addFiles(files);
//		}
//		
//		list.addValue(unit);
//	}
	
	
	public void add(String directory, SmList_1D_String folders, SmList_1D_Gnrc<DirectoriesAndFiles_File> files) {
		if (directory == null || directory.length() < 1) {
			throw new RuntimeException("Missing 'directory'.");
		}
		
		DirectoriesAndFiles_Unit unit = new DirectoriesAndFiles_Unit(listDepth);
		
		unit.putDirectory(directory);
		if (folders != null && folders.size() > 0) {
			unit.folders = folders;
		}
		if (files != null && files.size() > 0) {
			unit.files = files;
		}
		
		list.addValue(unit);
	}
	
	
	public void put(int index, DirectoriesAndFiles_Unit directory) {
		list.putValue(index, directory);
	}
	
	
	public void put(int index, String directory, String folder, String file) {
		if (directory == null || directory.length() < 1) {
			throw new RuntimeException("Missing 'directory'.");
		}
		
		DirectoriesAndFiles_Unit unit = new DirectoriesAndFiles_Unit(listDepth);
		
		unit.putDirectory(directory);
		if (folder != null) {
			unit.addFolder(folder);
		}
		if (file != null) {
			unit.addFile(file);
		}
		
		list.putValue(index, unit);
	}
	
	
//	public void put(int index, String directory, ArrayList<String> folders, ArrayList<String> files) {
//		DirectoriesAndFiles_Unit unit = new DirectoriesAndFiles_Unit(listWidth);
//		
//		unit.addDirectory(directory);
//		if (folders != null && folders.size() > 0) {
//			unit.addFolders(folders);
//		}
//		if (files != null && folders.size() > 0) {
//			unit.addFiles(files);
//		}
//		
//		list.putValue(index, unit);
//	}
	
	
	public void put(int index, String directory, SmList_1D_String folders, SmList_1D_Gnrc<DirectoriesAndFiles_File> files) {
		if (directory == null || directory.length() < 1) {
			throw new RuntimeException("Missing 'directory'.");
		}
		
		DirectoriesAndFiles_Unit unit = new DirectoriesAndFiles_Unit(listDepth);
		
		unit.putDirectory(directory);
		if (folders != null && folders.size() > 0) {
			unit.folders = folders;
		}
		if (files != null && folders.size() > 0) {
			unit.files = files;
		}
		
		list.putValue(index, unit);
	}
	
	
	public SmList_1D_Gnrc<DirectoriesAndFiles_Unit> get_list() {
		return list;
	}
	
	
	public int size() {
		return list.size();
	}
	
	
	public boolean isEmpty() {
		return list.size() == 0;
	}
	
	
	public DirectoriesAndFiles_Unit get_directoryUnit(int index) {
		return list.getValue(index);
	}
	
	
	public DirectoriesAndFiles_Unit getFirstOrNull_directoryUnit() {
		if (list != null && list.size() > 0) {
			return list.getValue(0);
		}
		else {
			return null;
		}
	}
	
	
	
	/* Getters when the list contain only one direcotry with one file or folder. E.g. path file for save. */
	
	public boolean isSingle_directory() {
		return (
				isSingle_directoryUnit() && 
				list.getValue(0).directory != null
		);
	}
	
	public String getSingle_directory() {
		return getSingle_directoryUnit().directory;
	}
	
	
	public boolean isSingle_folderInDirectory() {
		return (
				isSingle_directoryUnit() && 
				list.getValue(0).folders != null && 
				list.getValue(0).folders.size() > 0
		);
	}
	
	
	public String getSingle_folderInDirectory() {
		return getSingle_directoryUnit().getFolder(0);
	}
	
	
	public boolean isSingle_fileInDirectory() {
		return (
				isSingle_directoryUnit() && 
				list.getValue(0).files != null && 
				list.getValue(0).files.size() > 0
		);
	}
	
	
	public String getSingle_fileInDirectory() {
		return getSingle_directoryUnit().files.getValue(0).file;
	}
	
	
	public long getSingle_fileSizeInDirectory() {
		return getSingle_directoryUnit().files.getValue(0).file_size;
	}
	
	
	private boolean isSingle_directoryUnit() {
		return (
				list != null && 
				list.size() > 0 && 
				list.getValue(0) != null
		);
	}
	
	
	private DirectoriesAndFiles_Unit getSingle_directoryUnit() {
		return list.getValue(0);
	}

}
