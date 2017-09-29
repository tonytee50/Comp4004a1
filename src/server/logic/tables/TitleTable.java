package server.logic.tables;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import server.logic.model.Title;
//import utilities.Trace;

public class TitleTable {

	List<Title> titleList=new ArrayList<Title>();
    private static class TitleListHolder {
        private static final TitleTable INSTANCE = new TitleTable();
    }
    private TitleTable(){
    	//set up the default list with some instances
    	String[] ISBNList=new String[]{"9781442668584","9781442616899","9781442667181","9781611687910","9781317594277"};
    	String[] titlenameList=new String[]{"By the grace of God","Dante's lyric poetry ","Courtesy lost","Writing for justice","The act in context"};
    	for(int i=0;i<ISBNList.length;i++){
    		Title detitle=new Title(ISBNList[i],titlenameList[i]);
    		titleList.add(detitle);
		}
    	
    };
    public static final TitleTable getInstance() {
        return TitleListHolder.INSTANCE;
    }

}
