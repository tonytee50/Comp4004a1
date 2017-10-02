package TestPackage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import server.logic.model.User;

public class TestUser {

	User newUser;
	
	@Before
	public void setUp() throws Exception {
		newUser = new User(1234, "Username", "Pass");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetUsername() {			
		//test the getLoansAmount method
		assertEquals("Username", newUser.getUsername());
	}
	
	@Test
	public void testGetPassword() {
		assertEquals("Pass", newUser.getPassword());
	}
	
	@Test
	public void testUserIDGetter() {
		//test the getUserId method
		assertEquals(1234, newUser.getUserid());
	}
	
	@Test
	public void testtoString() {
		//test the toString method
		assertEquals("[1234,Username,Pass]", newUser.toString());
	}
	
	@Test
	public void testSetters() {
		assertEquals("Username", newUser.getUsername());
		assertEquals("Pass", newUser.getPassword());
		assertEquals(1234, newUser.getUserid());
		assertEquals("[1234,Username,Pass]", newUser.toString());
		
		newUser.setUsername("User");
		newUser.setPassword("Password");
		newUser.setUserid(123);
		
		assertEquals("User", newUser.getUsername());
		assertEquals("Password", newUser.getPassword());
		assertEquals(123, newUser.getUserid());
		assertEquals("[123,User,Password]", newUser.toString());
	}

}
