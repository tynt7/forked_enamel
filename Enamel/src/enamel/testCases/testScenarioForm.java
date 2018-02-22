package enamel.testCases;

import static org.junit.Assert.*;
import org.junit.*;

import enamel.ScenarioForm;

public class testScenarioForm{
	
	private ScenarioForm sf;

	@Before
	public void setUp() throws Exception {
		sf = new ScenarioForm();
	}

	/*
	 * Test if the GUI is created 
	 */
	@Test
	public void test() {
		assertNotNull(sf);
	}

	/*
	 * Ensure the GUI is capable of having multiple iterations of itself
	 */
	@Test
	public void test2() {
		ScenarioForm temp = new ScenarioForm();
		assertNotSame(sf, temp);
		
	}

	/*
	 * 
	 */
	@Test
	public void test3() {
		
	}
}