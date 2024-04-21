package main.java.project.havrlik.soft.smlib.smlist;

public class SmList_1D_byte_Partial extends SmList_1D_Partial {
	
	protected byte[] listPartial;
	
	
	protected SmList_1D_byte_Partial(int rowsQuantity) {
		super(rowsQuantity);
		listPartial = new byte[this.rowsQuantity];
	}
	
	
	//@Override
	void putValue(int rowNumber, byte value) {
		listPartial[rowNumber] = value;
	}
	
	
	//@Override
	byte getValue(int rowNumber) {
		return listPartial[rowNumber];
	}

}
