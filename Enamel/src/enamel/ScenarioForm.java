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

//import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
//form
//fixed colorss
public class ScenarioForm {

	private JFrame sCreatorFrame;
	private int numCells = 1; // assuming 1 selected by default. i.e. always non
								// zero
	private int numButtons = 1; // assuming 1 selected by default. i.e. always
	private JTextField titleTextField;
	private JTextField audioFileTextField;
	private JTextField questionTextField;
	private JTextField optionsTextField;
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
	private void initialize() {
		sCreatorFrame = new JFrame();
		sCreatorFrame.getContentPane().setBackground(new Color(240, 240, 240));
		sCreatorFrame.setResizable(false);
		sCreatorFrame.setBackground(new Color(255, 255, 255));
		sCreatorFrame.setTitle("Scenario Creator");
		sCreatorFrame.setBounds(100, 100, 504, 612);
		sCreatorFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);// DISPOSE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 10, 10, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 5, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		sCreatorFrame.getContentPane().setLayout(gridBagLayout);
		sCreatorFrame.addWindowListener(new confirmClose()); // pop up before
		// exit

		JLabel lblNewLabel = new JLabel("Create a Scenario for your Students");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 1;
		sCreatorFrame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNumberOfCells = new JLabel("Number of Cells");
		GridBagConstraints gbc_lblNumberOfCells = new GridBagConstraints();
		gbc_lblNumberOfCells.anchor = GridBagConstraints.WEST;
		gbc_lblNumberOfCells.ipadx = 16;
		gbc_lblNumberOfCells.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumberOfCells.gridx = 2;
		gbc_lblNumberOfCells.gridy = 3;
		sCreatorFrame.getContentPane().add(lblNumberOfCells, gbc_lblNumberOfCells);

