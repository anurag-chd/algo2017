package Geek4Geeks.Arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SmallestRangeKList {
	public static void main(String args[]){
		int arr[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		
		findMinRange(arr);
	}
	
	public static void findMinRange(int arr[][]){
		int row = arr.length;
		int col = arr[0].length;
		PriorityQueue<ListElements> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.val,b.val));
		int range = Integer.MAX_VALUE;
		int max= 0, min;
		int ptrArr[] = new int[row];
		for(int i = 0; i< row; i++){
			queue.add(new ListElements(arr[i][0], i));
			max = max > arr[i][0] ? max : arr[i][0];
			ptrArr[i] = 0;
		}
		min = queue.peek().val;
		range = max -min;
		
		while(ptrArr[queue.peek().arrIndex] != col -1){
			ListElements top = queue.poll();
			int arrIndex = top.arrIndex;
			ptrArr[arrIndex]++;
			int newNum = arr[arrIndex][ptrArr[arrIndex]];
			max = max > newNum ? max : newNum;
			
			ListElements temp = new ListElements(newNum, top.arrIndex);
			queue.add(temp);
			min = queue.peek().val;
			range = (max -min) > range ? range : (max -min);
		}
		
		System.out.println(max + " " + min + " " + range);
		return;
		
	}
}

class ListElements{
	int val, arrIndex;
	
	public ListElements(int val, int arrIndex){
		this.val = val;
		this.arrIndex = arrIndex;
	}
	
	public String toString(){
		return this.val +"";
	}
	
	
}
