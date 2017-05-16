package Geek4Geeks.LinkedList;

public class DeleteNMinus1 {
	public static void main(String args[]){
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		//head.next.next = new ListNode(3);
		printList(head);
		head = remove(head);
		printList(head);
	}
	
	public static ListNode remove(ListNode head){
		if(head == null || head.next == null){
			return null;
		}
		if(head.next.next == null){
			head = head.next;
			return head;
		}
		ListNode curr = head;
		ListNode prev = null;
		while(curr.next.next != null){
			prev = curr;
			curr = curr.next;
//			if( curr.next == null){
//				break;
//			}
		}
		prev.next = curr.next;
		return head;
	}
	
	public static void printList(ListNode head){
		if(head == null){
			System.out.println();
			return ;
		}
		ListNode curr = head;
		while(curr != null){
			System.out.print(curr.data +" ,");
			curr = curr.next;
		}
		System.out.println();
	}
}
