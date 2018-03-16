package enamel;

/**
 * 
 * @author Jeremy, Nisha, Tyler Class for DataButton objects. Each DataButton
 *         object has associated buttonID, buttonText and Button audioFile. This
 *         class also has accessors and modifiers
 */

public class DataButton {

	private int bID;
	private String text;
	private String audioFile;
	private String link;

	// Constructors
	/**
	 * Creates a DataButton object with a specific int id.
	 * 
	 * @param id
	 */
	public DataButton(int id) {
		this.bID = id;
		this.audioFile = "";
		this.text = "";
		this.link = "";
	}

	/**
	 * Creates a new DataButton object with other DataButton object
	 * 
	 * @param other
	 */
	public DataButton(DataButton other) {
		this.bID = other.bID;
		this.text = other.text;
		this.audioFile = other.audioFile;
		this.link = other.link;
	}

	// utility methods
	/**
	 * Method to get Button Id
	 * 
	 * @return int id
	 */
	public int getID() {
		return this.bID;
	}

	/**
	 * Method to get Recording file associated with the button
	 * 
	 * @return String audio file name
	 */
	public String getAudio() {
		return this.audioFile;
	}

	/**
	 * Method to get text associated with button
	 * 
	 * @return String text
	 */
	public String getText() {
		return this.text;
	}
	
	/**
	 * Method to get the link
	 * 
	 *  @return link to next card
	 */
	public String getLink() {
		return this.link;
	}

	// change methods
	/**
	 * Method to set the text associated with button. If text is empty, set
	 * 'newText' as text associated with button; else 'newText' is appended to
	 * already existing text as new line.
	 * 
	 * @param newText
	 */
	public void addText(String newText) {
		if (text.equals("")) {
			text = newText;
		} else {
			text += "\n" + newText;
		}
	}
	
	/**
	 * Method to set the new link
	 * 
	 * @param the card to link to
	 */
	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * Set the audio file associated with button based on specific audioPath
	 * 
	 * @param audioPath
	 */
	public void setAudio(String audioPath) {
		this.audioFile = audioPath;
	}

	/**
	 * Method to overwrite existing text with newText
	 * 
	 * @param newText
	 */
	public void setText(String newText) {
		this.text = newText;
	}

}
