package enamel.testCases;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.*;

import enamel.ScenarioWriter;

public class testScenarioWriter {

	private String name;
	private String path;
	private ScenarioWriter sw;
	private BufferedReader br;

	@Before
	public void setUp() throws Exception {
		path = "./TestDummies/scenarioWriterTest.txt";
		sw = new ScenarioWriter(path);
		br = new BufferedReader(new FileReader("./TestDummies/scenarioWriterTest.txt"));
	}

	/* 
	 * Creates a file and tests if it writes correctly
	 */
	@Test
	public void test() throws IOException {
		sw.write("One");
		assertEquals("One", br.readLine());
		
	}

	/*
	 * Appends the file created in test one and test the contents
	 */
	@Test
	public void test2() throws IOException {
		ScenarioWriter sw2 = new ScenarioWriter(path, true);
		sw2.write("Two");
		assertEquals("One", br.readLine());
		assertEquals("Two", br.readLine());
	}

	/*
	 * test the getName method
	 */
	@Test
	public void test3() {
		assertEquals(sw.getName(), "scenarioWriterTest.txt");
		path = "hello.txt";
		sw = new ScenarioWriter(path);
		assertEquals(sw.getName(), "hello.txt");
	}
}
