package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author zwp12
 *
 *
 * https://leetcode-cn.com/problems/letter-case-permutation/description/
 *
 * 将字符串中字母字符转换为大小写字符的所有情况
 *
 */

public class CharCastString {

	
	
	public static void updwcase(char[] s,int i) {
		if(s[i]>='a'&&s[i]<='z') 
			s[i]=(char) (s[i]-'a'+'A');
		else 
			s[i]=(char) (s[i]-'A'+'a');
	}
	
	
	public static  String chars2string(char[] s) {
		StringBuffer sb = new StringBuffer();
		sb.append(s);
		return sb.toString();
	}
	
	public static void helper(char[] s,int i, List<String> res) {
		while(i<s.length&&
				(s[i]<'a'||s[i]>'z')&&
				(s[i]<'A'||s[i]>'Z'))
			i++;
		
		if(i==s.length) res.add(chars2string(s));
		else {
			helper(s,i+1,res);
			updwcase(s,i);
			helper(s,i+1,res);
			updwcase(s,i);
		}
	}
	
	
    public static List<String> letterCasePermutation(String S) {
        int n = S.length();
        List<String> res = new ArrayList<>();
        char[] s = S.toCharArray();
        
    	if(n<1) {
    		res.add("");
    		return res;
    	}
    	
    	helper(s,0,res);
    
    	return res;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> tmp = letterCasePermutation("abcdefgzxc");
		for(String s : tmp) {
			System.err.println(s);
		}
	}

}
