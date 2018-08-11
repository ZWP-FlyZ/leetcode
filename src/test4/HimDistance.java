package test4;

/**
 * 
 * @author zwp12
 * 
 * https://leetcode-cn.com/problems/hamming-distance/description/
 * 
 * 计算两个数的汉明距离
 *
 */


public class HimDistance {

    public static int hammingDistance(int x, int y) {
        int dis = 0;
        if(x<0||y<0)return dis;
        while(x>0||y>0) {
        	if(x%2!=y%2)dis++;
        	x/=2;y/=2;
        }
        return dis;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.err.println(hammingDistance(4,5));
	}

}
