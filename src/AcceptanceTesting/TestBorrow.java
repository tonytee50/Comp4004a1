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

public class TestBorrow {
	public static final String INPUT = "user";
	public static final String BORROW = "borrow";

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBorrowBookSuccessfully() {
		InputHandler input = new InputHandler();
		ServerOutput out = new ServerOutput("", 0);
		OutputHandler output = new OutputHandler();
		
		if(input.processInput("", InputHandler.WAITING) == null) {
			fail("");
		}
		
		out = input.processInput(INPUT, InputHandler.FINISHWAITING);
		Output output1;
		
		if(out.getState() == InputHandler.USERLOGIN) {
			output1 = output.userLogin("Michelle@carleton.ca,Michelle");
			if(output1.getState() == OutputHandler.USER) {
				out = input.processInput(BORROW, output1.getState());
			}else{
				fail("");
			}
			System.out.println(out.getOutput());
			System.out.println(output1.getState());
		
			if(out.getState() == InputHandler.BORROW && out.getOutput() != null) {
				output1 = output.borrow("Michelle@carleton.ca,9781442616899,1");
			}else{
				fail("You did not select to create a user");
			}
			assertEquals("Success!", output1.getOutput());
		}
	}
	
	@Test
	public void testBorrowWithOutstandingFees() {
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
				out = input.processInput(BORROW, output1.getState());
			}else{
				fail("");
			}
			System.out.println(out.getOutput());
			System.out.println(output1.getState());
		
			if(out.getState() == InputHandler.BORROW && out.getOutput() != null) {
				output1 = output.borrow("Yu@carleton.ca,9781442616899,1");
			}else{
				fail("You did not select to create a user");
			}
			assertEquals("Outstanding Fee Exists!", output1.getOutput());
		}
	}
	
	@Test
	public void BorrowItemThatDoesntExist() {
		InputHandler input = new InputHandler();
		ServerOutput out = new ServerOutput("", 0);
		OutputHandler output = new OutputHandler();
		
		if(input.processInput("", InputHandler.WAITING) == null) {
			fail("");
		}
		
		out = input.processInput(INPUT, InputHandler.FINISHWAITING);
		Output output1;
		
		if(out.getState() == InputHandler.USERLOGIN) {
			output1 = output.userLogin("Kevin@carleton.ca,Kevin");
			if(output1.getState() == OutputHandler.USER) {
				out = input.processInput(BORROW, output1.getState());
			}else{
				fail("");
			}
			System.out.println(out.getOutput());
			System.out.println(output1.getState());
		
			if(out.getState() == InputHandler.BORROW && out.getOutput() != null) {
				output1 = output.borrow("Kevin@carleton.ca,9781442616889,1");
			}else{
				fail("You did not select to create a user");
			}
			assertEquals("ISBN Invalid!", output1.getOutput());
		}
	}

}
