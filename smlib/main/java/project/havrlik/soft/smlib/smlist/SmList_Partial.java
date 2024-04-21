package main.java.project.havrlik.soft.smlib.smlist;

abstract class SmList_Partial {
	
	protected int rowsQuantity = 0;
	
	
	protected SmList_Partial(int rowsQuantity) {
		this.rowsQuantity = rowsQuantity;
	}
	
	
	public final int size() {
		return rowsQuantity;
	}

}
