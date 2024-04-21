package main.java.project.havrlik.soft.smlib.smlist;

/*
 * Sort of SM lists.
 */


public class SmList_Sort {
	
	
	public SmList_Sort() {
	}
	
	
	/**
	 * Strings are compared lexicographically. The comparison is based on the Unicode value of each character in the strings.
	 */
	public static boolean sortAsc_insertion(SmList_1D_String list) {
		for (int i1 = 1; i1 < list.size(); i1++) {
			int i2 = i1 - 1;
			if (list.getValue(i1).compareTo(list.getValue(i2)) < 0) {
				do {
					i2 -= 1;
				} while (i2 > -1 && list.getValue(i1).compareTo(list.getValue(i2)) < 0);
				i2 += 1;
				
				
				// Value at index i1 insert to index i2, other values between (with i2) move.
				
				String tempValue = list.getValue(i1);
				
				int moveSize = i1 - i2;
				if (moveSize > 0) {
					for (int j1 = i1; j1 > i2; j1--) {
						
						list.putValue(j1, list.getValue(j1 - 1));
						
					}
				}
				else if (moveSize < 0) {
					for (int j1 = i1; j1 < i2; j1++) {
						
						list.putValue(j1, list.getValue(j1 + 1));
						
					}
				}
				
				list.putValue(i2, tempValue);
				
			}
		}
		
		return true;
	}
	
	
	/**
	 * Sort first passed list. At other lists move values in same indexes.
	 */
	public static boolean sortAsc_insertion(SmList_1D_double smList_1D_double, SmList_1D_int smList_1D_int) {
		for (int i1 = 1; i1 < smList_1D_double.size(); i1++) {
			int i2 = i1 - 1;
			if (smList_1D_double.getValue(i1) < smList_1D_double.getValue(i2)) {
				do {
					i2 -= 1;
				} while (i2 > -1 && smList_1D_double.getValue(i1) < smList_1D_double.getValue(i2));
				i2 += 1;
				
				
				// Value at index i1 insert to index i2, other values between (with i2) move.
				
				double tempValue_double = smList_1D_double.getValue(i1);
				int tempValue_int = smList_1D_int.getValue(i1);
				
				int moveSize = i1 - i2;
				if (moveSize > 0) {
					for (int j1 = i1; j1 > i2; j1--) {
						
						smList_1D_double.putValue(j1, smList_1D_double.getValue(j1 - 1));
						smList_1D_int.putValue(j1, smList_1D_int.getValue(j1 - 1));
						
					}
				}
				else if (moveSize < 0) {
					for (int j1 = i1; j1 < i2; j1++) {
						
						smList_1D_double.putValue(j1, smList_1D_double.getValue(j1 + 1));
						smList_1D_int.putValue(j1, smList_1D_int.getValue(j1 + 1));
						
					}
				}
				
				smList_1D_double.putValue(i2, tempValue_double);
				smList_1D_int.putValue(i2, tempValue_int);
				
			}
		}
		
		return true;
	}
	
	
	/**
	 * Sort first passed list. At other lists move values in same indexes.
	 */
	public static boolean sortDesc_insertion(SmList_1D_double smList_1D_double, SmList_1D_int smList_1D_int) {
		for (int i1 = 1; i1 < smList_1D_double.size(); i1++) {
			int i2 = i1 - 1;
			if (smList_1D_double.getValue(i1) > smList_1D_double.getValue(i2)) {
				do {
					i2 -= 1;
				} while (i2 > -1 && smList_1D_double.getValue(i1) > smList_1D_double.getValue(i2));
				i2 += 1;
				
				
				// Value at index i1 insert to index i2, other values between (with i2) move.
				
				double tempValue_double = smList_1D_double.getValue(i1);
				int tempValue_int = smList_1D_int.getValue(i1);
				
				int moveSize = i1 - i2;
				if (moveSize > 0) {
					for (int j1 = i1; j1 > i2; j1--) {
						
						smList_1D_double.putValue(j1, smList_1D_double.getValue(j1 - 1));
						smList_1D_int.putValue(j1, smList_1D_int.getValue(j1 - 1));
						
					}
				}
				else if (moveSize < 0) {
					for (int j1 = i1; j1 < i2; j1++) {
						
						smList_1D_double.putValue(j1, smList_1D_double.getValue(j1 + 1));
						smList_1D_int.putValue(j1, smList_1D_int.getValue(j1 + 1));
						
					}
				}
				
				smList_1D_double.putValue(i2, tempValue_double);
				smList_1D_int.putValue(i2, tempValue_int);
				
			}
		}
		
		return true;
	}

}
