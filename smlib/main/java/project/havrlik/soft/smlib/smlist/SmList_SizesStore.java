package main.java.project.havrlik.soft.smlib.smlist;

public class SmList_SizesStore {
	
	final String listNo;
	final SmList_Size listName;
	final int MAXSIZE;  // 2^31 = 2_147_483_648 ; max int 2_147_483_647 ;
	private final int[][] LIST_predefinedArraySizes;  // * Should rename to LIST_predefinedListAggregatedSizes.  // Array: [0] level ; [1] total size at level ; [2] added size against precedent level ; 
	
	
	public SmList_SizesStore(final String listNo, final SmList_Size listName, final int maxSize, final int[][] LIST_predefinedArraySizes) {
		this.listNo = listNo;
		this.listName = listName;
		this.MAXSIZE = maxSize;
		this.LIST_predefinedArraySizes = LIST_predefinedArraySizes;
	}
	
	
	public String get_listNo() {
		return listNo;
	}
	
	
	public SmList_Size get_listName() {
		return listName;
	}
	
	
	public int get_MAXSIZE() {
		return MAXSIZE;
	}
	
	
	public int[][] get_LIST_predefinedArraySizes() {
		return LIST_predefinedArraySizes;
	}

}
