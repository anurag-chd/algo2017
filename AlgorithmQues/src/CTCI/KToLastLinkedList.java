package CTCI;

import java.util.ArrayList;


public class KToLastLinkedList {
	public static void main(String args[]){
		LinkedList list = new LinkedList(1);
		list.addNode(2);
		list.addNode(3);
		list.addNode(4);
		list.addNode(2);
		list.addNode(5);
		list.printList();
		System.out.println();
		System.out.println(lastKth(list, 3));
	}
	
	public static int lastKth(LinkedList list, int k){
		if(list.head == null)
			return -1;
		ListNode node = list.head;
		ArrayList<Integer> l = new ArrayList<>();
		lastKthNode(node,k, l);
		return l.get(0);
		
		
	}
	
	public static int lastKthNode(ListNode node, int k, ArrayList<Integer>set){
		if(node.next == null){
			return k-1;
		}
		k = lastKthNode(node.next , k, set);
		if(k == 1){
			if(set.isEmpty()){
				set.add(node.data);
			}
			return k;
			
		}
		else
			return k-1;
	}

}
