package Geek4Geeks.LinkedList;

public class RevereseListGroupN {
	public static ListNode curr, tail,next;
	public static void main(String args[]){
		ListNode head = new ListNode(1);
		 head.next = new ListNode(2);
		 head.next.next = new ListNode(3);
		 head.next.next.next = new ListNode(4);
		 head.next.next.next.next = new ListNode(5);
		 head.next.next.next.next.next = new ListNode(6);
		 head.next.next.next.next.next.next = new ListNode(7);
		 head.next.next.next.next.next.next.next = new ListNode(8);
		 
		// head = splitList(head , 3);
		 head = revList(head,3);
		 printList(head);
		
	}
	
	public static ListNode revList(ListNode head, int k){
		if(head == null){
			return null;
		}
		int count = 0;
		ListNode prev = null;
		ListNode curr = head;
		ListNode temp = null;
		while(curr != null && count < k ){
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
			count++;
		}
		head.next = revList(curr,k);
		return prev;
	}
	
	
	
	
	public static void printList(ListNode head){
		ListNode temp = head;
		while(temp != null){
			System.out.print(temp.data + " ");
			temp = temp.next;
			
		}
		System.out.println();
	}
	
	// chutiaap code
	
	public static ListNode splitList(ListNode head, int k){
		if(head == null){
			return null;
		}
		 curr = head;
		 next = head;
		 tail = head;
		 ListNode prevHead = null, prevTail = null;
		while(curr != null){
			
			reverseList(k);
			if(prevHead == null){
				prevHead = tail;
			}
			if(prevTail == null){
				prevTail = curr;
			}
			else{
				prevTail.next = tail;
				prevTail = curr;
			}
			curr = next;
		}
		return prevHead;
		
	}
	
	public static void reverseList(int k){
		ListNode prev = null;
		ListNode current = curr;
		while(current != null && k>0){
			k--;
			ListNode temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
			if(current!= null && (current.next == null ||  k ==1)){
				tail = current;
				if(tail != null)
					next = tail.next;
				else{
					next = null;
				}
			}
		}
		printList(tail);
	}
}
