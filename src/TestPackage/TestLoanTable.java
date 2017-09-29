package TestPackage;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import server.logic.model.Loan;
import server.logic.tables.LoanTable;

public class TestLoanTable {
	
	LoanTable loanTable;
	LoanTable loanTable2;
	Date date;

	@Before
	public void setUp() throws Exception {
		
		loanTable = LoanTable.getInstance();
		loanTable2 = LoanTable.getInstance();
		date = new Date();	
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructor() {
		//test constructor
		assertNotNull(LoanTable.getInstance());
		assertNotNull(loanTable);
	}
	
	@Test
	public void testInstance() {
		//test getInstance method
		assertEquals(loanTable.getInstance(), loanTable2.getInstance());
		assertEquals(LoanTable.getInstance(), LoanTable.getInstance());
	}
	
	@Test
	public void testCheckLoan() {
		//test checkLoan method
		Loan loan=new Loan(0,"9781442668584","1",new Date(),"0");
		loanTable2.loanList.add(loan);
		assertTrue(loanTable.checkLoan("1234","1"));
		System.out.println(loanTable.loanList);
		assertFalse(loanTable2.checkLoan("9781442668584", "1"));
	}
	
	@Test
	public void testReturnItem() {
		assertEquals("success",loanTable.returnItem(0,"9781442668584","1", date));
		assertEquals("The Loan Does Not Exist", loanTable.returnItem(0, "4321", "2", date));
	}
	
}
