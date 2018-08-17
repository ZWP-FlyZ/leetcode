package backtracking;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author zwp12
 *
 *
 * https://leetcode-cn.com/problems/combinations/description/
 * 求解组合数
 *
 *
 */


public class CombinNum {

	
	public static List<Integer> arr2list(int[] s){
		List<Integer> a = new ArrayList<Integer>();
		for(Integer i :s){
			a.add(i);
		}
		return a;
	}
	
	public static void helper(int i,int n,int j,int[] tmp,List<List<Integer>> res) {
		if(j==tmp.length) res.add(arr2list(tmp));
		else
			for(int k=i;k<n+j+2-tmp.length;k++) {
				tmp[j]=k;
				helper(k+1,n,j+1,tmp,res);
			}
	}
	
	
    public static List<List<Integer>> combine(int n, int k) {
    	List<List<Integer>> res = new ArrayList<>();
    	if(n<1||k>n) return res;
    	else {
    		int[] tmp = new int[k];
    		helper(1,n,0,tmp,res);
    	}
    		
    	return res;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> res = combine(100,100);
		for(List<Integer> l :res) {
			String s= "[ ";
			for(Integer i:l)
				s+=i+" ";
			s+="]";
			System.err.println(s);
		}
	}

}
