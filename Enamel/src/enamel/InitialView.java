package enamel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import enamel.ToyAuthoring;
import java.awt.Color;
import java.awt.Font;
//import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class InitialView {

	private JFrame frmAuthoringApp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InitialView window = new InitialView();
					window.frmAuthoringApp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InitialView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAuthoringApp = new JFrame();
		frmAuthoringApp.setTitle("Authoring App");
		frmAuthoringApp.setBackground(new Color(240, 240, 240));
		frmAuthoringApp.getContentPane().setBackground(Color.WHITE);
		frmAuthoringApp.setBounds(150, 150, 275, 375);
		frmAuthoringApp.setResizable(false); // fix window dimensions

		frmAuthoringApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAuthoringApp.getContentPane().setLayout(null);
		;

		JLabel lblNewLabel = new JLabel("AUTHORING APP");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lblNewLabel.setForeground(new Color(0, 0, 205));
		lblNewLabel.setBounds(45, 11, 185, 70);
		frmAuthoringApp.getContentPane().add(lblNewLabel);

		JButton newButton = new JButton("New");
		newButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScenarioForm sf = new ScenarioForm();
				sf.displayForm();
			}
		});
		newButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		newButton.setBackground(new Color(255, 69, 0));
		newButton.setForeground(new Color(248, 248, 255));
		newButton.setToolTipText("Create New Scenario");
		newButton.setBounds(85, 90, 85, 50);
		frmAuthoringApp.getContentPane().add(newButton);

		JButton btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEdit.setForeground(new Color(248, 248, 255));
		btnEdit.setBackground(new Color(218, 165, 32));
		btnEdit.setToolTipText("Edit a Scenario");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEdit.setBounds(85, 150, 85, 50);
		frmAuthoringApp.getContentPane().add(btnEdit);

		JButton testButton = new JButton("Test");
		testButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		testButton.setBackground(new Color(0, 128, 0));
		testButton.setForeground(new Color(248, 248, 255));
		testButton.setToolTipText("Test a Scenario");
		testButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ToyAuthoring ta = new ToyAuthoring();
				// ta.launchToyAuthoring();
				// ta.main(null);
				/*
				 * frame.dispose(); JButton open = new JButton();
				 * 
				 * JFileChooser fc = new JFileChooser();
				 * fc.setCurrentDirectory(new
				 * java.io.File("./FactoryScenarios"));
				 * fc.setDialogTitle("Please Choose File to Open");
				 * fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				 * if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
				 * 
				 * } ScenarioParser s = new ScenarioParser(true);
				 * s.setScenarioFile(fc.getSelectedFile().getPath());
				 */
				// ToyAuthoring.runFileChhoser();
				/*
				 * ScenarioParser s = new ScenarioParser(true);
				 * s.setScenarioFile("FactoryScenarios/Scenario_" + 1 + ".txt");
				 */
			}
		});
		testButton.setBounds(85, 210, 85, 50);
		frmAuthoringApp.getContentPane().add(testButton);

		JButton exitButton = new JButton("Exit");
		exitButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		exitButton.setForeground(new Color(248, 248, 255));
		exitButton.setBackground(new Color(178, 34, 34));
		exitButton.setToolTipText("Exit the App");
		exitButton.setBounds(85, 270, 85, 50);
		frmAuthoringApp.getContentPane().add(exitButton);
		// frmAuthoringApp.setFocusTraversalPolicy(new FocusTraversalOnArray(new
		// Component[]{frmAuthoringApp.getContentPane(), lblNewLabel, newButton,
		// btnEdit, testButton, exitButton}));
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAuthoringApp.setVisible(false);
				frmAuthoringApp.dispose();
				System.exit(0);
			}
		});
	}
}
