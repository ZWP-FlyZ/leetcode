package test3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author zwp12
 *
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/description/
 *
 * 寻找两个存在重复数据的数组交集
 * 
 * 
 * 
 * 
 */


public class InsectTwoArr {

    public static int[] intersect(int[] nums1, int[] nums2) {
        
    	List<Integer> res = new ArrayList<>();
    	Map<Integer,Integer> v = new HashMap<>();
    	int m = nums1.length,n=nums2.length;
    	Integer mv=null;
    	if(m==0||n==0) return new int[0];
    	for(int i=0;i<m;i++) {
    		if((mv=v.get(nums1[i]))!=null)
    			v.put(nums1[i], ++mv);
    		else
    			v.put(nums1[i], 1);	
    	}
    	mv=m;
    	Integer tmp=null;
    	for(int i=0;i<n&&mv>0;i++) {
    		if((tmp=v.get(nums2[i]))!=null && tmp>0) {
    			res.add(nums2[i]);
    			mv--;
    			v.put(nums2[i], --tmp);
    		}
    	}
    	int[] resarr = new int[res.size()];
    	for(int i=0;i<res.size();i++)
    		resarr[i]=res.get(i);
    	return resarr;
    	
    }
	
	
    public int[] intersect_(int[] nums1, int[] nums2) {
        /*
        if(nums1.length == 0 && nums2.length != 0){
            return new int[1];
        }else if(nums2.length == 0 && nums1.length !=0){
            return new int[1];
        }else if(nums1.length == 0 && nums2.length == 0){
            return new int[1];
        }
        */
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] result;
        if(nums1.length > nums2.length){
            result = new int[nums2.length];
        }else{
            result = new int[nums1.length];
        }
        int i=0,j=0,z=-1;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]==nums2[j]){
                result[++z]=nums1[i];
                i++;
                j++;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else{
                i++;
            }
        }
        int[] result1=new int[z+1];
        for(int k=0;k<=z;k++){
            result1[k]=result[k];
        }
        return result1;
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {1, 2, 2, 1};
		int[] b= {2,2};
		System.err.println(Arrays.toString(intersect(a,b)));
	}

}
