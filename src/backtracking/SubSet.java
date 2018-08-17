package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author zwp12
 *
 *
 * https://leetcode-cn.com/problems/subsets/description/
 *
 * 计算一个集合的所有子集
 *
 *
 */


public class SubSet {


	
	public static List<Integer> copy(int[] tmp,int i,int j){
		List<Integer> t = new ArrayList<>();
		while(i<=j) {
			t.add(tmp[i++]);
		}
		return t;
	}
		
	public  static void helper(int[] nums,int i,int[] tmp,int d,List<List<Integer>> res) {
		for(int j=i;j<nums.length;j++) {
			tmp[d]=nums[j];
			res.add(copy(tmp,0,d));
			helper(nums,j+1,tmp,d+1,res);
		}
	}
	
	
    public static List<List<Integer>> subsets(int[] nums) {
    	
    	List<List<Integer>> res = new ArrayList<>();
    	res.add(new ArrayList<Integer>());
    	int n = nums.length;
    	int[] tmp = new int[n];
    	if(n<1)return res;
    	else if(n==1) {
    		res.add(copy(nums,0,0));
    	}else {
    		helper(nums,0,tmp,0,res);
    	}
        return res;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3,4,5,6,7};
		List<List<Integer>> res = subsets(a);
		for(List<Integer> l :res) {
			String s= "[ ";
			for(Integer i:l)
				s+=i+" ";
			s+="]";
			System.err.println(s);
		}
		
	}

}
