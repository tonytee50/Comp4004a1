package TestPackage;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import server.logic.model.Fee;
import server.logic.tables.FeeTable;
import server.logic.tables.LoanTable;

public class TestFeeTable {

	FeeTable newFee;
	FeeTable newFee2;
	
	@Before
	public void setUp() throws Exception {
		
		newFee = new FeeTable();
		newFee2 = new FeeTable();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructor() {
		
		//test constructor
		assertNotNull(new FeeTable());		
	}
	
	@Test
	public void testCheckUserMethod() {
		//testing checkUser method
		assertEquals(true, newFee.checkuser(0));
		assertEquals(false, newFee.checkuser(2));
	}
	
	@Test
	public void testGetInstance() {
		//test getInstance
		assertEquals(FeeTable.getInstance(), FeeTable.getInstance());
		assertEquals(FeeTable.getInstance(), FeeTable.getInstance());
		assertNotNull(FeeTable.getInstance());
	}
	
	@Test
	public void testLookUpMethod() {
		//test lookup method
		assertTrue(newFee.lookup(2));
		assertFalse(newFee.lookup(0));
	}
	
	@Test
	public void testLookupFee() {
		//test lookupFee method
		assertEquals(5, newFee.lookupfee(0));
		
		for(int i = 2; i<10;i++) {
			assertEquals(0, newFee.lookupfee(i));
		}
	}
	
	
	@Test
	public void testGetFeeTable() {
		//test getFeeTable method
		assertEquals(newFee.feeList, newFee.getFeeTable());
		Fee otherFee = new Fee(1,6);
		newFee2.feeList.add(otherFee);
		assertEquals(newFee2.feeList, newFee2.getFeeTable());
	}
	
	@Test
	public void testPayFine() {
		for(int i = 0; i<newFee.feeList.size(); i++) {
			if (i == 0) {
				assertEquals("Borrowing Items Exist", newFee.payfine(i));	
			}else if (i == 1) {
				assertEquals("success", newFee.payfine(i));
			}else{
				fail("This failed.");
			}
		}
		
		
	}
	
	@Test
	public void testApplyFee() {
		assertEquals(5, newFee.feeList.get(0).getFee());
		newFee.applyfee(newFee.feeList.get(0).getUserid(), 10000000);
		//now check if it applied the fee for user 
		assertEquals(166, newFee.feeList.get(0).getFee());
		
		assertEquals(3, newFee.feeList.get(1).getFee());
		newFee.applyfee(newFee.feeList.get(1).getUserid(), 100);
		//now make sure it didn't apply the fee when it wasn't supposed to
		assertEquals(3, newFee.feeList.get(1).getFee());
		
	}
	
	@Test
	public void testInitialization() {
		Date date = new Date();
		LoanTable loan = LoanTable.getInstance();
		loan.createloan(4, "9781611687910", "1", date);
		newFee.Initialization();
		assertEquals(3, newFee.feeList.size());
	}
	
}
