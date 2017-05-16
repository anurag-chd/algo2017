package Geek4Geeks.DP;

import java.util.Arrays;

public class MinCoins {
	public static void main(String args[]){
		int num = 7;
		int arr[] = {2, 1};
		
		System.out.println(getMinCoins(num, arr));
	}
	
	public static int getMinCoins(int num, int arr[]){
		//int posArr [] = new int[num+1];
		int minArr [] = new int[num+1];
		//Arrays.fill(posArr, -1);
		Arrays.fill(minArr, Integer.MAX_VALUE-1);
		minArr[0] = 0;
		for(int i = 0; i< arr.length; i++){
			for(int j = arr[i] ; j<=num; j++){
				if(minArr[j] > 1+ minArr[j- arr[i]]){
					minArr[j] = 1+ minArr[j- arr[i]];
				//	posArr[j] = i;
				}
			}
		}
//		for(int i : posArr){
//			System.out.print(i+",");
//		}
//		System.out.println();
		Math.abs( 0 -arr[1] + arr[2]);
		return minArr[num];
	}
}
