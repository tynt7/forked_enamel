package enamel;

import java.io.IOException;
import java.lang.reflect.Array;

public class AuthoringApp {

	private int numCells;
	private int numButtons;
	private Array buttons[];
	private String name;
	private ScenarioWriter writer;

	//constructor for creating a file
	public AuthoringApp(String path, int cell, int buttons, String theName) {
		writer = new ScenarioWriter(path);
		numCells = cell;
		numButtons = buttons;
		name = theName;

	}
	//Constructor for appending a file
	public AuthoringApp(String path, boolean val, int cell, int buttons, String theName) {
		writer = new ScenarioWriter(path, val);
		numCells = cell;
		numButtons = buttons;
		name = theName;
	}

	//initialize the form
	public void initalizeForm() throws IOException {
		writer.write("Cell " + numCells + "\nButton " + numButtons + "\n" + name);
	}

	//Display pins from a given array of 1's and 0's
	public void dispPin(String cell, String pins) throws IOException {
		writer.write("\n/~disp-cell-pins:" + cell + " " + pins);
	}

	//clear the pins
	public void clearPin() throws IOException {
		writer.write("\n/~disp-cell-clear:");
	}

	//write a prompt to be said
	public void writePrompt(String prompt) throws IOException {
		writer.write("\n" + prompt);
	}

	//reset the buttons
	public void resetButtons() throws IOException {
		writer.write("\n/~reset-buttons");
	}

	//set the buttons values
	public void setButtons() throws IOException {
		for (int i = 0; i <= buttons.length; i++) {
			writer.write("\n/~skip-button:" + buttons[i]);
		}
	}
}
