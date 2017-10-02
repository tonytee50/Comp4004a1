package TestPackage;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import server.logic.model.Loan;

public class TestLoan {

	Loan firstLoan;
	Date date;
	DateFormat format1;
	
	@Before
	public void setUp() throws Exception {
		date = new Date();
		firstLoan = new Loan(123, "1234567890123", "10", date, "1");
		format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testToString() {
		//Test toString method
		assertEquals("[123,1234567890123,10," + format1.format(date) + ",1]", firstLoan.toString());
	}
	
	
	@Test
	public void testUserID() {
		//Test getUserID method
		assertEquals(123, firstLoan.getUserid());
	}
	
	@Test
	public void testISBNGetter() {
		//Test getISBN method
		assertEquals("1234567890123", firstLoan.getIsbn());
	}
	
	@Test
	public void testCopyNumber() {
		//Test getCopyNumber method
		assertEquals("10", firstLoan.getCopynumber());
	}
	
	@Test
	public void testGetDate() {
		//test getDate method
		assertEquals(date, firstLoan.getDate());
	}
	
	@Test
	public void testRenewState() {
		//test getRenewstate method
		assertEquals("1", firstLoan.getRenewstate());
	}
	
	@Test 
	public void testSetters() {
		assertEquals(123, firstLoan.getUserid());
		assertEquals("1234567890123", firstLoan.getIsbn());
		assertEquals("10", firstLoan.getCopynumber());
		assertEquals(date, firstLoan.getDate());
		assertEquals("1", firstLoan.getRenewstate());
		
		firstLoan.setUserid(1234);
		firstLoan.setIsbn("1212121212121");
		firstLoan.setCopynumber("11");
		firstLoan.setDate(null);
		firstLoan.setRenewstate("2");
		
		assertEquals(1234, firstLoan.getUserid());
		assertEquals("1212121212121", firstLoan.getIsbn());
		assertEquals("11", firstLoan.getCopynumber());
		assertEquals(null, firstLoan.getDate());
		assertEquals("2", firstLoan.getRenewstate());
		
	}
	
}
