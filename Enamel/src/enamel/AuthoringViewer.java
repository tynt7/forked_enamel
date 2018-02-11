package enamel;

import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;

//A basic GUI
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
	private JTextField textField;
	private JTextField letterInput;
	
	public AuthoringViewer(ActionListener listener) {
		super("File Creator");
		setResizable(false);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(23, 150, 130, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		letterInput = new JTextField();
		letterInput.setBounds(20, 205, 150, 30);
		getContentPane().add(letterInput);
		letterInput.setColumns(10);
		
		JButton exit = new JButton("X");
		exit.setForeground(Color.BLACK);
		exit.setBackground(Color.WHITE);
		exit.setBounds(20, 296, 50, 50);
		getContentPane().add(exit);
		
		JButton save = new JButton("S");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		save.setBounds(70, 296, 50, 50);
		getContentPane().add(save);
		
		JButton test = new JButton("T");
		test.setBounds(120, 296, 50, 50);
		getContentPane().add(test);
		
		JButton left = new JButton("<");
		left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		left.setBounds(70, 240, 21, 29);
		getContentPane().add(left);
		
		JButton right = new JButton(">");
		right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		right.setBounds(103, 240, 21, 29);
		getContentPane().add(right);
		
		JList orderList = new JList();
		orderList.setBounds(435, 40, 197, 114);
		getContentPane().add(orderList);
		
		JEditorPane promptText = new JEditorPane();
		promptText.setBounds(183, 40, 240, 114);
		getContentPane().add(promptText);
		
		JLabel lblPrompt = new JLabel("PROMPT");
		lblPrompt.setBounds(183, 12, 61, 16);
		getContentPane().add(lblPrompt);
		
		JLabel lblCard = new JLabel("ORDER");
		lblCard.setBounds(435, 12, 61, 16);
		getContentPane().add(lblCard);
		
		JLabel lblAudio = new JLabel("AUDIO");
		lblAudio.setBounds(183, 166, 61, 16);
		getContentPane().add(lblAudio);
		
		JTextPane audioFile = new JTextPane();
		audioFile.setText("AudioFileName.mp3");
		audioFile.setBounds(182, 182, 150, 16);
		getContentPane().add(audioFile);
		
		JButton recButt = new JButton("R");
		recButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		recButt.setBounds(333, 182, 30, 16);
		getContentPane().add(recButt);
		
		JButton impButt = new JButton("I");
		impButt.setBounds(363, 182, 30, 16);
		getContentPane().add(impButt);
		
		JButton delButt = new JButton("D");
		delButt.setBounds(393, 182, 30, 16);
		getContentPane().add(delButt);
		
		JLabel lblButtons = new JLabel("BUTTONS");
		lblButtons.setBounds(182, 212, 61, 16);
		getContentPane().add(lblButtons);
		
		JEditorPane bttnText = new JEditorPane();
		bttnText.setBounds(183, 284, 449, 79);
		getContentPane().add(bttnText);
		
		JPanel bttnList = new JPanel();
		bttnList.setBounds(182, 230, 450, 42);
		getContentPane().add(bttnList);
		bttnList.setLayout(new BoxLayout(bttnList, BoxLayout.X_AXIS));
		
		JToggleButton one = new JToggleButton("1");
		bttnList.add(one);
		
		JToggleButton two = new JToggleButton("2");
		bttnList.add(two);
		
		JToggleButton three = new JToggleButton("3");
		bttnList.add(three);
		
		JToggleButton four = new JToggleButton("4");
		bttnList.add(four);
		
		JToggleButton five = new JToggleButton("5");
		bttnList.add(five);
		
		JToggleButton six = new JToggleButton("6");
		bttnList.add(six);
		
		JLabel currCard = new JLabel("currCard");
		currCard.setBounds(20, 12, 61, 16);
		getContentPane().add(currCard);
		
		this.makeLables();
		this.makeTextFields();
		this.makeButtons();
		this.makeFileChooser();
		this.makeMenu();
		this.makeJCheckBox();
		this.makeList();
		
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
