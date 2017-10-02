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
		
		firstItem = new Item(0, "1234567891023","1");
		secondItem = new Item(22, "","2");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testToString() {
		//test toString method
		assertEquals("[0,1234567891023,1]", firstItem.toString());
		assertEquals("[22,,2]", secondItem.toString());	

	}
	
	@Test
	public void testGetterItemID() {
		//test getItemID method
		assertEquals(0, firstItem.getItemid());
		assertEquals(22, secondItem.getItemid());
	}
	
	@Test
	public void testISBN() {
		//test getISBN method
		assertEquals("1234567891023", firstItem.getISBN());
		assertEquals("", secondItem.getISBN());
		
	}
	
	@Test
	public void testGetterCopyNumber() {
		assertEquals("1", firstItem.getCopyNumber());
		assertEquals("2", secondItem.getCopyNumber());

	}
	
	@Test
	public void testSetters() {
		
		assertEquals(0, firstItem.getItemid());
		assertEquals("1234567891023", firstItem.getISBN());
		assertEquals("1", firstItem.getCopyNumber());
		
		firstItem.setItemid(23);
		firstItem.setISBN("1212121212121");
		firstItem.setCopynumber("12");
		
		assertEquals(23, firstItem.getItemid());
		assertEquals("1212121212121", firstItem.getISBN());
		assertEquals("12", firstItem.getCopyNumber());
		
	}

}
