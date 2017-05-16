package Geek4Geeks.DP;

public class LongestIncreasingSubsequence {
	public static void main(String args[]){
		int arr[] = {1, 101, 2, 3, 100, 4, 5};
		System.out.println(getLis(arr));
		System.out.println(getMaxIncSeq(arr));
	}
	
	public static int getLis(int arr[]){
		int lis[] = new int[arr.length];
		
		for(int i =0 ; i< arr.length ; i++){
			if(i ==0){
				lis[0] = 1;
			}
			else{
				int j = 0;
				int max = 0;
				while(j < i){
					if(arr[i] > arr[j]){
						max = Math.max(lis[j],max);
					}
					j++;
				}
				lis[i] = 1+ max;
			}
			
		}
		
		int max = 0;
		for(int i : lis){
			max = Math.max(max, i);
		}
		return max;
	}
	
	public static int getMaxIncSeq(int arr[]){
		int lis[] = new int[arr.length];
		
		for(int i =0 ; i< arr.length ; i++){
			if(i ==0){
				lis[0] = arr[0];
			}
			else{
				int j = 0;
				int max = 0;
				while(j < i){
					if(arr[i] > arr[j]){
						max = Math.max(lis[j],max);
					}
					j++;
				}
				lis[i] = arr[i]+ max;
			}
			
		}
		
		int max = 0;
		for(int i : lis){
			max = Math.max(max, i);
		}
		return max;
	}
	
	
}
