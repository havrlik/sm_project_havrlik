package main.java.project.havrlik.soft.filefixtures.fc1_filelist;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import main.java.project.havrlik.soft.filefixtures.smlib.SmLib;
import main.java.project.havrlik.soft.smguiswing.font.Font_Common;
import main.java.project.havrlik.soft.smguiswing.font.Font_Common_Bold;
import main.java.project.havrlik.soft.smguiswing.font.Font_Title_H2;
import main.java.project.havrlik.soft.smguiswing.label.Label_Title;
import main.java.project.havrlik.soft.smguiswing.other.Panel_Main2_Scroll;
import main.java.project.havrlik.soft.smlib.introduction.Intoduction_GuiSwing_Dimension;

public class FilesInDirectories_Gui {
	
	private Intoduction_GuiSwing_Dimension guiDimension;
	
//	public final String thisFunctionnalityName_parent1_short = "";
	public final String thisFunctionnalityName = "Files in directories";
	public final String thisFunctionnalityName_short = "Files";
	private JPanel panel1_main;
	private CardLayout cardLayout;
	private String panel_main2_name;
	
	JLabel label_state;
	JLabel label_details;
	JLabel label_targetDirectory;
	JLabel label_resuldSavedToDirectory;
	JButton button1;
	JButton button2;
	JButton button4_checkFilenames;
	JButton button4_checkFilenames_pattern;
	JButton button3;
	JCheckBox checkBox1;
	JTextField textField1;
	
	
	public FilesInDirectories_Gui(SmLib smLib) {
		guiDimension = smLib.introduction.guiSwing_Dimension;
		
		// Main panel.
		Panel_Main2_Scroll panel_main2 = new Panel_Main2_Scroll(new Panel_Main3());
		panel_main2_name = "panel_main2";
		
		// Cards
		panel1_main = new JPanel();
		cardLayout = new CardLayout();
		panel1_main.setLayout(cardLayout);
		panel1_main.add(panel_main2, panel_main2_name);
		
		cardLayout.show(panel1_main, panel_main2_name);
	}
	
	
	public JPanel return_panel1() { return panel1_main; }
	
	
	public void clearLabels() {
		label_state.setText("-");
		label_details.setText("-");
		label_targetDirectory.setText("-");
		label_resuldSavedToDirectory.setText("-");
		textField1.setText("");
	}
	
	
	private class Panel_Main3 extends JPanel {
		
