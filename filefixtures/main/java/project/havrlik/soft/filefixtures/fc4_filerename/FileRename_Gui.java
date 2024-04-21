package main.java.project.havrlik.soft.filefixtures.fc4_filerename;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import main.java.project.havrlik.soft.filefixtures.smlib.SmLib;
import main.java.project.havrlik.soft.smguiswing.font.Font_Common;
import main.java.project.havrlik.soft.smguiswing.font.Font_Common_Bold;
import main.java.project.havrlik.soft.smguiswing.font.Font_Title_H2;
import main.java.project.havrlik.soft.smguiswing.label.Label_Title;
import main.java.project.havrlik.soft.smguiswing.other.Gui_ScreenTable;
import main.java.project.havrlik.soft.smguiswing.other.Gui_SmScrollTable;
import main.java.project.havrlik.soft.smguiswing.other.Panel_Main2_Scroll;
import main.java.project.havrlik.soft.smlib.introduction.Intoduction_GuiSwing_Dimension;

public class FileRename_Gui {
	
	private SmLib smLib;
	private Intoduction_GuiSwing_Dimension guiDimension;
	
//	public final String thisFunctionnalityName_parent1_short = "";
	public final String thisFunctionnalityName = "File rename";
	public final String thisFunctionnalityName_short = "File rename";
	private JPanel panel1_main;
	private CardLayout cardLayout;
	private String panel_main2_name;
	
	private JLabel label_state;
	private JButton button1_fetch;
	private JButton button3_perform;
	private JComboBox<String> jComboBox_modeOption;
	private JRadioButton rb_group_rb1;
	private JRadioButton rb_group_rb2;
	private JRadioButton rb_group_rb3;
	private JCheckBox checkBox1;
	
	public static final String[] modeOption = {
			"Choose one:", 
			"A)  Replace ':' by '-'.", 
//			"", 
	};
	
