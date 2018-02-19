package audioRecorder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;

public class RecorderFrame {
	private JFrame recorderFrame;

	private JPanel contentPane;
	private JTextField textField;

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
		recorderFrame = new JFrame();
		recorderFrame.setResizable(false);
		recorderFrame.setTitle("Audio Recorder");
		recorderFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		recorderFrame.setBounds(100, 100, 773, 224);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		recorderFrame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		recorderFrame.addWindowListener(new confirmClose()); // pop up before
		// exit

		JTextArea txtrPressrecordTo = new JTextArea();
		txtrPressrecordTo.setEditable(false);
		txtrPressrecordTo.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txtrPressrecordTo.setBounds(10, 5, 747, 120);
		txtrPressrecordTo.setText(
				" -     Press \"RECORD NEW\" to start recording\r\n -     Press \"STOP & SAVE\" to save audio as \".wav\" file\r\n -     \"TIMER\" indicates the record time\r\n -     You may choose to \"DISCARD\" recording ");
		contentPane.add(txtrPressrecordTo);

		JButton recordNewButton = new JButton("RECORD NEW");
		recordNewButton.setForeground(Color.BLUE);
		recordNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		recordNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		recordNewButton.setBounds(27, 138, 137, 46);
		contentPane.add(recordNewButton);

		JButton stopRecordingButton = new JButton("STOP & SAVE");
		stopRecordingButton.setForeground(Color.RED);
		stopRecordingButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		stopRecordingButton.setBounds(179, 138, 137, 46);
		contentPane.add(stopRecordingButton);

		JLabel lblTimer = new JLabel("TIMER:");
		lblTimer.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTimer.setBounds(342, 140, 70, 44);
		contentPane.add(lblTimer);

		textField = new JTextField();
		textField.setForeground(Color.BLUE);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setText("00.00.00");
		textField.setEditable(false);
		textField.setBounds(416, 138, 150, 46);
		contentPane.add(textField);
		textField.setColumns(10);
	}
	private class confirmClose extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			int option = JOptionPane.showConfirmDialog(null, "Do want to EXIT? \nNo changes will be saved!!!", "Confirm", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			if (option == JOptionPane.YES_OPTION) {
				// System.exit( 0 );
				recorderFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			} else {
				// do nothing
			}
		}
	}
}
