package enamel;

import java.util.ArrayList;

public class Card {
	// actions has attributes: 
	// Name: String 
	// Type: String -> {text or audio}
	// ID: int

	private int id; // unique id to access card object
	private int position; // specifies position in the list of cards
	private String cardName; // card1 card2 card3 
	private String type;
	private ArrayList<DataButton> bList;
	private String text;
	private ArrayList<BrailleCell> cells;
	private String sound;
	
	public Card(int id, String name, String type){
		this.id = id;
		this.cardName = name;
		this.type = type;
		this.bList = new ArrayList<>();
		this.cells = new ArrayList<>();
	}
	
	public int getId(){
		return this.id;
	}
	
	public String getName(){
		return this.cardName;
	}
	
	public String getType(){
		return this.type;
	}
	
	public String getText() {
		return this.text;
	}
	
	public ArrayList<BrailleCell> getCells() {
		return this.cells;
	}
	
	public ArrayList<DataButton> getButtonList() {
		return this.bList;
	}
	
	public void addText(String newText) {
		if (text == null) {
			text = newText;
		}
		else {
			text += "\n" + newText;
		}
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public void setSound(String newSound) {
		this.sound = newSound;
	}
	
	public void setBList(ArrayList<DataButton> newList) {
		this.bList = newList;
	}
	
	public void setCells(ArrayList<BrailleCell> newList) {
		this.cells = newList;
	}
}
