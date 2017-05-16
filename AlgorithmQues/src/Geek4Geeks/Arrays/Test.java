package Geek4Geeks.Arrays;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Test {
		public static boolean sameSide = false;
		public static void main(String[] args){
			BST tree = new BST();
			tree.insert(5);
			tree.insert(6);
			tree.insert(3);
			tree.insert(1);
			tree.insert(2);
			tree.insert(4);
			tree.inorderTraversal(tree.root);
			
			System.out.println(getDistance(tree.root, 2, 4));
		}
		
		public static int getDistance(BinaryTreeNode root, int n1, int n2){
			if(root == null){
				return -1;
			}
			// get LCA
			BinaryTreeNode lca = LCA(root,n1,n2);
			boolean inLeft = isPresent(lca.left, n1, n2);
			boolean inRight = isPresent(lca.right, n1, n2);
			if(inLeft && inRight){
				return getDist(lca,n1) + getDist(lca,n2);
			}
			else
				return Math.abs(getDist(lca,n1) -getDist(lca,n2));
			
		}
		
		public static int getDist(BinaryTreeNode root, int num){
			if(root == null || root.val == num){
				return 0;
			}
			if(root.val > num){
				return 1+getDist(root.left,num);
			}
			else{
				return 1+ getDist(root.right,num);
			}
			
		}
		
		public static BinaryTreeNode LCA(BinaryTreeNode root, int n1, int n2){
			if(root == null){
				return null;
			}
			if(root.val == n1 || root.val == n2)
				return root;
			boolean inLeft = isPresent(root.left, n1, n2);
			boolean inRight = isPresent(root.right, n1, n2);
			
			if(inLeft && inRight)
				return root;
			else if(inLeft){
				sameSide = true;
				return LCA(root.left,n1,n2);
			}
			else if(inRight){
				sameSide = true;
				return LCA(root.right, n1, n2);
			}
			else
				return null;
			
		}
		
		public static boolean isPresent(BinaryTreeNode root, int n1 , int n2){
			if(root == null)
				return false;
			if(root.val == n1 || root.val == n2)
				return true;
			return isPresent(root.left , n1, n2) || isPresent(root.right, n1, n2);
		}
		
		public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
			  // Use queue to help BFS
			wordList.add(endWord);
		    Queue<String> queue = new LinkedList<String>();
		    queue.add(beginWord);
		    int level = 0;
		    while(!queue.isEmpty()){
		        int size = queue.size();
		        for(int i = 0; i < size; i++){
		            String cur = queue.remove();
		            if(cur.equals(endWord)){ return level + 1;}
		            for(int j = 0; j < cur.length(); j++){
		                char[] word = cur.toCharArray();
		                for(char ch = 'a'; ch < 'z'; ch++){
		                    word[j] = ch;
		                    String check = new String(word);
		                    if(!check.equals(cur) && wordList.contains(check)){
		                        queue.add(check);
		                        wordList.remove(check);
		                    }
		                }
		            }
		        }
		        level++;
		    }
		    return 0;
			}
		
	}

	class BST{
		BinaryTreeNode root;
		
		public void insert(int val){
			BinaryTreeNode newNode = new BinaryTreeNode(val);
			if(root == null){
				root = newNode;
				return;
			}
			BinaryTreeNode ptr = root;
			BinaryTreeNode prev = null;
			while(true){
				prev = ptr;
				if(val<ptr.val){				
					ptr = ptr.left;
					if(ptr==null){
						prev.left = newNode;
						return;
					}
				}else{
					ptr = ptr.right;
					if(ptr==null){
						prev.right = newNode;
						return;
					}
				}
			}
		}
		
		public void inorderTraversal(BinaryTreeNode root){
			if(root==null)
				return;
			inorderTraversal(root.left);
			System.out.println(root.val);
			inorderTraversal(root.right);
		}

	}

	class BinaryTreeNode {
		int val;
		BinaryTreeNode left;
		BinaryTreeNode right;
		
		public BinaryTreeNode(int val){
			this.val = val;
		}
	}

