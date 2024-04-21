package test.java.project.havrlik.soft.smlib.smlist;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import main.java.project.havrlik.soft.smlib.smlist.SmList_1D_int;
import main.java.project.havrlik.soft.smlib.smlist.SmList_2DFc_String;
import main.java.project.havrlik.soft.smlib.smlist.SmList_2D_String;
import main.java.project.havrlik.soft.smlib.smlist.SmList_2D_int;
import main.java.project.havrlik.soft.smlib.smlist.SmList_Size;


public class SmList_Test {
	
	
	@Test
	void integrity_1Dint_16() {
		int listSize = 100_000;
		int[] array = new int[listSize];
		SmList_1D_int smList = new SmList_1D_int(SmList_Size.TINY_16);
		
		// Insert values.
		int value;
		for (int i1 = 0; i1 < array.length; i1++) {
			value = (int) (Math.random() * 1000);
			array[i1] = value;
			smList.putValue(i1, value);
		}
		
		// Switch several values.
		int index1;
		int index2;
		for (int i1 = 0; i1 < 1000; i1++) {
			index1 = (int) (Math.random() * (listSize - 1));
			index2 = (int) (Math.random() * (listSize - 1));
			array[index1] = array[index2];
			smList.putValue(index1, smList.getValue(index2));
		}
		
		// Rewrite several values.
		for (int i1 = 4_000; i1 < 12_000; i1 +=3) {
			value = (int) (Math.random() * 1_000);
			array[i1] = value;
			smList.putValue(i1, value);
		}
		
		// Compare.
		assertEquals(array.length, smList.size());
		for (int i1 = 0; i1 < array.length; i1++) {
			assertEquals(array[i1], smList.getValue(i1));
		}
	}
	
	
	@Test
	void integrity_2Dint_7() {
		int listSize = 20_000;
		int[] array = new int[listSize];
		SmList_2D_int smList = new SmList_2D_int(4, SmList_Size.TEST_7);
		int columnInsert = 3;
		
		// Insert any values.
		Random random = new Random();
		int value;
		for (int i1 = 0; i1 < listSize / 3; i1++) {
			value = random.nextInt();
			array[i1] = value;
			smList.putValue(i1, columnInsert, value);
		}
		value = random.nextInt();
		array[listSize - 1] = value;
		smList.putValue(listSize - 1, columnInsert, value);
		
		// Switch several values.
		int index1;
		int index2;
		for (int i1 = 0; i1 < 1_000; i1++) {
			index1 = random.nextInt(listSize / 2);
			index2 = random.nextInt(listSize / 3);
			array[index1] = array[index2];
			smList.putValue(index1, columnInsert, smList.getValue(index2, columnInsert));
		}
		
		// Insert any values again.
		for (int i1 = (int) (listSize * 0.7); i1 < listSize; i1 +=2) {
			value = (int) (Math.random() * 1_000);
			array[i1] = value;
			smList.putValue(i1, columnInsert, value);
		}
		
		// Compare.
		assertEquals(array.length, smList.size());
		for (int i1 = 0; i1 < array.length; i1++) {
			assertEquals(array[i1], smList.getValue(i1, columnInsert));
		}
	}
	
	
	@Test
	void integrity_2DString_4K() {
		int listSize = 20_000;
		String[] array = new String[listSize];
		SmList_2D_String smList = new SmList_2D_String(4, SmList_Size.MEDIUM_4K);
		int columnInsert = 0;
		
		// Insert any values.
		Random random = new Random();
		int value;
		for (int i1 = 0; i1 < listSize / 3; i1++) {
			value = random.nextInt();
			array[i1] = Integer.toString(value);
			smList.putValue(i1, columnInsert, Integer.toString(value));
		}
		value = random.nextInt();
		array[listSize - 1] = Integer.toString(value);
		smList.putValue(listSize - 1, columnInsert, Integer.toString(value));
		
		// Switch several values.
		int index1;
		int index2;
		for (int i1 = 0; i1 < 1_000; i1++) {
			index1 = random.nextInt(listSize / 2);
			index2 = random.nextInt(listSize / 3);
			array[index1] = array[index2];
			smList.putValue(index1, columnInsert, smList.getValue(index2, columnInsert));
		}
		
		// Insert any values again.
		for (int i1 = (int) (listSize * 0.7); i1 < listSize; i1 +=2) {
			value = (int) (Math.random() * 1_000);
			array[i1] = Integer.toString(value);
			smList.putValue(i1, columnInsert, Integer.toString(value));
		}
		
		// Compare.
		assertEquals(array.length, smList.size());
		for (int i1 = 0; i1 < array.length; i1++) {
			assertEquals(array[i1], smList.getValue(i1, columnInsert));
		}
	}
	
	
	@Test
	void integrity_2DFCString_7() {
		SmList_2DFc_String smList = new SmList_2DFc_String(SmList_Size.TEST_7, SmList_Size.TEST_7);
		
		// Test length.
		// Prepare.
		int listSize = 20_000;
		String[] array = new String[listSize];
		int columnInsert = 3;
		
		// Insert any values.
		Random random = new Random();
		int value;
		for (int i1 = 0; i1 < listSize / 3; i1++) {
			value = random.nextInt();
			array[i1] =  Integer.toString(value);
			smList.putValue(i1, columnInsert,  Integer.toString(value));
		}
		value = random.nextInt();
		array[listSize - 1] =  Integer.toString(value);
		smList.putValue(listSize - 1, columnInsert,  Integer.toString(value));
		
		// Switch several values.
		int index1;
		int index2;
		for (int i1 = 0; i1 < 1_000; i1++) {
			index1 = random.nextInt(listSize / 2);
			index2 = random.nextInt(listSize / 3);
			array[index1] = array[index2];
			smList.putValue(index1, columnInsert, smList.getValue(index2, columnInsert));
		}
		
		// Insert any values again.
		for (int i1 = (int) (listSize * 0.7); i1 < listSize; i1 +=2) {
			value = (int) (Math.random() * 1_000);
			array[i1] =  Integer.toString(value);
			smList.putValue(i1, columnInsert,  Integer.toString(value));
		}
		
		// Compare.
		assertEquals(array.length, smList.size());
		for (int i1 = 0; i1 < array.length; i1++) {
			assertEquals(array[i1], smList.getValue(i1, columnInsert));
		}
		
		// Test width.
		// Prepare.
		int listWidth = 2000;
		String[] arrayWidth = new String[listWidth];
		int rowInsert = 111;
		
		// Insert any values.
		for (int i1 = 0; i1 < listWidth; i1++) {
			value = random.nextInt();
			arrayWidth[i1] =  Integer.toString(value);
			smList.putValue(rowInsert, i1,  Integer.toString(value));
		}
		
		// Compare.
		assertEquals(arrayWidth.length, smList.getRow_SM1DList(rowInsert).size());
		for (int i1 = 0; i1 < arrayWidth.length; i1++) {
			assertEquals(arrayWidth[i1], smList.getValue(rowInsert, i1));
		}
	}
	
	
	@Test
	void border() {
		SmList_2D_int smList = new SmList_2D_int(4, SmList_Size.TEST_6);
		int listMaxSize = smList.return_MAXSIZE();
		int[] arrayInt = new int[listMaxSize];
		int columnInsert = 2;
		
		// Insert any values.
		Random random = new Random();
		int value;
		for (int i1 = 0; i1 < listMaxSize; i1++) {
			value = random.nextInt();
			arrayInt[i1] = value;
			smList.putValue(i1, columnInsert, value);
		}
		
		// Compare.
		assertEquals(listMaxSize, smList.size());
		assertEquals(listMaxSize, smList.size_real());
		for (int i1 = 0; i1 < arrayInt.length; i1++) {
			assertEquals(arrayInt[i1], smList.getValue(i1, columnInsert));
		}
		
	}
	
	
	@Test
	void insertionOutOfMaxSize() {
		SmList_2D_int smList = new SmList_2D_int(4, SmList_Size.TEST_6);
		int listMaxSize = smList.return_MAXSIZE();
		int columnInsert = 2;
		
		// Insert any values.
		int value = 1;
		for (int i1 = 0; i1 < listMaxSize; i1++) {
			smList.putValue(i1, columnInsert, value);
		}
		
		// Insertion who raise exception.
		try {
			smList.putValue(listMaxSize, columnInsert, value);
			Assert.fail("Exception expected");
		}
		catch (ArrayIndexOutOfBoundsException expected) {
			assertEquals(expected.getMessage(), "SM list cannot increase over MAXSIZE.");
		}
		catch (Exception anyOther) {
			Assert.fail("Unexpected Exception");
		}
	}
	
	
	@Test
	void getValueOutOfBounds() {
		SmList_2D_int smList = new SmList_2D_int(4, SmList_Size.TEST_6);
		int columnInsert = 2;
		int size = 20;
		
		// Insert any values.
		int value = 1;
		for (int i1 = 0; i1 < size; i1++) {
			smList.putValue(i1, columnInsert, value);
		}
		
		// Check precondition.
		int indexGet = 400;
		assertEquals(true, size + 1 < smList.size_real());
		assertEquals(true, indexGet - 20 > smList.size_real());
		
		// Main test.
		assertEquals(0, smList.getValue(size + 1, columnInsert));
		assertEquals(0, smList.getValue(indexGet, columnInsert));
		assertEquals(0, smList.getValue(indexGet + 100, columnInsert));
		assertEquals(size, smList.size());
		assertEquals(true, smList.size_real() >= size);
	}
	
	
	@Test
	void getValueFromEmptyPosition() {
		SmList_2D_int smList2Dint = new SmList_2D_int(4, SmList_Size.TEST_6);
		assertEquals(0, smList2Dint.getValue(3, 2));
		assertEquals(0, smList2Dint.getValue(1_000_000, 2));
		assertEquals(0, smList2Dint.size());
		
		SmList_2D_String smList2DString = new SmList_2D_String(4, SmList_Size.TEST_6);
		assertNull(smList2DString.getValue(3, 2));
		assertNull(smList2DString.getValue(1_000_000, 2));
		assertEquals(0, smList2DString.size());
		
		SmList_2DFc_String smList2DFCString = new SmList_2DFc_String(SmList_Size.TEST_6, SmList_Size.TEST_6);
		assertNull(smList2DFCString.getValue(3, 2));
		assertNull(smList2DFCString.getValue(1_000_000, 2));
		assertNull(smList2DFCString.getValue(3, 1_000_000));
		assertNull(smList2DFCString.getValue(1_000_000, 1_000_000));
		assertEquals(0, smList2DFCString.size());
	}

}
