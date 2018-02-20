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
import javax.swing.JCheckBox;

@SuppressWarnings({ "unused", "rawtypes" })
public class functionView {
	private JFrame funcFrame;
	private int numCells = 1;
	private int numButtons = 1;
	private BrailleCell cell;
	private boolean saveState;
	public static final String pins = "";
	// non zero

	/**
	 * This Window is still under construction
	 */

	/**
	 * Create the application.
	 */
	public functionView() {// BrailleCell cell2) {
		initialize();// cell2);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {// BrailleCell cell2) {
		// saveState = false;
		// cell = //cell2;
		funcFrame = new JFrame();
		funcFrame.getContentPane().setBackground(Color.GRAY);
		funcFrame.getContentPane().setLayout(null);

		JLabel lblPins = new JLabel("Pins:");
		lblPins.setBounds(20, 6, 61, 16);
		funcFrame.getContentPane().add(lblPins);

		JLabel lblNextCard = new JLabel("Next Card:");
		lblNextCard.setBounds(20, 110, 75, 16);
		funcFrame.getContentPane().add(lblNextCard);

		JList list = new JList();
		list.setBounds(20, 126, 260, 159);
		funcFrame.getContentPane().add(list);

		JPanel panel = new JPanel();
		panel.setBounds(30, 34, 241, 53);
		funcFrame.getContentPane().add(panel);
		panel.setLayout(null);

		JCheckBox pin1Box = new JCheckBox("");
		pin1Box.setBounds(6, 6, 28, 23);
		panel.add(pin1Box);

		JCheckBox pin2Box = new JCheckBox("");
		pin2Box.setBounds(46, 6, 28, 23);
		panel.add(pin2Box);

		JCheckBox pin3Box = new JCheckBox("");
		pin3Box.setBounds(86, 6, 28, 23);
		panel.add(pin3Box);

		JCheckBox pin4Box = new JCheckBox("");
		pin4Box.setBounds(127, 6, 28, 23);
		panel.add(pin4Box);

		JCheckBox pin5Box = new JCheckBox("");
		pin5Box.setBounds(168, 6, 28, 23);
		panel.add(pin5Box);

		JCheckBox pin6Box = new JCheckBox("");
		pin6Box.setBounds(209, 6, 28, 23);
		panel.add(pin6Box);

		JLabel label = new JLabel("1");
		label.setBounds(16, 30, 8, 16);
		panel.add(label);

		JLabel label_1 = new JLabel("2");
		label_1.setBounds(56, 30, 8, 16);
		panel.add(label_1);

		JLabel label_2 = new JLabel("3");
		label_2.setBounds(96, 28, 8, 16);
		panel.add(label_2);

		JLabel label_3 = new JLabel("4");
		label_3.setBounds(137, 28, 8, 16);
		panel.add(label_3);

		JLabel label_4 = new JLabel("5");
		label_4.setBounds(178, 28, 8, 16);
		panel.add(label_4);

		JLabel label_5 = new JLabel("6");
		label_5.setBounds(219, 28, 8, 16);
		panel.add(label_5);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveState = false;
				funcFrame.dispose();
			}
		});
		btnCancel.setBounds(20, 318, 117, 29);
		funcFrame.getContentPane().add(btnCancel);

		JButton btnSave = new JButton("Save");
		btnSave.setBounds(163, 318, 117, 29);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!saveState) {
					String pinsS = pin1Box.isSelected() ? "1" : "0";

					pinsS += pin2Box.isSelected() ? "1" : "0";
					pinsS += pin3Box.isSelected() ? "1" : "0";
					pinsS += pin4Box.isSelected() ? "1" : "0";
					pinsS += pin5Box.isSelected() ? "1" : "0";
					pinsS += pin6Box.isSelected() ? "1" : "0";
					pinsS += "00";
					System.out.println("pins" + pinsS);
					// setPins(pinsS);
					// cell.setPins(pins);
					pins.concat(pinsS);
					funcFrame.dispose();
					saveState = true;
					//AuthoringViewer.updatePins(pins);
				   }
			}
		});

		funcFrame.getContentPane().add(btnSave);
		funcFrame.setResizable(false);
		funcFrame.setBackground(new Color(255, 255, 255));
		funcFrame.setTitle("AuthoringApp view");
		funcFrame.setBounds(100, 100, 300, 400);
		funcFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		funcFrame.addWindowListener(new confirmClose());
		funcFrame.setVisible(true);
	}

	private class confirmClose extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			int option = JOptionPane.showConfirmDialog(null, "Do want to EXIT? \nNo changes will be saved!!!",
					"Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (option == JOptionPane.YES_OPTION) {
				// System.exit( 0 );
				funcFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			} else {
				// do nothing
			}
		}
	}

	public BrailleCell getCell() {
		return this.cell;
	}

	public boolean getSaveState() {
		return this.saveState;
	}

	public static String returnPins() {
		return pins;
	}
}
