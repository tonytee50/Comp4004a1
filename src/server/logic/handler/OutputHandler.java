package server.logic.handler;

import java.util.Date;

import server.logic.handler.model.Output;
import server.logic.tables.FeeTable;
import server.logic.tables.ItemTable;
import server.logic.tables.LoanTable;
import server.logic.tables.TitleTable;
import server.logic.tables.UserTable;
import utilities.Config;

public class OutputHandler {
	public static final int WAITING = 0;
	public static final int FINISHWAITING=1;
    public static final int CLERK = 2;
    public static final int USER = 3;
    public static final int CREATEUSER=4;
    public static final int CREATETITLE=5;
    public static final int CREATEITEM=6;
    public static final int DELETEUSER=7;
    public static final int DELETETITLE=8;
    public static final int DELETEITEM=9;
    public static final int BORROW=10;
    public static final int RENEW=11;
    public static final int RETURN=12;
    public static final int PAYFINE=13;
    public static final int CLERKLOGIN=14;
    public static final int USERLOGIN=15;

	public Output createUser(String input) {
		Output output=new Output("",0);
		String[] strArray = null;   
        strArray = input.split(",");
        boolean email=strArray[0].contains("@");
        Object result="";
        if(strArray.length!=2 || email!=true){
        	output.setOutput("Your input should be in this format:'username,password'");
        	output.setState(CREATEUSER);
        }else{
        	result=UserTable.getInstance().createuser(strArray[0], strArray[1]);
        	if(result.equals(true)){
        		output.setOutput("Success!");
        	}else{
        		output.setOutput("The User Already Exists!");
        	}
        	output.setState(CLERK);
        }
		return output;
	}
	
	public static boolean isInteger(String value) {
		char[] ch = value.toCharArray();
		boolean isNumber=true;
		if(value.length()==13){
			for (int i = 0; i < ch.length; i++) {
				isNumber = Character.isDigit(ch[i]);
			}
		}else{
			isNumber=false;
		}
		return isNumber;
	}
	
	public Output createItem(String input) {
		Output output=new Output("",0);
		String[] strArray = null;   
        strArray = input.split(",");
        boolean number=isInteger(strArray[0]);
        Object result="";
        if(strArray.length!=1 || number!=true){
        	output.setOutput("Your input should be in this format:'ISBN',ISBN should be a 13-digit number");
        	output.setState(CREATEITEM);
        }else{
        	result=ItemTable.getInstance().createitem(strArray[0]);
        	if(result.equals(true)){
        		output.setOutput("Success!");
        	}else{
        		output.setOutput("The Title Does Not Exists!");
        	}
        	output.setState(CLERK);
        }
		return output;
	}
	
	public Output deleteUser(String input) {
		Output output=new Output("",0);
		String[] strArray = null;   
        strArray = input.split(",");
        int userid=UserTable.getInstance().lookup(strArray[0]);
        boolean email=strArray[0].contains("@");
        Object result="";
        if(strArray.length!=1 || email!=true){
        	output.setOutput("Your input should be in this format:'useremail'");
        	output.setState(DELETEUSER);
        }else if(userid==-1){
        	output.setOutput("The User Does Not Exist!");
        	output.setState(DELETEUSER);
        }else{
        	result=UserTable.getInstance().delete(userid);
        	if(result.equals("success")){
        		output.setOutput("Success!");
        	}else{
        		output.setOutput(result+"!");
        	}
        	output.setState(CLERK);
        }
		return output;
	}
	
	public Output deleteTitle(String input) {
		Output output=new Output("",0);
		String[] strArray = null;   
        strArray = input.split(",");
        boolean number=isInteger(strArray[0]);
        Object result="";
        if(strArray.length!=1 || number!=true){
        	output.setOutput("Your input should be in this format:'ISBN',ISBN should be a 13-digit number");
        	output.setState(DELETETITLE);
        }else{
        	result=TitleTable.getInstance().delete(strArray[0]);
        	if(result.equals("success")){
        		output.setOutput("Success!");
        	}else{
        		output.setOutput(result+"!");
        	}
        	output.setState(CLERK);
        }
		return output;
	}
	
}
