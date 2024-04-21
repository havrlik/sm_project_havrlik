package main.java.project.havrlik.soft.smlib.data;

import main.java.project.havrlik.soft.smlib.SmLib;
import main.java.project.havrlik.soft.smlib.smlist.SmList_1D_String;
import main.java.project.havrlik.soft.smlib.smlist.SmList_Size;

public class Data_StringSmList extends Data {
	
	protected SmList_1D_String rows = null;
	
	
	public Data_StringSmList(SmLib smLib) {
		super(smLib);
	}
	
	
	public void initContent(SmList_Size useArraySizesModel) {
		rows = new SmList_1D_String(useArraySizesModel);
	}
	
	
	public void set_content(SmList_1D_String rows) {
		this.rows = rows;
		
//		rowNumber_fileData = rows.size();
//		rowNumber_fileOverall = rows.size();
	}
	
	
	public void dropContent() {
		rows = null;
	}
	
	
	public void putRow(int rowNumber, String row) {
		rows.putValue(rowNumber, row);
	}
	
	
	public void addRow(String row) {
		rows.putValue(rows.lastIndex() + 1, row);
	}
	
	
	public SmList_1D_String get_content() { return rows; }
	
	
	public int sizeOfContent() {
		if (rows == null) {
			return -1;
		}
		
		return rows.size();
	}

}
