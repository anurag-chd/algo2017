package CTCI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringPermutationDuplicates {
	public static void main(String args[]){
		String str = "aabc";
		System.out.println(getPerms(str));
	}
	
	public static List<String> getPerms(String str){
		if(str == null || str.length() == 0)
			return null;
		Map<Character, Integer> map = new HashMap<>();
		List<String> perms = new ArrayList<>();
		for(char c : str.toCharArray()){
			if(map.containsKey(c)){
				map.put(c, map.get(c)+1);
			}
			else
				map.put(c, 1);
		}
		
		getPerms(map,"",str.length(), perms);
		return perms;
		
	}
	
	public static void getPerms(Map<Character,Integer> map, String prefix, int remaining, List<String> perms){
		if(remaining == 0){
			perms.add(prefix);
			return;
		}
		for(char c : map.keySet()){
			int count = map.get(c);
			if(count > 0){
				map.put(c, count-1);
				getPerms(map , prefix+c, remaining-1,perms);
				map.put(c,count);
			}
			
		}
	}
	
	
}
