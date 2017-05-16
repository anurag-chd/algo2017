package Geek4Geeks.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhonePossibleWords {
	public static void main(String args[]){
		int arr[] = {2,3,4};
		printWords(arr);
	}
	
	public static void printWords(int arr[]){
		if(arr == null || arr.length == 0)
			return;
		Map<Integer,List<String>> keyMap = new HashMap<>();
		String strArr[] = {"A","B","C"};
		keyMap.put(2, Arrays.asList(strArr));
		String strArr1[] = {"D","E","F"};
		keyMap.put(3, Arrays.asList(strArr1));
		String strArr2[] = {"G","H","I"};
		keyMap.put(4, Arrays.asList(strArr2));
		String strArr3[] = {"J","K","L"};
		keyMap.put(5, Arrays.asList(strArr3));
		String strArr4[] = {"M","N","O"};
		keyMap.put(6, Arrays.asList(strArr4));
		String strArr5[] = {"P","Q","R","S"};
		keyMap.put(7, Arrays.asList(strArr5));
		String strArr6[] = {"T","U","V"};
		keyMap.put(8, Arrays.asList(strArr6));
		String strArr7[] = {"W","X","Y", "Z"};
		keyMap.put(9, Arrays.asList(strArr7));
		
		//StringBuilder sbr = new StringBuilder();
		String str = "";
		printAll(arr,0,keyMap,str);
		return;
	}
	
	public static void printAll(int arr[], int index,Map<Integer,List<String>> keyMap, String str){
		if(index == arr.length){
			System.out.print(str.toLowerCase() + " ");
			return;
		}
		List<String> temp = keyMap.get(arr[index]);
		for(String s: temp){
			str += s;
			printAll(arr, index+1, keyMap, str);
			if(str.length() == 1){
				str = "";//new StringBuilder();
			}
			else
				str = str.substring(0, str.length()-1);
			
		}
			
	}
}
