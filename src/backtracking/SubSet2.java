package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author zwp12
 *
 *
 * https://leetcode-cn.com/problems/subsets-ii/description/
 *
 * 计算一个集合的所有子集 重复数据
 *
 *
 */


public class SubSet2 {


	
	public static List<Integer> copy(int[] tmp,int i,int j){
		List<Integer> t = new ArrayList<>();
		while(i<=j) {
			t.add(tmp[i++]);
		}
		return t;
	}
		
	public static boolean same(int[] nums,int k,int m) {
		for(int i=k;i<m;i++)
			if(nums[i]==nums[m]) return true;
		return false;
	}
	
	public  static void helper(int[] nums,int i,int[] tmp,int d,List<List<Integer>> res) {
		for(int j=i;j<nums.length;j++) {
			if(same(nums,i,j))continue;
			tmp[d]=nums[j];
			res.add(copy(tmp,0,d));
			helper(nums,j+1,tmp,d+1,res);
		}
	}
	

	
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
    	
    	List<List<Integer>> res = new ArrayList<>();
    	res.add(new ArrayList<Integer>());
    	int n = nums.length;
    	int[] tmp = new int[n];
    	
    	if(n<1)return res;
    	else if(n==1) {
    		res.add(copy(nums,0,0));
    	}else {
    		Arrays.sort(nums);
    		helper(nums,0,tmp,0,res);
    	}
        return res;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {4,4,4,1,1,2};
		
		List<List<Integer>> res = subsetsWithDup(a);
		for(List<Integer> l :res) {
			String s= "[ ";
			for(Integer i:l)
				s+=i+" ";
			s+="]";
			System.err.println(s);
		}
		
	}

}
