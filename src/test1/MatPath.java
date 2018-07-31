package test1;

/**
 * 
 * @author zwp12
 *
 * https://leetcode-cn.com/problems/unique-paths/description/
 * 
 * 
 * 在矩阵中n行m列，(0,0)到(n-1,m-1)的总路径数
 * 
 */

public class MatPath {
	
	
    public static int uniquePaths(int m, int n) {
        int[][] v = new int[m][n];
        for(int i=0;i<m;i++)v[i][0]=1;
        for(int i=0;i<n;i++)v[0][i]=1;
        for(int i=1;i<m;i++)
        	for(int j=1;j<n;j++)
        		v[i][j]=v[i-1][j]+v[i][j-1];
     
    	return v[m-1][n-1];
    }
	
	
	public static void main(String[] args) {
		System.err.println(uniquePaths(7,3));
		// TODO Auto-generated method stub

	}

}
