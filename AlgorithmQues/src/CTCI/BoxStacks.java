package CTCI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoxStacks {
	public static void main(String args[]){
		List<Box> boxList = new ArrayList<>();
		boxList.add(new Box(4,6,7));
		boxList.add(new Box(1,2,3));
		boxList.add(new Box(4,5,6));
		boxList.add(new Box(10,12,32));
		System.out.println(getStackHeight(boxList));
		Collections.sort(boxList, Box::compare);
		System.out.println(boxList);
		
	}
	
	public static int getStackHeight(List<Box> boxes){
		if(boxes == null || boxes.size() == 0)
			return 0;
		Collections.sort(boxes, Box::compare);
		int stack[] = new int[boxes.size()];
		return getHeights(boxes,null,stack, 0);
	}
	
	public static int getHeights(List<Box> boxes,Box bottom, int[]cache, int index){
		if(index >= boxes.size()){
			return 0;
		}
		Box newBottom = boxes.get(index);
		int heightWithBottom = 0;
		if(bottom == null || bottom.isAllowed(newBottom)){
			if(cache[index] == 0){
				cache[index] = getHeights(boxes, newBottom, cache, index+1);
				cache[index] += newBottom.h;
			}
			heightWithBottom = cache[index];
		}
		int heightWOBottom = getHeights(boxes,newBottom,cache,index+1);
		
		return Math.max(heightWithBottom, heightWOBottom);
		
	}
}
class Box{
	int h,l,b;
	public Box(int h, int l, int b){
		this.h = h;
		this.l = l;
		this.b = b;
		
	}
	int compare(Box a){
		return this.h -a.h;
	}
	
	public String toString(){
		return "{"+h+","+l+","+b+"}";
	}
	
	public boolean isAllowed(Box a){
		return this.h<a.h && this.l <a.l && this.b <a.b ? true : false;
	}
}