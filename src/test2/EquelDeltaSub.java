package test2;


/**
 * 
 * @author zwp12
 * 
 * https://leetcode-cn.com/problems/arithmetic-slices/description/
 * 
 * 寻找连续元素的等差数列子序列个数
 * 
 */

public class EquelDeltaSub {

    public static int numberOfArithmeticSlices(int[] A) {
        int sum = 0,n=A.length;
        int delta=0,subn=2;
    	if(n<3)return sum;
    	delta = A[1]-A[0];
    	for(int i=2;i<n;i++) {
    		if(A[i]-A[i-1]==delta) subn++;
    		else {
    			 if(subn>2) 
    	    			sum+=(subn-1)*(subn-2)/2;
    			subn=2;
    			delta = A[i]-A[i-1];
    		}
	
    	}
    	if(subn>2) sum+=(subn-1)*(subn-2)/2;
    	return sum;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] s = {1, 3, 3, 3,6};
		System.err.println(numberOfArithmeticSlices(s));
	}
	
	
	
    public int numberOfArithmeticSlices_(int[] A) {
        int len = A.length;
        if(len < 3) return 0;
        
        int res = 0, add = 0;
        for(int i = 2; i < len; i++) {
            if(A[i]-A[i-1] == A[i-1]-A[i-2]) {
                add++;
                res += add;
            } else {
                add = 0;
            }
        }
        return res;
    }
	
	

}
