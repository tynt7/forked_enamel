package audioRecorder;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;


import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.Window;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Recorder extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton recordButton;
	private JButton stopButton;
	private JButton saveButton;
	private JButton cancelButton;
	
	private String saveFilePath;
	private JTextArea displayInstructions;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Recorder dialog = new Recorder();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Recorder() {
		setBounds(100, 100, 429, 151);
		getContentPane().setLayout(new BorderLayout());
		FlowLayout fl_contentPanel = new FlowLayout();
		contentPanel.setLayout(fl_contentPanel);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			displayInstructions = new JTextArea();
			displayInstructions.setEnabled(false);
			displayInstructions.setTabSize(10);
			displayInstructions.setEditable(false);
			displayInstructions.setWrapStyleWord(true);
			displayInstructions.setText("Press \"RECORD\" to start recording\r\nPress \"SAVE\" to save audio as \".wav\" file\r\nYou may choose to \"DISCARD\" recording ");
			contentPanel.add(displayInstructions);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				recordButton = new JButton("RECORD");
				recordButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					}
				});
			}
			{
				stopButton = new JButton("STOP");
				getRootPane().setDefaultButton(stopButton);
			}
			{
				cancelButton = new JButton("DISCARD");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						System.exit(0);
					}
				});
				{
					saveButton = new JButton("SAVE");
				}
			}
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			buttonPane.add(recordButton);
			buttonPane.add(stopButton);
			buttonPane.add(saveButton);
			buttonPane.add(cancelButton);
		}
	}
	
	/**
	 * Save the recorded sound into a WAV file.
	 */
	private void saveFile() {
		JFileChooser fileChooser = new JFileChooser();
		FileFilter wavFilter = new FileFilter() {
			@Override
			public String getDescription() {
				return "Sound file (*.WAV)";
			}

			@Override
			public boolean accept(File file) {
				if (file.isDirectory()) {
					return true;
				} else {
					return file.getName().toLowerCase().endsWith(".wav");
				}
			}
		};

		fileChooser.setFileFilter(wavFilter);
		fileChooser.setAcceptAllFileFilterUsed(false);

		int userChoice = fileChooser.showSaveDialog(this);
		if (userChoice == JFileChooser.APPROVE_OPTION) {
			saveFilePath = fileChooser.getSelectedFile().getAbsolutePath();
			if (!saveFilePath.toLowerCase().endsWith(".wav")) {
				saveFilePath += ".wav";
			}

			File wavFile = new File(saveFilePath);

		}
	}
}
