package main.java.project.havrlik.soft.filefixtures.fc2_audioplaylist;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import main.java.project.havrlik.soft.filefixtures.smlib.SmLib;
import main.java.project.havrlik.soft.smguiswing.font.Font_Common;
import main.java.project.havrlik.soft.smguiswing.font.Font_Common_Bold;
import main.java.project.havrlik.soft.smguiswing.font.Font_Title_H2;
import main.java.project.havrlik.soft.smguiswing.label.Label_Title;
import main.java.project.havrlik.soft.smlib.introduction.Intoduction_GuiSwing_Dimension;

public class AudioPlaylistsCreator_Gui {
	
	private Intoduction_GuiSwing_Dimension guiDimension;
	
//	public final String thisFunctionnalityName_parent1_short = "";
	public final String thisFunctionnalityName = "Audio playlist creator";
	public final String thisFunctionnalityName_short = "Playlists";
	private JPanel panel1_main;
	private CardLayout cardLayout;
	private String panel_main2_name;
	
	JLabel label_state;
	JLabel label_directory;
	JButton button1;
	JCheckBox checkBox1;
	JTextField textField1;
	
	
	public AudioPlaylistsCreator_Gui(SmLib smLib) {
		guiDimension = smLib.introduction.guiSwing_Dimension;
		
		// Main panel.
		Panel_Main2 panel_main2 = new Panel_Main2(new Panel_Main3());
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
		label_directory.setText("-");
	}
	
	
	private class Panel_Main2 extends JScrollPane {
		
		private static final long serialVersionUID = 8945114317816736864L;
		
		
		Panel_Main2(Panel_Main3 panel) {
			super(panel);
//			this.setPreferredSize(new Dimension(1140, 590));
			this.setBorder(null);
		}
	
	}
	
	
	private class Panel_Main3 extends JPanel {
		
		private static final long serialVersionUID = -6453104802466395461L;
		
		
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
			
			JLabel label_description_1 = new JLabel("Create palylist file in selected directory. Insert files which is containing the directory.");
			label_description_1.setFont(new Font_Common());
			label_description_1.setBounds(160, layoutPosition_y, 760, 20);
			this.add(label_description_1);
			layoutPosition_y += 35;
			
			// Function.
			layoutPosition_y += 5;
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
			
			// Last directory.
			JLabel label_labelDirectory = new JLabel("Last directory:");
			label_labelDirectory.setFont(new Font_Common());
			label_labelDirectory.setBounds(30, layoutPosition_y, 120, 20);
			this.add(label_labelDirectory);
			
			label_directory = new JLabel("-");
			label_directory.setFont(new Font_Common());
			label_directory.setBounds(160, layoutPosition_y, 760, 20);
			this.add(label_directory);
			layoutPosition_y += 35;
			
			JLabel label1 = new JLabel("1) Select directory, create and save paylist:");
			label1.setFont(new Font_Common());
			label1.setBounds(10, layoutPosition_y, 910, 20);
			this.add(label1);
			layoutPosition_y += 35;
			
			checkBox1 = new JCheckBox("Check file name extensions, exclude non audio.", true);
			checkBox1.setFont(new Font_Common());
			checkBox1.setBounds(30, layoutPosition_y, 890, 20);
			this.add(checkBox1);
			layoutPosition_y += 35;
			
			JLabel label4 = new JLabel("Insert file name prefix:");
			label4.setFont(new Font_Common());
			label4.setBounds(30, layoutPosition_y, 180, 20);
			this.add(label4);
			
			textField1 = new JTextField();
			textField1.setBounds(230, layoutPosition_y, 180, 22);
			this.add(textField1);
			layoutPosition_y += 35;
			
			button1 = new JButton("Go");
			button1.setBounds(740, layoutPosition_y, 180, 22);
			this.add(button1);
			layoutPosition_y += 35;
			
			
			// Set this panel.
			this.setPreferredSize(new Dimension(930, layoutPosition_y + 5));  // Set dimensions according to content.
			JScrollPane scrollPane = new JScrollPane(this);
			scrollPane.setBorder(null);
		}
	}

}
