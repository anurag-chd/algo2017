package Geek4Geeks.Trees;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPathsWithSumN {
	public static void main(String args[]){
		Node root = new Node(1);
		root.left = new Node(3);
		root.left.left = new Node(2);
		root.left.right = new Node(1);
		root.left.right.left = new Node(1);
		
		
		root.right = new Node(-1);
		root.right.left = new Node(4);
		root.right.left.left = new Node(1);
		root.right.left.right = new Node(2);
		root.right.right = new Node(5);
		root.right.right.right = new Node(6);
		
		printPaths(root, 5);
	}
	
	
	public static void printPaths(Node root, int k){
		if(root == null){
			return;
		}
		
		List<Integer> path = new ArrayList<>();
		getPaths(root,path,k);
	}
	
	public static void getPaths(Node root, List<Integer> paths, int k){
		if(root == null){
			return;
		}
		paths.add(root.data);
		getPaths(root.left, paths, k);
		getPaths(root.right, paths,k);
		
		int sum = 0;
		for(int index = paths.size()-1; index >=0 ; index--){
			sum += paths.get(index);
			if(sum == k){
				print(paths,index);
			}
		}
		paths.remove(paths.size()-1);
	}
	
	public static void print(List<Integer>l, int index){
		for(int i = index; i < l.size(); i++){
			System.out.print(l.get(i) + ", ");
			
		}
		System.out.println();
	}
}
