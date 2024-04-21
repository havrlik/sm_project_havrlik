package main.java.project.havrlik.soft.filefixtures.fc5_archivecommands;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import main.java.project.havrlik.soft.filefixtures.smlib.SmLib;
import main.java.project.havrlik.soft.smguiswing.font.Font_Common;
import main.java.project.havrlik.soft.smguiswing.font.Font_Common_Bold;
import main.java.project.havrlik.soft.smguiswing.label.Label_Title;
import main.java.project.havrlik.soft.smguiswing.other.Gui_ScreenTable;
import main.java.project.havrlik.soft.smguiswing.other.Gui_SmScrollTable;
import main.java.project.havrlik.soft.smguiswing.other.Panel_Main2_Scroll;
import main.java.project.havrlik.soft.smlib.introduction.Intoduction_GuiSwing_Dimension;

public class ArchiveCommands_Gui {
	
	private SmLib smLib;
	private Intoduction_GuiSwing_Dimension guiDimension;
	
//	public final String thisFunctionnalityName_parent1_short = "";
	public final String thisFunctionnalityName = "Archive commands";
	public final String thisFunctionnalityName_short = "AR cmds";
	private JPanel panel1_main;
	private CardLayout cardLayout;
	private String panel_main2_name;
	
	private JLabel label_state;
	private JButton button8_clear;
	
	private JLabel label1_program;
	private JComboBox<String> jComboBox1_command;
	private JCheckBox checkBox1_volumes;
	private JCheckBox checkBox2_compression;
	private JCheckBox checkBox3_password;
	private JTextField textField1_password;
	private JCheckBox checkBox4_headerEncription;
	private JTextField textField2_path1;
	private JTextField textField3_path2;
	private JCheckBox checkBox9_copyLastFolder;
	private JCheckBox checkBox8_suffix;
	private JTextField textField4_suffix;
	private JCheckBox checkBox5_extension_7z;
	private JCheckBox checkBox7_extension_7z001;
	private JCheckBox checkBox6_removeFolder;
	private JButton button1_fetch;
	
	private JButton button2_perform;
	private JButton button7_save;
	
	private final String[] jComboBox1_option = {
			"a", 
			"t", 
			"x", 
	};
	
