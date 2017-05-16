package CTCI;

import java.util.HashSet;
import java.util.Set;


public class RemoveDupsLinkedList {
	
	
	
	
	public static void main(String args[]){
		
		LinkedList list = new LinkedList(1);
		list.addNode(2);
		list.addNode(3);
		list.addNode(4);
		list.addNode(2);
		list.addNode(5);
		list.printList();
		System.out.println();
		removeDups(list);
		list.printList();
		
	}
	
	
	
	public static void removeDups(LinkedList list){
		if(list.head == null || list.head.next == null)
			return;
		Set<Integer> set = new HashSet<>();
		set.add(list.head.data);
		ListNode prev = list.head;
		ListNode curr = prev.next;
		while(curr.next != null){
			if(set.contains(curr.data)){
				prev.next = curr.next;
			}
			else{
				set.add(curr.data);
				prev = curr;
			}
			curr = curr.next;
			
		}
		
	}

}

class LinkedList {
	ListNode head;
	
	
	public LinkedList(int data){
		this.head = new ListNode(data);
	}
	
	public void addNode(int data){
		if(this.head == null){
			this.head = new ListNode(data);
			return;
		}
		else{
			ListNode temp = this.head;
			while(temp.next != null)
				temp = temp.next;
			temp.next = new ListNode(data);
		}
	}
	
	public void printList(){
		if(this.head == null)
			return;
		ListNode temp = this.head;
		while(temp != null){
			System.out.print(temp.data + " ,");
			temp = temp.next;
		}
		
	}
}

 class ListNode{
	int data;
	ListNode next;
	
	public ListNode(int data){
		this.data = data;
		this.next = null;
	}
	
	public String toString(){
		return this.data+ "";
	}
}