package test.java.project.havrlik.soft.smlib.smlist;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import main.java.project.havrlik.soft.smlib.smlist.SmList_SizesStore;
import main.java.project.havrlik.soft.smlib.smlist.SmList_SizesStores;

public class SmList_SizesStores_Test {
	
	private SmList_SizesStores smList_SizesStores;
	
	
	SmList_SizesStores_Test() {
		smList_SizesStores = new SmList_SizesStores();
	}
	
	
	@Test
	void testSumOfPredefinedSizes() {
		SmList_SizesStore store;
		for (int i1 = 0; i1 < smList_SizesStores.LIST_predefinedArraySizes.length; i1++) {
			store = smList_SizesStores.LIST_predefinedArraySizes[i1];
			assertNotNull(store.get_listNo());
			assertEquals(true, store.get_listNo().length() > 0);
			assertNotNull(store.get_listName());
			assertEquals(true, store.get_MAXSIZE() > 0);
			
			int[][] list = store.get_LIST_predefinedArraySizes();
			assertNotNull(list);
			assertEquals(true, list.length > 0);
			
			int totalSizeAtLevel = 0;
			for (int i2 = 0; i2 < list.length; i2++) {
				assertNotNull(list[i2]);
				assertEquals(true, list[i2].length == 3);
				assertEquals(i2, list[i2][0]);
				totalSizeAtLevel += list[i2][2];
				assertEquals(totalSizeAtLevel, list[i2][1]);
			}
		}
	}
	
	
	@Test
	void checkIfSquare2() {
		SmList_SizesStore store;
		final int MAXINT = 2_147_483_647;  // 2^31 = 2_147_483_648.
		int[] list2Squares = new int[31];
		list2Squares[0] = 1;
		for (int i0 = 1; i0 < list2Squares.length; i0++) {
			list2Squares[i0] = list2Squares[i0 - 1] * 2;
		}
		
		for (int i1 = 0; i1 < smList_SizesStores.LIST_predefinedArraySizes.length; i1++) {
			store = smList_SizesStores.LIST_predefinedArraySizes[i1];
			// Except testing predefined sizes.
			if (store.get_listNo().charAt(0) < 48 || store.get_listNo().charAt(0) > 57) {
				continue;
			}
			
			int[][] list = store.get_LIST_predefinedArraySizes();
			boolean find2SquareValue;
			for (int i2 = 0; i2 < list.length; i2++) {
				// Except last size if max int.
				if (list[i2][1] == MAXINT) {
					continue;
				}
				find2SquareValue = false;
				for (int i3 = 0; i3 < list2Squares.length; i3++) {
					if (list[i2][2] == list2Squares[i3] && list2Squares[i3] != 0) {
						find2SquareValue = true;
						break;
					}
				}
				assertEquals(true, find2SquareValue);
			}
		}
	}

}
