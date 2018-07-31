package test2;

/**
 * 
 * @author zwp12
 * 
 * https://leetcode-cn.com/problems/minimum-path-sum/description/
 * 
 * 左上到右下最小路径和
 * 
 */


public class MinSumPath {

    public static int minPathSum(int[][] grid) {
    	
    	int m = grid.length;
    	int n=grid[0].length;
    	
    	int[] f = new int[n];
    

    	f[0] = grid[0][0];
		
    	for(int i=1;i<n;i++) {

    		f[i] = f[i-1]+ grid[0][i];
    	}
    		
    	for(int i=1;i<m;i++) {
    		f[0]+=grid[i][0];
    		for(int j=1;j<n;j++) {
    			f[j]=Math.min(f[j]+grid[i][j],
    						f[j-1]+grid[i][j]);
    		}    		
    	} 

        return f[n-1];
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] a= {{1,3,1},{1,5,1},{4,2,1}};
		
		System.err.println(minPathSum(a));
	}

}
