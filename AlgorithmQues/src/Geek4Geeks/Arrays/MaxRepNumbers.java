package Geek4Geeks.Arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class MaxRepNumbers {
	public static void main(String args[]){
		String str ="27 28 2 26 62 3 59 58 42 58 59 41 17 38 5 60 60 20 53 24 62 33 9 57 28 59 40 25 15 21 49 43 49 51 5 47 55 0 41 33 58 37 10 11 11 16 8 7 36 61 31 35 30 40 28 59 36 5 20 51 26 5 30 11 57 35 59 48 36 36 17 30 9 28 42 20 44"; 
		int arr [] = new int [77];
		
		int index = 0;
		for(String s : str.split(" "))
			arr[index++] = Integer.valueOf(s);
		
		int k = 64;
		Map<Integer,Integer> map = new HashMap<>();
		
		for(int i : arr){
			if(map.containsKey(i)){
				int count = map.get(i);
				map.put(i, count+1);
			}
			else
				map.put(i,1);
		}
		System.out.println(map);
		System.out.println(findMaxRepeated(arr,k));
		
			
		
				
	
	
	
	}
	
	
	public static int findMaxRepeated(int arr[], int k){
	    if(k <0 || arr == null || arr.length == 0)
	        return 0;
	    
	    for(int i = 0; i< arr.length ; i++){
	        arr[(arr[i]%k)] += k;
	        
	    }
	    System.out.println();
	    for(int i = 0; i < arr.length; i++){
	    	System.out.println(arr[i]+"----- "+ (arr[i]-i)/k);
	    	arr[i] = (arr[i])/k;
	    //	System.out.print(arr[i]+ " ");
	    }
	    System.out.println();
	    int maxIndex = 0;
	    int max = 0;
	    
	    
	    for(int i = 0; i< arr.length; i++){
	        if(arr[i]> max){
	            max = arr[i];
	            maxIndex = i;
	        }
	        
	        
	    }
	    
	    //for (int i = 0; i< arr.length; i++){
         // System.out.print(arr[i]+" ");
	    //}
	    //System.out.println();
	    return maxIndex;
	}
}
