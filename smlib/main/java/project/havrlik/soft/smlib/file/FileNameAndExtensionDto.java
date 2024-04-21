package main.java.project.havrlik.soft.smlib.file;

public class FileNameAndExtensionDto {
	
	public String fileNameWithoutExtension = "";
	public String fileNameExtension = "";
	
	
	public FileNameAndExtensionDto() {
	}
	
	
	public FileNameAndExtensionDto(String fileNameWithoutExtension, String fileNameExtension) {
		this.fileNameWithoutExtension = fileNameWithoutExtension;
		this.fileNameExtension = fileNameExtension;
	}

}
