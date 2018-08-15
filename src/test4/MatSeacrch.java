package test4;

import java.util.Arrays;

/**
 * 
 * @author zwp12
 *
 *
 * https://leetcode-cn.com/problems/search-a-2d-matrix/description/
 *
 * 排列二维数组搜索
 *
 */

public class MatSeacrch {

	public static int col_binsearch(int[][] mat,int tag) {
		int m = mat.length;
		int up=0,dw = m-1;
		int mid = (up+dw)/2;
		while(up<=dw) {
			if(mat[mid][0]==tag) return mid;
			else if(mat[mid][0]>tag) dw=mid-1;
			else if(mat[mid][0]<tag) up = mid+1;
			mid = (up+dw)/2;
		}
		return up;
	}
	
    public static boolean searchMatrix(int[][] mat, int target) {
         if(mat.length<1||mat[0].length<1)return false;
         int m = mat.length,n=mat[0].length;
         if(mat[0][0]>target||mat[m-1][n-1]<target) return false;
         int ind = col_binsearch(mat,target);
         if(ind<m&&mat[ind][0]==target) return true;
         ind--;
         if(Arrays.binarySearch(mat[ind], target)<0) return false;
         else return true;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] b = {{1,3}};
		System.err.println(searchMatrix(b,2));

	}

}
