package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author zwp12
 *
 * https://leetcode-cn.com/problems/combination-sum/description/
 *
 * 在集合中选择某些元素组成特定和
 *
 */


public class TagSumSubSet {

	
	public static List<Integer> arr2list(int[] a,int j){
		List<Integer> r = new ArrayList<Integer>();
		for(int i=0;i<j;i++)
			r.add(a[i]);
		return r;
	}
	
	public static int[] tmp = new int[200];
	
	public static void helper(int[] nums,int i,int r,int j,List<List<Integer>> res) {
		if(r==0) {
			res.add(arr2list(tmp, j));
		}else if(r>0) {
			for(int k=i;k<nums.length;k++) {
				if(r<nums[k]) return ;
				tmp[j]=nums[k];
				helper(nums,k,r-nums[k],j+1,res);
			}
		}
		
	}
	
	
    public static  List<List<Integer>> combinationSum(int[] candidates, int target) {
        
    	List<List<Integer>> res = new ArrayList<>();
    	
    	Arrays.sort(candidates);
    	
    	helper(candidates,0,target,0,res);
    
    	return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3,4,5,6,7,8,9,12,11};
		List<List<Integer>> res = combinationSum(a,20);
		for(List<Integer> l :res) {
			String s= "[ ";
			for(Integer i:l)
				s+=i+" ";
			s+="]";
			System.err.println(s);
		}
	}

}
