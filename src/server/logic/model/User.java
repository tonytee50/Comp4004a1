package server.logic.model;

public class User {
	int userid;
	int loansAmount;

	public User(int userid, int loansAmount){
		this.userid=userid;
		this.loansAmount = loansAmount;
	}
	
	public String toString(){
		return "["+this.userid+","+ this.loansAmount + "]";
	}
	
	public int getUserid() {
		return userid;
	}
	
	public int getloansAmount() {
		return this.loansAmount;
	}

}
