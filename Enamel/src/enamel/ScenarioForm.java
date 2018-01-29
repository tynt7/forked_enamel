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
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import java.awt.GridBagConstraints;
import javax.swing.DefaultComboBoxModel;
import java.awt.Insets;
import java.awt.ItemSelectable;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class ScenarioForm {

	private JFrame sCreatorFrame;
	private int numCells = 1; //assuming 1 selected by default. i.e. always non zero
	private int numButtons = 1; //assuming 1 selected by default. i.e. always non zero

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
		sCreatorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		sCreatorFrame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Create a Scenario for your Students");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 0;
		sCreatorFrame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNumberOfCells = new JLabel("Number of Cells");
		GridBagConstraints gbc_lblNumberOfCells = new GridBagConstraints();
		gbc_lblNumberOfCells.ipadx = 16;
		gbc_lblNumberOfCells.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumberOfCells.gridx = 2;
		gbc_lblNumberOfCells.gridy = 2;
		sCreatorFrame.getContentPane().add(lblNumberOfCells, gbc_lblNumberOfCells);
		
		JComboBox buttonComboBox = new JComboBox();
		//String[] input = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		buttonComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		GridBagConstraints gbc_buttonComboBox = new GridBagConstraints();
		gbc_buttonComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_buttonComboBox.ipadx = 30;
		gbc_buttonComboBox.gridwidth = 10;
		gbc_buttonComboBox.fill = GridBagConstraints.VERTICAL;
		gbc_buttonComboBox.gridx = 4;
		gbc_buttonComboBox.gridy = 2;
		sCreatorFrame.getContentPane().add(buttonComboBox, gbc_buttonComboBox);
		JLabel lblNumberOfButtons = new JLabel("Number of Buttons");
		lblNumberOfButtons.setLabelFor(buttonComboBox);
		//int temp = buttonComboBox.getSelectedIndex();
		//numButtons = Integer.parseInt(input[temp]);
		//buttonComboBox.addItemListener(aListener);;
		buttonComboBox.addItemListener(new ItemListener() {
		      public void itemStateChanged(ItemEvent itemEvent) {
		        int state = itemEvent.getStateChange();
		        //System.out.println((state == ItemEvent.SELECTED) ? "Selected" : "Deselected");
		        //System.out.println("Item: " + itemEvent.getItem());
		        ItemSelectable is = itemEvent.getItemSelectable();
		        numButtons = Integer.parseInt(selectedString(is).toString());
		        System.out.println("Selected: " + selectedString(is));
		      }
		    });
		//buttonComboBox.addItemListener(itemListener);
		    
		GridBagConstraints gbc_lblNumberOfButtons = new GridBagConstraints();
		gbc_lblNumberOfButtons.ipadx = 16;
		gbc_lblNumberOfButtons.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumberOfButtons.gridx = 2;
		gbc_lblNumberOfButtons.gridy = 3;
		sCreatorFrame.getContentPane().add(lblNumberOfButtons, gbc_lblNumberOfButtons);
		JComboBox cellComboBox = new JComboBox();
		lblNumberOfCells.setLabelFor(cellComboBox);
		
		cellComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		GridBagConstraints gbc_cellComboBox = new GridBagConstraints();
		gbc_cellComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_cellComboBox.ipadx = 30;
		gbc_cellComboBox.gridwidth = 10;
		gbc_cellComboBox.fill = GridBagConstraints.VERTICAL;
		gbc_cellComboBox.gridx = 4;
		gbc_cellComboBox.gridy = 3;
		sCreatorFrame.getContentPane().add(cellComboBox, gbc_cellComboBox);
		cellComboBox.addItemListener(new ItemListener() {
		      public void itemStateChanged(ItemEvent itemEvent) {
		        int state = itemEvent.getStateChange();
		        //System.out.println((state == ItemEvent.SELECTED) ? "Selected" : "Deselected");
		        //System.out.println("Item: " + itemEvent.getItem());
		        ItemSelectable is = itemEvent.getItemSelectable();
		        numCells = Integer.parseInt(selectedString(is).toString());
		        System.out.println("Selected: " + selectedString(is));
		      }
		    });
		sCreatorFrame.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{sCreatorFrame.getContentPane(), lblNewLabel, lblNumberOfCells, buttonComboBox, lblNumberOfButtons, cellComboBox}));
	}
	
	static private String selectedString(ItemSelectable is) {
	    Object selected[] = is.getSelectedObjects();
	    return ((selected.length == 0) ? "null" : (String) selected[0]);
	  }
}
