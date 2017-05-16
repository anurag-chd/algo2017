package Geek4Geeks.Arrays;

public class CountInversionMergeSort {
	public static void main(String args[]){
		int arr[] = {2, 4, 1, 3, 5};
		System.out.println(countInversions(arr));
	}
	
	public static int countInversions(int arr[]){
		if(arr== null || arr.length <2)
			return 0;
		int temp[] = new int[arr.length];
		
		return getInversion(arr,temp, 0, arr.length-1);
	}
	
	public static int getInversion(int arr[], int temp[], int start, int end){
		int inv_count = 0;
		if(start < end){
			int mid = (start + end)/2;
			inv_count = getInversion(arr,temp, start,mid);
			inv_count += getInversion(arr, temp, mid+1, end);
			inv_count += merge(arr, temp, start, mid, end);
		}
		return inv_count;
	}
	
	public static int merge(int arr[], int temp[], int start, int mid, int end){
		int i = start;
		int j = mid+1;
		int k = start;
		int inv_count = 0;
		
		while(i <= mid && j <= end){
			if(arr[i] < arr[j]){
				temp[k++] = arr[i++];
			}
			else {
				temp[k++] = arr[j++];
				inv_count += mid+1-i;
			}
		}
		
		while(i <=mid){
			temp[k++] = arr[i++];
		}
		while(j <= end){
			temp[k++] = arr[j++];
		}
		
		for(i = 0 ; i <= end ;i++){
			arr[i] = temp[i];
			
		}
		return inv_count;
				
	}
}
