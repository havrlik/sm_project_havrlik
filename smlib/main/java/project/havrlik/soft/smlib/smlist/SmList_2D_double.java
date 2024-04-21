package main.java.project.havrlik.soft.smlib.smlist;

public class SmList_2D_double extends SmList_2D {
	
	protected SmList_2D_double_Partial[] listAggregated;
	
	
	public SmList_2D_double(int columnsQuantity) {
		super(columnsQuantity);
	}
	
	
	public SmList_2D_double(int columnsQuantity, SmList_Size useArraySizesModel) {
		super(columnsQuantity, useArraySizesModel);
	}
	
	
	public SmList_2D_double(int columnsQuantity, int higherMediumSizeOfList) {
		super(columnsQuantity, higherMediumSizeOfList);
	}
	
	
	//@Override
	public void addRow(double[] itemRow) {
		maxWritedRowNumber++;
		putRow(maxWritedRowNumber, itemRow);
	}
	
	
	//@Override
	public void addRow_shallow(double[] itemRow) {
		maxWritedRowNumber++;
		putRow_shallow(maxWritedRowNumber, itemRow);
	}
	
	
	//@Override
	public void addValue(int columnNumber, double value) {
		maxWritedRowNumber++;
		putValue(maxWritedRowNumber, columnNumber, value);
	}
	
	
	//@Override
	public void putRow(int rowNumber, double[] itemRow) {
		determineArrayNumberAndRowNumberInArray(rowNumber);
		
		listAggregated[arrayNumber].putRow(rowNumberInArray, itemRow);
		
		if (rowNumber > maxWritedRowNumber) {
			maxWritedRowNumber = rowNumber;
		}
	}
	
	
	//@Override
	public void putRow_shallow(int rowNumber, double[] itemRow) {
		determineArrayNumberAndRowNumberInArray(rowNumber);
		
		listAggregated[arrayNumber].putRow_shallow(rowNumberInArray, itemRow);
		
		if (rowNumber > maxWritedRowNumber) {
			maxWritedRowNumber = rowNumber;
		}
	}
	
	
	//@Override
	public void putValue(int rowNumber, int columnNumber, double value) {
		determineArrayNumberAndRowNumberInArray(rowNumber);
		
		listAggregated[arrayNumber].putValue(rowNumberInArray, columnNumber, value);
		
		if (rowNumber > maxWritedRowNumber) {
			maxWritedRowNumber = rowNumber;
		}
	}
	
	
	//@Override
	public double[] getRow(int rowNumber) {
		if (determineArrayNumberAndRowNumberInArray_notAddingArrays(rowNumber)) {
			return listAggregated[arrayNumber].getRow(rowNumberInArray);
		}
		
		return null;
	}
	
	
	//@Override
	public double[] getRow_shallow(int rowNumber) {
		if (determineArrayNumberAndRowNumberInArray_notAddingArrays(rowNumber)) {
			return listAggregated[arrayNumber].getRow_shallow(rowNumberInArray);
		}
		
		return null;
	}
	
	
	//@Override
	public double getValue(int rowNumber, int columnNumber) {
		if (determineArrayNumberAndRowNumberInArray_notAddingArrays(rowNumber)) {
			return listAggregated[arrayNumber].getValue(rowNumberInArray, columnNumber);
		}
		
		return 0.0;
	}
	
	
	@Override
	public void clearRow(int rowNumber) {
		if (determineArrayNumberAndRowNumberInArray_notAddingArrays(rowNumber)) {
			listAggregated[arrayNumber].putRow(rowNumberInArray, new double[COLUMNSQUANTITY]);
		}
	}
	
	
	@Override
	public void clearRow_deep(int rowNumber) {
		if (determineArrayNumberAndRowNumberInArray_notAddingArrays(rowNumber)) {
			for (int i1 = 0; i1 < COLUMNSQUANTITY; i1++) {
				listAggregated[arrayNumber].putValue(rowNumberInArray, i1, 0.0);
			}
		}
	}
	
	
	@Override
	public void clearValue(int rowNumber, int columnNumber) {
		if (determineArrayNumberAndRowNumberInArray_notAddingArrays(rowNumber)) {
			listAggregated[arrayNumber].putValue(rowNumberInArray, columnNumber, 0.0);
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
			listAggregated = new SmList_2D_double_Partial[list_arraySizes_length];
		}
		else if (listAggregated_initializedQuantity == list_arraySizes_length) {
			// Non empty list, so increase.
			increase_list_arraySizes();
			
			// Copy list.
			SmList_2D_double_Partial[] list_new = new SmList_2D_double_Partial[list_arraySizes_length];
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
		listAggregated[listAggregated_initializedQuantity] = new SmList_2D_double_Partial(newArrayRowQuantity, COLUMNSQUANTITY);
		listAggregated_initializedQuantity++;
		size_real += newArrayRowQuantity;
	}
	
	
	// Additional methods.
	//@Override
	public boolean is_listContainsValue(int columnNumber, double value) {
		for (int i1 = 0; i1 < size(); i1++) {
			if (getValue(i1, columnNumber) == value) {
				return true;
			}
		}
		return false;
	}

}
