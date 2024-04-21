package main.java.project.havrlik.soft.smguiswing.screen.main;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import main.java.project.havrlik.soft.smlib.SmLib;

public class G4d_MainTabs extends JTabbedPane {
	
	private static final long serialVersionUID = -1870096753647087755L;
	
	protected SmLib smLib;
	
	int tabMain_i = 0;   // TODO
	
	
	public G4d_MainTabs(SmLib smLib) {
		this.smLib = smLib;
		
		constructor1();
		
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
	
	
	protected void constructor1() {
	}
	
	
	protected void constructor3() {  }
	protected void constructor4_sub() {  }
	
	
	public void addNewTab(String tabName, JPanel panel) {
		// https://stackoverflow.com/questions/11553112/how-to-add-close-button-to-a-jtabbedpane-tab
		tabMain_i++;
		tabName = "T" + tabMain_i + " " + tabName;
		String tabName_c = tabName;
		this.addTab(tabName_c, panel);
		
		//cardPanel1_panel4_tabbedPane1.addTab(tabMain_title, obj_panel);
		int tabMain_index = this.indexOfTab(tabName_c);
		JPanel pnlTab = new JPanel(new GridBagLayout());
		pnlTab.setOpaque(false);
		pnlTab.setBorder(new EmptyBorder(1, 0, 1, 0));
		JLabel tabMain_title_label = new JLabel(tabName + "  ");
		JButton tabMain_buttonClose = new JButton("x");
		//tabMain_buttonClose.setFocusPainted(false);
		tabMain_buttonClose.setMargin(new Insets(0, 0, 0, 0));
		tabMain_buttonClose.setContentAreaFilled(false);
		//tabMain_buttonClose.setBorderPainted(false);
		//tabMain_buttonClose.setOpaque(false);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1;
		pnlTab.add(tabMain_title_label, gbc);
		gbc.gridx++;
		gbc.weightx = 0;
		pnlTab.add(tabMain_buttonClose, gbc);
		
		this.setTabComponentAt(tabMain_index, pnlTab);
		
		tabMain_buttonClose.addActionListener(new ActionListener() {
			private String tabName_b = tabName_c;
			public String getTabName() {
				return tabName_b;
			}
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int index = returnThis().indexOfTab(getTabName());
				if (index >= 0) {
					int i = JOptionPane.showConfirmDialog(null, "Close tab: '" + getTabName() + "'?", "Confirm: closing tabs", JOptionPane.OK_CANCEL_OPTION);
					if (i == 0) {
						returnThis().removeTabAt(index);
					}
				}
				
				// https://stackoverflow.com/questions/11553112/how-to-add-close-button-to-a-jtabbedpane-tab
				
				//Component selected = this.getSelectedComponent();
				//if (selected != null) {
					//this.remove(selected);
					// It would probably be worthwhile getting the source
					// casting it back to a JButton and removing
					// the action handler reference ;)
				//}
			}
		});
		this.setSelectedIndex(tabMain_index);
	}
	
	
	public void removeTab(String tabName) {
		String tabName_2 = tabName;
		int index = this.indexOfTab(tabName_2);
		this.removeTabAt(index);
	}
	
	
	public void removeAllTabs() {
		this.removeAll();
	}
	
	JTabbedPane returnThis() {
		return this;
	}

}
