package main.java.project.havrlik.soft.smlib.smlist;

public class SmList_1D_double extends SmList_1D {
	
	protected SmList_1D_double_Partial[] listAggregated;
	
	
	public SmList_1D_double() {
		super();
	}
	
	
	public SmList_1D_double(SmList_Size useArraySizesModel) {
		super(useArraySizesModel);
	}
	
	
	public SmList_1D_double(int higherMediumSizeOfList) {
		super(higherMediumSizeOfList);
	}
	
	
	//@Override
	public void addValue(double value) {
		putValue(maxWritedRowNumber + 1, value);
	}
	
	
	//@Override
	public void addArray(double[] array) {
		for (int i1 = 0; i1 < array.length; i1++) {
			putValue(maxWritedRowNumber + 1, array[i1]);
		}
	}
	
	
	//@Override
	public void putValue(int rowNumber, double value) {
		determineArrayNumberAndRowNumberInArray(rowNumber);
		
		listAggregated[arrayNumber].putValue(rowNumberInArray, value);
		
		if (rowNumber > maxWritedRowNumber) {
			maxWritedRowNumber = rowNumber;
		}
	}
	
	
	//@Override
	public void putArray(double[] array) {
		clear();
		for (int i1 = 0; i1 < array.length; i1++) {
			putValue(i1, array[i1]);
		}
	}
	
	
	//@Override
	public double getValue(int rowNumber) {
		if (determineArrayNumberAndRowNumberInArray_notAddingArrays(rowNumber)) {
			return listAggregated[arrayNumber].getValue(rowNumberInArray);
		}
		
		return 0.0;
	}
	
	
	//@Override
	public double[] getArray() {
		double[] array = new double[size()];
		for (int i1 = 0; i1 < array.length; i1++) {
			array[i1] = getValue(i1);
		}
		
		return array;
	}
	
	
	@Override
	public void clearRow(int rowNumber) {  // Same like method 'clearValue()'.
		clearValue(rowNumber);
	}
	
	
	@Override
	public void clearValue(int rowNumber) {
		if (determineArrayNumberAndRowNumberInArray_notAddingArrays(rowNumber)) {
			listAggregated[arrayNumber].putValue(rowNumberInArray, 0.0);
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
			listAggregated = new SmList_1D_double_Partial[list_arraySizes_length];
		}
		else if (listAggregated_initializedQuantity == list_arraySizes_length) {
			// Non empty list, so increase.
			increase_list_arraySizes();
			
			// Copy list.
			SmList_1D_double_Partial[] list_new = new SmList_1D_double_Partial[list_arraySizes_length];
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
		listAggregated[listAggregated_initializedQuantity] = new SmList_1D_double_Partial(newArrayRowQuantity);
		listAggregated_initializedQuantity++;
		size_real += newArrayRowQuantity;
	}
	
	
	// Additional methods.
	//@Override
	public boolean is_listContainsValue(double value) {
		for (int i1 = 0; i1 < size(); i1++) {
			if (getValue(i1) == value) {
				return true;
			}
		}
		return false;
	}

}
