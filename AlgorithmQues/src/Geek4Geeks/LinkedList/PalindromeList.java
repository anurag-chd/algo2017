package Geek4Geeks.LinkedList;

public class PalindromeList {
	public static void main(String args[]){
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		//head.next.next = new ListNode(3);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);
		
		System.out.println(isPalindrome(head));
	}
	
	public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode head2 = null;
        ListNode temp1= head;
        ListNode temp2 = head.next;
        boolean isEven = false;
        while(temp2.next != null && temp2.next.next != null){
            temp2 = temp2.next.next;
            temp1 = temp1.next;
        }
         if(temp2.next == null){
                isEven = true;
            }
        head2 = temp1.next;
        if(!isEven){
            head2 = head2.next;
        }
        ListNode tail1 = temp1;
        ListNode newHead = revList(head2);
        temp1 = head;
        head2 = newHead;
        while(temp1 != tail1.next && head2 != null){
            if(temp1.data != head2.data){
                return false;
            }
            temp1 = temp1.next;
            head2 = head2.next;
        }
        if(head2 != null){
            return false;
        }
        if(temp1 != tail1.next){
            return false;
        }
        
        head2 = revList(newHead);
        if(isEven){
            tail1.next = head2;
        }
        else{
            tail1.next.next = head2;
        }
        return true;
        
    }
    
    public static ListNode revList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while(curr != null){
            
        	next = curr.next;
        	curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
