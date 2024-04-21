package main.java.project.havrlik.soft.smlib.file;

import main.java.project.havrlik.soft.smlib.SmLib;
import main.java.project.havrlik.soft.smlib.introduction.PlatformOs;
import main.java.project.havrlik.soft.smlib.message.MessageReceiver;
import main.java.project.havrlik.soft.smlib.smlist.SmList_1D_String;

public class FileDirectoryAndNameCheck {
	
	protected SmLib smLib;
	protected MessageReceiver messageReceiver;
	
	protected PlatformOs PLATFORM_Os;
	protected char PLATFORM_slashType;
	
	
	// OS or filesystem rules:
	final char[] forbiddenCharacters = {  // Mostly Windows.
			'/',  // Linux/Unix, Windows.
			'\\',  // Windows.
			'<',  // (less than).
			'>',  // (greater than).
			':',  // (colon - sometimes works, but is actually NTFS Alternate Data Streams).
			'"',  // (double quote).
			'|',  // (vertical bar or pipe).
			'?',  // (question mark).
			'*',  // (asterisk).
	};
	final int characterBiggerOrEqual = 0;  //  Windows (ASCII control characters), Linux only '0' (NULL byte).
	final int characterSmallerOrEqual = 31;  //  Windows (ASCII control characters).
	final char character_space = ' ';  // Filename cannot end in space. *Beginning check include rather too.  // Windows.
	final char character_dot = '.';  // Filename cannot end in dot.  // Windows.
	// MacOS - depending on context: ':', '/'.
	final String[] forbiddenFilenames = {  // Windows. Filenames reserved both on their own and with arbitrary file extensions, e.g. 'LPT1.txt'. Lowercased letters too.
			"CON",
			"PRN", 
			"AUX",
			"NUL",
			"COM1", "COM2", "COM3", "COM4", "COM5", "COM6", "COM7", "COM8", "COM9",
			"LPT1", "LPT2", "LPT3", "LPT4", "LPT5", "LPT6", "LPT7", "LPT8", "LPT9",
	};
	
