package Geek4Geeks.Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class JumpingNumbers {
	
	public static void main(String args[]){
		int num = 50;
		printJumpingNo(num);
	}
	
	public static void printJumpingNo(int num){
		if(num < 1)
			return;
		System.out.print(0+" ");
		
		for(int i = 1; i<=9 && i <num;i++){
			printNos(num,i);
		}
		return;
		
	}
	
	public static void printNos(int num, int x){
		Queue<Integer> que = new LinkedList<>();
		que.add(x);
		
		while(!que.isEmpty()){
			int n = que.poll();
			if( n < num){
				System.out.print(n + " ");
				
				int digit = n%10;
				if(digit == 0){
					que.add(n*10 + (digit+1));
				}
				else if(digit == 9){
					que.add(n * 10 + (digit -1));
				}
				else{
					que.add(n*10 + (digit+1));
					que.add(n * 10 + (digit -1));
				}
			}
		}
	}

}
