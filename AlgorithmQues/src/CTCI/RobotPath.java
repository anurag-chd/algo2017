package CTCI;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RobotPath {
	
	
	
	public static void main(String args[]){
		int arr[][] = {{1,1,0,1},{1,1,1,0},{1,0,1,1},{0,1,1,1}};
		System.out.println(getPath(arr));
	}
	
	public static List<Point> getPath(int arr[][]){
		if(arr == null || arr.length == 0 || arr[0].length == 0){
			return null;
		}
		List<Point> path = new ArrayList<>();
		Set<Point> wrongPath = new HashSet<>();
		getPath(arr,arr.length-1, arr[0].length-1, path, wrongPath);
		return path;
		
	}
	
	public static boolean getPath(int arr[][], int row, int col, List<Point> path, Set<Point> wrongPath){
		if(row < 0 || col < 0 || arr[row][col] == 0)
			return false;
		
		Point p = new Point(row,col);
		if(wrongPath.contains(p))
			return false;
		
		boolean origin = row == 0 && col == 0 ? true : false;
		
		if(origin || getPath(arr,row-1,col,path,wrongPath) || getPath(arr, row, col-1, path, wrongPath) ){
			path.add(p);
			return true;
		}
		
		wrongPath.add(p);
		return false;
		
	}
}
class Point{
	int row;
	int col;
	public Point(int row, int col){
		this.row = row;
		this.col = col;
	}
	public String toString(){
		return "<" + this.row + ","+this.col + ">";
	}
	
	public boolean equals(Point b){
		return this.row == b.row && this.col == b.col; 
	}
}
