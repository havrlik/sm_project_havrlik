package main.java.project.havrlik.soft.smlib.other;

import java.util.UUID;

import main.java.project.havrlik.soft.smlib.SmLib;
import main.java.project.havrlik.soft.smlib.smlist.SmList_1D_String;
import main.java.project.havrlik.soft.smlib.smlist.SmList_Size;

public class ValuePerform {
	
	protected SmLib smLib;
	
	/*
	 * byte 1 byte:  -128 to 127
	 * short 2 bytes:  -32,768 to 32,767
	 * int 4 bytes:  -2,147,483,648 to 2,147,483,647
	 * long 8 bytes:  -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807  // -9 223 372 036 854 775 808    +9 223 372 036 854 775 807
	 * float 4 bytes:  approximately ±3.40282347E+38F, (6-7 significant decimal digits), Java implements IEEE 754 standard
	 * double 8 bytes:  approximately ±1.79769313486231570E+308, (15 significant decimal digits)
	 * char 2 byte:  0 to 65,536 (unsigned)
	 * boolean, bytes not precisely defined* [*Sun's data type tutorial]:  true or false
	 */
	public static final byte BYTE_defaultValue_lowest = -128;
	public static final byte BYTE_defaultValue_lowest_toCompare = -127;
	public static final short SHORT_defaultValue_lowest = -32_768;
	public static final short SHORT_defaultValue_lowest_toCompare = -32_767;
	public static final int INT_defaultValue_lowest = -2_147_483_648;
	public static final int INT_defaultValue_lowest_toCompare = -2_147_483_647;
	public static final int INT_highest = 2_147_483_647;
	public static final int INT_highest_toCompare = 2_147_483_646;
//	public static final long LONG_defaultValue = -2_147_483_648;  // -9_223_372_036_854_775_808
//	public static final long LONG_defaultValue_toCompare = -2_147_483_647;
//	public static final float FLOAT_defaultValue = ;
//	public static final float FLOAT_defaultValue_toCompare = ;
	public static final double DOUBLE_defaultValue = -11_100_000_000_000.0;
	public static final double DOUBLE_defaultValue_toCompare = -11_000_000_000_000.0;
	
	
	public ValuePerform(SmLib smLib) {
		this.smLib = smLib;
		
		call_constructorContinues();
		call_initializeFeatures();
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
	
	
	protected void call_initializeFeatures() {
		// Recommended to disable this method by overriding by empty method in your sub class 
		// and call method bellow at the end of your constructor (2).
		initializeFeatures();
	}
	
	
	protected void initializeFeatures() {
		initFeat();
		initFeat_sub();
	}
	
	
	protected void initFeat() {  }
	protected void initFeat_sub() {  }
	
	
	public void setup1() {  }
	public void setup2_sub() {  }
	public void setup3() {  }
	public void setup4_sub() {  }
	
	
	public static boolean is_stringNumber_int(String string) {
		/*
		 * Returns 'false' when e.g.: "null", "", "a1", "10_000".
		 */
		try {
			Integer.parseInt(string);
		}
		catch (NumberFormatException e1) {
			return false;
		}
		return true;
	}
	
	
	public static boolean is_stringNumber_double(String string) {
		try {
			Double.parseDouble(string);
		}
		catch (Exception e1) {
			return false;
		}
		return true;
	}
	
	
	public static String return_StringFromDouble_NoDecimalPlaces(double numDoub) {
		String numStr = Double.toString(numDoub);
		String numStr_new = "";
		for (byte b1 = 0; b1 < numStr.length(); b1++) {
			if (numStr.charAt(b1) == 46) {  // 46 = dot ".".
				break;
			}
			numStr_new += numStr.charAt(b1);
		}
		
		return numStr_new;
	}
	
	
	public static String return_StringFromDouble_2DecimalPlaces(double numDoub) {
		return return_StringFromDouble_XDecimalPlaces(numDoub, 2);
	}
	
	
	public static String return_StringFromDouble_4DecimalPlaces(double numDoub) {
		return return_StringFromDouble_XDecimalPlaces(numDoub, 4);
	}
	
	
	public static String return_StringFromDouble_6DecimalPlaces(double numDoub) {
		return return_StringFromDouble_XDecimalPlaces(numDoub, 6);
	}
	
	
	public static String return_StrinFromDoubleg_8DecimalPlaces(double numDoub) {
		return return_StringFromDouble_XDecimalPlaces(numDoub, 8);
	}
	
	
	public static String return_StringFromDouble_XDecimalPlaces(double numDoub, int numberDecimalPlaces) {
		String numStr = Double.toString(numDoub);
		String numStr_new = "";
		byte placesAfterDot = 0;
		boolean hasDot = false;
		for (byte b1 = 0; b1 < numStr.length(); b1++) {
			if (hasDot) {
				placesAfterDot++;
				if (placesAfterDot > numberDecimalPlaces) {
					break;
				}
			}
			else if (numStr.charAt(b1) == 46) {  // 46 = dot ".".
				hasDot = true;
			}
			numStr_new += numStr.charAt(b1);
		}
		
		return numStr_new;
	}
	
	
	public static int return_absoluteValue_int(int value) {
		// https://stackoverflow.com/questions/7750037/what-the-fastest-way-in-java-to-receive-absolute-value-of-double
		return value >= 0 ? value : -value;
	}
	
	
	public static double return_absoluteValue_double(double value) {
		return value >= 0 ? value : -value;
	}
	
	
	public static long return_absoluteValue_long(long value) {
		return value >= 0 ? value : -value;
	}
	
	
	/**
	 * @throws NullPointerException -> if pass 'null'.
	 * @return false -> if empty string "".
	 */
	public static boolean is_stringUuid(String string) {
		try {
			UUID.fromString(string);
		}
		catch (IllegalArgumentException e1) {
			return false;
		}
		return true;
	}
	
	
	public static String textFile_insertPrefixBeforeKeyCharacters(String str) {
		if (str == null) {
			return str;
		}
		
		String str_new = "";
		char FILE_TEXTKEYCHARACTERPREFIX = MarkLabelStringEtc.FILE_TEXTKEYCHARACTERPREFIX;
		char[] FILE_TEXTKEYCHARACTERS = MarkLabelStringEtc.FILE_TEXTKEYCHARACTERS;
		for (int i1 = 0; i1 < str.length(); i1++) {
			if (ListPerform.isArrayContainsValue(FILE_TEXTKEYCHARACTERS, str.charAt(i1))) {
				str_new += FILE_TEXTKEYCHARACTERPREFIX;
			}
			str_new += str.charAt(i1);
		}
		
		return str_new;
	}
	
	
	public static String textFile_removePrefixBeforeKeyCharacters(String str) {
		if (str == null) {
			return str;
		}
		
		String str_new = "";
		char FILE_TEXTKEYCHARACTERPREFIX = MarkLabelStringEtc.FILE_TEXTKEYCHARACTERPREFIX;
		char[] FILE_TEXTKEYCHARACTERS = MarkLabelStringEtc.FILE_TEXTKEYCHARACTERS;
		for (int i1 = 0; i1 < str.length(); i1++) {
			if (str.charAt(i1) == FILE_TEXTKEYCHARACTERPREFIX && 
					str.length() > i1 + 1 && 
					ListPerform.isArrayContainsValue(FILE_TEXTKEYCHARACTERS, str.charAt(i1 + 1))) {
				i1++;
				str_new += str.charAt(i1);
				continue;
			}
			str_new += str.charAt(i1);
		}
		
		return str_new;
	}
	
	
	public static String[] parseRowToColumns(String row, char valueSeparator, int numberOfColumns, boolean withCheck_numberOfColumns) {
		if (row == null) {
			return null;
		}
		
		String[] columns = new String[numberOfColumns];
		int columnToInsert = 0;
		String value = "";
		char rowChar;
		
		for (int i1 = 0; i1 < row.length(); i1++) {
			rowChar = row.charAt(i1);
			
			if (rowChar == valueSeparator) {
				columns[columnToInsert] = value;
				columnToInsert++;
				value = "";
				continue;
			}
			else {
				value += rowChar;
			}
		}
		columns[columnToInsert] = value;
		
		if (withCheck_numberOfColumns && columnToInsert != numberOfColumns - 1) {
			throw new RuntimeException("Number of values do not match to expected number of columns. Row: '" + row + "'");
		}
		
		return columns;
	}
	
	
	public static String[] parseRowToColumns(String row, char valueSeparator, int numberOfColumns) {
		return parseRowToColumns(row, valueSeparator, numberOfColumns, true);
	}
	
	
	/**
	 * Values separated by comma and space: ', '.
	 */
	public static SmList_1D_String parseStringValuesToList_commaSpace(String value) {
		if (value == null || value.length() == 0) {
			return null;
		}
		
		SmList_1D_String list = new SmList_1D_String(SmList_Size.TINY_16);
		char comma = MarkLabelStringEtc.SEPARATOR_commaSpace.charAt(0);
		char space = MarkLabelStringEtc.SEPARATOR_commaSpace.charAt(1);
		
		String temp = "";
		char tempChar;
		boolean hasComma = false;
		boolean hasSpace = false;
		
		for (int i1 = 0; i1 < value.length(); i1++) {
			tempChar = value.charAt(i1);
			
			// Force separator, else throw exception.
			if (tempChar == comma) {
				if (hasComma || hasSpace) {
					throw new RuntimeException("Value has not valid format (separators '" + MarkLabelStringEtc.SEPARATOR_commaSpace + 
							"') to parse to list, value: '" + value + "'.");
				}
				hasComma = true;
				continue;
			}
			else if (hasComma && tempChar == space) {
				if (hasSpace) {
					throw new RuntimeException("Value has not valid format (separators '" + MarkLabelStringEtc.SEPARATOR_commaSpace + 
							"') to parse to list, value: '" + value + "'.");
				}
				hasSpace = true;
				continue;
			}
			else if (hasComma && hasSpace) {
				list.addValue(temp);
				temp = "";
				hasComma = false;
				hasSpace = false;
			}
			
			temp += tempChar;
		}
		list.addValue(temp);
		
		return list;
	}
	
	
	/**
	 * Values separated by comma and space: ', '.
	 */
	public static String connectStringValuesToList_commaSpace(SmList_1D_String list) {
		if (list == null || list.size() == 0) {
			return null;
		}
		
		String value = list.getValue(0);
		
		for (int i1 = 1; i1 < list.size(); i1++) {
			value += MarkLabelStringEtc.SEPARATOR_commaSpace + list.getValue(i1);
		}
		
		return value;
	}

}
