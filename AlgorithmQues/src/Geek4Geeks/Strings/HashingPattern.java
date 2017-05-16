package Geek4Geeks.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HashingPattern {
	public static void main(String args[]){
		String arr[] = {"cgge","cggeagee", "cggeageeeaee", "cggeageeeaeeg", "cggeageeeaeegfedfdf"};
		List<String> l = Arrays.asList(arr);
		String pat = "cggeageeeaeeg";
		System.out.println(findMatchedWords(l, pat));
	}
	
	public static ArrayList<String> findMatchedWords(List<String> dict, String pattern)
	{//add code here.
	
	    ArrayList<String> result = new ArrayList<>();
	    String patHash = getHashCode(pattern);
	    for(String s: dict){
	        if(patHash.equals(getHashCode(s))){
	            result.add(s);
	        }
	    }
	    return result;
	}
	
	public static String  getHashCode(String str){
	    if(str == null || str.length() == 0){
	        return "";
	    }
	    if(str.length() == 1){
	        return "1";
	    }
	    int count = 1;
	    StringBuilder sbr = new StringBuilder();
	    for(int i = 1; i< str.length(); i++){
	    	if(str.charAt(i) == str.charAt(i-1)){
	    		count++;
	    		
	    	}else{
	    		sbr.append(count);
	    		count = 1;
	    	}
	    	if(i == str.length() -1){
    			sbr.append(count);
    		}
	    	
	    }
	    	
	    return sbr.toString();
	}

}
