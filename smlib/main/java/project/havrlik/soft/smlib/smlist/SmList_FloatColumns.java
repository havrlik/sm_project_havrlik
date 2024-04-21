package main.java.project.havrlik.soft.smlib.smlist;

abstract class SmList_FloatColumns extends SmList {
	
	protected SmList_Size USEARRAYSIZESMODEL_COLUMNS;
	
	
	protected SmList_FloatColumns() {
		super();
		USEARRAYSIZESMODEL_COLUMNS = SmList_Size.TINY_16;
	}
	
	
	protected SmList_FloatColumns(SmList_Size useArraySizesModel_rows, SmList_Size useArraySizesModel_columns) {
		super(useArraySizesModel_rows);
		USEARRAYSIZESMODEL_COLUMNS = useArraySizesModel_columns;
	}
	
	
	/*
	 * Abstract methods with certain passed or returned type:
	 * 
	 * get_columnsQuantity();
	 */

}
