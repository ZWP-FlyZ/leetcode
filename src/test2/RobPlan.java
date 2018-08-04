package test2;

/**
 * 
 * @author zwp12
 *
 * https://leetcode-cn.com/problems/house-robber/description/
 *
 * 不能连续抢劫两家，求最优抢劫的方案
 *
 *
 */


public class RobPlan {

    public static int rob(int[] nums) {
        int n = nums.length;
        int next=0,nnext=0,tmp=0;
        
        if(n<=0)return 0;
        else if(n==1) return nums[0];
        else {
        	for(int i=n-1;i>=0;i--) {
        		tmp=Math.max(nums[i]+nnext, next);
        		nnext=next;next=tmp;
        	}
        	
        }
    	return next;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] s = {2,7,9,3,1};
		System.err.println(rob(s));
	}

}