	private Gui_ScreenTable panel_fileList;
	private String panel_fileList_name;
	
	
	public FileRename_Gui(SmLib smLib) {
		this.smLib = smLib;
		guiDimension = smLib.introduction.guiSwing_Dimension;
		
		// Main panel.
		Panel_Main2_Scroll panel_main = new Panel_Main2_Scroll(new Panel_Main3());
		panel_main2_name = "panel_main";
		
		// Panel with file list.
		panel_fileList = new Gui_ScreenTable(
				this.smLib,
				thisFunctionnalityName_short + " → " + "File list", 
				guiDimension.width_panelScrolling, 
				guiDimension.height_panelScrolling
		);
		panel_fileList.get_button_backScreen().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(panel1_main, panel_main2_name);
			}
		});
		panel_fileList_name = "panel_fileList";
		
		// Cards
		panel1_main = new JPanel();
		cardLayout = new CardLayout();
		panel1_main.setLayout(cardLayout);
		panel1_main.add(panel_main, panel_main2_name);
		panel1_main.add(panel_fileList.get_panel(), panel_fileList_name);
		
		cardLayout.show(panel1_main, panel_main2_name);
		clear();
	}
	
	
	public JPanel return_panel1() { return panel1_main; }
	public Gui_SmScrollTable get_table_fileList() { return panel_fileList.get_smScrollTable(); }
	
	public JLabel get_label_state() { return label_state; }
	public JButton get_button1_fetch() { return button1_fetch; }
	public JButton get_button3_perform() { return button3_perform; }
	public JComboBox<String> get_jComboBox_modeOption() { return jComboBox_modeOption; }
	public JRadioButton get_rb_group_rb1() { return rb_group_rb1; }
	public JRadioButton get_rb_group_rb2() { return rb_group_rb2; }
	public JRadioButton get_rb_group_rb3() { return rb_group_rb3; }
	public JCheckBox get_checkBox1() { return checkBox1; }
	
	
	public void clear() {
		label_state.setText("-");
		jComboBox_modeOption.setSelectedIndex(0);
		checkBox1.setSelected(false);
		checkBox1.setEnabled(false);
		button3_perform.setEnabled(false);
	}
	
	
	private class Panel_Main3 extends JPanel {
		
		private static final long serialVersionUID = 126274312688768413L;
		
		
		Panel_Main3() {
			super();
			
			this.setLayout(null);
			
			
	//		Label_Title label_title = new Label_Title(thisFunctionnalityName_parent1_short + " → " + thisFunctionnalityName, guiDimension.width_leftPadding + 10, guiDimension.width_rightEdge);
			Label_Title label_title = new Label_Title(thisFunctionnalityName, guiDimension.width_leftPadding + 10, guiDimension.width_rightEdge);
			this.add(label_title);
			
			int layoutPosition_y = 45;
			
			// Description.
			JLabel label_description_a = new JLabel("Description:");
			label_description_a.setFont(new Font_Common());
			label_description_a.setBounds(30, layoutPosition_y, 120, 20);
			this.add(label_description_a);
			
			JLabel label_description_1 = new JLabel("Select files or folder with files to be renamed according to your needs.");
			label_description_1.setFont(new Font_Common());
			label_description_1.setBounds(160, layoutPosition_y, 760, 20);
			this.add(label_description_1);
			
			layoutPosition_y += 40;
			// Function.
			JLabel label0 = new JLabel("Function:");
			label0.setFont(new Font_Title_H2());
			label0.setBounds(10, layoutPosition_y, 910, 20);
			this.add(label0);
			
			layoutPosition_y += 35;
			// Condition.
			JLabel label_condition_a = new JLabel("Condition:");
			label_condition_a.setFont(new Font_Common());
			label_condition_a.setBounds(30, layoutPosition_y, 120, 20);
			this.add(label_condition_a);
			
			label_state = new JLabel("-");
			label_state.setFont(new Font_Common_Bold());
			label_state.setBounds(160, layoutPosition_y, 760, 20);
			this.add(label_state);
			
			layoutPosition_y += 35;
			JLabel label1 = new JLabel("1) Select mode: ");
			label1.setFont(new Font_Common_Bold());
			label1.setBounds(10, layoutPosition_y, 910, 20);
			this.add(label1);
			
			layoutPosition_y += 25;
			jComboBox_modeOption = new JComboBox<String>(modeOption);
			jComboBox_modeOption.setSelectedIndex(0);
			jComboBox_modeOption.setSize(890, 200);
			jComboBox_modeOption.setBounds(30, layoutPosition_y, 890, 22);
			this.add(jComboBox_modeOption);
			
			layoutPosition_y += 35;
			JPanel rb_panelTitledB = new JPanel();
			rb_panelTitledB.setLayout(null);
			TitledBorder rb_titledB = BorderFactory.createTitledBorder("2) Fetch files: ");
			rb_titledB.setTitleFont(rb_titledB.getTitleFont().deriveFont(Font.BOLD));
			ButtonGroup rb_bGroup = new ButtonGroup();
			rb_group_rb1 = new JRadioButton(" A)  Select certain files. ");
			rb_group_rb1.setFont(new Font_Common());
			rb_bGroup.add(rb_group_rb1);
			rb_group_rb1.setBounds(10, 22, 895, 18);
			rb_panelTitledB.add(rb_group_rb1);
			rb_group_rb2 = new JRadioButton(" B)  Select folder, fetch all files inside. ", true);
			rb_group_rb2.setFont(new Font_Common());
			rb_bGroup.add(rb_group_rb2);
			rb_group_rb2.setBounds(10, 42, 895, 18);
			rb_panelTitledB.add(rb_group_rb2);
			rb_group_rb3 = new JRadioButton(" C)  Select folder, fetch all files inside, all subfolders included. ");
			rb_group_rb3.setFont(new Font_Common());
			rb_bGroup.add(rb_group_rb3);
			rb_group_rb3.setBounds(10, 62, 895, 18);
			rb_panelTitledB.add(rb_group_rb3);
			rb_panelTitledB.setBorder(rb_titledB);
			rb_panelTitledB.setBounds(5, layoutPosition_y, 920, 92);
			this.add(rb_panelTitledB);
			
			layoutPosition_y += 105;
			button1_fetch = new JButton("3) Fetch");
			button1_fetch.setFont(button1_fetch.getFont().deriveFont(Font.BOLD));
			button1_fetch.setHorizontalAlignment(SwingConstants.LEFT);
			button1_fetch.setBounds(30, layoutPosition_y, 180, 22);
			this.add(button1_fetch);
			
			JLabel label2 = new JLabel("Fetch files, and suggest changes of new filenames.");
			label2.setFont(new Font_Common());
			label2.setBounds(230, layoutPosition_y, 880, 20);
			this.add(label2);
			
			layoutPosition_y += 35;
			checkBox1 = new JCheckBox(" 3.1) Prove suggested changes in table.", false);
			checkBox1.setFont(new Font_Common());
			checkBox1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (checkBox1.isSelected()) {
						button3_perform.setEnabled(true);
					}
					else {
						button3_perform.setEnabled(false);
					}
				}
			});
			checkBox1.setBounds(30, layoutPosition_y, 690, 20);
			this.add(checkBox1);
			
			JButton button2 = new JButton("Go to table");
			button2.setHorizontalAlignment(SwingConstants.LEFT);
			button2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					cardLayout.show(panel1_main, panel_fileList_name);
				}
			});
			button2.setBounds(740, layoutPosition_y, 180, 22);
			this.add(button2);
			
			layoutPosition_y += 35;
			button3_perform = new JButton("4) Perform");
			button3_perform.setFont(button3_perform.getFont().deriveFont(Font.BOLD));
			button3_perform.setHorizontalAlignment(SwingConstants.LEFT);
			button3_perform.setEnabled(false);
			button3_perform.setBounds(10, layoutPosition_y, 180, 22);
			this.add(button3_perform);
			
			
			layoutPosition_y += 35;
			// Set this panel.
			this.setPreferredSize(new Dimension(930, layoutPosition_y + 5));  // Set dimensions according to content.
			JScrollPane scrollPane = new JScrollPane(this);
			scrollPane.setBorder(null);
		}
	
	}

}
