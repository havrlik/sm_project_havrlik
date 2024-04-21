package main.java.project.havrlik.soft.smlib.smlist;


public class SmList_2D_Gnrc_Partial<E> {
	
	protected int rowsQuantity = 0;
	protected int columnsQuantity = 0;
	protected E[][] listPartial;
	
	
	@SuppressWarnings("unchecked")
	protected SmList_2D_Gnrc_Partial(int rowsQuantity, int columnsQuantity) {
		this.rowsQuantity = rowsQuantity;
		this.columnsQuantity = columnsQuantity;
		listPartial = (E[][]) new Object[this.rowsQuantity][this.columnsQuantity];
	}
	
	
	void putRow(int rowNumber, E[] itemRow) {
		for (int i1 = 0; i1 < columnsQuantity; i1++) {
			listPartial[rowNumber][i1] = itemRow[i1];
		}
	}
	void putRow_shallow(int rowNumber, E[] itemRow) {
		listPartial[rowNumber] = (E[]) itemRow;
	}
	
	
	void putValue(int rowNumber, int columnNumber, E value) {
		listPartial[rowNumber][columnNumber] = value;
	}
	
	
	@SuppressWarnings("unchecked")
	E[] getRow(int rowNumber) {
		E[] row = (E[]) new Object[columnsQuantity];
		for (int i1 = 0; i1 < columnsQuantity; i1++) {
			row[i1] = listPartial[rowNumber][i1];
		}
		return row;
	}
	E[] getRow_shallow(int rowNumber) {
		return (E[]) listPartial[rowNumber];
	}
	
	
	E getValue(int rowNumber, int columnNumber) {
		return (E) listPartial[rowNumber][columnNumber];
	}
	
	
	public final int size() {
		return rowsQuantity;
	}

}
