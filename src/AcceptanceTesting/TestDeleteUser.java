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

public class TestDeleteUser {
	public static final String INPUT = "clerk";
	public static final String DELETEUSER = "delete user";

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDeleteUserSuccess() {
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
				out = input.processInput(DELETEUSER, output1.getState());
			}else{
				fail("");
			}
			System.out.println(out.getOutput());
			System.out.println(output1.getState());
		
			if(out.getState() == InputHandler.DELETEUSER && out.getOutput() != null) {
				output1 = output.deleteUser("Sun@carleton.ca");
			}else{
				fail("You did not select to delete a user");
			}
			assertEquals("Success!", output1.getOutput());
		}
	
	}
	
	@Test
	public void testDeleteNonExistingUser() {
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
				out = input.processInput(DELETEUSER, output1.getState());
			}else{
				fail("");
			}
			System.out.println(out.getOutput());
			System.out.println(output1.getState());
		
			if(out.getState() == InputHandler.DELETEUSER && out.getOutput() != null) {
				output1 = output.deleteUser("Sun@carleton.ca");
			}else{
				fail("You did not select to delete a user");
			}
			assertEquals("The User Does Not Exist!", output1.getOutput());
		}
	
	}
	
	@Test
	public void testDeleteUserWithLoan() {
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
				out = input.processInput(DELETEUSER, output1.getState());
			}else{
				fail("");
			}
			System.out.println(out.getOutput());
			System.out.println(output1.getState());
		
			if(out.getState() == InputHandler.DELETEUSER && out.getOutput() != null) {
				output1 = output.deleteUser("Zhibo@carleton.ca");
			}else{
				fail("You did not select to delete a user");
			}
			assertEquals("Outstanding Fee Exists!", output1.getOutput());
		}
	
	}

}
