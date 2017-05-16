package Geek4Geeks.Arrays;

import java.util.Arrays;

public class SumClosestZero {
	
	public static void main(String args[]){
		String str = "78546 -1303 41190 39913 7125 39396 68012 76829 71946 41107 12507 19525 54939 85528 5556 2285 -3589 63972 80571 -6539 59293 77837 60089 38962 68485 -1073 43443 56817 69705 48859 79712 58247 81278 54619 31877 -1602 4011 33606 85227 9674 84713 31451 39199 73369 50697 78478 85654 80830 52445 -62 84291 45456 87775 54376 -5587 89977 87025 47856 80511 66725 6710 70219 34967 21706 58555 561 30104 -3717 44167 49049 39680 62597 -9505 88879 45962 74914 1069 65333 65740 87237 -1012 60026 42688 -3242 48119 70823 -3269 45139 28674 87242 21860 69106 -8827 -9456 807 83451 1106 64634 89734 78995 47400 39409 51588 71617 62006 31267 56527 -3208 30317 32262 17746 39306 26005 -5849 69786 84125 74974 234 39259 37365 21194 -5164 16467 22367 -4619 50996 39535 30209 49347 62987 42921 6742 36113 28226 88360 31836 69493 78604 38629 33528 20861 -9908 82834 80588 -5756 62615 74708 79218 72850 47685 26579 27761 76243 76768 83850 5341 61481 33381 45550 20824 6363 22189 61288 52476 60415 59643 18030 39904 71964 66659 7149 26542 66751 -22 17126 -5288 -3690 1829 83931 2877 83236 44227 40638 69475 54712 34484 84816 26188 77865 64084 57012 17945 -3732 52018 4138 66683 21656 32168 40304 3616 32544 57453 40158 33013 -8852 -8999 37725 -2541 26553 55373 34058 19784 33317 84697 22976 -1976 52898 41510 34213 64480 15589 24942 -7580 45579 86960 30280 45979 42334 -3834 -3721 79672 62432 87454 53547 29162 12320 54549 76888 43501 -8903 65978 87559 44603 9291 5968 77580 41037 68866 29085 85250 43341 78396 43910 69483 33970 40865 33481 89949 16916 39647 19945 6583 35796 41117 -6152 74959 63437 58397 85564 40655 83216 61537 38209 37814 4545 54178 49111 55583 56761 88196 74550 10098 304 28455 13298 44274 79321 56779 67941 29954 30143 21603 46538 75940 72720 50386 84616 69874 42500 80175 20524 35711 51707 -7549 7242 89975 80351 66354 55553 47107 88267 40098 -9078 22289 78554 14221 280 -8413 4717 78221 31541 68583 33542 11796 78240 39979 -4101 72851 19849 48399 63021 74095 17827 48445 263 58792 48415 -9391 58863 37685 71439 80847 87784 72361 13131 50 20299 23412 1637 35017 35350 66900 13595 78892 12414 1830 28867 18313 8398 82438 430 81419 -9755 51979 63581 509 20766 21992 24840 89629 -6606 6274 4189 -8827 88636 27320 24945 18930 60732 60304 87669 6078 37200 34981 18687 59614 70533 81276 11644 88931 73709 22074 4062 -2328 7771 77644 8181 38537 33353 66743 61884 36747 83018 76073 61643 5366 13388 -3417 58018 7838 66888 55683 47638 37805 659 42 31136 81193 -8686 52780 3836 75023 8572 17899 82695 26343 5538 24593 -1403 72613 1332 70481 19355 18067 80271 14715 33433 27377 21299 1446 45215 21904 -9154 26570 69709 25228 36612 10840 40138 37926 -2663 53974 46667 15909 81873 63079 52252 21128 -2332 60850 3736 32722 65048 56814 84511 55315 81529 27939 -7313 36545 63107 71624 68449 63954 8189 71875 22899 78523 -7290 73037";
		String [] strArr = str.split(" ");
		int arr[] = new int[strArr.length];
		int i = 0;
		for(String s : strArr)
			arr[i++] = Integer.valueOf(s);
		printNums(arr);
		
	}
	
	public static void printNums(int arr[]){
	    Arrays.sort(arr);
	    int l = 0;
	    int r = arr.length -1;
	    int min1 = -1;
	    int min2 = -1;
	    int min_sum = Integer.MAX_VALUE;
	    while(l < r){
	        if(Math.abs(min_sum) > Math.abs(arr[l] + arr[r])){
	            min1 = arr[l];
	            min2 = arr[r];
	            min_sum = min1 + min2;
	        }
	        if(arr[l] <0){
	            l++;
	        }
	        else
	            r--;
	    }
	    
	    System.out.println(min1 +" " +min2);
	    return;
	    
	}

}
