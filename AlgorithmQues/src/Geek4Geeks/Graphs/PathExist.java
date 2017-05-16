package Geek4Geeks.Graphs;

import java.util.*;
import java.lang.*;
import java.io.*;

public class PathExist {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
		    int n = sc.nextInt();
		    if(n < 1){
		        return;
		    }
		    int arr[][]  = new int[n][n];
		    int startX = -1, startY =-1;
		    int endX = -1, endY = -1;
		    for(int i = 0; i< n; i++){
		        for(int j = 0; j< n; j++){
		            arr[i][j] = sc.nextInt();
		            if(arr[i][j] == 1){
		                startX = i;
		                startY = j;
		            }
		            else if(arr[i][j] == 2){
		                endX = i;
		                endY = j;
		            }
		        }
		    }
		    if(startX == -1 || startY == -1){
		        return;
		    }
		    System.out.println(findPath(arr, startX, startY, endX, endY));
		    t--;
		}
	}
	
	public static int findPath(int arr[][], int startX, int startY, int endX, int endY){
	    Point start = new Point(startX,startY);
	    Set<Point> set = new HashSet<>();
	    Set<Point> endSet = new HashSet<>();
	    // start
	    Queue<Point> startQ = new LinkedList<>();
	    startQ.add(start);
	    set.add(start);
	    // end end
	    Queue<Point> endQ = new LinkedList<>();
	    Point end = new Point(endX,endY);
	    endQ.add(end);
	    endSet.add(end);
	    while(!startQ.isEmpty() && !endQ.isEmpty()){
	        // start
	        Point temp1 = startQ.poll();
	        int x = temp1.x;
	        int y = temp1.y;
	        
	        if(x+1 <= arr.length-1){
	            Point temp = new Point(x+1,y);
	            if(endSet.contains(temp)){
	                return 1;
	            }
	            if(!set.contains(temp)){
	                if(arr[x+1][y] == 2 ){
	                    return 1;
	                }
	                else if(arr[x+1][y] == 3){
	                    startQ.add(temp);
	                    set.add(temp);
	                }
	            }
	        } 
	            
	        if( x-1 >= 0){
	            Point temp = new Point(x-1,y);
	            if(endSet.contains(temp)){
	                return 1;
	            }
	            if(!set.contains(temp)){
	                if(arr[x-1][y] == 2 ){
	                    return 1;
	                }
	                else if(arr[x-1][y] == 3){
	                   startQ.add(temp);
	                   set.add(temp);
	                }
	            }
	        }
	        if(y+1 <= arr[0].length-1){
	            Point temp = new Point(x,y+1);
	            if(endSet.contains(temp)){
	                return 1;
	            }
	            if(!set.contains(temp)){
	                if(arr[x][y+1] == 2 ){
	                    return 1;
	                }
	                else if(arr[x][y+1] == 3){
	                    startQ.add(temp);
	                    set.add(temp);
	                }
	            }
	        }     
	        if( y-1 >= 0){
	            Point temp = new Point(x,y-1);
	            if(endSet.contains(temp)){
	                return 1;
	            }
	            if(!set.contains(temp)){
	                if(arr[x][y-1] == 2){
	                    return 1;
	                }
	                else if(arr[x][y-1] == 3){
	                    startQ.add(temp);
	                    set.add(temp);
	                }
	            }
	        }
	        
	        
	        // end
	        temp1 = endQ.poll();
	         x = temp1.x;
	         y = temp1.y;
	        
	        if(x+1 <= arr.length-1){
	            Point temp = new Point(x+1,y);
	            if(set.contains(temp)){
	                return 1;
	            }
	            if(!endSet.contains(temp)){
	                if(arr[x+1][y] == 1 ){
	                    return 1;
	                }
	                else if(arr[x+1][y] == 3){
	                    endQ.add(temp);
	                    endSet.add(temp);
	                }
	            }
	        } 
	            
	        if( x-1 >= 0){
	            Point temp = new Point(x-1,y);
	            if(set.contains(temp)){
	                return 1;
	            }
	            if(!endSet.contains(temp)){
	                if(arr[x-1][y] == 1 ){
	                    return 1;
	                }
	                else if(arr[x-1][y] == 3){
	                   endQ.add(temp);
	                   endSet.add(temp);
	                }
	            }
	        }
	        if(y+1 <= arr[0].length-1){
	            Point temp = new Point(x,y+1);
	            if(set.contains(temp)){
	                return 1;
	            }
	            if(!endSet.contains(temp)){
	                if(arr[x][y+1] == 1){
	                    return 1;
	                }
	                else if(arr[x][y+1] == 3){
	                    endQ.add(temp);
	                    endSet.add(temp);
	                }
	            }
	        }     
	        if( y-1 >= 0){
	            Point temp = new Point(x,y-1);
	            if(set.contains(temp)){
	                return 1;
	            }
	            if(!endSet.contains(temp)){
	                if(arr[x][y-1] == 1 ){
	                    return 1;
	                }
	                else if(arr[x][y-1] == 3){
	                    endQ.add(temp);
	                    endSet.add(temp);
	                }
	            }
	        }
	    }
	    
	    return 0;
	}
}

class Point{
    int x,y;
    
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public boolean equals( Object b){
    	if(this == b){
    		return true;
    	}
    	if (b == null)
    		return false;
    	if(b instanceof Point){
    		Point obj = (Point)b; 
    		return (this.x == obj.x && this.y == obj.y);
    	}
    	return false;
    	
        
    }
    //@Override
    public int hashCode(){
        return (this.x*10) + this.y;
    }
    @Override
    public String toString(){
    	return "<" +this.x +"," + this.y+">";
    }
}