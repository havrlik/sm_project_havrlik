package main.java.project.havrlik.soft.smlib.smlist;

abstract class SmList_2D extends SmList_SteadyColumns {
	
	protected int COLUMNSQUANTITY = 0;
	
	
	protected SmList_2D(int columnsQuantity) {
		super();
		mutualConstructor_2D(columnsQuantity);
		
		clear();
	}
	
	
	protected SmList_2D(int columnsQuantity, SmList_Size useArraySizesModel) {
		super(useArraySizesModel);
		mutualConstructor_2D(columnsQuantity);
		
		clear();
	}
	
	
	protected SmList_2D(int columnsQuantity, int higherMediumSizeOfList) {
		super(higherMediumSizeOfList);
		mutualConstructor_2D(columnsQuantity);
		
		clear();
	}
	
	
	private void mutualConstructor_2D(int columnsQuantity) {
		COLUMNSQUANTITY = columnsQuantity;
	}
	
	
	/*
	 * Abstract methods with certain passed or returned type:
	 * 
	 * addRow();
	 * addRow_shallow();
	 * addValue();
	 * putRow();
	 * putRow_shallow();
	 * putValue();
	 * getRow();
	 * getRow_shallow();
	 * getValue();
	 */
	
	
	public abstract void clearRow_deep(int rowNumber);
	public abstract void clearValue(int rowNumber, int columnNumber);
	
	
	public final int get_columnsQuantity() {
		return COLUMNSQUANTITY;
	}

}
