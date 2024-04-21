package main.java.project.havrlik.soft.smlib.file;

import main.java.project.havrlik.soft.smlib.SmLib;
import main.java.project.havrlik.soft.smlib.message.MessageList;
import main.java.project.havrlik.soft.smlib.message.MessageReceiver;
import main.java.project.havrlik.soft.smlib.message.MessageType;
import main.java.project.havrlik.soft.smlib.smlist.SmList_1D_Gnrc;
import main.java.project.havrlik.soft.smlib.smlist.SmList_2D_String;
import main.java.project.havrlik.soft.smlib.smlist.SmList_Sort;

public class FileListCustomize {

	protected SmLib smLib;
	protected MessageReceiver messageReceiver;
	protected FileDirectoryAndNameCustomize fileDirectoryAndNameCustomize;
	
	protected final String[] TEMPLATE_emptyRow_1 = new String[] {"-", "<empty>"};
	
	
	public FileListCustomize(SmLib smLib) {
		this.smLib = smLib;
		messageReceiver = smLib.messageReceiver;
		fileDirectoryAndNameCustomize = smLib.fileDirectoryAndNameCustomize;
		
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
	
	
	/**
	 * Sort directory units by directory.
	 * Sort folders in each unit.
	 * Sort files in each unit.
	 * 
	 * Insertion sorting.
	 * Strings are compared lexicographically. The comparison is based on the Unicode value of each character in the strings.
	 */
	public static void sortAsc_insertion(DirectoriesAndFiles dirsAndFiles) {
		SmList_1D_Gnrc<DirectoriesAndFiles_Unit> lisrDirs = dirsAndFiles.get_list();
		
		// Sort units / directories.
		for (int i1 = 1; i1 < lisrDirs.size(); i1++) {
			int i2 = i1 - 1;
			if (lisrDirs.getValue(i1).directory.compareTo(lisrDirs.getValue(i2).directory) < 0) {
				do {
					i2 -= 1;
				} while (i2 > -1 && lisrDirs.getValue(i1).directory.compareTo(lisrDirs.getValue(i2).directory) < 0);
				i2 += 1;
				
				
				// Value at index i1 insert to index i2, other values between (with i2) move.
				
				DirectoriesAndFiles_Unit tempValue = lisrDirs.getValue(i1);
				
				int moveSize = i1 - i2;
				if (moveSize > 0) {
					for (int j1 = i1; j1 > i2; j1--) {
						
						lisrDirs.putValue(j1, lisrDirs.getValue(j1 - 1));
						
					}
				}
				else if (moveSize < 0) {
					for (int j1 = i1; j1 < i2; j1++) {
						
						lisrDirs.putValue(j1, lisrDirs.getValue(j1 + 1));
						
					}
				}
				
				lisrDirs.putValue(i2, tempValue);
				
			}
		}
		
		// Sort files in each directory.
		for (int k1 = 0; k1 < lisrDirs.size(); k1++) {
			sortAsc_insertion(lisrDirs.getValue(k1));
		}
	}
	
	
	/**
	 * Sort folders and files (by file name) in directory unit.
	 */
	public static void sortAsc_insertion(DirectoriesAndFiles_Unit directoryUnit) {
		if (directoryUnit.folders != null && directoryUnit.folders.size() >= 0) {
			SmList_Sort.sortAsc_insertion(directoryUnit.folders);
		}
		
		if (directoryUnit.files != null && directoryUnit.files.size() >= 0) {
			sortAsc_insertion(directoryUnit.files);
		}
	}
	
	
	private static void sortAsc_insertion(SmList_1D_Gnrc<DirectoriesAndFiles_File> files) {
		for (int i1 = 1; i1 < files.size(); i1++) {
			int i2 = i1 - 1;
			if (files.getValue(i1).file.compareTo(files.getValue(i2).file) < 0) {
				do {
					i2 -= 1;
				} while (i2 > -1 && files.getValue(i1).file.compareTo(files.getValue(i2).file) < 0);
				i2 += 1;
				
				
				// Value at index i1 insert to index i2, other values between (with i2) move.
				
				DirectoriesAndFiles_File tempValue = files.getValue(i1);
				
				int moveSize = i1 - i2;
				if (moveSize > 0) {
					for (int j1 = i1; j1 > i2; j1--) {
						
						files.putValue(j1, files.getValue(j1 - 1));
						
					}
				}
				else if (moveSize < 0) {
					for (int j1 = i1; j1 < i2; j1++) {
						
						files.putValue(j1, files.getValue(j1 + 1));
						
					}
				}
				
				files.putValue(i2, tempValue);
				
			}
		}
	}
	
	
	/**
	 * 'input_fileList': list with file names.
	 * Return rowsTable: file names inserted to second column, theirs directory inserted to first column. 
	 * Other columns are empty.
	 */
	public String[][] return_array2D_fileListCollection(DirectoriesAndFiles input_fileList, int output_columnsQuantity, boolean isLinesColumn) {
		if (isLinesColumn && output_columnsQuantity < 3 || !isLinesColumn && output_columnsQuantity < 2) {
			return null;
		}
		String[][] list_table = null;
		int columnDirectories = isLinesColumn ? 1 : 0;
		int columnFiles = columnDirectories + 1;
		
		if (input_fileList == null || input_fileList.size() == 0) {
			list_table = return_fileList_insertEmptyRow(output_columnsQuantity);
			smLib.messageReceiver.message(MessageType.N1_FATAL, 
					MessageList.assemblePlacement(this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName()), 
					"Received array with filelist = null");
			return list_table;
		}
		else {
			try {
				int filesSum = 0;
				for (int i = 0; i < input_fileList.size(); i++) {
					if (input_fileList.get_directoryUnit(i) != null && 
							input_fileList.get_directoryUnit(i).files != null && 
							input_fileList.get_directoryUnit(i).files.size() > 0) {
						filesSum += input_fileList.get_directoryUnit(i).files.size();
					}
				}
				if (filesSum == 0) {
					list_table = return_fileList_insertEmptyRow(output_columnsQuantity);
					return list_table;
				}
				list_table = new String[filesSum][output_columnsQuantity];
				int rowsTableP4_row = 0;
				for (int i = 0; i < input_fileList.size(); i++) {
					DirectoriesAndFiles_Unit folder = input_fileList.get_directoryUnit(i);
					if (folder.files == null) {
						continue;
					}
					for (int i2 = 0; i2 < folder.files.size(); i2++) {
						if (isLinesColumn) {
							list_table[rowsTableP4_row][0] = Integer.toString(rowsTableP4_row + 1);
						}
						list_table[rowsTableP4_row][columnDirectories] = fileDirectoryAndNameCustomize.return_directoryWithoutLastSlash(
								folder.directory);
						list_table[rowsTableP4_row][columnFiles] = folder.files.getValue(i2).file;
						for (int j1 = columnFiles + 1; j1 < output_columnsQuantity; j1++) {
							list_table[rowsTableP4_row][j1] = "";
						}
						rowsTableP4_row++;
					}
				}
			}
			catch (ArrayIndexOutOfBoundsException e) {
				smLib.messageReceiver.message(MessageType.N1_FATAL, 
						MessageList.assemblePlacement(this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName()), 
						"ArrayIndexOutOfBoundsException:  " + e.toString());
				return list_table;
			}
		}
		
		return list_table;
	}
	
	
	public String[][] return_array2D_fileListCollection(DirectoriesAndFiles input_fileList, int output_columnsQuantity) {
		return return_array2D_fileListCollection(input_fileList, output_columnsQuantity, false);
	}
	
	
	private String[][] return_fileList_insertEmptyRow(int output_columnsQuantity) {
		String[][] list_table = new String[1][output_columnsQuantity];
		list_table[0][0] = TEMPLATE_emptyRow_1[0];
		list_table[0][1] = TEMPLATE_emptyRow_1[1];
		for (int j1 = 2; j1 < output_columnsQuantity; j1++) {
			list_table[0][j1] = "";
		}
		
		return list_table;
	}
	
	
	public String[][] return_2DArray(SmList_2D_String input_list, int output_columnsQuantity) {
		String[][] output_array = new String[input_list.size()][output_columnsQuantity];
		int useInputColumns = input_list.get_columnsQuantity();
		if (useInputColumns > output_columnsQuantity) {
			useInputColumns = output_columnsQuantity;
		}
		
		for (int i1 = 0; i1 < input_list.size(); i1++) {
			// Copy values from input_list.
			for (int columnNum = 0; columnNum < useInputColumns; columnNum++) {
				output_array[i1][columnNum] = input_list.getValue(i1, columnNum);
			}
			// Insert empty string to extra columns.
			for (int columnNum_empty = useInputColumns; columnNum_empty < output_columnsQuantity; columnNum_empty++) {
				output_array[i1][columnNum_empty] = "";
			}
		}
		
		return output_array;
	}

}
