package main.java.project.havrlik.soft.smlib.smlist;

class SmList_1D_int_Partial extends SmList_1D_Partial {
	
	protected int[] listPartial;
	
	
	protected SmList_1D_int_Partial(int rowsQuantity) {
		super(rowsQuantity);
		listPartial = new int[this.rowsQuantity];
	}
	
	
	//@Override
	void putValue(int rowNumber, int value) {
		listPartial[rowNumber] = value;
	}
	
	
	//@Override
	int getValue(int rowNumber) {
		return listPartial[rowNumber];
	}

}
