package test.java.project.havrlik.soft.smlib.file;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import main.java.project.havrlik.soft.smlib.SmLib;
import main.java.project.havrlik.soft.smlib.file.FileDirectoryAndNameCheck;

public class FileDirectoryAndNameCheck_Test {
	
	private SmLib smLib;
	private FileDirectoryAndNameCheck fileDirectoryAndNameCheck;
	
	
	FileDirectoryAndNameCheck_Test() {
		smLib = new SmLib();
		fileDirectoryAndNameCheck = smLib.fileDirectoryAndNameCheck;
	}
	
	
	@Test
	void check_filename_allOk() {
		// Just a few cases - copied from previous version.
		
		assertEquals(true, fileDirectoryAndNameCheck.check_filename_allOk("abCD12"));
		assertEquals(true, fileDirectoryAndNameCheck.check_filename_allOk("abCD12.txtzz"));
		assertEquals(true, fileDirectoryAndNameCheck.check_filename_allOk("a-b_c^d^^e"));
		
		assertEquals(false, fileDirectoryAndNameCheck.check_filename_allOk(""));
		
		assertEquals(false, fileDirectoryAndNameCheck.check_filename_allOk("a\\b"));
		assertEquals(false, fileDirectoryAndNameCheck.check_filename_allOk("a/b"));
		assertEquals(false, fileDirectoryAndNameCheck.check_filename_allOk("a*b"));
		assertEquals(false, fileDirectoryAndNameCheck.check_filename_allOk("a|b"));
		assertEquals(false, fileDirectoryAndNameCheck.check_filename_allOk("a|b"));
		assertEquals(false, fileDirectoryAndNameCheck.check_filename_allOk("a<>?b"));
		assertEquals(false, fileDirectoryAndNameCheck.check_filename_allOk("\\\\aa"));
		assertEquals(false, fileDirectoryAndNameCheck.check_filename_allOk("bb\\\\"));
		
		assertEquals(false, fileDirectoryAndNameCheck.check_filename_allOk("\\/:*\"<>|?"));
	}

}
