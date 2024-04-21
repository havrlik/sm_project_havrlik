package main.java.project.havrlik.soft.smguiswing.other;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


public class Gui_SmScrollTable extends JScrollPane {
	
	private static final long serialVersionUID = -5765592089063639918L;
	
	private Gui_SmTable smTable;
	
	
	public Gui_SmScrollTable(Gui_Table_Dto tableDto) {
		super();
		
		smTable = new Gui_SmTable(tableDto);
		super.setViewportView(smTable);
	}
	
	
	public Gui_SmScrollTable() {
		this(null);
	}
	
	
	public Gui_SmTable get_smTable() { return smTable; }
	public Gui_Table_Dto get_tableDto() { return smTable.get_tableDto(); }
	public void initTable(Gui_Table_Dto tableDto) { smTable.initTable(tableDto); }
	public void refresh(Gui_Table_Dto tableDto) { smTable.refresh(tableDto); }
	public void refresh(boolean refreshColumnsWidthsToo) { smTable.refresh(refreshColumnsWidthsToo); }
	public void refresh() { smTable.refresh(); }
	
	
	public class Gui_SmTable extends JTable {
		
		private static final long serialVersionUID = -6791587313722078876L;
		
		protected Gui_Table_Dto tableDto;
		protected int columnsQuantity;
		
		
		Gui_SmTable(Gui_Table_Dto tableDto) {
			super();
			initTable(tableDto);
		}
		
		
//		Gui_SmTable() {
//			this(null);
//		}
		
		
		@Override
		public boolean getScrollableTracksViewportWidth() {
			return (getPreferredSize().width < getParent().getWidth());
		}
		
		
		Gui_Table_Dto get_tableDto() { return tableDto; }
		
		
		void initTable(Gui_Table_Dto tableDto) {
			// Column names alignment.
			DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) this.getTableHeader().getDefaultRenderer();
			renderer.setHorizontalAlignment(JLabel.LEFT);
			
			refresh(tableDto);
		}
		
		
		void refresh(Gui_Table_Dto tableDto) {
			this.tableDto = tableDto;
			
			refresh();
		}
		
		
		void refresh(boolean refreshColumnsWidthsToo) {
			checkDto();
			
			setTableRows();
			if (refreshColumnsWidthsToo) {
				setTableColumnsWidth();
			}
		}
		
		
		void refresh() {
			refresh(true);
		}
		
		
		protected void checkDto() {
			columnsQuantity = 0;
			
			if (tableDto == null) {
				tableDto = new Gui_Table_Dto();
			}
			
			// Set 'columnsQuantity'.
			if (tableDto.rows != null && tableDto.rows.length != 0 && tableDto.rows[0].length != 0) {
				columnsQuantity = tableDto.rows[0].length;
			}
			else if (tableDto.columns_name != null && tableDto.columns_name.length != 0) {
				columnsQuantity = tableDto.columns_name.length;
			}
			else if (tableDto.columns_width != null && tableDto.columns_width.length != 0) {
				columnsQuantity = tableDto.columns_width.length;
			}
			
			// Set default column names if needed.
			if (tableDto.columns_name == null || tableDto.columns_name.length != columnsQuantity) {
				tableDto.columns_name = new String[columnsQuantity];
			}
			if (tableDto.columns_name == null || tableDto.columns_name.length == 0) {
				tableDto.columns_name = new String[] { null };
			}
			
			// Set default column widths if needed.
			if (tableDto.columns_width == null || tableDto.columns_width.length != columnsQuantity) {
				tableDto.columns_width = null;
				tableDto.columns_width_forced = false;
			}
		}
		
		
		protected void setTableRows() {
			checkDto();
			
			this.setModel(new DefaultTableModel(tableDto.rows, tableDto.columns_name));
		}
		
		
		protected void setTableColumnsWidth() {
			if (tableDto.columns_width != null) {
				TableColumnModel tcm = this.getColumnModel();
				for (int i1 = 0; i1 < columnsQuantity; i1++) {
					if (tableDto.columns_width_forced) {
						// Coumn widths is always as the value. But can not resize column width in GUI.
						tcm.getColumn(i1).setMinWidth(tableDto.columns_width[i1]);
						tcm.getColumn(i1).setMaxWidth(tableDto.columns_width[i1]);
					}
					else {
						// If sum of dolumn widhts is less then panel widht, column withts is stretch.
						tcm.getColumn(i1).setPreferredWidth(tableDto.columns_width[i1]);
					}
				}
			}
		}
		
	}

}
