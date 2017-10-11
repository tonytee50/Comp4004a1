package AcceptanceTesting;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import server.logic.handler.InputHandler;
import server.logic.handler.OutputHandler;
import server.logic.handler.model.Output;
import server.logic.handler.model.ServerOutput;
import utilities.Config;

public class TestAddUser {
	public static final String INPUT = "clerk";
	public static final String CREATEUSER = "create user";
//	public static final String CLERK_PASSWORD = "admin";
//	public static final int FINISHWAITING=1;
//	public static final int CREATEUSER=4;
	
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddUserSuccess() {
		InputHandler input = new InputHandler();
		ServerOutput out = new ServerOutput("", 0);
		OutputHandler output = new OutputHandler();
		
		if(input.processInput("", InputHandler.WAITING) == null) {
			fail("");
		}
		
		out = input.processInput(INPUT, InputHandler.FINISHWAITING);
		Output output1;
		
		if(out.getState() == InputHandler.CLERKLOGIN) {
			output1 = output.clerkLogin(Config.CLERK_PASSWORD);
			if(output1.getState() == OutputHandler.CLERK) {
				out = input.processInput(CREATEUSER, output1.getState());
			}else{
				fail("");
			}
			System.out.println(out.getOutput());
			System.out.println(output1.getState());
		
			if(out.getState() == InputHandler.CREATEUSER && out.getOutput() != null) {
				output1 = output.createUser("tony.tamer@carleton.ca,thePass");
			}else{
				fail("You did not select to create a user");
			}
			assertEquals("Success!", output1.getOutput());
		}
	
	}
	
	
	
	@Test
	public void testAddUserWrongEmail() {
		InputHandler input = new InputHandler();
		ServerOutput out = new ServerOutput("", 0);
		OutputHandler output = new OutputHandler();
		
		out = input.processInput(INPUT, InputHandler.FINISHWAITING);
		Output output1;
		
		if(out.getState() == InputHandler.CLERKLOGIN) {
			output1 = output.clerkLogin(Config.CLERK_PASSWORD);
			if(output1.getState() == OutputHandler.CLERK) {
				out = input.processInput(CREATEUSER, output1.getState());
			}else{
				fail("");
			}
			System.out.println(out.getOutput());
			System.out.println(output1.getState());
		
			if(out.getState() == InputHandler.CREATEUSER && out.getOutput() != null) {
				output1 = output.createUser("tony.tamercarleton.ca,thePass");
			}
			assertEquals("Your input should be in this format:'username,password'", output1.getOutput());
		}	
	}
	
	@Test
	public void testAddUserAlreadyExists() {
		InputHandler input = new InputHandler();
		ServerOutput out = new ServerOutput("", 0);
		OutputHandler output = new OutputHandler();
		
		out = input.processInput(INPUT, InputHandler.FINISHWAITING);
		Output output1;
		
		if(out.getState() == InputHandler.CLERKLOGIN) {
			output1 = output.clerkLogin(Config.CLERK_PASSWORD);
			if(output1.getState() == OutputHandler.CLERK) {
				out = input.processInput(CREATEUSER, output1.getState());
			}else{
				fail("");
			}
			System.out.println(out.getOutput());
			System.out.println(output1.getState());
		
			if(out.getState() == InputHandler.CREATEUSER && out.getOutput() != null) {
				output1 = output.createUser("tony.tamer@carleton.ca,thePass");
			}
			assertEquals("The User Already Exists!", output1.getOutput());
		}	
	}
	
	
}