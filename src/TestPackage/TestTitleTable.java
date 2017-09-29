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
	
	@Test
	public void testGetTable() {
		String[] check = {"[9781442668584,By the grace of God]", "[9781442616899,Dante's lyric poetry ]", "[9781442667181,Courtesy lost]", "[9781611687910,Writing for justice]", "[9781317594277,The act in context]"};
		assertEquals(check, titleTable1.titleList);
	}

}
