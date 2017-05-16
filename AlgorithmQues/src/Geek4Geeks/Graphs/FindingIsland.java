package Geek4Geeks.Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class FindingIsland {
	public static void main(String args[]){
		int arr [][] = {{1,1,0},
						{0,0,1},
						{1,0,1}};
		
		ArrayList<Integer> graph[] = new ArrayList[4];
		
		System.out.println(findIslands(arr));
	}
	
	public static int findIslands(int matrix[][]){
		if(matrix == null || matrix.length == 0){
			return 0;
		}
		int count = 0;
		for(int i = 0; i < matrix.length ; i++){
			for(int j = 0; j< matrix[0].length ; j++){
				if(matrix[i][j] == 1){
					count++;
					dfs(matrix, i, j);
				}
			}
		}
		return count;
	}
	
	public static void dfs(int matrix[][], int row, int col){
		Stack <Point> stack = new Stack<>();
		matrix[row][col] = 0;
		stack.push(new Point(row,col));
		while(!stack.isEmpty()){
			Point temp = stack.pop();
			int x = temp.x;
			int y = temp.y;
			if(x < matrix.length -1 && matrix[x+1][y] == 1){
				matrix[x+1][y] = 0;
				stack.push(new Point(x+1, y));
			}
			if(y < matrix[0].length -1 && matrix[x][y+1] == 1){
				matrix[x][y+1] = 0;
				stack.push(new Point(x, y+1));
			}
			if(x < matrix.length -1 && y < matrix[0].length -1 && matrix[x+1][y+1] == 1){
				matrix[x+1][y+1] = 0;
				stack.push(new Point(x+1, y+1));
			}
		}
	}
	
	
//	class Point{
//		int row, col;
//		public Point(int row, int col){
//			this.row = row;
//			this.col = col;
//		}
//		
//		@Override
//		public boolean equals(Object b){
//			if(!(b instanceof Point))
//				return false;
//			
//			Point x = (Point) b;
//			
//			return x.col == this.col && x.row == this.row;
//		}
//		
//		@Override
//		public String toString(){
//			return "<" + this.row+", " + this.col + " >";
//		}
//	}
	
	
	
}


