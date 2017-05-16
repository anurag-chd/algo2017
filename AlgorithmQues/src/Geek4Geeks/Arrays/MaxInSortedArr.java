package Geek4Geeks.Arrays;

public class MaxInSortedArr {
	public static void main(String args[]){
		int arr[] = {5,6,1,2,3,4};
		System.out.println(findMax(arr));
	}
	
	public static int findMax(int arr[]){
		if(arr == null || arr.length==0){
			return -1;
			
		}
		if(arr.length == 1)
			return arr[0];
		
		return findMax(arr, 0, arr.length-1);
	}
	
	public static int findMax(int arr[], int start, int end){
		if(start == end){
			return arr[end];
		}
		if(arr[start] < arr[end]){
			return arr[end];
		}
		int mid = (start + end)/2;
		if(mid < end && arr[mid] > arr[mid+1]){
			return arr[mid];
		}
		if(mid > start && arr[mid-1] > arr[mid]){
			return arr[mid-1];
		}
		else if(arr[mid] > arr[start]){
			return findMax(arr,mid+1,end);
		}
		else{
			return findMax(arr,start,mid-1);
		}
	}
}
