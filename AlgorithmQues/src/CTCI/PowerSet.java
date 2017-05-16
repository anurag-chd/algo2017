package CTCI;

import java.util.ArrayList;

public class PowerSet {
	
	public static void main(String args[]){
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(getSubsets2(list));
	}

	
	
	public static ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> set){
		ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<>();
		int max = 1 << set.size();
		System.out.println(max);
		for(int k = 0; k < max ; k++){
			ArrayList<Integer> subSet = convertIntToSet(k,set);
			allSubsets.add(subSet);
			
		}
		return allSubsets;
	}
	
	public static ArrayList<Integer> convertIntToSet(int x, ArrayList<Integer> set){
		ArrayList<Integer> subset = new ArrayList<>();
		int index = 0;
		for(int k = x ; k >0 ; k >>= 1){
			System.out.println(k);
			if((k & 1) == 1){
				subset.add(set.get(index));
				System.out.println(subset);
			}
				
			index++;
		}
		return subset;
	}
}
