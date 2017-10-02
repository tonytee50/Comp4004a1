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
	public void testToString() {
		//test toString method
		assertEquals("[1234,12]", firstFee.toString());
		assertEquals("[99997771,0]", secondFee.toString());
		
		//test getFee method
		assertEquals(0, secondFee.getFee());
		assertEquals(12, firstFee.getFee());
	}
	
	@Test 
	public void testUserIDGetter(){
		//test getUserID method
		assertEquals(1234, firstFee.getUserid());
		assertEquals(99997771, secondFee.getUserid());
	}
	
	@Test
	public void testGetFee() {
		//test getFee method
		assertEquals(0, secondFee.getFee());
		assertEquals(12, firstFee.getFee());		
	
	}
	
	@Test
	public void testSetters() {
		assertEquals(1234, firstFee.getUserid());
		assertEquals(12, firstFee.getFee());
		
		firstFee.setFee(13);
		firstFee.setUserid(123);
		
		assertEquals(123, firstFee.getUserid());
		assertEquals(13, firstFee.getFee());
		
	}

}

