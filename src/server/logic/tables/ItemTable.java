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
    	for(int i=0;i<ISBNList.length;i++){
			Item deitem=new Item(i,ISBNList[i]);
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
	
}