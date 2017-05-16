package CTCI;

import java.util.HashMap;
import java.util.Map;

public class PathToSum {
	public static void main(String args[]){
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(-3);
		root.left.left = new Node(3);
		root.left.right = new Node(1);
		root.left.right.right = new Node(2);
		root.left.left.left = new Node(3);
		root.left.left.right = new Node(-2);
		root.right.right = new Node(11);
		
		System.out.println(getPaths(root, 8));
	}
	
	public static int getPaths(Node root, int targetSum){
		Map<Integer,Integer> sumMap = new HashMap<>();
		return getPaths(root, targetSum, 0, sumMap);
	}
	
	public static int getPaths(Node root, int targetSum, int runningSum, Map<Integer,Integer> pathCount){
		if(root == null)
			return 0;
		runningSum += root.data;
		int sum = runningSum - targetSum;
		int count = pathCount.getOrDefault(sum, 0);
		if(runningSum == targetSum){
			count++;
		}
		incrementTable(pathCount, runningSum, true);
		count += getPaths(root.left,targetSum,runningSum,pathCount);
		count += getPaths(root.right,targetSum,runningSum,pathCount);
		incrementTable(pathCount, runningSum, false);
		
		return count;
	}
	
	public static void incrementTable(Map<Integer,Integer> pathCount, int key, boolean incrementFlag){
		int val = pathCount.getOrDefault(key, 0);
		if(incrementFlag){
			pathCount.put(key,++val);
		}
		else{
			if(val == 0){
				pathCount.remove(key);
			}
			else{
				pathCount.put(key, --val);
			}
		}
	}
}
