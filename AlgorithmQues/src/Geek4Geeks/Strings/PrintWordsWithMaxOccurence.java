package Geek4Geeks.Strings;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class PrintWordsWithMaxOccurence {
	public static void main(String args[]){
		String str = "practice makes perfect. get perfect by practice. just practice!";
		printWords(str);
		
	}
	
	public static void printWords(String str){
		if(str == null || str.length() == 0){
			return;
		}
		str = str.trim();
		str = str.toLowerCase();
		str = str.replaceAll("  "," ");
		String strArr[] = str.split(" ");
		Map<String, Integer> wordCount = new HashMap<>();
		for(String s : strArr){
			s = s.replaceAll("[^A-Za-z0-9]","");
			if(wordCount.containsKey(s)){
				int c = wordCount.get(s);
				wordCount.put(s, ++c);
			}else{
				wordCount.put(s,1);
			}
		}
		List<FreqWords> list = new LinkedList<>();
		for(String s : wordCount.keySet()){
			list.add(new FreqWords(s,wordCount.get(s)));
		}
		Collections.sort(list);
		
		System.out.println(list);
		return;
		
		
	}
	
	
}
class FreqWords implements Comparable{
	String word;
	int count;
	
	public FreqWords(String word){
		this.word = word;
		this.count = 1;
	}
	
	public FreqWords(String word, int count){
		this.word = word;
		this.count = count;
	}
	
	@Override
	public boolean equals(Object b){
		if(!(b instanceof FreqWords)){
			return false;
		}
		FreqWords obj = (FreqWords)b;
		return this.word.equalsIgnoreCase(obj.word);
	}
	

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		FreqWords obj = (FreqWords) o;
		return this.count > obj.count? -1 : this.count < obj.count ? 1 :0;
	}
	
	public String toString(){
		return "< " +this.word +": "+ this.count +" >";
	}
}
