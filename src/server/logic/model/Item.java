package server.logic.model;

public class Item {
	int itemid;
	String ISBN;
	String copynumber;
	
	public Item(int itemid,String ISBN,String copynumber){
		this.itemid=itemid;
		this.ISBN=ISBN;
		this.copynumber=copynumber;
	}
	
	public String toString(){
		return "["+this.itemid+","+this.ISBN+","+this.copynumber+"]";
	}
	
	public int getItemid() {
		return itemid;
	}
	public String getISBN() {
		return ISBN;
	}
	public String getCopynumber() {
		return copynumber;
	}

}
