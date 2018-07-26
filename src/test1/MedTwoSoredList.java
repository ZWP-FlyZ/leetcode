package test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 
 * @author zwp12
 * 分治递归法求解该问题
 *
 *
 */


public class MedTwoSoredList {

	public static void arr2list(int[] num,List<Integer> li) {
		for(int i =0;i<num.length;i++) li.add(num[i]);
	}
	
	
	public static void merge(	List<Integer>lia,
			List<Integer>lib,
			int left_a,int right_a,
			int left_b,int right_b) {
			
		int i = left_a,j=left_b,k=right_a-left_a+1;
		
		while(j<=right_b) {
			if(k<=0)
				lia.add(i++,lib.get(j++));
			else if(lia.get(i)>lib.get(j))
				lia.add(i++,lib.get(j++));
			else {
				k--;
				i++;
			}
		}
	}	
	
	public static int search(List<Integer>ori,int left,int right,int targ) {
		if (left>=right) return left;
		int med = (left+right)/2;
		if(ori.get(med)>targ) return search(ori,left,med-1,targ);
		else if(ori.get(med)<targ) return search(ori,med+1,right,targ);
		else return med;

	}
	
	
	
	public static void merge_rev(	List<Integer>lia,
								List<Integer>lib,
								int left_a,int right_a,
								int left_b,int right_b) {
		if(right_b==left_b || right_a==left_a) {
			merge(lia,lib,left_a,right_a,left_b,right_b);
		}// 归并
		else {
			int meda = (left_a+right_a)/2;
			int medb = (left_b+right_b)/2;
			int med_v_a = lia.get(meda);
			int med_v_b = lib.get(medb);
			int k = medb;
			if(med_v_a>=lib.get(right_b))
				merge_rev(lia,lib,left_a,meda,left_b,right_b);
			else if(med_v_a<lib.get(left_b))
				merge_rev(lia,lib,meda+1,right_a,left_b,right_b);
			else {
				if(med_v_a<med_v_b) {
					k = search(lib,left_b,medb,med_v_a);
				}
				else if(med_v_a>med_v_b) {
					k = search(lib,medb+1,right_b,med_v_a);
				}
				if(lib.get(k)>med_v_a) k--;
				merge_rev(lia,lib,meda+1,right_a,k+1,right_b);
				merge_rev(lia,lib,left_a,meda,left_b,k);				
			} 
	
		}
	
	}
	

	
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> li1 = new ArrayList<Integer>(nums1.length);
        List<Integer> li2 = new ArrayList<Integer>(nums2.length);
        arr2list(nums1,li1);
        arr2list(nums2,li2);
        //System.err.println(li1);
        //System.err.println(li2);
        if(li1.size()>0&&li2.size()>0)
        	merge_rev(li1,li2,0,li1.size()-1,0,li2.size()-1);
        else
        	li1.addAll(li2);
        //System.err.println(li1);
        int le = li1.size();
        int med = le/2;
        if(le%2==0)
        	return (li1.get(med)+li1.get(med-1))/2.0;
        else 
        	return li1.get(med);
    }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2};
		int[] b = {3,4,5,6,7};
		
		double med = findMedianSortedArrays(a,b);
		
		System.err.println(med);
	}
	
	
// 最佳解决方法	
	class Solution {
	    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	        int m = nums1.length, n = nums2.length, left = (m + n + 1) / 2, right = (m + n + 2) / 2;
	        return (findKth(nums1, nums2, left) + findKth(nums1, nums2, right)) / 2.0;
	    }
	    
	    int findKth(int[] nums1, int[] nums2, int k) {
	        int m = nums1.length, n = nums2.length;
	        if (m > n) return findKth(nums2, nums1, k);
	        if (m == 0) return nums2[k - 1];
	        if (k == 1) return Math.min(nums1[0], nums2[0]);
	        int i = Math.min(m, k / 2), j = Math.min(n, k / 2);
	        if (nums1[i - 1] > nums2[j - 1]) {
	            return findKth(nums1, Arrays.copyOfRange(nums2, j, n), k - j);
	        } else {
	            return findKth(Arrays.copyOfRange(nums1, i, m), nums2, k - i);
	        }
	    }
	    
	}
	
	
	
	
	
	
	
	
	

}
