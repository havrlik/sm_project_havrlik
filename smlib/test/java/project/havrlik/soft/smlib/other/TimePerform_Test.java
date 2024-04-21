package test.java.project.havrlik.soft.smlib.other;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import main.java.project.havrlik.soft.smlib.SmLib;
import main.java.project.havrlik.soft.smlib.other.TimePerform;
import main.java.project.havrlik.soft.smlib.other.TimeType;


public class TimePerform_Test {
	
	private SmLib smLib;
	private TimePerform timePerform;
	
	
	TimePerform_Test() {
		smLib = new SmLib();
		timePerform = smLib.timePerform;
	}
	
	
	@Test
	void return_datePlusTimeLength() {
//		fail("Not yet implemented");
		
		
		String[][] dateTime = {
				{"20000418  060000", "h", "+1", "20000418  070000"},
				{"20050202  103000", "h", "+11", "20050202  213000"},
				{"20050202  233000", "h", "+1", "20050203  003000"},
				{"20050202  233000", "h", "-2", "20050202  213000"},
				{"20050211  233001", "h", "-13", "20050211  103001"},
				{"20050222  205100", "h", "+26", "20050223  225100"},
				{"20050222  205100", "h", "+28", "20050224  005100"},
				{"20050222  205100", "h", "-26", "20050221  185100"},
				{"20050131  205100", "h", "+26", "20050201  225100"},
				
				{"20050802  203000", "m", "+1", "20050802  203100"},
				{"20050202  205100", "m", "+26", "20050202  211700"},
				{"20050202  235100", "m", "+26", "20050203  001700"},
				{"20050202  200102", "m", "-70", "20050202  185102"},
		};
		
		for (int i1 = 0; i1 < dateTime.length; i1++) {
			String time_new = timePerform.return_datePlusTimeLength(
					dateTime[i1][0], 
					TimeType.valueOf(dateTime[i1][1]), 
					Integer.parseInt(dateTime[i1][2])
			);
			assertEquals(dateTime[i1][3], time_new);
//			System.out.println(i1);
		}
	}

}
