package AcceptanceTesting;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import server.logic.handler.InputHandler;
import server.logic.handler.OutputHandler;
import server.logic.handler.model.Output;
import server.logic.handler.model.ServerOutput;

public class TestReturn {

	public static final String INPUT = "user";
	public static final String RETURN = "return";
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReturnSuccessfully() {
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
				out = input.processInput(RETURN, output1.getState());
			}else{
				fail("");
			}
			System.out.println(out.getOutput());
			System.out.println(output1.getState());
		
			if(out.getState() == InputHandler.RETURN && out.getOutput() != null) {
				output1 = output.returnBook("Zhibo@carleton.ca,9781442668584,1");
			}else{
				fail("You did not select the return option");
			}
			assertEquals("Success!", output1.getOutput());
		}
	}
	
	@Test
	public void testReturnWithoutLoan() {
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
				out = input.processInput(RETURN, output1.getState());
			}else{
				fail("");
			}
			System.out.println(out.getOutput());
			System.out.println(output1.getState());
		
			if(out.getState() == InputHandler.RETURN && out.getOutput() != null) {
				output1 = output.returnBook("Michelle@carleton.ca,9781442668584,1");
			}else{
				fail("You did not select the return option");
			}
			assertEquals("The Loan Does Not Exist!", output1.getOutput());
		}
	}
	
	@Test
	public void testReturnIncorrectly() {
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
				out = input.processInput(RETURN, output1.getState());
			}else{
				fail("");
			}
			System.out.println(out.getOutput());
			System.out.println(output1.getState());
		
			if(out.getState() == InputHandler.RETURN && out.getOutput() != null) {
				output1 = output.returnBook("Michelle@carleton.ca,97814668584,1");
			}else{
				fail("You did not select the return option");
			}
			assertEquals("Your input should be in this format:'useremail,ISBN,copynumber'", output1.getOutput());
		}
	}
}
