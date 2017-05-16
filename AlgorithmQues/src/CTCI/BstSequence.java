package CTCI;

import java.util.LinkedList;
import java.util.ArrayList;

public class BstSequence {
	
	public static void main(String arrgs[]){
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
//		root.left.left = new Node(4);
//		root.left.right = new Node(5);
//		root.right.left = new Node(6);
//		root.right.left.left = new Node(7);
		
		System.out.println(allSequences(root));
	}
	
	public static ArrayList<LinkedList<Integer>> allSequences(Node root){
		ArrayList<LinkedList<Integer>> results = new ArrayList<>();
		if(root == null){
			results.add(new LinkedList<>());
			return results;
		}
		LinkedList<Integer> prefix = new LinkedList<>();
		prefix.add(root.data);
		
		ArrayList<LinkedList<Integer>> leftSeq = allSequences(root.left);
		ArrayList<LinkedList<Integer>> rightSeq = allSequences(root.right);
		
		for(LinkedList<Integer> left: leftSeq){
			for(LinkedList<Integer> right: rightSeq){
				ArrayList<LinkedList<Integer>> weaved = new ArrayList<>();
				weavedLists(left,right,prefix,weaved);
				results.addAll(weaved);
			}
		}
		
		return results;
		
	}
	
	
	public static void weavedLists(LinkedList<Integer> first, LinkedList<Integer> second, 
			LinkedList<Integer> prefix ,ArrayList<LinkedList<Integer>> results){
		if(first.size() == 0 || second.isEmpty()){
			@SuppressWarnings("unchecked")
			LinkedList<Integer> result = (LinkedList<Integer>)prefix.clone();
			result.addAll(first);
			result.addAll(second);
			results.add(result);
			return;
		}
		
		int headFirst = first.removeFirst();
		prefix.addLast(headFirst);
		weavedLists(first,second,prefix,results);
		prefix.removeLast();
		first.add(headFirst);
		
		int headSecond = second.removeFirst();
		prefix.addLast(headSecond);
		weavedLists(first,second,prefix,results);
		prefix.removeLast();
		second.add(headSecond);
		
		
		
	}

}
