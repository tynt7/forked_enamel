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
	
	public DataButton(int id) {
		this.bID = id;
	}
	
	public DataButton(DataButton other) {
		this.bID = other.bID;
		this.text = other.text;
		this.audioFile = other.audioFile;
	}
	
	public String getText() {
		return this.text;
	}
	
	public int getID() {
		return this.bID;
	}
	
	public void addText(String newText) {
		if (text == null) {
			text = newText;
		}
		else {
			text += "\n" + newText;
		}
	}
	
	public void setAudio(String audioPath) {
		this.audioFile = audioPath;
	}
	
}
