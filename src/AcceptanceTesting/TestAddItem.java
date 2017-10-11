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

public class TestAddItem {
	public static final String INPUT = "clerk";
	public static final String CREATEITEM = "create item";
	public static String CREATETITLE;
	@Before
	public void setUp() throws Exception {
		CREATETITLE  = "create title";
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddItemSuccessfully() {
		InputHandler input = new InputHandler();
		ServerOutput out = new ServerOutput("", 0);
		OutputHandler output = new OutputHandler();
		
		out = input.processInput(INPUT, InputHandler.FINISHWAITING);
		Output output1;
		
		if(out.getState() == InputHandler.CLERKLOGIN) {
			output1 = output.clerkLogin(Config.CLERK_PASSWORD);
			if(output1.getState() == OutputHandler.CLERK) {
				out = input.processInput(CREATEITEM, output1.getState());
			}else{
				fail("");
			}
			System.out.println(out.getOutput());
			System.out.println(output1.getState());
		
			if(out.getState() == InputHandler.CREATEITEM && out.getOutput() != null) {
				output1 = output.createItem("9781442616899");
			}
			assertEquals("Success!", output1.getOutput());
		}
	}
	
	@Test
	public void testAddItemThatDoesntExist() {
		InputHandler input = new InputHandler();
		ServerOutput out = new ServerOutput("", 0);
		OutputHandler output = new OutputHandler();
		
		out = input.processInput(INPUT, InputHandler.FINISHWAITING);
		Output output1;
		
		if(out.getState() == InputHandler.CLERKLOGIN) {
			output1 = output.clerkLogin(Config.CLERK_PASSWORD);
			if(output1.getState() == OutputHandler.CLERK) {
				out = input.processInput(CREATEITEM, output1.getState());
			}else{
				fail("");
			}
			System.out.println(out.getOutput());
			System.out.println(output1.getState());
		
			if(out.getState() == InputHandler.CREATEITEM && out.getOutput() != null) {
				output1 = output.createItem("1234565432121");
			}
			if(output1.getState() == InputHandler.CREATETITLE) {
				if(input.processInput("", InputHandler.WAITING) == null) {
					fail("");
				}
				
				out = input.processInput("create title", InputHandler.CLERK);
				if(out.getState() == InputHandler.CREATETITLE && out.getOutput() != null) {
					output1 = output.createTitle("1222111444557,The COMP 4004");
				}
			}
			if(output1.getState() == OutputHandler.CLERK) {
				out = input.processInput(CREATEITEM, output1.getState());
			}else{
				fail("");
			}
			System.out.println(out.getOutput());
			System.out.println(output1.getState());
		
			if(out.getState() == InputHandler.CREATEITEM && out.getOutput() != null) {
				output1 = output.createItem("1222111444557");
				assertEquals("Success!", output1.getOutput());
			}
		}
	}
	
	@Test
	public void addItemWithIncorrectISBN() {
		InputHandler input = new InputHandler();
		ServerOutput out = new ServerOutput("", 0);
		OutputHandler output = new OutputHandler();
		
		out = input.processInput(INPUT, InputHandler.FINISHWAITING);
		Output output1;
		
		if(out.getState() == InputHandler.CLERKLOGIN) {
			output1 = output.clerkLogin(Config.CLERK_PASSWORD);
			if(output1.getState() == OutputHandler.CLERK) {
				out = input.processInput(CREATEITEM, output1.getState());
			}else{
				fail("");
			}
			System.out.println(out.getOutput());
			System.out.println(output1.getState());
		
			if(out.getState() == InputHandler.CREATEITEM && out.getOutput() != null) {
				output1 = output.createItem("97814426168");
			}
			assertEquals("Your input should be in this format:'ISBN',ISBN should be a 13-digit number", output1.getOutput());
		}
	}

}
