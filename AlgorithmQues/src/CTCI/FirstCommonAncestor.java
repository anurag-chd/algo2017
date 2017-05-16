package CTCI;

public class FirstCommonAncestor {
	public static void main(String args[]){
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.left.left = new Node(7);
		
		Node node1 = new Node(7);
		Node node2 = new Node(6);
		System.out.println(fca(root, node1, node2));
	}
	
	public static Node fca(Node root, Node node1, Node node2){
		if(root == null){
			return null;
		}
		if(root.data == node1.data ||
				root.data == node2.data)
			return root;
		boolean inLeft = isPresent(root.left, node1, node2);
		boolean inRight = isPresent(root.right, node1, node2);
		
		if(inLeft && inRight)
			return root;
		if(inLeft){
			return fca(root.left,node1,node2);
		}
		if(inRight){
			return fca(root.right, node1, node2);
		}
		else
			return null;
	}
	
	public static boolean isPresent(Node root, Node node1, Node node2){
		if(root == null)
			return false;
		if(root.data == node1.data || root.data == node2.data)
			return true;
		return isPresent(root.left , node1, node2) || isPresent(root.right, node1, node2);
	}

}
