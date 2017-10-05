package server.logic.tables;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import server.logic.model.Item;
//import utilities.Trace;

public class ItemTable {

	public List<Item> itemList=new ArrayList<Item>();
    
    private ItemTable(){
    	//set up the default list with some instances
    	String[] ISBNList=new String[]{"9781442668584","9781442616899","9781442667181","9781611687910"};
    	String[] cnList=new String[]{"1","1","1","1"};
    	for(int i=0;i<ISBNList.length;i++){
			Item deitem=new Item(i,ISBNList[i],cnList[i]);
			itemList.add(deitem);
		}
    	//logger.info(String.format("Operation:Initialize ItemTable;ItemTable: %s", itemList));
    };

    
    private static class ItemListHolder {
        private static final ItemTable INSTANCE = new ItemTable();
    }
    
    public static final ItemTable getInstance() {
        return ItemListHolder.INSTANCE;
    }
    
	public boolean lookup(String string) {
		boolean result=true;
		int flag=0;
		for(int i=0;i<itemList.size();i++){
			String ISBN=(itemList.get(i)).getISBN();
			if(ISBN.equalsIgnoreCase(string)){
				flag=flag+1;
			}else{
				flag=flag+0;	
			}
		}
		if(flag==0){
			result=false;
		}
		return result;
	}
    
	public List<Item> getItemTable() {
		return itemList;
	}
	
	public void deleteAll(String string) {
		for(int i=0;i<itemList.size();i++){
			if(string.equalsIgnoreCase(itemList.get(i).getISBN())){
				itemList.get(i).setISBN("N/A");
				itemList.get(i).setCopynumber("N/A");
			}
		}
		
	}
	
	public Object createitem(String string) {
		boolean result=true;
		result=TitleTable.getInstance().lookup(string);
		if(result){
		int flag=0;
		for(int i=0;i<itemList.size();i++){
			if(itemList.get(i).getISBN().equalsIgnoreCase(string)){
				flag=flag+1;
			}else{
				flag=flag+0;
			}
		}
		Item newitem=new Item(itemList.size(),string,String.valueOf(flag+1));
		itemList.add(newitem);
		}else{
			result=false;
		}
		return result;
	}
	public Object delete(String string, String string2) {
		String result="";
		int index=0;
		int flag=0;
		for(int i=0;i<itemList.size();i++){
			String ISBN=(itemList.get(i)).getISBN();
			String copynumber=(itemList.get(i)).getCopyNumber();
			if(ISBN.equalsIgnoreCase(string) && copynumber.equalsIgnoreCase(string2)){
				index=i;
				flag=flag+1;
			}else{
				flag=flag+0;
			}
		}
		if(flag!=0){
			boolean loan=LoanTable.getInstance().checkLoan(string,string2);
			if(loan){
			itemList.get(index).setCopynumber("N/A");
			result="success";
			}else{
				result="Active Loan Exists";
			}
		}else{
			result="The Item Does Not Exist";
		}
		return result;
	}
	
	public boolean lookup(String string, String string2) {
		boolean result=true;
		int flag=0;
		for(int i=0;i<itemList.size();i++){
			String ISBN=(itemList.get(i)).getISBN();
			String copynumber=(itemList.get(i)).getCopyNumber();
			if(ISBN.equalsIgnoreCase(string) && copynumber.equalsIgnoreCase(string2)){
				flag=flag+1;
			}else{
				flag=flag+0;	
			}
		}
		if(flag==0){
			result=false;
		}
		return result;
	}
	
}