package Geek4Geeks.DP;

public class EditDistance {
	
	public static void main(String args[]){
		int len1 = 84;
		int len2 = 87;
		String str1 = "lrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmcoq";
		String str2 = "hnwnkuewhsqmgbbuqcljjivswmdkqtbxixmvtrrbljptnsnfwzqfjmafadrrwsofsbcnuvqhffbsaqxwpqcaceh";
		System.out.println(editDistance(str1, str2, len1, len2));
		
	}
	
	public static int editDistance(String str1, String str2, int len1, int len2){
	    if((str1 == null || len1 == 0) && (str2 == null || len2 ==0 )){
	        return 0;
	    }
	    else if((str1 == null || len1 == 0) && !(str2 == null || len2 ==0 )){
	        return len2;
	    }
	    else if(!(str1 == null || len1 == 0) && (str2 == null || len2 ==0 )){
	        return len1;
	    }
	    
	    int disArr[][] = new int[len1 +1] [len2 +1];
	    
	    for(int i = 0; i <= len1 ; i++){
	        disArr[i][0] = i;
	    }
	    for(int i = 0; i <= len2 ; i++){
	        disArr[0][i] = i;
	    }
	    
	    for(int index1 = 1; index1 <= len1 ; index1++){
	        for(int index2 = 1; index2 <= len2 ; index2++){
	            if(str1.charAt(index1-1) == str2.charAt(index2-1)){
	                disArr[index1][index2] = disArr[index1-1][index2-1];
	            }
	            else{
	            	int min = Math.min(disArr[index1-1][index2], disArr[index1][index2-1]) == disArr[index1-1][index2] ?
	            			Math.min(disArr[index1-1][index2], disArr[index1-1][index2-1]) : Math.min(disArr[index1][index2-1], disArr[index1-1][index2-1]);
	                disArr[index1][index2] = 1 + min;
	            }
	        }
	    }
	    
	    return disArr[len1][len2];
	    
	}

}
