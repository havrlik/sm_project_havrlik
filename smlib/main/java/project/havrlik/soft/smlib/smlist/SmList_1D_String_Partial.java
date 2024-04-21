package main.java.project.havrlik.soft.smlib.smlist;

class SmList_1D_String_Partial extends SmList_1D_Partial {
	
	protected String[] listPartial;
	
	
	protected SmList_1D_String_Partial(int rowsQuantity) {
		super(rowsQuantity);
		listPartial = new String[this.rowsQuantity];
	}
	
	
	//@Override
	void putValue(int rowNumber, String value) {
		listPartial[rowNumber] = value;
	}
	
	
	//@Override
	String getValue(int rowNumber) {
		return listPartial[rowNumber];
	}

}
