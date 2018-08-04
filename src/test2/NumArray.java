package test2;

/**
 * 
 * @author zwp12
 *
 *
 * https://leetcode-cn.com/problems/range-sum-query-immutable/description/
 *
 * 求解数组任意段的和
 *
 *
 *
 */

public class NumArray {

	private int[] sum;
	
    public NumArray(int[] nums) {
        sum=new int[nums.length];
        int last=0;
        for(int i=0;i<nums.length;i++){
        	last+=nums[i];
        	sum[i]=last;
        }
    }
    
    public int sumRange(int i, int j) {
    	if(i<0||i>j) throw new IllegalArgumentException("i,j");
    	if(i==0) return sum[j];
    	else return sum[j]-sum[i-1];
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
