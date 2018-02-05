package enamel;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class ScenarioWriter {
	
	private String path;
	private boolean append = false;
	
	public ScenarioWriter (String filePath) {
		path = filePath;
	}
	
	public ScenarioWriter (String filePath, boolean appendVal) {
		path = filePath;
		append = appendVal;
	}
	
	public void write(String text) throws IOException{
		FileWriter write = new FileWriter(path, append);
		PrintWriter print = new PrintWriter(write);
		print.printf("%s" + "%n", text);
		print.close();
	}
}
