package enamel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComponent;
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
import java.util.Set;
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
import java.awt.GridLayout;

/**
 *
 * @author Jeremy, Nisha, Tyler
 *
 *         GUI class to display initial view of Authoring app. This class allows
 *         user to create new scenario, edit saved scenario, test saved
 *         scenario. Accessibility features are implemented.
 *
 */
@SuppressWarnings({ "unused", "static-access", "serial" })
public class InitialView {

	private boolean ctrlPressed = false;
	private JFrame frmAuthoringApp;
	private Thread starterCodeThread;// thread to run visual player
	private JButton exitButton;

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
		frmAuthoringApp.setBounds(150, 150, 975, 575);
		// frmAuthoringApp.setResizable(false); // fix window dimensions

		// *****************************************************************************
		Dimension thisScreen = Toolkit.getDefaultToolkit().getScreenSize();

		// find the dimensions of the screen and a dimension that is derive one
		// quarter of the size
		// Dimension targetSize = new Dimension((int) thisScreen.getWidth() / 4, (int)
		// thisScreen.getHeight() / 4);
		// frmAuthoringApp.setPreferredSize(targetSize);
		frmAuthoringApp.setSize((int) thisScreen.getWidth() / 2, (int) thisScreen.getHeight() / 2);
		// .frmAutho(this.getClass().getName());
		this.frmAuthoringApp.setLocationByPlatform(true);
		// *****************************************************************************
		// this methods asks the window manager to position the frame in the
		// centre of the screen
		this.frmAuthoringApp.setLocationRelativeTo(null);

		frmAuthoringApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAuthoringApp.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblNewLabel = new JLabel("AUTHORING APP");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lblNewLabel.setForeground(Color.BLACK);
		frmAuthoringApp.getContentPane().add(lblNewLabel);

		JButton newButton = new JButton("New");
		newButton.getAccessibleContext().setAccessibleDescription("Creates a new file");
		
		JLabel label = new JLabel("");
		frmAuthoringApp.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		frmAuthoringApp.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		frmAuthoringApp.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("");
		frmAuthoringApp.getContentPane().add(label_3);
		newAction(newButton);
		newButton.setFont(new Font("Tahoma", Font.BOLD, 16));

		// newButton.getActionMap().put(key, buttonAction);
		// newButton.setBackground(Color.WHITE);
		// newButton.setContentAreaFilled(false);
		// newButton.setOpaque(true);

		newButton.setForeground(new Color(0, 0, 205));
		newButton.setToolTipText("Create New Scenario");
		frmAuthoringApp.getContentPane().add(newButton);

		JButton editButton = new JButton("Edit");
		editButton.getAccessibleContext().setAccessibleDescription("Loads and allows you to edit a file");
		editButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		editButton.setForeground(new Color(255, 140, 0));
		// editButton.setContentAreaFilled(false);
		// editButton.setOpaque(true);
		// editButton.setBackground(Color.WHITE);

		editAction(editButton);
		editButton.setToolTipText("Edit a Scenario");
		frmAuthoringApp.getContentPane().add(editButton);

		JButton testButton = new JButton("Test");
		testButton.getAccessibleContext().setAccessibleDescription("Tests a file");
		testButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		// testButton.setBackground(Color.WHITE);
		// testButton.setContentAreaFilled(false);
		// testButton.setOpaque(true);
		testButton.setForeground(new Color(0, 128, 128));

		testAction(testButton);
		testButton.setToolTipText("Test a Scenario");
		frmAuthoringApp.getContentPane().add(testButton);

