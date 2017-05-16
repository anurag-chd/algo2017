package Geek4Geeks.Arrays;

import java.util.Arrays;

public class MinPlatforms {
	public static void main(String args[]){
		double[]arr = {9.00,  9.40, 9.50,  11.00, 15.00, 18.00};
		double[]dep = {9.10, 12.00, 11.20, 11.30, 19.00, 20.00};
		
		calcMinPlatform(arr,dep);
	}
	
	public static void calcMinPlatform(double []arr, double[] dep){
		Arrays.sort(arr);
		Arrays.sort(dep);
		int len = arr.length;
		int res = 1;
		int platform = 1;
		int i = 1;
		int j = 0;
		while(i < len && j <len){
			if(arr[i] < dep[j]){
				platform++;
				res = res > platform?res : platform;
				i++;
			}
			else{
				platform--;
				j++;
			}
		}
		
		System.out.println(res);
		return;
	}
}
