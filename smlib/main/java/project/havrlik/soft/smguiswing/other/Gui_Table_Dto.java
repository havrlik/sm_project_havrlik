package main.java.project.havrlik.soft.smguiswing.other;

public class Gui_Table_Dto {
	
	public String[] columns_name = null;
	public int[] columns_width = null;
	// columns_width_forced: 'false': If sum of dolumn widhts is less then panel widht, column withts is stretch.
	// 'true': Coumn widths is always as the value. But can not resize column width in GUI.
	public boolean columns_width_forced = false;  // 
	public String[][] rows = null;
	
	
	public Gui_Table_Dto() {
	}
	
	
	public Gui_Table_Dto(
			String[] columns_name,
			int[] columns_width,
			boolean columns_width_forced,
			String[][] rows
	) {
		this.columns_name = columns_name;
		this.columns_width = columns_width;
		this.columns_width_forced = columns_width_forced;
		this.rows = rows;
	}
	
	
	public Gui_Table_Dto(
			String[] columns_name,
			int[] columns_width,
			String[][] rows
	) {
		this.columns_name = columns_name;
		this.columns_width = columns_width;
		this.rows = rows;
	}

}
