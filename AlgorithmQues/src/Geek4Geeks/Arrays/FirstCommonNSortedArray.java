package Geek4Geeks.Arrays;

import java.util.PriorityQueue;

public class FirstCommonNSortedArray {
	public static void main(String args[]){
		int arr[][] = { {1,3,5,8,9},
						{-1, -8, -7, 9, 10},
						{5,8,9,12,13},
						{7,9,10,11,12}
						};
		System.out.println(findFirstCommon(arr));
	}
	
	public static int findFirstCommon(int arr[][]){
		if(arr == null || arr.length == 0){
			return Integer.MAX_VALUE;
		}
		int ptrArr[] = new int[arr.length];
		PriorityQueue<ArrNum> minHeap = new PriorityQueue<>((a,b)->Integer.compare(a.val, b.val));
		int maxNum = Integer.MIN_VALUE;
		for(int i = 0; i < arr.length ; i++){
			maxNum = maxNum > arr[i][0] ? maxNum : arr[i][0];
			ptrArr[i] = 0;
			minHeap.add(new ArrNum(arr[i][0], i));
		}
		
		while(ptrArr[minHeap.peek().arrIndex] < arr[minHeap.peek().arrIndex].length){
			if(maxNum == minHeap.peek().val){
				return maxNum;
			}
			ArrNum temp = minHeap.poll();
			int currArr = temp.arrIndex;
			int currArrIndex = ptrArr[currArr];
			currArrIndex++;
			maxNum = maxNum > arr[currArr][currArrIndex] ? maxNum :arr[currArr][currArrIndex];
			ptrArr[currArr] = currArrIndex;
			temp = new ArrNum(arr[currArr][currArrIndex], currArr);
			minHeap.add(temp);
			
		}
		
		return Integer.MAX_VALUE;
	}
}
class ArrNum{
	int val;
	int arrIndex;
	
	public ArrNum(int val, int arrIndex){
		this.val = val;
		this.arrIndex = arrIndex;
	}
	
	public String toString(){
		return "<"+this.val +", " + this.arrIndex +">";
	}
}
