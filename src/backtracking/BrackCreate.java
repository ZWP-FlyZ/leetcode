package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author zwp12
 *
 * https://leetcode-cn.com/problems/generate-parentheses/description/
 *
 *
 * 回溯法生成所有可能括号对
 *
 */


public class BrackCreate {

	public static String arr2string(char[] s) {
		return new StringBuffer().append(s).toString();
	}
	
	
	public static void helper(int in,int out,int s,char[] tmp,List<String> res) {
		if(in>0) {
			tmp[s]='(';
			helper(in-1,out,s+1,tmp,res);
		}
		if(out>0&&in<out){
			tmp[s]=')';
			helper(in,out-1,s+1,tmp,res);
		}
		if(s==tmp.length)	
			res.add(arr2string(tmp));

	}
	
    public static List<String> generateParenthesis(int n) {
    	List<String> res= new ArrayList<>();
    	char[] tmp = new char[n*2];
    	tmp[0]='(';
    	helper(n-1,n,1,tmp,res);
    	return res;
    	
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> res = generateParenthesis(10);
		for(String s:res)
			System.err.println(s);
	}

}
