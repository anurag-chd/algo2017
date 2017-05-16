package CTCI;

public class Urlify {
	public static void main(String args[]){
		String str = "this is  it";
		System.out.println(url(str));
	}
	
	public static String url (String str){
		if(str == null || str.length() == 0){
			return str;
		}
		int spaceCount = 0;
		for(char c : str.toCharArray()){
			if(c == ' '){
				spaceCount ++;
			}
		}
		char arr[] = new char[str.length() + 2* spaceCount];
		int newIndex = arr.length-1;
		char preArr[] = str.toCharArray();
		for(int index = preArr.length-1; index>=0; index--){
			if(preArr[index] == ' '){
				arr[newIndex--] ='0';
				arr[newIndex--] = '2';
				arr[newIndex--] = '%';
			}
			else{
				arr[newIndex--] = preArr[index];
			}
		}
		
		return new String(arr);	
		
	}

}
