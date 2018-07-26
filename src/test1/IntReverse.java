package test1;

/*
 * 回文整数
 * https://leetcode-cn.com/problems/reverse-integer/description/
 * 
 */

public class IntReverse {

	public static Integer str2int(String str) {
		try {
			return Integer.parseInt(str);
		} catch (Exception e) {
			return 0;
		}
	}
	
	public static String int2str(int num) {
		return String.valueOf(num);
	}
	
	public static String reverseStr(String str,int start,int end) {
		char[] oris = str.toCharArray();
		char tmp = 0;
		for(;start<end;start++,end--) {
			tmp = oris[start];
			oris[start]=oris[end];
			oris[end]=tmp;
		}
		return new String(oris);
	}
	
    public static int reverse(int x) {
    	if(x==0) return 0;
    	String str_x = int2str(x);
    	int end = str_x.length()-1;
    	int start=0;
    	if(x<0) start=1;
    	String re_x = reverseStr(str_x,start,end);
        return str2int(re_x);
    }	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.err.println(reverse(2111144444));
	}

}
