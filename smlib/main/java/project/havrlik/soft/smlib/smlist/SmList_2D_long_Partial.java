package main.java.project.havrlik.soft.smlib.smlist;

class SmList_2D_long_Partial extends SmList_2D_Partial {
	
	protected long[][] listPartial;
	
	
	protected SmList_2D_long_Partial(int rowsQuantity, int columnsQuantity) {
		super(rowsQuantity, columnsQuantity);
		listPartial = new long[this.rowsQuantity][this.columnsQuantity];
	}
	
	
	//@Override
	void putRow(int rowNumber, long[] itemRow) {
		for (int i1 = 0; i1 < columnsQuantity; i1++) {
			listPartial[rowNumber][i1] = itemRow[i1];
		}
	}
	
	
	//@Override
	void putRow_shallow(int rowNumber, long[] itemRow) {
		listPartial[rowNumber] = itemRow;
	}
	
	
	//@Override
	void putValue(int rowNumber, int columnNumber, long value) {
		listPartial[rowNumber][columnNumber] = value;
	}
	
	
	//@Override
	long[] getRow(int rowNumber) {
		long[] row = new long[columnsQuantity];
		for (int i1 = 0; i1 < columnsQuantity; i1++) {
			row[i1] = listPartial[rowNumber][i1];
		}
		return row;
	}
	
	
	//@Override
	long[] getRow_shallow(int rowNumber) {
		return listPartial[rowNumber];
	}
	
	
	//@Override
	long getValue(int rowNumber, int columnNumber) {
		return listPartial[rowNumber][columnNumber];
	}

}
