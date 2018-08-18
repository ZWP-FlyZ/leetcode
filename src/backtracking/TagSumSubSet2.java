package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author zwp12
 *
 * https://leetcode-cn.com/problems/combination-sum-ii/description/
 *
 * 在集合中选择某些元素组成特定和 无重复
 *
 */


public class TagSumSubSet2 {

	
	public static List<Integer> arr2list(int[] a,int j){
		List<Integer> r = new ArrayList<Integer>();
		for(int i=0;i<j;i++)
			r.add(a[i]);
		return r;
	}
	
	public static boolean same(int[] nums,int k,int m) {
		for(int i=k;i<m;i++)
			if(nums[i]==nums[m]) return true;
		return false;
	}
	
	public static int[] tmp = null;
	
	
	
	
	public static void helper(int[] nums,int i,int r,int j,List<List<Integer>> res) {
		if(r==0) {
			res.add(arr2list(tmp, j));
		}else if(r>0) {
			for(int k=i;k<nums.length;k++) {
				if(same(nums,i,k)) continue;
				if(r<nums[k]) return ;
				tmp[j]=nums[k];
				helper(nums,k+1,r-nums[k],j+1,res);
			}
		}
		
	}
	
	
    public static  List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
    	List<List<Integer>> res = new ArrayList<>();
    	
    	Arrays.sort(candidates);
    	
    	tmp = new int[candidates.length];
    	
    	helper(candidates,0,target,0,res);
    
    	return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2,5,2,1,2};
		List<List<Integer>> res = combinationSum2(a,5);
		for(List<Integer> l :res) {
			String s= "[ ";
			for(Integer i:l)
				s+=i+" ";
			s+="]";
			System.err.println(s);
		}
	}

}
