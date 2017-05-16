package CTCI;

import java.util.Stack;

public class SortStack {
	public static void main(String args[]){
		Stack<Integer> s = new Stack<>();
		s.push(7);
		s.push(8);
		s.push(20);
		s.push(4);
		s.push(5);
		s.push(122);
		s.push(2);
		
		System.out.println(sortStack(s));
		System.out.println(s.pop());
		
	}
	
	public static Stack<Integer> sortStack(Stack<Integer> s){
		Stack<Integer> r = new Stack<>();
		while(!s.isEmpty()){
			int temp = s.pop();
			while(!r.isEmpty() && r.peek() > temp){
				s.push(r.pop());
			}
			r.push(temp);
		}
		
		while(!r.isEmpty())
			s.push(r.pop());
		
		return s;
	}

}
