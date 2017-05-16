package Geek4Geeks.Strings;

import java.util.ArrayList;
import java.util.Scanner;

public class PatternCount101 {
	public static void main (String[] args) {
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
    	System.out.println(getPatternCount(str));
    }
}

public static int getPatternCount(String str){
    int count = 0;
    if(str == null || str.length() ==0 )
        return count;
   boolean matchStarted = false;
   boolean zeroFound = false;
   int index1 = 0;
   while(index1 < str.length()){
       if(matchStarted || str.charAt(index1) == '1'){
           matchStarted = true;
           int index2 = index1 + 1;
           while(index2 < str.length()){
               if(str.charAt(index2) == '0'){
                   zeroFound = true;
                   index2++;
               }
               else if(str.charAt(index2) == '1' && zeroFound){
                   count++;
                   index2++;
                   break;
               }
               else{
            	   matchStarted = false;
                   zeroFound = false;
                   break;
               }
           }
           
           index1 = index2;
       }
       else{
           index1++;
       }
   }
   return count;
   
   
   
}
}
