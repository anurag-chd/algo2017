package CTCI;

public class CheckBalanced {
	public static Node parent;
	public static void main(String args[]){
		Node root = new Node(20);
		root.left = new Node(10);
		root.left.left = new Node(5);
		root.left.left.left = new Node(2);
		root.left.left.left.right = new Node(3);
		System.out.println(isBST(root));
		
	}
	
	static int isBST(Node root)  
    {
        // Your code here
        if(root == null){
            return 1;
        }
        if(isBST(root.left) == 0) return 0;
        if(parent != null && parent.data > root.data) return 0;
        parent = root;
        if(isBST(root.right) == 0) return 0;
        
        return 1;
    }

}
