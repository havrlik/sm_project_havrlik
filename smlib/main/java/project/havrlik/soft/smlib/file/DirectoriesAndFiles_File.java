package main.java.project.havrlik.soft.smlib.file;


public class DirectoriesAndFiles_File {
	
	String file = null;
	long file_size = 0;
	
	
	public DirectoriesAndFiles_File(String file, long file_size) {
		this.file = file;
		this.file_size = file_size;
	}
	
	
	public DirectoriesAndFiles_File(String file) {
		this.file = file;
		this.file_size = 0;
	}
	
	
	public String get_file() { return file; }
	public long get_file_size() { return file_size; }

}
