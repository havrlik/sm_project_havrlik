package main.java.project.havrlik.soft.smlib.data;

import main.java.project.havrlik.soft.smlib.SmLib;
import main.java.project.havrlik.soft.smlib.smlist.SmList_1D_byte;
import main.java.project.havrlik.soft.smlib.smlist.SmList_Size;

public class Data_byte_SmList extends Data {
	
	protected SmList_1D_byte rows = null;
	
	
	public Data_byte_SmList(SmLib smLib) {
		super(smLib);
	}
	
	
	public void initContent(SmList_Size useArraySizesModel) {
		rows = new SmList_1D_byte(useArraySizesModel);
	}
	
	
	public void set_content(SmList_1D_byte rows) {
		this.rows = rows;
		
//		rowNumber_fileData = rows.size();
//		rowNumber_fileOverall = rows.size();
	}
	
	
	public void dropContent() {
		rows = null;
	}
	
	
	public void putRow(int rowNumber, byte value) {
		rows.putValue(rowNumber, value);
	}
	
	
	public void addRow(byte value) {
		rows.putValue(rows.lastIndex() + 1, value);
	}
	
	
	public SmList_1D_byte get_content() { return rows; }
	
	
	public int sizeOfContent() {
		if (rows == null) {
			return -1;
		}
		
		return rows.size();
	}

}
