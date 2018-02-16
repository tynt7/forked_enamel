package enamel;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Scrollbar;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import java.awt.GridBagConstraints;
import javax.swing.DefaultComboBoxModel;
import java.awt.Insets;
import java.awt.ItemSelectable;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import javax.swing.JEditorPane;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import javax.swing.BoxLayout;

public class AuthoringViewer {

	private JFrame aViewFrame;
	private int numCells = 1;
	private int numButtons = 1; 
	private JTextField txtCardName;
	private JTextField txtAudiofilenamemp;
	private JTextField textField;
	// non zero

	/**
	 * Launch the application.
	 */
	public static void displayForm() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AuthoringViewer window = new AuthoringViewer();
					window.aViewFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AuthoringViewer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		aViewFrame = new JFrame();
		aViewFrame.getContentPane().setBackground(Color.GRAY);
		aViewFrame.getContentPane().setLayout(null);
		
		JLabel lblCurrcard = new JLabel("1/n");
		lblCurrcard.setBounds(148, 10, 55, 16);
		aViewFrame.getContentPane().add(lblCurrcard);
		
		JLabel lblPrompt = new JLabel("PROMPT");
		lblPrompt.setBounds(250, 10, 61, 16);
		aViewFrame.getContentPane().add(lblPrompt);
		
		JLabel lblOrder = new JLabel("ORDER");
		lblOrder.setBounds(750, 10, 61, 16);
		aViewFrame.getContentPane().add(lblOrder);
		
		txtCardName = new JTextField();
		txtCardName.setText("Card Name");
		txtCardName.setBounds(6, 5, 130, 26);
		aViewFrame.getContentPane().add(txtCardName);
		txtCardName.setColumns(10);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(250, 30, 478, 128);
		aViewFrame.getContentPane().add(editorPane);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(250, 320, 561, 65);
		aViewFrame.getContentPane().add(buttonPanel);
		buttonPanel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(53, 19, 0, 0);
		buttonPanel.add(label);
		
		JButton button = new JButton("1");
		button.setBounds(20, 20, 80, 30);
		buttonPanel.add(button);
		
		JButton button_1 = new JButton("2");
		button_1.setBounds(110, 20, 80, 30);
		buttonPanel.add(button_1);
		
		JButton button_2 = new JButton("3");
		button_2.setBounds(200, 20, 75, 30);
		buttonPanel.add(button_2);
		
		JButton button_3 = new JButton("4");
		button_3.setBounds(290, 20, 75, 30);
		buttonPanel.add(button_3);
		
		JButton button_4 = new JButton("5");
		button_4.setBounds(380, 20, 75, 30);
		buttonPanel.add(button_4);
		
		JButton button_5 = new JButton("6");
		button_5.setBounds(470, 20, 75, 30);
		buttonPanel.add(button_5);
		
		JLabel lblButtons = new JLabel("BUTTONS");
		lblButtons.setBounds(250, 300, 61, 16);
		aViewFrame.getContentPane().add(lblButtons);
		
		JLabel lblAudio = new JLabel("AUDIO");
		lblAudio.setBounds(250, 200, 61, 16);
		aViewFrame.getContentPane().add(lblAudio);
		
		txtAudiofilenamemp = new JTextField();
		txtAudiofilenamemp.setText("AudioFileName.mp3");
		txtAudiofilenamemp.setBounds(250, 220, 209, 26);
		aViewFrame.getContentPane().add(txtAudiofilenamemp);
		txtAudiofilenamemp.setColumns(10);
		
		JPanel cellPanel = new JPanel();
		cellPanel.setBounds(70, 38, 82, 105);
		aViewFrame.getContentPane().add(cellPanel);
		cellPanel.setLayout(null);
		
		JRadioButton pOne = new JRadioButton("");
		pOne.setBounds(6, 6, 28, 23);
		cellPanel.add(pOne);
		
		JRadioButton pFour = new JRadioButton("");
		pFour.setBounds(46, 6, 28, 23);
		cellPanel.add(pFour);
		
		JRadioButton pTwo = new JRadioButton("");
		pTwo.setBounds(6, 41, 28, 23);
		cellPanel.add(pTwo);
		
		JRadioButton pFive = new JRadioButton("");
		pFive.setBounds(46, 41, 28, 23);
		cellPanel.add(pFive);
		
		JRadioButton pThree = new JRadioButton("");
		pThree.setBounds(6, 76, 28, 23);
		cellPanel.add(pThree);
		
		JRadioButton pSix = new JRadioButton("");
		pSix.setBounds(46, 76, 28, 23);
		cellPanel.add(pSix);
		
		textField = new JTextField();
		textField.setBounds(73, 155, 130, 26);
		aViewFrame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblLetter = new JLabel("Letter:");
		lblLetter.setBounds(20, 160, 55, 16);
		aViewFrame.getContentPane().add(lblLetter);
		
		JButton btnAudio = new JButton("Audio");
		btnAudio.setBounds(823, 319, 117, 29);
		aViewFrame.getContentPane().add(btnAudio);
		
		JButton btnFunction = new JButton("Function");
		btnFunction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				functionView fw = new functionView();
				fw.displayForm();
			}
		});
		btnFunction.setBounds(823, 356, 117, 29);
		aViewFrame.getContentPane().add(btnFunction);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "Do want to EXIT? \nNo changes will be saved!!!", "Confirm", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if (option == JOptionPane.YES_OPTION) {
					aViewFrame.dispose();
				} else {
					// do nothing
				}
			}
		});
		btnExit.setBounds(20, 525, 50, 50);
		aViewFrame.getContentPane().add(btnExit);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSave.setBounds(80, 525, 50, 50);
		aViewFrame.getContentPane().add(btnSave);
		
		JButton btnTest = new JButton("Test");
		btnTest.setBounds(140, 525, 50, 50);
		aViewFrame.getContentPane().add(btnTest);
		
		JEditorPane buttonEditor = new JEditorPane();
		buttonEditor.setBounds(250, 400, 561, 70);
		aViewFrame.getContentPane().add(buttonEditor);
		
		JButton button_6 = new JButton("<");
		button_6.setBounds(38, 80, 20, 20);
		aViewFrame.getContentPane().add(button_6);
		
		JButton button_7 = new JButton(">");
		button_7.setBounds(164, 80, 20, 20);
		aViewFrame.getContentPane().add(button_7);
		
		JList list = new JList();
		list.setBounds(750, 30, 234, 128);
		aViewFrame.getContentPane().add(list);
		
		JButton btnR = new JButton("R");
		btnR.setBounds(458, 224, 20, 20);
		aViewFrame.getContentPane().add(btnR);
		
		JButton btnI = new JButton("I");
		btnI.setBounds(482, 224, 20, 20);
		aViewFrame.getContentPane().add(btnI);
		
		JButton btnD = new JButton("D");
		btnD.setBounds(506, 224, 20, 20);
		aViewFrame.getContentPane().add(btnD);
		aViewFrame.setResizable(false);
		aViewFrame.setBackground(new Color(255, 255, 255));
		aViewFrame.setTitle("AuthoringApp view");
		aViewFrame.setBounds(100, 100, 1000, 612);
		aViewFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		aViewFrame.addWindowListener(new confirmClose());


	}

	private class confirmClose extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			int option = JOptionPane.showConfirmDialog(null, "Do want to EXIT? \nNo changes will be saved!!!", "Confirm", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			if (option == JOptionPane.YES_OPTION) {
				// System.exit( 0 );
				aViewFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			} else {
				// do nothing
			}
		}
	}
}
