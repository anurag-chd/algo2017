package CTCI;

public class MagicIndex {
	public static void main(String args[]){
		int arr1[] = {-40,-20,-1,1,2,3,5,7,9,12,13};
		int arr2[] = {-10,-5,2,2,2,3,4,7,9,12,13};
		System.out.println(getMi1(arr1));
		System.out.println(getMi2(arr2));
	}
	
	public static int getMi2(int arr[]){
		if(arr == null || arr.length == 0)
			return -1;
		return getMi2(arr, 0, arr.length-1);
	}
	public static int getMi2(int arr[], int start, int end){
		if(start > end){
			return -1;
		}
		int mid = (start + end)/2;
		
		if(arr[mid] == mid){
			return mid;
		}
		int leftIndex = Math.min(arr[mid], mid-1);
		int left = getMi2(arr,start, leftIndex);
		if(left >= 0){
			return left;
		}
		int rightIndex = Math.max(arr[mid], mid+1);
		return getMi2(arr,rightIndex, end);
	}
	
	public static int getMi1(int arr[]){
		if(arr == null || arr.length == 0)
			return -1;
		return getMi1(arr, 0, arr.length-1);
	}
	public static int getMi1(int arr[], int start, int end){
		if(start > end){
			return -1;
		}
		int mid = (start + end)/2;
		
		if(arr[mid] == mid){
			return mid;
		}
		if(arr[mid] > mid)
			return getMi1(arr,start,mid-1);
		else{
			return getMi1(arr,mid+1,end);
		}
	}
}
