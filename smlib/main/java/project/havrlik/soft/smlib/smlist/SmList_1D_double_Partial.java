package main.java.project.havrlik.soft.smlib.smlist;

class SmList_1D_double_Partial extends SmList_1D_Partial {
	
	protected double[] listPartial;
	
	
	protected SmList_1D_double_Partial(int rowsQuantity) {
		super(rowsQuantity);
		listPartial = new double[this.rowsQuantity];
	}
	
	
	//@Override
	void putValue(int rowNumber, double value) {
		listPartial[rowNumber] = value;
	}
	
	
	//@Override
	double getValue(int rowNumber) {
		return listPartial[rowNumber];
	}

}
