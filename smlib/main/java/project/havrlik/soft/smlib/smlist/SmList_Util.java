package main.java.project.havrlik.soft.smlib.smlist;

public class SmList_Util {
	
	SmList_SizesStores smList_SizesStore;
	
	
	public SmList_Util() {
		smList_SizesStore = new SmList_SizesStores();
	}
	
	
	public static SmList_Size return_recommendedSmListSizeName(int higherMediumSizeOfList) {
		SmList_Size arraySizeName = null;
		if (higherMediumSizeOfList < 0) {
			arraySizeName = null;
		}
		else if (higherMediumSizeOfList == 0) {
			arraySizeName = SmList_Size.DEFAULT_128;
		}
		else if (higherMediumSizeOfList < 50) {
			arraySizeName = SmList_Size.TINY_16;
		}
		else if (higherMediumSizeOfList < 400) {
			arraySizeName = SmList_Size.SMALL_64;
		}
		else if (higherMediumSizeOfList < 2_000) {
			arraySizeName = SmList_Size.SMALL_512;
		}
		else if (higherMediumSizeOfList < 10_000) {
			arraySizeName = SmList_Size.MEDIUM_4K;
		}
		else if (higherMediumSizeOfList < 100_000) {
			arraySizeName = SmList_Size.MEDIUM_32K;
		}
		else if (higherMediumSizeOfList < 1_000_000) {
			arraySizeName = SmList_Size.BIG_256K;
		}
		else if (higherMediumSizeOfList < 10_000_000) {
			arraySizeName = SmList_Size.BIG_2M;
		}
		else {
			arraySizeName = SmList_Size.HUGE_16M;
		}
		
		return arraySizeName;
	}
	
	
	public static SmList_Size return_recommendedSmListSizeName(String higherMediumSizeOfList_int_string) {
		/*
		 * Try to parse integer from string, then get SmList_Size.
		 */
		try {
			if (higherMediumSizeOfList_int_string == null || higherMediumSizeOfList_int_string.length() == 0) {
				return null;
			}
			
			return return_recommendedSmListSizeName(Integer.parseInt(higherMediumSizeOfList_int_string));
		}
		catch (Exception e1) {
			return null;
		}
	}
	
	
	public SmList_SizesStore return_predefinedArraySizes(SmList_Size smList_Size) {
		for (int i1 = 0; i1 < smList_SizesStore.LIST_predefinedArraySizes.length; i1++) {
			if (smList_Size == smList_SizesStore.LIST_predefinedArraySizes[i1].get_listName()) {
				return smList_SizesStore.LIST_predefinedArraySizes[i1];
			}
		}
		
		return null;
	}
	
	
	public SmList_Size return_SmListSize_allowedOnly(String smListSize_string) {
		SmList_Size smListSize;
		try {
			smListSize = SmList_Size.valueOf(smListSize_string);
		}
		catch (Exception e1) {
			return null;
		}
		if (return_predefinedArraySizes(smListSize) == null) {
			return null;
		}
		
		return smListSize;
	}
	
	
	public boolean isAllowed_smListSize(String smListSize_string) {
		if (return_SmListSize_allowedOnly(smListSize_string) != null) {
			return true;
		}
		
		return false;
	}
	
	
	public static SmList_1D_String copy_SmList_1D_String(
			SmList_1D_String originList
	) {
		if (originList == null) {
			return null;
		}
		
		SmList_1D_String newList = new SmList_1D_String(return_recommendedSmListSizeName(originList.size()));
		
		for (int j1 = 0; j1 < originList.size(); j1++) {
			newList.addValue(originList.getValue(j1));
		}
		
		return newList;
	}
	
	
	public static SmList_2D_String copy_SmList_2D_String(
			SmList_2D_String originList
	) {
		if (originList == null) {
			return null;
		}
		
		SmList_2D_String newList = new SmList_2D_String(originList.COLUMNSQUANTITY, return_recommendedSmListSizeName(originList.size()));
		
		for (int j1 = 0; j1 < originList.size(); j1++) {
			newList.addRow(originList.getRow_shallow(j1));
		}
		
		return newList;
	}

}
