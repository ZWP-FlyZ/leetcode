package test2;

import java.util.Arrays;

/**
 * 
 * @author zwp12
 * 
 * 
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/description/
 * 
 * 最多两次不重叠购买最佳购买股票时机
 *  
 * 
 *  
 *  
 */


public class TwoDirBestStock {

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int max = 0,al,br,tmp,bind;
        int[] a=new int[n];
        int[] b=new int[n];
        
        if(n<2)return 0;
        else if(n==2)
        	return (max=prices[1]-prices[0])>0?max:0;
        else {
        	al=prices[0];br=prices[n-1];
        	for(int i=1;i<n;i++) {
        		
        		if((tmp=prices[i]-al)>=0)
        			a[i]=Math.max(a[i-1], tmp);
        		else {
        			al = prices[i];
        			a[i]=a[i-1];
        		}
        		bind = n-1-i;
        		if((tmp=br-prices[bind])>=0) 
        			b[bind] = Math.max(b[bind+1], tmp);
        		else {
        			br = prices[bind];
        			b[bind]=b[bind+1];
        		}
        	}
        	for(int i=0;i<n-1;i++)
        		max = Math.max(max, a[i]+b[i]);
        	System.err.println(Arrays.toString(a));
        	System.err.println(Arrays.toString(b));
        }
    	return max;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {9,7,8,8,5,9};
		System.err.println(maxProfit(a));
	}

}
