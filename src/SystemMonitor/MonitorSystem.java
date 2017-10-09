package SystemMonitor;

import server.logic.tables.TitleTable;
import server.logic.tables.UserTable;


public class MonitorSystem {
	
	public String titleDisplay() {
		TitleTable titles = TitleTable.getInstance();
		String result = "";
		System.out.println("Here is a list of titles held in the librarian terminal:");
		for(int i = 0; i<titles.titleList.size(); i++) {
//			System.out.println(titles.titleList.get(i).toString());
			result = result + titles.titleList.get(i).toString() + "\n";
		}
		System.out.println(result);
		return result;
	}
	
	public String userDisplay() {
		UserTable users = UserTable.getInstance();
		String result = "";
		System.out.println("Here is a list of all users:");
		for(int i = 0; i<users.userList.size(); i++) {
//			System.out.println(titles.titleList.get(i).toString());
			result = result + users.userList.get(i).toString() + "\n";
		}
		System.out.println(result);
		return result;
		
	}
	
	public String display() {
		String result = "";
		result = titleDisplay() + userDisplay();
		return result;
	}


}
