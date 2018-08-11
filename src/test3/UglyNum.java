package test3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author zwp12
 *
 * 因数只由2，3，5组成的数
 *
 *
 *https://leetcode-cn.com/problems/ugly-number-ii/description/
 *
 *
 */


public class UglyNum {
	
	
	public static int nthUglyNumber(int n) {
		long[] ugs =  new long[n+1];
		int i=0;
		long a,min=Integer.MAX_VALUE;
		boolean f = true;
		if(n<7)return n;
		for(i=1;i<7;i++)ugs[i]=i;
		for(i=7;i<=n;i++) {
			min=Integer.MAX_VALUE;
			for(int j=i-1;j>0;j--) {
				f= true;
				if((a=ugs[j]*2)>ugs[i-1]){
					min = Math.min(min, a);
					f=false;
				}
				if((a=ugs[j]*3)>ugs[i-1]){
					min = Math.min(min, a);
					f=false;
				}
				if((a=ugs[j]*5)>ugs[i-1]){
					min = Math.min(min, a);
					f=false;
				}
				if(f)break;
			}
			ugs[i] = min;	
		}
		return (int)ugs[n];
	}
	

////////////////////////////// 较好思路 //////////////////////////
	
    public static int nthUglyNumber__(int n) {
        int t2 = 0, t3 = 0, t5 = 0;
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        for(int i = 1; i < n; i++) {
            uglyNumbers[i] = Math.min(uglyNumbers[t2] * 2, Math.min(uglyNumbers[t3] * 3, uglyNumbers[t5] * 5));
            if(uglyNumbers[i] % 2 == 0) t2++;
            if(uglyNumbers[i] % 3 == 0) t3++;
            if(uglyNumbers[i] % 5 == 0) t5++;
        }
        return uglyNumbers[n - 1];
    }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.err.println(nthUglyNumber__(1600));
	}

}
