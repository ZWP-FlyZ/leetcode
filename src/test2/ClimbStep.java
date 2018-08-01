package test2;

/**
 * 
 * @author zwp12
 * https://leetcode-cn.com/problems/climbing-stairs/description/
 * 
 * n个台阶，只能1步或者2步走，总共有几种方法
 * 
 * 
 * m[0]=m[1]=1;
 * m[n]=m[n-1]+m[n-2];
 * 
 */

public class ClimbStep {

    public static int climbStairs(int n) {
        int m_1=1,m_2=1;
        int tmp=1;
        for(int i=1;i<n;i++) {
        	tmp=m_1+m_2;
        	m_2=m_1;
        	m_1=tmp;
        }
    	return m_1;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.err.println(climbStairs(3));
	}

}
