package TestPackage;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import server.logic.handler.OutputHandler;
import server.logic.handler.model.Output;
import server.logic.model.Loan;
import server.logic.tables.LoanTable;

public class TestOutputHandler {
	
	OutputHandler outputHand;

	@Before
	public void setUp() throws Exception {
		outputHand = new OutputHandler();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateUser() {
		Output out = new Output("Your input should be in this format:'username,password'", 4);
		assertEquals(out.toString(), outputHand.createUser("Antony,password").toString());
		Output out1 = new Output("Success!", 2);
		assertEquals(out1.toString(), outputHand.createUser("tony.tamer@carleton.ca, MyPass").toString());
		Output out2 = new Output("The User Already Exists!", 2);
		assertEquals(out2.toString(), outputHand.createUser("tony.tamer@carleton.ca, MyPass").toString());
	}
	
	@Test
	public void testIsInteger() {
		//This is meant to make sure ISBN is 13 digits long
		assertTrue(OutputHandler.isInteger("1243212345676"));
		assertFalse(OutputHandler.isInteger("123456789"));
		assertFalse(OutputHandler.isInteger("1234567823414312439"));
		assertFalse(OutputHandler.isInteger("000000000000000"));
	}
	
	@Test
	public void testCreateItem() {
		Output out = new Output("Your input should be in this format:'ISBN',ISBN should be a 13-digit number", 6);
		assertEquals(out.toString(), outputHand.createItem("123456789123456").toString());
		
		Output out1 = new Output("The Title Does Not Exists!\nPlease add it!", 5);
		assertEquals(out1.toString(), outputHand.createItem("1234567891234").toString());
		
		Output out2 = new Output("Success!", 2);
		assertEquals(out2.toString(), outputHand.createItem("9781442668584").toString());
		
	}
	
	@Test
	public void testDeleteUser() {
		Output out = new Output("Your input should be in this format:'useremail'", 7);
		assertEquals(out.toString(), outputHand.deleteUser("tonytamer").toString());
		
		Output out1 = new Output("Success!", 2);
		assertEquals(out1.toString(), outputHand.deleteUser("tony.tamer@carleton.ca").toString());
		
		Output out2 = new Output("The User Does Not Exist!", 7);
		assertEquals(out2.toString(), outputHand.deleteUser("tony.tamer111@carleton.ca").toString());
	}
	
	@Test
	public void testDeleteTitle() {
		Output out = new Output("Your input should be in this format:'ISBN',ISBN should be a 13-digit number", 8);
		assertEquals(out.toString(), outputHand.deleteTitle("1234").toString());
		
		Output out1 = new Output("The Title Does Not Exist!", 2);
		assertEquals(out1.toString(), outputHand.deleteTitle("1234123456789").toString());
		
		Output out2 = new Output("Success!", 2);
		assertEquals(out2.toString(), outputHand.deleteTitle("9781442616899").toString());
	}
	
	@Test
	public void testisNumber() {
		assertFalse(outputHand.isNumber("abfdr5"));
		assertTrue(outputHand.isNumber("123453"));
		assertFalse(outputHand.isNumber("12312a32"));
	}
	
	@Test
	public void testDeleteItem() {
		Output out = new Output("Your input should be in this format:'ISBN,copynumber',ISBN should be a 13-digit number", 9);
		assertEquals(out.toString(), outputHand.deleteItem("Hello mates!").toString());
		assertEquals(out.toString(), outputHand.deleteItem("1,1234312345678").toString());
		
		Output out1 = new Output("Success!", 2);
		assertEquals(out1.toString(), outputHand.deleteItem("9781442667181,1").toString());
	}
	
	@Test
	public void testborrow() {
		Output out = new Output("Your input should be in this format:'useremail,ISBN,copynumber'", 10);
		assertEquals(out.toString(), outputHand.borrow("1234,vdsdsf,1").toString());
		
		Output out1 = new Output("The User Does Not Exist!", 3);
		assertEquals(out1.toString(), outputHand.borrow("tony.tamer@carleton.ca,123,1").toString());
		
	}
	
	@Test
	public void testReniew() {
		
		Date date = new Date();
		Loan myLoan = new Loan(3, "2343234323432", "1", date, "0");
		LoanTable loanTable = LoanTable.getInstance();
		loanTable.loanList.add(myLoan);
		
		Output out = new Output("Your input should be in this format:'useremail,ISBN,copynumber'", 11);
		assertEquals(out.toString(), outputHand.renew("tony.tamercarleton.ca,123,1").toString());
		
		Output out1 = new Output("The User Does Not Exist!", 11);
		assertEquals(out1.toString(), outputHand.renew("tony.tamer@111carleton.ca,1234321456784,1").toString());
		
		Output out2 = new Output("Success!", 3);
		assertEquals(out2.toString(), outputHand.renew("Kevin@carleton.ca,2343234323432,1").toString());
		
	}
	
	@Test
	public void testReturnBook() {
		Output out = new Output("Your input should be in this format:'useremail,ISBN,copynumber'", 12);
		assertEquals(out.toString(), outputHand.returnBook("tonytamer,1234321234321,1").toString());
		
		Output out2 = new Output("Success!", 3);
		assertEquals(out2.toString(), outputHand.returnBook("Zhibo@carleton.ca,9781442668584,1").toString());
		
	}
	
	@Test
	public void testPayFine() {
		Output out = new Output("Your input should be in this format:'useremail'", 13);
		assertEquals(out.toString(), outputHand.payFine("tonytamer,1234321234321,1").toString());
		
		Output out1 = new Output("The User Does Not Exist!", 13);
		assertEquals(out1.toString(), outputHand.payFine("tony.fake@carleton.ca").toString());
		
		Output out2 = new Output("Success!", 3);
		assertEquals(out2.toString(), outputHand.payFine("Yu@carleton.ca").toString());
	}
	
	@Test
	public void testClerkLogin() {
		Output out = new Output("What can I do for you?Menu:Create User/Title/Item,Delete User/Title/Item.", 2);
		assertEquals(out.toString(), outputHand.clerkLogin("admin").toString());
		
		Output out1 = new Output("Wrong Password!Please Input The Password:", 14);
		assertEquals(out1.toString(), outputHand.clerkLogin("NotAdmin").toString());
	}
	
	@Test
	public void testUserLogin() {
		Output out = new Output("Your input should be in this format:'username,password'", 15);
		assertEquals(out.toString(), outputHand.userLogin("hello,password").toString());
		
		Output out1 = new Output("What can I do for you?Menu:Borrow,Renew,Return,Pay Fine.", 3);
		assertEquals(out1.toString(), outputHand.userLogin("Zhibo@carleton.ca,Zhibo").toString());
		
		Output out2 = new Output("Wrong Password!Please Input Username and Password:'username,password'", 15);
		assertEquals(out2.toString(), outputHand.userLogin("Zhibo@carleton.ca,Zhibozz").toString());
		
		Output out3 = new Output("The User Does Not Exist!Please The Username and Password:'username,password'", 15);
		assertEquals(out3.toString(), outputHand.userLogin("Zhibozzz@carleton.ca,Zhibo").toString());
	}
	
	@Test
	public void testCreateTitle() {
		Output out = new Output("Your input should be in this format:'ISBN,title',ISBN should be a 13-digit number", 5);
		assertEquals(out.toString(), outputHand.createTitle("123,title").toString());
		
		Output out1 = new Output("Success!", 2);
		assertEquals(out1.toString(), outputHand.createTitle("1222222221113, THe Title").toString());
		
		Output out2 = new Output("The Title Already Exists!", 2);
		assertEquals(out2.toString(), outputHand.createTitle("1222222221113, THe Title").toString());
		
	}

}
