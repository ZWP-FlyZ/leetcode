package test3;

import java.util.Arrays;

/**
 * 
 * @author zwp12
 *
 * https://leetcode-cn.com/problems/product-of-array-except-self/description/
 *
 * 除了自己以外其他数的乘积
 *
 *
 */


public class MultArrays {

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        if(n<2) return  new int[0] ;
        int[] res = new int[n];
        int next=1;
        res[0]=nums[0];
        for(int i=1;i<n;i++) res[i]=res[i-1]*nums[i];
        res[n-1]=res[n-2];
        next=nums[n-1];
        for(int i=n-2;i>0;i--) {
        	res[i]=res[i-1]*next;
        	next*=nums[i];
        }
        res[0]=next;
    	return res;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2};
		System.err.println(Arrays.toString(productExceptSelf(a)));
	}

}
