package test4;

import java.util.Arrays;

/**
 * 
 * @author zwp12
 *
 *
 *	在0-1矩阵中寻找最大只包含1的子矩阵
 *
 * https://leetcode-cn.com/problems/maximal-rectangle/description/
 *
 *
 */

public class MaxRectang {

	public static int[][] char2int(char[][] m){
		int[][] ret = new int[m.length][m[0].length];
		for(int i=0;i<m.length;i++)
			for(int j=0;j<m[0].length;j++)
				ret[i][j]=m[i][j]-'0';
		return ret;
	}
	
	public static int line_max(int[] li) {
		int max=0,b=0;
		for(int i=0;i<li.length;i++) {
			if(li[i]==0) b=0;
			else {
				b+=li[i];
				if(b>max)max=b;
			}
		}
		return max;
	}
	
	public static void line_sum(int[] s,int[] t) {
		for(int i=0;i<s.length;i++) {
			if(s[i]!=0 && t[i]!=0) s[i]+=t[i];
			else s[i]=0;
		}	
	}
	
	
    public static int maximalRectangle(char[][] matrix) {
    	
    	
    	if(matrix==null || matrix.length<1 || 
    		matrix[0]==null || matrix[0].length <1) return 0;
    	int[][] mat = char2int(matrix);
    	int max=0,m=mat.length;
    	int tmp=0;
    	for(int i=0;i<m;i++) {
    		tmp= line_max(mat[i]);
    		if(tmp>max)max=tmp;
    		for(int j=i+1;j<m;j++) {
    			line_sum(mat[i],mat[j]);
        		tmp= line_max(mat[i]);
        		if(tmp>max)max=tmp;
    		}
    	}
        return max;
    }
	
    
    ////////////////// 较好方法 ///////////////////////
    
    public int maximalRectangle_(char[][] matrix) {
        if(matrix.length == 0)
            return 0;
        int max = 0;
        int m = matrix.length;
        int n = matrix[m-1].length;

        int[][] metrix = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(j==0){
                    if(matrix[i][j]=='1'){
                        metrix[i][j]= 1;
                    }
                    else
                        metrix[i][j] = 0;
                }
                else{
                    if(matrix[i][j]=='0')
                        metrix[i][j]=0;
                    else{
                        metrix[i][j] = metrix[i][j-1]+1;
                    }
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(metrix[i][j]==0)
                    continue;
                int count = 1;
                for(int k = i-1;k>=0 && metrix[k][j]>=metrix[i][j];k--,count++);
                for(int k = i+1;k<m && metrix[k][j]>=metrix[i][j];k++,count++);

                if(max<metrix[i][j] * count){
                    max = metrix[i][j] * count;
                }
            }
        }
        return max;
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		char[][] mat = {{'1','0','1','0','0'},
//						{'1','0','1','1','1'},
//						{'1','1','1','1','1'},
//						{'1','0','0','1','0'}};
		char[][] mat = new char[1][1];
		mat[0][0]='1';
		System.err.println(maximalRectangle(mat));
	}

}
