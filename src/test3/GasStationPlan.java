package test3;

/**
 * 
 * @author zwp12
 * 
 * https://leetcode-cn.com/problems/gas-station/description/
 * 
 * 寻找一个起始点可以绕一圈
 * 
 * 
 * 
 */


public class GasStationPlan {

	
	
    public static int canCompleteCircuit(int[] gas, int[] cost) {
    	int n = gas.length,start=-1,tmpsum=0;
    	int[] delta = new int[n];
    	if(n==1) return gas[0]-cost[0]>=0?0:-1;
    	
    	for(int i=0;i<n;i++) {
    		delta[i]=gas[i]-cost[i];
    		tmpsum+=delta[i];
    		if(start<0&&delta[i]>=0) start=i;
    	}
    	if (start<0||tmpsum<0) return -1;
    	
    	
    	for(int i=start;i<n;i++) {
    		if(delta[i]<0) continue;
    		tmpsum=0;
    		for(int j=0;j<n;j++) {
    			tmpsum+=delta[(i+j)%n];
    			if(tmpsum<0) break;
    		}
    		if(tmpsum>=0)return i;
    	}

        return -1;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3,4,5};
		int[] b= {3,4,5,1,2};
		System.err.println(canCompleteCircuit_(a,b));
	}
	
	
    public static int canCompleteCircuit_(int[] gas, int[] cost) {
    	int n = gas.length,start=-1,tmpsum=0,total=0;
    	int index=0;
    	if(n==1) return gas[0]-cost[0]>=0?0:-1;
    	
    	for(int i=0;i<n;i++) {
    		tmpsum+=gas[i]-cost[i];
    		total+=gas[i]-cost[i];
    		if(tmpsum<0) {tmpsum=0;index=i+1;}
    	}
    	if(total<0) return -1;
    	else return index;

    }
	
	

}
