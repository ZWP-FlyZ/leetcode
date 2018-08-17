package test4;

import java.util.Arrays;

 


public class ArrEqueSumSub {

	/// 回溯法
	public static boolean helper1(int[] nums,int i,int remin) {
		if(remin<0)return false;
		if(remin==0) return true;
		if(i>=nums.length)return false;
		if(helper1(nums,i+1,remin-nums[i])) return true;
		else 
			return helper1(nums,i+1,remin);
	}
	
	
    public static boolean canPartition1(int[] nums) {
        if(nums.length<2)return false;
        else if(nums.length==2) return nums[0]==nums[1];
        
        int n=nums.length;
        int[]  sum = new int[n];
        
        Arrays.sort(nums);
        sum[0]=nums[0];
        for(int i=1;i<n;i++) sum[i]=sum[i-1]+nums[i];
        if(sum[n-1]%2!=0)return false;
        int loc = Arrays.binarySearch(sum, sum[n-1]/2);
        if(loc>=0)return true;
        else {
        	loc*=-1;
        	if(loc==n)return false;
        }
    	return helper1(nums,0,sum[n-1]/2);
    }
    

    public static boolean helper2(int[] nums,int[] x,int sum) {
    	int cw=0,r=sum*2;
    	int n=nums.length,i=0;
    	while(true) {
    		while(i<n&&cw+nums[i]<=sum) {
    			cw+=nums[i];
    			x[i]=1;
    			r-=nums[i];
    			i++;
    		}
    		
    		if(cw==sum)return true; // 全加结束
    		else if(i>=n) return false;
    		else {
    			// 进入右子树
    			x[i]=0;
    			r-=nums[i];
    			i++;
    		}
    		
    		
    		while(cw+r<sum) {
    			// 剪支回溯
    			i--;
    			while(i>-1&&x[i]==0) {
    				r+=nums[i];
    				i--;
    			}
    			if(i==-1) return false;
    			x[i]=0;
    			cw-=nums[i];
    			i++;
    		}		
    	}

    }
    
    public static boolean canPartition2(int[] nums) {
        if(nums.length<2)return false;
        else if(nums.length==2) return nums[0]==nums[1];
        
        int sum=0,n=nums.length;
        int[]  x = new int[n];
        for(int i=0;i<n;i++) sum+=nums[i];
        if(sum%2!=0)return false;

        boolean res = helper2(nums,x,sum/2);
        System.err.println(Arrays.toString(x));
    	return res;
    }
    
    
    
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,100};
		int[] b= {100,99,1};
		System.err.println(a.length);
		System.err.println(canPartition2(a));
	}

}
