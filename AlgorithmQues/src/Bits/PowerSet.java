package Bits;

public class PowerSet {
	public static void main(String args[]){
		char set[] = {'a', 'b', 'c'};
        printSubsets(set);
	}
	
	public static void printSubsets(char arr[]){
		if(arr == null || arr.length ==0){
			System.out.println("{ }");
			return;
		}
		
		int totalSets = 1 << arr.length;
		
		for(int i = 0; i< totalSets ; i++){
			StringBuilder sbr = new StringBuilder("{");
			for(int j =0 ; j < arr.length; j++){
				if((i & (1 <<j)) > 0){
					sbr.append(arr[j]).append(" ");
				}
			}
			sbr.append("}");
			System.out.println(sbr);
		}
		
	}
}
