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

				JLabel lblNewLabel = new JLabel("Create a NEW Scenario for your Students");
				lblNewLabel.setBounds(91, 22, 285, 27);
				lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 15));
				sCreatorFrame.getContentPane().add(lblNewLabel);
		
				JLabel lblNumberOfCells = new JLabel("Number of Cells");
				lblNumberOfCells.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNumberOfCells.setBounds(33, 77, 102, 16);
				sCreatorFrame.getContentPane().add(lblNumberOfCells);
				
						JComboBox comboCellBox = new JComboBox();
						comboCellBox.setFont(new Font("Tahoma", Font.BOLD, 11));
						comboCellBox.setBounds(224, 76, 64, 21);
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
				lblNumberOfButtons.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNumberOfButtons.setBounds(33, 109, 119, 16);
				sCreatorFrame.getContentPane().add(lblNumberOfButtons);
						lblNumberOfCells.setLabelFor(comboCellBox);
						JComboBox comboButtonBox = new JComboBox();
						comboButtonBox.setFont(new Font("Tahoma", Font.BOLD, 11));
						comboButtonBox.setBounds(224, 108, 64, 21);
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
				
						JLabel lblScenarioTitle = new JLabel("Scenario Title");
						lblScenarioTitle.setFont(new Font("Tahoma", Font.BOLD, 12));
						lblScenarioTitle.setBounds(33, 142, 85, 16);
						sCreatorFrame.getContentPane().add(lblScenarioTitle);
		
				titleTextField = new JTextField();
				titleTextField.setFont(new Font("Tahoma", Font.PLAIN, 12));
				titleTextField.setBounds(224, 140, 130, 21);
				sCreatorFrame.getContentPane().add(titleTextField);
				titleTextField.setColumns(10);
		
		JLabel lblAddAudioFile = new JLabel("Add Audio File (Optional)");
		lblAddAudioFile.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAddAudioFile.setBounds(33, 177, 160, 16);
		sCreatorFrame.getContentPane().add(lblAddAudioFile);
		
		audioFileTextField = new JTextField();
		audioFileTextField.setBounds(224, 176, 119, 21);
		audioFileTextField.setColumns(10);
		sCreatorFrame.getContentPane().add(audioFileTextField);
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBrowse.setBounds(350, 176, 82, 21);
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
		
		JLabel lblS = new JLabel("Record and Save a New Audio \".wav\" File");
		lblS.setBounds(33, 212, 278, 19);
		sCreatorFrame.getContentPane().add(lblS);
		lblS.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnRecordAudio = new JButton("Record Audio");
		btnRecordAudio.setBounds(321, 210, 111, 21);
		sCreatorFrame.getContentPane().add(btnRecordAudio);
		btnRecordAudio.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRecordAudio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RecorderFrame rf = new RecorderFrame();
				rf.displayRecorder();
			}
		});
		
				JButton btnSaveAndCreate = new JButton("Save and Create Scenario File");
				btnSaveAndCreate.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnSaveAndCreate.setBounds(117, 303, 201, 29);
				btnSaveAndCreate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ArrayList<Card> cards =  new ArrayList<Card>();
						Card temp = new Card(1, "Card 1", "");
						cards.add(temp);
						cards.get(0).getCells().add(new BrailleCell());
						AuthoringViewer av = new AuthoringViewer(comboCellBox.getSelectedIndex()+1, comboButtonBox.getSelectedIndex()+1, cards, "Hi", "Bye");
						av.setCardList();
						sCreatorFrame.dispose();
					}
				});
				
				/*btnSaveAndCreate.setForeground(Color.BLACK);
				btnSaveAndCreate.setContentAreaFilled(false);
				btnSaveAndCreate.setOpaque(true);*/
				btnSaveAndCreate.setBackground(UIManager.getColor("CheckBox.background"));
				sCreatorFrame.getContentPane().add(btnSaveAndCreate);
		
				JButton btnExitWithoutSaving = new JButton("Exit Without Saving");
				btnExitWithoutSaving.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnExitWithoutSaving.setBounds(117, 343, 201, 29);
				/*btnExitWithoutSaving.setForeground(Color.BLACK);
				btnExitWithoutSaving.setContentAreaFilled(false);
				btnExitWithoutSaving.setOpaque(true);
				btnExitWithoutSaving.setBackground(UIManager.getColor("CheckBox.background"));*/
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
