package server.logic.tables;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import server.logic.model.Loan;
//import utilities.Config;
//import utilities.Trace;

public class LoanTable {

	public List<Loan> loanList=new ArrayList<Loan>();
	
	private static class LoanListHolder {
        private static final LoanTable INSTANCE = new LoanTable();
    }
    
    private LoanTable(){
    	//set up the default list with some instances
    	Loan loan=new Loan(0,"9781442668584","1",new Date(),"0");
    	loanList.add(loan);
    	//logger.info(String.format("Operation:Initialize LoanTable;LoanTable: %s", loanList));
    };
    
    public static final LoanTable getInstance() {
        return LoanListHolder.INSTANCE;
    }
    
	public boolean checkLoan(String string, String string2) {
		boolean result=true;
		int flag=0;
		for(int i=0;i<loanList.size();i++){
			String ISBN=(loanList.get(i)).getIsbn();
			String copynumber=(loanList.get(i)).getCopynumber();
			if(ISBN.equalsIgnoreCase(string) && copynumber.equalsIgnoreCase(string2)){
				flag=flag+1;
			}else{
				flag=flag+0;	
			}
		}
		if(flag!=0){
			result=false;
		}
		return result;
	}
    
	public Object returnItem(int j, String string, String string2, Date date) {
		String result="";
		int flag=0;
		int index=0;
		for(int i=0;i<loanList.size();i++){
			String ISBN=(loanList.get(i)).getIsbn();
			String copynumber=(loanList.get(i)).getCopynumber();
			int userid=(loanList.get(i)).getUserid();
			if((userid==j) && ISBN.equalsIgnoreCase(string) && copynumber.equalsIgnoreCase(string2)){
				flag=flag+1;
				index=i;
			}else{
				flag=flag+0;	
			}
		}
		if(flag!=0){
			long time = date.getTime()-loanList.get(index).getDate().getTime();
			loanList.remove(index);
			result="success";
		}else{
			result="The Loan Does Not Exist";
		}
		
		return result;
	}
	
	public List<Loan> getLoanTable() {
		return loanList;
	}
	
	public boolean looklimit(int j) {
		boolean result=true;
		int flag=0;
		for(int i=0;i<loanList.size();i++){
			int userid=(loanList.get(i)).getUserid();
			if(userid==j){
				flag=flag+1;
			}else{
				flag=flag+0;	
			}
		}
		if(flag!=0){
			result=false;
		}
		return result;
	}
	
}
