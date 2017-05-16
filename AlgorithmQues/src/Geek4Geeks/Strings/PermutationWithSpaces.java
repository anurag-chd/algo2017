package Geek4Geeks.Strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationWithSpaces {
	public static void main(String args[]){
		String str = "abc";
		List<String> list = new ArrayList<>();
		Set<String> set = new HashSet<>();
		insertSpaces(str,list, 1,set);
		Collections.reverse(list);
		System.out.println(list );
	}
	
	public static void insertSpaces(String str, List<String> list, int index, Set<String> set){
		if(index >= str.length())
			return;
		if(!set.contains(str)){
			list.add(str);
			set.add(str);
		}
		insertSpaces(str,list,index+1,set);
		String str1 = str.substring(0,index) + " " + str.substring(index);
		if(!set.contains(str1)){
			list.add(str1);
			set.add(str1);
		}
		insertSpaces(str1,list,index+2,set);
		
	}
}
