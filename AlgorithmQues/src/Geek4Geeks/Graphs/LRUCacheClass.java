package Geek4Geeks.Graphs;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheClass {
	public static void main(String args[]){
		LRUCache cache = new LRUCache(2);
		cache.set(1,2);
		cache.set(2, 3);
		cache.set(1, 5);
		cache.set(2, 3);
		cache.set(1, 5);
		cache.get(4);
		cache.get(1);
		
	}
}

@SuppressWarnings("unchecked")
class LRUCache  {
    LinkedHashMap<Integer,Integer> map;
    /*Inititalize an LRU cache with size N */
    public LRUCache(int N) {
       //Your code here
        map = new LinkedHashMap(N+1,1.1f, true){
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return this.size() > N;
            }
        };
    }
    
    /*Returns the value of the key x if 
     present else returns -1 */
    public int get(int x) {
       //Your code here
    //   System.out.println("size" + map.size());
       if(map.size() ==0 || !map.containsKey(x)){
           return -1;
       }
       return map.get(x);
    }
    
    /*Sets the key x with value y in the LRU cache */
    public void set(int x, int y) {
       //Your code here
       System.out.println("size" + map.size());
       map.put(x,y);
       
    }
    
    
}

