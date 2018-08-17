package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author zwp12
 *
 *
 * https://leetcode-cn.com/problems/combination-sum-iii/description/
 *
 * 寻找确定数量元素个数和解
 * 
 *
 */



public class SpiltSum {

	public static List<Integer> arr2list(int[] a){
		List<Integer> r = new ArrayList<Integer>();
		for(int i=0;i<a.length;i++)
			r.add(a[i]);
		return r;
	}
	
	
	public static int[] tmp=null;
	
	
	public static void helper(int i,int j,int r,List<List<Integer>> res) {
		
		if(r==0&&j==tmp.length) 
			res.add(arr2list(tmp));
		else if(r>=i && j<tmp.length) {
			for(int k=i;k<10;k++) {
				if(r<k) return ;
				tmp[j]=k;
				helper(k+1,j+1,r-k,res);
			}
		}
	}
	
    public static  List<List<Integer>> combinationSum3(int k, int n) {
       
    	List<List<Integer>> res = new ArrayList<>();
    	if(n<k||n>9*k) return res;
    	tmp = new int[k];
    	helper(1,0,n,res);
    	return res;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3,4,5,6,7,8,9,12,11};
		List<List<Integer>> res = combinationSum3(3,9);
		for(List<Integer> l :res) {
			String s= "[ ";
			for(Integer i:l)
				s+=i+" ";
			s+="]";
			System.err.println(s);
		}
	}

}
