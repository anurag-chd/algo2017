package Geek4Geeks.Arrays;

import java.util.ArrayList;
import java.util.List;

public class BuySellStocks {
	
	public static void main(String args[]){
		String str = "8858 4395 6029 1237 8235 3793 5818 4428 6143 1011 5928 9529 8776 2404 4443 5763 4613 4538 8606 6840 2904 4818";
		String strArr[] = str.split(" ");
		
		int arr[] = new int[strArr.length];
		int i =0;
		for(String s: strArr){
			arr[i++] = Integer.valueOf(s);
		}
		
		printMaxProfit(arr);
	}
	
	public static void printMaxProfit(int arr[]){
		int min_index = 0;
		int min_value = arr[0];
		int max_index = -1;
		int max_value = Integer.MIN_VALUE;
		boolean buy = true;
		List<Integer> buyList = new ArrayList<>();
		List<Integer> sellList = new ArrayList<>();
		
		for(int i = 1; i < arr.length; i++){
			if(buy){
				if(arr[i-1] < arr[i]){
					buyList.add(min_index);
					buy = !buy;
					min_value = Integer.MAX_VALUE;
					max_value = arr[i];
					max_index= i;
					if(i == arr.length-1){
						sellList.add(max_index);
					}
				}
				else{
					if(min_value > arr[i]){
						min_value = arr[i];
						min_index = i;
 					}
				}
			}
			else{
				
				if(arr[i-1] > arr[i]){
					sellList.add(max_index);
					buy = !buy;
					max_value = Integer.MIN_VALUE;
					min_value = arr[i];
					min_index = i;
				}
				else if(i == arr.length-1){
					sellList.add(i);
				}
				else{
					if(max_value < arr[i]){
						max_value = arr[i];
						max_index = i;
 					}
				}
			}
		}
		
		if(buyList.size() == 0 || sellList.size() == 0){
			System.out.println("No Profit");
		}
		if(buyList.size() == sellList.size() + 1){
			buyList.remove(buyList.size() -1);
		}
		
		for(int i = 0; i < buyList.size() ; i++){
			System.out.print("(" + buyList.get(i)+ " " + sellList.get(i)+ ")");
		}
		
	}

}
