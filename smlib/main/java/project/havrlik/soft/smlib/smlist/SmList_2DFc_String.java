package main.java.project.havrlik.soft.smlib.smlist;

public class SmList_2DFc_String extends SmList_2DFloatColumns {
	
	protected SmList_2DFc_String_Partial[] listAggregated;
	
	
	public SmList_2DFc_String() {
		super();
	}
	
	
	public SmList_2DFc_String(SmList_Size useArraySizesModel_rows, SmList_Size useArraySizesModel_columns) {
		super(useArraySizesModel_rows, useArraySizesModel_columns);
	}
	
	
	//@Override
	public void addRow(String[] itemRow) {
		maxWritedRowNumber++;
		putRow(maxWritedRowNumber, itemRow);
	}
	
	
	//@Override
	public void addRow_SM1DList(SmList_1D_String listRow) {
		maxWritedRowNumber++;
		putRow_SM1DList(maxWritedRowNumber, listRow);
	}
	
	
	//@Override
	public void addRow_SM1DList_deep(SmList_1D_String listRow) {
		maxWritedRowNumber++;
		putRow_SM1DList_deep(maxWritedRowNumber, listRow);
	}
	
	
	//@Override
	public void addValue(int columnNumber, String value) {
		maxWritedRowNumber++;
		putValue(maxWritedRowNumber, columnNumber, value);
	}
	
	
	//@Override
	public void putRow(int rowNumber, String[] itemRow) {
		determineArrayNumberAndRowNumberInArray(rowNumber);
		
		listAggregated[arrayNumber].putRow(rowNumberInArray, itemRow);
		
		if (rowNumber > maxWritedRowNumber) {
			maxWritedRowNumber = rowNumber;
		}
	}
	
	
	//@Override
	public void putRow_SM1DList(int rowNumber, SmList_1D_String listRow) {
		determineArrayNumberAndRowNumberInArray(rowNumber);
		
		listAggregated[arrayNumber].putRow(rowNumberInArray, listRow);
		
		if (rowNumber > maxWritedRowNumber) {
			maxWritedRowNumber = rowNumber;
		}
	}
	
	
	//@Override
	public void putRow_SM1DList_deep(int rowNumber, SmList_1D_String listRow) {
		determineArrayNumberAndRowNumberInArray(rowNumber);
		
		listAggregated[arrayNumber].putRow_deep(rowNumberInArray, listRow);
		
		if (rowNumber > maxWritedRowNumber) {
			maxWritedRowNumber = rowNumber;
		}
	}
	
	
	//@Override
	public void addToRow(int rowNumber, String[] itemArray) {
		determineArrayNumberAndRowNumberInArray(rowNumber);
		
		listAggregated[arrayNumber].addToRow(rowNumberInArray, itemArray);
		
		if (rowNumber > maxWritedRowNumber) {
			maxWritedRowNumber = rowNumber;
		}
	}
	
	
	//@Override
	public void addToRow_SM1DList(int rowNumber, SmList_1D_String itemList) {
		determineArrayNumberAndRowNumberInArray(rowNumber);
		
		listAggregated[arrayNumber].addToRow_SM1DList(rowNumberInArray, itemList);
		
		if (rowNumber > maxWritedRowNumber) {
			maxWritedRowNumber = rowNumber;
		}
	}
	
	
	//@Override
	public void putValue(int rowNumber, int columnNumber, String value) {
		determineArrayNumberAndRowNumberInArray(rowNumber);
		
		listAggregated[arrayNumber].putValue(rowNumberInArray, columnNumber, value);
		
		if (rowNumber > maxWritedRowNumber) {
			maxWritedRowNumber = rowNumber;
		}
	}
	
	
	//@Override
	public String[] getRow_array(int rowNumber) {
		determineArrayNumberAndRowNumberInArray_notAddingArrays(rowNumber);
		
		return listAggregated[arrayNumber].getRow_array(rowNumberInArray);
	}
	
	
	//@Override
	public SmList_1D_String getRow_SM1DList(int rowNumber) {
		determineArrayNumberAndRowNumberInArray_notAddingArrays(rowNumber);
		
		return listAggregated[arrayNumber].getRow_SM1DList(rowNumberInArray);
	}
	
	
	//@Override
	public SmList_1D_String getRow_SM1DList_deep(int rowNumber) {
		determineArrayNumberAndRowNumberInArray_notAddingArrays(rowNumber);
		
		return listAggregated[arrayNumber].getRow_SM1DList_deep(rowNumberInArray);
	}
	
	
	//@Override
	public String getValue(int rowNumber, int columnNumber) {
		determineArrayNumberAndRowNumberInArray_notAddingArrays(rowNumber);
		
		return listAggregated[arrayNumber].getValue(rowNumberInArray, columnNumber);
	}
	
	
	@Override
	public void clearRow(int rowNumber) {
		determineArrayNumberAndRowNumberInArray_notAddingArrays(rowNumber);
		listAggregated[arrayNumber].clearRow(rowNumberInArray);
	}
	
	
	@Override
	public void clearRow_deep(int rowNumber) {
		determineArrayNumberAndRowNumberInArray(rowNumber);
		listAggregated[arrayNumber].clearRow_deep(rowNumberInArray);
	}
	
	
	@Override
	public void clearValue(int rowNumber, int columnNumber) {
		determineArrayNumberAndRowNumberInArray(rowNumber);
		listAggregated[arrayNumber].clearValue(rowNumberInArray, columnNumber);
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
	
	
	//@Override
	public int get_columnsQuantity(int rowNumber) {
		determineArrayNumberAndRowNumberInArray_notAddingArrays(rowNumber);
		
		return listAggregated[arrayNumber].getRow_SM1DList(rowNumberInArray).size();
	}
	
	
	@Override
	protected void addArrayToList() {
		if (listAggregated == null || listAggregated.length == 0) {
			// Empty list - create first array.
			createNew_list_arraySizes();
			
			// New list.
			listAggregated = null;
			listAggregated = new SmList_2DFc_String_Partial[list_arraySizes_length];// list of SM lists.
		}
		else if (listAggregated_initializedQuantity == list_arraySizes_length) {
			// Non empty list, so increase.
			increase_list_arraySizes();
			
			// Copy list.
			SmList_2DFc_String_Partial[] list_new = new SmList_2DFc_String_Partial[list_arraySizes_length];
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
		listAggregated[listAggregated_initializedQuantity] = new SmList_2DFc_String_Partial(newArrayRowQuantity, USEARRAYSIZESMODEL_COLUMNS);
		listAggregated_initializedQuantity++;
		size_real += newArrayRowQuantity;
		
//		maxWritedRowNumber++;  // TODO DEL.
//		list[maxWritedRowNumber] = new SM_List_1D_String(USEARRAYSIZESMODEL_COLUMNS);  // TODO DEL.
	}
	
	
	// Additional methods.
	//@Override
	public boolean is_listContainsValue(int columnNumber, String value) {
		for (int i1 = 0; i1 < size(); i1++) {
			if (get_columnsQuantity(i1) > columnNumber) {
				String valueFromList = getValue(i1, columnNumber);
				if (valueFromList.length() == value.length() && valueFromList.equals(value)) {
					return true;
				}
			}
		}
		return false;
	}

}
