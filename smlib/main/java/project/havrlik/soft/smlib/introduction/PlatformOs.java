package main.java.project.havrlik.soft.smlib.introduction;

public enum PlatformOs {
	
	MSWINDOWS("Microsoft Windows"),
	LINUX("Linux");
//	APPLEMACOS("Apple Mac OS"),
	
	
	private final String name;
	
	
	PlatformOs(String name) {
		this.name = name;
	}
	
	
	public String get_name() { return name; }

}
