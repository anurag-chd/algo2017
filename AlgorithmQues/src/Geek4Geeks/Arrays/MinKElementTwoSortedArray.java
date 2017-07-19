package Geek4Geeks.Arrays;

public class MinKElementTwoSortedArray {
	public static void main(String args[]){
		String str1 = "2 3 6 7 9";
		String str2 = "1 4 8 10";
		String[] str1Arr = str1.split(" ");
		String[] str2Arr = str2.split(" ");
		int arr1Len = 5;
		int arr2Len = 4;
		int arr1[] = new int[arr1Len];
		int arr2[] = new int[arr2Len];
		for(int i = 0; i< arr1Len; i++){
			arr1[i] = Integer.valueOf(str1Arr[i]);
		}
		
		for(int i = 0; i< arr2Len; i++){
			arr2[i] = Integer.valueOf(str2Arr[i]);
		}
		int k = 5;
		//System.out.println(findKth(arr1,arr2,k, 0, arr1Len, 0, arr2Len));
		System.out.println(findKth2(arr1, arr2, k, 0, arr1Len, 0, arr2Len));
	}
	
	// logm + logn
	public static int findKth2(int arr1[], int arr2[], int k,
            int start1, int end1, int start2, int end2){
		int len1 = end1-start1;
		int len2 = end2 - start2;
//		if(k < 1 || k > (len1 + len2)){
//			return -1;
//		}
		if(k == 1){
			return Math.min(arr1[start1], arr2[start2]);
		}
		if(len1 == 0){
			return arr2[start2 + k -1];
		}
		if(len2 == 0){
			return arr1[start1 + k -1];
		}
		
		int mid1 = (end1 - start1)/2;
		int mid2 = ( end2 - start2)/2;
		
		if((start1 - mid1) + (start2 - mid2)  >= k){
			if(arr1[start1 + mid1 -1 ] > arr2[start2 + mid2-1]){
				return findKth2(arr1, arr2, k, start1, start1 + mid1, start2, end2);
			}
			else{
				return findKth2(arr1, arr2, k, start1, end1, start2, start2 + mid2);
			}
		}
		else{
			if(arr1[start1 + mid1-1] > arr2[start2 + mid2-1]){
				return findKth2(arr1, arr2, k-mid2, start1, end1, start2 + mid2, end2);
			}
			else{
				return findKth2(arr1, arr2, k-mid1, start1 + mid1, end1, start2, end2);
			}
		}
		
	}
	
	// log(m + n)
	public static int findKth(int arr1[], int arr2[], int k,
            int start1, int end1, int start2, int end2){
		int len1 = end1-start1;
		int len2 = end2 - start2;
		System.out.print("Arr 1 :  ");
		printArr(arr1, start1, end1);
		System.out.print("Arr 2 :  ");
		printArr(arr2, start2, end2);
		System.out.println("K == " + k);
		if(k < 1 || k > (len1 + len2)){
			return -1;
		}
		
		if(len1 > len2){
			return findKth(arr2, arr1, k, start2, end2, start1, end1);
		}
		if(len1 == 0){
			return arr2[start2 + k -1];
		}
		if(k == 1){
			return Math.min(arr1[start1], arr2[start2]);
		}
		int i = Math.min(len1, k/2);
		int j = Math.min(len2, k/2);
		
		if(arr1[start1 +i-1] > arr2[start2 + j-1]){
			return findKth(arr1, arr2, k-j, start1, end1, start2+j, end2);
		}
		else{
			return findKth(arr1, arr2, k-i, start1+i, end1, start2, end2);
		}
	}
	
	public static void printArr(int arr[] , int start, int end){
		for(int i = start; i< end; i++){
			System.out.print(arr[i]+", ");
		}
		System.out.println();
	}
}
