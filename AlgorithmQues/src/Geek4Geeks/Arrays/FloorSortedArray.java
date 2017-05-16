package Geek4Geeks.Arrays;

import java.util.Scanner;

public class FloorSortedArray {
	
	//35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100 101 102 103 104 105 106 107 108 109 110 111 112 113
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t >0){
			int x = sc.nextInt();
			int n = sc.nextInt();
			if(n < 1)
				return;
			int arr[] = new int[n];
			int index = 0;
			while(index < n){
				arr[index++] = sc.nextInt();
			}
			System.out.println(getFloor(arr, x));
			t--;
		}
	}
	
	public static int getFloor(int arr[], int x){
	    if(arr == null || arr.length == 0 
	        || arr[0] > x)
	        return -1;
	    return getFloorRec(arr, x, 0, arr.length-1);     
	}
	
	public static int getFloorRec(int arr[], int x, int start, int end){
	    if(start > end)
	        return -1;
	    int mid = (start + end)/2;
	    if(x == arr[mid]){
	        while(mid < arr.length-1 && arr[mid] == arr[mid+1])
	            mid++;
	       return mid;     
	    }
	        
	    else if( x > arr[mid]){
	        if( mid < arr.length-1 && x < arr[mid+1]){
	            return mid;
	        }
	        else{
	        	if(mid == arr.length-1)
	                return mid;
	            return getFloorRec(arr, x, mid + 1, end);
	        }
	    }
	    else{
	        return getFloorRec(arr,x, start, mid -1);
	    }
	}
	
}