		exitButton = new JButton("Exit");
		exitButton.getAccessibleContext().setAccessibleDescription("Closes the application");
		exitButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		exitButton.setForeground(new Color(139, 0, 0));
		frmAuthoringApp.getContentPane().add(exitButton);
		// frmAuthoringApp.setFocusTraversalPolicy(new FocusTraversalOnArray(new
		// Component[]{frmAuthoringApp.getContentPane(), lblNewLabel, newButton,
		// btnEdit, testButton, exitButton}));
		exitAction(exitButton);
		exitButton.setToolTipText("Exit the App");
		/*
		 * //frmAuthoringApp.setFocusable(true); Action exAction = new AbstractAction()
		 * {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { // TODO Auto-generated
		 * method stub testExtract(exitButton); } };
		 * exitButton.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
		 * ActionEvent.CTRL_MASK), "exiting"); exitButton.getActionMap().put("exiting",
		 * exAction); //exitButton.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
		 * ActionEvent.CTRL_MASK));
		 */
		// System.out.println(Thread.currentThread().getName().toString());
		/*
		 * if( Thread.getAllStackTraces().containsKey(starterCodeThread)==true){
		 * //Thread c = Thread.getAllStackTraces().containsValue(starterCodeThread);
		 * System.out.println(""+
		 * Thread.getAllStackTraces().get(starterCodeThread).toString()); }
		 */
		// Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
		// Walk up all the way to the root thread group

	}

	private void newAction(JButton newButton) {
		Action buttonAction = new AbstractAction("New") {

			@Override
			public void actionPerformed(ActionEvent e) {
				ScenarioForm sf = new ScenarioForm();
				sf.displayForm();
			}
		};
		newButton.setAction(buttonAction);
		newButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK), "New");
		newButton.getActionMap().put("New", buttonAction);
	}

	private void editAction(JButton editButton) {

		Action buttonAction = new AbstractAction("Edit") {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Thread(new Runnable() {
					public void run() {
						JButton open = new JButton();
						JFileChooser fc = new JFileChooser();
						makeFileChooser(fc, open);
						if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
							FileToCardsParser f = new FileToCardsParser();
							f.setFile(fc.getSelectedFile().getPath());
							AuthoringViewer av = new AuthoringViewer(f.getCells(), f.getButtons(), f.getCards(),
									f.getInitial(), f.getEnding()); // newActionListener(){public void
							// actionPerformed(ActionEvente2) {}});
							av.setPromptText(f.getCards().get(0).getText());
							av.setCurrCellPins(f.getCards().get(0).getCells().get(0));
							av.setButtonText(f.getCards().get(0).getButtonList().get(0).getText());
							av.setCardList();
							av.setEdited();
						}
					}

				}).start();
			}
		};
		editButton.setAction(buttonAction);
		editButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK), "Edit");
		editButton.getActionMap().put("Edit", buttonAction);
	}

	private void testAction(JButton testButton) {

		Action buttonAction = new AbstractAction("Test") {

			@Override
			public void actionPerformed(ActionEvent e) {
				starterCodeThread = new Thread("Starter Code Thread") {
					public void run() {
						JButton open = new JButton();
						JFileChooser fc = new JFileChooser();
						makeFileChooser(fc, open);
						if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
							ScenarioParser s = new ScenarioParser(true);
							s.setScenarioFile(fc.getSelectedFile().getPath());
						}
					}
				};// ).start();
				starterCodeThread.start();
				ThreadGroup currentGroup = Thread.currentThread().getThreadGroup();
				int noThreads = currentGroup.activeCount();
				Thread[] lstThreads = new Thread[noThreads];
				currentGroup.enumerate(lstThreads);

				for (int i = 0; i < noThreads; i++)
					System.out.println("Thread No:" + i + " = " + lstThreads[i].getName());
			}

		};
		// System.out.println(Thread.currentThread().getName().toString());
		/*
		 * ThreadGroup rootGroup = Thread.currentThread().getThreadGroup(); ThreadGroup
		 * parent; while ((parent = rootGroup.getParent()) != null) { rootGroup =
		 * parent; listThreads(rootGroup, ""); }
		 */
		testButton.setAction(buttonAction);
		testButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK), "Test");
		testButton.getActionMap().put("Test", buttonAction);
	}

	private void exitAction(JButton exitButton) {
		Action buttonAction = new AbstractAction("Exit") {

			@Override
			public void actionPerformed(ActionEvent e) {
				frmAuthoringApp.setVisible(false);
				frmAuthoringApp.dispose();
				System.exit(0);
			}
		};
		exitButton.setAction(buttonAction);
		exitButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK), "Exit");
		exitButton.getActionMap().put("Exit", buttonAction);
	}

	private void makeFileChooser(JFileChooser fc, JButton open) {
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

	}

	// List all threads and recursively list all subgroup
	public static void listThreads(ThreadGroup group, String indent) {
		System.out.println(indent + "Group[" + group.getName() + ":" + group.getClass() + "]");
		int nt = group.activeCount();
		Thread[] threads = new Thread[nt * 2 + 10]; // nt is not accurate
		nt = group.enumerate(threads, false);

		// List every thread in the group
		for (int i = 0; i < nt; i++) {
			Thread t = threads[i];
			System.out.println(indent + "  Thread[" + t.getName() + ":" + t.getClass() + "]");
		}

		// Recursively list all subgroups
		int ng = group.activeGroupCount();
		ThreadGroup[] groups = new ThreadGroup[ng * 2 + 10];
		ng = group.enumerate(groups, false);

		for (int i = 0; i < ng; i++) {
			listThreads(groups[i], indent + "  ");
		}
	}
}
