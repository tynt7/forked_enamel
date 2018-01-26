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

public class InitialView {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InitialView window = new InitialView();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 175, 275);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);;
		
		JLabel lblNewLabel = new JLabel("AUTHORING APP");
		lblNewLabel.setForeground(new Color(0, 0, 205));
		lblNewLabel.setBounds(28, 35, 112, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JButton newButton = new JButton("New");
		newButton.setBackground(new Color(255, 69, 0));
		newButton.setForeground(new Color(248, 248, 255));
		newButton.setToolTipText("Create New Scenario");
		newButton.setBounds(45, 90, 75, 25);
		frame.getContentPane().add(newButton);
		newButton.setAlignmentY(20);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setForeground(new Color(248, 248, 255));
		btnEdit.setBackground(new Color(218, 165, 32));
		btnEdit.setToolTipText("Edit a Scenario");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEdit.setBounds(45, 120, 75, 25);
		frame.getContentPane().add(btnEdit);
		
		JButton testButton = new JButton("Test");
		testButton.setBackground(new Color(0, 128, 0));
		testButton.setForeground(new Color(248, 248, 255));
		testButton.setToolTipText("Test a Scenario");
		testButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*frame.dispose();
				JButton open = new JButton();

				JFileChooser fc = new JFileChooser();
				fc.setCurrentDirectory(new java.io.File("./FactoryScenarios"));
				fc.setDialogTitle("Please Choose File to Open");
				fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
					
				}
				ScenarioParser s = new ScenarioParser(true);
				s.setScenarioFile(fc.getSelectedFile().getPath());*/
				//ToyAuthoring.runFileChhoser();
				/*ScenarioParser s = new ScenarioParser(true);
				s.setScenarioFile("FactoryScenarios/Scenario_" + 1 + ".txt");*/			
			}
		});
		testButton.setBounds(45, 150, 75, 25);
		frame.getContentPane().add(testButton);
		
		JButton exitButton = new JButton("Exit");
		exitButton.setForeground(new Color(248, 248, 255));
		exitButton.setBackground(new Color(178, 34, 34));
		exitButton.setToolTipText("Exit the App");
		exitButton.setBounds(45, 180, 75, 25);
		frame.getContentPane().add(exitButton);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			    frame.dispose();
				System.exit(0);
			}
		});
	}
}
