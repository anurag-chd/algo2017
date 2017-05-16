package Geek4Geeks.LinkedList;

public class SortLinkedList {
	public static void main(String args[]){
		
	}
	
	public ListNode sortedList(ListNode head)
	{
		// Your code here
		java.util.TreeMap <Integer,Integer> map = new java.util.TreeMap<>();
		ListNode temp = head;
		while(temp != null){
		    if(map.containsKey(temp.data)){
		        int count = map.get(temp.data);
		        map.put(temp.data, ++count);
		    }
		    else{
		        map.put(temp.data, 1);
		    }
		    temp = temp.next;
		}
		ListNode newHead = null;
		temp = null;
		
		for(int i : map.keySet()	){
		    int count = map.get(i);
		    while(count > 0){
		        if(newHead == null){
		            newHead = new ListNode(i);
		            temp = newHead;
		        }
		        else{
		            temp.next = new ListNode(i);
		            temp = temp.next;
		        }
		        count--;
		    }
		    
		}
		
		return newHead;
	}
}
