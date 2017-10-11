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

public class TestDeleteItem {
	public static final String INPUT = "clerk";
	public static final String DELETEITEM = "delete item";

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDeleteItemSuccessfully() {
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
				out = input.processInput(DELETEITEM, output1.getState());
			}else{
				fail("");
			}
			System.out.println(out.getOutput());
			System.out.println(output1.getState());
		
			if(out.getState() == InputHandler.DELETEITEM && out.getOutput() != null) {
				output1 = output.deleteItem("9781442667181,1");
			}else{
				fail("You did not select to delete an item");
			}
			assertEquals("Success!", output1.getOutput());
		}
	}
	
	@Test
	public void testDeleteItemThatDoesntExist() {
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
				out = input.processInput(DELETEITEM, output1.getState());
			}else{
				fail("");
			}
			System.out.println(out.getOutput());
			System.out.println(output1.getState());
		
			if(out.getState() == InputHandler.DELETEITEM && out.getOutput() != null) {
				output1 = output.deleteItem("9781442667181,1");
			}else{
				fail("You did not select to delete an item");
			}
			assertEquals("The Item Does Not Exist!", output1.getOutput());
		}
	}

	@Test
	public void testDeleteItemWithWrongInput() {
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
				out = input.processInput(DELETEITEM, output1.getState());
			}else{
				fail("");
			}
			System.out.println(out.getOutput());
			System.out.println(output1.getState());
		
			if(out.getState() == InputHandler.DELETEITEM && out.getOutput() != null) {
				output1 = output.deleteItem("97814426671,1");
			}else{
				fail("You did not select to delete an item");
			}
			assertEquals("Your input should be in this format:'ISBN,copynumber',ISBN should be a 13-digit number", output1.getOutput());
		}
	}
	
	@Test
	public void testDeleteItemThatIsInLoan() {
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
				out = input.processInput(DELETEITEM, output1.getState());
			}else{
				fail("");
			}
			System.out.println(out.getOutput());
			System.out.println(output1.getState());
		
			if(out.getState() == InputHandler.DELETEITEM && out.getOutput() != null) {
				output1 = output.deleteItem("9781442668584,1");
			}else{
				fail("You did not select to delete an item");
			}
			assertEquals("Active Loan Exists!", output1.getOutput());
		}
	}
	
	
}
