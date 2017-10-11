package AcceptanceTesting;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import server.logic.handler.InputHandler;
import server.logic.handler.OutputHandler;
import server.logic.handler.model.Output;
import server.logic.handler.model.ServerOutput;

public class TestPayFine {
	public static final String INPUT = "user";
	public static final String PAYFINE = "pay fine";

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSuccess() {
		InputHandler input = new InputHandler();
		ServerOutput out = new ServerOutput("", 0);
		OutputHandler output = new OutputHandler();
		
		if(input.processInput("", InputHandler.WAITING) == null) {
			fail("");
		}
		
		out = input.processInput(INPUT, InputHandler.FINISHWAITING);
		Output output1;
		
		if(out.getState() == InputHandler.USERLOGIN) {
			output1 = output.userLogin("Yu@carleton.ca,Yu");
			if(output1.getState() == OutputHandler.USER) {
				out = input.processInput(PAYFINE, output1.getState());
			}else{
				fail("");
			}
			System.out.println(out.getOutput());
			System.out.println(output1.getState());
		
			if(out.getState() == InputHandler.PAYFINE && out.getOutput() != null) {
				output1 = output.payFine("Yu@carleton.ca");
			}else{
				fail("You did not select to create a user");
			}
			assertEquals("Success!", output1.getOutput());
		}
		
	}
	
	@Test
	public void testWhenUserBorrowingItem() {
		InputHandler input = new InputHandler();
		ServerOutput out = new ServerOutput("", 0);
		OutputHandler output = new OutputHandler();
		
		if(input.processInput("", InputHandler.WAITING) == null) {
			fail("");
		}
		
		out = input.processInput(INPUT, InputHandler.FINISHWAITING);
		Output output1;
		
		if(out.getState() == InputHandler.USERLOGIN) {
			output1 = output.userLogin("Zhibo@carleton.ca,Zhibo");
			if(output1.getState() == OutputHandler.USER) {
				out = input.processInput(PAYFINE, output1.getState());
			}else{
				fail("");
			}
			System.out.println(out.getOutput());
			System.out.println(output1.getState());
		
			if(out.getState() == InputHandler.PAYFINE && out.getOutput() != null) {
				output1 = output.payFine("Zhibo@carleton.ca");
			}else{
				fail("You did not select to create a user");
			}
			assertEquals("Borrowing Items Exist!", output1.getOutput());
		}
	}
}
