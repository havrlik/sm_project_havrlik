package test.java.project.havrlik.soft.smlib.other;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import main.java.project.havrlik.soft.smlib.SmLib;
import main.java.project.havrlik.soft.smlib.other.ValuePerform;

public class ValuePerform_Test {
	
	protected SmLib smLib;
	protected ValuePerform valuePerform;
	
	
	ValuePerform_Test() {
		smLib = new SmLib();
		valuePerform = smLib.valuePerform;
	}
	
	
	@Test
	void is_stringNumber_int() {
//		fail("Not yet implemented");
		
		
		String[][] values = {  // Columns: [0] expected result ; [1] value to perform ; 
				{"true", "0"},
				{"true", "10"},
				{"true", "100000000"},
				
				{"true", "-1"},
				{"true", "-999"},
				{"true", "-999999"},
				
				{"false", ""},
				{"false", "a"},
				{"false", "a1"},
				{"false", "two"},
				{"false", "100_000"},
				{"false", null},
		};
		
		for (int i1 = 0; i1 < values.length; i1++) {
//			System.out.println(i1 + ":  " + values[i1][1]);
			assertEquals(Boolean.parseBoolean(values[i1][0]), ValuePerform.is_stringNumber_int(values[i1][1]));
		}
	}

}
