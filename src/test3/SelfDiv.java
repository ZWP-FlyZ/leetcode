package test3;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author zwp12
 *
 * https://leetcode-cn.com/problems/self-dividing-numbers/description/
 * 
 * 一个数自己每个位都可以整除自己
 *
 */


public class SelfDiv {

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        
    	if(left>right||left<1||right>10000) return res;
    	int tmp=0,loc;boolean flag=false;
    	for(int i=left;i<right+1;i++) {
    		tmp=i;flag=true;
    		while(tmp>0) { 
    			if((loc=tmp%10)==0||i%loc!=0) {
    				flag=false;break;
    			}
    			tmp/=10;
    		}
    		if(flag)res.add(i);
    	}
    	return res;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> res = selfDividingNumbers(1,22);
		for(Integer s : res) {
			System.err.println(s);
		}
	}

}