	// My additional rules:
	final int directory_lengthMin = 1;
	final int directory_lengthMax = 5_000;  // > 30 000 unicode characters, with each path component no more than 255 characters.
	final int filename_lengthMin = 1;
	final int filename_lengthMax = 127;  // 255 unicode characters.
	final char namesPatternBegin_dot = '.';
	final char namesPatternBegin_dollar = '$';
	// Filename begin in 'space'.
	final String[] restrictedFilenames = {
			"thumbs.db",  // "Thumbs.db".
			"desktop.ini",
			".ds_store",  // Apple file: ".DS_Store".
			
			"folder.jpg",  // Audio albums. Included "Folder.jpg". To-do Is needed also another filename extensions?
			// "AlbumArt ... .jpg"  // Audio albums. Really wanted ??
	};
	
	
	public FileDirectoryAndNameCheck(SmLib smLib) {
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
	
	
	public String check_filename(String name) {
		// General check.
		if (name == null) {
			return "name == null";
		}
		if (name.length() == 0) {
			return "name.length() == 0";
		}
		
		// Forbidden characters.
		for (int i1 = 0; i1 < name.length(); i1++) {
			for (int i2 = 0; i2 < forbiddenCharacters.length; i2++) {
				if (name.charAt(i1) == forbiddenCharacters[i2]) {
					return "name.charAt(i1) == forbiddenCharacters[i2]";
				}
			}
			if (name.charAt(i1) >= characterBiggerOrEqual && name.charAt(i1) <= characterSmallerOrEqual) {
				return "name.charAt(i1) >= characterBiggerOrEqual && name.charAt(i1) <= characterSmallerOrEqual";
			}
		}
		if (name.charAt(0) == character_space) {
			return "name.charAt(0) == character_space";
		}
		if (
				name.charAt(name.length() - 1) == character_space || 
				name.charAt(name.length() - 1) == character_dot
		) {
			return "name.charAt(name.length() - 1) == character_space || "
					+ "name.charAt(name.length() - 1) == character_dot";				
		}
		
		// Forbidden filenames.
		for (int j1 = 0; j1 < forbiddenFilenames.length; j1++) {
			String name_uppercased = name.toUpperCase();
			String name_uppercasedWithoutExtension = 
					smLib.fileDirectoryAndNameCustomize.return_FileNameAndExtensionDto(name_uppercased).fileNameWithoutExtension;
			
			if (forbiddenFilenames[j1].equals(name_uppercased) || 
					forbiddenFilenames[j1].equals(name_uppercasedWithoutExtension)) {
				return "forbiddenFilenames[j1].equals(name_uppercased) || "
						+ "forbiddenFilenames[j1].equals(name_uppercasedWithoutExtension)";
			}
		}
		
		return null;
	}
	
	
	public String check_filename_pattern(String name) {
		// Length.
		if (name.length() < filename_lengthMin) {
			return "name.length() < filename_lengthMin";
		}
		if (name.length() > filename_lengthMax) {
			return "name.length() > filename_lengthMax";
		}
		
		// First character.
		if (
				name.charAt(0) == namesPatternBegin_dot || 
				name.charAt(0) == namesPatternBegin_dollar
		) {
			return "name.charAt(0) == namesPatternBegin_dot || "
					+ "name.charAt(0) == namesPatternBegin_dollar";
		}
		
		// Restricted names.
		for (int i1 = 0; i1 < restrictedFilenames.length; i1++) {
			String name_lowercased = name.toLowerCase();
			
			if (restrictedFilenames[i1].equals(name_lowercased)) {
				return "restrictedFilenames[i1].equals(name_lowercased)";
			}
		}
		
		return null;
	}
	
	
	public String check_filename_all(String name) {
		String issue = null;
		
		issue = check_filename(name);
		if (issue != null) {
			return issue;
		}
		issue = check_filename_pattern(name);
		if (issue != null) {
			return issue;
		}
		
		return issue;
	}
	
	
	public boolean check_filename_allOk(String name) {
		return check_filename_all(name) == null ? true : false;
	}
	
	
	public String check_directory(String directory) {
		/*
		 * *Not tested yet.
		 * Works on Linux (specifically used method of "each folder name").
		 */
		
		// General check.
		if (directory == null) {
			return "directory == null";
		}
		if (directory.length() == 0) {
			return "directory.length() == 0";
		}
		
		// Each folder name. Use the same check as for filename.
		SmList_1D_String folders = smLib.fileDirectoryAndNameCustomize.return_folderNamesOfPathDividedBySlash(directory);
		if (folders == null || folders.size() == 0) {
			return "folders == null || folders.size() == 0";
		}
		for (int j1 = 0; j1 < folders.size(); j1++) {
			String result = check_filename(folders.getValue(j1));
			if (result != null) {
				return "folder: " + result;
			}
		}
		
		return null;
	}
	
	
	public String check_directory_pattern(String directory) {
		/*
		 * *Not tested yet.
		 * Works on Linux (specifically used method of "each folder name").
		 */
		
		// Length.
		if (directory.length() < directory_lengthMin) {
			return "directory.length() < directory_lengthMin";
		}
		if (directory.length() > directory_lengthMax) {
			return "directory.length() > directory_lengthMax";
		}
		
		// Each folder name. Use the same check as for filename.
		SmList_1D_String folders = smLib.fileDirectoryAndNameCustomize.return_folderNamesOfPathDividedBySlash(directory);
		if (folders == null || folders.size() == 0) {
			return "folders == null || folders.size() == 0";
		}
		for (int j1 = 0; j1 < folders.size(); j1++) {
			String result = check_filename_pattern(folders.getValue(j1));
			if (result != null) {
				return "folder: " + result;
			}
		}
		
		return null;
	}
	
	
	public String check_directory_all(String name) {
		String issue = null;
		
		issue = check_directory(name);
		if (issue != null) {
			return issue;
		}
		issue = check_directory_pattern(name);
		if (issue != null) {
			return issue;
		}
		
		return issue;
	}
	
	
	public boolean check_directory_allOk(String name) {
		return check_filename_all(name) == null ? true : false;
	}

}
