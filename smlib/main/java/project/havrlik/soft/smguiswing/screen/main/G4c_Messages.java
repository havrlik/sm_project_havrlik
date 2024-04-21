package main.java.project.havrlik.soft.smguiswing.screen.main;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import main.java.project.havrlik.soft.smguiswing.font.Font_Title_H1;
import main.java.project.havrlik.soft.smguiswing.listener.MessagesListener_coloring_Interface;
import main.java.project.havrlik.soft.smguiswing.other.Gui_SmScrollTable;
import main.java.project.havrlik.soft.smguiswing.other.Gui_Table_Dto;
import main.java.project.havrlik.soft.smlib.SmLib;
import main.java.project.havrlik.soft.smlib.introduction.Intoduction_GuiSwing_Dimension;
import main.java.project.havrlik.soft.smlib.message.MessageType;

public class G4c_Messages {
	
	protected SmLib smLib;
	protected Intoduction_GuiSwing_Dimension guiDimension;
	
	protected String thisFunctionnalityName;
	protected String thisFunctionnalityName_short;
	
	protected JScrollPane mainPanel;
	protected Gui_SmScrollTable table;
	protected DefaultTableModel defaultTableModel;
	
	protected JTextField textField1;
	
	private boolean colorCells_MessageTypeId = true;
	
	
	public G4c_Messages(SmLib smLib) {
		this.smLib = smLib;
		guiDimension = smLib.introduction.guiSwing_Dimension;
		
		call_constructorContinues();
	}
	
	
	protected void call_constructorContinues() {
		// Recommended disable by overriding empty method and call 'constructorContinues()' at the end of your sub class.
		constructorContinues();
	}
	
	
	protected void constructorContinues() {
		constructor3();
		constructor4_sub();
	}
	
	
	protected void constructor3() {
		mainPanel = new JScrollPane();
		
		set_thisFunctionnalityNames();
		
		content();
	}
	
	
	protected void constructor4_sub() {  }
	
	
	protected void set_thisFunctionnalityNames() {
		thisFunctionnalityName = "Event messages";
		thisFunctionnalityName_short = "Events";
	}
	
	
	protected void content() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JLabel label1 = new JLabel(thisFunctionnalityName);
		label1.setFont(new Font_Title_H1());
		label1.setBounds(20, 10, 980, 22);  // setBounds(x position, y position, x width, y height)
		panel.add(label1);
		
		textField1 = new JTextField("", 30);
		textField1.setBounds(guiDimension.width_rightEdge - 180 - 140 - 140 - 200, 10, 180, 22);
		panel.add(textField1);
		
		JButton button1 = new JButton("Insert label");
		button1.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {  }
			@Override
			public void mousePressed(MouseEvent e) {
				button_insertLabel();
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				scrollTable_scrollDown();
			}
			@Override
			public void mouseEntered(MouseEvent e) {  }
			@Override
			public void mouseExited(MouseEvent e) {  }
		});
