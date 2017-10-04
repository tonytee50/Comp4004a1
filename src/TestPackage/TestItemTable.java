package TestPackage;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import server.logic.model.Fee;
import server.logic.model.Item;
import server.logic.tables.ItemTable;
import server.logic.tables.TitleTable;

public class TestItemTable {
	
	ItemTable itemTable1;
	ItemTable itemTable2;

	@Before
	public void setUp() throws Exception {
		
		itemTable1 = ItemTable.getInstance();
		itemTable2 = ItemTable.getInstance();
	}

	@Test
	public void test() {
		
		//Test constructor
		assertNotNull(ItemTable.getInstance());
		assertNotNull(itemTable1);
	}
	
	@Test
	public void testInstance() {
		//test getInstance method
		assertEquals(itemTable1.getInstance(), itemTable2.getInstance());
		assertEquals(ItemTable.getInstance(), ItemTable.getInstance());
	}
	
	@Test
	public void testLookUp() {
		//test lookup method
		assertTrue(itemTable1.lookup("9781442667181"));
		assertFalse(itemTable1.lookup("1234567891234"));
	}
	
	@Test
	public void testGetItemTable() {
		//test getItemTable method
		assertEquals(itemTable1.itemList, itemTable1.getItemTable());
		itemTable1.itemList.add(new Item(12,"1234567890123","1"));
		assertEquals(itemTable1.itemList, itemTable1.getItemTable());
	}
	
	@Test
	public void testDeleteAll() {
		//System.out.println(itemTable1.itemList.size());
		//System.out.println(itemTable1.itemList);
		Item theItem = new Item(0,"N/A","N/A");
		itemTable1.deleteAll("9781442668584");
		assertEquals(theItem.toString(), itemTable1.itemList.get(0).toString());
		System.out.println(itemTable1.itemList);
		System.out.println(itemTable1.itemList.size());
		for(int i = 1; i<itemTable1.itemList.size(); i++) {
			assertThat(theItem.toString(), is(not(itemTable1.itemList.get(i).toString())));
		}
	}
	
	@Test
	public void testCreateItem() {
		//assertEquals(true, itemTable1.createitem("3451234576543"));
		TitleTable titleTable = TitleTable.getInstance();
		for(int i = 0; i<titleTable.titleList.size();i++) {
			assertEquals(true, itemTable1.createitem(titleTable.titleList.get(i).getISBN()));
		}
		assertEquals(false, itemTable1.createitem("3451234576543"));
		assertEquals(false, itemTable1.createitem("1111111111111"));
	}
	

}
