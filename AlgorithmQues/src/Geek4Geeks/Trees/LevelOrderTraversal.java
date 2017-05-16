package Geek4Geeks.Trees;
import java.util.*;

public class LevelOrderTraversal {
	
	public static void main(String args[]){
		Node root = new Node(2);
		root.left = new Node(1);
		root.right = new Node(3);
		
		printLevelOrder(root);
	}
	
	public static void printLevelOrder(Node root){
		if(root == null)
			return;
		List<List<Integer>> levels = new ArrayList<>();
		int height = 0;
		getOrderdList(root, height, levels);
		
		for(List<Integer> l : levels){
			for(int i : l){
				System.out.print(i +" ") ;
			}
			System.out.print("$ ");
		}
		
	}
	
	public static void getOrderdList(Node root, int height, List<List<Integer>>levels){
		if(root == null)
			return;
		if(levels.size() == height){
			List<Integer> temp = new ArrayList<>();
			temp.add(root.data);
			levels.add(height, temp);
		}
		else{
			List<Integer> temp = levels.get(height);
			temp.add(root.data);
		}
		getOrderdList(root.left, height+1, levels);
		getOrderdList(root.right, height+1, levels);
		return;
	}

}
