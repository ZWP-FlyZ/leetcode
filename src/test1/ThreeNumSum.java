package test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author zwp12
 *
 * https://leetcode-cn.com/problems/3sum/description/
 *
 * 寻找数组中的三数和
 *
 */



public class ThreeNumSum {

	public static List<Integer> toList(int[] arr){
		return Arrays.asList(arr[0],arr[1],arr[2]);
	}
	
	public static boolean checkRep(int[] arr,Set<String> set){
		String tmp=Arrays.toString(arr);
		if(set.contains(tmp))return true;
		else {
			set.add(tmp);
			return false;
		}
	}	
	
    public  static List<List<Integer>> threeSum(int[] nums) {
    	
    	
    	int sum=0,n=0,index=0;
    	List<List<Integer>> res = new ArrayList<>();
    	Set<String> resStr = new HashSet<>();
    	int[] tmparr = new int[3];
    	if(nums==null || (n=nums.length)<3) return res;
    	
    	List<Integer> tmp = null;
    	
    	Arrays.sort(nums);
    	System.err.println(Arrays.toString(nums));
    	for(int i=0;i<n-2;i++) {
    		if(nums[i]>sum) break; // 肯定没有
    		if(nums[i]==nums[i+1]&&
    		   nums[i]==nums[i+2]&&
    		   i+3<n&&nums[i]==nums[i+3])
    			continue;
    		sum-=nums[i];
    		
    		tmparr[index++]=nums[i];
    		for(int j=i+1;j<n-1;j++) {
    			if(sum==0&&nums[j]==0&&nums[j+1]==0) {
    				tmparr[index++]=0;
    				tmparr[index++]=0;
    				if(!checkRep(tmparr, resStr)) 
        					res.add(toList(tmparr));
    			}
    			else if(nums[j]<sum) {
    				sum-=nums[j];
    				tmparr[index++]=nums[j];
    				
    				if(sum>=nums[j] && sum<=nums[n-1]&&
    						Arrays.binarySearch(nums, j+1, n, sum)>=0) {
        				tmparr[index++]=sum;
        				if(!checkRep(tmparr, resStr)) 
        							res.add(toList(tmparr));
    				}
    				sum+=nums[j];
    			}
    			else break;
    			
    			index=1;
    		}
    		sum=0;
    		index=0;
    	}
    	
        return res;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] res = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
		System.err.println(threeSum_(res));
		///System.err.println(Arrays.asList(a));
	}

	/////// 最佳方法
	
	 public static List<List<Integer>> threeSum_(int[] nums) {
	        
	      if (nums.length < 3)
	        return Collections.emptyList();
	      List<List<Integer>> res = new ArrayList<>();
	      int minValue = Integer.MAX_VALUE;
	      int maxValue = Integer.MIN_VALUE;
	      int negSize = 0;
	      int posSize = 0;
	      int zeroSize = 0;
	      for (int v : nums) {
	        if (v < minValue)
	          minValue = v;
	        if (v > maxValue)
	          maxValue = v;
	        if (v > 0)
	          posSize++;
	        else if (v < 0)
	          negSize++;
	        else
	          zeroSize++;
	      }
	      if (zeroSize >= 3)
	        res.add(Arrays.asList(0, 0, 0));
	      if (negSize == 0 || posSize == 0)
	        return res;
	      if (minValue * 2 + maxValue > 0)
	        maxValue = -minValue * 2;
	      else if (maxValue * 2 + minValue < 0)
	        minValue = -maxValue * 2;

	      int[] map = new int[maxValue - minValue + 1];
	      int[] negs = new int[negSize];
	      int[] poses = new int[posSize];
	      negSize = 0;
	      posSize = 0;
	      for (int v : nums) {
	        if (v >= minValue && v <= maxValue) {
	          if (map[v - minValue]++ == 0) {
	            if (v > 0)
	              poses[posSize++] = v;
	            else if (v < 0)
	              negs[negSize++] = v;
	          }
	        }
	      }
	      Arrays.sort(poses, 0, posSize);
	      Arrays.sort(negs, 0, negSize);
	      int basej = 0;
	      for (int i = negSize - 1; i >= 0; i--) {
	        int nv = negs[i];
	        int minp = (-nv) >>> 1;
	        while (basej < posSize && poses[basej] < minp)
	          basej++;
	        for (int j = basej; j < posSize; j++) {
	          int pv = poses[j];
	          int cv = 0 - nv - pv;
	          if (cv >= nv && cv <= pv) {
	            if (cv == nv) {
	              if (map[nv - minValue] > 1)
	                res.add(Arrays.asList(nv, nv, pv));
	            } else if (cv == pv) {
	              if (map[pv - minValue] > 1)
	                res.add(Arrays.asList(nv, pv, pv));
	            } else {
	              if (map[cv - minValue] > 0)
	                res.add(Arrays.asList(nv, cv, pv));
	            }
	          } else if (cv < nv)
	            break;
	        }
	      }
	      return res;
	    
	    }
	
	
}
