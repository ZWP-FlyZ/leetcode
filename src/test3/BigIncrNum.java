package test3;

import java.util.Arrays;

/**
 * 
 * @author zwp12
 * 
 * 
 * 不大于N的最大递增数
 * 
 * https://leetcode-cn.com/problems/monotone-increasing-digits/description/
 * 
 * 
 */


public class BigIncrNum {

	
    public static int monotoneIncreasingDigits(int N) {
    	
    	int n=0,tmp=N;
    	int[] dig=new int[10];
    	boolean flag= false;
    	if(N>=0&&N<10)return N;
    	while(tmp>0){dig[n++]=tmp%10;tmp/=10;}

    	for(int ind=n-2;ind>=0;ind--) {
    		tmp=ind;
    		if(flag) {dig[ind]=9;continue;}
    		while(tmp<n-1 && dig[tmp]<dig[tmp+1]) {
    			flag=true;
    			dig[tmp]=9;
    			dig[tmp+1]=(9+dig[tmp+1])%10;
    			tmp++;
    		}
    	}//end for
    	tmp=0;
    	for(int i=n-1;i>=0;i--) tmp=tmp*10 + dig[i];
    	
    	return tmp;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.err.println(monotoneIncreasingDigits(332));
	}
	
}
