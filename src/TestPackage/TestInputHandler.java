package TestPackage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import server.logic.handler.InputHandler;
import server.logic.handler.model.ServerOutput;

public class TestInputHandler {
	
	InputHandler input;

	@Before
	public void setUp() throws Exception {
		input = new InputHandler();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testProcessInput() {
//		Test some cases in that one method
		assertEquals("Who Are you?Clerk or User?", input.processInput("", 0).getOutput());
		assertEquals("Please Input The Password:", input.processInput("clerk", 1).getOutput());
		//When state is finished waiting
		assertEquals("Please Input Username and Password:'username,password'", input.processInput("user", 1).getOutput());
		//When state is clerk
		assertEquals("Please Input Title Info:'ISBN,title'", input.processInput("create title", 2).getOutput());
		assertEquals("Successfully Log Out!", input.processInput("log out", 2).getOutput());
		
		//When state is user
		assertEquals("Please Input Item Info:'useremail,ISBN,copynumber'", input.processInput("return", 3).getOutput());
		assertEquals("Please Input User Info:'useremail'", input.processInput("pay fine", 3).getOutput());
	
		//When state is create user
		assertEquals("Successfully Log Out!", input.processInput("log out", 4).getOutput());
		
		//When state is return
		assertEquals("What can I do for you?Menu:Borrow,Renew,Return,Pay Fine.", input.processInput("main menu", 12).getOutput());
		
		//When state is payfine
		assertEquals("What can I do for you?Menu:Borrow,Renew,Return,Pay Fine.", input.processInput("main menu", 13).getOutput());
	}

}