		private static final long serialVersionUID = -4581628264685422934L;
		
		
		Panel_Main3() {
			super();
			
			this.setLayout(null);
			
			
	//		Label_Title label_title = new Label_Title(thisFunctionnalityName_parent1_short + " → " + thisFunctionnalityName, guiDimension.width_leftPadding + 10, guiDimension.width_rightEdge);
			Label_Title label_title = new Label_Title(thisFunctionnalityName, guiDimension.width_leftPadding + 10, guiDimension.width_rightEdge);
			this.add(label_title);
			
			int layoutPosition_y = 45;
			
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
			JLabel label_details_a = new JLabel("Details:");
			label_details_a.setFont(new Font_Common());
			label_details_a.setBounds(30, layoutPosition_y, 120, 20);
			this.add(label_details_a);
			
			label_details = new JLabel("-");
			label_details.setFont(new Font_Common());
			label_details.setBounds(160, layoutPosition_y, 760, 20);
			this.add(label_details);
			
			layoutPosition_y += 35;
			// Description.
			JLabel label_description_a = new JLabel("Description:");
			label_description_a.setFont(new Font_Common());
			label_description_a.setBounds(30, layoutPosition_y, 120, 20);
			this.add(label_description_a);
			
			JLabel label_description_1 = new JLabel(
					"Application ask for target directory, then load file names and directories inside. The result will save to a new text file.");
			label_description_1.setFont(new Font_Common());
			label_description_1.setBounds(160, layoutPosition_y, 760, 20);
			this.add(label_description_1);
			
			// Function.
			layoutPosition_y += 40;
			JLabel label0 = new JLabel("Fetch file names list from selected directory:");
			label0.setFont(new Font_Title_H2());
			label0.setBounds(10, layoutPosition_y, 910, 20);
			this.add(label0);
			
			layoutPosition_y += 35;
			JLabel label_targetDirectory_a = new JLabel("Details (input):");
			label_targetDirectory_a.setFont(new Font_Common());
			label_targetDirectory_a.setBounds(30, layoutPosition_y, 120, 20);
			this.add(label_targetDirectory_a);
			
			label_targetDirectory = new JLabel("-");
			label_targetDirectory.setFont(new Font_Common());
			label_targetDirectory.setBounds(160, layoutPosition_y, 760, 20);
			this.add(label_targetDirectory);
			
			layoutPosition_y += 35;
			JLabel label_resuldSavedToDirectory_a = new JLabel("Details (output):");
			label_resuldSavedToDirectory_a.setFont(new Font_Common());
			label_resuldSavedToDirectory_a.setBounds(30, layoutPosition_y, 120, 20);
			this.add(label_resuldSavedToDirectory_a);
			
			label_resuldSavedToDirectory = new JLabel("-");
			label_resuldSavedToDirectory.setFont(new Font_Common());
			label_resuldSavedToDirectory.setBounds(160, layoutPosition_y, 760, 20);
			this.add(label_resuldSavedToDirectory);
			
			layoutPosition_y += 35;
			JLabel label1 = new JLabel("1) Select target directory:");
			label1.setFont(new Font_Common());
			label1.setBounds(10, layoutPosition_y, 700, 20);
			this.add(label1);
			
			button1 = new JButton("Select");
			button1.setBounds(720, layoutPosition_y, 180, 22);
			button1.setHorizontalAlignment(SwingConstants.LEFT);
			this.add(button1);
			
			layoutPosition_y += 35;
			JLabel label2 = new JLabel("2) Fetch names:");
			label2.setFont(new Font_Common());
			label2.setBounds(10, layoutPosition_y, 700, 20);
			this.add(label2);
			
			layoutPosition_y += 35;
			checkBox1 = new JCheckBox("Include file sizes.", false);
			checkBox1.setFont(new Font_Common());
			checkBox1.setBounds(30, layoutPosition_y, 150, 20);
			this.add(checkBox1);
			
			button2 = new JButton("Fetch");
			button2.setBounds(720, layoutPosition_y, 180, 22);
			button2.setHorizontalAlignment(SwingConstants.LEFT);
			this.add(button2);
			
			layoutPosition_y += 35;
			JLabel label5 = new JLabel("3) Check file and folder names:");
			label5.setFont(new Font_Common());
			label5.setBounds(10, layoutPosition_y, 700, 20);
			this.add(label5);
			
			button4_checkFilenames = new JButton("Check");
			button4_checkFilenames.setBounds(520, layoutPosition_y, 180, 22);
			button4_checkFilenames.setHorizontalAlignment(SwingConstants.LEFT);
			this.add(button4_checkFilenames);
			
			layoutPosition_y += 30;
			button4_checkFilenames_pattern = new JButton("Check patternt");
			button4_checkFilenames_pattern.setBounds(520, layoutPosition_y, 180, 22);
			button4_checkFilenames_pattern.setHorizontalAlignment(SwingConstants.LEFT);
			this.add(button4_checkFilenames_pattern);
			
			layoutPosition_y += 35;
			JLabel label3 = new JLabel("4) Save list to new text file:");
			label3.setFont(new Font_Common());
			label3.setBounds(10, layoutPosition_y, 700, 20);
			this.add(label3);
			
			layoutPosition_y += 35;
			JLabel label4 = new JLabel("Insert note to file:");
			label4.setFont(new Font_Common());
			label4.setBounds(30, layoutPosition_y, 120, 20);
			this.add(label4);
			
			textField1 = new JTextField();
			textField1.setBounds(160, layoutPosition_y, 740, 22);
			this.add(textField1);
			
			layoutPosition_y += 35;
			button3 = new JButton("Save file");
			button3.setBounds(720, layoutPosition_y, 180, 22);
			button3.setHorizontalAlignment(SwingConstants.LEFT);
			this.add(button3);
			
			
			// Set this panel.
			layoutPosition_y += 35;
			this.setPreferredSize(new Dimension(930, layoutPosition_y + 5));  // Set dimensions according to content.
			JScrollPane scrollPane = new JScrollPane(this);
			scrollPane.setBorder(null);
		}
	}

}
