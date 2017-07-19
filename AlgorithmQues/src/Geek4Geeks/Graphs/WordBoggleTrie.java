package Geek4Geeks.Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class WordBoggleTrie {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
		    int wordCount = sc.nextInt();
		   // Set<String> dict = new HashSet<>();
		    Trie dict = new Trie(); 
		    for(int i = 0; i< wordCount; i++){
		        dict.addString(sc.next());
		    }
		    int row = sc.nextInt();
		    int col = sc.nextInt();
		    char [][] boggle = new char[row][col];
		    for(int i = 0; i<row; i++){
		        for(int j =0; j<col; j++){
		            String s = sc.next();
		            boggle[i][j] = s.charAt(0);
		        }
		    }
		    
		    getBoggle(dict, boggle);
		    //System.out.println();
		    t--;
		}
	}
	
	public static void getBoggle(Trie dict, char[][] boggle){
	   int row = boggle.length;
	    int col = boggle[0].length;
	    boolean visited[][] = new boolean[row][col];
	    TrieNode currNode = dict.root;
	    Set<String> checkwords = new HashSet<String>();
	    for(int rowIndex = 0; rowIndex < row; rowIndex++){
	        for(int colIndex = 0; colIndex < col; colIndex++){
	            if(currNode.containsKey(boggle[rowIndex][colIndex])){
	                StringBuilder sbr = new StringBuilder();
	                dfs(currNode.get(boggle[rowIndex][colIndex]), boggle, visited, sbr, rowIndex, colIndex, checkwords);    
	            }
	        }
	    }
	    
	  //  Collections.sort(checkwords);
	    List<String> l = new ArrayList<>(checkwords);
	    Collections.sort(l);
	    
	    for(String s : l){
	    	System.out.print(s+ " ");
	    }
	    System.out.println();
	    
	}
	
	public static void dfs(TrieNode node, char[][] boggle, boolean[][] visited, 
	                        StringBuilder sbr, int row, int col, Set<String> checkwords){
	   visited[row][col] = true;
	   sbr.append(boggle[row][col]+"");
	   if(!checkwords.contains(sbr.toString()) && node.isWord ){
	       checkwords.add(sbr.toString());
	       //System.out.print(sbr.toString() + " ");
	   }
	   
	   int rowLen = boggle.length;
	   int colLen = boggle[0].length;
	   if(row > 0 && col > 0 && !visited[row-1][col-1] && node.containsKey(boggle[row-1][col-1])){
	       dfs(node.get(boggle[row-1][col-1]),boggle,visited,sbr,row-1,col-1, checkwords);
	   }
	   if( row > 0 && !visited[row-1][col] && node.containsKey(boggle[row-1][col])){
	       dfs(node.get(boggle[row-1][col]),boggle,visited,sbr,row-1,col, checkwords);
	   }
	   if(row > 0 && col < colLen-1 && !visited[row-1][col+1] && node.containsKey(boggle[row-1][col+1])){
	       dfs(node.get(boggle[row-1][col+1]),boggle,visited,sbr,row-1,col+1, checkwords);
	   }
	   if( col > 0 && !visited[row][col-1] && node.containsKey(boggle[row][col-1])){
	       dfs(node.get(boggle[row][col-1]),boggle,visited,sbr,row,col-1, checkwords);
	   }
	   if( col < colLen-1 && !visited[row][col+1] && node.containsKey(boggle[row][col+1])){
	       dfs(node.get(boggle[row][col+1]),boggle,visited,sbr,row,col+1, checkwords);
	   }
	   if(row < rowLen-1 && col > 0 && !visited[row+1][col-1] && node.containsKey(boggle[row+1][col-1])){
	       dfs(node.get(boggle[row+1][col-1]),boggle,visited,sbr,row+1,col-1, checkwords);
	   }
	   if(row < rowLen-1  &&  !visited[row+1][col] && node.containsKey(boggle[row+1][col])){
	       dfs(node.get(boggle[row+1][col]),boggle,visited,sbr,row+1,col, checkwords);
	   }
	   if(row < rowLen-1 && col < colLen-1 && !visited[row+1][col+1] && node.containsKey(boggle[row+1][col+1])){
	       dfs(node.get(boggle[row+1][col+1]),boggle,visited,sbr,row+1,col+1, checkwords);
	   }
	   visited[row][col] = false;
	   sbr.deleteCharAt(sbr.length() -1);
	   
	   
                          
	}
	
}

class TrieNode {
    boolean isWord;
    Map<Character,TrieNode> charMap;
    
    public TrieNode(){
        charMap = new HashMap<>();
        
    }
    
    public boolean containsKey(char c){
        return charMap.containsKey(c);
    }
    
    public TrieNode get(char c){
        return charMap.get(c);
    }
    
    public void put(char c , TrieNode node){
        charMap.put(c, node);
    }
}

class Trie{
    TrieNode root;
    
    public void addString(String str){
        if(str == null || str.length() == 0){
            return;
        }
        if(root == null){
            root = new TrieNode();
        }
        TrieNode curr = root;
        for(int i = 0; i < str.length();i++){
            char c = str.charAt(i);
            if(!curr.containsKey(c)){
                curr.put(c, new TrieNode());
            }
            curr = curr.get(c);
        }
        curr.isWord = true;
        
    }
}
