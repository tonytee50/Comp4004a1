package server.logic.model;

public class Item {
	int itemid;
	String ISBN;
//	String copynumber;
	
	public Item(int itemid,String ISBN){
		this.itemid=itemid;
		this.ISBN=ISBN;
	}
	
	public String toString(){
		return "["+this.itemid+","+this.ISBN +"]";
	}
	
}
