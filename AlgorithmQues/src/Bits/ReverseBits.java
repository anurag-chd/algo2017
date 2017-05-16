package Bits;

public class ReverseBits {
	public static void main(String args[]){
		long s = 5;
		long res = revBits(s);
		if(res > 0){
			System.out.println(res);
		}
		else{
			System.out.println(res *-1);
		}
		
		
	}
	
	public static long revBits(long num){
		long res = 0;
		long count = 0;
		while(count < 32){
			long leftMost = num & 1;
			res = res <<1;
			res = res | leftMost;
			num = num >>1;
			count++;
		}
		 
		return res > 0 ?res : -1*res;
	}
}	
