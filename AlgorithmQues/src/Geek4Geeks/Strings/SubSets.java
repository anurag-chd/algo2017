package Geek4Geeks.Strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class SubSets {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
		    int len = sc.nextInt();
		    int arr []= new int[len];
		    for(int i = 0; i< len; i++){
		        arr[i] = sc.nextInt();
		    }
		    printSubSets(arr);
		    t--;
		}
	}
	@SuppressWarnings({"unchecked","unused"})
	public static void printSubSets(int arr[]){
	    if(arr == null || arr.length == 0){
	        System.out.println("()");
	        return;
	    }
	    LinkedList<LinkedList<Integer>> arrList = new LinkedList<>();
	    arrList.add(new LinkedList<>());
	    Arrays.sort(arr);
	    
	    Set<String> set = new HashSet<>();
	    for(int i = 0; i < arr.length ; i++){
	        LinkedList<LinkedList<Integer>> temp = cloneList(arrList);
	        Iterator<LinkedList<Integer>> itr = temp.iterator();
	       // System.out.println(temp);
	        while(itr.hasNext()){
	            LinkedList<Integer> l = (LinkedList<Integer>)itr.next();
	            String str = getString(l);
	            str += arr[i];
	            //System.out.println(str);
	            if(!set.contains(str)){
	                l.add(arr[i]);
	                set.add(str);
	            }
	            else{
	                itr.remove();
	            }
	        }
	        System.out.println(arrList);
	        arrList.addAll(temp);
	        System.out.println(arrList);
	    }
	    
	    for(LinkedList<Integer> l : arrList){
	        System.out.print("(");
	        for(int index =0 ; index < l.size() ; index++){
	            if(index != l.size() -1){
	                System.out.print(l.get(index)+ " ");
	            }
	            else{
	                System.out.print(l.get(index));
	            }
	        }
	         System.out.print(")");
	    }
	    System.out.println();
	}
	
	public static LinkedList<LinkedList<Integer>> cloneList(LinkedList<LinkedList<Integer>> a){
		LinkedList<LinkedList<Integer>> l = new LinkedList<>();
		for(LinkedList<Integer> list : a){
			LinkedList<Integer> temp = new LinkedList<>();
			for(int i : list){
				temp.add(i);
			}
			l.add(temp);
		}
		return l;
	}
	public static String getString(LinkedList<Integer> l){
	    StringBuilder sbr = new StringBuilder();
	    if(l != null && l.size() > 0){
	        for(int i : l){
	            sbr.append(i);
	        }
	    }
	    return sbr.toString();
	}
}
