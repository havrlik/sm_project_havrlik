package main.java.project.havrlik.soft.smlib.smlist;

abstract class SmList {
	
	/**
	 * Author: 'havrlik', created on 2018.
	 * 
	 * SmList aims to provide features like Java arrays but mutable size.
	 * 
	 * Note: If you request to get value or row from bigger index then size (or size_real), can return array or list of nulls or null. This is feature.
	 */
	
	private SmList_Util smList_Util = new SmList_Util();
	
	protected SmList_SizesStore LIST_predefinedArraySizes_template;
	
	protected int LISTLENGTH_DEFAULT = 0;
	protected int INCREASELENGTHOFBIGGERLIST = 0;
	protected double MULTIPLELENGTHOFANOTHERARRAYS = 0;
	
	protected int[][] list_arraySizes = null;  // * Should rename to list_listAggregatedSizes.  // List with all used arrays. Level number, whole list size at level, array size at level.
	protected int list_arraySizes_length = 0;  // * Should rename to list_listAggregatedSizes_length.  // Use instead 'list_arraySizes.length', may differs.
	protected int listAggregated_initializedQuantity = 0;  // Initialized arrays in list.
	
	protected int maxWritedRowNumber = -1;  // 'row number' = 'index'.
	protected int size_real = 0;  // Suma of used arrays length.
	
	protected int arrayNumber = 0;
	protected int rowNumberInArray = 0;
	
