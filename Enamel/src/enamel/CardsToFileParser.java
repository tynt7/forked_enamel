package enamel;

import java.util.ArrayList;

public class CardsToFileParser {

	private ArrayList<Card> cards;
	private String initialPrompt;
	private String endingPrompt;
	private int numButtons;
	private int numCells;
	private String body;

	public CardsToFileParser(ArrayList<Card> cards, int numButtons, int numCells, String initialPrompt,
			String endingPrompt) { // , String path) {
		this.cards = cards;
		this.numButtons = numButtons;
		this.numCells = numCells;
		this.initialPrompt = initialPrompt;
		this.endingPrompt = endingPrompt;
		this.body = "";
	}

	public void createBody() {
		body += "Cell " + numCells;
		body += "\nButton " + numButtons;
		body += "\n" + initialPrompt;
		for (Card currCard : cards) {
			body += "\n" + writeCard(currCard);
		}
		body += "\n" + endingPrompt;
		for (int i = 0; i < this.numCells; i++) {
			body += "\n/~disp-cell-clear:" + i;
		}
		System.out.println(body);
	}

	public String writeCard(Card currCard) {
		String result = "/~disp-cell-clear:0";
		for (int i = 1; i < this.numCells; i++) {
			result += "\n/~disp-cell-clear:" + i;
		}
		ArrayList<BrailleCell> cells = currCard.getCells();
		for (int i = 0; i < cells.size(); i++) {
			String pins = "";
			for (int j = 0; j < cells.get(i).getNumberOfPins(); j++) {
				pins += cells.get(i).getPinState(j) ? "1" : "0";
			}
			result += "\n/~disp-cell-pins:" + i + " " + pins;
		}
		result += "\n" + currCard.getText();
		ArrayList<DataButton> buttons = currCard.getButtonList();
		for (int i = 0; i < buttons.size(); i++) {
			result += "\n/~skip-button:" + i + " ";
			switch (i) {
			case (0):
				result += "ONEE";
				break;
			case (1):
				result += "TWOO";
				break;
			case (2):
				result += "THREEE";
				break;
			case (3):
				result += "FOURR";
				break;
			case (4):
				result += "FIVEE";
				break;
			case (5):
				result += "SIXX";
				break;
			}
		}
		result += "\n/~user-input";
		for (int i = 0; i < buttons.size(); i++) {
			switch (i) {
			case (0):
				result += "\n/~ONEE";
				break;
			case (1):
				result += "\n/~TWOO";
				break;
			case (2):
				result += "\n/~THREEE";
				break;
			case (3):
				result += "\n/~FOURR";
				break;
			case (4):
				result += "\n/~FIVEE";
				break;
			case (5):
				result += "\n/~SIXX";
				break;
			}
			String audioPath = buttons.get(i).getAudio();
			if (!audioPath.equals("")) {
				int slashPos = 0;
				for (int j = 0; j < audioPath.length(); j++) {
					if (audioPath.charAt(j) == '\\') {
						slashPos = j;
					}
				}
				result += "\n/~sound:" + audioPath.substring(slashPos + 1);
			}
			String[] arr = buttons.get(i).getText().split("\n");
			for (int j = 0; j < arr.length; j++) {
				if ((arr[j].length() == 20) && (arr[j].substring(0, 9).equals("/Pins on "))) {
					result += "\n/~disp-cell-clear:" + arr[j].charAt(9);
					result += "\n/~disp-cell-pins:" + arr[j].charAt(9) + " " + arr[j].substring(12);
				} else {
					result += "\n" + arr[j];
				}
			}
			result += "\n/~skip:NEXTT";
		}
		result += "\n\n/~NEXTT";
		return result;
	}

	public String getText() {
		return this.body;
	}
}
