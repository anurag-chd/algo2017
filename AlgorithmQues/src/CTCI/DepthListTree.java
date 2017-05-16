package CTCI;

import java.util.ArrayList;
import java.util.List;

public class DepthListTree {
	public static void main(String args[]){
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.left.left = new Node(7);
		
		List<List<Node>> l= new ArrayList<>();
		prepareDepthList(root, 0, l);
		System.out.println(l);
	}
	
	public static void prepareDepthList(Node root, int h, List<List<Node>> l){
		if(root == null)
			return;
		
		
		if(l.size() < h+1){
			l.add(new ArrayList<Node>());
		}
		l.get(h).add(root);	
		prepareDepthList(root.left, h+1, l);
		prepareDepthList(root.right, h+1, l);
		return;
		
	}
}
