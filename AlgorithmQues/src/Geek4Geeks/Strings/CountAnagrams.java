package Geek4Geeks.Strings;

import java.util.Arrays;
import java.util.Scanner;

public class CountAnagrams {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t >0){
		    String str = sc.next();
		    String pat = sc.next();
		    System.out.println(getAnaCount(str,pat));
		    t--;
		}
	}
	
	public static int getAnaCount(String str, String pat){
	    if(str == null || str.length() == 0 || pat == null || pat.length() ==0){
	        return 0;
	    }
	    System.out.println(str +" "+ pat);
	    int count = 0;
	    char patArr[] = pat.toCharArray();
	    Arrays.sort(patArr);
	    for(int index = 0; index  < str.length() -pat.length() ; index++){
	        System.out.println(index +" "+ pat.length());
	        String s = str.substring(index, pat.length());
	        
	        char sArr[] = s.toCharArray();
	        Arrays.sort(sArr);
	        boolean notAna = false;
	        for(int i =0 ; i< s.length() ; i++){
	            if(sArr[i] != patArr[i]){
	                notAna = true;
	            }
	        }
	        if(!notAna){
	           count++;
	        }
	    }
	    return count;
	}
}
