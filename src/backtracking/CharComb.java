package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author zwp12
 *
 *
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/
 * 
 * 字母组合
 *
 */


public class CharComb {
	
	public static char[][] t= {{'a','b','c'},{'d','e','f'},
							   {'g','h','i'},{'j','k','l'},
							   {'m','n','o'},{'p','q','r','s'},
							   {'t','u','v'},{'w','x','y','z'}};
	public static char[] tmp=null;
	
	
	public static String arr2string(char[] s,int i) {
		StringBuffer sb = new StringBuffer();
		for(int k=0;k<i;k++)
			sb.append(s[k]);
		return sb.toString();
	}
	
	public static void helper(char[] s ,int i,int j,List<String> res) {
		while(i<s.length&&s[i]<='1') i++;
		if(i==s.length) {
			if(j>0) res.add(arr2string(tmp,j));
		}
		else  {
			for(char c:t[s[i]-'2']) {
				tmp[j]=c;
				helper(s,i+1,j+1,res);
			}
		}
		
	} 
	
    public static  List<String> letterCombinations(String digits) {
    	List<String> res = new ArrayList<String>();
    	if(digits==null||digits.length()<1)return res;
    	tmp = new char[digits.length()];
    	helper(digits.toCharArray(),0,0,res);
    	return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> res = letterCombinations("1111121113111");
		for(String s:res)
			System.err.println(s);
	}

}
