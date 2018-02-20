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
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.Window;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.JTextField;
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

	
	private static final int BUFFER_SIZE = 4096;
	private ByteArrayOutputStream recordBytes;
	private TargetDataLine audioLine;
	private AudioFormat format;

	private boolean isRunning;

	/**
	 * Defines a default audio format used to record
	 */
	AudioFormat getAudioFormat() {
		float sampleRate = 44100;
		int sampleSizeInBits = 16;
		int channels = 2;
		boolean signed = true;
		boolean bigEndian = true;
		return new AudioFormat(sampleRate, sampleSizeInBits, channels, signed,
				bigEndian);
	}

	/**
	 * Start recording sound.
	 * @throws LineUnavailableException if the system does not support the specified 
	 * audio format nor open the audio data line.
	 */
	public void start() throws LineUnavailableException {
		format = getAudioFormat();
		DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);

		// checks if system supports the data line
		if (!AudioSystem.isLineSupported(info)) {
			throw new LineUnavailableException(
					"The system does not support the specified format.");
		}

		audioLine = AudioSystem.getTargetDataLine(format);

		audioLine.open(format);
		audioLine.start();

		byte[] buffer = new byte[BUFFER_SIZE];
		int bytesRead = 0;

		recordBytes = new ByteArrayOutputStream();
		isRunning = true;

		while (isRunning) {
			bytesRead = audioLine.read(buffer, 0, buffer.length);
			recordBytes.write(buffer, 0, bytesRead);
		}
	}

	/**
	 * Stop recording sound.
	 * @throws IOException if any I/O error occurs.
	 */
	public void stop() throws IOException {
		isRunning = false;
		
		if (audioLine != null) {
			audioLine.drain();
			audioLine.close();
		}
	}

	/**
	 * Save recorded sound data into a .wav file format.
	 * @param wavFile The file to be saved.
	 * @throws IOException if any I/O error occurs.
	 * @throws UnsupportedAudioFileException 
	 */
	public void save(File wavFile) throws IOException {
		byte[] audioData = recordBytes.toByteArray();
		ByteArrayInputStream bais = new ByteArrayInputStream(audioData);
		AudioInputStream audioInputStream = new AudioInputStream(bais, format,
				audioData.length / format.getFrameSize());		
		AudioSystem.write(audioInputStream, AudioFileFormat.Type.WAVE, wavFile);

		audioInputStream.close();
		recordBytes.close();
	}

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
			displayInstructions.setText(
					"Press \"RECORD\" to start recording\r\nPress \"SAVE\" to save audio as \".wav\" file\r\nYou may choose to \"DISCARD\" recording ");
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

	private class confirmClose extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			int option = JOptionPane.showConfirmDialog(null, "Do want to EXIT? \nNo changes will be saved!!!",
					"Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (option == JOptionPane.YES_OPTION) {
				// System.exit( 0 );
				// dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			} else {
				// do nothing
			}
		}
	}
}