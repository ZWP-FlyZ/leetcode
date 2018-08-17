package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author zwp12
 *
 *
 * https://leetcode-cn.com/problems/permutations/description/
 *
 * 全排序
 *
 */


public class AllOrder {

	public static List<Integer> arr2list(int[] s){
		List<Integer> a = new ArrayList<Integer>();
		for(Integer i :s){
			a.add(i);
		}
		return a;
	}
	
	public static void swap(int[] s,int i,int j) {
		int k = s[i];
		s[i]=s[j];
		s[j]=k;
	}
	
	public static void helper(int[] nums,int i,List<List<Integer>> res) {
		
		if(i==nums.length) res.add(arr2list(nums));
		else
			for(int j=i;j<nums.length;j++) {
				swap(nums,i,j);
				helper(nums,i+1,res);
				swap(nums,i,j);
			}
	}
	
    public static  List<List<Integer>> permute(int[] nums) {
    	List<List<Integer>> res = new ArrayList<>();
    	helper(nums,0,res);
    	return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3};
		List<List<Integer>> res = permute(a);
		for(List<Integer> l :res) {
			String s= "[ ";
			for(Integer i:l)
				s+=i+" ";
			s+="]";
			System.err.println(s);
		}
	}

}
