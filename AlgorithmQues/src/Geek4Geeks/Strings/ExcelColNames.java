package Geek4Geeks.Strings;

public class ExcelColNames {
	public static void main(String args[]){
		int num = 470211273;
		System.out.println(printCol(num));
	}
	
	public static String printCol(int num){
	    StringBuilder sbr = new StringBuilder();
	    while(num > 0){
	        int mod = num%26;
	        mod = mod == 0?26:mod;
	        sbr.insert(0,""+(char)(64+mod));
	        num = num/26;
	        num = mod == 26 ? num-1:num;
	    }
	    return sbr.toString();
	}
}
