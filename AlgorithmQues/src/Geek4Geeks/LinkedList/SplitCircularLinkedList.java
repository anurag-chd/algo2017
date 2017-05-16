package Geek4Geeks.LinkedList;

public class SplitCircularLinkedList {
	public static void main(String args[]){
		circular_LinkedList list = new circular_LinkedList();
		list.head = new Node(1);
		list.head.next = new Node(5);
		list.head.next.next = new Node(7);
		list.head.next.next.next = list.head;
		splitList(list);
		printList(list.head1);
		printList(list.head2);
	}
	
	public static void printList(Node head){
		Node temp = head;	
		while(temp != null ){
			System.out.print(temp.data+" ,");
			temp= temp.next;
		}
		System.out.println();
	}
	public static void splitList(circular_LinkedList list)
    {
             // Your code here
             if(list.head == null || list.head.next == null){
                 return;
             }
             int count = 1;
             Node temp = list.head.next;
             Node endNode = null;
             while(temp.data != list.head.data && temp.next.data != list.head.next.data){
                 count++;
                 if(temp.next.data == list.head.data && 
                    temp.next.next.data == list.head.next.data){
                        endNode = temp;
                    }
                 temp = temp.next;
                 if(temp == null){
                     return;
                 }
             }
             int l1Len = 0;
             if(count%2 == 0){
                 l1Len = count/2;
             }
             else{
                 l1Len = count/2 +1;
             }
             
             list.head1 = list.head;
             temp = list.head;
             while(l1Len >0){
                 l1Len--;
                 if(l1Len == 0){
                     list.head2 = temp.next;
                     temp.next = list.head1;
                 }else{
                     temp = temp.next;
                 }
             }
             endNode.next = list.head2;
             
	 }
}

class circular_LinkedList
{
    Node head;  // head of list
    Node head1,head2;  //heads of splitedLists

    // other utility functions
}
class Node {
	   int data;
	    Node next;
	    Node(int d)  { data = d;  next = null; }
	}