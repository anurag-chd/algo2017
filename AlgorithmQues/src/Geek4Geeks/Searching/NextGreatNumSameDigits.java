package Geek4Geeks.Searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class NextGreatNumSameDigits {
	public static void main(String args[]){
		int num = 26963;
		getNextNum(num);
	}
	
	public static void getNextNum(int num){
		if(num/10 <= 0){
			System.out.println("Not Possible");
			return;
		}
		int shortNum = num;
		List<Integer> list = new ArrayList<>();
		List<Integer> sortedList = new ArrayList<>();
		//TreeSet<Integer> set = new TreeSet<>();
		int index1 = -1;
		while(shortNum > 0){
			int temp = shortNum%10;
			if(list.size() > 0 && list.get(list.size()-1) > temp && index1 == -1){
				index1 = list.size();
				
			}
			if(index1 == -1){
				sortedList.add(temp);
			}
			list.add(temp);
			shortNum = shortNum/10;
		}
		
		Collections.sort(sortedList);
		
		if(index1 == -1){
			System.out.println("Not Possible");
			return;
		}
		int d = list.get(index1);
		int num2 = -1;
		for(int i : sortedList){
			if(i > d){
				list.set(index1, i);
				num2 = i;
				sortedList.add(d);
				break;
			}
		}
		
		sortedList.remove(Integer.valueOf(num2));
		Collections.sort(sortedList);
		index1--;
		for(int i : sortedList){
			if(index1 < 0){
				System.out.println("Not Possible");
				return;
			}
			list.set(index1--, i);
		}
		
		int resultNum = 0;
		for(int i = list.size()-1 ; i >= 0; i--){
			resultNum = resultNum*10 + list.get(i);
		}
		
		System.out.println(resultNum);
		return;
		
	}
}
