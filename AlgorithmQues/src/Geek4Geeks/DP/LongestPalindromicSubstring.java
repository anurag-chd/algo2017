package Geek4Geeks.DP;

public class LongestPalindromicSubstring {
	public static void main(String args[]){
		String str = "ABABC";
		getMaxLen(str);
	}
	
	public static void getMaxLen(String str){
		if(str == null || str.length() == 0){
			return;
		}
		
		boolean mem[][] = new boolean[str.length()][str.length()];
		int len = str.length();
		int maxLen = 1;
		for(int i = 0; i< len ; i++){
			mem[i][i] = true;
		}
		
		// check for length of 2
		for(int i = 0; i < len-1 ; i++){
			if(str.charAt(i) == str.charAt(i+1)){
				maxLen = 2;
				mem[i][i+1] = true;
			}
			else{
				mem[i][i+1] = false;
			}
		}
		
		for(int len1 = 3; len1 < len ; len1++){
			for(int i = 0; i < len - len1 + 1; i++){
				int j = i + len1 -1;
				if(str.charAt(i) == str.charAt(j) && mem[i+1][j-1]){
					maxLen = maxLen > len1 ? maxLen :len1;
					mem[i][j] = true;
				}
				else{
					mem[i][j] = false;
				}
			}
		}
		
		System.out.println(maxLen);
		
	}
}
