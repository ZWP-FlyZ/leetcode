package test1;

/**
 * 
 * @author zwp12
 *
 * https://leetcode-cn.com/problems/maximum-subarray/description/
 * 最大连续整数子串和
 */

public class MaxSumSub {

    public static int maxSubArray(int[] nums) {
        int maxSum=nums[0];
        int n = nums.length,tmp=0;
        if(n==1)return nums[0];
        for(int i=0;i<n;i++) {
        	tmp+=nums[i];
        	maxSum=Math.max(maxSum, tmp);
        	if(tmp<0)tmp=0;
        }
        
        return maxSum;
    	
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {-2,1,-3,4,-1,2,1,-5,4};
		System.err.println(maxSubArray(a));
		
	}

}
