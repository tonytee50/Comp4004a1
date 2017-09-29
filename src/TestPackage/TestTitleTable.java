package TestPackage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import server.logic.tables.TitleTable;

public class TestTitleTable {
	
	TitleTable titleTable1;
	TitleTable titleTable2;

	@Before
	public void setUp() throws Exception {
		titleTable1 = TitleTable.getInstance();
		titleTable2 = TitleTable.getInstance();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testgetInstane() {
		assertNotNull(titleTable1);
		assertNotNull(titleTable2);
		assertNotNull(TitleTable.getInstance());
	}
	
	

}
