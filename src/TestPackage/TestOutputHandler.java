package TestPackage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import server.logic.handler.OutputHandler;
import server.logic.handler.model.Output;

public class TestOutputHandler {
	
	OutputHandler outputHand;

	@Before
	public void setUp() throws Exception {
		outputHand = new OutputHandler();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateUser() {
		Output out = new Output("Your input should in this format:'username,password'", 4);
		assertEquals(out.toString(), outputHand.createUser("Antony,password").toString());
		Output out1 = new Output("Success!", 2);
		assertEquals(out1.toString(), outputHand.createUser("tony.tamer@carleton.ca, MyPass").toString());
		Output out2 = new Output("The User Already Exists!", 2);
		assertEquals(out2.toString(), outputHand.createUser("tony.tamer@carleton.ca, MyPass").toString());
	}
	
	@Test
	public void testIsInteger() {
		//This is meant to make sure ISBN is 13 digits long
		assertTrue(OutputHandler.isInteger("1243212345676"));
		assertFalse(OutputHandler.isInteger("123456789"));
		assertFalse(OutputHandler.isInteger("1234567823414312439"));
		assertFalse(OutputHandler.isInteger("000000000000000"));
	}

}
