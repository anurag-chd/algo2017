package CTCI;

import java.util.Random;

public class RandomTreeNode {
	
	int data;
	int size;
	RandomTreeNode left;
	RandomTreeNode right;
	
	public RandomTreeNode(int data){
		this.data = data;
		this.size = 1;
	}
	
	public void insertInOrder(int d){
		if(data >= d){
			if(left == null){
				left = new RandomTreeNode(d);
			}
			else{
				left.insertInOrder(d);
			}
		}
		else{
			if(right == null){
				right = new RandomTreeNode(d);
			}
			else{
				right.insertInOrder(d);
			}
		}
		size++;
	}
	
	public RandomTreeNode getRandom(){
		int leftSize = left != null ? left.size :0;
		Random rand = new Random();
		int num = rand.nextInt(size);
		if(num < leftSize){
			return left.getRandom();
		}
		else if(num == leftSize){
			return this;
		}
		else{
			return right.getRandom();
		}
	}
}

