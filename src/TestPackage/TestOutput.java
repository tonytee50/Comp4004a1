package TestPackage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import server.logic.handler.model.Output;

public class TestOutput {
	
	Output output;

	@Before
	public void setUp() throws Exception {
		
		output = new Output("This is the output", 1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetters() {
		assertEquals("This is the output", output.getOutput());
		assertEquals(1, output.getState());
	}
	
	@Test
	public void testSetters() {
		output.setOutput("New output");
		output.setState(2);
		assertEquals("New output", output.getOutput());
		assertEquals(2, output.getState());
	}
	
	@Test
	public void testToString() {
		assertEquals("[This is the output,1]", output.toString());
	}

}
