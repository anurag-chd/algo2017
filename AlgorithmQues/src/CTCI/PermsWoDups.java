package CTCI;

import java.util.ArrayList;
import java.util.List;

public class PermsWoDups {
	public static void main(String args[]){
		String str = "abc";
		System.out.println(getPerms(str));
	}
	
	public static List<String> getPerms(String str){
		if(str == null || str.length() == 0)
			return null;
		//List<String> perms = new ArrayList<>();
		return getPerms(str ,0);
	}
	
	public static List<String> getPerms(String s, int index){
		if(index == s.length()-1){
			List<String> perms = new ArrayList<>();
			perms.add(s.charAt(index)+"");
			return perms;
		}
		List<String> result = getPerms(s,index+1);
		List<String> perms = new ArrayList<>();
		char c = s.charAt(index);
		for(String str : result){
			for(int i =0; i<str.length()+1 ; i++){
				String temp = str.substring(0, i) + c + str.substring(i);
				perms.add(temp);
			}
		}
		return perms;
	}
}
