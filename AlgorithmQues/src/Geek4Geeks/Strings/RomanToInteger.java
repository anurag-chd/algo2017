package Geek4Geeks.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class RomanToInteger {
    static Map<Character,Integer> charValueMap = new HashMap<>();
	public static void main (String[] args) {
		//code
		
		Scanner sc = new Scanner(System.in);
		
        int t = sc.nextInt();
        charValueMap.put('I',1);
        charValueMap.put('V',5);
        charValueMap.put('X',10);
        charValueMap.put('L',50);
        charValueMap.put('C',100);
        charValueMap.put('D',500);
        charValueMap.put('M',1000);
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
        	System.out.println(getIntegerVal(str));
        }
        
	}
	
	public static int getIntegerVal(String str){
	    int result = 0;
	    str = str.toUpperCase();
	    if(str == null || str.length() == 0)
	        return 0;
	   
	   for(int index = 0; index < str.length(); index++){
	       char c = str.charAt(index);
	       if(!charValueMap.containsKey(c)){
	           return 0;
	       }
	       if(index == str.length() -1){
	           result += charValueMap.get(c);
	       }
	       else{
	           int currValue = charValueMap.get(c);
	           int nextValue = charValueMap.get(str.charAt(index+1));
	           currValue = currValue < nextValue? -1* currValue :currValue;
	           result += currValue;
	       }
	   }
	   return result;
	}
}