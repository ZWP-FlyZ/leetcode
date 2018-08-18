package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author zwp12
 *
 *
 * https://leetcode-cn.com/problems/restore-ip-addresses/description/
 *
 * 将ip数字串分割
 *
 */

public class IpSpliter {

	
	public static String[] tmp = new String[4];
	
	
	public static String c2s(char[] c,int i,int j) {
		StringBuffer sb = new StringBuffer();
		while(i<=j) {
			sb.append(c[i++]);
		}
		return sb.toString();
	}
	
	public static String arr2string(String[] ar) {
		String r = ar[0];
		for(int i=1;i<4;i++)
			r+="."+ar[i];
		return r;
	}
	
	public static boolean in(int n,int i,int j) {
		int x = n-i-1,y = 3-j;
		if(x>=y && x <= 3*(y)) return true;
		else return false;
	}
	
	public static void helper(char[] s,int i,int j,List<String> res) {
		if(i==s.length) res.add(arr2string(tmp));
		else {
				if(i<s.length&&in(s.length,i,j)) {
					tmp[j]=c2s(s,i,i);
					helper(s,i+1,j+1,res);
				}
				if(i+1<s.length&&s[i]>'0'&&
						in(s.length,i+1,j)) {
					tmp[j]=c2s(s,i,i+1);
					helper(s,i+2,j+1,res);
				}
				if(i+2<s.length&&s[i]>'0'
						&&in(s.length,i+2,j))  {
					if(Integer.parseInt(c2s(s,i,i+2))<256) {
						tmp[j]=c2s(s,i,i+2);
						helper(s,i+3,j+1,res);
					}
				}
				
		}
	
	}
	
	
    public static List<String> restoreIpAddresses(String s) {
        
    	 List<String> res = new ArrayList<>();
    	 if(s==null||s.length()<4||s.length()>12) return res;
    	 
    	 helper(s.toCharArray(),0,0,res);
    	 
    	return res;
    	
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> res = restoreIpAddresses("010010");
		for(String s:res)
			System.err.println(s);
		
	}

}
