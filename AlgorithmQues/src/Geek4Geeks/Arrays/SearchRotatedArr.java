package Geek4Geeks.Arrays;

public class SearchRotatedArr {
	public static void main(String args[]){
		String str = "5 6 7 8 9 10 1 2 3";
		String strArr [] = str.split(" ");
		int arr[] = new int[strArr.length];
		int index = 0;
		for(String s : strArr){
			arr[index++] = Integer.valueOf(s);
		}
		int num = 10;
		System.out.println(findNum(arr,num));
		
	}
	
	public static int findNum(int arr[], int num ){
		if(arr == null || arr.length == 0){
			return -1;
		}
		if(arr.length == 1 && arr[0] != num)
			return -1;
		
		return find(arr,num, 0, arr.length-1);
	}
	
	public static int find(int arr[], int num , int l, int r){
		if(l > r){
			return -1;
		}
		int mid = (l + r)/2;
		if(arr[mid] == num){
			return mid;
		}
		if(arr[mid] > arr[l] && num < arr[mid] && num >= arr[l]){
			return find(arr,num,l,mid-1);
		}
		else if(arr[mid] < arr[r] && arr[mid] < num && num <= arr[r]){
			return find(arr,num,mid+1,r);
		}
		else{
			int left = find(arr,num,l,mid-1);
			int right = find(arr,num, mid+1, r);
			
			if(left == -1 && right == -1){
				return -1;
			}
			else if(left != -1){
				return left;
			}
			else if(right != -1){
				return right;
			}
			return -1;
		}
	}
	
}
