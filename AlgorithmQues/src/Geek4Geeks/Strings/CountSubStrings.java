package Geek4Geeks.Strings;

public class CountSubStrings {
	public static void main(String args[]){
		String str = "100100101";
		System.out.println(countSub(str));
		
	}
	
	public static int countSub(String str){
		if(str == null || str.length() == 0){
			return 0;
		}
		int count= 0;
		for(char c: str.toCharArray()){
			if(c == '1')
				count++;
			
		}
		
		int sum = 0;
		for(int i = 1; i< count; i++){
			sum = sum + i;
		}
		return sum;
		
	}
}
