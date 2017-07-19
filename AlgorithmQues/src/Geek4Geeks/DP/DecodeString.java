package Geek4Geeks.DP;

import java.util.HashSet;
import java.util.Set;

public class DecodeString {
	public static void main(String args[]){
		String str = "31910";
		System.out.println(decode(str));
	}
	
	public static int decode(String str){
		if(str == null || str.length() == 0){
			return -1;
		}
		if(str.contains("00") || str.charAt(0) == '0'){
			return -1;
		}
		
		StringBuilder sbr = new StringBuilder();
		int index = 0;
		while(index < str.length()){
			if(index < str.length()-1 && str.charAt(index+1) == '0'){
				int num = Integer.valueOf(str.substring(index, index+2));
				if(num > 26){
					return 0;
				}
				else{
					sbr.append((char)((int)'a' + num-1));
					index +=2;
				}
			}else{
				sbr.append((char)((int)'a' + Character.getNumericValue(str.charAt(index))-1));
				index++;
			}
			
		}
		Set<String> set = new HashSet<>();
		set.add(sbr.toString());
		decodeString(str,sbr.toString(), set, 0);
		return set.size();
	}
	
	public static void decodeString(String str, String initStr, Set<String> set, int index){
		for(int i = index; i < initStr.length()-1; i++){
			if(Integer.valueOf(str.substring(i,i+2)) <=26){
				int num = Integer.valueOf(str.substring(i,i+2));
				String newStr = initStr.substring(0,i)+ 
						String.valueOf((char)((int)'a' + num-1)) + initStr.substring(i+1);
				set.add(newStr);
				decodeString(str, newStr, set, i+2);
			}
		}
	}
}
