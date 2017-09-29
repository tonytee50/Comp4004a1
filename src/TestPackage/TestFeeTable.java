package TestPackage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
	public void test() {
		
		//test constructor
		assertNotNull(new FeeTable());
		
		
		//testing checkUser method
		assertEquals(true, newFee.checkuser(0));
		assertEquals(false, newFee.checkuser(1));
		
		//test getInstance
		assertEquals(newFee.getInstance(), newFee2.getInstance());
		
	}
	
}
