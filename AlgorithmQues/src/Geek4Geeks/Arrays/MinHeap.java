package Geek4Geeks.Arrays;

public class MinHeap {
	int arr[];
	int maxSize;
	int size;
	
	public MinHeap(int maxSize){
		this.maxSize = maxSize;
		this.arr = new int[maxSize+1];
		this.size = 0;
	}
	
	public static void main(String args[]){
		int arr[] = {9,8,7,4,5,2,3};
		System.out.println(Math.abs((long)Integer.MIN_VALUE));
		MinHeap mHeap = new MinHeap(8);
		for(int i : arr){
			mHeap.insert(i);
		}
		while(mHeap.getSize() > 0){
			System.out.print(mHeap.poll() + " ,");
		}
	}
	
	public void insert(int item){
		if(maxSize == this.size){
			System.out.println("The heap is full");
			return;
		}
		this.size++;
		arr[size] = item;
		
		int index = size;
		while(index>1){
			int parentIndex = index/2;
			if(arr[parentIndex] > arr[index]){
				swap(arr, index, parentIndex);
				index = parentIndex;
			}
			else{
				break;
			}
		}
		
	}
	
	public int getSize(){
		return size;
	}
	
	private void swap(int arr[], int x, int y){
		if(arr == null || arr.length == 0 || x == y || x >= arr.length || y >= arr.length){
			return;
		}
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
		return;
	}
	
	public int poll(){
		int res = arr[1];
		arr[1] = arr[size--];
		int index = 1;
		while((index *2) <= size){
			int leftChildIndex = index*2;
			int rightChildIndex = (index *2) +1;
			int minIndex = leftChildIndex;
			if(rightChildIndex <= size){
				minIndex = arr[leftChildIndex] > arr[rightChildIndex] ? rightChildIndex : leftChildIndex;
			}
			if(arr[index] > arr[minIndex]){
				swap(arr, index, minIndex);
				index = minIndex;
			}
			else{
				break;
			}
		}
		return res;
	}
	
	public int peek(){
		if(size > 0){
			return arr[1];
		}
		else{
			return Integer.MAX_VALUE;
		}
	}
}

