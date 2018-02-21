package enamel.testCases;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import enamel.Card;
import enamel.CardsToFileParser;
import enamel.DataButton;

public class testCTFP {
	
	ArrayList<Card> cards = new ArrayList<>();
	
	@Test
	public void testCtor() {
		CardsToFileParser cTFP = new CardsToFileParser(cards, 1, 2, "Hello", "Bye");
		assertEquals("", cTFP.getText());
	}
	
	@Test
	public void testCellButtonInitialEnding() {
		CardsToFileParser cTFP = new CardsToFileParser(cards, 1, 2, "Hello", "Bye");
		cTFP.createBody();
		String text = "Cell 2\nButton 1\nHello\nBye\n/~disp-cell-clear:0\n/~disp-cell-clear:1";
		assertEquals(text, cTFP.getText());
		CardsToFileParser cTFP2 = new CardsToFileParser(cards, 5, 1, "HI", "Good Bye\nHave a Nice Day");
		cTFP2.createBody();
		text = "Cell 1\nButton 5\nHI\nGood Bye\nHave a Nice Day\n/~disp-cell-clear:0";
		assertEquals(text, cTFP2.getText());
	}
	
	@Test
	public void testWriteButtons() {
		CardsToFileParser cTFP = new CardsToFileParser(cards, 2, 3, "Hello", "Bye");
		Card test = new Card(0, "Card1", "Hi");
		ArrayList<DataButton> bList = new ArrayList<>();
		DataButton b1 = new DataButton(0);
		b1.addText("hello");
		bList.add(b1);
		DataButton b2 = new DataButton(1);
		b2.addText("bye");
		bList.add(b2);
		test.setBList(bList);
		String returned = cTFP.writeCard(test);
		System.out.println(returned);
		String result = "/~disp-cell-clear:0";
		for (int i = 1; i < 3; i++) {
			result += "\n/~disp-cell-clear:" + i;
		}
		result += "\n" + null;
		result += "\n/~skip-button:" + 0 + " ONEE";
		result += "\n/~skip-button:" + 1 + " TWOO";
		result += "\n/~user-input";
		result += "\n/~ONEE";
		result += "\nhello";
		result += "\n/~skip:NEXTT";
		result += "\n/~TWOO";
		result += "\nbye";
		result += "\n/~skip:NEXTT";
		result += "\n\n/~NEXTT";
		assertEquals(result, returned); //Test basic button
		
		
		b1.setAudio("correct.wav");
		returned = cTFP.writeCard(test);
		System.out.println(returned);
		result = "/~disp-cell-clear:0";
		for (int i = 1; i < 3; i++) {
			result += "\n/~disp-cell-clear:" + i;
		}
		result += "\n" + null;
		result += "\n/~skip-button:" + 0 + " ONEE";
		result += "\n/~skip-button:" + 1 + " TWOO";
		result += "\n/~user-input";
		result += "\n/~ONEE";
		result += "\n/~sound:correct.wav";
		result += "\nhello";
		result += "\n/~skip:NEXTT";
		result += "\n/~TWOO";
		result += "\nbye";
		result += "\n/~skip:NEXTT";
		result += "\n\n/~NEXTT";
		assertEquals(result, returned); // button with sound file only
		
		
		b1.setAudio(".\\FactoryScenarios\\correct.wav");
		returned = cTFP.writeCard(test);
		System.out.println(returned);
		result = "/~disp-cell-clear:0";
		for (int i = 1; i < 3; i++) {
			result += "\n/~disp-cell-clear:" + i;
		}
		result += "\n" + null;
		result += "\n/~skip-button:" + 0 + " ONEE";
		result += "\n/~skip-button:" + 1 + " TWOO";
		result += "\n/~user-input";
		result += "\n/~ONEE";
		result += "\n/~sound:correct.wav";
		result += "\nhello";
		result += "\n/~skip:NEXTT";
		result += "\n/~TWOO";
		result += "\nbye";
		result += "\n/~skip:NEXTT";
		result += "\n\n/~NEXTT";
		assertEquals(result, returned); //button with sound file with path
		
		
		b1.setText("hello\n/Pins on 0: 10101010");
		returned = cTFP.writeCard(test);
		System.out.println(returned);
		result = "/~disp-cell-clear:0";
		for (int i = 1; i < 3; i++) {
			result += "\n/~disp-cell-clear:" + i;
		}
		result += "\n" + null;
		result += "\n/~skip-button:" + 0 + " ONEE";
		result += "\n/~skip-button:" + 1 + " TWOO";
		result += "\n/~user-input";
		result += "\n/~ONEE";
		result += "\n/~sound:correct.wav";
		result += "\nhello";
		result += "\n/~disp-cell-clear:0";
		result += "\n/~disp-cell-pins:0 10101010";
		result += "\n/~skip:NEXTT";
		result += "\n/~TWOO";
		result += "\nbye";
		result += "\n/~skip:NEXTT";
		result += "\n\n/~NEXTT";
		assertEquals(result, returned);
	}
}
