package Geek4Geeks.Trees;

import java.util.Stack;

public class LevelDifference {
	public static void main(String args[]){
		Node root = new Node(2);
		root.left = new Node(1);
		root.right = new Node(3);
		System.out.println(getLevelDiff(root));
	}
	
	static int getLevelDiff(Node root)
    {
        // Your code here
        if(root == null)
            return 0;
        boolean odd = true;
        return getDiff(root, odd, 0);
    }
    
	static int getDiff(Node
			root, boolean odd, int sum){
		Stack<Integer> s = new Stack<>();
        if(root == null)
            return 0;
        int left = getDiff(root.left, !odd, sum);
        int right =  getDiff(root.right, !odd, sum);
        int data = root.data;
        if (!odd){
        	data = data * -1;
        }
         return data + left + right;
        
        
       // return  getDiff(root.left, odd, sum) + getDiff(root.right, odd, sum);
    }
}

class Node{
	int data;
	Node left,right;
	
	public Node(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
	public String toString(){
		return this.data+"";
	}
	
	
}
