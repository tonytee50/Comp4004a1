package TestPackage;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import server.logic.model.User;
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
	
	@Test
	public void testGetUserTable() {
		String[] passwordList=new String[]{"Zhibo","Yu","Michelle","Kevin","Sun"};
    	String[] usernameList=new String[]{"Zhibo@carleton.ca","Yu@carleton.ca","Michelle@carleton.ca","Kevin@carleton.ca","Sun@carleton.ca"};
    	
    	for(int i=0;i<usernameList.length;i++) {
    		User deuser=new User(i,usernameList[i],passwordList[i]);
			userLister.add(deuser);
			assertEquals(userLister.get(i).getUsername(), userTable.getUserTable().get(i).getUsername());
    		assertEquals(userLister.get(i).getPassword(), userTable.getUserTable().get(i).getPassword());
    		assertEquals(userLister.get(i).getUserid(), userTable.getUserTable().get(i).getUserid());
    		assertEquals(i+1, userLister.size());
    	}
    	assertEquals(7, userTable.getUserTable().size());
	}
	
	@Test
	public void testLookupString() {
		for(int i = 0; i < userTable.userList.size(); i++) {
			assertEquals(i, userTable.lookup(userTable.userList.get(i).getUsername()));
		}
		assertEquals(-1, userTable.lookup("john@carleton.ca"));
	}
	
	@Test
	public void testCheckUser() {
		//test the case where the user is found
		for(int i = 0; i<userTable.userList.size(); i++) {
			assertEquals(0, userTable.checkUser(userTable.userList.get(i).getUsername(), userTable.userList.get(i).getPassword()));
		}
		//test the case where user is not found
		assertEquals(2, userTable.checkUser("john@carleton.ca",userTable.userList.get(0).getPassword()));
		//test the case where the password is false
		assertEquals(1,userTable.checkUser(userTable.userList.get(0).getUsername(), userTable.userList.get(1).getPassword()));
	}
	
	@Test
	public void testDelete() {
		//test "Outstanding Fee Exists"
		assertEquals("Outstanding Fee Exists", userTable.delete(userTable.userList.get(0).getUserid()));
		//test success when it finds user to delete and user does not have active loan
		assertEquals("success", userTable.delete(userTable.userList.get(5).getUserid()));
		//test "The User Does Not Exist" when user doesn't exist
		assertEquals("The User Does Not Exist", userTable.delete(userTable.userList.get(5).getUserid()+100));
		
	}

}
