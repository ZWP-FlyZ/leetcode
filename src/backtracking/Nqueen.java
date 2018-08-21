package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author zwp12
 *
 *
 * https://leetcode-cn.com/problems/n-queens/description/
 *
 * n后问题
 *
 */

public class Nqueen {

	
	public static List<String> arr2string(int[] x) {
		List<String> ret = new ArrayList<>();
		StringBuffer sb = null;
		int j=0;
		for(int i=0;i<x.length;i++) {
			sb = new StringBuffer();
			for(j=0;j<x[i];j++)
				sb.append(".");
			sb.append("Q");
			for(j++;j<x.length;j++)
				sb.append(".");
			ret.add(sb.toString());
		}
		return ret;
	} 
	
	public static boolean place(int[] x,int k) {
		for(int i=0;i<k;i++)
			if(Math.abs(i-k)==Math.abs(x[i]-x[k])||x[i]==x[k])
				return false;
		return true;
	}
	
	public static void helper(int[] x,int i,List<List<String>> res) {
		if(i==x.length) res.add(arr2string(x));
		else {			
			for(int k=0;k<x.length;k++) {
				x[i]=k;
				if(place(x,i)) helper(x,i+1,res);
			}
		}
	}
	
    public static List<List<String>> solveNQueens(int n) {
    	List<List<String>> res = new ArrayList<>();
    	if(n<1)return res;
    	int[] x = new int[n];
    	 
    	helper(x,0,res);
    	
    	return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		 List<List<String>> res = solveNQueens(5);
		for(List<String> l:res) {
			for(String s:l)
				System.err.println(s);
			System.err.println("\n");
		}
	}

}
