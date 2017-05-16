package Geek4Geeks.Trees;

public class BinaryTreeFromParentArray {
	
	public static Node root;
	public static void main(String args[]){
		int arr [] ={1, 5, 5, 2, 2, -1, 3};
		
		createTree(arr);
		inorderPrint(root);
		
		
	}
	
	public static void inorderPrint(Node root){
		if(root == null)
			return;
		inorderPrint(root.left);
		System.out.print(root.data +" ");
		inorderPrint(root.right);
		
	}
	
	public static void createTree(int arr[]){
		Node[] created = new Node[arr.length];
		
		for(int index = 0; index < arr.length ; index++){
			created[index] = null;
		}
		for(int index = 0; index < arr.length; index++){
			createNode(arr,created,index);
		}
	}
	
	public static void createNode(int arr[], Node created[], int index){
		if(created[index] != null){
			return;
		}
		
		if(arr[index] == -1){
			created[index] = new Node(index);
			root = created[index];
			return;
		}
		
		if(created[arr[index]] == null){
			createNode(arr, created, arr[index]);
		}
		Node n = created[arr[index]];
		created[index] = new Node(index);
		if(n.left == null){
			n.left = created[index];
		}
		else{
			n.right = created[index];
		}
	}
}
