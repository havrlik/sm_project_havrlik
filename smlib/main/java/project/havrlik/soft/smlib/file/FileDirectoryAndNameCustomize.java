package main.java.project.havrlik.soft.smlib.file;

import java.io.File;

import main.java.project.havrlik.soft.smlib.SmLib;
import main.java.project.havrlik.soft.smlib.introduction.PlatformOs;
import main.java.project.havrlik.soft.smlib.message.MessageList;
import main.java.project.havrlik.soft.smlib.message.MessageReceiver;
import main.java.project.havrlik.soft.smlib.message.MessageType;
import main.java.project.havrlik.soft.smlib.smlist.SmList_1D_String;
import main.java.project.havrlik.soft.smlib.smlist.SmList_Size;

public class FileDirectoryAndNameCustomize {
	
	protected SmLib smLib;
	protected MessageReceiver messageReceiver;
	
	protected PlatformOs PLATFORM_Os;
	protected char PLATFORM_slashType;
	
	
	public FileDirectoryAndNameCustomize(SmLib smLib) {
		this.smLib = smLib;
		messageReceiver = smLib.messageReceiver;
		
		call_constructorContinues();
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
	
	
	public void setup1() {
		PLATFORM_Os = smLib.introduction.get_PLATFORM_OS();
		PLATFORM_slashType = smLib.introduction.get_platform_slashType();
	}
	
	
	public void setup2_sub() {  }
	public void setup3() {  }
	public void setup4_sub() {  }
	
	
	// Getters.
	
	public char get_platformSlashType() { return PLATFORM_slashType; }
	
	
	// File directory and file name customize.
	
	public String return_path_changeSlashesToCurrentPlatform(String path) {
		/*
		 * return_path_changeSlashesToCurrentPlatform("AA/bb/CC/dd/ee")  returns  "AA\bb\CC\dd\ee".
		 */
		if (path == null) {
			return null;
		}
		String path_new = "";
		char character;
		for (int i1 = 0; i1 < path_new.length(); i1++) {
			character = path.charAt(i1);
			if (character == '/' || character == '\\') {
				path_new += PLATFORM_slashType;
			}
			else {
				path_new += character;
			}
		}
		
		return path_new;
	}
	
	
	public String return_connectFileDirectoryAndName(String directory, String name) {
		/*
		 * return_connectFileDirectoryAndName("AA/bb/CC/dd/ee", "12.txt")  returns  "AA/bb/CC/dd/ee/12.txt".
		 */
		if (directory == null || name == null || directory.length() < 2 || name.length() < 1) {
			return null;
		}
		
		String filePathName = "";
		filePathName = directory;
		// Check slash at end of path.
		if (filePathName.charAt(filePathName.length() - 1) != PLATFORM_slashType) {
			filePathName += PLATFORM_slashType;
		}
		
		filePathName += name;
		return filePathName;
	}
	
	
	public String return_connectFileDirectoryAndName(DirectoriesAndFiles directoriesAndFiles) {
		/*
		 * directoriesAndFiles contains only one directory and single file name.
		 */
		return return_connectFileDirectoryAndName(directoriesAndFiles.getSingle_directory(), directoriesAndFiles.getSingle_fileInDirectory());
	}
	
	
	public String return_connectFileDirectories(String ... directories) {
		/*
		 * Last received argument may be file name.
		 * return_connectFileDirectories("AA/bb", "CC", "dd/ee"")  returns  "AA/bb/CC/dd/ee".
		 */
		if (directories == null || directories.length == 0) {
			return null;
		}
		
		String path = "";
		for (int i1 = 0; i1 < directories.length; i1++) {
			if (directories[i1] == null) {
				return null;
			}
			if (directories[i1].length() == 0) {
				continue;
			}
			path += PLATFORM_slashType + directories[i1];  // Slash at position [0] will be removed.
		}
		
		// Remove multiple slashes.
		String newPath = "";
		newPath += PLATFORM_slashType;
		for (int i2 = 1; i2 < path.length(); i2++) {
			if (path.charAt(i2) == PLATFORM_slashType && path.charAt(i2 - 1) == PLATFORM_slashType) {
				continue;
			}
			newPath += path.charAt(i2);
		}
		
		return newPath;
	}
	
	
	public String return_folderWithoutSlashes(String folder) {
		/*
		 * return_folderWithoutSlashes("/AA/")  returns  "AA".
		 */
		if (folder == null || folder.length() == 0) {
			return null;
		}
		
		String newFolder = "";
		for (int i1 = 0; i1 < folder.length(); i1++) {
			if (folder.charAt(i1) != PLATFORM_slashType) {
				newFolder += folder.charAt(i1);
			}
		}
		
		if (newFolder.length() == 0) {
			return null;
		}
		
		return newFolder;
	}
	
	
	public String return_directoryWithoutLastSlash(String directory) {
		/*
		 * return_directoryWithoutLastSlash("AA/bb/CC/dd/ee/")  returns  "AA/bb/CC/dd/ee".
		 */
		if (directory == null || directory.length() < 4) {
			return null;
		}
		
		String newDirectory = "";
		if (directory.charAt(directory.length() - 1) == PLATFORM_slashType) {
			for (int i = 0; i < directory.length() - 1; i++) {
				newDirectory += directory.charAt(i);
			}
		}
		else {
			newDirectory = directory;
		}
		
		return newDirectory;
	}
	
	
	public String return_directoryWithoutFileName_dividePath(String path) {
		/*
		 * Remove a last part of the path divided by slashes.
		 * return_directoryWithoutFileName_dividePath("AA/bb/CC/dd/ee/12.txt")  returns  "AA/bb/CC/dd/ee".
		 * return_directoryWithoutFileName_dividePath("AA/bb/CC/dd/")  returns  "AA/bb/CC/dd/ee".
		 */
		if (path == null) {
			return null;
		}
		
		int numLastSlash = 0;
		for (int i1 = path.length() - 2; i1 > 0; i1--) {
			if (path.charAt(i1) == PLATFORM_slashType) {
				numLastSlash = i1;
				break;
			}
		}
		if (numLastSlash < 2) {
			return null;
		}
		
		String dir = "";
		for (short s = 0; s < numLastSlash; s++) {
			dir += path.charAt(s);
		}
		
		return dir;
	}
	
	
	public String return_fileNameWithoutDirectory_dividePath(String path) {
		/*
		 * return_fileNameWithoutDirectory_dividePath("AA/bb/CC/dd/ee/12.txt")  returns  "12.txt".
		 */
		if (path == null) {
			return null;
		}
		String fileName = null;
		int numLastSlash = -1;
		for (int i1 = path.length() - 1; i1 >= 0; i1--) {
			if (path.charAt(i1) == PLATFORM_slashType) {
				numLastSlash = i1;
				break;
			}
		}
		if (numLastSlash < 0) {
			return fileName;
		}
		fileName = "";
		for (short s = (short) (numLastSlash + 1); s < path.length(); s++) {
			fileName += path.charAt(s);
		}
		
		return fileName;
	}
	
	
//	public String return_parentDirectory_withLastSlash(String directory) {
	/*
	 * return_parentDirectory_withLastSlash("AA/bb/CC/dd/ee/")  returns  "AA/bb/CC/dd/".
	 */
//		if (directory == null || directory.length() < 3) {
//			return null;
//		}
//		
//		String newDirectory = "";
//		short s = 0;
//		for (s = (short) (directory.length() - 2); s > 2; s--) {
//			if (directory.charAt(s) == PLATFORMSlashType) {
//				break;
//			}
//		}
//		if (s > 2) {
//			for (short s2 = 0; s2 <= s; s2++) {
//				newDirectory += directory.charAt(s2);
//			}
//		}
//		else {
//			return null;
//		}
//		
//		return newDirectory;
//	}
	
	
	public String return_parentDirectory(String directory) {
		/*
		 * return_parentDirectory("AA/bb/CC/dd/ee/")  returns  "AA/bb/CC/dd".
		 */
		if (directory == null || directory.length() < 3) {
			return null;
		}
		
		String newDirectory = "";
		short s = 0;
		for (s = (short) (directory.length() - 2); s > 2; s--) {
			if (directory.charAt(s) == PLATFORM_slashType) {
				break;
			}
		}
		if (s > 2) {
			for (short s2 = 0; s2 < s; s2++) {
				newDirectory += directory.charAt(s2);
			}
		}
		else {
			return null;
		}
		
		return newDirectory;
	}
	
	
	public int return_foldersQuantityOfPathDividedBySlash(String path) {
		/*
		 * return_foldersQuantityOfPathDividedBySlash("/AA/bb/CC/dd/ee/")  returns '5'.
		 * return_foldersQuantityOfPathDividedBySlash("/AA/bb/CC/dd/ee.txt")  returns '5'.
		 */
		
		if (path == null || path.length() == 0) {
			return -2;
		}
		if (path.length() == 1 && path.charAt(0) == PLATFORM_slashType) {
			return 0;
		}
		
		int quantity = 1;
		for (int i1 = 1; i1 < path.length() - 2; i1++) {
			if (path.charAt(i1) == PLATFORM_slashType) {
				quantity++;
				i1++;
			}
		}
		
		return quantity;
	}
	
	
	public SmList_1D_String return_folderNamesOfPathDividedBySlash(String path) {
		if (path == null || path.length() == 0) {
			return null;
		}
		
		SmList_1D_String folders = new SmList_1D_String(SmList_Size.TINY_16);
		
		if (path.length() == 1 && path.charAt(0) == PLATFORM_slashType) {
			return folders;
		}
		
		String folderName = "";
		for (int i1 = 0; i1 < path.length(); i1++) {
			if (path.charAt(i1) == PLATFORM_slashType) {
				if (i1 != 0) {
					folders.addValue(folderName);
					folderName = "";
				}
			}
			else {
				folderName += path.charAt(i1);
			}
		}
		if (folderName.length() > 0) {
			folders.addValue(folderName);
		}
		
		return folders;
	}
	
	
	public String return_assemblePath(SmList_1D_String path_foldersList, boolean isFromRoot) {
		if (path_foldersList == null || path_foldersList.size() == 0) {
			return null;
		}
		
		String path_new = "";
		if (isFromRoot && PLATFORM_Os != PlatformOs.MSWINDOWS) {
			path_new += PLATFORM_slashType;
		}
		else {
			path_new += PLATFORM_slashType;
		}
		
		path_new += path_foldersList.getValue(0);
		for (int i1 = 1; i1 < path_foldersList.size(); i1++) {
			path_new += PLATFORM_slashType + path_foldersList.getValue(i1);
		}
		
		return path_new;
	}
	
	
	public String return_assemblePath(SmList_1D_String path_foldersList) {
		return return_assemblePath(path_foldersList, true);
	}
	
	
	public String return_changeDirectory_cutEnd(String directory, int cutQuantityFromEnd) {
		/*
		 * return_changeDirectory_cutEnd("AA/bb/CC/dd/ee", 2)  returns  "AA/bb/CC".
		 */
		if (directory == null || directory.length() < 3) {
			return null;
		}
		if (cutQuantityFromEnd == 0) {
			return directory;
		}
		if (cutQuantityFromEnd < 0) {
			return null;
		}
		
		String newDirectory = "";
		int slashCount = 0;
		for (int i1 = directory.length() - 2; i1 > 1; i1--) {
			if (directory.charAt(i1) == PLATFORM_slashType) {
				slashCount++;
				if (slashCount == cutQuantityFromEnd) {
					for (int i2 = 0; i2 <= i1; i2++) {
						newDirectory += directory.charAt(i2);
					}
					return newDirectory;
				}
			}
		}
		
		return null;
	}
	
	
	public String return_changeDirectory_cutEnd_keepBegin(String directory, int keepQuantityFromBegin) {
		/*
		 * return_changeDirectory_cutEnd_keepBegin("AA/bb/CC/dd/ee", 2)  returns  "AA/bb".
		 */
		if (directory == null || directory.length() < 3) {
			return null;
		}
		if (keepQuantityFromBegin == 0) {
			return directory;
		}
		if (keepQuantityFromBegin < 0) {
			return null;
		}
		
		String newDirectory = "";
		int slashCount = 0;
		for (int i1 = 0; i1 < directory.length(); i1++) {
			if (directory.charAt(i1) == PLATFORM_slashType && i1 > 1 && i1 < directory.length() - 1) {
				slashCount++;
				if (slashCount == keepQuantityFromBegin) {
					return newDirectory;
				}
			}
			newDirectory += directory.charAt(i1);
		}
		
		if (slashCount + 1 == keepQuantityFromBegin) {
			return directory;
		}
		
		return null;
	}
	
	
	public String return_changeDirectory_cutBegin(String directory, int cutQuantityFromBegin) {
		/*
		 * return_changeDirectory_cutBegin("AA/bb/CC/dd/ee", 2)  returns  "CC/dd/ee".
		 */
		if (directory == null || directory.length() < 3) {
			return null;
		}
		if (cutQuantityFromBegin == 0) {
			return directory;
		}
		if (cutQuantityFromBegin < 0) {
			return null;
		}
		
		String newDirectory = "";
		int slashCount = 0;
		for (int i1 = 1; i1 < directory.length() - 1; i1++) {
			if (directory.charAt(i1) == PLATFORM_slashType) {
				slashCount++;
				i1++;
				if (slashCount == cutQuantityFromBegin) {
					for (int i2 = i1; i2 < directory.length(); i2++) {
						newDirectory += directory.charAt(i2);
					}
					return newDirectory;
				}
			}
		}
		
		return null;
	}
	
	
	public String return_changeDirectory_cutBegin_keepEnd(String directory, int keepQuantityFromEnd) {
		/*
		 * return_changeDirectory_cutBegin_keepEnd("AA/bb/CC/dd/ee", 2)  returns  "dd/ee".
		 */
		if (directory == null || directory.length() < 3) {
			return null;
		}
		if (keepQuantityFromEnd == 0) {
			return "";
		}
		if (keepQuantityFromEnd < 0) {
			return null;
		}
		
		String newDirectory = "";
		int slashCount = 0;
		for (int i1 = directory.length() - 2; i1 > 0; i1--) {
			if (directory.charAt(i1) == PLATFORM_slashType) {
				slashCount++;
				if (slashCount == keepQuantityFromEnd) {
					for (int i2 = i1 + 1; i2 < directory.length(); i2++) {
						newDirectory += directory.charAt(i2);
					}
					return newDirectory;
				}
			}
		}
		
		if (slashCount + 1 == keepQuantityFromEnd) {
			return directory;
		}
		
		return null;
	}
	
	
	public String return_nameOfDirectory_fromBegin(String directory, int nameNumberFromBegin) {
		/*
		 * First name has number 0.
		 * return_nameFromDirectory_fromBegin("AA/bb/CC/dd/ee", 1) returns  "bb".
		 */
		String name = return_changeDirectory_cutEnd_keepBegin(directory, nameNumberFromBegin + 1);
		name = return_changeDirectory_cutBegin_keepEnd(name, 1);
		
		return name;
	}
	
	
	public String return_nameFromDirectory_fromEnd(String directory, int nameNumberFromEnd) {
		/*
		 * Last name has number 0.
		 * return_nameFromDirectory_fromEnd("AA/bb/CC/dd/ee", 1)  returns  "dd".
		 */
		String name = return_changeDirectory_cutBegin_keepEnd(directory, nameNumberFromEnd + 1);
		name = return_changeDirectory_cutEnd_keepBegin(name, 1);
		
		return name;
	}
	
	
	public String return_nameFromDirectory_last(String directory) {
		return return_changeDirectory_cutBegin_keepEnd(directory, 1);
	}
	
	
	/**
	 * Split file name to his extension and part before the extension.
	 * Controlled by the last dot in the file name. 
	 * But if the last character in the filename is a dot, it means there isn't file name extension.
	 */
	public FileNameAndExtensionDto return_FileNameAndExtensionDto(String fileName) {
		FileNameAndExtensionDto dto = new FileNameAndExtensionDto();
		
		// Find dot. 
		int lastDotIndex = -1;
		if (fileName.charAt(fileName.length() - 1) != 46) {  // 46 '.' dot.
			for (int i1 = fileName.length() - 2; i1 >= 0; i1--) {
				if (fileName.charAt(i1) == 46) {  // 46 '.' dot.
					lastDotIndex = i1;
					break;
				}
			}
		}
		if (lastDotIndex > 0 && lastDotIndex < fileName.length() - 1) {
			for (int i2 = 0; i2 < lastDotIndex; i2++) {
				dto.fileNameWithoutExtension += fileName.charAt(i2);
			}
			for (int i3 = lastDotIndex; i3 < fileName.length(); i3++) {
				dto.fileNameExtension += fileName.charAt(i3);
			}
		}
		else {
			dto.fileNameWithoutExtension = fileName;
		}
		
		return dto;
	}
	
	
	/**
	 * @param fileName - allowed to contain also directory.
	 * @return
	 */
	public String return_fileNameExtension(String fileName) {
		char character;
		for (int i1 = fileName.length() - 1; i1 >= 0 ; i1--) {
			character = fileName.charAt(i1);
			
			if (character == 46) {  // 46 '.' dot.
				String fileNameExtension = "";
				for (int i2 = i1; i2 < fileName.length(); i2++) {
					fileNameExtension += fileName.charAt(i2);
				}
				return fileNameExtension;
			}
			
			if (character == 47 || character == 92) {  // 47 '/' slash ; 92 '\' backslash.
				return null;
			}
		}
		
		return null;
	}
	
	
	// File name customize and/or with checking files on disk.
	
	public boolean is_existDirectoryOrFileInDirectory(String filePathAndName) {
		return (new File(filePathAndName)).exists();
	}
	
	
	public boolean is_existDirectoryOrFileInDirectory(String directory, String name) {
		return is_existDirectoryOrFileInDirectory(return_connectFileDirectoryAndName(directory, name));
	}
	
	
	public String return_checkExistSameFileNameAndReturnDifferent(String directory, String name) {
		/*
		 * 
		 */
		String addString = "__v";
		int maxNumberOfVersions = 200;
		
		if (directory == null || name == null || name.length() == 0) {
			return null;
		}
		
		// When full path do not exists.
		if (checkIfExistsFolderAndCreateIt(directory) || !is_existDirectoryOrFileInDirectory(directory, name)) {
			return name;
		}
		
		// Else edit file name.
		messageReceiver.message(MessageType.N11_INFO, 
				MessageList.assemblePlacement(this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName()), 
				"File name will be change because this already exists.", 
				directory + "  " + name);
		
		// Prepare parts of file name.
		FileNameAndExtensionDto nameDto = return_FileNameAndExtensionDto(name);
		
		// Create and check new versions.
		String fileName_v2 = "";
		int versionFile = 1;
		do {
			versionFile++;
			fileName_v2 = nameDto.fileNameWithoutExtension;
			fileName_v2 += addString;
			fileName_v2 += String.valueOf(versionFile);
			fileName_v2 += nameDto.fileNameExtension;
			
			if (versionFile > maxNumberOfVersions) {
				messageReceiver.message(MessageType.N2_ERROR, 
						MessageList.assemblePlacement(this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName()), 
						"Attempt to create versioned file name, reached max: " + maxNumberOfVersions + ".");
				return null;
			}
		} while (is_existDirectoryOrFileInDirectory(directory, fileName_v2));
		
		return fileName_v2;
	}
	
	
	public long return_fileSize(String directoryAndName) {
		if (directoryAndName == null) {
			return -2;
		}
		File fi = new File(directoryAndName);
		if (!fi.exists()) {
			return -3;
		}
		long fileLength = fi.length();
		
		return fileLength;
	}
	
	
	public long return_fileSize(String directory, String name) {
		String fileDirectoryAndName = return_connectFileDirectoryAndName(directory, name);
		
		return return_fileSize(fileDirectoryAndName);
	}
	
	
	public DirectoriesAndFiles return_fileSize(DirectoriesAndFiles fileList) {
		if (fileList == null || fileList.size() == 0) {
			return fileList;
		}
		
		for (int i1 = 0; i1 < fileList.size(); i1++) {
			DirectoriesAndFiles_Unit unit = fileList.get_directoryUnit(i1);
			if (unit.files == null) {
				continue;
			}
			for (int i2 = 0; i2 < unit.files.size(); i2++) {
				DirectoriesAndFiles_File directory = unit.files.getValue(i2);
				directory.file_size = return_fileSize(unit.directory, directory.file);
			}
		}
		
		return fileList;
	}
	
	
	public boolean checkIfExistsFolderAndCreateIt(String receiveDirectory) {
		File directory = new File(receiveDirectory);
		if (!directory.exists()) {
			directory.mkdirs();  // Prime version: directory.mkdir();
			// If you require to make the entire directory path including parents, use directory.mkdirs(); here instead.
			return true;  // Directory created.
		}
		
		return false;  // Already exists, not created.
	}
	
	
	// Changes at disk.
	
	public boolean renameFile(String primeFullPath, String newFullPath) {
		/*
		 * Rename file.
		 * and / or
		 * Move file to another directory.
		 */
		try {
			// Check exists path.
			checkIfExistsFolderAndCreateIt(return_directoryWithoutFileName_dividePath(newFullPath));
			
			// Rename file.
			File file_prime = new File(primeFullPath);
			File file_new = new File(newFullPath);
			if (file_prime.renameTo(file_new)) {
				return true;
			}
			else {
				return false;
			}
		}
		catch (Exception ex) {
			smLib.messageReceiver.message(MessageType.N1_FATAL, 
					MessageList.assemblePlacement(this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName()), 
					"Prime full path:  " + primeFullPath, 
					"Exception:  " + ex.toString());
			return false;
		}
	}
	
	
	public boolean renameFile(String fileName, String primeDirectory, String newdirectory) {
		/*
		 * Move file to another directory, with same file name.
		 */
		String primeDirectoryAndName = return_connectFileDirectoryAndName(primeDirectory, fileName);
		if (!is_existDirectoryOrFileInDirectory(primeDirectoryAndName)) {
			return false;
		}
		
		return renameFile(primeDirectoryAndName, return_connectFileDirectoryAndName(newdirectory, fileName));
	}

}
