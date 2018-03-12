package audioRecorder;

//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextArea;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import javax.swing.filechooser.FileFilter;
import java.io.IOException;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
//import javax.swing.SwingUtilities;

import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;

///////////////////////////////////////////////////////////////////////////////////////Save as

/**
 * 
 * @author Jeremy, Nisha, Tyler
 * 
 *         GUI class to implement Recording feature for Authoring app This class
 *         allows user record and save audio. User may discard the audio and
 *         play recently saved audio. Accessibility features are implemented.
 *
 */
public class RecorderFrame {
	// Fields
	private JFrame recorderFrame;

	private JPanel contentPane;
	private JTextField textField;
	JEditorPane txtrPressrecordTo;
	JButton recordNewButton;
	JButton stopRecordingButton;

	private Boolean isRecording;

	private static final int BUFFER_SIZE = 4096;
	private ByteArrayOutputStream recordBytes;
	private TargetDataLine audioLine;
	private AudioFormat format;

	private boolean isRunning;

	private String path;
	private JButton resetButton;
	private final JButton btnPlay = new JButton("PLAY");
	
	//Menu
	private JMenuItem mntmRecordNew;
	private JMenuItem mntmInstructions;
	private JMenu mnTools;
	private JMenuItem mntmPlay;
	private JMenuBar menuBar;
	private JMenu mntmHelp;
	private JMenuItem mntmSave;
	
	/**
	 * Launch the application.
	 */
	public static void displayRecorder() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecorderFrame frame = new RecorderFrame();
					frame.recorderFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RecorderFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// settings for the frame
		recorderFrame = new JFrame();
		recorderFrame.setResizable(false);
		recorderFrame.setTitle("Audio Recorder");
		recorderFrame.getAccessibleContext().setAccessibleDescription("Use this tool to record and save an audio file");
		recorderFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		recorderFrame.setBounds(100, 100, 774, 244);
		
		//Menu Bar
		menuBar = new JMenuBar();
		recorderFrame.setJMenuBar(menuBar);
		
		//Tools menu
		mnTools = new JMenu("Tools");
		menuBar.add(mnTools);
		
