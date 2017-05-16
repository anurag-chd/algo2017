package Geek4Geeks.Arrays;

import java.util.Arrays;

public class PythagoreanTriplets {
	public static void main(String args[]){
		int arr[] = {3, 2, 4, 6, 5};
		check(arr);
	}
	
	public static void check(int arr[]){
		if(arr == null || arr.length <3){
			System.out.println("No");
			return;
		}
		
		for(int i = 0; i< arr.length ; i++)
			arr[i] = arr[i] * arr[i];
		
		Arrays.sort(arr);
		for(int i = 2; i < arr.length ;i++){
			int l = 0;
			int r = i-1;
			while(l < r){
				if(arr[l] + arr[r] == arr[i]){
					System.out.println("Yes");
					return;
				}
				else{
					if(arr[l] + arr[r] > arr[i]){
						r--;
					}
					else
						l++;
				}
			}
		}
		System.out.println("No");
		return;
		
	}
}
