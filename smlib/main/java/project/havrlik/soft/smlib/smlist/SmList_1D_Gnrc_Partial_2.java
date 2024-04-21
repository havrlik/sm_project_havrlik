package main.java.project.havrlik.soft.smlib.smlist;

import java.lang.reflect.Array;

/*
 * Uses 'Array.newInstance()' istead 'new Object[][]' to initialize generic array.
 */


public class SmList_1D_Gnrc_Partial_2<E> {
	
	protected Class<E> clazz;
	protected int rowsQuantity = 0;
	protected E[] listPartial;
	
	
	@SuppressWarnings("unchecked")
	protected SmList_1D_Gnrc_Partial_2(Class<E> clazz, int rowsQuantity) {
		this.clazz = clazz;
		this.rowsQuantity = rowsQuantity;
		listPartial = (E[]) Array.newInstance(this.clazz, this.rowsQuantity);
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
