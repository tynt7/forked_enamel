package enamel;

/**
 *
 *Buttons with associated fields and methods 
 *
 */

public class DataButton {
	
	private int bID;
	private String text;
	private String audioFile;
	
	//Constructors
	public DataButton(int id) {
		this.bID = id;
		this.audioFile = "";
		this.text = "";
	}
	public DataButton(DataButton other) {
		this.bID = other.bID;
		this.text = other.text;
		this.audioFile = other.audioFile;
	}
	
	//utility methods
	public int getID() {
		return this.bID;
	}
	
	public String getAudio() {
		return this.audioFile;
	}
	
	public String getText() {
		return this.text;
	}
	
	//change methods
	public void addText(String newText) {
		if (text.equals("")) {
			text = newText;
		}
		else {
			text += "\n" + newText;
		}
	}
	
	public void setAudio(String audioPath) {
		this.audioFile = audioPath;
	}
	
	public void setText(String newText) {
		this.text = newText;
	}
	
	
	
}
