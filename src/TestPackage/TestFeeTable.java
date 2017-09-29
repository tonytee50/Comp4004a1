package TestPackage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import server.logic.model.Fee;
import server.logic.tables.FeeTable;

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
		assertEquals(false, newFee.checkuser(1));
	}
	
	@Test
	public void testGetInstance() {
		//test getInstance
		assertEquals(newFee.getInstance(), newFee2.getInstance());
	}
	
	@Test
	public void testLookUpMethod() {
		//test lookup method
		assertTrue(newFee.lookup(1));
		assertFalse(newFee.lookup(0));
	}
	
	@Test
	public void testLookupFee() {
		//test lookupFee method
		assertEquals(5, newFee.lookupfee(0));	
	}
	
	
	@Test
	public void testGetFeeTable() {
		//test getFeeTable method
		assertEquals(newFee.feeList, newFee.getFeeTable());
		Fee otherFee = new Fee(1,6);
		newFee2.feeList.add(otherFee);
		assertEquals(newFee2.feeList, newFee2.getFeeTable());
	}
	
}
