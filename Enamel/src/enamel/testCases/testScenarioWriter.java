package enamel.testCases;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.*;

import enamel.ScenarioWriter;

public class testScenarioWriter {

	private boolean val = true;
	private String path;
	private ScenarioWriter sw;

	@Before
	public void setUp() throws Exception {
		path = "./";
	}

	/* 
	 * Creates a file and tests if it writes correctly
	 */
	@Test
	public void test() throws IOException {
		sw = new ScenarioWriter(path);
		sw.write("Hello\n");
		
	}

	/*
	 * Appends the file created in test one and test the contents
	 */
	@Test
	public void test2() throws IOException {
		sw = new ScenarioWriter(path, true);
		sw.write("Bye");
	}

	/*
	 * 
	 */
	@Test
	public void test3() {

	}
}
