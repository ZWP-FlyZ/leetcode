package test2;

import java.util.Arrays;

/**
 * 
 * @author zwp12
 * https://leetcode-cn.com/problems/counting-bits/description/
 * 
 * 计算数中位为1的个数
 * 
 */

public class CountBit {

    public static int[] countBits(int num) {
    	if(num==0) return new int[]{0};
        int[]  v = new int[num+1];
        int ei=2,ind;
        v[0]=0;v[1]=1;
        while((ind=ei)<=num){
        	v[ind]=1;
        	for(int i=ind+1;i<=num&&i<ind*2;i++)
        		v[i]=v[i-ind]+1;
        	ei*=2;
        }
    	return v;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.err.println(Arrays.toString(countBits(16)));
	}

}
