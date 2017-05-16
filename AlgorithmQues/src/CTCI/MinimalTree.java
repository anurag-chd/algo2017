package CTCI;

public class MinimalTree {
	public static void main(String args[]){
		int arr[] = {1,2,3,4,5,6,7,8};
		Tree tree = getMinimalTree(arr);
		tree.printInOrder(tree.root);
		
	}
	
	public static Tree getMinimalTree(int arr[]){
		Tree tree = null;
		if(arr == null || arr.length == 0)
			return tree;
		
		if(arr.length == 1){
			tree = new Tree(arr[0]);
			return tree;
		}	
		int start = 0;
		int end = arr.length-1;
		
		Node node = getTree(arr, start, end);	
		if(node != null){
			tree = new Tree();
			tree.root = node;
		}
		
		return tree;
		
	}
	
	public static Node getTree(int arr[], int start, int end){
		if(start > end){
			return null;
		}
		int mid = (start + end)/2;
		Node root = new Node(arr[mid]);
		root.left = getTree(arr,start,mid-1);
		root.right = getTree(arr,mid+1,end);
		return root;
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

class Tree{
	Node root;
	public Tree(int data){
		this.root = new Node(data);
	}
	public Tree(){
		
	}
	
	public void printPreOrder(Node root){
		if(root == null)
			return;
		System.out.print(root+ " ,");
		printPreOrder(root.left);
		printPreOrder(root.right);
		
	}
	
	public void printInOrder(Node root){
		if(root == null)
			return;
		printInOrder(root.left);
		System.out.print(root+ " ,");
		printInOrder(root.right);
	}
	
	public void printPostOrder(Node root){
		if(root == null)
			return;
		printPostOrder(root.left);
		printPostOrder(root.right);
		System.out.print(root+ " ,");
		
	}
}
