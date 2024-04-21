package main.java.project.havrlik.soft.smlib.smlist;

/*
 * Not suitable to huge sizes, because every row is another object of SM_List_1D.
 */

abstract class SmList_2DFloatColumns extends SmList_FloatColumns {
	
	/*
	 * Variable with certain type need to create:
	 * 
	 * protected <T>[] listAggregated;
	 */
	
	
	protected SmList_2DFloatColumns() {
		super();
		
		clear();
	}
	
	
	protected SmList_2DFloatColumns(SmList_Size useArraySizesModel_rows, SmList_Size useArraySizesModel_columns) {
		super(useArraySizesModel_rows, useArraySizesModel_columns);
		
		clear();
	}
	
	
	/*
	 * Abstract methods with certain passed or returned type:
	 * 
	 * addRow();
	 * addRow_SM1DList();
	 * addRow_SM1DList_deep();
	 * addValue();
	 * putRow();
	 * putRow_SM1DList();
	 * putRow_SM1DList_deep();
	 * addToRow();
	 * addToRow_SM1DList();
	 * putValue();
	 * getRow_array();
	 * getRow_SM1DList();
	 * getRow_SM1DList_deep();
	 * getValue();
	 */
	
	
	public abstract void clearRow_deep(int rowNumber);
	public abstract void clearValue(int rowNumber, int columnNumber);

}
