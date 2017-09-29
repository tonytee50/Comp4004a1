package TestPackage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import server.logic.model.Item;

public class TestItem {
	
	Item firstItem;
	Item secondItem;

	@Before
	public void setUp() throws Exception {
		
		firstItem = new Item(0, "1234567891023");
		secondItem = new Item(22, "");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		//test toString method
		assertEquals("[0,1234567891023]", firstItem.toString());
		assertEquals("[22,]", secondItem.toString());
			
	
		//test getItemID method
		assertEquals(0, firstItem.getItemid());
		assertEquals(22, secondItem.getItemid());
		
	}

}
