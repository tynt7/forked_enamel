package enamel;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.UIManager;

import audioRecorder.RecorderFrame;

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
	private JEditorPane dtrpnEnterAPrompt;
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
		if (this.cards.get(0).getButtonList().isEmpty()) {
			this.cards.get(0).getButtonList().add(new DataButton(0));
		}
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
		aViewFrame.getContentPane().setBackground(Color.LIGHT_GRAY);
		aViewFrame.getContentPane().setLayout(null);

		JLabel lblCurrCell = new JLabel("1/" + this.numCells);
		lblCurrCell.setBounds(148, 10, 55, 16);
		aViewFrame.getContentPane().add(lblCurrCell);

		JLabel lblPrompt = new JLabel("PROMPT");
		lblPrompt.setBounds(250, 10, 61, 16);
		aViewFrame.getContentPane().add(lblPrompt);

		JLabel lblOrder = new JLabel("ORDER");
		lblOrder.setBounds(750, 10, 61, 16);
		aViewFrame.getContentPane().add(lblOrder);

		txtCardName = new JTextField();
		txtCardName.setToolTipText("Enter a name for the card");
		txtCardName.setText(cards.get(currCard).getName());
		txtCardName.setBounds(6, 5, 130, 26);
		aViewFrame.getContentPane().add(txtCardName);
		txtCardName.setColumns(10);

		dtrpnEnterAPrompt = new JEditorPane();
		dtrpnEnterAPrompt.setText("Enter a Prompt for this card");
		dtrpnEnterAPrompt.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				dtrpnEnterAPrompt.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
			}
		});
		JScrollPane promptPane = new JScrollPane(dtrpnEnterAPrompt);
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
		txtAudiofilenamemp.setToolTipText("Audio File Name");
		txtAudiofilenamemp.setBounds(250, 220, 209, 26);
		aViewFrame.getContentPane().add(txtAudiofilenamemp);
		txtAudiofilenamemp.setColumns(10);

		JPanel cellPanel = new JPanel();
		cellPanel.setBounds(70, 38, 82, 140);
		aViewFrame.getContentPane().add(cellPanel);
		cellPanel.setLayout(null);

		pOne = new JRadioButton("");
		pOne.setToolTipText("Pin One");
		pOne.setBounds(6, 6, 28, 23);
		cellPanel.add(pOne);

		pFour = new JRadioButton("");
		pFour.setToolTipText("Pin Two");
		pFour.setBounds(46, 6, 28, 23);
		cellPanel.add(pFour);

		pTwo = new JRadioButton("");
		pTwo.setToolTipText("Pin  Three");
		pTwo.setBounds(6, 41, 28, 23);
		cellPanel.add(pTwo);

		pFive = new JRadioButton("");
		pFive.setToolTipText("Pin  Four");
		pFive.setBounds(46, 41, 28, 23);
		cellPanel.add(pFive);

		pThree = new JRadioButton("");
		pThree.setToolTipText("Pin  Five");
		pThree.setBounds(6, 76, 28, 23);
		cellPanel.add(pThree);

		pSix = new JRadioButton("");
		pSix.setToolTipText("Pin  Six");
		pSix.setBounds(46, 76, 28, 23);
		cellPanel.add(pSix);

		pSeven = new JRadioButton("");
		pSeven.setToolTipText("Pin  Seven");
		pSeven.setBounds(6, 111, 28, 23);
		cellPanel.add(pSeven);

		pEight = new JRadioButton("");
		pEight.setToolTipText("Pin  Eight");
		pEight.setBounds(46, 111, 28, 23);
		cellPanel.add(pEight);

		// Under Construction
		// textField = new JTextField();
		// textField.setBounds(73, 185, 130, 26);
		// aViewFrame.getContentPane().add(textField);
		// textField.setColumns(10);
		//
		// JLabel lblLetter = new JLabel("Letter:");
		// lblLetter.setBounds(20, 185, 55, 16);
		// aViewFrame.getContentPane().add(lblLetter);

		JButton btnAudio = new JButton("Audio");
		btnAudio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.setCurrentDirectory(new java.io.File("./FactoryScenarios/AudioFiles"));
				fc.setDialogTitle("Please Choose File to Open");
				fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				if (fc.showOpenDialog(btnAudio) == JFileChooser.APPROVE_OPTION) {
					String temp = fc.getSelectedFile().getName().toString();

					if (temp.length() > 4) {
						if (temp.charAt(temp.length() - 4) != '.' || temp.charAt(temp.length() - 3) != 'w'
								|| temp.charAt(temp.length() - 2) != 'a' || temp.charAt(temp.length() - 1) != 'v') {
							JOptionPane.showMessageDialog(null, "Please select a .wav file", "Alert",
									JOptionPane.ERROR_MESSAGE);
						} else {
							setButtonText(buttonEditor.getText() + "\n/~sound:" + (temp));
							cards.get(currCard).getButtonList().get(currButton).setAudio(temp);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Please select a .wav file", "Alert",
								JOptionPane.ERROR_MESSAGE);
					}
					

				}
			}
		});
		btnAudio.setBounds(823, 319, 117, 29);
		aViewFrame.getContentPane().add(btnAudio);

		// Change the state of pin
		JButton btnRaisePins = new JButton("Raise Pins");
		btnRaisePins.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputValue = JOptionPane.showInputDialog("Please input which pins to raise");
				boolean checkNumber = true;
				if (inputValue != null) {
					for (int i = 0; i < inputValue.length(); i++) {
						System.out.println(i);
						if (inputValue.charAt(i) != '0' && inputValue.charAt(i) != '1') {
							System.out.println("hi");
							checkNumber = false;
						}
					}
					System.out.println(inputValue.length() + " " + inputValue);
					if (inputValue.length() == 8 && checkNumber) {
						setButtonText(buttonEditor.getText() + "\n/Pins on " + (currCell) + ": " + inputValue);
					} else {
						JOptionPane.showMessageDialog(null,
								"Please enter 8 1's or 0's corresponding to the pins you want to raise", "Alert",
								JOptionPane.ERROR_MESSAGE);
					}

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
		buttonEditor.setText("Enter a response for this button");
		buttonEditor.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				buttonEditor.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
			}
		});

		
		JScrollPane buttonPane = new JScrollPane(buttonEditor);
		buttonPane.setBounds(250, 400, 561, 113);
		aViewFrame.getContentPane().add(buttonPane);

		JButton button_6 = new JButton("<");
		button_6.setToolTipText("Left Cell Button");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currCell == 0) {
					JOptionPane.showMessageDialog(null, "You are already at the first cell", "Alert",
							JOptionPane.ERROR_MESSAGE);
				} else {
					updateCell();
					currCell--;
					setCurrCellPins(cards.get(currCard).getCells().get(currCell));
					lblCurrCell.setText("" + (currCell + 1) + "/" + numCells);
				}
			}
		});
		button_6.setBounds(6, 80, 52, 39);
		aViewFrame.getContentPane().add(button_6);

		JButton button_7 = new JButton(">");
		button_7.setToolTipText("Right Cell Button");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currCell + 1 == numCells) {
					JOptionPane.showMessageDialog(null, "You are already at the last cell", "Alert",
							JOptionPane.ERROR_MESSAGE);
				} else {
					if (cards.get(currCard).getCells().size() > currCell + 1) {
						updateCell();
						currCell++;
						setCurrCellPins(cards.get(currCard).getCells().get(currCell));
						lblCurrCell.setText("" + (currCell + 1) + "/" + numCells);
					} else {
						BrailleCell temp = new BrailleCell();
						cards.get(currCard).getCells().add(temp);
						System.out.println(cards.get(currCard).getCells().size());
						updateCell();
						currCell++;
						setCurrCellPins(cards.get(currCard).getCells().get(currCell));
						lblCurrCell.setText("" + (currCell + 1) + "/" + numCells);
					}
				}

			}
		});
		button_7.setBounds(164, 80, 52, 39);
		aViewFrame.getContentPane().add(button_7);

		listModel = new DefaultListModel();
		list = new JList(listModel);
		list.setToolTipText("Card Order List");
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(-1);
		JScrollPane listScroller = new JScrollPane(list);
		listScroller.setBounds(750, 30, 234, 128);
		listScroller.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
		aViewFrame.getContentPane().add(listScroller);

		JButton btnR = new JButton("R");
		btnR.setToolTipText("Record an Audio FIle");
		btnR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RecorderFrame rf = new RecorderFrame();
				rf.displayRecorder();
			}
		});
		btnR.setBounds(458, 224, 45, 20);
		aViewFrame.getContentPane().add(btnR);

		JButton btnI = new JButton("I");
		btnI.setToolTipText("Import an Audio File");
		btnI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.setCurrentDirectory(new java.io.File("./FactoryScenarios/AudioFiles"));
				fc.setDialogTitle("Please Choose File to Open");
				fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				if (fc.showOpenDialog(btnI) == JFileChooser.APPROVE_OPTION) {
					String temp = fc.getSelectedFile().getName().toString();
					txtAudiofilenamemp.setText(temp);
					cards.get(currCard).setSound(temp);
				}
			}
		});
		btnI.setBounds(506, 224, 45, 20);
		aViewFrame.getContentPane().add(btnI);

		JButton btnD = new JButton("D");
		btnD.setToolTipText("Delete the Selected Audio File");
		btnD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cards.get(currCard).setSound("");
				txtAudiofilenamemp.setText(null);
			}
		});
		btnD.setBounds(554, 224, 45, 20);
		aViewFrame.getContentPane().add(btnD);

		JButton btnCardUp = new JButton("Card Up");
		btnCardUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selected = list.getSelectedIndex();
				if (selected == 0) {
					JOptionPane.showMessageDialog(null, "This card is already at the top", "Alert",
							JOptionPane.ERROR_MESSAGE);
				} else {
					if (currCard == selected) {
						currCard--;
					} else if (currCard == selected - 1) {
						currCard++;
					}
					Card temp = cards.get(selected);
					cards.set(selected, cards.get(selected - 1));
					cards.set(selected - 1, temp);
					setCardList();

				}
			}
		});
		btnCardUp.setBounds(750, 165, 234, 20);
		aViewFrame.getContentPane().add(btnCardUp);

		JButton btnCardDown = new JButton("Card Down");
		btnCardDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selected = list.getSelectedIndex();
				if (selected == cards.size() - 1) {
					JOptionPane.showMessageDialog(null, "This card is already at the bottom", "Alert",
							JOptionPane.ERROR_MESSAGE);
				} else {
					if (currCard == selected) {
						currCard++;
					} else if (currCard == selected - 1) {
						currCard--;
					}
					Card temp = cards.get(selected);
					cards.set(selected, cards.get(selected + 1));
					cards.set(selected + 1, temp);
					setCardList();
				}
			}
		});
		btnCardDown.setBounds(750, 190, 234, 20);
		aViewFrame.getContentPane().add(btnCardDown);

		JButton btnNextCard = new JButton("Next Card");
		btnNextCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cards.size() > currCard + 1) {
					nextCard();
				} else {
					System.out.println(cards.size());
					Card temp = new Card(currCard + 1, "card" + (currCard + 2), "");
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
					JOptionPane.showMessageDialog(null, "You are already at the first card", "Alert",
							JOptionPane.ERROR_MESSAGE);
				} else {
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
		dtrpnEnterAPrompt.setText(text);
	}

	public void setCurrCellPins(BrailleCell cell) {
		pOne.setSelected(cell.getPinState(0));
		pTwo.setSelected(cell.getPinState(1));
		pThree.setSelected(cell.getPinState(2));
		pFour.setSelected(cell.getPinState(3));
		pFive.setSelected(cell.getPinState(4));
		pSix.setSelected(cell.getPinState(5));
		pSeven.setSelected(cell.getPinState(6));
		pEight.setSelected(cell.getPinState(7));
	}

	public void setButtonText(String text) {
		buttonEditor.setText(text);
	}

	public void setCardList() {
		listModel.clear();
		for (Card cards : this.cards) {
			listModel.addElement(cards.getName());
		}
		list.setSelectedIndex(currCard);
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
				cards.get(currCard).getButtonList().get(currButton).setText(buttonEditor.getText());
				while (size <= buttonNum) {
					System.out.println(size);
					cards.get(currCard).getButtonList().add(new DataButton(size));
					size = cards.get(currCard).getButtonList().size();
				}
				System.out.println(size);
				currButton = buttonNum;
				this.setButtonText("");
			}
		}
	}

	public void updateButton() {
		if (cards.get(currCard).getButtonList().isEmpty()) {
			DataButton temp = new DataButton(0);
			cards.get(currCard).getButtonList().add(temp);
		}
		cards.get(currCard).getButtonList().get(currButton).setText(buttonEditor.getText());
	}

	public void updatePrompt() {
		cards.get(currCard).setText(dtrpnEnterAPrompt.getText());
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
		s += pSeven.isSelected() ? "1" : "0";
		s += pEight.isSelected() ? "1" : "0";
		temp.setPins(s);
		cards.get(currCard).getCells().set(currCell, temp);
	}

	public void showPrompt() {
		setPromptText(cards.get(currCard).getText());
	}

	public void nextCard() {
		updateButton();
		updatePrompt();
		setCurrCellPins(cards.get(currCard).getCells().get(currCell));
		cards.get(currCard).setName(txtCardName.getText());
		currCard++;
		currButton = 0;
		currCell = 0;
		this.setButtonText(cards.get(currCard).getButtonList().get(0).getText());
		txtCardName.setText(cards.get(currCard).getName());
		showPrompt();
		setCurrCellPins(cards.get(currCard).getCells().get(currCell));
		setCardList();
	}

	public void prevCard() {
		updateButton();
		updatePrompt();
		setCurrCellPins(cards.get(currCard).getCells().get(currCell));
		cards.get(currCard).setName(txtCardName.getText());
		currCard--;
		currButton = 0;
		currCell = 0;
		this.setButtonText(cards.get(currCard).getButtonList().get(0).getText());
		txtCardName.setText(cards.get(currCard).getName());
		showPrompt();
		setCurrCellPins(cards.get(currCard).getCells().get(currCell));
		setCardList();
	}
}