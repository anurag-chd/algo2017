package Geek4Geeks.Arrays;

public class CircularTour {
	public static void main(String args[]){
		int len = 8;
		int petrol[] = new int[len];
		int distance[] = new int[len];
		String str = "96 25 46 83 68 15 65 35 51 44 9 88 79 77 85 89";
		String strArr[] = str.split(" ");
		int index = 0;
		for(int i = 0 ; i < strArr.length-1 ; i= i+2){
			petrol[index] = Integer.valueOf(strArr[i]);
			distance[index] = Integer.valueOf(strArr[i+1]);
			index++;
		}
		
		System.out.println(tour(petrol,distance));
	}
	
	
	public static int tour(int petrol[], int distance[])
    {
	// Your code here
	    if(petrol == null || distance == null || petrol.length == 0 || distance.length == 0){
	        return 0;
	    }
	    if(petrol.length != distance.length){
	        return 0;
	    }
	    if(petrol.length == 1){
	        return 1;
	    }
	    int start = 0;
	    int end = 1;
	    int len = petrol.length;
	    int currPet = petrol[start] - distance[start];
	    
	    while(start != end){
	        while(currPet < 0 && start != end){
	            currPet = currPet - petrol[start] + distance[start];
	            start = (start+1)%len;
	            if (start == 0)
                    return 0;
	        }
	        currPet = currPet + petrol[end] - distance[end];
	        end = (end +1)%len;
	    }
	    if(currPet < 0 ){
	        return 0;
	    }
	    return 1;
    }
}
