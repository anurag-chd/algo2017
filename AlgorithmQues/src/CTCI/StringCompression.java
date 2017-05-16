package CTCI;

public class StringCompression {
	public static void main(String args[]){
		String str1 = "aabccccaab";
		System.out.println(compress(str1));
	}
	
	public static String compress(String str){
		StringBuilder compressStr = new StringBuilder();
		int count = 1;
		int index = 0;
		while(index < str.length()-1){
			if(str.charAt(index) == str.charAt(index+1)){
				while(index < str.length()-1 && str.charAt(index) == str.charAt(index+1)){
					count++;
					index++;
				}
				compressStr.append(str.charAt(index)).append(count);
				count = 1;
				index++;
			}
			else{
				compressStr.append(str.charAt(index)).append(count);
				count = 1;
				index++;
			}
			
		}
		if(index == str.length() -1 && str.charAt(index) != str.charAt(index-1)){
			compressStr.append(str.charAt(index)).append(count);
		}
		
		
		return compressStr.length()<=str.length() ? compressStr.toString() : str;
	}

}
