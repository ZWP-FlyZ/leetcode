package test2;

/**
 * 
 * @author zwp12
 *  带权重的阶梯走法
 *  
 *  
 *  
 *  
 */


public class ClimbStepWeight {

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
    	int v1=0,v2=0,tmp;
    	for(int i=2;i<=n;i++) {
    		tmp=Math.min(v1+cost[i-1], v2+cost[i-2]);
    		v2=v1;
    		v1=tmp;
    	}
    	return v1;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
		System.err.println(minCostClimbingStairs(a));
	}

}
