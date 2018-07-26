package test1;
/*
 * 回文整数检查
 * 
 * https://leetcode-cn.com/problems/palindrome-number/description/
 * 
 */
public class HuiWenInt {
	
	public static String int2str(int num) {
		return String.valueOf(num);
	}	
	
	
    public static boolean isPalindrome(int x) {
    	
    	char[] cs = int2str(x).toCharArray();
    	int start=0;
    	int end=cs.length-1;
    	for(;start<end;start++,end--)
    		if (cs[start]!=cs[end])  return false;
        return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.err.println(isPalindrome(-0));
	}

}
