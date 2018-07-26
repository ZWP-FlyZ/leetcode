package test1;

import java.util.Arrays;

/**
 * 
 * @author zwp12
 *
 * @link https://leetcode-cn.com/problems/two-sum/description/
 * 
 */


public class twoNumSum {

    public static int[] twoSum(int[] nums, int target) {
    	int[] res = {0,0};
    	int size = nums.length;
    	for(int i=0;i<size-1;i++) {
    		int tb = target-nums[i];
    		for(int j=i+1;j<size;j++)
    			if (tb == nums[j]) {
    				res[0]=i;
    				res[1]=j;
    				return res;
    			}
    	}

    
		return nums;
    }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] t = {3,2,4};
		System.err.println(Arrays.toString(twoSum(t, 6)));
	}

}
