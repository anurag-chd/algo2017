package Geek4Geeks.Arrays;

import java.util.Scanner;

public class MaxOneRowMatrix {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
		    int row = sc.nextInt();
		    int col = sc.nextInt();
		    int mat [][] = new int [row][col];
		    for(int i = 0; i< row; i++){
		    	for(int j = 0; j< col; j++){
		    		mat[i][j] = sc.nextInt();
		    	}
		    }
		    System.out.println(getMaxOne(mat));
		    t--;
		}
	}
	
	public static int getMaxOne(int mat[][]){
	    if(mat == null ){
	        return 0;
	    }
	    int maxCount = 0;
	    int maxRow = -1;
	    for(int row = 0; row < mat.length ; row++){
	        int count = getOneCount(mat[row]);
	      //  System.out.println(count);
	        if(maxCount < count){
	            maxCount = count;
	            maxRow = row;
	        }
	    }
	    return maxRow;
	}
	
	public static int getOneCount(int arr[]){
	    if(arr[0] == 1){
	        return arr.length;
	    }
	    if(arr[arr.length -1] == 0){
	        return 0;
	    }
	    int len = arr.length-1;
	    int start = 0;
	    int end = len;
	    while(start < end){
	        int mid = (start + end)/2;
	        if(mid < len && arr[mid] == 0 && arr[mid + 1] == 1){
	            return arr.length - (mid +1) -1;
	        }
	        if(mid > 0 && arr[mid] == 1 && arr[mid -1] == 0){
	            return arr.length -(mid) -1;
	        }
	        if(arr[mid] == 0 && arr[end] == 1){
	            start = mid+1;
	        }
	        else{
	            end = mid -1;
	        }
	    }
	    
	    return 0;
	}
}
