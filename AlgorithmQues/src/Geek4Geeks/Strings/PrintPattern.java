package Geek4Geeks.Strings;

import java.util.Scanner;

public class PrintPattern {
	public static boolean flag = false;
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t >0){
		    int num = sc.nextInt();
		    printSeq(num);
		    flag = false;
		    t--;
		}
	}
	
	public static void printSeq(int num){
	    System.out.print(num+" ");
	    int prev =num;
	    if(prev > 0){
	        prev = prev -5;
	    }else{
	        prev = prev + 5;
	    }
	    if(prev < 0){
	    	flag = true;
	    }
	    print(num,prev);
	    System.out.println();
	}
	
	public static void print(int start, int prev){
	    if(start == prev){
	        System.out.print(prev+" ");
	        return;
	    }else{
	        System.out.print(prev+" ");
	        if(!flag){
	            prev = prev -5;
	            if(prev <= 0){
	            	flag = true;
	            }
	        }else{
	            prev = prev + 5;
	        }
	        print(start,prev);
	    }
	    return;
	    
	}
}
