package main.java.project.havrlik.soft.smlib.data;

import main.java.project.havrlik.soft.smlib.SmLib;

public class Data_byte_array extends Data {
	
	protected byte[] rows = null;
	
	
	public Data_byte_array(SmLib smLib) {
		super(smLib);
	}
	
	
	public void initContent(int size) {
		rows = new byte[size];
	}
	
	
	public void set_content(byte[] rows) {
		this.rows = rows;
		
//		rowNumber_fileData = rows.length;
//		rowNumber_fileOverall = rows.length;
	}
	
	
	public void dropContent() {
		rows = null;
	}
	
	
	public void putRow(int rowNumber, byte value) {
		rows[rowNumber] = value;
	}
	
	
	public byte[] get_content() { return rows; }
	
	
	public int sizeOfContent() {
		if (rows == null) {
			return -1;
		}
		
		return rows.length;
	}

}
