package TestPackage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import server.logic.handler.model.ServerOutput;

public class TestServerOutput {

	ServerOutput output;
	
	@Before
	public void setUp() throws Exception {
		output = new ServerOutput("output", 0);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetOutput() {
		assertEquals("output", output.getOutput());
	}
	
	@Test
	public void testGetState() {
		assertEquals(0, output.getState());
	}

}
