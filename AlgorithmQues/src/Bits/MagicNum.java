package Bits;

public class MagicNum {
	public static void main(String args[]){
		int num = 6;
		System.out.println(getMagicNum(num));
	}
	
	public static int getMagicNum(int num){
		int sum =0, pow = 1;
		while(num >0){
			int temp = num &1;
			if(temp == 1){
				sum = sum + (int)Math.pow(5, pow);
			}
			pow++;
			num = num >>1;
		}
		return sum;
	}
	
}
