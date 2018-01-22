package enamel;

import java.awt.event.ActionListener;

import javax.swing.*;

public class AuthoringViewer extends JFrame {
	private JLabel prompt;
	private JLabel b1L;
	private JLabel b2L;
	private JLabel b3L;
	private JLabel b4L;
	private JTextField promptTF;
	private JTextField b1TF;
	private JTextField b2TF;
	private JTextField b3TF;
	private JTextField b4TF;
	private JFileChooser fc;
	private JRadioButton rbLetter;
	private JRadioButton rbPins;
	private JCheckBox b1CB;
	private JCheckBox b2CB;
	private JCheckBox b3CB;
	private JCheckBox b4CB;
	private JList list;
	
	public AuthoringViewer(ActionListener listener) {
		super("File Creator");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.makeLables();
		this.makeTextFields();
		this.makeButtons();
		this.makeFileChooser();
		this.makeMenu();
		this.makeJCheckBox();
		this.makeList();
		
		this.add(prompt);
		this.add(promptTF);
		this.add(b1L);
		this.add(b1TF);
		this.add(b1CB);
		this.add(b2L);
		this.add(b2TF);
		this.add(b2CB);
		this.add(b3L);
		this.add(b3TF);
		this.add(b3CB);
		this.add(b4L);
		this.add(b4TF);
		this.add(b4CB);
		this.add(rbLetter);
		this.add(rbPins);
		this.add(list);
		
	}

	private void makeList() {
		// TODO Auto-generated method stub
		
	}

	private void makeJCheckBox() {
		// TODO Auto-generated method stub
		
	}

	private void makeMenu() {
		// TODO Auto-generated method stub
		
	}

	private void makeFileChooser() {
		// TODO Auto-generated method stub
		
	}

	private void makeButtons() {
		// TODO Auto-generated method stub
		
	}

	private void makeTextFields() {
		// TODO Auto-generated method stub
		
	}

	private void makeLables() {
		// TODO Auto-generated method stub
		
	}
	
}
