package main.java.project.havrlik.soft.smlib.smlist;

abstract class SmList_1D extends SmList_SteadyColumns {
	
	
	protected SmList_1D() {
		super();
		
		clear();
	}
	
	
	protected SmList_1D(SmList_Size useArraySizesModel) {
		super(useArraySizesModel);
		
		clear();
	}
	
	
	protected SmList_1D(int higherMediumSizeOfList) {
		super(higherMediumSizeOfList);
		
		clear();
	}
	
	
	/*
	 * Abstract methods with certain passed or returned type:
	 * 
	 * addValue();
	 * addArray();
	 * putValue();
	 * putArray();
	 * getValue();
	 * getArray();
	 */
	
	
	public abstract void clearValue(int rowNumber);

}
