package main.java.project.havrlik.soft.smlib.other;


public enum TimeType {
	Y("y"),
	M("M"),
	W("w"),
	D("d"),
	
	h("H"),
	m("m"),
	s("s"),
	;
	
	
	private final String sm_string;
	private final String javaType;
	
	
	TimeType(String javaType) {
		this.sm_string = this.name();
		this.javaType = javaType;
	}
	
	
	public String get_sm_string() { return sm_string; }
	public String get_javaType() { return javaType; }

}
