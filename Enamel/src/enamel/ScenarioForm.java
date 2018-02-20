package enamel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;

import audioRecorder.RecorderFrame;

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
import java.util.ArrayList;

import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.GridBagConstraints;
import javax.swing.DefaultComboBoxModel;
import java.awt.Insets;
import java.awt.ItemSelectable;

//import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import java.awt.GridLayout;

@SuppressWarnings({"unused", "rawtypes"})
public class ScenarioForm {

	private JFrame sCreatorFrame;
	private int numCells = 1; // assuming 1 selected by default. i.e. always non
								// zero
	private int numButtons = 1; // assuming 1 selected by default. i.e. always
	private JTextField titleTextField;
	private JTextField audioFileTextField;
	// non zero

	/**
	 * Launch the application.
	 */
	public static void displayForm() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScenarioForm window = new ScenarioForm();
					window.sCreatorFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ScenarioForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unchecked")
	private void initialize() {
		sCreatorFrame = new JFrame();
		sCreatorFrame.getContentPane().setBackground(UIManager.getColor("CheckBox.background"));
		sCreatorFrame.setResizable(false);
		sCreatorFrame.setBackground(new Color(255, 255, 255));
		sCreatorFrame.setTitle("Scenario Creator");
		sCreatorFrame.setBounds(100, 100, 467, 412);
		sCreatorFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		sCreatorFrame.addWindowListener(new confirmClose());
				sCreatorFrame.getContentPane().setLayout(null);
				// exit

				JLabel lblNewLabel = new JLabel("Create a Scenario for your Students");
				lblNewLabel.setBounds(103, 20, 236, 18);
				lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
				sCreatorFrame.getContentPane().add(lblNewLabel);
				
				JLabel label = new JLabel("");
				label.setBounds(254, 18, 0, 0);
				sCreatorFrame.getContentPane().add(label);
				
				JLabel label_1 = new JLabel("");
				label_1.setBounds(259, 18, 0, 0);
				sCreatorFrame.getContentPane().add(label_1);
				
				JLabel label_2 = new JLabel("");
				label_2.setBounds(264, 18, 0, 0);
				sCreatorFrame.getContentPane().add(label_2);
		
				JLabel lblNumberOfCells = new JLabel("Number of Cells");
				lblNumberOfCells.setBounds(116, 77, 102, 16);
				sCreatorFrame.getContentPane().add(lblNumberOfCells);
				
				JLabel label_3 = new JLabel("");
				label_3.setBounds(376, 18, 0, 0);
				sCreatorFrame.getContentPane().add(label_3);
				
						JComboBox comboCellBox = new JComboBox();
						comboCellBox.setBounds(254, 76, 64, 21);
						comboCellBox
								.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
						sCreatorFrame.getContentPane().add(comboCellBox);
						
						comboCellBox.addItemListener(new ItemListener() {
							public void itemStateChanged(ItemEvent itemEvent) {
								int state = itemEvent.getStateChange();
								ItemSelectable is = itemEvent.getItemSelectable();
								numButtons = Integer.parseInt(selectedString(is).toString());
								System.out.println("Selected: " + selectedString(is));
							}
						});
				JLabel lblNumberOfButtons = new JLabel("Number of Buttons");
				lblNumberOfButtons.setBounds(116, 111, 119, 16);
				sCreatorFrame.getContentPane().add(lblNumberOfButtons);
						lblNumberOfCells.setLabelFor(comboCellBox);
						JComboBox comboButtonBox = new JComboBox();
						comboButtonBox.setBounds(254, 105, 64, 27);
						comboButtonBox.setBackground(new Color(238, 238, 238));
						
								comboButtonBox
										.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6" }));
								sCreatorFrame.getContentPane().add(comboButtonBox);
								
										comboButtonBox.addItemListener(new ItemListener() {
											public void itemStateChanged(ItemEvent itemEvent) {
												int state = itemEvent.getStateChange();
												ItemSelectable is = itemEvent.getItemSelectable();
												numCells = Integer.parseInt(selectedString(is).toString());
												System.out.println("Selected: " + selectedString(is));
											}
										});
						
						JLabel label_4 = new JLabel("");
						label_4.setBounds(212, 50, 0, 0);
						sCreatorFrame.getContentPane().add(label_4);
				
						JLabel lblScenarioTitle = new JLabel("Scenario Title");
						lblScenarioTitle.setBounds(116, 140, 85, 16);
						sCreatorFrame.getContentPane().add(lblScenarioTitle);
				
				JLabel label_5 = new JLabel("");
				label_5.setBounds(307, 50, 0, 0);
				sCreatorFrame.getContentPane().add(label_5);
		
				titleTextField = new JTextField();
				titleTextField.setBounds(246, 135, 130, 26);
				sCreatorFrame.getContentPane().add(titleTextField);
				titleTextField.setColumns(10);
		
		JLabel label_6 = new JLabel("");
		label_6.setBounds(447, 50, 0, 0);
		sCreatorFrame.getContentPane().add(label_6);
		
		JLabel lblAddAudioFile = new JLabel("Add Audio File");
		lblAddAudioFile.setBounds(73, 223, 92, 16);
		sCreatorFrame.getContentPane().add(lblAddAudioFile);
		
		JLabel label_7 = new JLabel("");
		label_7.setBounds(160, 83, 0, 0);
		sCreatorFrame.getContentPane().add(label_7);
		
		audioFileTextField = new JTextField();
		audioFileTextField.setBounds(175, 218, 130, 26);
		audioFileTextField.setColumns(10);
		sCreatorFrame.getContentPane().add(audioFileTextField);
		
		JLabel label_8 = new JLabel("");
		label_8.setBounds(300, 83, 0, 0);
		sCreatorFrame.getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("");
		label_9.setBounds(305, 83, 0, 0);
		sCreatorFrame.getContentPane().add(label_9);
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.setBounds(320, 217, 88, 29);
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.setCurrentDirectory(new java.io.File("./FactoryScenarios/AudioFiles"));
				fc.setDialogTitle("Please Choose File to Open");
				fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				if (fc.showOpenDialog(btnBrowse) == JFileChooser.APPROVE_OPTION) {
					audioFileTextField.setText(fc.getSelectedFile().getName().toString());
				}
			}
		});
		sCreatorFrame.getContentPane().add(btnBrowse);
		
		JLabel label_10 = new JLabel("");
		label_10.setBounds(403, 83, 0, 0);
		sCreatorFrame.getContentPane().add(label_10);
		
		JPanel panel = new JPanel();
		panel.setBounds(47, 251, 362, 39);
		panel.setBackground(UIManager.getColor("CheckBox.background"));
		sCreatorFrame.getContentPane().add(panel);
		
		JButton btnRecordAudio = new JButton("Record Audio");
		btnRecordAudio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RecorderFrame rf = new RecorderFrame();
				rf.displayRecorder();
			}
		});
		panel.add(btnRecordAudio);
		
		JButton btnStopRecording = new JButton("Stop Recording");
		panel.add(btnStopRecording);
		
		JButton btnSave = new JButton("Save");
		panel.add(btnSave);
		
		JLabel label_11 = new JLabel("");
		label_11.setBounds(404, 122, 0, 0);
		sCreatorFrame.getContentPane().add(label_11);
		
		JLabel label_12 = new JLabel("");
		label_12.setBounds(409, 122, 0, 0);
		sCreatorFrame.getContentPane().add(label_12);
		
		JLabel label_13 = new JLabel("");
		label_13.setBounds(414, 122, 0, 0);
		sCreatorFrame.getContentPane().add(label_13);
		
		JLabel label_14 = new JLabel("");
		label_14.setBounds(419, 122, 0, 0);
		sCreatorFrame.getContentPane().add(label_14);
		
		JLabel label_15 = new JLabel("");
		label_15.setBounds(424, 122, 0, 0);
		sCreatorFrame.getContentPane().add(label_15);
		
		JLabel label_16 = new JLabel("");
		label_16.setBounds(429, 122, 0, 0);
		sCreatorFrame.getContentPane().add(label_16);
		
				JButton btnSaveAndCreate = new JButton("Save and Create ScenarioFile");
				btnSaveAndCreate.setBounds(21, 355, 222, 29);
				btnSaveAndCreate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ArrayList<Card> cards =  new ArrayList<Card>();
						Card temp = new Card(1, "Card 1", "");
						cards.add(temp);
						AuthoringViewer aw = new AuthoringViewer(1, comboButtonBox.getSelectedIndex()+1, cards, "Hi", "Bye");
						sCreatorFrame.dispose();
					}
				});
				
				btnSaveAndCreate.setForeground(Color.BLACK);
				btnSaveAndCreate.setContentAreaFilled(false);
				btnSaveAndCreate.setOpaque(true);
				btnSaveAndCreate.setBackground(UIManager.getColor("CheckBox.background"));
				sCreatorFrame.getContentPane().add(btnSaveAndCreate);
		
		JLabel label_17 = new JLabel("");
		label_17.setBounds(251, 161, 0, 0);
		sCreatorFrame.getContentPane().add(label_17);
		
		JLabel label_18 = new JLabel("");
		label_18.setBounds(256, 161, 0, 0);
		sCreatorFrame.getContentPane().add(label_18);
		
		JLabel label_19 = new JLabel("");
		label_19.setBounds(261, 161, 0, 0);
		sCreatorFrame.getContentPane().add(label_19);
		
				JButton btnExitWithoutSaving = new JButton("Exit Without Saving");
				btnExitWithoutSaving.setBounds(263, 355, 166, 29);
				btnExitWithoutSaving.setForeground(Color.BLACK);
				btnExitWithoutSaving.setContentAreaFilled(false);
				btnExitWithoutSaving.setOpaque(true);
				btnExitWithoutSaving.setBackground(UIManager.getColor("CheckBox.background"));
				btnExitWithoutSaving.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//sCreatorFrame.setVisible(false);
						int option = JOptionPane.showConfirmDialog(null, "Do want to EXIT? \nNo changes will be saved!!!", "Confirm", JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE);
						if (option == JOptionPane.YES_OPTION) {
							sCreatorFrame.dispose();
						} else {
							// do nothing
							JOptionPane.getRootFrame().dispose();  

						}
					}
				});
				sCreatorFrame.getContentPane().add(btnExitWithoutSaving);
		
		JLabel label_20 = new JLabel("");
		label_20.setBounds(437, 161, 0, 0);
		sCreatorFrame.getContentPane().add(label_20);
		
		JLabel label_21 = new JLabel("");
		label_21.setBounds(442, 161, 0, 0);
		sCreatorFrame.getContentPane().add(label_21);

	}

	static private String selectedString(ItemSelectable is) {
		Object selected[] = is.getSelectedObjects();
		return ((selected.length == 0) ? "null" : (String) selected[0]);
	}

	private class confirmClose extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			int option = JOptionPane.showConfirmDialog(null, "Do want to EXIT? \nNo changes will be saved!!!", "Confirm", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			if (option == JOptionPane.YES_OPTION) {
				sCreatorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			} else {
				JOptionPane.getRootFrame().dispose();  
				// do nothing
			}
		}
	}
}
