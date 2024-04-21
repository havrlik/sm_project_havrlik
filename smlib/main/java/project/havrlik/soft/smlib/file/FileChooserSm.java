package main.java.project.havrlik.soft.smlib.file;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

import main.java.project.havrlik.soft.smlib.SmLib;

public class FileChooserSm extends JPanel implements ActionListener {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5468261681L;

	SmLib smLib;
	
	String lastDir = "";
	
	
	public FileChooserSm(SmLib smLib) {
		this.smLib = smLib;
	}
	
	
	String jFileChooser_chooseDirectory(String fromDirectory) {
		JFileChooser chooser = new JFileChooser(lastDir);
		chooser.setPreferredSize(new Dimension(850, 650));  // Origin: '800, 600'.
		String choosertitle = "Choose a directory";
		chooser.setDialogTitle(choosertitle);
		
		if (fromDirectory != null) {
			chooser.setCurrentDirectory(new File(fromDirectory));
		}
		else if (smLib.introduction.customValues.defaultWorkspaceDirectory != null) {
			chooser.setCurrentDirectory(new File(smLib.introduction.customValues.defaultWorkspaceDirectory));
		}
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		// disable the "All files" option.
		chooser.setAcceptAllFileFilterUsed(false);
		
		File dir;
		String directory = null;
		
		if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			//System.out.println("getCurrentDirectory(): " +  chooser.getCurrentDirectory());
			//System.out.println("getSelectedFile() : " +  chooser.getSelectedFile());
			lastDir = "";
			lastDir += chooser.getCurrentDirectory();
			dir = chooser.getSelectedFile();
			directory = dir.getAbsolutePath();
		}
		else {
			//System.out.println("No Selection ");
			directory = null;
		}

		return directory;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
	}
	
}
