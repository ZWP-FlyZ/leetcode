package test2;

/**
 * 
 * @author zwp12
 *
 * https://leetcode-cn.com/problems/predict-the-winner/description/
 * 预测胜利者
 *
 */

public class PredictWinner {

	
	
	////////////////// 回溯法 ////////////////////////
	public static boolean helper1(int[] nums,int left,int right,
										 int sum1,int sum2,double end) {
		if(left>right) return sum1>=sum2;
		else if(left==right) return (sum1+nums[left])>=sum2;
		else if(right-left==1) {
			if(nums[left]>=nums[right]) {
				sum1+=nums[left];
				sum2+=nums[right];
			}else {
				sum1+=nums[right];
				sum2+=nums[left];
			}
			return sum1>=sum2;
		}else {
			
			if((sum1+nums[left])>=end) return true;
			if((sum1+nums[right])>=end) return true;
			
			if((sum2+nums[left+1])<=end&&
					(sum2+nums[right])<=end) {
				boolean f = helper2(nums,left+1,right,sum1+nums[left],sum2,end);
				if(!f) return true;
			}
			
			if((sum2+nums[left])<=end&&
					(sum2+nums[right-1])<=end) {
				boolean f = helper2(nums,left,right-1,sum1+nums[right],sum2,end);
				if(!f) return true;
			}
			
			return false;
		}
			
	}
	
	public static boolean helper2(int[] nums,int left,int right,
										 int sum1,int sum2,double end) {
		if(left>right) return sum1<sum2;
		else if(left==right) return (sum2+nums[left])>sum1;
		else if(right-left==1) {
			if(nums[left]>=nums[right]) {
				sum2+=nums[left];
				sum1+=nums[right];
			}else {
				sum2+=nums[right];
				sum1+=nums[left];
			}
			return sum2>sum1;
		}else {
			
			if((sum2+nums[left])>end) return true;
			if((sum2+nums[right])>end) return true;
			
			if((sum1+nums[left+1])<end&&
					(sum1+nums[right])<end) {
				boolean f = helper1(nums,left+1,right,sum1,sum2+nums[left],end);
				if(!f) return true;
			}
			
			if((sum1+nums[left])<end&&
					(sum1+nums[right-1])<end) {
				boolean f = helper1(nums,left,right-1,sum1,sum2+nums[right],end);
				if(!f) return true;
			}
			
			return false;
		}
	}
	
    public static boolean PredictTheWinner(int[] nums) {
        int sum =0;
        for(int i :nums)
        	sum+=i;
    	return helper1(nums, 0, nums.length-1, 0, 0, sum/2.0);
    }
	
    ///////////////////////// 动态规划解法 ///////////////////
    
    public static boolean PredictTheWinner_(int[] nums) {
        // http://www.cnblogs.com/grandyang/p/6369688.html
        // http://bookshadow.com/weblog/2017/01/22/leetcode-predict-the-winner/
        
        int n = nums.length;
        Integer[][] dp = new Integer[n][n];
        
        return canWin(nums, 0, n - 1, dp) >= 0;
    }
    
    static int canWin(int[] nums, int s, int e, Integer[][] dp) {
        if (dp[s][e] == null) {
            dp[s][e] = (s == e) ? nums[s] : Math.max(nums[s] - canWin(nums, s + 1, e, dp), nums[e] - canWin(nums, s, e - 1, dp));
        }
        
        return dp[s][e];
    }
    
    //////////////////// 动态规划 2 ///////////////////////
    public static boolean PredictTheWinner__(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        dp[dp.length - 1][dp.length - 1] = nums[nums.length - 1];
        for (int left = dp.length - 2; left >= 0; left--) {
            for (int right = left; right < dp.length; right++) {
                if (left == right) {
                    dp[left][right] = nums[left];
                } else {
                    int pickLeft = nums[left] - dp[left + 1][right];
                    int pickRight = nums[right] - dp[left][right - 1];
                    dp[left][right] = Math.max(pickLeft, pickRight);
                }
            }
        }
        return dp[0][nums.length - 1] >= 0;
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1000,999,999,1000,555,400};
		System.err.println(PredictTheWinner__(a));
	}

}
