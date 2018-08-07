package test3;

import java.util.Arrays;

/**
 * 
 * @author zwp12
 * 
 * 
 * https://leetcode-cn.com/problems/next-greater-element-i/description/
 * 寻找一个数组中下一个大的数
 *
 */


public class NextBigNum {

	
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
    	int m = nums1.length,n=nums2.length;
    	int[] res = new int[m];
    	if(m<1||n<1)return res;
    	if(m==1 && n==1) return new int[]{-1};
    	int submax=0;boolean flag= false;
    	for(int i=0;i<m;i++) {
    		submax=nums1[i];
    		flag=false;
    		for(int j=0;j<n;j++) {
    			if(!flag&&submax==nums2[j]) flag=true;
    			if(flag&&submax<nums2[j]){
    				submax=nums2[j];
    				break;
    			}
    		}
    		if(submax==nums1[i])res[i]=-1;
    		else res[i]=submax;
    	}
    	
    	
		return res;
    }
    
    
    ///////////////////////////// 最优方法 /////////////////////
    
    /// 建立一个结果表存每个元素各自下一个比自己大的数，
    public int[] nextGreaterElement_(int[] nums1, int[] nums2) {
		if (nums1.length == 0 || nums2.length == 0)
			return new int[0];
		int[] ans = new int[nums1.length];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums2.length; i++) {
			if (nums2[i] > max)
				max = nums2[i];
		}
		int[] temps = new int[max + 1];
		Arrays.fill(temps, -1);
		for (int i = 0; i < nums2.length; i++) {
			for (int j = i + 1; j < nums2.length; j++) {
				if (nums2[j] > nums2[i]) {
					temps[nums2[i]] = nums2[j];
					break;
				}
			}
		}
		for (int i = 0; i < nums1.length; i++) {
			ans[i] = temps[nums1[i]];
		}
		return ans;
    }
    
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {4,1,2};
		int[] b = {1,3,4,2};
		System.err.println(Arrays.toString(nextGreaterElement(a,b)));
	}

}
