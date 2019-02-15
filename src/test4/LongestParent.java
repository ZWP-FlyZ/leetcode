package test4;

import java.util.Arrays;

/**
 * 
 * @author zwp12
 *
 * 	最长有效括号字符串
 *	https://leetcode-cn.com/problems/longest-valid-parentheses/description/
 *
 */

public class LongestParent {

	

    public static int longestValidParentheses(String s) {
    	int n = s.length();
    	if(n<2)return 0;
    	int[] stack = new int[n+1];
    	int max=0;
    	int i=0,sv=0,si=0;
    	// 找到第一个(
    	while(i<n && s.charAt(i)==')') i++;
    	stack[0]=i-1;
    	
    	while(i<n) {
    		if(s.charAt(i)=='(') {
    			sv++;
    			if(sv>si) {stack[sv]=i;si=sv;}
    			i++;
    		}else if(s.charAt(i)==')') {
    			
    			if(sv==0 && si>0) {
    				// 找到下一个 (
    				i++;
    				while(i<n && s.charAt(i)==')') i++;
    				stack[0]=i-1;
    				si=0;
    			}else if(sv>0) {
    				max = Math.max(max, i-stack[sv]+1);
    				sv--;
    				i++;
    			}
    		}// end else 
    		
    	}//end for
    	
        return max;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.err.println(longestValidParentheses("(())()(()(("));
	}

}
