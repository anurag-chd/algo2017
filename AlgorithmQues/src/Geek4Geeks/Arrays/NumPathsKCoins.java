package Geek4Geeks.Arrays;

import java.util.LinkedList;
import java.util.Queue;

public class NumPathsKCoins {
	public static void main(String args[]){
		int arr[][] = {{1, 2, 3},{4, 6, 5},{3, 2, 1}};
		int k = 12;
		System.out.println(getNumPaths(arr,k));
	}
	
	public static int getNumPaths(int arr[][], int k){
		Queue<Pos> queue = new LinkedList<>();
		queue.add(new Pos(0,0,arr[0][0]));
		int count = 0;
		
		while(!queue.isEmpty()){
			Pos temp = queue.poll();
			if(temp.cost > k){
				continue;
			}
			if(temp.cost == k && 
					temp.x == arr.length-1 &&
					temp.y == arr[0].length -1){
				count++;
			}
			else if(temp.cost < k && 
					temp.x == arr.length-1 &&
					temp.y == arr[0].length -1){
				continue;
			}
			
			else if(temp.x == arr.length -1){
				Pos pos= new Pos(temp.x, temp.y+1, temp.cost+arr[temp.x][temp.y+1]);
				queue.add(pos);
			}
			else if(temp.y == arr[0].length -1){
				Pos pos= new Pos(temp.x+1, temp.y, temp.cost+arr[temp.x+1][temp.y]);
				queue.add(pos);
			}
			else{
				Pos pos1= new Pos(temp.x, temp.y+1, temp.cost+arr[temp.x][temp.y+1]);
				queue.add(pos1);
				Pos pos2= new Pos(temp.x+1, temp.y, temp.cost+arr[temp.x+1][temp.y]);
				queue.add(pos2);
			}
			
		}
		
		return count;
		
	}
	
	
}

class Pos {
	int x,y,cost;
	
	public Pos(int x, int y, int cost){
		this.x = x;
		this.y = y;
		this.cost = cost;
	}
	
	public String toString(){
		return "x :" + this.x +" y :" + this.y + " cost :" + this.cost;
		
	}
}