	private Gui_ScreenTable panel_table;
	private String panel_table_name;
	
	
	public ArchiveCommands_Gui(SmLib smLib) {
		this.smLib = smLib;
		guiDimension = smLib.introduction.guiSwing_Dimension;
		
		// Main panel.
		Panel_Main2_Scroll panel_main = new Panel_Main2_Scroll(new Panel_Main3());
		panel_main2_name = "panel_main";
		
		// Panel with file list.
		panel_table = new Gui_ScreenTable(
				this.smLib,
				thisFunctionnalityName_short + " → " + "List", 
				guiDimension.width_panelScrolling, 
				guiDimension.height_panelScrolling
		);
		panel_table.get_button_backScreen().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(panel1_main, panel_main2_name);
			}
		});
		panel_table_name = "panel_table";
		
		// Cards
		panel1_main = new JPanel();
		cardLayout = new CardLayout();
		panel1_main.setLayout(cardLayout);
		panel1_main.add(panel_main, panel_main2_name);
		panel1_main.add(panel_table.get_panel(), panel_table_name);
		
		cardLayout.show(panel1_main, panel_main2_name);
		clear();
	}
	
	
	public JPanel return_panel1() { return panel1_main; }
	public Gui_SmScrollTable get_table_list() { return panel_table.get_smScrollTable(); }
	
	public JLabel get_label_state() { return label_state; }
	public JButton get_button8_clear() { return button8_clear; }
	
	public JLabel get_label1_program() { return label1_program; }
	public JComboBox<String> get_jComboBox1_command() { return jComboBox1_command; }
	public JCheckBox get_checkBox1_volumes() { return checkBox1_volumes; }
	public JCheckBox get_checkBox2_compression() { return checkBox2_compression; }
	public JCheckBox get_checkBox3_password() { return checkBox3_password; }
	public JTextField get_textField1_password() { return textField1_password; }
	public JCheckBox get_checkBox4_headerEncription() { return checkBox4_headerEncription; }
	public JTextField get_textField2_path1() { return textField2_path1; }
	public JTextField get_textField3_path2() { return textField3_path2; }
	public JCheckBox get_checkBox9_copyLastFolder() { return checkBox9_copyLastFolder; }
	public JCheckBox get_checkBox8_suffix() { return checkBox8_suffix; }
	public JTextField get_textField4_suffix() { return textField4_suffix; }
	public JCheckBox get_checkBox5_extension_7z() { return checkBox5_extension_7z; }
	public JCheckBox get_checkBox7_extension_7z001() { return checkBox7_extension_7z001; }
	public JCheckBox get_checkBox6_removeFolder() { return checkBox6_removeFolder; }
	public JButton get_button1_fetch() { return button1_fetch; }
	
	public JButton get_button2_perform() { return button2_perform; }
	public JButton get_button7_save() { return button7_save; }
	
	public String[] get_jComboBox1_option() { return jComboBox1_option; }
	
	
	public void clear() {
		label_state.setText("-");
		jComboBox1_command.setSelectedIndex(0);
		textField1_password.setText("");
		textField2_path1.setText("");
		textField3_path2.setText("");
	}
	
	
	private class Panel_Main3 extends JPanel {
		
		private static final long serialVersionUID = 4339152788769239220L;
		
		
		Panel_Main3() {
			super();
			
			this.setLayout(null);
			
			
	//		Label_Title label_title = new Label_Title(thisFunctionnalityName_parent1_short + " → " + thisFunctionnalityName, guiDimension.width_leftPadding + 10, guiDimension.width_rightEdge);
			Label_Title label_title = new Label_Title(thisFunctionnalityName, guiDimension.width_leftPadding + 10, guiDimension.width_rightEdge);
			this.add(label_title);
			
			int layoutPosition_y = 10;

			layoutPosition_y += 35;
//			// Description.
//			JLabel label_description_a = new JLabel("Description:");
//			label_description_a.setFont(new Font_Common());
//			label_description_a.setBounds(30, layoutPosition_y, 120, 20);
//			this.add(label_description_a);
//			
//			JLabel label_description_1 = new JLabel("");
//			label_description_1.setFont(new Font_Common());
//			label_description_1.setBounds(160, layoutPosition_y, 760, 20);
//			this.add(label_description_1);
//			
//			layoutPosition_y += 40;
			// Function.
//			JLabel label0 = new JLabel("Function:");
//			label0.setFont(new Font_Title_H2());
//			label0.setBounds(10, layoutPosition_y, 910, 20);
//			this.add(label0);
//			
//			layoutPosition_y += 35;
			// Condition.
			JLabel label_condition_a = new JLabel("Condition:");
			label_condition_a.setFont(new Font_Common());
			label_condition_a.setBounds(30, layoutPosition_y, 120, 20);
			this.add(label_condition_a);
			
			label_state = new JLabel("-");
			label_state.setFont(new Font_Common_Bold());
			label_state.setBounds(230, layoutPosition_y, 860, 20);
			this.add(label_state);
			
			layoutPosition_y += 30;
			button8_clear = new JButton("Clear");
			button8_clear.setHorizontalAlignment(SwingConstants.LEFT);
			button8_clear.setBounds(30, layoutPosition_y, 180, 22);
			this.add(button8_clear);
			
			// Settings.
			layoutPosition_y += 45;
			label1_program = new JLabel("7z");
			label1_program.setFont(new Font_Common());
			label1_program.setBounds(30, layoutPosition_y, 120, 20);
			this.add(label1_program);
			
			JLabel label_note1 = new JLabel("Program.");
			label_note1.setFont(new Font_Common());
			label_note1.setBounds(230, layoutPosition_y, 900, 20);
			this.add(label_note1);
			
			layoutPosition_y += 25;
			jComboBox1_command = new JComboBox<String>(jComboBox1_option);
			jComboBox1_command.setSelectedIndex(0);
			jComboBox1_command.setSize(180, 200);
			jComboBox1_command.setBounds(30, layoutPosition_y, 180, 22);
			this.add(jComboBox1_command);
			
			JLabel label_note2 = new JLabel("Command: create 'a', test 't', extract 'x'.");
			label_note2.setFont(new Font_Common());
			label_note2.setBounds(230, layoutPosition_y, 900, 20);
			this.add(label_note2);
			
			layoutPosition_y += 25;
			checkBox1_volumes = new JCheckBox("-v3600m");
			checkBox1_volumes.setFont(new Font_Common());
			checkBox1_volumes.setSelected(true);
			checkBox1_volumes.setBounds(30, layoutPosition_y, 180, 20);
			this.add(checkBox1_volumes);
			
			JLabel label_note3 = new JLabel("Volumes (parts).");
			label_note3.setFont(new Font_Common());
			label_note3.setBounds(230, layoutPosition_y, 900, 20);
			this.add(label_note3);
			
			layoutPosition_y += 25;
			checkBox2_compression = new JCheckBox("-mx=0");
			checkBox2_compression.setFont(new Font_Common());
			checkBox2_compression.setSelected(true);
			checkBox2_compression.setBounds(30, layoutPosition_y, 180, 20);
			this.add(checkBox2_compression);
			
			JLabel label_note4 = new JLabel("Compress level.");
			label_note4.setFont(new Font_Common());
			label_note4.setBounds(230, layoutPosition_y, 900, 20);
			this.add(label_note4);
			
			layoutPosition_y += 25;
			checkBox3_password = new JCheckBox("-p");
			checkBox3_password.setFont(new Font_Common());
			checkBox3_password.setSelected(true);
			checkBox3_password.setBounds(30, layoutPosition_y, 180, 20);
			this.add(checkBox3_password);
			
			JLabel label_note5 = new JLabel("Password.");
			label_note5.setFont(new Font_Common());
			label_note5.setBounds(230, layoutPosition_y, 100, 20);
			this.add(label_note5);
			
			JButton button4 = new JButton("Clear");
			button4.setHorizontalAlignment(SwingConstants.LEFT);
			button4.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					textField1_password.setText("");
				}
			});
			button4.setBounds(330, layoutPosition_y, 80, 22);
			this.add(button4);
			
			textField1_password = new JTextField();
			textField1_password.setBounds(430, layoutPosition_y, 490, 22);
			this.add(textField1_password);
			
			layoutPosition_y += 25;
			checkBox4_headerEncription = new JCheckBox("-mhe=on");
			checkBox4_headerEncription.setFont(new Font_Common());
			checkBox4_headerEncription.setSelected(true);
			checkBox4_headerEncription.setBounds(30, layoutPosition_y, 180, 20);
			this.add(checkBox4_headerEncription);
			
			JLabel label_note6 = new JLabel("Archive header encription (file names).");
			label_note6.setFont(new Font_Common());
			label_note6.setBounds(230, layoutPosition_y, 900, 20);
			this.add(label_note6);
			
			layoutPosition_y += 25;
			JLabel label_note7 = new JLabel("Path 1.");
			label_note7.setFont(new Font_Common());
			label_note7.setBounds(30, layoutPosition_y, 100, 20);
			this.add(label_note7);
			
			JButton button5 = new JButton("Clear");
			button5.setHorizontalAlignment(SwingConstants.LEFT);
			button5.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					textField2_path1.setText("");
				}
			});
			button5.setBounds(130, layoutPosition_y, 80, 22);
			this.add(button5);
			
			textField2_path1 = new JTextField();
			textField2_path1.setBounds(230, layoutPosition_y, 690, 22);
			this.add(textField2_path1);
			
			layoutPosition_y += 25;
			JLabel label_note8 = new JLabel("Path 2.");
			label_note8.setFont(new Font_Common());
			label_note8.setBounds(30, layoutPosition_y, 100, 20);
			this.add(label_note8);
			
			JButton button6 = new JButton("Clear");
			button6.setHorizontalAlignment(SwingConstants.LEFT);
			button6.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					textField3_path2.setText("");
				}
			});
			button6.setBounds(130, layoutPosition_y, 80, 22);
			this.add(button6);
			
			textField3_path2 = new JTextField();
			textField3_path2.setBounds(230, layoutPosition_y, 690, 22);
			this.add(textField3_path2);
			
			layoutPosition_y += 25;
			checkBox9_copyLastFolder = new JCheckBox("<copy last folder>");
			checkBox9_copyLastFolder.setFont(new Font_Common());
			checkBox9_copyLastFolder.setSelected(true);
			checkBox9_copyLastFolder.setBounds(30, layoutPosition_y, 180, 20);
			this.add(checkBox9_copyLastFolder);
			
			JLabel label_note16 = new JLabel("Copy last part (folder name) of the path to the end.");
			label_note16.setFont(new Font_Common());
			label_note16.setBounds(230, layoutPosition_y, 700, 20);
			this.add(label_note16);
			
			layoutPosition_y += 25;
			checkBox8_suffix = new JCheckBox("<suffix>");
			checkBox8_suffix.setFont(new Font_Common());
			checkBox8_suffix.setSelected(true);
			checkBox8_suffix.setBounds(30, layoutPosition_y, 180, 20);
			this.add(checkBox8_suffix);
			
			JLabel label_note12 = new JLabel("Add suffix.");
			label_note12.setFont(new Font_Common());
			label_note12.setBounds(230, layoutPosition_y, 100, 20);
			this.add(label_note12);
			
			JButton button8 = new JButton("Clear");
			button8.setHorizontalAlignment(SwingConstants.LEFT);
			button8.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					textField4_suffix.setText("");
				}
			});
			button8.setBounds(330, layoutPosition_y, 80, 22);
			this.add(button8);
			
			textField4_suffix = new JTextField();
			textField4_suffix.setBounds(430, layoutPosition_y, 490, 22);
			this.add(textField4_suffix);
			
			layoutPosition_y += 25;
			checkBox5_extension_7z = new JCheckBox(".7z");
			checkBox5_extension_7z.setFont(new Font_Common());
			checkBox5_extension_7z.setSelected(true);
			checkBox5_extension_7z.setBounds(30, layoutPosition_y, 180, 20);
			this.add(checkBox5_extension_7z);
			
			JLabel label_note13 = new JLabel("Add extension.");
			label_note13.setFont(new Font_Common());
			label_note13.setBounds(230, layoutPosition_y, 700, 20);
			this.add(label_note13);
			
			layoutPosition_y += 25;
			checkBox7_extension_7z001 = new JCheckBox(".7z.001");
			checkBox7_extension_7z001.setFont(new Font_Common());
			checkBox7_extension_7z001.setSelected(true);
			checkBox7_extension_7z001.setBounds(30, layoutPosition_y, 180, 20);
			this.add(checkBox7_extension_7z001);
			
			JLabel label_note14 = new JLabel("Prefer extension (for 't' and 'x').");
			label_note14.setFont(new Font_Common());
			label_note14.setBounds(230, layoutPosition_y, 700, 20);
			this.add(label_note14);
			
			layoutPosition_y += 25;
			checkBox6_removeFolder = new JCheckBox("<'x' - remove folder>");
			checkBox6_removeFolder.setFont(new Font_Common());
			checkBox6_removeFolder.setSelected(true);
			checkBox6_removeFolder.setBounds(30, layoutPosition_y, 180, 20);
			this.add(checkBox6_removeFolder);
			
			JLabel label_note15 = new JLabel("'x' - remove last folder in output path.");
			label_note15.setFont(new Font_Common());
			label_note15.setBounds(230, layoutPosition_y, 700, 20);
			this.add(label_note15);
			
			layoutPosition_y += 25;
			button1_fetch = new JButton("Fetch folders");
			button1_fetch.setFont(new Font_Common());
			button1_fetch.setHorizontalAlignment(SwingConstants.LEFT);
			button1_fetch.setBounds(30, layoutPosition_y, 180, 22);
			this.add(button1_fetch);
			
			JLabel label_note11 = new JLabel("TXT file with list of paths, each on one row. Example: /my/path/folder .");
			label_note11.setFont(new Font_Common());
			label_note11.setBounds(230, layoutPosition_y, 700, 20);
			this.add(label_note11);
			// Settings end.
			
			
			layoutPosition_y += 45;
			button2_perform = new JButton("Perform");
			button2_perform.setFont(new Font_Common());
			button2_perform.setHorizontalAlignment(SwingConstants.LEFT);
			button2_perform.setBounds(10, layoutPosition_y, 180, 22);
			this.add(button2_perform);
			
			JButton button3 = new JButton("Go to table");
			button3.setHorizontalAlignment(SwingConstants.LEFT);
			button3.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					cardLayout.show(panel1_main, panel_table_name);
				}
			});
			button3.setBounds(210, layoutPosition_y, 180, 22);
			this.add(button3);
			
			layoutPosition_y += 35;
			button7_save = new JButton("Save");
			button7_save.setFont(new Font_Common());
			button7_save.setHorizontalAlignment(SwingConstants.LEFT);
			button7_save.setBounds(10, layoutPosition_y, 180, 22);
			this.add(button7_save);
			
			layoutPosition_y += 45;
			JLabel label_note9 = new JLabel("Example: 7z a -v3600m -mx=0 -p -mhe=on '/media/path/data1/data1_Suffix.7z' '/media/path/data1' .");
			label_note9.setFont(new Font_Common());
			label_note9.setBounds(30, layoutPosition_y, 900, 20);
			this.add(label_note9);
			
			layoutPosition_y += 20;
			JLabel label_note10 = new JLabel("Example: 7z x '/media/path/data1/data1_Suffix.rar' -o'/media/path/data1' .");
			label_note10.setFont(new Font_Common());
			label_note10.setBounds(30, layoutPosition_y, 900, 20);
			this.add(label_note10);
			
			layoutPosition_y += 35;
			// Set this panel.
			this.setPreferredSize(new Dimension(930, layoutPosition_y + 5));  // Set dimensions according to content.
			JScrollPane scrollPane = new JScrollPane(this);
			scrollPane.setBorder(null);
		}
	
	}

}
