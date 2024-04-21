package main.java.project.havrlik.soft.smlib.other;

import main.java.project.havrlik.soft.smlib.SmLib;
import main.java.project.havrlik.soft.smlib.exception.PerformMethodThrowsAnyExceprion;
import main.java.project.havrlik.soft.smlib.exception.PerformMethod_ReceivedValueNotFound;
import main.java.project.havrlik.soft.smlib.exception.ReceivedVariableInPerformMethod_NullOrEmptyVariable;
import main.java.project.havrlik.soft.smlib.exception.ReceivedVariableInPerformMethod_WrongValue;

public class ListPerform {
	
	protected SmLib smLib;
	
	
	public ListPerform(SmLib smLib) {
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
	
	
	public static boolean isArrayContainsValue(int[] array, int findValue) {
		for (int i1 = 0; i1 < array.length; i1++) {
			if (array[i1] == findValue) {
				return true;
			}
		}
		
		return false;
	}
	
	
	public static boolean isArrayContainsValue(float[] array, float findValue) {
		for (int i1 = 0; i1 < array.length; i1++) {
			if (array[i1] == findValue) {
				return true;
			}
		}
		
		return false;
	}
	
	
	public static boolean isArrayContainsValue(double[] array, double findValue) {
		for (int i1 = 0; i1 < array.length; i1++) {
			if (array[i1] == findValue) {
				return true;
			}
		}
		
		return false;
	}
	
	
	public static boolean isArrayContainsValue(char[] array, char findValue) {
		for (int i1 = 0; i1 < array.length; i1++) {
			if (array[i1] == findValue) {
				return true;
			}
		}
		
		return false;
	}
	
	
	public static boolean isArrayContainsValue(String[] array, String findValue) {
		for (int i1 = 0; i1 < array.length; i1++) {
			if (array[i1].length() == findValue.length() && array[i1].equals(findValue)) {
				return true;
			}
		}
		
		return false;
	}
	
	
	public static boolean isArrayContainsValue(int[][] array, int findValue, int columnWhereFind) {
		for (int i1 = 0; i1 < array.length; i1++) {
			if (array[i1][columnWhereFind] == findValue) {
				return true;
			}
		}
		
		return false;
	}
	
	
	public static boolean isArrayContainsValue(float[][] array, float findValue, int columnWhereFind) {
		for (int i1 = 0; i1 < array.length; i1++) {
			if (array[i1][columnWhereFind] == findValue) {
				return true;
			}
		}
		
		return false;
	}
	
	
	public static boolean isArrayContainsValue(char[][] array, char findValue, int columnWhereFind) {
		for (int i1 = 0; i1 < array.length; i1++) {
			if (array[i1][columnWhereFind] == findValue) {
				return true;
			}
		}
		
		return false;
	}
	
	
	public static boolean isArrayContainsValue(double[][] array, double findValue, int columnWhereFind) {
		for (int i1 = 0; i1 < array.length; i1++) {
			if (array[i1][columnWhereFind] == findValue) {
				return true;
			}
		}
		
		return false;
	}
	
	
	public static boolean isArrayContainsValue(String[][] array, String findValue, int columnWhereFind) {
		for (int i1 = 0; i1 < array.length; i1++) {
			if (array[i1][columnWhereFind].length() == findValue.length() && array[i1][columnWhereFind].equals(findValue)) {
				return true;
			}
		}
		
		return false;
	}
	
	
	/*
	 * Several methods to find row with received value at certain column.
	 */
	public static int returnRow_1DArray(int[] array, int findValue) {
		for (int i1 = 0; i1 < array.length; i1++) {
			if (array[i1] == findValue) {
				return i1;
			}
		}
		
		return -2;
	}
	
	
	public static int returnRow_1DArray(float[] array, float findValue) {
		for (int i1 = 0; i1 < array.length; i1++) {
			if (array[i1] == findValue) {
				return i1;
			}
		}
		
		return -2;
	}
	
	
	public static int returnRow_1DArray(double[] array, double findValue) {
		for (int i1 = 0; i1 < array.length; i1++) {
			if (array[i1] == findValue) {
				return i1;
			}
		}
		
		return -2;
	}
	
	
	public static int returnRow_1DArray(String[] array, String findValue) {
		for (int i1 = 0; i1 < array.length; i1++) {
			if (array[i1].equals(findValue)) {
				return i1;
			}
		}
		
		return -2;
	}
	
	
	public static int returnRow_2DArray(int[][] array, int findValue, int columnWhereFind) {
		for (int i1 = 0; i1 < array.length; i1++) {
			if (array[i1][columnWhereFind] == findValue) {
				return i1;
			}
		}
		
		return -2;
	}
	
	
	public static int returnRow_2DArray(float[][] array, float findValue, int columnWhereFind) {
		for (int i1 = 0; i1 < array.length; i1++) {
			if (array[i1][columnWhereFind] == findValue) {
				return i1;
			}
		}
		
		return -2;
	}
	
	
	public static int returnRow_2DArray(double[][] array, double findValue, int columnWhereFind) {
		for (int i1 = 0; i1 < array.length; i1++) {
			if (array[i1][columnWhereFind] == findValue) {
				return i1;
			}
		}
		
		return -2;
	}
	
	
	public static int returnRow_2DArray(String[][] array, String findValue, int columnWhereFind) {
		for (int i1 = 0; i1 < array.length; i1++) {
			if (array[i1][columnWhereFind].equals(findValue)) {
				return i1;
			}
		}
		
		return -2;
	}
	
	
	/*
	 * Several methods to find row and return value from certain column.
	 */
	public static int returnValue_2DArray(int[][] array, int findValue, int columnWhereFind, int columnWhereGet) throws PerformMethod_ReceivedValueNotFound {
		for (int i1 = 0; i1 < array.length; i1++) {
			if (array[i1][columnWhereFind] == findValue) {
				return array[i1][columnWhereGet];
			}
		}
		
		throw new PerformMethod_ReceivedValueNotFound();
	}
	
	
	public static float returnValue_2DArray(float[][] array, float findValue, int columnWhereFind, int columnWhereGet) throws PerformMethod_ReceivedValueNotFound {
		for (int i1 = 0; i1 < array.length; i1++) {
			if (array[i1][columnWhereFind] == findValue) {
				return array[i1][columnWhereGet];
			}
		}
		
		throw new PerformMethod_ReceivedValueNotFound();
	}
	
	
	public static double returnValue_2DArray(double[][] array, double findValue, int columnWhereFind, int columnWhereGet) throws PerformMethod_ReceivedValueNotFound {
		for (int i1 = 0; i1 < array.length; i1++) {
			if (array[i1][columnWhereFind] == findValue) {
				return array[i1][columnWhereGet];
			}
		}
		
		throw new PerformMethod_ReceivedValueNotFound();
	}
	
	
	public static String returnValue_2DArray(String[][] array, String findValue, int columnWhereFind, int columnWhereGet) throws PerformMethod_ReceivedValueNotFound {
		for (int i1 = 0; i1 < array.length; i1++) {
			if (array[i1][columnWhereFind].equals(findValue)) {
				return array[i1][columnWhereGet];
			}
		}
		
		throw new PerformMethod_ReceivedValueNotFound();
	}
	
	
	/*
	 * Several methods to find row and return value from certain column.
	 * 
	 * Without recommended exception 'value not found'.
	 */
	public static int returnValue_2DArray_withoutException(int[][] array, int findValue, int columnWhereFind, int columnWhereGet) {
		for (int i1 = 0; i1 < array.length; i1++) {
			if (array[i1][columnWhereFind] == findValue) {
				return array[i1][columnWhereGet];
			}
		}
		
		return -2_147_483_648;
	}
	
	
	public static float returnValue_2DArray_withoutException(float[][] array, float findValue, int columnWhereFind, int columnWhereGet) {
		for (int i1 = 0; i1 < array.length; i1++) {
			if (array[i1][columnWhereFind] == findValue) {
				return array[i1][columnWhereGet];
			}
		}
		
		return -2_147_483_648;
	}
	
	
	public static double returnValue_2DArray_withoutException(double[][] array, double findValue, int columnWhereFind, int columnWhereGet) {
		for (int i1 = 0; i1 < array.length; i1++) {
			if (array[i1][columnWhereFind] == findValue) {
				return array[i1][columnWhereGet];
			}
		}
		
		return -2_147_483_648;
	}
	
	
	public static String returnValue_2DArray_withoutException(String[][] array, String findValue, int columnWhereFind, int columnWhereGet) {
		for (int i1 = 0; i1 < array.length; i1++) {
			if (array[i1][columnWhereFind].equals(findValue)) {
				return array[i1][columnWhereGet];
			}
		}
		
		return null;
	}
	
	
	/*
	 * Methods above with checking received values and exceptions.
	 * 
	 * In case of 2D array we expect same length of inner arrays. There is checking only first "row" with received column number.
	 */
	public static int returnValue_2DArray_withExceptions(int[][] array, int findValue, int columnWhereFind, int columnWhereGet) throws ReceivedVariableInPerformMethod_WrongValue, ReceivedVariableInPerformMethod_NullOrEmptyVariable, PerformMethodThrowsAnyExceprion, PerformMethod_ReceivedValueNotFound {
		if (array == null || array.length == 0 || array[0].length == 0) {
			throw new ReceivedVariableInPerformMethod_NullOrEmptyVariable();
		}
		if (columnWhereFind >= array[0].length || columnWhereFind < 0 || columnWhereGet >= array[0].length || columnWhereGet < 0) {
			throw new ReceivedVariableInPerformMethod_WrongValue();
		}
		
		try {
			for (int i1 = 0; i1 < array.length; i1++) {
				if (array[i1][columnWhereFind] == findValue) {
					return array[i1][columnWhereGet];
				}
			}
		}
		catch (Exception e1) {
			throw new PerformMethodThrowsAnyExceprion();
		}
		
		throw new PerformMethod_ReceivedValueNotFound();
	}
	
	
	public static float returnValue_2DArray_withExceptions(float[][] array, float findValue, int columnWhereFind, int columnWhereGet) throws ReceivedVariableInPerformMethod_WrongValue, ReceivedVariableInPerformMethod_NullOrEmptyVariable, PerformMethodThrowsAnyExceprion, PerformMethod_ReceivedValueNotFound {
		if (array == null || array.length == 0 || array[0].length == 0) {
			throw new ReceivedVariableInPerformMethod_NullOrEmptyVariable();
		}
		if (columnWhereFind >= array[0].length || columnWhereFind < 0 || columnWhereGet >= array[0].length || columnWhereGet < 0) {
			throw new ReceivedVariableInPerformMethod_WrongValue();
		}
		
		try {
			for (int i1 = 0; i1 < array.length; i1++) {
				if (array[i1][columnWhereFind] == findValue) {
					return array[i1][columnWhereGet];
				}
			}
		}
		catch (Exception e1) {
			throw new PerformMethodThrowsAnyExceprion();
		}
		
		throw new PerformMethod_ReceivedValueNotFound();
	}
	
	
	public static double returnValue_2DArray_withExceptions(double[][] array, double findValue, int columnWhereFind, int columnWhereGet) throws ReceivedVariableInPerformMethod_WrongValue, ReceivedVariableInPerformMethod_NullOrEmptyVariable, PerformMethodThrowsAnyExceprion, PerformMethod_ReceivedValueNotFound {
		if (array == null || array.length == 0 || array[0].length == 0) {
			throw new ReceivedVariableInPerformMethod_NullOrEmptyVariable();
		}
		if (columnWhereFind >= array[0].length || columnWhereFind < 0 || columnWhereGet >= array[0].length || columnWhereGet < 0) {
			throw new ReceivedVariableInPerformMethod_WrongValue();
		}
		
		try {
			for (int i1 = 0; i1 < array.length; i1++) {
				if (array[i1][columnWhereFind] == findValue) {
					return array[i1][columnWhereGet];
				}
			}
		}
		catch (Exception e1) {
			throw new PerformMethodThrowsAnyExceprion();
		}
		
		throw new PerformMethod_ReceivedValueNotFound();
	}
	
	
	public static String returnValue_2DArray_withExceptions(String[][] array, String findValue, int columnWhereFind, int columnWhereGet) throws ReceivedVariableInPerformMethod_WrongValue, ReceivedVariableInPerformMethod_NullOrEmptyVariable, PerformMethodThrowsAnyExceprion, PerformMethod_ReceivedValueNotFound {
		if (array == null || array.length == 0 || array[0].length == 0) {
			throw new ReceivedVariableInPerformMethod_NullOrEmptyVariable();
		}
		if (findValue == null || findValue.length() == 0) {
			throw new ReceivedVariableInPerformMethod_NullOrEmptyVariable();
		}
		if (columnWhereFind >= array[0].length || columnWhereFind < 0 || columnWhereGet >= array[0].length || columnWhereGet < 0) {
			throw new ReceivedVariableInPerformMethod_WrongValue();
		}
		
		try {
			for (int i1 = 0; i1 < array.length; i1++) {
				if (array[i1][columnWhereFind].equals(findValue)) {
					return array[i1][columnWhereGet];
				}
			}
		}
		catch (Exception e1) {
			throw new PerformMethodThrowsAnyExceprion();
		}
		
		throw new PerformMethod_ReceivedValueNotFound();
	}

}
