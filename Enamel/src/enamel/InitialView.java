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
import javax.management.JMException;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import enamel.ToyAuthoring;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
//import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;
import enamel.ScenarioParser;

/**
 * 
 * @author Jeremy, Nisha, Tyler
 * 
 *         GUI class to display initial view of Authoring app. This class allows
 *         user to create new scenario, edit saved scenario, test saved scenario.
 *         Accessibility features are implemented.
 *
 */
@SuppressWarnings({ "unused", "static-access" })
public class InitialView {

	private JFrame frmAuthoringApp;
	private Thread starterCodeThread;// thread to run visual player

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
		frmAuthoringApp.getContentPane().setBackground(UIManager.getColor("CheckBox.background"));
		frmAuthoringApp.setBounds(150, 150, 275, 375);
		//frmAuthoringApp.setResizable(false); // fix window dimensions
		
		//*****************************************************************************
		Dimension thisScreen = Toolkit.getDefaultToolkit().getScreenSize();
		
		// find the dimensions of the screen and a dimension that is derive one
		// quarter of the size
		Dimension targetSize = new Dimension((int) thisScreen.getWidth() / 4, (int) thisScreen.getHeight() / 4);
		frmAuthoringApp.setPreferredSize(targetSize);
		frmAuthoringApp.setSize((int) thisScreen.getWidth() / 2, (int) thisScreen.getHeight() / 2);
		//.frmAutho(this.getClass().getName());
		this.frmAuthoringApp.setLocationByPlatform(true);
		//*****************************************************************************
		// this methods asks the window manager to position the frame in the
		// centre of the screen
		this.frmAuthoringApp.setLocationRelativeTo(null);
		
		frmAuthoringApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAuthoringApp.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("AUTHORING APP");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(379, 60, 185, 70);
		frmAuthoringApp.getContentPane().add(lblNewLabel);

		JButton newButton = new JButton("New");
		newButton.getAccessibleContext().setAccessibleDescription("Creates a new file");
		newAction(newButton);
		newButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		// newButton.setBackground(Color.WHITE);
		// newButton.setContentAreaFilled(false);
		// newButton.setOpaque(true);

		newButton.setForeground(new Color(0, 0, 205));
		newButton.setToolTipText("Create New Scenario");
		newButton.setBounds(389, 139, 165, 50);
		frmAuthoringApp.getContentPane().add(newButton);

		JButton editButton = new JButton("Edit");
		editButton.getAccessibleContext().setAccessibleDescription("Loads and allows you to edit a file");
		editButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		editButton.setForeground(new Color(255, 140, 0));
		// editButton.setContentAreaFilled(false);
		// editButton.setOpaque(true);
		// editButton.setBackground(Color.WHITE);
		editButton.setToolTipText("Edit a Scenario");
		editAction(editButton);
		editButton.setBounds(389, 200, 165, 50);
		frmAuthoringApp.getContentPane().add(editButton);

		JButton testButton = new JButton("Test");
		testButton.getAccessibleContext().setAccessibleDescription("Tests a file");
		testButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		// testButton.setBackground(Color.WHITE);
		// testButton.setContentAreaFilled(false);
		// testButton.setOpaque(true);
		testButton.setForeground(new Color(0, 128, 128));
		testButton.setToolTipText("Test a Scenario");
		testAction(testButton);

		testButton.setBounds(389, 259, 165, 50);
		frmAuthoringApp.getContentPane().add(testButton);

		JButton exitButton = new JButton("Exit");
		exitButton.getAccessibleContext().setAccessibleDescription("Closes the application");
		exitButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		exitButton.setForeground(new Color(139, 0, 0));
		// exitButton.setContentAreaFilled(false);
		// exitButton.setOpaque(true);
		// exitButton.setBackground(Color.WHITE);
		exitButton.setToolTipText("Exit the App");
		exitButton.setBounds(389, 319, 165, 50);
		frmAuthoringApp.getContentPane().add(exitButton);
		// frmAuthoringApp.setFocusTraversalPolicy(new FocusTraversalOnArray(new
		// Component[]{frmAuthoringApp.getContentPane(), lblNewLabel, newButton,
		// btnEdit, testButton, exitButton}));
		exitAction(exitButton);
		/*//frmAuthoringApp.setFocusable(true);
		Action exAction = new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				testExtract(exitButton);
			}
		};
		exitButton.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK), "exiting");
		exitButton.getActionMap().put("exiting", exAction);
		//exitButton.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
*/	
		System.out.println(Thread.currentThread().getName().toString());

	}

	private void newAction(JButton newButton) {
		newButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScenarioForm sf = new ScenarioForm();
				sf.displayForm();
			}
		});
	}

	private void editAction(JButton editButton) {
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(new Runnable() {
					public void run() {
						JButton open = new JButton();

						JFileChooser fc = new JFileChooser();
						FileFilter txtFilter = new FileFilter() {
							@Override
							public String getDescription() {
								return "Text file (*.TXT)";
							}

							@Override
							public boolean accept(File file) {
								if (file.isDirectory()) {
									return true;
								} else {
									return file.getName().toLowerCase().endsWith(".txt");
								}
							}
						};

						fc.setFileFilter(txtFilter);
						fc.setAcceptAllFileFilterUsed(false);
						fc.setCurrentDirectory(new java.io.File("./FactoryScenarios"));
						fc.setDialogTitle("Please Choose File to Open");
						fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
						if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
							FileToCardsParser f = new FileToCardsParser();
							f.setFile(fc.getSelectedFile().getPath());
							AuthoringViewer av = new AuthoringViewer(f.getCells(), f.getButtons(), f.getCards(),
									f.getInitial(), f.getEnding()); // new
																	// ActionListener()
																	// {public
																	// void
																	// actionPerformed(ActionEvent
																	// e2) {}});
							av.setPromptText(f.getCards().get(0).getText());
							av.setCurrCellPins(f.getCards().get(0).getCells().get(0));
							av.setButtonText(f.getCards().get(0).getButtonList().get(0).getText());
							av.setCardList();
							av.setEdited();
						}

					}
				}).start();
			}
		});
	}

	private void testAction(JButton testButton) {
		testButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ToyAuthoring ta = new ToyAuthoring();
				// ta.launchToyAuthoring();
				// ta.main(null);

				// frame.dispose();
				/*
				 * JButton open = new JButton();
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

				// Running Starter code as separate thread
				starterCodeThread = new Thread("Starter Code Thread") {
					public void run() {
						JButton open = new JButton();

						JFileChooser fc = new JFileChooser();
						FileFilter txtFilter = new FileFilter() {
							@Override
							public String getDescription() {
								return "Text file (*.TXT)";
							}

							@Override
							public boolean accept(File file) {
								if (file.isDirectory()) {
									return true;
								} else {
									return file.getName().toLowerCase().endsWith(".txt");
								}
							}
						};

						fc.setFileFilter(txtFilter);
						fc.setCurrentDirectory(new java.io.File("./FactoryScenarios"));
						fc.setDialogTitle("Please Choose File to Open");
						fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
						if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
							ScenarioParser s = new ScenarioParser(true);
							s.setScenarioFile(fc.getSelectedFile().getPath());
						}
					}
				};// ).start();
				starterCodeThread.start();
			}

		});
		System.out.println(Thread.currentThread().getName().toString());
	}

	private void exitAction(JButton exitButton) {
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAuthoringApp.setVisible(false);
				frmAuthoringApp.dispose();
				System.exit(0);
			}
		});
	}
}
