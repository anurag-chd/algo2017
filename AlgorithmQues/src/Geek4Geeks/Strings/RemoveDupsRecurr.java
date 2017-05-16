package Geek4Geeks.Strings;

import java.util.ArrayList;
import java.util.Scanner;

public class RemoveDupsRecurr {
	public static boolean flag = false;
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
        ArrayList<String> strList = new ArrayList<>();
        while (t > 0)
        {
            String str = sc.nextLine();
            if(str.equals(""))
            	continue;
            else{
            	strList.add(str);
                t--;
            }
            
        }
        
        for(String str: strList){
        	System.out.println(removeDupsRec(str));
        }
	}
	
	public static String removeDupsRec(String str){
	    if(str == null || str.length() < 2)
	        return str;
	   return remDup(str,1);     
	        
	}
	
	public static String remDup(String str, int index){
	    if(index > str.length()-1){
	    	if(flag){
	    		flag = false;
	    		str = str.substring(0,index-1) + str.substring(index);
	    	}
	        return str;
	    }
	    if(str.charAt(index-1) == str.charAt(index)){
	    	flag = true;
	        str = str.substring(0,index-1) + str.substring(index);
	        return remDup(str,index);
	    }
	    else if(flag){
	    	flag = false;
	        str = str.substring(0,index-1) + str.substring(index);
	        return remDup(str,index);
	    }
	    else
	        return remDup(str,index+1);
	   
	}
}