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
	
	public Card(int id, String name, String type){
		this.id = id;
		this.cardName = name;
		this.type = type;
		this.bList = new ArrayList<>();
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
}
