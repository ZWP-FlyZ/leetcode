package test3;

import java.util.Arrays;

/**
 * 
 * @author zwp12
 *
 *https://leetcode-cn.com/problems/string-compression/description/
 *
 * 数据压缩
 */


public class DataCom {

	
	
	
    public static int compress(char[] chars) {
    	int n = chars.length;
    	int t=0,wt_idx=0,nowrepet=1;
    	char[] tmp = new char[5];
    	if(n<2) return n;
    	tmp[4]=chars[0];
    	for(int i=1;i<n;i++) {
    		if(chars[i]==tmp[4])
    			nowrepet++;
    		else {
    			chars[wt_idx++]=tmp[4];
    			if(nowrepet>1) {
    				t=0;
    				while(nowrepet>0) {
    					tmp[t++]=(char) (nowrepet%10);
    					nowrepet/=10;
    				}
    				while(--t>=0)
    					chars[wt_idx++]=(char) (tmp[t]+'0');
    			}
    			tmp[4]=chars[i];
    			nowrepet=1;
    		}	
    	}
    	chars[wt_idx++]=tmp[4];
		if(nowrepet>1) {
			t=0;
			while(nowrepet>0) {
				tmp[t++]=(char) (nowrepet%10);
				nowrepet/=10;
			}
			while(--t>=0)
				chars[wt_idx++]=(char) (tmp[t]+'0');
		}
    	return wt_idx;
    }
	
	////////////////////// 最佳方法 //////////////////////
    
    public int compress_(char[] chars) {
        int len = chars.length;
        if (len < 2) {
            return len;
        }
        int write = 0;
        // 当前重复的次数
        int duplicateTimes = 1;
        for (int i = 0; i < len; i++) {
            if (i != len - 1 && chars[i] == chars[i + 1]) {
                duplicateTimes++;
            } else {
                chars[write] = chars[i];
                write++;
                if (duplicateTimes == 1) {
                    continue;
                }
                char[] timesArr = String.valueOf(duplicateTimes).toCharArray();
                for (char c : timesArr) {
                    chars[write] = c;
                    write++;
                }
                duplicateTimes = 1;
            }
        }
        // 调试代码
        // printResult(chars, write);
        return write;
    }
    
    
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//char[] s = {'a','a','a','b','b','b','b','b','b','b','b','b','b','b','b','a','a','c'};
		char[] s = {'a','b','c'};
		int c = compress(s);
		System.err.println(c);
		System.err.println(Arrays.toString(s));
	}

}
