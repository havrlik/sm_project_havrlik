package main.java.project.havrlik.soft.smlib.smlist;


public class SmList_1D_Gnrc_Partial<E> {
	
	protected int rowsQuantity = 0;
	protected E[] listPartial;
	
	
	@SuppressWarnings("unchecked")
	protected SmList_1D_Gnrc_Partial(int rowsQuantity) {
		this.rowsQuantity = rowsQuantity;
		listPartial = (E[]) new Object[this.rowsQuantity];
	}
	
	
	void putValue(int rowNumber, E value) {
		listPartial[rowNumber] = value;
	}
	
	
	E getValue(int rowNumber) {
		return (E) listPartial[rowNumber];
	}
	
	
	public final int size() {
		return rowsQuantity;
	}

}
