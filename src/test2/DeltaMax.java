package test2;

/**
 * 
 * @author zwp12
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/description/
 * 
 * 
 * 求解相差最大的位置
 *
 */

public class DeltaMax {

    public static int maxProfit(int[] prices) {
        int max=0,delta=0,start=0;
    	int n=prices.length;
    	if(n<=1)return max;
    	for(int i=1;i<n;i++) {
    		if((delta=(prices[i]-prices[start]))<0)
    			start=i;
    		else 
    			max=Math.max(max, delta);
    	}

    	return max;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] s = {7,1,5,3,6,4};
		System.err.println(maxProfit(s));
	}

}
