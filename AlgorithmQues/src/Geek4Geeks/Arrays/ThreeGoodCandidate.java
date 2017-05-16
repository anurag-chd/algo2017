package Geek4Geeks.Arrays;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ThreeGoodCandidate {
	public static void main (String[] args) {
		String str = "-180 180 -402 -14 -482 252 -37 -402 195 -490 5 -321 -358 -434 -402 -75 -28 478 353 466 297 248 47 -228 16 -414 412 -341 377 400 53 -303 432 -497 -465 451 -393 -2 -451 -346 361 406 -166 -497 -175 284 -72 297 263 133 -385 60 -119 -486 -315 397 -400 -403 -92 -171 -151 -187 379 134 -184 414 85 275 265 486 430 126 392 116 129 69 252 -91 -134 15 -105 333 -72 276 347 113 -474 -200 -438 286 129 263 -400 8 -103 -84 275";
		int arr [] = new int [97];
		int index = 0;
		for(String s : str.split(" "))
			arr[index++] = Integer.valueOf(s);
		System.out.println(find(arr));
	}
	
	public static int find(int arr[]){
		TreeSet<Integer> tSet = new TreeSet<>();
	    for(int a : arr){
	        tSet.add(a);
	    }
	    
	    
	    int max1 = tSet.last();
	    tSet.remove(max1);
	    int max2 = tSet.last();
	    tSet.remove(max2);
	    int max3 = tSet.last();
	    
	    int min1 = Integer.MIN_VALUE;
	    if(!tSet.isEmpty()){
	        min1 = tSet.first();
	        tSet.remove(min1);
	    }
	    int min2 = Integer.MIN_VALUE;
	    if(!tSet.isEmpty()){
	        min2 = tSet.first();
	        tSet.remove(min2);    
	    }
	    int prod1 = max1 * max2 *max3;
	    int prod2 = 0;
	    if(min1 == Integer.MIN_VALUE || min2 == Integer.MIN_VALUE)
	        prod2 = Integer.MIN_VALUE;
	    else
	        prod2 = min1 * min2 * max1;
	    
	    
	    
	    
	    return prod1 > prod2 ? prod1 : prod2;
	}
}
