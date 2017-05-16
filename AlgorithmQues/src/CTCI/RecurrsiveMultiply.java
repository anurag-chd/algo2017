package CTCI;

public class RecurrsiveMultiply {
	
	public static void main(String args[]){
			System.out.println(minProduct(3,13));
	}
	public static int minProduct(int a, int b){
		int bigger = a < b ? b: a;
		int smaller = a <b ?a:b;
		return minProductHelper(smaller, bigger);
	}
	
	public static int minProductHelper(int small, int big){
		if(small == 0)
			return 0;
		else if(small ==1)
			return big;
		int s = small >>1;
		int halfProd = minProductHelper(s,big);
		if(small % 2 == 0)
			return halfProd + halfProd;
		else
			return halfProd + halfProd + big;
	}

}
