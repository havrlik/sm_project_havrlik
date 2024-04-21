package test.java.project.havrlik.soft.smlib.smlist;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import main.java.project.havrlik.soft.smlib.smlist.SmList_Size;
import main.java.project.havrlik.soft.smlib.smlist.SmList_SizesStore;
import main.java.project.havrlik.soft.smlib.smlist.SmList_SizesStores;
import main.java.project.havrlik.soft.smlib.smlist.SmList_Util;

public class SmList_Util_Test {
	
	private SmList_Util smList_Util;
	
	
	SmList_Util_Test() {
		smList_Util = new SmList_Util();
	}
	
	
	@Test
	void return_SMListSize_allowedOnly() {
		assertEquals(SmList_Size.DEFAULT_128, smList_Util.return_SmListSize_allowedOnly(SmList_Size.DEFAULT_128.toString()));
		assertNull(smList_Util.return_SmListSize_allowedOnly(null));
		assertNull(smList_Util.return_SmListSize_allowedOnly("random string 1234--++ CuteJava  :)  "));
	}
	
	
	@Test
	void return_predefinedArraySizes() {
		SmList_SizesStore[] predefinedSizes = (new SmList_SizesStores()).LIST_predefinedArraySizes;
		
		assertNull(smList_Util.return_predefinedArraySizes(null));
		
		SmList_SizesStore test2 = smList_Util.return_predefinedArraySizes(SmList_Size.TEST_7);
		assertEquals(predefinedSizes[10].get_listName(), test2.get_listName());
		
		SmList_SizesStore test3 = smList_Util.return_predefinedArraySizes(SmList_Size.DEFAULT_128);
		assertEquals(predefinedSizes[0].get_listName(), test3.get_listName());
	}

}
