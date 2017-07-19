package Geek4Geeks.Trees;

import java.util.Stack;

public class TernaryOperator {
	public static void main(String args[]){
		String str = "a?b:c?d:e";
		BTree tree = new BTree();
		tree.root = getExpTree(str);
		tree.preOrderPrint();
	}
	
	public static TreeNode getExpTree(String str){
		if(str == null || str.length() == 0){
			return null;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode root = new TreeNode(str.substring(0,1));
		stack.push(root);
		for(int i = 1;i<str.length(); i++){
			if(str.charAt(i) == '?'){
				TreeNode node = stack.peek();
				TreeNode left = new TreeNode(str.substring(i+1,i+2));
				i++;
				node.left = left;
				stack.push(left);
			}
			else{
				stack.pop();
				TreeNode node = stack.peek();
				TreeNode right = new TreeNode(str.substring(i+1,i+2));
				i++;
				node.right = right;
				stack.push(right);
			}
		}
		
		return root;
	}
	
}

class BTree{
	TreeNode root;
	
	public BTree(){
		
	}
	
	public BTree( String data){
		this.root = new TreeNode(data);
	}
	
	public void preOrderPrint(){
		if(root == null){
			return;
		}
		print(root);
	}
	public void print(TreeNode root){
		if(root == null){
			return;
		}
		System.out.print(root +", ");
		print(root.left);
		print(root.right);
	}
}
class TreeNode{
	String val;
	TreeNode left,right;
	
	public TreeNode(String val){
		this.val = val;
	}
	
	public String toString(){
		return this.val;
	}
}