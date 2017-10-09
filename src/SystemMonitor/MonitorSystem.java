package SystemMonitor;

import server.logic.tables.TitleTable;


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
	
//	public void display() {
//		UserTable users = UserTable.getInstance();
//		
//	}
	
//	public static void main(String [] args) {
//		MonitorSystem sys = new MonitorSystem();
//		sys.titleDisplay();
//	}

}
