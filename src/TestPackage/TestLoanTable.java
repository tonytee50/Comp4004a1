package TestPackage;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import server.logic.model.Loan;
import server.logic.tables.FeeTable;
import server.logic.tables.ItemTable;
import server.logic.tables.LoanTable;
import server.logic.tables.TitleTable;
import server.logic.tables.UserTable;

public class TestLoanTable {
	
	LoanTable loanTable;
	LoanTable loanTable2;
	Date date;
	DateFormat format1;

	@Before
	public void setUp() throws Exception {
		
		loanTable = LoanTable.getInstance();
		loanTable2 = LoanTable.getInstance();
		date = new Date();	
		format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testCheckUser() {
		for(int i = 0; i<loanTable.loanList.size(); i++) {
			assertEquals(false, loanTable.checkUser(loanTable.loanList.get(i).getUserid()));
		}
		//check if user isn't in the loanTable it should return true
		assertEquals(true, loanTable.checkUser(123));
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
		Loan loan=new Loan(0,"9781442668585","1",new Date(),"0");
		loanTable2.loanList.add(loan);
		assertTrue(loanTable.checkLoan("1234","1"));
		System.out.println(loanTable.loanList);
		assertFalse(loanTable2.checkLoan("9781442668585", "1"));
	}
	
	@Test
	public void testReturnItem() {
		assertEquals("success",loanTable.returnItem(0,"9781442668584","1", date));
		assertEquals("The Loan Does Not Exist", loanTable.returnItem(0, "4321", "2", date));
	}
	
	@Test
	public void testGetLoanTable() {
		assertEquals(loanTable.loanList, loanTable.getLoanTable());
		assertEquals(loanTable2.loanList, loanTable.getLoanTable());
		assertEquals(loanTable2.loanList, loanTable2.getLoanTable());
		assertEquals(1, loanTable.getLoanTable().size());
	}
	
	@Test
	public void testLookLimit() {
		Loan loan=new Loan(2,"9781442668585","1",new Date(),"2");
		loanTable.loanList.add(loan);
		assertTrue(loanTable.looklimit(4));
		assertFalse(loanTable.looklimit(2));
		
	}

	@Test
	public void testCheckLoan1() {
		//test checkLoan method
		Loan loan=new Loan(2,"9781442668525","1",new Date(),"0");
		loanTable2.loanList.add(loan);
		assertTrue(loanTable.checkLoan("1234"));
		System.out.println(loanTable.loanList);
		assertFalse(loanTable2.checkLoan("9781442668584"));
	}
	
	@Test
	public void testLookup() {
		for(int i=0; i<loanTable.loanList.size(); i++) {
			assertEquals(false, loanTable.lookup(loanTable.loanList.get(i).getIsbn(), loanTable.loanList.get(i).getCopynumber()));
			assertEquals(true, loanTable.lookup(loanTable.loanList.get(i).getIsbn()+100, loanTable.loanList.get(i).getCopynumber()+100));
		}
	}
	
	@Test
	public void dateFormat() {
		assertEquals(format1.format(date), loanTable.dateformat(date));
	}
	
	@Test
	public void testCheckLimit() {
		for(int i=0; i<loanTable.loanList.size(); i++) {
			assertEquals(true, loanTable.checkLimit(loanTable.loanList.get(i).getUserid()));
		}
		Loan loan=new Loan(1,"9781442668584","1",new Date(),"0");
    	loanTable.loanList.add(loan);
    	loanTable.loanList.add(loan);
    	loanTable.loanList.add(loan);
    	assertEquals(false, loanTable.checkLimit(loanTable.loanList.get(2).getUserid()));
	}
	
	@Test
	public void testCreateLoan() {
		//test the different cases
		UserTable userTable = UserTable.getInstance();
		TitleTable titleTable = TitleTable.getInstance();
		ItemTable itemTable = ItemTable.getInstance();
		FeeTable feeTable = FeeTable.getInstance();
		
		for(int i = 0; i<userTable.userList.size(); i++) {
			assertEquals("User Invalid", loanTable.createloan(userTable.userList.get(i).getUserid()+100, "", "", date));
			assertEquals("ISBN Invalid",loanTable.createloan(userTable.userList.get(i).getUserid(), "", "", date));
		}
		for(int i = 0; i<itemTable.itemList.size(); i++) {
			assertEquals("Copynumber Invalid",loanTable.createloan(userTable.userList.get(i).getUserid(), itemTable.itemList.get(i).getISBN(), "", date));
		}
		
		assertEquals("The Item is Not Available", loanTable.createloan(userTable.userList.get(0).getUserid(), loanTable.loanList.get(0).getIsbn(), loanTable.loanList.get(0).getCopynumber(), date));
		assertEquals("success", loanTable.createloan(2, "9781442616899", "1", date));
		assertEquals("The Maximun Number of Items is Reached", loanTable.createloan(1, "9781442667181", "1", date));
	}
	
	@Test
	public void testRenewal() {
		//test the different cases
		
		//test when max number of items reached
		assertEquals("The Maximun Number of Items is Reached", loanTable.renewal(loanTable.loanList.get(0).getUserid(), loanTable.loanList.get(0).getIsbn(), loanTable.loanList.get(0).getCopynumber(), date));
		
		//test when loan doesn't exist
		assertEquals("The loan does not exist", loanTable.renewal(loanTable.loanList.get(3).getUserid(), loanTable.loanList.get(0).getIsbn(), loanTable.loanList.get(0).getCopynumber(), date));
		
		//test for success
		assertEquals("success", loanTable.renewal(loanTable.loanList.get(3).getUserid(), loanTable.loanList.get(3).getIsbn(), loanTable.loanList.get(3).getCopynumber(), date));
		
		
	}
	
}
