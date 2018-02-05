package enamel;

import javax.swing.JButton;
import javax.swing.JFileChooser;

public class TestFileToCardsParser {

	public static void main(String[] args) {
		JButton open = new JButton();
		JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(new java.io.File("./FactoryScenarios"));
		fc.setDialogTitle("Please Choose File to Open");
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {

		}
		FileToCardsParser f = new FileToCardsParser();
		f.setFile(fc.getSelectedFile().getPath());
	}
}
