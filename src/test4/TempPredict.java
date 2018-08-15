package test4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author zwp12
 *
 *https://leetcode-cn.com/problems/daily-temperatures/description/
 *
 * 温度预测
 *
 */

public class TempPredict {

	
	
	
	// 从后往前规划，v[i] 与  v[i+1]的升温点比较 
	public static int[] dailyTemperatures(int[] temps) {
		if(temps.length<1)return new int[0];
		int n = temps.length;
		int[] res =  new int[n];
		for(int i =n-2,j=0;i>=0;i--) {
			if(temps[i]<temps[i+1])res[i]=1;
			else {
				j=1;
				while(res[i+j]>0) {
					j+=res[i+j];
					if(temps[i]<temps[i+j]) {res[i]=j;break;}
				}
			}
		}
		return res;
	}
		
	
	

    // 暴力法 
    public static int[] dailyTemperatures__(int[] temperatures) {
    	int n=temperatures.length,tmp=0;
    	for(int i=0;i<n;i++) {
    		tmp=0;
    		for(int j=i+1;j<n;j++) 
    			if(temperatures[j]>temperatures[i]) {
    				tmp=j-i;break;
    			}
    		temperatures[i]=tmp;
    	}
    	return temperatures;
    }
    
   
    ////////////////////////////// 动态规划法
    public static int[] dailyTemperatures_(int[] temps) {
        if (temps ==null || temps.length <1) return new int[0];
        int[] ret = new int[temps.length];
        
        // Note: last one (ret[ret.length-1]) is always 0
        for (int i=temps.length-2; i >=0; i--){
            // System.out.println(">>> " +temps[i]+ " <<<");
            if (temps[i] < temps[i+1]) {
                ret[i] =1;
            }
            else {
                int dist =1;
                // System.out.println(temps[i+dist] + "|" + ret[i+dist]);
                while(ret[i+dist] !=0) {
                    dist +=ret[i+dist];
                    if (temps[i] < temps[i+dist]){
                        ret[i] =dist;
                        // System.out.println("BB");
                        // System.out.println(temps[i+dist] + "->" + dist);
                        break;
                    }
                }
            }
        }
        
        return ret;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] t = {73, 74, 75, 71, 69, 72, 76, 73};
		System.err.println(Arrays.toString(dailyTemperatures(t)));
	}

}
