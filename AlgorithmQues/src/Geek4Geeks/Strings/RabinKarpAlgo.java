package Geek4Geeks.Strings;

public class RabinKarpAlgo {
	public static final int primeNum = 3;
	
	public static void main(String args[]){
		String pat = "abc";
		String text = "abedabc";
		System.out.println(getIndex(text,pat));
	}
	
	public static int getIndex(String text, String pat){
		if(pat == null || pat.length() == 0 || text == null || text.length() == 0){
			return -1;
		}
		if(pat.length() == text.length()){
			if(patPresent(pat, text, 0)){
				return 0;
			}
			return -1;
		}
		
		int patLen = pat.length();
		int patHash = getHash(pat,patLen,0,0);
		int hash = 0;
		for(int i = 0; i<= text.length() - patLen; i++){
			hash = getHash(text, patLen, hash, i);
			if(hash == patHash){
				if(patPresent(pat, text, i)){
					return i;
				}
			}
		}
		return -1;
		
	}
	
	public static boolean patPresent(String pat, String text, int index){
		for(int i = 0 ; i < pat.length(); i++){
			if(pat.charAt(i) != text.charAt(index + i)){
				return false;
			}
		}
		return true;
	}
	
	public static int getHash(String str, int len, int prevHash, int startIndex){
		int hash = 0;
		if(startIndex == 0){
			for(int i = startIndex; i < startIndex+len; i++){
				hash += (int)str.charAt(i) * (int)Math.pow(primeNum, i-startIndex);
			}
		}
		else{
			hash = prevHash - (int)str.charAt(startIndex-1);
			hash /= primeNum;
			hash += (int)str.charAt(startIndex + len -1) * (int)Math.pow(primeNum, len -1);
		}
		return hash;
	}
}
