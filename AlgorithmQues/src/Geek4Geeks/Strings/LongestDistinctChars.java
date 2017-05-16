package Geek4Geeks.Strings;

import java.util.HashSet;
import java.util.Set;

public class LongestDistinctChars {
	public static void main(String args[]){
		String str = "geeksforgeeks";
		System.out.println(getLongestUnique(str));
	}
	
	public static int getLongestUnique(String str){
	    if(str == null || str.length() == 0)
	        return 0;
	    if(str.length() == 1)
	        return 1;
	    Set<Character> set = new HashSet<>();
	    
	    int i = 0;
	    
	    int max_count = 1;
	    int j = 1;
	    
	    
	    while(i < str.length()){
	    
	    	int curr_count = 1;
	    	if(i == 0)
	    		set.add(str.charAt(i));

	    	while(j < str.length() &&!set.contains(str.charAt(j))){
	            set.add(str.charAt(j));
	            j++;
	        }
	        curr_count = j-i;
	        if(curr_count > 1){
	            while(j < str.length() && i < j && str.charAt(i) != str.charAt(j)){
	                set.remove(str.charAt(i));
	                i++;
	            }
	            
	        }
	        set.remove(str.charAt(i));
            i++;
            if(i ==j){
            	j++;
            }
	        max_count = Math.max(max_count, curr_count); 
	       
	             
	        
	        
	    }
	    return max_count;
	}
}
