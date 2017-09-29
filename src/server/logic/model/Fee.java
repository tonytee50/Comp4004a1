package server.logic.model;

public class Fee {
	int userid;
	int fee;
	public Fee(int userid,int fee){
		this.userid=userid;
		this.fee=fee;
	}
	public String toString(){
		return "["+this.userid+","+this.fee+"]";
	}
	
	public int getUserid() {
		return userid;
	}
	public int getFee() {
		return fee;
	}	

}
