package TestPackage;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import server.logic.model.Title;
import server.logic.tables.TitleTable;

public class TestTitleTable {
	
	TitleTable titleTable1;
	TitleTable titleTable2;
	public List<Title> titleLister;
	

	@Before
	public void setUp() throws Exception {
		titleTable1 = TitleTable.getInstance();
		titleTable2 = TitleTable.getInstance();
		titleLister = new ArrayList<Title>();
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
		
		String[] ISBNList=new String[]{"9781442668584","9781442616899","9781442667181","9781611687910","9781317594277"};
    	String[] titlenameList=new String[]{"By the grace of God","Dante's lyric poetry ","Courtesy lost","Writing for justice","The act in context"};
    	for(int i=0;i<ISBNList.length;i++){
    		Title detitle=new Title(ISBNList[i],titlenameList[i]);
    		titleLister.add(detitle);
    		assertEquals(titleLister.get(i).getBooktitle(), titleTable1.getTitleTable().get(i).getBooktitle());
    		assertEquals(titleLister.get(i).getISBN(), titleTable2.getTitleTable().get(i).getISBN());
    		assertEquals(i+1, titleLister.size());
    	}
    	
    	System.out.println(titleLister);
    	System.out.println(titleTable1.getTitleTable());
		assertEquals(6, titleTable1.getTitleTable().size());
	}
	
	@Test
	public void testCreateTitle() {
		
		for(int i = 0; i<titleTable1.titleList.size(); i++) {
			assertEquals(false,titleTable1.createtitle(titleTable1.titleList.get(0).getISBN(), "This Title"));
		}
		
		assertEquals(true, titleTable1.createtitle("1234567891234", "This Title"));
	}
	
	@Test 
	public void testLookUp() {
		
		for(int i = 0; i<titleTable1.titleList.size(); i++) {
			assertEquals(true,titleTable1.lookup(titleTable1.titleList.get(0).getISBN()));
		}
		
		assertEquals(false,titleTable1.lookup("1234567891233"));
	}
	
	@Test
	public void testDelete() {
		//Test every case
		//Case where it was able to delete
		System.out.println(titleTable1.titleList);
		assertEquals("success", titleTable1.delete("9781442616899"));
		assertEquals("success", titleTable1.delete("9781442667181"));
		
		//Case where loan exists
		assertEquals("Active Loan Exists", titleTable1.delete("9781442668584"));
		
		//case where title doesn't exist
		assertEquals("The Title Does Not Exist", titleTable1.delete("1212121212121"));
	}
	

}
