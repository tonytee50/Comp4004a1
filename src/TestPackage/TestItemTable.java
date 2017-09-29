package TestPackage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import server.logic.model.Fee;
import server.logic.model.Item;
import server.logic.tables.ItemTable;

public class TestItemTable {
	
	ItemTable itemTable1;
	ItemTable itemTable2;

	@Before
	public void setUp() throws Exception {
		
		itemTable1 = new ItemTable();
		itemTable2 = new ItemTable();
	}

	@Test
	public void test() {
		
		//Test constructor
		assertNotNull(new ItemTable());
		assertNotNull(itemTable1);
		
		//test getInstance method
		assertEquals(itemTable1.getInstance(), itemTable2.getInstance());
		assertEquals(ItemTable.getInstance(), ItemTable.getInstance());
		
		//test lookup method
		assertTrue(itemTable1.lookup("9781442668584"));
		assertFalse(itemTable1.lookup("1234567891234"));
		
		//test getItemTable method
		assertEquals(itemTable1.itemList, itemTable1.getItemTable());
		itemTable1.itemList.add(new Item(12,"1234567890123"));
		assertEquals(itemTable1.itemList, itemTable1.getItemTable());
	}

}
