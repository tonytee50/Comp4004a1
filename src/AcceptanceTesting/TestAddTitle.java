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

public class TestAddTitle {
	public static String INPUT;
	public static String CREATETITLE;
	
	@Before
	public void setUp() throws Exception {
		INPUT = "clerk";
		CREATETITLE  = "create title";
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testAddTitleSuccess() {
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
				out = input.processInput(CREATETITLE, output1.getState());
			}else{
				fail("");
			}
			System.out.println(out.getOutput());
			System.out.println(output1.getState());
		
			if(out.getState() == InputHandler.CREATETITLE && out.getOutput() != null) {
				output1 = output.createTitle("1222111444554,The COMP 4004");
			}
			assertEquals("Success!", output1.getOutput());
		}
	}
	
	@Test
	public void testAddTitleThatAlreadyExists() {
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
				out = input.processInput(CREATETITLE, output1.getState());
			}else{
				fail("");
			}
			System.out.println(out.getOutput());
			System.out.println(output1.getState());
		
			if(out.getState() == InputHandler.CREATETITLE && out.getOutput() != null) {
				output1 = output.createTitle("9781442668584,The Volcanoes");
			}
			assertEquals("The Title Already Exists!", output1.getOutput());
		}
	}
	
	@Test
	public void testAddTitleIncorrectly() {
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
				out = input.processInput(CREATETITLE, output1.getState());
			}else{
				fail("");
			}
			System.out.println(out.getOutput());
			System.out.println(output1.getState());
		
			if(out.getState() == InputHandler.CREATETITLE && out.getOutput() != null) {
				output1 = output.createTitle("The Good Man,1234324565431");
			}
			assertEquals("Your input should be in this format:'ISBN,title',ISBN should be a 13-digit number", output1.getOutput());
		}
	}

}
