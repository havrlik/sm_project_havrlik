package main.java.project.havrlik.soft.smlib.data;

import main.java.project.havrlik.soft.smlib.SmLib;
import main.java.project.havrlik.soft.smlib.smlist.SmList_1D_String;
import main.java.project.havrlik.soft.smlib.smlist.SmList_1D_byte;
import main.java.project.havrlik.soft.smlib.smlist.SmList_2D_String;
import main.java.project.havrlik.soft.smlib.smlist.SmList_2D_double;
import main.java.project.havrlik.soft.smlib.smlist.SmList_2D_int;
import main.java.project.havrlik.soft.smlib.smlist.SmList_2D_long;

/*
 * DEPRECATED.
 */

public class Data_General extends Data {
	
	protected int dataType = 0;  // Describes content type. Not changeable after first set.
	protected int dataType_sub1;
	protected int dataType_sub2;
	protected int dataType_sub3;
	protected int dataType_sub4;
	
	public String[] array1D_string;
	public byte[] array1D_byte;
	public String[][] array2D_string;
	public int[][] array2D_int;
	public double[][] array2D_double;
	public long[][] array2D_long;
	public SmList_1D_String smList1D_string;
	public SmList_1D_byte smList1D_byte;
	public SmList_2D_String smList2D_string;
	public SmList_2D_int smList2D_int;
	public SmList_2D_double smList2D_double;
	public SmList_2D_long smList2D_long;
	public int rowNumber_data;  // Various meaning. Usually number of rows of main data in the file.
	public int rowNumber_overall;  // Various meaning. Usually number of all rows in the file.
	
	
	public Data_General(SmLib smLib) {
		super(smLib);
	}
	
	
	protected void clear2_sub() {
		dataType_sub1 = 0;
		dataType_sub2 = 0;
		dataType_sub3 = 0;
		dataType_sub4 = 0;
		
		array1D_string = null;
		array1D_byte = null;
		array2D_string = null;
		array2D_int = null;
		array2D_double = null;
		array2D_long = null;
		smList1D_string = null;
		smList1D_byte = null;
		smList2D_string = null;
		smList2D_int = null;
		smList2D_double = null;
		smList2D_long = null;
		rowNumber_data = -1;
		rowNumber_overall = -1;
		
		clear3_sub();
	}
	
	
	protected void clear3_sub() {  }
	
	
	// Getters:
	
	public int get_dataType() { return dataType; }
	
	public int get_dataType_sub1() { return dataType_sub1; }
	public int get_dataType_sub2() { return dataType_sub2; }
	public int get_dataType_sub3() { return dataType_sub3; }
	public int get_dataType_sub4() { return dataType_sub4; }
	
	
	// Setters:
	
//	public boolean set_dataType(int dataType) {
//		if (this.dataType == 0) {
//			this.dataType = dataType;
//			return true;
//		}
//		else if (this.dataType == dataType) {
//			return true;
//		}
//		
//		this.dataType = ValuesPerform_Super.BYTE_defaultValue_lowest;
//		conditionMain.messageReceiver.message(MessageType.M1_FATAL, 
//				MessageList.assemblePlacement(this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName()), 
//				"Forbidden reassign of 'dataType'.");
//		return false;
//	}
//	
//	public boolean set_dataTypeSub1(int dataTypeSub1) {
//		if (this.dataType == 0) {
//			this.dataTypeSub1 = 0;
//			return false;
//		}
//		this.dataTypeSub1 = dataTypeSub1;
//		return true;
//	}

}
