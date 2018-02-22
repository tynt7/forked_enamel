package enamel;


import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class ScenarioWriter {
	
	private String path;
	private boolean append = false;
	
	/*
	 * Constructor for creating a file
	 */
	public ScenarioWriter (String filePath) {
		path = filePath;
	}
	
	/*
	 * Constructor for editing file
	 */
	public ScenarioWriter (String filePath, boolean appendVal) {
		path = filePath;
		append = appendVal;
	}
	
	/*
	 * Write to a file
	 */
	public void write(String text) throws IOException{
		FileWriter write = new FileWriter(path, append);
		PrintWriter print = new PrintWriter(write);
		print.printf("%s" + "%n", text);
		print.close();
	}
}
