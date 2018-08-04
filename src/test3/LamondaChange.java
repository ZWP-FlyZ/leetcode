package test3;

/**
 * 
 * @author zwp12
 *
 * https://leetcode-cn.com/problems/lemonade-change/description/
 * 
 * 
 * 5,10,20元找零
 *
 */


public class LamondaChange {

    public static boolean lemonadeChange(int[] bills) {
        
    	int[] type = new int[3];
    	int n = bills.length;

    	 for(int i=0;i<n;i++) {
    		 if(bills[i]==5)type[0]++;
    		 else if(bills[i]==10) {
    			 if(type[0]<1)return false;
    			 type[1]++;type[0]--;
    			 
    		 }else if(bills[i]==20) {
    			 if(type[1]>0&&type[0]>0) {
    				 type[2]++;type[1]--;
    				 type[0]--;
    			 }else if(type[0]>2) {
    				 type[2]++;
    				 type[0]-=3;
    			 }else return false;
    		 }
    	}

    	return true;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] s= {10,10};
		System.err.println(lemonadeChange(s));
	}

}
