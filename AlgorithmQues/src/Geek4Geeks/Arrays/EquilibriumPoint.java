package Geek4Geeks.Arrays;

import java.util.Scanner;

public class EquilibriumPoint {
	
	public static void main (String[] args) {
		//code
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while (t > 0){	
			int size = sc.nextInt();
			if(size <1)
				return;
			int arr[] = new int[size];
			int index = 0;
			while(index < size){
				arr[index++] = Integer.valueOf(sc.next());
			}
			System.out.println(getEquiPt(arr));
			t--;
		}
	}
	
	public static int getEquiPt(int arr[]){
		int size = arr.length;
		int leftArr[] = new int[arr.length];
		int leftSum= 0, rightSum= 0;
		int rightArr[] = new int[arr.length];
		for(int i = 0; i< size; i++){
			if(i == 0){
				leftArr[i] = leftSum;
				rightArr[size-1-i] = rightSum;
			}
			else{
				leftSum += arr[i-1];
				leftArr[i] = leftSum;
				rightSum += arr[size-i];
				rightArr[size-1-i] = rightSum;
			}
			
		}
		
		for(int i = 1; i < size-1; i++){
			if(leftArr[i] == rightArr[i]){
				return  i+1;
			}
		}
		return -1;
	}
}
