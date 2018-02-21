package enamel.testCases;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.Test;

import enamel.DataButton;

/**
 * 
 * @author Jeremy, Nisha, Tyler
 * 
 *         This Class tests constructors and methods of DataButton class.
 *
 */
public class testDataButton {
	private DataButton dataButton;

	/**
	 * Initial Setup
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		dataButton = new DataButton(1);
	}

	/**
	 * Tests constructor with ID
	 */
	@Test
	public void testDataButtonID() {
		DataButton newDB = new DataButton(3);
		assertTrue("Wrong Audio", (newDB.getAudio() == ""));
		assertTrue("Wrong Text", (newDB.getText() == ""));
		assertTrue("Wrong ID", (newDB.getID() == 3));
		assertTrue("Wrong Audio or Text or ID",
				(dataButton.getAudio() == "") && (dataButton.getText() == "") && (dataButton.getID() == 1));
	}

	/**
	 * Tests constructor with other DataButton Object
	 */
	@Test
	public void testDataButtonOther() {
		DataButton newDB = new DataButton(dataButton);
		assertTrue("Wrong Audio", (newDB.getAudio() == ""));
		assertTrue("Wrong Text", (newDB.getText() == ""));
		assertTrue("Wrong ID", (newDB.getID() == 1));
	}
	
	/**
	 * Tests getID method
	 */
	@Test
	public void testGetID(){
		assertTrue("Wrong ID", (dataButton.getID() == 1));
		
		DataButton newDB = new DataButton(0);
		assertTrue("Wrong ID", (newDB.getID() == 0));
		
		DataButton newDB1 = new DataButton(1);
		assertTrue("Wrong ID", (newDB1.getID() == 1));
		
		DataButton newDB2 = new DataButton(2);
		assertTrue("Wrong ID", (newDB2.getID() == 2));
		
		DataButton newDB3 = new DataButton(3);
		assertTrue("Wrong ID", (newDB3.getID() == 3));
		
		DataButton newDBNeg = new DataButton(-1);
		assertTrue("Wrong ID", (newDBNeg.getID() == -1));
	}
	
	/**
	 * Tests getText Method
	 */
	@Test
	public void testGetText(){
		assertTrue("Wrong Text", (dataButton.getText() == ""));
		
		dataButton.addText("Hello");
		assertTrue("Wrong text1", (dataButton.getText().equals("Hello")));
		assertEquals("Wrong Text", dataButton.getText(), "Hello");

		dataButton.addText("1");
		assertTrue("Wrong text1", (dataButton.getText().equals("Hello"+"\n1")));
		assertEquals("Wrong Text", dataButton.getText(), "Hello\n1");
		
		dataButton.addText("2");
		assertTrue("Wrong text2", (dataButton.getText().equals("Hello\n1\n2")));
		assertEquals("Wrong Text2", dataButton.getText(), "Hello\n1\n2");
		
		dataButton.addText("3");
		assertTrue("Wrong text3", (dataButton.getText().equals("Hello\n1\n2\n3")));
		assertEquals("Wrong Text3", dataButton.getText(), "Hello\n1\n2\n3");
	}
	
	/**
	 * tests getAudio Method
	 */
	@Test
	public void testGetAudio(){
		assertTrue("Wrong Audio", (dataButton.getAudio() == ""));
		
		dataButton.setAudio("Hello");
		assertTrue("Wrong File", (dataButton.getAudio().equals("Hello")));
		assertTrue("Wrong File", (dataButton.getAudio()=="Hello"));
		assertEquals("Wrong File",dataButton.getAudio(), "Hello");
		
		dataButton.setAudio("World");
		assertTrue("Wrong File", (dataButton.getAudio().equals("World")));
		assertTrue("Wrong File", (dataButton.getAudio()=="World"));
		assertEquals("Wrong File", dataButton.getAudio(), "World");

		dataButton.setAudio("WorldNow");
		assertTrue("Wrong File", (dataButton.getAudio().equals("WorldNow")));
		assertTrue("Wrong File", (dataButton.getAudio()=="WorldNow"));
		assertEquals("Wrong File", dataButton.getAudio(), "WorldNow");
		
		dataButton.setAudio("WorldNew");
		assertTrue("Wrong File", (dataButton.getAudio().equals("WorldNew")));
		assertTrue("Wrong File", (dataButton.getAudio()=="WorldNew"));
		assertEquals("Wrong File", dataButton.getAudio(), "WorldNew");
	}
	