//		button1.addMouseListener(new MouseListener() {
//			@Override
//			public void mouseClicked(MouseEvent e) {  }
//			@Override
//			public void mousePressed(MouseEvent e) {  }
//			@Override
//			public void mouseReleased(MouseEvent e) {
//				scrollTable_scrollDown();
//			}
//			@Override
//			public void mouseEntered(MouseEvent e) {  }
//			@Override
//			public void mouseExited(MouseEvent e) {  }
//		});
		button1.setBounds(guiDimension.width_rightEdge - 180 - 140 - 140, 10, 120, 22);
		panel.add(button1);
		
		JButton button2 = new JButton("Export mess.");
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				button_saveList();
			}
		});
		button2.setBounds(guiDimension.width_rightEdge - 180 - 140, 10, 120, 22);
		panel.add(button2);
		
		JButton button3 = new JButton("Refresh");
		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				refreshTable();
			}
		});
		button3.setBounds(guiDimension.width_rightEdge - 180, 10, 180, 22);
		panel.add(button3);
		
		table = new Gui_SmScrollTable(new Gui_Table_Dto(
				smLib.messageReceiver.return_table_messages_columnNames(), 
				smLib.messageReceiver.return_table_messages_columnWidth(), 
				false, 
				null
		));
		table.setBounds(10, 40, guiDimension.width_content, guiDimension.windowFrame_height - 105);
		panel.add(table);
		refreshTable();
		
		// Set main panel.
		panel.setPreferredSize(new Dimension(guiDimension.width_panelScrolling, guiDimension.windowFrame_height - 65 + 5));  // Set dimensions according to content.
		mainPanel = new JScrollPane(panel);
		mainPanel.setBorder(null);
	}
	
	
	private List<MessagesListener_coloring_Interface> listeners_coloring = new ArrayList<MessagesListener_coloring_Interface>();
	public void addListener(MessagesListener_coloring_Interface toAdd) { listeners_coloring.add(toAdd); }
	protected void notifyListeners_coloring() {
		// Notify everybody that may be interested.
		for (MessagesListener_coloring_Interface hl : listeners_coloring) {
			hl.coloringEvent();
		}
	}
	
	
	protected void refreshTable() {
		if (!smLib.messageReceiver.get_isNewUnseenMessage()) {
			scrollTable_scrollDown();
			return;
		}
		
		notifyListeners_coloring();
		table.get_tableDto().rows = smLib.messageReceiver.returnRefreshedTableForGui();
		table.refresh();
		
		if (colorCells_MessageTypeId) {
			MyRenderer myRenderer = new MyRenderer();
			table.get_smTable().setDefaultRenderer(Object.class, myRenderer);
		}
		
		// Scroll to bottom. 
		// Bug, to-do: Do not scrolling precisely to last newly added record(s) on (first) 'refresh'. Hacked by scroll down again on mouse releasing.
		scrollTable_scrollDown();
	}
	
	
	protected void scrollTable_scrollDown() {
		table.getVerticalScrollBar().setValue(table.getVerticalScrollBar().getMaximum());
	}
	
	
	protected void button_insertLabel() {
		smLib.messageReceiver.button_insertLabel(textField1.getText());
		textField1.setText("");
		refreshTable();
	}
	
	
	protected void button_saveList() {
		smLib.messageReceiver.button_saveList();
		refreshTable();
	}
	
	
	class MyRenderer extends DefaultTableCellRenderer {
		
		private static final long serialVersionUID = -5390963021176039533L;
		
		
		public Component getTableCellRendererComponent(JTable table, Object value, boolean   isSelected, boolean hasFocus, int row, int column) {
			Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			
			if (column == 2) {
				int idMessageType = idOfMessageType(String.valueOf(value));
				
				if (idMessageType == MessageType.N0_UNKNOWN.get_id()) {
					c.setBackground(MessageType.N0_UNKNOWN.get_backgroundColor());
				}
				else if (idMessageType == MessageType.N1_FATAL.get_id()) {
					c.setBackground(MessageType.N1_FATAL.get_backgroundColor());
				}
				else if (idMessageType == MessageType.N2_ERROR.get_id()) {
					c.setBackground(MessageType.N2_ERROR.get_backgroundColor());
				}
				else if (idMessageType == MessageType.N3_FAIL.get_id()) {
					c.setBackground(MessageType.N3_FAIL.get_backgroundColor());
				}
				else if (idMessageType == MessageType.N4_WARN.get_id()) {
					c.setBackground(MessageType.N4_WARN.get_backgroundColor());
				}
				else if (idMessageType == MessageType.N11_INFO.get_id()) {
					c.setBackground(MessageType.N11_INFO.get_backgroundColor());
				}
				else if (idMessageType == MessageType.N12_INFONOREFER.get_id()) {
					c.setBackground(MessageType.N12_INFONOREFER.get_backgroundColor());
				}
				else if (idMessageType == MessageType.N13_APP.get_id()) {
					c.setBackground(MessageType.N13_APP.get_backgroundColor());
				}
				else if (idMessageType == MessageType.N14_USER.get_id()) {
					c.setBackground(MessageType.N14_USER.get_backgroundColor());
				}
				else if (idMessageType == MessageType.N21_ANOTHER.get_id()) {
					c.setBackground(MessageType.N21_ANOTHER.get_backgroundColor());
				}
				else if (idMessageType == MessageType.N91_DEVELOPER.get_id()) {
					c.setBackground(MessageType.N91_DEVELOPER.get_backgroundColor());
				}
				else if (idMessageType == MessageType.N92_DEVELOPER_FAST.get_id()) {
					c.setBackground(MessageType.N92_DEVELOPER_FAST.get_backgroundColor());
				}
				else if (idMessageType == MessageType.N2_ERROR.get_id()) {
					c.setBackground(MessageType.N2_ERROR.get_backgroundColor());
				}
				else {
					c.setBackground(table.getBackground());
				}
			}
			else {
				c.setBackground(table.getBackground());
			}
			
			return c;
		}
		
		
		private int idOfMessageType(String value) {
			String id_string = "";
			for (int i1 = 0; i1 < value.length(); i1++) {
				if (value.charAt(i1) == ' ') {
					break;
				}
				id_string += value.charAt(i1);
			}
			
			try {
				return Integer.valueOf(id_string);
			}
			catch (Exception e1) {
				return -1;
			}
		}
		
	}

}
