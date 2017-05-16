package Geek4Geeks.DP;

public class SubSetSum {
	public static void main(String args[]){
		int arr[] = {1, 3, 5};
		subSetExist(arr);
	}
	
	public static void subSetExist(int arr[]){
		if(arr == null || arr.length < 2){
			System.out.println("NO");
			return;
		}
		int sum = 0;
		for(int i : arr){
			sum += i;
		}
		if(sum % 2 != 0){
			System.out.println("NO");
			return;
		}
		int half = sum/2;
		boolean tab[][] = new boolean[arr.length][half+1];
		for(int i =0; i< arr.length ; i++)
			tab[i][0] = true;
		
		for(int i =0 ; i <arr.length; i++){
			for(int j = 1; j <= half ; j++){
				if(i == 0){
					tab[i][j] = arr[i] == j ? true:false;
				}
				else{
					if(j < i){
						tab[i][j] = tab[i-1][j];
					}
					else{
						tab[i][j] = tab[i-1][j] ? true : j >= arr[i] ?tab[i-1][j - arr[i]] : false;
					}
				}
			}
		}
		
		if(tab[arr.length-1][half])
			System.out.println("YES");
		else{
			System.out.println("NO");
		}
		return;
	}
}
