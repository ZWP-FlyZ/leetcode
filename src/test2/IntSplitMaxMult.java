package test2;

import java.util.Arrays;

/**
 * 
 * @author zwp12
 * 
 * 
 * https://leetcode-cn.com/problems/integer-break/description/
 * 
 * 将整数分为若干个整数，求这个最大的数和
 * 
 * 
 * 
 */

public class IntSplitMaxMult {

	public static int max(int a,int b,int c,int d) {
		return Math.max(Math.max(a, b), Math.max(c, d));
	}
	
    public static int integerBreak(int n) {
    	
//        int[] v= {0, 1, 1, 2, 4, 6, 9, 12, 18, 27, 36, 54, 81, 108, 162, 243, 324, 
//        		486, 729, 972, 1458, 2187, 2916, 4374, 6561, 8748, 13122, 19683, 
//        		26244, 39366, 59049, 78732, 118098, 177147, 236196, 354294, 531441, 
//        		708588, 1062882, 1594323, 2125764, 3188646, 4782969, 6377292, 9565938, 
//        		14348907, 19131876, 28697814, 43046721, 57395628, 86093442, 129140163, 172186884, 
//        		258280326, 387420489, 516560652, 774840978, 1162261467, 1549681956};
    	
    	int[] v = new int[n+1];

    	v[1]=1;v[2]=1;
    	for(int k=3;k<=n;k++) {
    		v[k]=1;
    		for(int i=1;i<k;i++) {

    			v[k]=Math.max(v[k], Math.max(i*(k-i),i*v[k-i]));
    		}
    	}
    	System.err.println(Arrays.toString(v));
        return v[n];
    }
	
	public static void main(String[] args) {
		
		System.err.println(integerBreak(58));

	}

	////// 最优方法 ////////
	
	
    public int integerBreak__(int n) {
        if(n<=3)
        	return n-1;
        else{
        	if(n%3==1){
        		int num = n/3 - 1;
        		return (int)Math.pow(3,num)*4;
        	}else if(n%3==2){
        		int num = n/3;
        		return (int)Math.pow(3,num)*2;
        	}else{
        		int num = n/3;
        		return (int)Math.pow(3,num);
        	}      	
        }
    }
	
	
	
}
