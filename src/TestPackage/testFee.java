package TestPackage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import server.logic.model.Fee;

public class testFee {

	Fee firstFee;
	Fee secondFee;
	
	@Before
	public void setUp() throws Exception {
		firstFee = new Fee(1234, 12);
		secondFee = new Fee(99997771, 0);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		//test toString method
		assertEquals("[1234,12]", firstFee.toString());
		assertEquals("[99997771,0]", secondFee.toString());
		
		//test getUserID method
		assertEquals(1234, firstFee.getUserid());
		assertEquals(99997771, secondFee.getUserid());
		
		//test getFee method
		assertEquals(0, secondFee.getFee());
		assertEquals(12, firstFee.getFee());
	}

}

