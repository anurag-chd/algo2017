package Geek4Geeks.Arrays;

import java.util.Scanner;
import java.util.Stack;

public class MaxRectangle {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
			int m = sc.nextInt();
			int n = sc.nextInt();
			int arr[][] = new int[m][n];
			for(int i = 0 ; i< m ;i++){
				for(int j = 0; j<n; j++){
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(maxArea(arr,m,n));
		}
	}
	
	 public static int maxArea(int arr[][],int m,int n){
	        //add code here.
	        int mem[][] = new int[m][n];
	        int max = 0;
	        for(int i = 0; i < n; i++){
	            mem[0][i] = arr[0][i];
	        
	        }
	        max = maxRectangle(arr[0]);
	        
	        for(int i = 1; i < m; i++){
	            for(int j = 0; j < n; j++){
	                if(arr[i][j] == 0){
	                    mem[i][j] = 0;
	                }else{
	                    mem[i][j] =arr[i][j] + mem[i-1][j]; 
	                }
	                
	            }
	            int area = maxRectangle(mem[i]);
	            max = max > area? max : area;
	        }
	        return max;
	    }
	    
	    public static int maxRectangle(int arr[]){
	        if(arr == null || arr.length == 0){
	            return 0;
	        }
	        if(arr.length == 1){
	            return arr[0];
	        }
	        Stack<Integer> stack = new Stack<>();
	        int max = arr[0];
	        stack.push(0);
	        int i; 
	        for(i = 1; i< arr.length ; i++){
	            if(stack.isEmpty() || arr[stack.peek()] <= arr[i]){
	                stack.push(i);
	            }
	            else{
	                while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
	                    int index = stack.pop();
	                    int num = arr[index];
	                    int area = num *( stack.isEmpty()?i :i - stack.peek() -1);
	                    max = max < area ? area : max;
	                }
	                stack.push(i);
	            }
	        }
	        
	        while(!stack.isEmpty()){
	            int index = stack.pop();
	                    int num = arr[index];
	                    int area = num *( stack.isEmpty()?i :i - stack.peek() -1);
	                    max = max < area ? area : max;
	        }
	        for(int j : arr){
	            System.out.print(j+ " ");
	        }
	        System.out.println(max);
	        return max;
	    }
}
