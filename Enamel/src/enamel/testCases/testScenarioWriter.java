package enamel.testCases;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.*;

import enamel.ScenarioWriter;

public class testScenarioWriter {

	private boolean val = true;
	private String path;
	private String line;
	private ScenarioWriter sw;
	private BufferedReader br;

	@Before
	public void setUp() throws Exception {
		path = "./TestFile.txt";
		sw = new ScenarioWriter(path);
		br = new BufferedReader(new FileReader(sw.getName()));

	}

	/* 
	 * Creates a file and tests if it writes correctly
	 */
	@Test
	public void test() throws IOException {
		sw.write("One");
		line = br.readLine();
		assertEquals("One", line);
	}

	/*
	 * Appends the file created in test one and test the contents
	 */
	@Test
	public void test2() throws IOException {
		ScenarioWriter sw2 = new ScenarioWriter(path,true);
		sw2.write("Two");
		br.readLine();
		line = br.readLine();
		br.close();
		assertEquals("Two", line);
		
	}
}
