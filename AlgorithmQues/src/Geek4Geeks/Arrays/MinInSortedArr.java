package Geek4Geeks.Arrays;

public class MinInSortedArr {
	public static void main(String args[]){
		int arr[] = {4,5,6,7,8,9,450,2,3};
		System.out.println(findMin(arr));
	}
	
	public static int findMin(int arr[]){
		if(arr == null || arr.length == 0){
			return -1;
			
		}
		if(arr.length == 1){
			return arr[0];
		}
		return findMin(arr,0,arr.length-1);
	}
	
	public static int findMin(int arr[], int start, int end){
		if(start == end)
			return arr[start];
		
		if(arr[start] < arr[end]){
			return arr[start];
		}
		int mid = end + (start - end)/2;
		if(arr[mid] > arr[mid+1])
			return arr[mid+1];
		if(arr[mid]< arr[mid-1])
			return arr[mid];
		
		if(arr[mid] < arr[end]){
			return findMin(arr,start, mid-1);
			
		}
		else{
			return findMin(arr, mid+1, end);
		}
		
	}
}
