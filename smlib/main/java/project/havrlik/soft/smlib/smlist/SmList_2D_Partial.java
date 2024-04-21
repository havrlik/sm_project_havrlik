package main.java.project.havrlik.soft.smlib.smlist;

abstract class SmList_2D_Partial extends SmList_Partial {
	
	protected int columnsQuantity = 0;
	
	/*
	 * Variable with certain type need to create:
	 * 
	 * protected <T> listPartial[][];
	 */
	
	
	protected SmList_2D_Partial(int rowsQuantity, int columnsQuantity) {
		super(rowsQuantity);
		this.columnsQuantity = columnsQuantity;
	}
	
	
	/*
	 * Abstract methods with certain passed or returned type:
	 * 
	 * putRow();
	 * putRow_shallow();
	 * putValue();
	 * getRow();
	 * getRow_shallow();
	 * getValue();
	 */

}
