package test.java.project.havrlik.soft.smlib.smlist;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.Test;

import main.java.project.havrlik.soft.smlib.smlist.SmList_2D_Gnrc_2;
import main.java.project.havrlik.soft.smlib.smlist.SmList_Size;

public class SmList_Gnrc_2_Test {
	
	
	@Test
	void integrity_2Dint_7() {
		int listSize = 20_000;
		int[] array = new int[listSize];
		SmList_2D_Gnrc_2<Integer> smExpArrayGen = new SmList_2D_Gnrc_2<Integer>(Integer.class, 4, SmList_Size.TEST_7);
		int columnInsert = 3;
		
		// Insert any values.
		Random random = new Random();
		int value;
		for (int i1 = 0; i1 < listSize / 3; i1++) {
			value = random.nextInt();
			array[i1] = value;
			smExpArrayGen.putValue(i1, columnInsert, value);
		}
		value = random.nextInt();
		array[listSize - 1] = value;
		smExpArrayGen.putValue(listSize - 1, columnInsert, value);
		
		// Switch several values.
		int index1;
		int index2;
		for (int i1 = 0; i1 < 1_000; i1++) {
			index1 = random.nextInt(listSize / 2);
			index2 = random.nextInt(listSize / 3);
			array[index1] = array[index2];
			smExpArrayGen.putValue(index1, columnInsert, smExpArrayGen.getValue(index2, columnInsert));
		}
		
		// Insert any values again.
		for (int i1 = (int) (listSize * 0.7); i1 < listSize; i1 +=2) {
			value = (int) (Math.random() * 1_000);
			array[i1] = value;
			smExpArrayGen.putValue(i1, columnInsert, value);
		}
		
		// Compare.
		assertEquals(array.length, smExpArrayGen.size());
		for (int i1 = 0; i1 < array.length; i1++) {
			assertEquals(array[i1], treatInt(smExpArrayGen.getValue(i1, columnInsert)));
		}
	}
	
	
	private int treatInt(Integer value) {
		if (value == null) {
			return 0;
		}
		return value.intValue();
	}

}
