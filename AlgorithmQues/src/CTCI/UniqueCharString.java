package CTCI;

import java.util.Arrays;
import java.util.BitSet;

public class UniqueCharString {
	public static void main(String args[]){
		String str = "abcdefxyzst";
		System.out.println(isUnique(str));
		System.out.println(isUniqueWithoutSpace(str));
		
	}
	
	public static boolean isUnique(String str){
		if(str == null || str.length() < 2) 
			return true;
		if( str.length() >127)
			return false;
		BitSet bitSet = new BitSet();
		for(char c: str.toCharArray()){
			if(bitSet.get(Integer.valueOf(c))){
				return false;
			}
			bitSet.set(Integer.valueOf(c));
		}
		
		return true;
	}
	
	public static boolean isUniqueWithoutSpace(String str){
		if(str == null || str.length() < 2) 
			return true;
		if( str.length() >127)
			return false;
		char arr[] = str.toCharArray();
		Arrays.sort(arr);
		for(int index = 0 ; index< arr.length-1 ; index++){
			if(arr[index] == arr[index+1]){
				return false;
			}
		}
		return true;
	}

}
