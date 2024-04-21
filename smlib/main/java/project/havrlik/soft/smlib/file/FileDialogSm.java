package main.java.project.havrlik.soft.smlib.file;

import java.awt.FileDialog;
import java.io.File;
import java.io.FilenameFilter;

import javax.swing.JFrame;

import main.java.project.havrlik.soft.smlib.SmLib;
import main.java.project.havrlik.soft.smlib.message.MessageList;
import main.java.project.havrlik.soft.smlib.smlist.SmList_1D_Gnrc;


public class FileDialogSm {
	
	protected SmLib smLib;
	
	protected FileChooserSm fileChooserSm;
	
	protected DirectoriesAndFiles dirsAndFiles_LowerDirs;
	public final int RECURSIONDEPTH = 20;  // '1' means get only desired directory.
	protected int recursionDepth_private = RECURSIONDEPTH;
	public final boolean FETCHFOLDERS = false;
	protected boolean fetchFolders_private = FETCHFOLDERS;
	protected boolean recursionAllowedDepthExceeded = false;
	
	
	public FileDialogSm(SmLib smLib) {
		this.smLib = smLib;
		fileChooserSm = new FileChooserSm(smLib);
		
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
	
	
	public void setup1() {  }
	public void setup2_sub() {  }
	public void setup3() {  }
	public void setup4_sub() {  }
	
	
	public DirectoriesAndFiles fileDialog_save_chooseDirectoryAndFileName(String fromDirectory, String fileExtension) {
		dirsAndFiles_LowerDirs = null;
		JFrame frame = new JFrame("Save - Choose a file directory and name");
		FileDialog fd = new FileDialog(frame, "Choose a file directory and name", FileDialog.SAVE);

		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		if (fromDirectory != null) {
			fd.setDirectory(fromDirectory);
		}
		else if (smLib.introduction.customValues.defaultWorkspaceDirectory != null) {
			fd.setDirectory(smLib.introduction.customValues.defaultWorkspaceDirectory);
		}
		if (fileExtension != null) {
			fd.setFile("*" + fileExtension);
		}
		/*fd.setFilenameFilter(new FilenameFilter() {
		    @Override
		    public boolean accept(File dir, String name) {
		        return name.endsWith(save_fileExtensions);
		    }
		});*/
		//fd.setFilenameFilter((dir, name) -> name.endsWith(save_fileExtensions);
		fd.setVisible(true);
		
		String filePath = fd.getDirectory();
		String fileName = fd.getFile();
		//File[] items = fd.getFiles();
		
		if (filePath == null) {
			// System.out.println("You cancelled the choice");
			return null;
		}
		else {
			// System.out.println("You chose " + fileName);
			fileName = return_addFileExtensionToFileName(fileName, fileExtension);
			DirectoriesAndFiles directoriesAndFiles = new DirectoriesAndFiles();
			directoriesAndFiles.add(filePath, null, fileName);
			return directoriesAndFiles;
		}
	}
	
	
	public DirectoriesAndFiles fileDialog_load_oneFile(String fromDirectory, String fileExtension) {
		dirsAndFiles_LowerDirs = null;
		JFrame frame = new JFrame("Load - Choose one file");
		FileDialog fd = new FileDialog(frame, "Choose one file", FileDialog.LOAD);

		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		fd.setMultipleMode(false);
		if (fromDirectory != null) {
			fd.setDirectory(fromDirectory);
		}
		else if (smLib.introduction.customValues.defaultWorkspaceDirectory != null) {
			fd.setDirectory(smLib.introduction.customValues.defaultWorkspaceDirectory);
		}
		if (fileExtension != null) {
			fd.setFile("*" + fileExtension);
		}
		/*fd.setFilenameFilter(new FilenameFilter() {
		    @Override
		    public boolean accept(File dir, String name) {
		        return name.endsWith(load_fileExtension);
		    }
		});*/
		//fd.setFilenameFilter((dir, name) -> name.endsWith(load_fileExtension);
		fd.setVisible(true);
		
		String filePath = fd.getDirectory();
		String fileName = fd.getFile();
		
		if (filePath == null) {
			// System.out.println("You cancelled the choice");
			return null;
		}
		else {
			// System.out.println("You chose " + save_name);
//			System.out.println(filePath);
//			System.out.println(fileName);
			DirectoriesAndFiles directoriesAndFiles = new DirectoriesAndFiles();
			directoriesAndFiles.add(filePath, null, fileName);
			return directoriesAndFiles;
		}
	}
	
	
	public DirectoriesAndFiles fileDialog_load_oneFile(String fromDirectory) {
		return fileDialog_load_oneFile(fromDirectory, null);
	}
	
	
	public DirectoriesAndFiles fileDialog_load_multipleFiles(String fromDirectory, String fileExtension) {
		dirsAndFiles_LowerDirs = null;
		JFrame frame = new JFrame("Load - Choose multiple files");
		FileDialog fd = new FileDialog(frame, "Choose multiple files", FileDialog.LOAD);

		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		fd.setMultipleMode(true);
		if (fromDirectory != null) {
			fd.setDirectory(fromDirectory);
		}
		else if (smLib.introduction.customValues.defaultWorkspaceDirectory != null) {
			fd.setDirectory(smLib.introduction.customValues.defaultWorkspaceDirectory);
		}
		if (fileExtension != null) {
			fd.setFile("*" + fileExtension);
		}
		/*fd.setFilenameFilter(new FilenameFilter() {
		    @Override
		    public boolean accept(File dir, String name) {
		        return name.endsWith(load_fileExtension);
		    }
		});*/
		//fd.setFilenameFilter((dir, name) -> name.endsWith(load_fileExtension);
		fd.setVisible(true);
		
		String filePath = fd.getDirectory();
		File[] items = fd.getFiles();
		
		if (filePath == null) {
			// System.out.println("You cancelled the choice");
			return null;
		}
		else {
			// System.out.println("You chose " + save_name);
			SmList_1D_Gnrc<DirectoriesAndFiles_File> list = new SmList_1D_Gnrc<DirectoriesAndFiles_File>();
			for (int i = 0; i < items.length; i++) {
				list.addValue(new DirectoriesAndFiles_File(items[i].getName()));
			}
			DirectoriesAndFiles directoriesAndFiles = new DirectoriesAndFiles();
			directoriesAndFiles.add(filePath, null, list);
			return directoriesAndFiles;
		}
	}
	
	
	public DirectoriesAndFiles fileChooser_chooseDirectory(String fromDirectory) {
		dirsAndFiles_LowerDirs = null;
		DirectoriesAndFiles directoriesAndFiles = null;
		
		String dir = fileChooserSm.jFileChooser_chooseDirectory(fromDirectory);
		
		if (dir == null) {
			return directoriesAndFiles;
		}
		
		directoriesAndFiles = new DirectoriesAndFiles();
		directoriesAndFiles.add(dir, (String) null, (String) null);
		return directoriesAndFiles;
	}
	
	
	public DirectoriesAndFiles fileChooser_chooseDirectory() {
		return fileChooser_chooseDirectory(null);
	}
	
	
	public DirectoriesAndFiles fileChooser_chooseDirectoryAndReturnAllFilesInsideThisDirectory(String fromDirectory, String fileExtension) {
		dirsAndFiles_LowerDirs = null;
		
		String dir = fileChooserSm.jFileChooser_chooseDirectory(fromDirectory);
		
		if (dir == null) {
			dirsAndFiles_LowerDirs = null;
			return dirsAndFiles_LowerDirs;
		}
		
		DirectoriesAndFiles directoriesAndFiles = returnAllFilesInDirectory(dir, fileExtension);
		
		return directoriesAndFiles;
	}
	
	
	public DirectoriesAndFiles fileChooser_chooseDirectoryAndReturnAllFilesInsideThisDirectory(String fromDirectory) {
		return fileChooser_chooseDirectoryAndReturnAllFilesInsideThisDirectory(fromDirectory, null);
	}
	
	
	public DirectoriesAndFiles fileChooser_chooseDirectoryAndReturnAllFilesInsideThisAndLowerDirectories(String fromDirectory, String fileExtension) {
		dirsAndFiles_LowerDirs = null;
		String dir = fileChooserSm.jFileChooser_chooseDirectory(fromDirectory);
		
		if (dir == null) {
			return dirsAndFiles_LowerDirs;
		}
		
		return_allFilesInsideThisAndLowerDirectories(dir, fileExtension);
		
		return dirsAndFiles_LowerDirs;
	}
	
	
	public DirectoriesAndFiles returnAllFilesInDirectory(String fromDirectory, String fileExtension) {
		dirsAndFiles_LowerDirs = null;
		
		DirectoriesAndFiles directoriesAndFiles = new DirectoriesAndFiles();
		directoriesAndFiles.add(returnAllFilesInDirectory_private(fromDirectory, false, true, fileExtension));
		
		return directoriesAndFiles;
	}
	
	
	private DirectoriesAndFiles_Unit returnAllFilesInDirectory_private(
			String fromDirectory, boolean loadFolders, boolean loadFiles, String fileExtension) {
		if (fromDirectory == null) {
			return null;
		}
		
		DirectoriesAndFiles_Unit unit = new DirectoriesAndFiles_Unit();
			
		File dir = new File(fromDirectory);
		File[] files;
		files = dir.listFiles();
		
		unit.putDirectory(dir.getAbsolutePath());  // Origin directory.
		
		if (files == null || files.length == 0) {
			return unit;
		}
		
		// Folders in directory.
		if (loadFolders) {
			for (int i1 = 0; i1 < files.length; i1++) {
				if (!files[i1].isFile()) {  // isDirectory().
					unit.addFolder(files[i1].getName());
				}
			}
		}
		
		// Files in directory.
		if (loadFiles) {
			// If filter by file end, then rewrite 'items'.
			if (fileExtension != null && fileExtension.length() > 0) {
				// https://stackoverflow.com/questions/8921987/how-to-get-all-text-files-from-one-folder-using-java
				FilenameFilter textFilter = new FilenameFilter() {
					@Override
					public boolean accept(File dir, String name) {
						return name.toLowerCase().endsWith(fileExtension.toLowerCase());
					}
				};
				files = dir.listFiles(textFilter);
			}
			for (int i2 = 0; i2 < files.length; i2++) {
				if (files[i2].isFile()) {
					unit.addFile(files[i2].getName());
				}
			}
		}
		
		return unit;
	}
	
	
	public DirectoriesAndFiles returnAllFoldersInDirectory(String fromDirectory) {
		dirsAndFiles_LowerDirs = null;
		
		DirectoriesAndFiles directoriesAndFiles = new DirectoriesAndFiles();
		directoriesAndFiles.add(returnAllFilesInDirectory_private(fromDirectory, true, false, null));
		
		return directoriesAndFiles;
	}
	
	
	public DirectoriesAndFiles return_allFilesInsideThisAndLowerDirectories(
			String fromDirectory, boolean fetchFoldersInDirectory, String fileExtension, int recursionDepth
	) {
		dirsAndFiles_LowerDirs = new DirectoriesAndFiles();
		
		if (fromDirectory == null) {
			return null;
		}
		
		this.fetchFolders_private = fetchFoldersInDirectory;
		if (recursionDepth >= 0) {
			this.recursionDepth_private = recursionDepth;
		}
		recursionAllowedDepthExceeded = false;
		
		recursionLowerDirectories(fromDirectory, fileExtension, 1);
		
		if (recursionAllowedDepthExceeded) {
			smLib.messageReceiver.n4_warn(
					MessageList.assemblePlacement(this.getClass(), ""), 
					"'recursionAllowedDepthExceeded = false'."
			);
		}
		
		// After, set default values here.
		this.fetchFolders_private = FETCHFOLDERS;
		this.recursionDepth_private = RECURSIONDEPTH;
		// this.recursionAllowedDepthExceeded = false;  // Advice: check and set manually defalut value.
		
		return dirsAndFiles_LowerDirs;
	}
	
	
	public DirectoriesAndFiles return_allFilesInsideThisAndLowerDirectories(String fromDirectory, String fileExtension) {
		return return_allFilesInsideThisAndLowerDirectories(fromDirectory, FETCHFOLDERS, fileExtension, RECURSIONDEPTH);
	}
	
	
	public DirectoriesAndFiles return_allFilesInsideThisAndLowerDirectories(
			String fromDirectory, boolean fetchFoldersInDirectory, String fileExtension, int recursionDepth, boolean sort
	) {
		DirectoriesAndFiles dirsAndFiles = return_allFilesInsideThisAndLowerDirectories(
				fromDirectory, fetchFoldersInDirectory, fileExtension, recursionDepth);
		
		if (sort) {
			FileListCustomize.sortAsc_insertion(dirsAndFiles);
		}
		
		return dirsAndFiles;
	}
	
	
	private void recursionLowerDirectories(String fromDirectory, String fileExtension, int recursionLevel) {
		/*
		 * Take all folders and files inside received directory and lower directories.
		 */
		if (recursionLevel > recursionDepth_private) {
			recursionAllowedDepthExceeded = true;
			return;
		}
		recursionLevel++;
		if (fromDirectory != null) {
			
			DirectoriesAndFiles_Unit unit = returnAllFilesInDirectory_private(fromDirectory, true, true, fileExtension);
			dirsAndFiles_LowerDirs.add(unit);
			
			if (unit.folders != null) {
				for (int i1 = 0; i1 < unit.folders.size(); i1++) {
					recursionLowerDirectories(
							smLib.fileDirectoryAndNameCustomize.return_connectFileDirectoryAndName(unit.directory, unit.folders.getValue(i1)), 
							fileExtension, recursionLevel);
				}
			}
			
			if (!fetchFolders_private) {
				unit.folders = null;
			}
		}
	}
	
	
	public String return_addFileExtensionToFileName(String fileName, String fileExtension) {
		// Receive file name or file directory and name, and file extension.
		// Check if contain file end or not, add file end.
		if (fileName == null || fileExtension == null) {
			return null;
		}
		String newFileName = "";
		for (short s1 = (short) (fileName.length() - 1); s1 > 0; s1--) {
			if (fileName.charAt(s1) == '.') {
				for (short s2 = 0; s2 < s1; s2++) {
					newFileName += fileName.charAt(s2);
				}
				newFileName += fileExtension;
				break;
			}
			if (fileName.charAt(s1) == '/' || fileName.charAt(s1) == '\\' || s1 == 1) {
				newFileName = fileName + fileExtension;
				break;
			}
		}
		
		return newFileName;
	}
	
	
	public boolean get_recursionAllowedDepthExceeded() { return recursionAllowedDepthExceeded; }
	public void setDefault_recursionAllowedDepthExceeded() { recursionAllowedDepthExceeded = false; }

}
