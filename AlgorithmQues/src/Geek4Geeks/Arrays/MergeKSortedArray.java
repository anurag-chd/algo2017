package Geek4Geeks.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

public class MergeKSortedArray {
	public static void main(String args[]){
		int arr[][] = {{2,2},{2,2}};
		int size = 2;
		System.out.println(mergeKArrays(arr, size));
	}
	
	
	public static ArrayList<Integer> mergeKArrays(int[][] arr,int k) 
    {
       if(arr == null || k == 0){
           return null;
       }
       
       //add code here.
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int arrPtr[] = new int[k];
        Map<Integer,java.util.LinkedList<Integer>> indexMap = new HashMap<>();
        Arrays.fill(arrPtr,0);
        for(int index = 0; index < k; index++){
            queue.add(arr[index][0]);
            if(!indexMap.containsKey(arr[index][0])){
                indexMap.put(arr[index][0],new LinkedList<Integer>());
            }
            indexMap.get(arr[index][0]).addLast(index);
        }
       // System.out.println(indexMap);
        while(!queue.isEmpty()){
            int t = queue.poll();
           // int a;
          // System.out.println(indexMap);
            int arrIndex = indexMap.get(t).removeFirst();
            if(indexMap.get(t).size() == 0){
                indexMap.remove(t);
            }
            int index = arrPtr[arrIndex];
            if(index < k-1){
                index++;
                arrPtr[arrIndex] = index;
                int num = arr[arrIndex][index];
                if(!indexMap.containsKey(num)){
                    indexMap.put(num,new LinkedList<Integer>());
                }
                indexMap.get(num).addLast(arrIndex);
                queue.add(num);
            }
            result.add(t);
        }
        return result;
       
    }
}
