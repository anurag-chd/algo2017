package Geek4Geeks.DP;

public class CoinChange {
	public static void main(String args[]){
		int num = 10;
		int set[] = {2, 5, 3, 6};
		System.out.println(getCoinChange(set,num));
	}
	
	public static int getCoinChange(int arr[], int num){
		if(arr == null || arr.length == 0 || num < 0){
			return 0;
		}
		int map[] = new int[num+1];
		map[0] = 1;
		for(int i =0 ; i<	 arr.length; i++){
			for(int j = arr[i]; j <= num; j++){
				map[j] += map[j-arr[i]];
			}
		}
		return map[num];
	}
}
