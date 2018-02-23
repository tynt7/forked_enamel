package enamel.testCases;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import enamel.DataButton;
import enamel.InitialView;

/**
 * 
 * @author Nisha, Jeremy, Tyler Test class to test Initial View GUI Further to
 *         feedback from professor, it was decided to do the GUI testing
 *         manually as it's beyond the scope of this course
 *
 */
class testInitialView {
	private InitialView iv;

	/**
	 * Setup before class
	 * 
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpClass() throws Exception {

	}

	/**
	 * Tear down class a the end
	 * 
	 * @throws Exception
	 */
	@AfterClass
	public static void tearDownClass() throws Exception {

	}

	/**
	 * Initial Setup
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		iv = new InitialView();
	}

	/**
	 * test
	 */
	public void testConstructor() {

	}

}