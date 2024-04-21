package main.java.project.havrlik.soft.smlib.smlist;

class SmList_2DFc_String_Partial {
	
	protected SmList_Size USEARRAYSIZESMODEL_COLUMNS;
	protected int rowsQuantity = 0;
	protected SmList_1D_String[] listPartial;
	
	/*
	 * Variable with certain type need to create:
	 * 
	 * listPartial;
	 */
	
	
	protected SmList_2DFc_String_Partial(int rowsQuantity, SmList_Size useArraySizesModel_columns) {
		// Current version without inheriting.
		this.USEARRAYSIZESMODEL_COLUMNS = useArraySizesModel_columns;
		this.rowsQuantity = rowsQuantity;
		listPartial = new SmList_1D_String[this.rowsQuantity];
	}
	
	
	protected final int size() {
		return rowsQuantity;
	}
	
	
	// Super class:
	/*
	 * Abstract methods with certain passed or returned type:
	 * 
	 * putRow();
	 * putRow();  SM_List_1D_
	 * putRow_deep();
	 * addToRow();
	 * addToRow();  SM_List_1D_
	 * putValue();
	 * getRow_array();
	 * getRow_SM1DList();
	 * getRow_SM1DList_deep();
	 * getValue();
	 * clearRow();
	 * clearRow_deep();
	 * clearValue();
	 */
	
	
	//@Override
	void putRow(int rowNumber, String[] itemRow) {
		listPartial[rowNumber] = new SmList_1D_String(USEARRAYSIZESMODEL_COLUMNS);
		listPartial[rowNumber].addArray(itemRow);
	}
	
	
	//@Override
	void putRow(int rowNumber, SmList_1D_String itemRow) {
		listPartial[rowNumber] = itemRow;
	}
	
	
	//@Override
	void putRow_deep(int rowNumber, SmList_1D_String itemRow) {
		listPartial[rowNumber] = new SmList_1D_String(USEARRAYSIZESMODEL_COLUMNS);
		for (int i1 = 0; i1 < itemRow.size(); i1++) {
			listPartial[rowNumber].addValue(itemRow.getValue(i1));
		}
	}
	
	
	//@Override
	void addToRow(int rowNumber, String[] itemRow) {
		if (listPartial[rowNumber] == null) {
			listPartial[rowNumber] = new SmList_1D_String(USEARRAYSIZESMODEL_COLUMNS);
		}
		listPartial[rowNumber].addArray(itemRow);
	}
	
	
	//@Override
	void addToRow_SM1DList(int rowNumber, SmList_1D_String itemRow) {
		if (listPartial[rowNumber] == null) {
			listPartial[rowNumber] = new SmList_1D_String(USEARRAYSIZESMODEL_COLUMNS);
		}
		for (int i1 = 0; i1 < itemRow.size(); i1++) {
			listPartial[rowNumber].addValue(itemRow.getValue(i1));
		}
	}
	
	
	//@Override
	void putValue(int rowNumber, int columnNumber, String itemRow) {
		if (listPartial[rowNumber] == null) {
			listPartial[rowNumber] = new SmList_1D_String(USEARRAYSIZESMODEL_COLUMNS);
		}
		listPartial[rowNumber].putValue(columnNumber, itemRow);
	}
	
	
	//@Override
	String[] getRow_array(int rowNumber) {
		if (listPartial[rowNumber] == null) {
			return null;
		}
		String[] row = new String[listPartial[rowNumber].size()];
		for (int i1 = 0; i1 < listPartial[rowNumber].size(); i1++) {
			row[i1] = listPartial[rowNumber].getValue(i1);
		}
		return row;
	}
	
	
	//@Override
	SmList_1D_String getRow_SM1DList(int rowNumber) {
		return listPartial[rowNumber];
	}
	
	
	//@Override
	SmList_1D_String getRow_SM1DList_deep(int rowNumber) {
		if (listPartial[rowNumber] == null) {
			return null;
		}
		SmList_1D_String row = new SmList_1D_String(USEARRAYSIZESMODEL_COLUMNS);
		for (int i1 = 0; i1 < listPartial[rowNumber].size(); i1++) {
			row.addValue(listPartial[rowNumber].getValue(i1));
		}
		return row;
	}
	
	
	//@Override
	String getValue(int rowNumber, int columnNumber) {
		if (listPartial[rowNumber] == null) {
			return null;
		}
		return listPartial[rowNumber].getValue(columnNumber);
	}
	
	
	//@Override
	void clearRow(int rowNumber) {
		if (listPartial[rowNumber] == null) {
			return;
		}
		listPartial[rowNumber] = null;
	}
	
	
	//@Override
	void clearRow_deep(int rowNumber) {
		if (listPartial[rowNumber] == null) {
			return;
		}
		for (int i1 = 0; i1 < listPartial[rowNumber].size(); i1++) {
			listPartial[rowNumber].putValue(i1, null);
		}
		listPartial[rowNumber] = null;
	}
	
	
	//@Override
	void clearValue(int rowNumber, int columnNumber) {
		if (listPartial[rowNumber] == null) {
			return;
		}
		listPartial[rowNumber].clearValue(columnNumber);
	}

}
