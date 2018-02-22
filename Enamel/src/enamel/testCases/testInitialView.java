package enamel.testCases;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import enamel.DataButton;
import enamel.InitialView;

class testInitialView {
	private InitialView iv;
	
	/**
	 * Setup before class
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpClass() throws Exception{
		
	}
	
	/**
	 * Tear down class a the end
	 * @throws Exception
	 */
	@AfterClass
	public static void tearDownClass() throws Exception{
		
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
	public void testConstructor(){
		
	}

}
