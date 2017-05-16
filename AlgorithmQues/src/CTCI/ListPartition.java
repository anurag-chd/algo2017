package CTCI;


public class ListPartition {
	public static void main(String args[]){
		LinkedList list = new LinkedList(3);
		list.addNode(5);
		list.addNode(8);
		list.addNode(5);
		list.addNode(10);
		list.addNode(2);
		list.addNode(1);
		list.printList();
		System.out.println();
		divideList(list ,5);
		list.printList();
	}
	
	public static void divideList(LinkedList list, int val){
		if(list.head == null || list.head.next == null)
			return;
		
		ListNode beforeStart = null;
		ListNode beforeEnd = null;
		ListNode afterStart = null;
		ListNode afterEnd = null;
		ListNode temp = list.head;
		while(temp != null){
			if(temp.data < val){
				if(beforeStart == null){
					beforeStart = new ListNode(temp.data);
					beforeEnd = beforeStart;
				}
				else{
					beforeEnd.next = new ListNode(temp.data);
					beforeEnd = beforeEnd.next;
					
				}
			}
			else{
				if(afterStart == null){
					afterStart = new ListNode(temp.data);
					afterEnd = afterStart;
				}
				else{
					afterEnd.next = new ListNode(temp.data);
					afterEnd = afterEnd.next;
					
				}
			}
			temp = temp.next;
		}
		if(beforeStart == null){
			list.head = afterStart;
		}else{
			beforeEnd.next = afterStart;
			list.head = beforeStart;
		}
		return;
		
	}
}
