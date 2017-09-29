package TestPackage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import server.logic.model.Title;

public class TestTitle {

	Title firstTitle;
	
	@Before
	public void setUp() throws Exception {
		firstTitle = new Title("1232145678912", "The Title");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {

		//test getISBN method
		assertEquals("1232145678912", firstTitle.getISBN());
		
	}

}
