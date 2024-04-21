package main.java.project.havrlik.soft.smguiswing.other;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import main.java.project.havrlik.soft.smguiswing.button.Button_Back;
import main.java.project.havrlik.soft.smguiswing.font.Font_Common;
import main.java.project.havrlik.soft.smguiswing.label.Label_Title;
import main.java.project.havrlik.soft.smlib.SmLib;
import main.java.project.havrlik.soft.smlib.data.Data_StringSmList;
import main.java.project.havrlik.soft.smlib.file.DirectoriesAndFiles;
import main.java.project.havrlik.soft.smlib.message.MessageList;
import main.java.project.havrlik.soft.smlib.message.MessageType;
import main.java.project.havrlik.soft.smlib.other.MarkLabelStringEtc;
import main.java.project.havrlik.soft.smlib.smlist.SmList_Size;

/**
 * Missing: Panel dimensions do not customized yet.
 */


public class Gui_ScreenTable {
	
	private SmLib smLib;
	
	private Panel_main2 scrollPane;
	
	private String title;
	private Gui_SmScrollTable smScrollTable;
	private Button_Back button_backScreen;  // Implementation: Add listener to parent class.
	private Label_Title label_title;
	private JLabel label1;
	private JButton button_export;
	
	private int panelWidth;
	private int panelHeight;
	
	
	public Gui_ScreenTable(SmLib smLib, String title, int windowWidth, int panelHeight) {
		this.smLib = smLib;
		
		this.title = title;
		this.panelWidth = windowWidth;
		this.panelHeight = panelHeight;
		
		if (this.title == null) {
			this.title = "";
		}
		if (this.panelWidth < 1) {
			this.panelWidth = 500;
		}
		if (this.panelHeight < 1) {
			this.panelHeight = 250;
		}
		
		scrollPane = new Panel_main2(new Panel_main3());
	}
	
	
	public Panel_main2 get_panel() { return scrollPane; }
	public Gui_SmScrollTable get_smScrollTable() { return smScrollTable; }
	public Button_Back get_button_backScreen() { return button_backScreen; }
	
	public void setText_label_title(String text) { label_title.setText(text); }
	public void setText_label1(String text) { label1.setText(text); }
	
	
	class Panel_main2 extends JScrollPane {
		
		private static final long serialVersionUID = 2157549366064945480L;
		
		
		Panel_main2(Panel_main3 panel) {
			super(panel);
			this.setPreferredSize(new Dimension(panelWidth + 25, panelHeight + 10));
			this.setBorder(null);
		}
	
	}
	
	
	class Panel_main3 extends JPanel {
		
		private static final long serialVersionUID = 2056468925372614635L;
		

		Panel_main3() {
			super();
			
			this.setLayout(null);
			
			button_backScreen = new Button_Back();
			this.add(button_backScreen);
			
			label_title = new Label_Title(title, panelWidth - 10);
			this.add(label_title);
			
			label1 = new JLabel("Table:");
			label1.setFont(new Font_Common());
			label1.setBounds(10, 45, panelWidth - 150, 20);
			this.add(label1);
			
			button_export = new JButton("Export to file");
			button_export.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					exportToFile();
				}
			});
			button_export.setBounds(panelWidth - 130, 45, 120, 22);
			this.add(button_export);
			
			smScrollTable = new Gui_SmScrollTable();
			smScrollTable.setBounds(5, 70, panelWidth - 10, panelHeight - 90);
			this.add(smScrollTable);
			
			this.setPreferredSize(new Dimension(panelWidth, panelHeight));  // Set dimensions according to content.
		}
		
		
		private void exportToFile() {
			if (smScrollTable == null || smScrollTable.get_tableDto() == null || smScrollTable.get_tableDto().rows == null) {
				return;
			}
			
			Gui_Table_Dto tableDto = smScrollTable.get_tableDto();
			
			DirectoriesAndFiles fileFullPath = smLib.fileDialogSm.fileDialog_save_chooseDirectoryAndFileName(null, ".txt");
			if (fileFullPath == null) {
				return;
			}
			
			Data_StringSmList data = new Data_StringSmList(smLib);
			data.initContent(SmList_Size.SMALL_512);
			
			data.addRow("");
			data.addRow("SM App: table '" + title + "' exported into file at '" + 
					smLib.timePerform.get_str_sdf_actualDateTime_withSeparators_twoSpaces_descending() + "'.");
			data.addRow("");
			
			if (tableDto.columns_name != null) {
				String columns = tableDto.columns_name[0];
				for (int i1 = 1; i1 < tableDto.columns_name.length; i1++) {
					columns += MarkLabelStringEtc.CHARS_semicolon + tableDto.columns_name[i1];
				}
				data.addRow(columns);
				data.addRow("");
			}
			
			String row;
			for (int i2 = 0; i2 < tableDto.rows.length; i2++) {
				row = tableDto.rows[i2][0];
				for (int i3 = 1; i3 < tableDto.rows[i2].length; i3++) {
					row += MarkLabelStringEtc.CHARS_semicolon + tableDto.rows[i2][i3];
				}
				data.addRow(row);
			}
			
			data.addRow("");
			
			data.set_fileDirectory(fileFullPath.getSingle_directory());
			data.set_fileName(fileFullPath.getSingle_fileInDirectory());
			data.set_processResult_success();
			Data_StringSmList result = smLib.fileIo.write_smList1DString(data);
			
			if (result.isFailed()) {
				MessageList errors = result.getAndClear_processMessages();
				errors.add(
						MessageList.assemblePlacement(this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName()), 
						"SM App: table '" + title + "' export error."
				);
				smLib.messageReceiver.message(MessageType.N3_FAIL, errors);
			}
		}
	
	}

}
