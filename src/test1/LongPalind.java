package test1;

/**
 * 
 * @author zwp12
 *
 * https://leetcode-cn.com/problems/longest-palindromic-substring/description/
 * 最长回文子串
 */


public class LongPalind {

	
	public static boolean checkPalind(String s,int left,int right) {
		while(left<=right) {
			if(s.charAt(left++)!=s.charAt(right--))
				return false;
		}
		return true;
	}
	
	// 暴力解法 O(n*n*n)
	public static int longestPali(String s) {
		int n = s.length();
		int max=1;
		for(int i=0;i<n-1;i++)
			for(int j=i+1;j<n;j++) {
				if(checkPalind(s,i,j)) 
					max = Math.max(max, j-i+1);
			}
		return max;
	}
	
	
	// 动态规划解法 p(i,j) = p(i+1,j-1) & a[i]==a[j]
	// 初始化 p(i,i)=true p(i,i+1)=a[i]==a[i+1]
	// O(n*n) 
	public static String dp_longestPali(String s) {
		if(s==null || "".equals(s))return "";
		
		int n = s.length();
		int max=1,max_l=0,max_r=0;
		boolean[][] p = new boolean[n][n];
		
		for(int i=0;i<n-1;i++) {
			p[i][i]=true;
			if(s.charAt(i)==s.charAt(i+1)) {
				p[i][i+1]=true;
				max=2;
				max_l=i;max_r=i+1;
			}
		} 
		p[n-1][n-1]=true;
		int len=0;
		for(int k=2;k<n;k++)
			for(int i=0;i<n-k;i++) {
				int j=i+k;
				p[i][j]=p[i+1][j-1]&s.charAt(i)==s.charAt(j);
				if(p[i][j]&&(len=j-i+1)>max) {
					max=len;
					max_l=i;max_r=j;
				}
			}
		return s.substring(max_l, max_r+1);
	}
	
	
	// 中心扩张法
	// O(n*n) 空间O(1)
	public static String inout_longestPali(String s) {
		if(s==null || "".equals(s))return "";
		int left=0,right=0;
		for(int i=0;i<s.length();i++) {
			int t = Math.max(inout_search(s,i,i),
					inout_search(s,i,i+1));
			System.err.println(t);
			if(t>right-left) {
				left=i-(t-1)/2;
				right=i+t/2;
			}
		}
		return s.substring(left, right+1);
	}
	
	public static int inout_search(String s,int left,int right) {
		while(left>=0 && right<s.length()&&s.charAt(left)==s.charAt(right)) {
			left--;right++;
		}
		return right-left-1;
	}
	
	
	
	
	
	public static void main(String[] args) {
		String s = "cabba";
		System.err.println(inout_longestPali(s));

	}

}
