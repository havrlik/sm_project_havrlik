package main.java.project.havrlik.soft.smlib.smlist;

class SmList_1D_long_Partial extends SmList_1D_Partial {
	
	protected long[] listPartial;
	
	
	protected SmList_1D_long_Partial(int rowsQuantity) {
		super(rowsQuantity);
		listPartial = new long[this.rowsQuantity];
	}
	
	
	//@Override
	void putValue(int rowNumber, long value) {
		listPartial[rowNumber] = value;
	}
	
	
	//@Override
	long getValue(int rowNumber) {
		return listPartial[rowNumber];
	}

}