	/*
	 * Variable with certain type need to create at inherited classes:
	 * 
	 * protected <T>[] listAggregated;
	 */
	
	
	protected SmList() {
		mutualConstructor(SmList_Size.DEFAULT_128);
	}
	
	
	protected SmList(SmList_Size smList_Size) {
		mutualConstructor(smList_Size);
	}
	
	
	protected SmList(int mediumSizeOfList) {
		mutualConstructor(SmList_Util.return_recommendedSmListSizeName(mediumSizeOfList));
	}
	
	
	private void mutualConstructor(SmList_Size smList_Size) {
		LIST_predefinedArraySizes_template = smList_Util.return_predefinedArraySizes(smList_Size);
//		
		LISTLENGTH_DEFAULT = LIST_predefinedArraySizes_template.get_LIST_predefinedArraySizes().length;  // Test carefully if you use another policy.
		INCREASELENGTHOFBIGGERLIST = LISTLENGTH_DEFAULT;
		MULTIPLELENGTHOFANOTHERARRAYS = 1.0;  // Currently no increasing policy is applied.
	}
	
	
	public abstract void clearRow(int rowNumber);
	
	
	public final void set_maxWritedRowNumber(int set_maxWritedRowNumber) {
		// Method clear another rows.
		// Variable 'set_maxWritedRowNumber' and 'maxWritedRowNumber' is row number (= index). Not quantity or something like length or size of inserted items.
		// Pass to 'set_maxWritedRowNumber' desired last index, higher indexes will be cleared.
		for (int i1 = set_maxWritedRowNumber + 1; i1 <= maxWritedRowNumber; i1++) {
			clearRow(i1);
		}
		maxWritedRowNumber = set_maxWritedRowNumber;
	}
	
	
	public final void set_size(int set_size) {
		set_maxWritedRowNumber(set_size - 1);
	}
	
	
	public final int size() {
		return maxWritedRowNumber + 1;
	}
	
	
	public final int get_maxWritedRowNumber() {
		// Notice: It is row number. Not quantity or somefing like length or size.
		return maxWritedRowNumber;
	}
	
	
	public final int lastIndex() {
		return get_maxWritedRowNumber();
	}
	
	
	protected abstract void clear();
	
	
	protected abstract void addArrayToList();
	protected abstract void addAnotherOneArrayToList();
	
	
	/*
	 * Additional methods - Abstract methods with certain passed or returned type:
	 * 
	 * is_listContainsValue();
	 */
	
	
	public final int size_real() {
		// Notice: this value usualy user can not demand -> maybe rather not public access.
		return size_real;
	}
	
	
	public final int return_MAXSIZE() {
		return LIST_predefinedArraySizes_template.get_MAXSIZE();
	}
	
	
	protected final void determineArrayNumberAndRowNumberInArray(int rowNumber) {
		while (rowNumber >= size_real) {
			addArrayToList();
		}
		int i1 = 0;
		for (i1 = listAggregated_initializedQuantity - 1; i1 >= 0; i1--) {
			if (rowNumber >= list_arraySizes[i1][1]) {
				break;
			}
		}
		arrayNumber = i1 + 1;
		rowNumberInArray = rowNumber - (list_arraySizes[arrayNumber][1] - list_arraySizes[arrayNumber][2]);
	}
	
	
	protected final boolean determineArrayNumberAndRowNumberInArray_notAddingArrays(int rowNumber) {
		/*
		 * When out of bounds return false.
		 */
		if (rowNumber >= size_real) {
			return false;
		}
		int i1 = 0;
		for (i1 = listAggregated_initializedQuantity - 1; i1 >= 0; i1--) {
			if (rowNumber >= list_arraySizes[i1][1]) {
				break;
			}
		}
		arrayNumber = i1 + 1;
		rowNumberInArray = rowNumber - (list_arraySizes[arrayNumber][1] - list_arraySizes[arrayNumber][2]);
		
		return true;
	}
	
	
	protected void createNew_list_arraySizes() {
		list_arraySizes_length = 0;
		listAggregated_initializedQuantity = 0;
		size_real = 0;
		maxWritedRowNumber = -1;
		
		// New LIST_usedArraySizes - copy of LIST_predefinedArraySizes[].
		list_arraySizes_length = LISTLENGTH_DEFAULT;
		list_arraySizes = null;
		list_arraySizes = new int[list_arraySizes_length][3];
		
		// Add values from template.
		int copy_listArraySizes_length = LIST_predefinedArraySizes_template.get_LIST_predefinedArraySizes().length;
		if (list_arraySizes_length < copy_listArraySizes_length) {
			// Check lenght, because LIST_predefinedArraySizes[x] may be longer then used listLength - according to LIST_predefinedArraySizes_note[x][1].
			copy_listArraySizes_length = list_arraySizes_length;
		}
		// Copy array (deep copy).
		for (int i1 = 0; i1 < copy_listArraySizes_length; i1++) {
			list_arraySizes[i1] = new int[LIST_predefinedArraySizes_template.get_LIST_predefinedArraySizes()[i1].length];
			for (int i2 = 0; i2 < LIST_predefinedArraySizes_template.get_LIST_predefinedArraySizes()[i1].length; i2++) {
				list_arraySizes[i1][i2] = LIST_predefinedArraySizes_template.get_LIST_predefinedArraySizes()[i1][i2];
			}
		}
		
		// Fill remaining empty rows.
		list_arraySizes = addValuesToNewBigger_list_arraySizes(list_arraySizes, copy_listArraySizes_length);
	}
	
	
	protected void increase_list_arraySizes() {
		if (list_arraySizes[list_arraySizes_length - 1][1] == LIST_predefinedArraySizes_template.get_MAXSIZE()) {
			throw new ArrayIndexOutOfBoundsException("SM list cannot increase over MAXSIZE.");
		}
		int listLength_new = list_arraySizes_length + INCREASELENGTHOFBIGGERLIST;
		// Copy list_arraySizes.
		int[][] list_arraySizes_new = new int[listLength_new][3];
		for (int i1 = 0; i1 < list_arraySizes_length; i1++) {
			list_arraySizes_new[i1] = list_arraySizes[i1];
		}
		list_arraySizes_length = listLength_new;  // May be decreased by further method if achieved MAXSIZE.
		list_arraySizes = addValuesToNewBigger_list_arraySizes(list_arraySizes_new, list_arraySizes.length);
	}
	
	
	int[][] addValuesToNewBigger_list_arraySizes(int[][] list_arraySizes_new, int firstEmptyIndex) {
		/*
		 * Precondition: received list contains first row least already.
		 * int firstEmptyIndex : is optional.
		 */
		if (list_arraySizes_new[0][1] < 1) {
			throw new ArrayStoreException("SM list - list_arraySizes increasing error.");
		}
		int i1 = 1;
		if (firstEmptyIndex > 1) {
			i1 = firstEmptyIndex;
		}
		
		for (; i1 < list_arraySizes_new.length; i1++) {
			if (list_arraySizes_new[i1][2] == 0) {
				int[] arraySize_row = new int[3];
				arraySize_row[0] = i1;  // Level.
				arraySize_row[2] = returnNextArraySize(list_arraySizes_new[i1 - 1]);  // List length.
				arraySize_row[1] = list_arraySizes_new[i1 - 1][1] + arraySize_row[2];  // Added size against precedent level.
				list_arraySizes_new[i1] = arraySize_row;
				
				if (list_arraySizes_new[i1][1] == LIST_predefinedArraySizes_template.get_MAXSIZE()) {
					list_arraySizes_length = i1 + 1;
					break;
				}
			}
		}
		
		return list_arraySizes_new;
	}
	
	
	private int returnNextArraySize(final int[] usedArraySize_precedent) {
		int arrayLength_new = (int) (usedArraySize_precedent[2] * MULTIPLELENGTHOFANOTHERARRAYS);
		
		// Never smaller length.
		if (arrayLength_new < usedArraySize_precedent[2]) {
			arrayLength_new = usedArraySize_precedent[2];
		}
		
		// Check max size.
		if ((long) arrayLength_new + usedArraySize_precedent[1] > LIST_predefinedArraySizes_template.get_MAXSIZE()) {
			arrayLength_new = (int) (LIST_predefinedArraySizes_template.get_MAXSIZE() - usedArraySize_precedent[1]);
		}
		
		return arrayLength_new;
	}

}