	/**
	 * tests add Texts Method. 
	 * Method should append new text in new Line if getText is not an empty string
	 */
	@Test
	public void testAddText(){
		dataButton.addText("Hello");
		assertTrue("Wrong text", (dataButton.getText().equals("Hello")));
		assertTrue("Wrong text", (dataButton.getText()=="Hello"));
		assertEquals("Wrong text",dataButton.getText(), "Hello");
		
		dataButton.addText(" World");
		assertTrue("Wrong text1", (dataButton.getText().equals("Hello"+"\n"+" World")));
		assertEquals("Wrong Text", dataButton.getText(), "Hello\n World");

		dataButton.addText("New Line");
		assertTrue("Wrong text1", (dataButton.getText().equals("Hello"+"\n"+" World\nNew Line")));
		assertEquals("Wrong Text", dataButton.getText(), "Hello\n World"+ "\nNew Line");
		
		dataButton.addText("Another New Line");
		assertTrue("Wrong text1", (dataButton.getText().equals("Hello"+"\n"+" World\nNew Line\nAnother New Line")));
		assertEquals("Wrong Text", dataButton.getText(), "Hello\n World"+ "\nNew Line\nAnother New Line");
		
		dataButton.addText("End Line");
		assertTrue("Wrong text1", (dataButton.getText().equals("Hello"+"\n"+" World\nNew Line\nAnother New Line\nEnd Line")));
		assertEquals("Wrong Text", dataButton.getText(), "Hello\n World"+ "\nNew Line\nAnother New Line\nEnd Line");
	}
	
	/**
	 * tests setAudio Method
	 */
	@Test
	public void testSetAudio(){
		dataButton.setAudio("Hello");
		assertTrue("Wrong File", (dataButton.getAudio().equals("Hello")));
		assertTrue("Wrong File", (dataButton.getAudio()=="Hello"));
		assertEquals("Wrong File",dataButton.getAudio(), "Hello");
		
		dataButton.setAudio("World");
		assertTrue("Wrong File", (dataButton.getAudio().equals("World")));
		assertEquals("Wrong File", dataButton.getAudio(), "World");

		//Check for spaces!!!!!
		dataButton.setAudio("New Audio");
		assertTrue("Wrong File", (dataButton.getAudio().equals("New Audio")));
		assertEquals("Wrong File", dataButton.getAudio(), "New Audio");
		
		dataButton.setAudio("./FactoryScenarios/name");
		assertTrue("Wrong Path", (dataButton.getAudio().equals("./FactoryScenarios/name")));
		assertEquals("Wrong Path", dataButton.getAudio(), "./FactoryScenarios/name");
		
		dataButton.setAudio("./FactoryScenarios/AudioFiles");
		assertTrue("Wrong Path", (dataButton.getAudio().equals("./FactoryScenarios/AudioFiles")));
		assertEquals("Wrong Path", dataButton.getAudio(), "./FactoryScenarios/AudioFiles");
	}
	
	/**
	 * Tests setText Method
	 * Method should overwrite button text field.
	 */
	@Test
	public void testSetText(){
		dataButton.setText("Hello");
		assertTrue("Wrong text", (dataButton.getText().equals("Hello")));
		assertTrue("Wrong text", (dataButton.getText()=="Hello"));
		assertEquals("Wrong text",dataButton.getText(), "Hello");
		
		dataButton.setText(" World");
		assertTrue("Wrong text1", (dataButton.getText().equals(" World")));
		assertEquals("Wrong Text", dataButton.getText(), " World");

		dataButton.setText("New Line");
		assertTrue("Wrong text1", (dataButton.getText().equals("New Line")));
		assertEquals("Wrong Text", dataButton.getText(), "New Line");
		
		dataButton.setText("New Text");
		assertTrue("Wrong text1", (dataButton.getText().equals("New Text")));
		assertEquals("Wrong Text", dataButton.getText(), "New Text");
		
		dataButton.setText("Last");
		assertTrue("Wrong text1", (dataButton.getText().equals("Last")));
		assertEquals("Wrong Text", dataButton.getText(), "Last");
	}
}
