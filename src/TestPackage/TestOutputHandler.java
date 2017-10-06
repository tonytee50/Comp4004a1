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
		Output out = new Output("Your input should be in this format:'username,password'", 4);
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
	
	@Test
	public void testCreateItem() {
		Output out = new Output("Your input should be in this format:'ISBN',ISBN should be a 13-digit number", 6);
		assertEquals(out.toString(), outputHand.createItem("123456789123456").toString());
		
		Output out1 = new Output("The Title Does Not Exists!", 2);
		assertEquals(out1.toString(), outputHand.createItem("1234567891234").toString());
		
		Output out2 = new Output("Success!", 2);
		assertEquals(out2.toString(), outputHand.createItem("9781442668584").toString());
		
	}
	
	@Test
	public void testDeleteUser() {
		Output out = new Output("Your input should be in this format:'useremail'", 7);
		assertEquals(out.toString(), outputHand.deleteUser("tonytamer").toString());
		
		Output out1 = new Output("Success!", 2);
		assertEquals(out1.toString(), outputHand.deleteUser("tony.tamer@carleton.ca").toString());
		
		Output out2 = new Output("The User Does Not Exist!", 7);
		assertEquals(out2.toString(), outputHand.deleteUser("tony.tamer111@carleton.ca").toString());
	}
	
	@Test
	public void testDeleteTitle() {
		Output out = new Output("Your input should be in this format:'ISBN',ISBN should be a 13-digit number", 8);
		assertEquals(out.toString(), outputHand.deleteTitle("1234").toString());
		
		Output out1 = new Output("The Title Does Not Exist!", 2);
		assertEquals(out1.toString(), outputHand.deleteTitle("1234123456789").toString());
		
		Output out2 = new Output("Success!", 2);
		assertEquals(out2.toString(), outputHand.deleteTitle("9781442616899").toString());
	}
	
	@Test
	public void testisNumber() {
		assertFalse(outputHand.isNumber("abfdr5"));
		assertTrue(outputHand.isNumber("123453"));
		assertFalse(outputHand.isNumber("12312a32"));
	}
	
	@Test
	public void testDeleteItem() {
		Output out = new Output("Your input should in this format:'ISBN,copynumber',ISBN should be a 13-digit number", 9);
		assertEquals(out.toString(), outputHand.deleteItem("Hello mates!").toString());
		assertEquals(out.toString(), outputHand.deleteItem("1,1234312345678").toString());
		
		Output out1 = new Output("Success!", 2);
		assertEquals(out1.toString(), outputHand.deleteItem("9781442667181,1").toString());
	}

}
