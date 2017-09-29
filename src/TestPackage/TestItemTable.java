package TestPackage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import server.logic.tables.ItemTable;

public class TestItemTable {
	
	ItemTable itemTable;

	@Before
	public void setUp() throws Exception {
		
		itemTable = new ItemTable();
	}

	@Test
	public void test() {
		
		//Test constructor
		assertNotNull(new ItemTable());
		assertNotNull(itemTable);
		
		

	}

}
