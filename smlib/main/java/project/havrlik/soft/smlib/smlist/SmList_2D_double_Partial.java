package main.java.project.havrlik.soft.smlib.smlist;

class SmList_2D_double_Partial extends SmList_2D_Partial {
	
	protected double[][] listPartial;
	
	
	protected SmList_2D_double_Partial(int rowsQuantity, int columnsQuantity) {
		super(rowsQuantity, columnsQuantity);
		listPartial = new double[this.rowsQuantity][this.columnsQuantity];
	}
	
	
	//@Override
	void putRow(int rowNumber, double[] itemRow) {
		for (int i1 = 0; i1 < columnsQuantity; i1++) {
			listPartial[rowNumber][i1] = itemRow[i1];
		}
	}
	
	
	//@Override
	void putRow_shallow(int rowNumber, double[] itemRow) {
		listPartial[rowNumber] = itemRow;
	}
	
	
	//@Override
	void putValue(int rowNumber, int columnNumber, double value) {
		listPartial[rowNumber][columnNumber] = value;
	}
	
	
	//@Override
	double[] getRow(int rowNumber) {
		double[] row = new double[columnsQuantity];
		for (int i1 = 0; i1 < columnsQuantity; i1++) {
			row[i1] = listPartial[rowNumber][i1];
		}
		return row;
	}
	
	
	//@Override
	double[] getRow_shallow(int rowNumber) {
		return listPartial[rowNumber];
	}
	
	
	//@Override
	double getValue(int rowNumber, int columnNumber) {
		return listPartial[rowNumber][columnNumber];
	}

}
