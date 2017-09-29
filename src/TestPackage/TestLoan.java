package TestPackage;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import server.logic.model.Loan;

public class TestLoan {

	Loan firstLoan;
	Date date;
	
	@Before
	public void setUp() throws Exception {
		date = new Date();
		firstLoan = new Loan(123, "1234567890123", "10", date, "Good");
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		//Test toString method
	//	assertEquals("[123,1234567890123,10, ")
		
		//Test getUserID method
		assertEquals(123, firstLoan.getUserid());
		
		//Test getISBN method
		assertEquals("1234567890123", firstLoan.getIsbn());
		
		//Test getCopyNumber
		assertEquals("10", firstLoan.getCopynumber());
		
	}

}
