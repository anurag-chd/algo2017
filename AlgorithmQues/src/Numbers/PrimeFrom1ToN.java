package Numbers;

public class PrimeFrom1ToN {
	public static void main(String args[]){
		printPrimes(2,50);
	}
	
	public static void printPrimes(int start, int end){
		if(end <2){
			System.out.println(1);
			return;
		}
		
		boolean isPrime[] = new boolean[end+1];
		for(int i = 0; i<= end; i++){
			isPrime[i] = true;
		}
		
		for(int p = 2; (p * p) <=end; p++){
			if(isPrime[p]){
				for(int i = p*2; i <= end; i= i+p){
					isPrime[i] = false;
				}
			}
		}
		StringBuilder sbr = new StringBuilder();
		for(int index = start; index <= end; index++){
			if(isPrime[index]){
				sbr.append(index).append(", ");
			}
		}
		
		System.out.println(sbr);
	}
	
	//2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47
	//2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47
}
