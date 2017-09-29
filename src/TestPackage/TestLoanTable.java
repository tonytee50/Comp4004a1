package TestPackage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import server.logic.tables.LoanTable;

public class TestLoanTable {
	
	LoanTable loanTable;
	LoanTable loanTable2;

	@Before
	public void setUp() throws Exception {
		
		loanTable = LoanTable.getInstance();
		loanTable2 = LoanTable.getInstance();
		
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
		assertFalse(loanTable.checkLoan("9781442668584"));
		assertTrue(loanTable.checkLoan("1234"));
		
	}

}
