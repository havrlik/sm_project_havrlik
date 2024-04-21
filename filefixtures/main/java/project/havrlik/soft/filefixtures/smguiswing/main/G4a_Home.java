package main.java.project.havrlik.soft.filefixtures.smguiswing.main;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import main.java.project.havrlik.soft.smlib.SmLib;


public class G4a_Home extends main.java.project.havrlik.soft.smguiswing.screen.main.G4a_Home {
	
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	
	
	public G4a_Home(SmLib smLib) {
		super(smLib);
		
		constructor2_sub();
		
		constructorContinues();
	}
	
	
	@Override
	protected void call_constructorContinues() {  }
	
	
	protected void constructor2_sub() {  }
	
	
	public JButton get_button1() { return button1; }
	public JButton get_button2() { return button2; }
	public JButton get_button3() { return button3; }
	public JButton get_button4() { return button4; }
	public JButton get_button5() { return button5; }
	
	
	@Override
	protected void content() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		
		header(panel);
		
		int layoutPosition_y = 50;
		
		button1 = new JButton("1) Files list");
		button1.setHorizontalAlignment(SwingConstants.LEFT);
		button1.setBounds(10, layoutPosition_y, 180, 22);
		panel.add(button1);
		
		JLabel label1 = new JLabel("Fetch file names in directories.");
		label1.setBounds(210, layoutPosition_y, 710, 20);
		panel.add(label1);
		layoutPosition_y += 35;
		
		button2 = new JButton("2) Create playlist");
		button2.setHorizontalAlignment(SwingConstants.LEFT);
		button2.setBounds(10, layoutPosition_y, 180, 22);
		panel.add(button2);
		
		JLabel label2 = new JLabel("Create audio playlist.");
		label2.setBounds(210, layoutPosition_y, 710, 20);
		panel.add(label2);
		layoutPosition_y += 35;
		
//		button3 = new JButton("3) Fake file");
//		button3.setHorizontalAlignment(SwingConstants.LEFT);
//		button3.setBounds(10, layoutPosition_y, 180, 22);
//		panel.add(button3);
//		
//		JLabel label3 = new JLabel("Fake file magic number.");
//		label3.setBounds(210, layoutPosition_y, 710, 20);
//		panel.add(label3);
//		layoutPosition_y += 35;
		
		button4 = new JButton("3) File rename");
		button4.setHorizontalAlignment(SwingConstants.LEFT);
		button4.setBounds(10, layoutPosition_y, 180, 22);
		panel.add(button4);
		
		JLabel label4 = new JLabel("");
		label4.setBounds(210, layoutPosition_y, 710, 20);
		panel.add(label4);
		layoutPosition_y += 35;
		
		button5 = new JButton("4) Archive commands");
		button5.setHorizontalAlignment(SwingConstants.LEFT);
		button5.setBounds(10, layoutPosition_y, 180, 22);
		panel.add(button5);
		
		JLabel label5 = new JLabel("");
		label5.setBounds(210, layoutPosition_y, 710, 20);
		panel.add(label5);
		layoutPosition_y += 35;
		
		
		// Set main panel.
		panel.setPreferredSize(new Dimension(guiDimension.width_panelScrolling, layoutPosition_y + 5));  // Set dimensions according to content.
		mainPanel = new JScrollPane(panel);
		mainPanel.setBorder(null);
	}

}
