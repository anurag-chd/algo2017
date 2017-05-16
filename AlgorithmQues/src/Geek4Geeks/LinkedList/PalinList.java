package Geek4Geeks.LinkedList;


public class PalinList {
	public static void main(String args[]){
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		//head.next.next = new ListNode(3);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(1);
		
		System.out.println(checkPalin(head));
	}
	
	public static boolean checkPalin(ListNode head){
		if(head == null || head.next == null){
			return false;
		}
		int listLen = getLen(head);
		boolean isEven = listLen%2 == 0 ? true : false;
		int mid = (listLen/2) + 1;
		int count = mid;
		ListNode rHead = head;
		ListNode lHead = head;
		while(mid > 1){
			if(mid == 2){
				lHead = rHead;
			}
			rHead = rHead.next;
			
			mid--;
		}
		if(!isEven){
			rHead = rHead.next;
			
		}
		
		revList(head,count-1);
		while(lHead != null && rHead!= null){
			if(lHead.data != rHead.data){
				return false;
			}
			lHead = lHead.next;
			rHead = rHead.next;
		}
		if(lHead == null && rHead == null){
			return true;
		}
		return false;
		
	}
	
	public static ListNode revList(ListNode head, int count){
		if(count == 1){
			head.next = null;
			return head;
		}
		ListNode parent = revList(head.next,count-1);
		parent.next = head;
		head.next = null;
		return head;
	}
	
	
	public static int getLen(ListNode head){
		if(head == null){
			return 0;
		}
		int count = 0;
		ListNode temp = head;
		while(temp != null){
			count++;
			temp = temp.next;
		}
		return count;
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