		JComboBox buttonComboBox = new JComboBox();
		// String[] input = new String[] {"1", "2", "3", "4", "5", "6", "7",
		// "8", "9", "10"};
		buttonComboBox
				.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
		GridBagConstraints gbc_buttonComboBox = new GridBagConstraints();
		gbc_buttonComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_buttonComboBox.ipadx = 30;
		gbc_buttonComboBox.gridwidth = 2;
		gbc_buttonComboBox.fill = GridBagConstraints.VERTICAL;
		gbc_buttonComboBox.gridx = 4;
		gbc_buttonComboBox.gridy = 3;
		sCreatorFrame.getContentPane().add(buttonComboBox, gbc_buttonComboBox);
		// int temp = buttonComboBox.getSelectedIndex();
		// numButtons = Integer.parseInt(input[temp]);
		// buttonComboBox.addItemListener(aListener);;
		buttonComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent itemEvent) {
				int state = itemEvent.getStateChange();
				// System.out.println((state == ItemEvent.SELECTED) ? "Selected"
				// : "Deselected");
				// System.out.println("Item: " + itemEvent.getItem());
				ItemSelectable is = itemEvent.getItemSelectable();
				numButtons = Integer.parseInt(selectedString(is).toString());
				System.out.println("Selected: " + selectedString(is));
			}
		});
		JLabel lblNumberOfButtons = new JLabel("Number of Buttons");
		// buttonComboBox.addItemListener(itemListener);
		lblNumberOfButtons.setLabelFor(buttonComboBox);

		GridBagConstraints gbc_lblNumberOfButtons = new GridBagConstraints();
		gbc_lblNumberOfButtons.anchor = GridBagConstraints.WEST;
		gbc_lblNumberOfButtons.ipadx = 16;
		gbc_lblNumberOfButtons.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumberOfButtons.gridx = 2;
		gbc_lblNumberOfButtons.gridy = 4;
		sCreatorFrame.getContentPane().add(lblNumberOfButtons, gbc_lblNumberOfButtons);
		JComboBox cellComboBox = new JComboBox();
		lblNumberOfCells.setLabelFor(cellComboBox);

		cellComboBox
				.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
		GridBagConstraints gbc_cellComboBox = new GridBagConstraints();
		gbc_cellComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_cellComboBox.ipadx = 30;
		gbc_cellComboBox.gridwidth = 2;
		gbc_cellComboBox.fill = GridBagConstraints.VERTICAL;
		gbc_cellComboBox.gridx = 4;
		gbc_cellComboBox.gridy = 4;
		sCreatorFrame.getContentPane().add(cellComboBox, gbc_cellComboBox);

		cellComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent itemEvent) {
				int state = itemEvent.getStateChange();
				// System.out.println((state == ItemEvent.SELECTED) ? "Selected"
				// : "Deselected");
				// System.out.println("Item: " + itemEvent.getItem());
				ItemSelectable is = itemEvent.getItemSelectable();
				numCells = Integer.parseInt(selectedString(is).toString());
				System.out.println("Selected: " + selectedString(is));
			}
		});

		JLabel lblScenarioTitle = new JLabel("Scenario Title");
		GridBagConstraints gbc_lblScenarioTitle = new GridBagConstraints();
		gbc_lblScenarioTitle.anchor = GridBagConstraints.WEST;
		gbc_lblScenarioTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblScenarioTitle.gridx = 2;
		gbc_lblScenarioTitle.gridy = 5;
		sCreatorFrame.getContentPane().add(lblScenarioTitle, gbc_lblScenarioTitle);

		titleTextField = new JTextField();
		GridBagConstraints gbc_titleTextField = new GridBagConstraints();
		gbc_titleTextField.gridwidth = 2;
		gbc_titleTextField.insets = new Insets(0, 0, 5, 5);
		gbc_titleTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_titleTextField.gridx = 4;
		gbc_titleTextField.gridy = 5;
		sCreatorFrame.getContentPane().add(titleTextField, gbc_titleTextField);
		titleTextField.setColumns(10);

		JButton btnSaveAndCreate = new JButton("Save and Create ScenarioFile");
		btnSaveAndCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JLabel lblDescription = new JLabel("Task Description");
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.anchor = GridBagConstraints.WEST;
		gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescription.gridx = 2;
		gbc_lblDescription.gridy = 6;
		sCreatorFrame.getContentPane().add(lblDescription, gbc_lblDescription);
		
		JLabel lblQuestion = new JLabel("Question:");
		GridBagConstraints gbc_lblQuestion = new GridBagConstraints();
		gbc_lblQuestion.anchor = GridBagConstraints.WEST;
		gbc_lblQuestion.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuestion.gridx = 2;
		gbc_lblQuestion.gridy = 8;
		sCreatorFrame.getContentPane().add(lblQuestion, gbc_lblQuestion);
		
		questionTextField = new JTextField();
		GridBagConstraints gbc_questionTextField = new GridBagConstraints();
		gbc_questionTextField.insets = new Insets(0, 0, 5, 5);
		gbc_questionTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_questionTextField.gridx = 4;
		gbc_questionTextField.gridy = 8;
		sCreatorFrame.getContentPane().add(questionTextField, gbc_questionTextField);
		questionTextField.setColumns(10);
		
		JLabel lblOptions = new JLabel("Options:");
		GridBagConstraints gbc_lblOptions = new GridBagConstraints();
		gbc_lblOptions.anchor = GridBagConstraints.WEST;
		gbc_lblOptions.insets = new Insets(0, 0, 5, 5);
		gbc_lblOptions.gridx = 2;
		gbc_lblOptions.gridy = 9;
		sCreatorFrame.getContentPane().add(lblOptions, gbc_lblOptions);
		
		optionsTextField = new JTextField();
		GridBagConstraints gbc_optionsTextField = new GridBagConstraints();
		gbc_optionsTextField.insets = new Insets(0, 0, 5, 5);
		gbc_optionsTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_optionsTextField.gridx = 4;
		gbc_optionsTextField.gridy = 9;
		sCreatorFrame.getContentPane().add(optionsTextField, gbc_optionsTextField);
		optionsTextField.setColumns(10);
		
		JLabel lblAddAudioFile = new JLabel("Add Audio File");
		GridBagConstraints gbc_lblAddAudioFile = new GridBagConstraints();
		gbc_lblAddAudioFile.anchor = GridBagConstraints.WEST;
		gbc_lblAddAudioFile.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddAudioFile.gridx = 2;
		gbc_lblAddAudioFile.gridy = 11;
		sCreatorFrame.getContentPane().add(lblAddAudioFile, gbc_lblAddAudioFile);
		
		audioFileTextField = new JTextField();
		audioFileTextField.setColumns(10);
		GridBagConstraints gbc_audioFileTextField = new GridBagConstraints();
		gbc_audioFileTextField.gridwidth = 2;
		gbc_audioFileTextField.insets = new Insets(0, 0, 5, 5);
		gbc_audioFileTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_audioFileTextField.gridx = 4;
		gbc_audioFileTextField.gridy = 11;
		sCreatorFrame.getContentPane().add(audioFileTextField, gbc_audioFileTextField);
		
		JButton btnBrowse = new JButton("Browse");
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
		GridBagConstraints gbc_btnBrowse = new GridBagConstraints();
		gbc_btnBrowse.insets = new Insets(0, 0, 5, 5);
		gbc_btnBrowse.gridx = 6;
		gbc_btnBrowse.gridy = 11;
		sCreatorFrame.getContentPane().add(btnBrowse, gbc_btnBrowse);
		
		btnSaveAndCreate.setForeground(new Color(255, 255, 255));
		btnSaveAndCreate.setContentAreaFilled(false);
        btnSaveAndCreate.setOpaque(true);
		btnSaveAndCreate.setBackground(new Color(154, 205, 50));
		GridBagConstraints gbc_btnSaveAndCreate = new GridBagConstraints();
		gbc_btnSaveAndCreate.insets = new Insets(0, 0, 5, 5);
		gbc_btnSaveAndCreate.gridx = 4;
		gbc_btnSaveAndCreate.gridy = 18;
		sCreatorFrame.getContentPane().add(btnSaveAndCreate, gbc_btnSaveAndCreate);

		JButton btnExitWithoutSaving = new JButton("Exit Without Saving");
		btnExitWithoutSaving.setForeground(new Color(255, 255, 255));
		btnExitWithoutSaving.setContentAreaFilled(false);
        btnExitWithoutSaving.setOpaque(true);
		btnExitWithoutSaving.setBackground(new Color(178, 34, 34));
		btnExitWithoutSaving.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// sCreatorFrame.setVisible(false);
				int option = JOptionPane.showConfirmDialog(null, "Do want to EXIT? \nNo changes will be saved!!!", "Confirm", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if (option == JOptionPane.YES_OPTION) {
					sCreatorFrame.dispose();
				} else {
					// do nothing
				}
			}
		});
		GridBagConstraints gbc_btnExitWithoutSaving = new GridBagConstraints();
		gbc_btnExitWithoutSaving.insets = new Insets(0, 0, 5, 5);
		gbc_btnExitWithoutSaving.gridx = 4;
		gbc_btnExitWithoutSaving.gridy = 19;
		sCreatorFrame.getContentPane().add(btnExitWithoutSaving, gbc_btnExitWithoutSaving);
		/*
		 * sCreatorFrame .setFocusTraversalPolicy(new FocusTraversalOnArray(new
		 * Component[] { sCreatorFrame.getContentPane(), lblNewLabel,
		 * lblNumberOfCells, buttonComboBox, lblNumberOfButtons, cellComboBox
		 * }));
		 */

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
				// System.exit( 0 );
				sCreatorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			} else {
				// do nothing
			}
		}
	}
}
