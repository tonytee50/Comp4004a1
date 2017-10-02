package server.logic.model;

public class Item {
	int itemid;
	String ISBN;
	String copynumber;
	
	public Item(int itemid,String ISBN, String copynumber){
		this.itemid=itemid;
		this.ISBN=ISBN;
		this.copynumber = copynumber;
	}
	
	public String toString(){
		return "["+this.itemid+","+this.ISBN+ "," + this.copynumber + "]";
	}
	
	public int getItemid() {
		return itemid;
	}
	public String getISBN() {
		return ISBN;
	}
	
	public String getCopyNumber() {
		return copynumber;
	}
	
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	
	public void setCopynumber(String copynumber) {
		this.copynumber = copynumber;
	}
	
}
