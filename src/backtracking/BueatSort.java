package backtracking;

/**
 * 
 * @author zwp12
 *
 *
 * https://leetcode-cn.com/problems/beautiful-arrangement/description/
 *
 * 1-N的序列改变元素顺序，
 *  使得第i个元素能被i整除或者i能被第i个元素整除
 *
 *
 */


public class BueatSort {

	public static int res=0;
	
	public static void swap(int[] s,int i,int j) {
		int k = s[i];
		s[i]=s[j];
		s[j]=k;
	}
	
	public static void helper(int[] s,int i) {
		if(i==s.length) res++;
		for(int k=i;k<s.length;k++) {
			if(s[k]%i!=0&&i%s[k]!=0) continue;
			swap(s,i,k);
			helper(s,i+1);
			swap(s,i,k);
		}
		
		
	}
	
	public static int countArrangement(int N) {
		res=0;
		if(N<3) return N>=0?N:0;
		int[] s = new int[N+1];
		for(int i=1;i<=N;i++)
			s[i]=i;
		helper(s,1);
		
		return res;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.err.println(countArrangement(4));
	}

}
