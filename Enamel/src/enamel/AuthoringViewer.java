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
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import java.awt.GridBagConstraints;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.Insets;
import java.awt.ItemSelectable;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.JPanel;
import javax.swing.JEditorPane;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.lang.Object;

@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
public class AuthoringViewer {

	private JFrame aViewFrame;
	private int numCells = 1;
	private int numButtons = 1;
	private JTextField txtCardName;
	private JTextField txtAudiofilenamemp;
	private JTextField textField;
	private JEditorPane editorPane;
	private JRadioButton pOne;
	private JRadioButton pTwo;
	private JRadioButton pThree;
	private JRadioButton pFour;
	private JRadioButton pFive;
	private JRadioButton pSix;
	private JRadioButton pSeven;
	private JRadioButton pEight;
	private JEditorPane buttonEditor;
	private JList list;
	private DefaultListModel<String> listModel;
	private static String testPins;

	private int currButton;
	private int currCell;
	private int currCard;
	private ArrayList<Card> cards;
	private String initialPrompt;
	private String endingPrompt;
	private String path;
	// non zero

	/**
	 * Create the application.
	 */
	public AuthoringViewer(int numCells, int numButtons, ArrayList<Card> cards, String initialPrompt,
			String endingPrompt) {
		this.numButtons = numButtons;
		this.initialPrompt = initialPrompt;
		this.endingPrompt = endingPrompt;
		this.numCells = numCells;
		this.cards = new ArrayList<Card>(cards);
		this.path = "";
		initialize();
		this.currButton = 0;
		this.currCell = 0;
		this.currCard = 0;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		aViewFrame = new JFrame();
		aViewFrame.getContentPane().setBackground(UIManager.getColor("CheckBox.background"));
		aViewFrame.getContentPane().setLayout(null);

		JLabel lblCurrcard = new JLabel("1/" + this.numCells);
		lblCurrcard.setBounds(148, 10, 55, 16);
		aViewFrame.getContentPane().add(lblCurrcard);

		JLabel lblPrompt = new JLabel("PROMPT");
		lblPrompt.setBounds(250, 10, 61, 16);
		aViewFrame.getContentPane().add(lblPrompt);

		JLabel lblOrder = new JLabel("ORDER");
		lblOrder.setBounds(750, 10, 61, 16);
		aViewFrame.getContentPane().add(lblOrder);

		txtCardName = new JTextField();
		txtCardName.setText("Card Name");
		txtCardName.setBounds(6, 5, 130, 26);
		aViewFrame.getContentPane().add(txtCardName);
		txtCardName.setColumns(10);

		editorPane = new JEditorPane();
		JScrollPane promptPane = new JScrollPane(editorPane);
		promptPane.setBounds(250, 30, 478, 128);
		aViewFrame.getContentPane().add(promptPane);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(250, 320, 561, 65);
		aViewFrame.getContentPane().add(buttonPanel);
		buttonPanel.setLayout(null);

		JLabel label = new JLabel("");
		label.setBounds(53, 19, 0, 0);
		buttonPanel.add(label);

		// determine how many buttons to display
		if (this.numButtons >= 1) {
			JButton button = new JButton("1");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showButtonText(0);
				}
			});
			button.setBounds(20, 20, 80, 30);
			buttonPanel.add(button);
		}
		if (this.numButtons >= 2) {
			JButton button_1 = new JButton("2");
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showButtonText(1);
				}
			});
			button_1.setBounds(110, 20, 80, 30);
			buttonPanel.add(button_1);
		}
		if (this.numButtons >= 3) {
			JButton button_2 = new JButton("3");
			button_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showButtonText(2);
				}
			});
			button_2.setBounds(200, 20, 75, 30);
			buttonPanel.add(button_2);
		}
		if (this.numButtons >= 4) {
			JButton button_3 = new JButton("4");
			button_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showButtonText(3);
				}
			});
			button_3.setBounds(290, 20, 75, 30);
			buttonPanel.add(button_3);
		}
		if (this.numButtons >= 5) {
			JButton button_4 = new JButton("5");
			button_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showButtonText(4);
				}
			});
			button_4.setBounds(380, 20, 75, 30);
			buttonPanel.add(button_4);
		}
		if (this.numButtons >= 6) {
			JButton button_5 = new JButton("6");
			button_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showButtonText(5);
				}
			});
			button_5.setBounds(470, 20, 75, 30);
			buttonPanel.add(button_5);
		}

		JLabel lblButtons = new JLabel("BUTTONS");
		lblButtons.setBounds(250, 300, 61, 16);
		aViewFrame.getContentPane().add(lblButtons);

		JLabel lblAudio = new JLabel("AUDIO");
		lblAudio.setBounds(250, 200, 61, 16);
		aViewFrame.getContentPane().add(lblAudio);

		txtAudiofilenamemp = new JTextField();
		txtAudiofilenamemp.setText("AudioFileName.mp3");
		txtAudiofilenamemp.setBounds(250, 220, 209, 26);
		aViewFrame.getContentPane().add(txtAudiofilenamemp);
		txtAudiofilenamemp.setColumns(10);

		JPanel cellPanel = new JPanel();
		cellPanel.setBounds(70, 38, 82, 105);
		aViewFrame.getContentPane().add(cellPanel);
		cellPanel.setLayout(null);

		pOne = new JRadioButton("");
		pOne.setBounds(6, 6, 28, 23);
		cellPanel.add(pOne);

		pFour = new JRadioButton("");
		pFour.setBounds(46, 6, 28, 23);
		cellPanel.add(pFour);

		pTwo = new JRadioButton("");
		pTwo.setBounds(6, 41, 28, 23);
		cellPanel.add(pTwo);

		pFive = new JRadioButton("");
		pFive.setBounds(46, 41, 28, 23);
		cellPanel.add(pFive);

		pThree = new JRadioButton("");
		pThree.setBounds(6, 76, 28, 23);
		cellPanel.add(pThree);

		pSix = new JRadioButton("");
		pSix.setBounds(46, 76, 28, 23);
		cellPanel.add(pSix);
		
		pSeven = new JRadioButton("");
		pSeven.setBounds(6, 111, 28, 23);
		cellPanel.add(pSeven);
		
		pEight = new JRadioButton("");
		pEight.setBounds(46, 76, 28, 23);
		cellPanel.add(pEight);

		textField = new JTextField();
		textField.setBounds(73, 155, 130, 26);
		aViewFrame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblLetter = new JLabel("Letter:");
		lblLetter.setBounds(20, 160, 55, 16);
		aViewFrame.getContentPane().add(lblLetter);

		JButton btnAudio = new JButton("Audio");
		btnAudio.setBounds(823, 319, 117, 29);
		aViewFrame.getContentPane().add(btnAudio);

		// Change the state of pin
		JButton btnRaisePins = new JButton("Raise Pins");
		btnRaisePins.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputValue = JOptionPane.showInputDialog("Please input which pins to raise");
				boolean checkNumber = true;
				for (int i = 0; i < inputValue.length(); i++) {
					System.out.println(i);
					if (inputValue.charAt(i) != '0' && inputValue.charAt(i) != '1') {
						System.out.println("hi");
						checkNumber = false;
					}
				}
				System.out.println(inputValue.length() + " " + inputValue);
				if (inputValue.length() == 8 && checkNumber) {
					setButtonText(buttonEditor.getText() + "\n/Pins on " + (currButton + 1) + ": " + inputValue);
				} else {
					JOptionPane.showMessageDialog(null,
							"Please enter 8 1's or 0's corresponding to the pins you want to raise", "Alert",
							JOptionPane.ERROR_MESSAGE);
				}

			}

		});
		btnRaisePins.setBounds(823, 356, 117, 29);
		aViewFrame.getContentPane().add(btnRaisePins);

		// exit the editor window
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "Do want to EXIT? \nNo changes will be saved!!!",
						"Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (option == JOptionPane.YES_OPTION) {
					aViewFrame.dispose();
				} else {
					// do nothing
				}
			}
		});
		btnExit.setBounds(20, 525, 75, 50);
		aViewFrame.getContentPane().add(btnExit);

		// save the current card and write it to a file
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton save = new JButton();
				JFileChooser fc = new JFileChooser();
				fc.setCurrentDirectory(new java.io.File("./FactoryScenarios"));
				fc.setDialogTitle("Please Save The File");
				fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				if (fc.showSaveDialog(save) == JFileChooser.APPROVE_OPTION) {
					System.out.println(fc.getSelectedFile().getPath());
					path = fc.getSelectedFile().getPath();
					updateButton();
					updatePrompt();
					CardsToFileParser a = new CardsToFileParser(cards, numButtons, numCells, initialPrompt,
							endingPrompt);
					a.createBody();
					ScenarioWriter sW = new ScenarioWriter(path);
					try {
						sW.write(a.getText());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		btnSave.setBounds(100, 525, 75, 50);
		aViewFrame.getContentPane().add(btnSave);

		// test running the scenario currently being worked on
		JButton btnTest = new JButton("Test");
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (path.equals("")) {
					JOptionPane.showMessageDialog(null, "Please save first", "Alert", JOptionPane.ERROR_MESSAGE);
				} else {
					updateButton();
					updatePrompt();
					CardsToFileParser a = new CardsToFileParser(cards, numButtons, numCells, initialPrompt,
							endingPrompt);
					a.createBody();
					ScenarioWriter sW = new ScenarioWriter(path);
					try {
						sW.write(a.getText());
						new Thread(new Runnable() {
							public void run() {
								ScenarioParser s = new ScenarioParser(true);
								s.setScenarioFile(path);
							}
						}).start();
					} catch (IOException e1) {
						System.out.println("failed to print");
					}
				}

			}
		});
		btnTest.setBounds(180, 525, 75, 50);
		aViewFrame.getContentPane().add(btnTest);

		buttonEditor = new JEditorPane();

		JScrollPane buttonPane = new JScrollPane(buttonEditor);
		buttonPane.setBounds(250, 400, 561, 113);
		aViewFrame.getContentPane().add(buttonPane);

		JButton button_6 = new JButton("<");
		button_6.setBounds(20, 80, 38, 26);
		aViewFrame.getContentPane().add(button_6);

		JButton button_7 = new JButton(">");
		button_7.setBounds(164, 80, 39, 26);
		aViewFrame.getContentPane().add(button_7);

		listModel = new DefaultListModel();
		list = new JList(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(-1);
		list.setBounds(750, 30, 234, 128);
		JScrollPane listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension(250, 80));
		listScroller.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
		aViewFrame.getContentPane().add(listScroller);
		aViewFrame.getContentPane().add(list);

		JButton btnR = new JButton("R");
		btnR.setBounds(458, 224, 35, 20);
		aViewFrame.getContentPane().add(btnR);

		JButton btnI = new JButton("I");
		btnI.setBounds(493, 224, 35, 20);
		aViewFrame.getContentPane().add(btnI);

		JButton btnD = new JButton("D");
		btnD.setBounds(528, 224, 35, 20);
		aViewFrame.getContentPane().add(btnD);

		
		JButton btnNextCard = new JButton("Next Card");
		btnNextCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cards.size() > currCard+1) {
					nextCard();
				}
				else {
					Card temp = new Card(currCard+1, "" + (currCard+2), "");
					cards.add(temp);
					temp.getButtonList().add(new DataButton(0));
					temp.getCells().add(new BrailleCell());
					nextCard();
				}
			}
		});
		btnNextCard.setBounds(823, 525, 117, 29);
		aViewFrame.getContentPane().add(btnNextCard);
		
		JButton btnPreviousCard = new JButton("Previous Card");
		btnPreviousCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currCard == 0) {
					//add at front?
				}
				else {
					prevCard();
				}
			}
		});
		btnPreviousCard.setBounds(694, 525, 117, 29);
		aViewFrame.getContentPane().add(btnPreviousCard);
		
		aViewFrame.setResizable(false);
		aViewFrame.setBackground(new Color(255, 255, 255));
		aViewFrame.setTitle("AuthoringApp view");
		aViewFrame.setBounds(100, 100, 1000, 612);
		aViewFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		aViewFrame.addWindowListener(new confirmClose());

		aViewFrame.setVisible(true);
	}

	private class confirmClose extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			int option = JOptionPane.showConfirmDialog(null, "Do want to EXIT? \nNo changes will be saved!!!",
					"Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (option == JOptionPane.YES_OPTION) {
				aViewFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			} else {
				// do nothing
			}
		}
	}

	public void setPromptText(String text) {
		editorPane.setText(text);
	}

	public void setCurrCellPins(BrailleCell cell) {
		pOne.setSelected(cell.getPinState(0));
		pTwo.setSelected(cell.getPinState(1));
		pThree.setSelected(cell.getPinState(2));
		pFour.setSelected(cell.getPinState(3));
		pFive.setSelected(cell.getPinState(4));
		pSix.setSelected(cell.getPinState(5));
	}

	public void setButtonText(String text) {
		buttonEditor.setText(text);
	}

	public void setCardList() {
		for (Card cards : this.cards) {
			listModel.addElement(cards.getName());
		}
	}

	public void showButtonText(int buttonNum) { // ButtonNum 0-5
		if (currButton != buttonNum) {
			try {
				String replace = cards.get(currCard).getButtonList().get(buttonNum).getText();
				cards.get(currCard).getButtonList().get(currButton).setText(buttonEditor.getText());
				currButton = buttonNum;
				this.setButtonText(replace);
			} catch (Exception e) {
				int size = cards.get(currCard).getButtonList().size();
				while (size <= buttonNum) {
					System.out.println(size);
					cards.get(currCard).getButtonList().add(new DataButton(size));
					size = cards.get(currCard).getButtonList().size();
				}
				currButton = buttonNum;
				this.setButtonText("");
			}
		}
	}

	public void updateButton() {
		cards.get(currCard).getButtonList().get(currButton).setText(buttonEditor.getText());
	}

	public void updatePrompt() {
		cards.get(currCard).setText(editorPane.getText());
	}
	
	public void updateCell() {
		BrailleCell temp = new BrailleCell();
		String s = "";
		s += pOne.isSelected() ? "1" : "0";
		s += pTwo.isSelected() ? "1" : "0";
		s += pThree.isSelected() ? "1" : "0";
		s += pFour.isSelected() ? "1" : "0";
		s += pFive.isSelected() ? "1" : "0";
		s += pSix.isSelected() ? "1" : "0";
		cards.get(currCard).getCells().set(currCell, temp);
	}
	
	public void showPrompt() {
		setPromptText(cards.get(currCard).getText());
	}
	
	public void nextCard() {
		updateButton();
		updatePrompt();
		setCurrCellPins(cards.get(currCard).getCells().get(currCell));
		currCard++;
		currButton = 0;
		currCell = 0;
		this.setButtonText(cards.get(currCard).getButtonList().get(0).getText());
		
		
		showPrompt();
		setCurrCellPins(new BrailleCell());
		
	}
	
	public void prevCard() {
		updateButton();
		updatePrompt();
		setCurrCellPins(cards.get(currCard).getCells().get(currCell));
		currCard--;
		currButton = 0;
		currCell = 0;
		this.setButtonText(cards.get(currCard).getButtonList().get(0).getText());
		showPrompt();
		setCurrCellPins(new BrailleCell());
	}
}
