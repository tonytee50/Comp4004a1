package server.logic.model;

public class Title {
	String ISBN;
	String booktitle;
	
	public Title(String ISBN,String booktitle){
		this.ISBN=ISBN;
		this.booktitle=booktitle;
	}

	public String getISBN() {
		return ISBN;
	}
	
	public String getBooktitle() {
		return booktitle;
	}
}
