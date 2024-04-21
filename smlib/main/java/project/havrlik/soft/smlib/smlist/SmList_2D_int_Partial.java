package main.java.project.havrlik.soft.smlib.smlist;

class SmList_2D_int_Partial extends SmList_2D_Partial {
	
	protected int[][] listPartial;
	
	
	protected SmList_2D_int_Partial(int rowsQuantity, int columnsQuantity) {
		super(rowsQuantity, columnsQuantity);
		listPartial = new int[this.rowsQuantity][this.columnsQuantity];
	}
	
	
	//@Override
	void putRow(int rowNumber, int[] itemRow) {
		for (int i1 = 0; i1 < columnsQuantity; i1++) {
			listPartial[rowNumber][i1] = itemRow[i1];
		}
	}
	
	
	//@Override
	void putRow_shallow(int rowNumber, int[] itemRow) {
		listPartial[rowNumber] = itemRow;
	}
	
	
	//@Override
	void putValue(int rowNumber, int columnNumber, int value) {
		listPartial[rowNumber][columnNumber] = value;
	}
	
	
	//@Override
	int[] getRow(int rowNumber) {
		int[] row = new int[columnsQuantity];
		for (int i1 = 0; i1 < columnsQuantity; i1++) {
			row[i1] = listPartial[rowNumber][i1];
		}
		return row;
	}
	
	
	//@Override
	int[] getRow_shallow(int rowNumber) {
		return listPartial[rowNumber];
	}
	
	
	//@Override
	int getValue(int rowNumber, int columnNumber) {
		return listPartial[rowNumber][columnNumber];
	}

}
