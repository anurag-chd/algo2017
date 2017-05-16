package Geek4Geeks.Trees;

public class LargestBinaryTree {
	public static int max_count = 0;
	public static int curr_count = 0;
	public static Node parent = null;
	public static void main(String args[]){
		max_count = 0;
		curr_count = 0;
		Node root = new Node(3);
		root.left = new Node(2);
		root.right = new Node(4);
		
//		Node root = new Node(1);
//		root.left = new Node(20);
//		root.right = new Node(10);
//		root.right.left = new Node(5);
//		root.right.left.left = new Node(3);
//		root.right.left.right = new Node(6);
//		root.right.left.left.right = new Node(4);
//		root.right.right = new Node(15);
//		root.right.right.right = new Node(25);
//		
//		root.left.right = new Node(30);
//		root.left.left = new Node(16);
		
		System.out.println(getTotalNodes(root));
		System.out.println(getBiggestBST(root));
		parent = null;
	//	System.out.println(checkBst(root));
		System.out.println(max_count);
		
		
		
	}
	
	public static int getBiggestBST(Node root){
		if(root == null){
			return 0;
		}
		if(isBst(root)){
			return getTotalNodes(root);
		}
		parent = null;
		int left = 0;
		if(isBst(root.left)){
			left = getTotalNodes(root.left);
		}
		parent = null;
		int right = 0;
		if(isBst(root.right)){
			right = getTotalNodes(root.right);
		}
		
		return Math.max(left, right);
	}
	
	public static int getTotalNodes(Node root){
		if(root == null){
			return 0;
		}
		return 1 + getTotalNodes(root.left) + getTotalNodes(root.right);
	}
	
	
	public static boolean isBst(Node root){
        if(root == null)
            return true;
        if(!isBst(root.left)){
            return false;
        }
        if(parent != null && parent.data > root.data){
            return false;
        }
        parent = root;
        
        return isBst(root.right); 
            
            
    }
	
	public static void checkBst(Node root){
		if(root == null){
			return ;
		}
		checkBst(root.left);
		max_count = Math.max(curr_count, max_count);
		if(parent != null && parent.data > root.data){
			parent = null;
			curr_count = 0;
		}
		else if(parent == null){
			curr_count = 1;
		}
		else{
			curr_count++;
		}
		parent = root;
		 checkBst(root.right);
		max_count = Math.max(curr_count, max_count);
		
		
		return ;
		
	}
}
