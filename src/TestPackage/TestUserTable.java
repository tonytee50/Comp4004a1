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
	List<User> userLister;
	

	@Before
	public void setUp() throws Exception {
		userTable = UserTable.getInstance();
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
		assertEquals(5, userTable.userList.size());
		//test for equality
		assertEquals(userTable, UserTable.getInstance());
	}

}
