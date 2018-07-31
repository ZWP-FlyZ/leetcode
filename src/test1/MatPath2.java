package test1;

/**
 * 
 * @author zwp12
 *
 *
 * https://leetcode-cn.com/problems/unique-paths-ii/description/
 * 
 *
 */

public class MatPath2 {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
    	
    	////// 
    	
    	int[][] v = obstacleGrid;
    	int m=v.length;
    	int n=v[0].length;
    	if(v[0][0]==1) v[0][0]=0;
    	else v[0][0]=1;
    	for(int i=1;i<m;i++) {
    		if(v[i][0]==1) v[i][0]=0;
    		else v[i][0]=v[i-1][0];
    	}
    	for(int i=1;i<n;i++) {
    		if(v[0][i]==1) v[0][i]=0;
    		else v[0][i]=v[0][i-1];
    	}
    	
    	for(int i=1;i<m;i++)
    		for(int j=1;j<n;j++){
    			if(v[i][j]==1) v[i][j]=0;
    			else
    				v[i][j]=v[i-1][j]+v[i][j-1]; // 优化为空间O(n)
    		}    	
    	
    	
    	return v[m-1][n-1];
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a= {{0,0,0},
					{0,1,0},
					{0,0,0}};
		
//		int[][] a= {{1}};
		System.err.println(uniquePathsWithObstacles(a));
	}
	
	
	/////////////// 优化方法 /////////////
	
	

	    public int uniquePathsWithObstacles_(int[][] obstacleGrid) {
	        int m = obstacleGrid.length;
	        int n = obstacleGrid[0].length;
	        int[] f = new int[n];
	        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
	        for (int i = 0; i < m; i++) {
	            f[0] = obstacleGrid[i][0] == 0 ? f[0] : 0;
	            for (int j = 1; j < n; j++) {
	                f[j] = obstacleGrid[i][j] != 0 ? 0 : (f[j] + f[j - 1]);
	            }
	        }
	        return f[n - 1];
	    }


}
