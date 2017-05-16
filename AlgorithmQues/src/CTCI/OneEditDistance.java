package CTCI;

public class OneEditDistance {
	
	public static void main(String args[]){
		String str1 = "apple";
		String str2 = "aples";
		
		System.out.println(isOneEdit(str1, str2));
	}
	
	public static boolean isOneEdit(String str1, String str2){
		if(str1 == null || str1.length() == 0
				|| str2 == null || str2.length() == 0){
			return false;
		}
		if(Math.abs(str1.length()- str2.length()) > 1){
			return false;
		}
		
		if(str1.length() == str2.length()){
			return checkOneReplace(str1, str2);
		}
		if(str1.length() > str2.length()){
			return checkOneEdit(str2, str1);
		}
		else{
			return checkOneEdit(str1, str2);
		}
	}
	
	public static boolean checkOneReplace(String str1, String str2){
		boolean oneChange = false;
		for( int index = 0 ; index < str1.length() ; index++){
			if(str1.charAt(index) != str2.charAt(index)){
				if(oneChange)
					return false;
				else
					oneChange = true;
			}
		}
		return true;
	}
	
	public static boolean checkOneEdit(String small, String big){
		int index1 = 0, index2 = 0;
		while(index1 < small.length() && index2 < big.length()){
			if(small.charAt(index1) != big.charAt(index2)){
				if(index1 != index2)
					return false;
				else
					index2++;
			}
			else{
				index1++;
				index2++;
			}
		}
		return true;
		
	}
}
