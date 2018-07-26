package test1;

import java.util.Arrays;

public class NoRepSubString {

	/*
	 * 最长无重复子串
	 * 
	 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/
	 * 
	 */

	
	public static int index(char[] ori,int start,int end,char tag) {
		for(int i= start;i<=end;i++)
			if (ori[i]==tag) return i;
		return -1;
	}
	
	
    public static int lengthOfLongestSubstring(String s) {
    	char[] char_arrs = s.toCharArray();
    	int string_size = s.length();
    	int max_start=0,max_end = 0;
    	int start=0,end=0,check=0;
    	if(s.equals("")) return 0;
//    	while(end<string_size-1) {
//    		for(end=start;end<string_size-1;end++) {
//    			check = index(char_arrs,start,end,char_arrs[end+1]);
//    			if (check>=0) break; // 检查到重复
//    		}
//    		if((max_end-max_start)<(end-start)) {
//    			max_start = start;
//    			max_end = end;
//    		}
//    		if(check>=0) start = check+1;
//    	}
    	
		while(end<string_size-1) {
			check = index(char_arrs,start,end,char_arrs[end+1]);
			if (check>=0) {
				
				if((max_end-max_start)<(end-start)) {
					max_start = start;
					max_end = end;
				}
				
				start = check+1;
			} // 检查到重复
			end++;
		}
		if((max_end-max_start)<(end-start)) {
			max_start = start;
			max_end = end;
		}
	  	
    	
    	System.err.println(new String(Arrays.copyOfRange(char_arrs, max_start, max_end+1)));
        return max_end-max_start+1;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.err.println(lengthOfLongestSubstring("dvdf"));
	}

}
