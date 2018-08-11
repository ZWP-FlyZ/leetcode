package test3;

import java.util.Arrays;

/**
 * 
 * @author zwp12
 *
 * https://leetcode-cn.com/problems/wiggle-subsequence/description/
 * 
 * 最长摆动子串
 * 
 *
 *
 */


public class WipSubNums {

	
    public static int wiggleMaxLength(int[] nums) {
        int n = nums.length,maxs= 1,tmp;
        if(n<2) return n;
        int last=nums[0];
        int dir = 0,idx;
        for(idx=1;idx<n;idx++) 
        	if(last==nums[idx])continue;
        	else {
        		dir = nums[idx]-last>0?1:-1;
        		last=nums[idx];
        		maxs++;idx++;
        		break;
        	}
        
        for(;idx<n;idx++) {
        	if(last==nums[idx])continue;
        	else if((nums[idx]-last)*dir<0) {
        		maxs++;
        		dir*=-1;
        	}
        	last=nums[idx];
        }

    	return maxs;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,7,4,5,5};
		System.err.println(wiggleMaxLength(a));
	}

}
