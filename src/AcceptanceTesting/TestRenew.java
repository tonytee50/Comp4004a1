package AcceptanceTesting;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import server.logic.handler.InputHandler;
import server.logic.handler.OutputHandler;
import server.logic.handler.model.Output;
import server.logic.handler.model.ServerOutput;
import server.logic.model.Loan;
import server.logic.tables.LoanTable;

public class TestRenew {
	public static final String INPUT = "user";
	public static final String RENEW = "renew";
	
	static LoanTable table;
	static Loan loan;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		table = LoanTable.getInstance();
		loan = new Loan(3, "9781442667181", "1", new Date(), "0");
		table.loanList.add(loan);
		
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRenewBookWithFee() {
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
				out = input.processInput(RENEW, output1.getState());
			}else{
				fail("");
			}
			System.out.println(out.getOutput());
			System.out.println(output1.getState());
		
			if(out.getState() == InputHandler.RENEW && out.getOutput() != null) {
				output1 = output.renew("Zhibo@carleton.ca,9781442668584,1");
			}else{
				fail("You did not select to create a user");
			}
			assertEquals("Outstanding Fee Exists!", output1.getOutput());
		}
	}
	
	@Test
	public void testRenewBookSuccessful() {
		
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
				out = input.processInput(RENEW, output1.getState());
			}else{
				fail("");
			}
			System.out.println(out.getOutput());
			System.out.println(output1.getState());
		
			if(out.getState() == InputHandler.RENEW && out.getOutput() != null) {
				output1 = output.renew("Kevin@carleton.ca,9781442667181,1");
			}else{
				fail("You did not select to create a user");
			}
			assertEquals("Success!", output1.getOutput());
		}
	}
	
	@Test
	public void testRenewBookTwice() {
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
				out = input.processInput(RENEW, output1.getState());
			}else{
				fail("");
			}
			System.out.println(out.getOutput());
			System.out.println(output1.getState());
		
			if(out.getState() == InputHandler.RENEW && out.getOutput() != null) {
				output1 = output.renew("Kevin@carleton.ca,9781442667181,1");
			}else{
				fail("You did not select to create a user");
			}
			assertEquals("Renewed Item More Than Once for the Same Loan!", output1.getOutput());
		}
	}

}
