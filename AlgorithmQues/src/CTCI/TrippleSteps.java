package CTCI;

import java.util.Arrays;

public class TrippleSteps {
	public static void main(String args[]){
		int num = 74;
		System.out.println(getTrippleSteps(num));
	}
	
	public static long getTrippleSteps(int num){
		if(num <=0 || num == 1){
			return num;
		}
		int arr[] = new int[num +1];
		Arrays.fill(arr,-1);
		
		long dp[]= new long[91];
		
		for(int i=0;i<91;i++)
		{
			dp[i]=-1;
		}
		
		return point(num,dp);
		//return countWays(num,arr);
		
	}
	
	public static int countWays(int num, int []arr){
		if(num < 0){
			return 0;
		}
		else if( num == 0){
			return 1;
		}
		else if(arr[num]> -1)
			return arr[num];
		else{
			arr[num] = countWays(num-1,arr) + countWays(num-2,arr) ;//+ countWays(num-3,arr);
			return arr[num];
		}
			
		
	}
	
	
	public static long point(int n,long dp[])
	{
		if(dp[n]!=-1)
		{
			return dp[n];
		}
		if(n==1)
		{
			dp[1]=1;
			return dp[1];
		}
		if(n==2)
		{
			dp[2]=2;
			return dp[2];
		}
		
		dp[n]=point(n-1, dp)+point(n-2, dp);
		return dp[n];
	}
}
