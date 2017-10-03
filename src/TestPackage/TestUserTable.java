package TestPackage;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import server.logic.model.User;
import server.logic.tables.TitleTable;
import server.logic.tables.UserTable;

public class TestUserTable {
	
	UserTable userTable;
	UserTable userTable1;
	List<User> userLister;
	

	@Before
	public void setUp() throws Exception {
		userTable = UserTable.getInstance();
		userTable1 = UserTable.getInstance();
		userLister=new ArrayList<User>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInstance() {
		//Check to make sure it got created
		assertNotNull(userTable);
		assertNotNull(UserTable.getInstance());
		//test the size of it's array on initialization
		assertEquals(7, userTable.userList.size()); 
		//test for equality
		assertEquals(userTable, UserTable.getInstance());
	}
	
	@Test
	public void testCreateUser() {
		for (int i = 0; i<userTable1.userList.size(); i++) {
			assertEquals(false, userTable1.createuser(userTable1.userList.get(0).getUsername(), userTable1.userList.get(0).getPassword()));
		}
		assertEquals(true, userTable1.createuser("Tonyo@carleton.ca", "myPass"));
		assertEquals(true, userTable1.createuser("Tony@carleton.ca", "myPass"));
	}
	
	@Test
	public void testLookup() {
		for(int i = 0; i<userTable.userList.size(); i++) {
			assertEquals(true,userTable.lookup(userTable.userList.get(0).getUserid()));
		}
		
		assertEquals(false,userTable.lookup(1233));
		assertEquals(false,userTable.lookup(12333243));
	}

}
