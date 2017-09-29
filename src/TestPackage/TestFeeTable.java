package TestPackage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import server.logic.tables.FeeTable;

public class TestFeeTable {

	FeeTable newFee;
	
	@Before
	public void setUp() throws Exception {
		
		newFee = new FeeTable();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		//test constructor
		assertNotNull(new FeeTable());		
	}

}
