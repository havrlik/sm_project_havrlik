package main.java.project.havrlik.soft.smlib.smlist;

public class SmList_2D_int extends SmList_2D {
	
	protected SmList_2D_int_Partial[] listAggregated;
	
	
	public SmList_2D_int(int columnsQuantity) {
		super(columnsQuantity);
	}
	
	
	public SmList_2D_int(int columnsQuantity, SmList_Size useArraySizesModel) {
		super(columnsQuantity, useArraySizesModel);
	}
	
	
	public SmList_2D_int(int columnsQuantity, int higherMediumSizeOfList) {
		super(columnsQuantity, higherMediumSizeOfList);
	}
	
	
	//@Override
	public void addRow(int[] itemRow) {
		maxWritedRowNumber++;
		putRow(maxWritedRowNumber, itemRow);
	}
	
	
	//@Override
	public void addRow_shallow(int[] itemRow) {
		maxWritedRowNumber++;
		putRow_shallow(maxWritedRowNumber, itemRow);
	}
	
	
	//@Override
	public void addValue(int columnNumber, int value) {
		maxWritedRowNumber++;
		putValue(maxWritedRowNumber, columnNumber, value);
	}
	
	
	//@Override
	public void putRow(int rowNumber, int[] itemRow) {
		determineArrayNumberAndRowNumberInArray(rowNumber);
		
		listAggregated[arrayNumber].putRow(rowNumberInArray, itemRow);
		
		if (rowNumber > maxWritedRowNumber) {
			maxWritedRowNumber = rowNumber;
		}
	}
	
	
	//@Override
	public void putRow_shallow(int rowNumber, int[] itemRow) {
		determineArrayNumberAndRowNumberInArray(rowNumber);
		
		listAggregated[arrayNumber].putRow_shallow(rowNumberInArray, itemRow);
		
		if (rowNumber > maxWritedRowNumber) {
			maxWritedRowNumber = rowNumber;
		}
	}
	
	
	//@Override
	public void putValue(int rowNumber, int columnNumber, int value) {
		determineArrayNumberAndRowNumberInArray(rowNumber);
		
		listAggregated[arrayNumber].putValue(rowNumberInArray, columnNumber, value);
		
		if (rowNumber > maxWritedRowNumber) {
			maxWritedRowNumber = rowNumber;
		}
	}
	
	
	//@Override
	public int[] getRow(int rowNumber) {
		if (determineArrayNumberAndRowNumberInArray_notAddingArrays(rowNumber)) {
			return listAggregated[arrayNumber].getRow(rowNumberInArray);
		}
		
		return null;
	}
	
	
	//@Override
	public int[] getRow_shallow(int rowNumber) {
		if (determineArrayNumberAndRowNumberInArray_notAddingArrays(rowNumber)) {
			return listAggregated[arrayNumber].getRow_shallow(rowNumberInArray);
		}
		
		return null;
	}
	
	
	//@Override
	public int getValue(int rowNumber, int columnNumber) {
		if (determineArrayNumberAndRowNumberInArray_notAddingArrays(rowNumber)) {
			return listAggregated[arrayNumber].getValue(rowNumberInArray, columnNumber);
		}
		
		return 0;
	}
	
	
	@Override
	public void clearRow(int rowNumber) {
		if (determineArrayNumberAndRowNumberInArray_notAddingArrays(rowNumber)) {
			listAggregated[arrayNumber].putRow(rowNumberInArray, new int[COLUMNSQUANTITY]);
		}
	}
	
	
	@Override
	public void clearRow_deep(int rowNumber) {
		if (determineArrayNumberAndRowNumberInArray_notAddingArrays(rowNumber)) {
			for (int i1 = 0; i1 < COLUMNSQUANTITY; i1++) {
				listAggregated[arrayNumber].putValue(rowNumberInArray, i1, 0);
			}
		}
	}
	
	
	@Override
	public void clearValue(int rowNumber, int columnNumber) {
		if (determineArrayNumberAndRowNumberInArray_notAddingArrays(rowNumber)) {
			listAggregated[arrayNumber].putValue(rowNumberInArray, columnNumber, 0);
		}
	}
	
	
	@Override
	public void clear() {
		if (listAggregated != null && listAggregated.length != 0) {
			for (int i1 = 0; i1 < listAggregated.length; i1++) {
				listAggregated[i1] = null;
			}
		}
		listAggregated = null;
		
		addArrayToList();
	}
	
	
	@Override
	protected void addArrayToList() {
		if (listAggregated == null || listAggregated.length == 0) {
			// Empty list - create first array.
			createNew_list_arraySizes();
			
			// New list.
			listAggregated = null;
			listAggregated = new SmList_2D_int_Partial[list_arraySizes_length];
		}
		else if (listAggregated_initializedQuantity == list_arraySizes_length) {
			// Non empty list, so increase.
			increase_list_arraySizes();
			
			// Copy list.
			SmList_2D_int_Partial[] list_new = new SmList_2D_int_Partial[list_arraySizes_length];
			for (int i1 = 0; i1 < listAggregated.length; i1++) {
				list_new[i1] = listAggregated[i1];
			}
			listAggregated = list_new;
		}
		
		addAnotherOneArrayToList();
	}
	
	
	@Override
	protected void addAnotherOneArrayToList() {
		int newArrayRowQuantity = list_arraySizes[listAggregated_initializedQuantity][2];
		listAggregated[listAggregated_initializedQuantity] = new SmList_2D_int_Partial(newArrayRowQuantity, COLUMNSQUANTITY);
		listAggregated_initializedQuantity++;
		size_real += newArrayRowQuantity;
	}
	
	
	// Additional methods.
	//@Override
	public boolean is_listContainsValue(int columnNumber, int value) {
		for (int i1 = 0; i1 < size(); i1++) {
			if (getValue(i1, columnNumber) == value) {
				return true;
			}
		}
		return false;
	}

}