		// MenuItem Record
		mntmRecordNew = new JMenuItem("Record New");
		mnTools.add(mntmRecordNew);
		mntmRecordNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recordAudio();
			}
		});
		
		// Menu Item Save
		mntmSave = new JMenuItem("Save");
		mnTools.add(mntmSave);
		mntmSave.setEnabled(false);
		mntmSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				stopRecording();
			}
		});
		
		mntmPlay = new JMenuItem("Play");
		mnTools.add(mntmPlay);
		mntmSave.setEnabled(false);
		
		mntmHelp = new JMenu("Help");
		menuBar.add(mntmHelp);
		
		mntmInstructions = new JMenuItem("Instructions");
		mntmHelp.add(mntmInstructions);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		recorderFrame.setContentPane(contentPane);
		contentPane.setLayout(null);

		// Button for starting a new recording
		recordNewButton = new JButton("RECORD");
		recordNewButton.getAccessibleContext().setAccessibleDescription("Click to record a new audio");
		recordNewButton.setForeground(Color.BLUE);
		recordNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		recordNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recordAudio();
			}
		});
		recordNewButton.setBounds(20, 148, 125, 29);
		contentPane.add(recordNewButton);

		// Button for stopping and then saving the current recoding
		stopRecordingButton = new JButton("STOP & SAVE");
		stopRecordingButton.getAccessibleContext()
				.setAccessibleDescription("Click to stop recording and save audio file");
		stopRecordingButton.setEnabled(false);
		stopRecordingButton.setForeground(Color.RED);
		stopRecordingButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		stopRecordingButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				stopRecording();
			}
		});
		stopRecordingButton.setBounds(155, 148, 125, 29);
		contentPane.add(stopRecordingButton);

		// Label for record timer
		JLabel lblTimer = new JLabel("TIMER:");
		lblTimer.getAccessibleContext().setAccessibleDescription("Indicates whether the recorder is recording or not");
		lblTimer.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTimer.setBounds(290, 148, 54, 29);
		contentPane.add(lblTimer);

		// textField to display the record time
		textField = new JTextField();
		textField.getAccessibleContext().setAccessibleDescription("Recording or not");
		textField.setForeground(Color.BLUE);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setText("00.00.00");
		textField.setEditable(false);
		textField.setBounds(343, 148, 125, 29);
		contentPane.add(textField);
		textField.setColumns(10);

		// button for discarding current recording and resetting the recorder
		resetButton = new JButton("RESET");
		resetButton.getAccessibleContext().setAccessibleDescription("Click to Discard a Recording");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetRecorder();
				// playSound(path);
			}
		});
		resetButton.setForeground(new Color(220, 20, 60));
		resetButton.setEnabled(false);
		resetButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		resetButton.setBounds(478, 148, 125, 29);
		contentPane.add(resetButton);

		// button to play the recorded audio
		btnPlay.getAccessibleContext().setAccessibleDescription("Click to play recently saved audio");
		btnPlay.setBounds(619, 148, 125, 29);
		contentPane.add(btnPlay);
		btnPlay.setForeground(new Color(0, 100, 0));
		btnPlay.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPlay.setEnabled(false);
				
				
		
				// JTextArea for instructions
				txtrPressrecordTo = new JEditorPane();
				txtrPressrecordTo.setEditable(false);
				txtrPressrecordTo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
				txtrPressrecordTo.setBounds(109, 20, 592, 149);
				txtrPressrecordTo.setText("Welcome to \"Audio Recorder\". Below are the instructions to use it: \r\n -     Press \"RECORD NEW\" to start a new recording\r\n -     Press \"STOP & SAVE\" to save audio as \".wav\" file\r\n -     \"TIMER\" indicates that audio is being recorded\r\n\t- (record timer will be added in next build)\r\n -     You may choose to \"DISCARD\" recording \r\n -     You may play the recorded audio after you save it (you can not play a previously saved audio file yet)");
				contentPane.add(txtrPressrecordTo);
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				playSound(path);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane(txtrPressrecordTo);
		scrollPane.setBounds(20, 5, 719, 133);
		contentPane.add(scrollPane);

		if (textField.getText() == "00.00.00") {
			recorderFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		recorderFrame.addWindowListener(new confirmClose());
		// pop up before exit
	}

	/**
	 * Defines a default audio format used to record
	 * 
	 * @return AudioFormat
	 */
	public AudioFormat getAudioFormat() {
		float sampleRate = 44100;
		int sampleSizeInBits = 16;
		int channels = 2;
		boolean signed = true;
		boolean bigEndian = true;
		return new AudioFormat(sampleRate, sampleSizeInBits, channels, signed, bigEndian);
	}

	/*
	 * Record audio as a separate thread
	 */
	public void recordAudio() {
		Thread record = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				// set isRecording boolean to true
				isRecording = true;
				recordNewButton.setEnabled(false);//new button
				mntmRecordNew.setEnabled(false);//new menu
				textField.setText("Recording......");
				recordNewButton.setEnabled(false);
				stopRecordingButton.setEnabled(true);//save button
				mntmSave.setEnabled(true);//save menu
				resetButton.setEnabled(true);//reset button
				//reset menu <_-------------------------------------------------------------------------

				// while recording
				while (isRecording) {
					try {
						start();
					} catch (LineUnavailableException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		});
		record.start();
	}

	/**
	 * Start recording sound.
	 * 
	 * @throws LineUnavailableException
	 *             if the system does not support the specified audio format nor
	 *             open the audio data line.
	 */
	public void start() throws LineUnavailableException {
		format = getAudioFormat();
		DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);

		// checks if system supports the data line
		if (!AudioSystem.isLineSupported(info)) {
			throw new LineUnavailableException("The system does not support the specified format.");
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
	 * Stop recording and save the sound into a WAV file
	 */
	private void stopRecording() {
		isRecording = false;
		textField.setText("Recording Stopped");
		//recordNewButton.setEnabled(true);//-------------------------------------------------------------------------------
		// stopRecordingButton.setEnabled(false);
		try {
			stop();
			saveAudioFile();
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "Error", "Error stopping sound recording!", JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();
		}
	}

	/**
	 * Stop recording and reset recorder
	 */
	private void resetRecorder() {
		isRecording = false;
		textField.setText("00.00.00");
		
		recordNewButton.setEnabled(true);
		mntmRecordNew.setEnabled(true);
		
		stopRecordingButton.setEnabled(false);
		mntmSave.setEnabled(false);
		
		btnPlay.setEnabled(false);
		//mntmPlay.setEnabled(false);
		try {
			stop();
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "Error", "Error discarding sound recording!",
					JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();
		}
	}

	/**
	 * Stop recording sound.
	 * 
	 * @throws IOException
	 *             if any I/O error occurs.
	 */
	public void stop() throws IOException {
		isRunning = false;

		if (audioLine != null) {
			// audioLine.drain();
			audioLine.close();
			audioLine.drain();
		}
	}

	private void saveAudioFile() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new java.io.File("./FactoryScenarios/AudioFiles"));
		fileChooser.setDialogTitle("Save as");
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

		int userChoice = fileChooser.showSaveDialog(null);
		if (userChoice == JFileChooser.APPROVE_OPTION) {
			path = fileChooser.getSelectedFile().getAbsolutePath();
			if (!path.toLowerCase().endsWith(".wav")) {
				path += ".wav";
			}

			File wavFile = new File(path);

			try {
				save(wavFile);
				recordNewButton.setEnabled(true);
				mntmRecordNew.setEnabled(true);
				stopRecordingButton.setEnabled(false);
				mntmSave.setEnabled(false);
				JOptionPane.showMessageDialog(null, "Saved recorded sound to:\n" + path);
				btnPlay.setEnabled(true);
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "Error", "Error saving to sound file!", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}
		}
	}

	/**
	 * Save recorded sound data into a .wav file format.
	 * 
	 * @param wavFile
	 *            The file to be saved.
	 * @throws IOException
	 *             if any I/O error occurs.
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

	// Class with method to display confirmation dialog box when user tries to
	// close the JFrame
	private class confirmClose extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			if (!(textField.getText().contains("00.00.00"))) {
				int option = JOptionPane.showConfirmDialog(null, "Do you want to EXIT? \nNo changes will be saved!!!",
						"Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (option == JOptionPane.YES_OPTION) {
					// System.exit( 0 );
					recorderFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				} else {
					// do nothing
				}
			} else {
				// normal exit if no recording started
				recorderFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		}
	}

	/*
	 * This method corresponds to the /~sound: key phrase in the scenario file,
	 * and it plays the sound files where the argument is the name of the sound
	 * file.
	 */
	private void playSound(String sound) {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(new File(sound)));
			clip.start();
			// This while loop is to check if the audio file has played or not,
			// and if it has not then it will
			// continue to wait until it does.
			while (!clip.isRunning())
				Thread.sleep(10);
			while (clip.isRunning())
				Thread.sleep(10);
			clip.close();

		} catch (Exception e) {
			System.out.println("Exception error: " + e.toString()
					+ "Expected the name of the file (including extension) but instead got: " + sound
					+ "\n Perhaps you forgot to include the extension of the sound file with the name? Other "
					+ "possibilities include: \n Incorrect name of the file, the file not being in the same location "
					+ "as the project folder, or an attempt to play an unsupported sound file. (only .wav files"
					+ "are supported at this time)");
		}
	}
}
