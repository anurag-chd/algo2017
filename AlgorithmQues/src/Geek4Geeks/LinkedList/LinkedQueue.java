package Geek4Geeks.LinkedList;

public class LinkedQueue {
	int size;
	int maxSize;
	DNode head,tail;
	
	public static void main(String args[]){
		LinkedQueue queue = new LinkedQueue(4);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.print();
		
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		queue.enqueue(5);
		queue.enqueue(6);
		queue.print();
	}
	
	public void print(){
		DNode curr = head;
		while(curr != null){
			System.out.print(curr + ", ");
			curr = curr.next;
		}
		System.out.println();
	}
	
	public LinkedQueue(int maxSize){
		this.maxSize = maxSize;
	}
	
	public void enqueue(int data){
		if(size == maxSize){
			System.out.println("Queue is full");
			return;
		}
		size++;
		DNode n = new DNode(data);
		if(head == null){
			head = n;
			tail = n;
		}
		else{
			tail.next = n;
			n.prev = tail;
			tail = tail.next;
		}
		return;
	}
	
	public int dequeue(){
		if(size == 0){
			System.out.println("Queue is empty");
			return Integer.MAX_VALUE;
		}
		size--;
		if(head == tail){
			int result = head.val;
			head = null;
			tail = null;
			return result;
		}
		else{
			int result = head.val;
			DNode temp = head.next;
			temp.prev = null;
			head.next = null;
			head = temp;
			return result;
		}
	}
}

class DNode{
	int val;
	DNode next;
	DNode prev;
	
	public DNode(int val){
		this.val = val;
	}
	
	public String toString(){
		return this.val+"";
	}
}
