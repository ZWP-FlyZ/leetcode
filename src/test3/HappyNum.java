package test3;

/**
 * 
 * @author zwp12
 * 
 * https://leetcode-cn.com/problems/happy-number/description/
 * 
 * 
 */


public class HappyNum {

	public static int qut(int n) {return n*n;}
	public static boolean find(int[] arr,int v) {
		for(int e:arr)
			if(e==v) return true;
		return false;
	}
    public static boolean isHappy(int n) {
    	
    	if(n<1)return false;
    	if(n==1) return true;
        int MAXRE=100,tmp;
        int[] end = {4,16,37,58,89,145,42,20};
        while((MAXRE--)>0) {
        	tmp=0;
        	while(n>0) {
        		tmp+=qut(n%10);
        		n/=10;
        	}
        	System.err.println(tmp);
        	if(tmp==1) return true;
        	if(find(end,tmp))return false;
        	n=tmp;
        }
    	return false;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.err.println(isHappy(19));
	}

}
