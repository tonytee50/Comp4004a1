package server.logic.tables;

import java.util.ArrayList;
import java.util.List;
import server.logic.model.Fee;

public class FeeTable {
	
//	private Logger logger = Trace.getInstance().getLogger("opreation_file");
	public List<Fee> feeList=new ArrayList<Fee>();
	
    public FeeTable(){
    	//set up the default list with some instances
    	Fee fee=new Fee(0,5);
    	Fee fee1=new Fee(1,3);
    	feeList.add(fee);
    	feeList.add(fee1);
    };
    
	public boolean checkuser(int j) {
		boolean result=true;
		int fee = 0;
		for(int i=0;i<feeList.size();i++){
			int userid=(feeList.get(i)).getUserid();
			if(userid==j){
				fee=fee+1;
			}else{
				fee=fee+0;
			}
		}	
		if(fee==0){
			result=false;
		}
		return result;
	}
	
	private static class FeeListHolder {
        private static final FeeTable INSTANCE = new FeeTable();
    }

	public static final FeeTable getInstance() {
        return FeeListHolder.INSTANCE;
    }

	public boolean lookup(int j) {
		boolean result=true;
		int fee = 0;
		boolean user=FeeTable.getInstance().checkuser(j);
		if(user){
			for(int i=0;i<feeList.size();i++){
				int userid=(feeList.get(i)).getUserid();
				if(userid==j){
					fee=fee+feeList.get(i).getFee();
				}
			}	
		}else{
			fee=0;
		}
		if(fee!=0){
			result=false;
		}
		return result;
	}
	
	public Object lookupfee(int j) {
		int fee=0;
		boolean user=FeeTable.getInstance().checkuser(j);
		if(user){
		for(int i=0;i<feeList.size();i++){
			int userid=(feeList.get(i)).getUserid();
			if(userid==j){
				fee=fee+feeList.get(i).getFee();
			}
		}
		}else{
			fee=0;
		}
		return fee;
	}
	
	public List<Fee> getFeeTable() {
		return feeList;
	}
	
	public Object payfine(int i) {
		String result="";
		boolean oloan=LoanTable.getInstance().looklimit(i);
		int fee=0;
		int index=0;
		boolean user=FeeTable.getInstance().checkuser(i);
		if(user){
			for(int m=0;m<feeList.size();m++){
				if(feeList.get(m).getUserid()==i){
					fee=feeList.get(m).getFee();
					index=m;
				}else{
					fee=0;
				}
			}
		}else{
			fee=0;
		}
		if(oloan==false){
			result="Borrowing Items Exist";
		}else{
			feeList.get(index).setUserid(i);
			feeList.get(index).setFee(0);
			result="success";
		}
		return result;
	}
	
}
