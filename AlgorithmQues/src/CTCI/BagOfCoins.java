package CTCI;

import java.util.Arrays;

/**
 * it is just like knap sack problem
 * @author anurag
 *
 */
public class BagOfCoins {
	public static void main(String args[]){
		int arr[] = {1,2,3};
		System.out.println(getWays(5,arr));
		System.out.println(countWays(arr, arr.length, 5));
	}
	
	public static int getWays(int num, int arr[]){
		if(num == 0 || arr == null || arr.length == 0){
			return 0;
		}
		int arrLen = arr.length;
		int table[][] = new int[num+1][arrLen];
		
		for(int i = 0; i < arrLen ; i++)
			table[0][i] = 1;
		
		for(int i = 1; i<= num; i++){
			for(int j = 0; j < arrLen; j++){
				int x = i -arr[j] >=0 ? table[i-arr[j]][j]:0;
				int y = j >= 1 ?table[i][j-1] : 0;
				table[i][j] = x + y;
			}
		}
		return table[num][arrLen-1];
	}
	
	static long countWays(int S[], int m, int n)
    {
        //Time complexity of this function: O(mn)
        //Space Complexity of this function: O(n)
 
        // table[i] will be storing the number of solutions
        // for value i. We need n+1 rows as the table is
        // constructed in bottom up manner using the base
        // case (n = 0)
        long[] table = new long[n+1];
 
        // Initialize all table values as 0
        Arrays.fill(table, 0);   //O(n)
 
        // Base case (If given value is 0)
        table[0] = 1;
 
        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to
        // the value of the picked coin
        for (int i=0; i<m; i++)
            for (int j=S[i]; j<=n; j++)
                table[j] += table[j-S[i]];
 
        return table[n];
    }
}
