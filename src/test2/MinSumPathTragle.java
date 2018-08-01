package test2;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author zwp12
 * 
 * [
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
	]
 * min = 2+3+5+1=11
 * 计算三角性最小路径
 * 
 * https://leetcode-cn.com/problems/triangle/description/
 */


public class MinSumPathTragle {

    public static int minimumTotal(List<List<Integer>> triangle) {
    	int n = triangle.size();
    	List<Integer> la = triangle.get(n-1),tmp;
    	for(int i=n-2;i>=0;i++) {
    		tmp=triangle.get(i);
    		for(int j=0;j<=i;j++)
    		la.set(j,Math.min(la.get(j)+tmp.get(j), la.get(j+1)+tmp.get(j)));
    	}
    	
        return la.get(0);
    }
	
	
	public static void main(String[] args) {
		List<List<Integer>> ll = new ArrayList<>();
		List<Integer> l = new ArrayList<>();
		
		l.add(2);
		ll.add(l);
		
		System.err.println(minimumTotal(ll));
	}

}
