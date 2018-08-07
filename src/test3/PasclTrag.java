package test3;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author zwp12
 * 
 * https://leetcode-cn.com/problems/pascals-triangle/description/
 * 
 * 杨辉三角
 * 
 */


public class PasclTrag {

    public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> res =new ArrayList<>();
    	if(numRows>=1) {
    		List<Integer> tmp = new ArrayList<>();
    		tmp.add(1); res.add(tmp);
    	}
    	if(numRows>=2) {
    		List<Integer> tmp = new ArrayList<>();
    		tmp.add(1);tmp.add(1); 
    		res.add(tmp);
    	}
    	if(numRows>2) {
    		for(int i=2;i<numRows;i++) {
    			List<Integer> tmp = new ArrayList<>();
    			List<Integer> last = res.get(i-1);
    			tmp.add(1);
    			for(int j =1;j<i;j++) {
    				tmp.add(last.get(j-1)+last.get(j));
    			}
    			tmp.add(1);	
    			res.add(tmp);
    		}
    	}
    	return res;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
