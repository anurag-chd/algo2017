package Geek4Geeks.Strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintPermutations {
	public static void main(String args[]){
		String str = "abc";
		printPerms(str);
	}
	
	public static void printPerms(String str){
	    List<String> list = new ArrayList<>();
	    if(str == null || str.length() == 0){
	        System.out.println("");
	        return;
	    }
	    
	    for(int i = 0; i< str.length(); i++){
	        char c = str.charAt(i);
	        if(list.size() == 0){
	            list.add(new String(c+""));
	        }
	        else{
	            List<String> temp  = new ArrayList<>();
	            for(String s : list){
	                for(int j = 0; j <= s.length() ; j++){
	                    String newStr = s.substring(0,j) + c + s.substring(j);
	                    temp.add(newStr) ;
	                }
	            }
	            list = temp;
	        }
	    }
	    Collections.sort(list);
	    for(int i = list.size()-1; i >= 0; i--){
	        System.out.print(list.get(i)+ " ");
	    }
	    System.out.println();
	    
	}
}
