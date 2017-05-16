package Geek4Geeks.Graphs;

import java.util.HashMap;

public class LRUCache2 {
	int capacity;
	HashMap<Integer,Node> map;
	DList list;
	
	// SET 1 2 SET 2 3 SET 1 5 SET 4 5 SET 6 7 GET 4 GET 1
//	public static void main(String args[]){
//		LRUCache2 cache = new LRUCache2(2);
//		cache.put(1,2);
//		cache.put(2,3);
//		cache.put(1,5);
//		cache.put(4,5);
//		cache.put(6,7);
//		System.out.println(cache.getVal(4));
//		System.out.println(cache.getVal(1));
//		cache.print();
//		
//	}
	
	public LRUCache2(int capacity){
		this.capacity = capacity;
		this.map = new HashMap<>();
		this.list = new DList();
	}
	
	public void print(){
		list.print();
	}
	
	public void put(int key, int value){
		if(!map.containsKey(key)){
			Node node = new Node(key,value);
			if(map.size() == capacity){
				map.remove(list.tail.key);
				list.removeNode(list.tail);
			}
			map.put(key, node);
			list.addNode(node);
		}
		else{
			Node node = map.get(key);
			node.data = value;
			list.removeNode(node);
			list.addNode(node);
		}
		
	}
	
	public int getVal(int data){
		if(map.containsKey(data)){
			Node node = map.get(data);
			list.removeNode(node);
			list.addNode(node);
			return node.data;
		}
		return -1;
	}
	public void remove(int data){
		if(map.containsKey(data)){
			Node node = map.get(data);
			list.removeNode(node);
			map.remove(data);
		}
	}
	
	public int getSize(){
		return map.size();
	}
	
	
	
	class DList{
		Node head,tail;
		
		public DList(){
			this.head = null;
			this.tail = null;
		}
		
		public void print(){
			Node temp = head;
			while(temp != null){
				System.out.print(temp+ " ,");
				temp = temp.next;
			}
			System.out.println();
		}
		
		public void addNode(Node node){
			if(head == null){
				head = node;
				tail = node;
			}
			else{
				node.next = head;
				head.prev = node;
				head = node;
			}
		}
		
		public Node removeNode(Node node){
			if(head == null){
				return null;
			}
			if(node.equals(head) && node.equals(tail)){
				head = null;
				tail = null;
				
			}
			else if(node.equals(head)){
				head = node.next;
				head.prev = null;
			}
			else if(node.equals(tail)){
				tail = node.prev;
				tail.next = null;
			}
			else{
				node.prev.next = node.next;
				node.next.prev = node.prev;
			}
			return node;
		}
		
	}
	class Node{
		int key;
		int data;
		Node next,prev;
		
		public Node(int key,int data){
			this.key = key;
			this.data = data;
		}
		
		@Override
		public String toString(){
			return "<" + this.key+","+this.data+">";
		}
		
		@Override
		public boolean equals(Object b){
			if(b instanceof Node){
				Node temp = (Node) b;
				return temp.key == this.key && temp.data == this.data;
			}
			return false;
			
		}
		
		
	}

}
