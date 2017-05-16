package Geek4Geeks.Strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PrintStringsUsingTrie {
	public static void main(String args[]){
		String str1 = "a b b c";
		String str2 = "a c d";
		String str3 = "a b b";
		String str4 = "a b b a";
		
		Trie t = new Trie();
		t.insert(str1);
		t.insert(str2);
		t.insert(str3);
		t.insert(str4);
		
		System.out.println(t.search("a b b c" ));
		System.out.println(t.getAllStrings());
	}
}
class TrieNode{
    Map<Character,TrieNode> trieMap;
    boolean isLeaf;
    
    public TrieNode(){
        this.trieMap = new HashMap<>();
    }
}

class Trie{
    TrieNode root;
    
    public void insert(String str){
        if(str == null || str.length() == 0){
            return;
        }
        if(this.root == null){
            this.root = new TrieNode();
        }
        TrieNode curr = this.root;
        for(char c : str.toCharArray()){
            if(!curr.trieMap.containsKey(c)){
                curr.trieMap.put(c ,new TrieNode());   
                
            }
            curr = curr.trieMap.get(c);
        }
        curr.isLeaf = true;
    }
    
    public boolean search(String str){
        if(str == null || str.length() == 0)
            return true;
        if(this.root == null){
            return false;
        }
        TrieNode curr = this.root;
        for(char c : str.toCharArray()){
            if(!curr.trieMap.containsKey(c)){
                return false;
            }
            curr = curr.trieMap.get(c);
        }
        
        return curr.isLeaf;
    }
    
    public List<String> getAllStrings(){
        List<String> strList = new ArrayList<>();
        if(this.root == null){
            return strList;
        }
        StringBuilder sbr = new StringBuilder();
        getStrings(this.root, sbr, strList);
        return strList;
        
    }
    
    public void getStrings(TrieNode root, StringBuilder sbr, List<String> list){
        Map<Character, TrieNode> trieMap = root.trieMap;
        if(trieMap != null && trieMap.size() >0){
        	List<Character> l = new ArrayList<>(trieMap.keySet());
        	Collections.sort( l,( x, y)->  (int)x-(int)y);
        	for(char c : l){
        		sbr.append(c);
        		TrieNode temp = trieMap.get(c);
        		if(temp.isLeaf){
        			list.add(sbr.toString());
        		}
        		getStrings(temp,sbr,list);
        		sbr.deleteCharAt(sbr.length()-1);
        	}
        }
    }
}