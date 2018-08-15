package test4;

/**
 * 
 * @author zwp12
 *
 * https://leetcode-cn.com/problems/max-increase-to-keep-city-skyline/description/
 * 
 * 城市天际线
 *
 *
 */


public class MaxIncrHigh {

    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int m = grid.length,n=grid[0].length;
        int[] tu = new int[n];
        int[] lr = new int[m];
        int cot=0;
        for(int i=0;i<m;i++)
        	for(int j=0;j<n;j++) {
        		tu[j]= Math.max(tu[j], grid[i][j]);
        		lr[i]=Math.max(lr[i], grid[i][j]);
        	}
        for(int i=0;i<m;i++)
        	for(int j=0;j<n;j++) {
        		cot+=Math.min(lr[i], tu[j])-grid[i][j];
        	}
        
    	return cot;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
