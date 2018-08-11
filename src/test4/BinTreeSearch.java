package test4;
/**
 * 
 * @author zwp12
 *
 * https://leetcode-cn.com/problems/binary-tree-tilt/description/
 *
 * 二叉树遍历相关问题
 *
 */


public class BinTreeSearch {
	
	

	 class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }

	
	
    public static int findTilt(TreeNode root) {
    	int v =0;
    	if(root==null)return 0;
    	v =root.left==null?0:root.left.val;
    	v =v-(root.right==null?0:root.right.val);
    	v =Math.abs(v);
    	v+=findTilt(root.left);
    	v+=findTilt(root.right);
    	return v;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
