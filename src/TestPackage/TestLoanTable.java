package TestPackage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import server.logic.tables.LoanTable;

public class TestLoanTable {
	
	LoanTable loanTable;

	@Before
	public void setUp() throws Exception {
		
		loanTable = new LoanTable();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		//test constructor
		assertNotNull(new LoanTable());
		assertNotNull(loanTable);
		
	}

}
