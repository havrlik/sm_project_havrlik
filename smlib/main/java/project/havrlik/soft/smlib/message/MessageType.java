package main.java.project.havrlik.soft.smlib.message;

import java.awt.Color;

/*
 * 'logs message levels'
 * 
 * When edit, also check MessageType_Lists class and .
 */

public enum MessageType {
	
	// Columns: ID ; priority ; short description and color ; 
	N0_UNKNOWN(0, 900, "Unknown (nearly white)", new Color(255, 255, 255)),
	
	N1_FATAL(1, 110, "Fatal (red)", new Color(250, 200, 180)),
	N2_ERROR(2, 120, "Error (pink)", new Color(255, 241, 245)),
	N3_FAIL(3, 130, "Fail (hard violet)", new Color(189, 171, 211)),
	N4_WARN(4, 140, "Warn (soft violet)", new Color(230, 219, 247)),
	
	N11_INFO(11, 1_000, "Info (soft blue)", new Color(210, 225, 240)),
	N12_INFONOREFER(12, 1_000, "Info no refer (no colored)", new Color(255, 255, 255)),
	N13_APP(13, 1_000, "App (no color)", new Color(255, 255, 255)),
	N14_USER(14, 1_000, "User's mark (no colored)", new Color(255, 255, 255)),
	
	N21_ANOTHER(21, 210, "Another (yellow)", new Color(235, 211, 114)),
	N91_DEVELOPER(91, 50, "Developer debug note (hard red)", new Color(210, 120, 110)),
	N92_DEVELOPER_FAST(92, 50, "Developer debug note (hard red)", new Color(210, 120, 110));
	
	
	private final int id;
	private final int priority;
	private final String shortDescription;
	private final Color backgroundColor;
	
	
	MessageType(
			int id,
			int priority,
			String shortDescription,
			Color backgroundColor
	) {
		this.id = id;
		this.priority = priority;
		this.shortDescription = shortDescription;
		this.backgroundColor = backgroundColor;
	}
	
	
	public int get_id() { return id; }
	public int get_priority() { return priority; }
	public String get_shortDescription() { return shortDescription; }
	public Color get_backgroundColor() { return backgroundColor; }

}
