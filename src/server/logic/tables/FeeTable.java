package server.logic.tables;

import java.util.ArrayList;
import java.util.List;
import server.logic.model.Fee;

public class FeeTable {
	
//	private Logger logger = Trace.getInstance().getLogger("opreation_file");
	List<Fee> feeList=new ArrayList<Fee>();
	
    public FeeTable(){
    	//set up the default list with some instances
    	Fee fee=new Fee(0,5);
    	feeList.add(fee);
    //	Initialization();
    };
    
}
