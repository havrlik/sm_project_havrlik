package test.java.project.havrlik.soft.smlib.file;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import main.java.project.havrlik.soft.smlib.SmLib;
import main.java.project.havrlik.soft.smlib.file.FileDirectoryAndNameCustomize;
import main.java.project.havrlik.soft.smlib.file.FileNameAndExtensionDto;

public class FileDirectoryAndNameCustomize_Test {
	
	private SmLib smLib;
	private FileDirectoryAndNameCustomize fileDirectoryAndNameCustomize;
	
	
	FileDirectoryAndNameCustomize_Test() {
		smLib = new SmLib();
		fileDirectoryAndNameCustomize = smLib.fileDirectoryAndNameCustomize;
	}
	
	
	@Test
	void return_directoryWithoutFileName_dividePath() {
		String[] valuesNull = {
				null,
				"",
				"A/xxxxxxxx",
				"AA/",
		};
		for (int i1 = 0; i1 < valuesNull.length; i1++) {
			if (null != fileDirectoryAndNameCustomize.return_directoryWithoutFileName_dividePath(valuesNull[i1])) {
				fail("<" + valuesNull[i1] + "> should be performed as null, but is not.");
			}
		}
		
		String[][] values = {  // Columns: [0] expected result ; [1] value to perform ; 
				{"AA", "AA/bb"},
				{"AA", "AA/bb.txt"},
				{"AA", "AA/bb.x/"},
				{"AA/bb/CC/dd", "AA/bb/CC/dd/ee"},
				{"/AA/bb/CC/dd", "/AA/bb/CC/dd/ee/"},
		};
		for (int i2 = 0; i2 < values.length; i2++) {
			String result = fileDirectoryAndNameCustomize.return_directoryWithoutFileName_dividePath(values[i2][1]);
			if (!values[i2][0].equals(result)) {
				fail("<" + values[i2][0] + "> compareTo <" + result + ">");
			}
		}
	}
	
	
	@Test
	void return_foldersQuantityOfPathDividedBySlash() {
		String[][] values = {  // Columns: [0] expected result ; [1] value to perform ; 
				{"-2", null},
				{"-2", ""},
				
				{"1", "AA"},
				{"2", "AA/bb"},
				{"2", "AA/bb.x"},
				{"3", "AA/bb.x/cc"},
				{"5", "AA/bb/CC/dd/ee"},
				{"5", "/AA/bb/CC/dd/ee/"},
		};
		for (int i1 = 0; i1 < values.length; i1++) {
			int result = fileDirectoryAndNameCustomize.return_foldersQuantityOfPathDividedBySlash(values[i1][1]);
			if (Integer.parseInt(values[i1][0]) != result) {
				fail("<" + values[i1][0] + "> == <" + result + ">");
			}
		}
	}
	
	
	@Test
	void return_FileNameAndExtensionDto() {
		String[][] values = {  // Columns: [0] value to perform ; [1] first expected result ; [2] second expected result ; 
				{"aa.bb", "aa", ".bb"},
				{"aa.bb.cc", "aa.bb", ".cc"},
				{"aa", "aa", ""},
				{".aa", ".aa", ""},
				{"aa.", "aa.", ""},
		};
		for (int i1 = 0; i1 < values.length; i1++) {
			FileNameAndExtensionDto result = fileDirectoryAndNameCustomize.return_FileNameAndExtensionDto(values[i1][0]);
			if (values[i1][1].compareTo(result.fileNameWithoutExtension) != 0 || values[i1][2].compareTo(result.fileNameExtension) != 0) {
				fail("<" + values[i1][1] + "> compareTo <" + result.fileNameWithoutExtension + "> || "
						+ "<" + values[i1][2] + "> compareTo <" + result.fileNameExtension + ">");
			}
		}
	}

}
