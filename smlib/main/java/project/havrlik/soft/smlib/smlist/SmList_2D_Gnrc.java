package main.java.project.havrlik.soft.smlib.smlist;

public class SmList_2D_Gnrc<E> extends SmList_SteadyColumns {
	
	protected int COLUMNSQUANTITY = 0;
	@SuppressWarnings("rawtypes")
	protected SmList_2D_Gnrc_Partial[] listAggregated;
	
	
	public SmList_2D_Gnrc(int columnsQuantity) {
		super();
		mutualConstructor_2D(columnsQuantity);
		
		clear();
	}
	
	
	public SmList_2D_Gnrc(int columnsQuantity, SmList_Size useArraySizesModel) {
		super(useArraySizesModel);
		mutualConstructor_2D(columnsQuantity);
		
		clear();
	}
	
	
	public SmList_2D_Gnrc(int columnsQuantity, int higherMediumSizeOfList) {
		super(higherMediumSizeOfList);
		mutualConstructor_2D(columnsQuantity);
		
		clear();
	}
	
	
	private void mutualConstructor_2D(int columnsQuantity) {
		COLUMNSQUANTITY = columnsQuantity;
	}
	
	
	//@Override
	public void addRow(E[] itemRow) {
		maxWritedRowNumber++;
		putRow(maxWritedRowNumber, itemRow);
	}
	
	
	//@Override
	public void addRow_shallow(String[] itemRow) {
		maxWritedRowNumber++;
		putRow_shallow(maxWritedRowNumber, itemRow);
	}
	
	
	//@Override
	public void addValue(int columnNumber, E value) {
		maxWritedRowNumber++;
		putValue(maxWritedRowNumber, columnNumber, value);
	}
	
	
	//@Override
	@SuppressWarnings("unchecked")
	public void putRow(int rowNumber, E[] itemRow) {
		determineArrayNumberAndRowNumberInArray(rowNumber);
		
		listAggregated[arrayNumber].putRow(rowNumberInArray, itemRow);
		
		if (rowNumber > maxWritedRowNumber) {
			maxWritedRowNumber = rowNumber;
		}
	}
	
	
	//@Override
	@SuppressWarnings("unchecked")
	public void putRow_shallow(int rowNumber, String[] itemRow) {
		determineArrayNumberAndRowNumberInArray(rowNumber);
		
		listAggregated[arrayNumber].putRow_shallow(rowNumberInArray, itemRow);
		
		if (rowNumber > maxWritedRowNumber) {
			maxWritedRowNumber = rowNumber;
		}
	}
	
	
	//@Override
	@SuppressWarnings("unchecked")
	public void putValue(int rowNumber, int columnNumber, E value) {
		determineArrayNumberAndRowNumberInArray(rowNumber);
		
		listAggregated[arrayNumber].putValue(rowNumberInArray, columnNumber, value);
		
		if (rowNumber > maxWritedRowNumber) {
			maxWritedRowNumber = rowNumber;
		}
	}
	
	
	//@Override
	@SuppressWarnings("unchecked")
	public E[] getRow(int rowNumber) {
		if (determineArrayNumberAndRowNumberInArray_notAddingArrays(rowNumber)) {
			return (E[]) listAggregated[arrayNumber].getRow(rowNumberInArray);
		}
		
		return null;
	}
	
	
	//@Override
	@SuppressWarnings("unchecked")
	public E[] getRow_shallow(int rowNumber) {
		if (determineArrayNumberAndRowNumberInArray_notAddingArrays(rowNumber)) {
			return (E[]) listAggregated[arrayNumber].getRow_shallow(rowNumberInArray);
		}
		
		return null;
	}
	
	
	//@Override
	@SuppressWarnings("unchecked")
	public E getValue(int rowNumber, int columnNumber) {
		if (determineArrayNumberAndRowNumberInArray_notAddingArrays(rowNumber)) {
			return (E) listAggregated[arrayNumber].getValue(rowNumberInArray, columnNumber);
		}
		
		return null;
	}
	
	
	public final int get_columnsQuantity() {
		return COLUMNSQUANTITY;
	}
	
	
	@Override
	@SuppressWarnings("unchecked")
	public void clearRow(int rowNumber) {
		if (determineArrayNumberAndRowNumberInArray_notAddingArrays(rowNumber)) {
			listAggregated[arrayNumber].putRow(rowNumberInArray, new String[COLUMNSQUANTITY]);
		}
	}
	
	
	//@Override
	@SuppressWarnings("unchecked")
	public void clearRow_deep(int rowNumber) {
		if (determineArrayNumberAndRowNumberInArray_notAddingArrays(rowNumber)) {
			for (int i1 = 0; i1 < COLUMNSQUANTITY; i1++) {
				listAggregated[arrayNumber].putValue(rowNumberInArray, i1, null);
			}
		}
	}
	
	
	//@Override
	@SuppressWarnings("unchecked")
	public void clearValue(int rowNumber, int columnNumber) {
		if (determineArrayNumberAndRowNumberInArray_notAddingArrays(rowNumber)) {
			listAggregated[arrayNumber].putValue(rowNumberInArray, columnNumber, null);
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
	@SuppressWarnings("rawtypes")
	protected void addArrayToList() {
		if (listAggregated == null || listAggregated.length == 0) {
			// Empty list - create first array.
			createNew_list_arraySizes();
			
			// New list.
			listAggregated = null;
			listAggregated = new SmList_2D_Gnrc_Partial[list_arraySizes_length];
		}
		else if (listAggregated_initializedQuantity == list_arraySizes_length) {
			// Non empty list, so increase.
			increase_list_arraySizes();
			
			// Copy list.
			SmList_2D_Gnrc_Partial[] list_new = new SmList_2D_Gnrc_Partial[list_arraySizes_length];
			for (int i1 = 0; i1 < listAggregated.length; i1++) {
				list_new[i1] = listAggregated[i1];
			}
			listAggregated = list_new;
		}
		
		addAnotherOneArrayToList();
	}
	
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	protected void addAnotherOneArrayToList() {
		int newArrayRowQuantity = list_arraySizes[listAggregated_initializedQuantity][2];
		listAggregated[listAggregated_initializedQuantity] = new SmList_2D_Gnrc_Partial(newArrayRowQuantity, COLUMNSQUANTITY);
		listAggregated_initializedQuantity++;
		size_real += newArrayRowQuantity;
	}
	
	
	// Additional methods.
	//@Override
	public boolean is_listContainsValue(int columnNumber, E value) {
		for (int i1 = 0; i1 < size(); i1++) {
			E valueFromList = getValue(i1, columnNumber);
			if (valueFromList.equals(value)) {
				return true;
			}
		}
		return false;
	}

}
