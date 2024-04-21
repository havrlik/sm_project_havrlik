package main.java.project.havrlik.soft.smlib.smlist;

class SmList_2D_String_Partial extends SmList_2D_Partial {
	
	protected String[][] listPartial;
	
	
	protected SmList_2D_String_Partial(int rowsQuantity, int columnsQuantity) {
		super(rowsQuantity, columnsQuantity);
		listPartial = new String[this.rowsQuantity][this.columnsQuantity];
	}
	
	
	//@Override
	void putRow(int rowNumber, String[] itemRow) {
		for (int i1 = 0; i1 < columnsQuantity; i1++) {
			listPartial[rowNumber][i1] = itemRow[i1];
		}
	}
	
	
	//@Override
	void putRow_shallow(int rowNumber, String[] itemRow) {
		listPartial[rowNumber] = itemRow;
	}
	
	
	//@Override
	void putValue(int rowNumber, int columnNumber, String value) {
		listPartial[rowNumber][columnNumber] = value;
	}
	
	
	//@Override
	String[] getRow(int rowNumber) {
		String[] row = new String[columnsQuantity];
		for (int i1 = 0; i1 < columnsQuantity; i1++) {
			row[i1] = listPartial[rowNumber][i1];
		}
		return row;
	}
	
	
	//@Override
	String[] getRow_shallow(int rowNumber) {
		return listPartial[rowNumber];
	}
	
	
	//@Override
	String getValue(int rowNumber, int columnNumber) {
		return listPartial[rowNumber][columnNumber];
	}

}
