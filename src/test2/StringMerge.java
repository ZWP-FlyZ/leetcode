package test2;

import java.util.HashMap;

/**
 * 
 * @author zwp12
 *
 * https://leetcode-cn.com/problems/interleaving-string/description/
 * 
 * 
 * 检查s3 是否由s1与s2 混合而来
 *
 * 
 */


public class StringMerge {

	
	/// 递归法解决问题 t=1000ms
	public static boolean mergecheck(char[] s1, char[] s2, char[] s3,int i1,int i2,int i3) {
		
		if(i1<s1.length&&i2<s2.length) {
		
			if(s1[i1]==s2[i2]&&s1[i1]==s3[i3]) {
				
				if(mergecheck(s1,s2,s3,i1+1,i2,i3+1))return true;
				else return mergecheck(s1,s2,s3,i1,i2+1,i3+1);
				
			}else if(s1[i1]==s3[i3])
				return mergecheck(s1,s2,s3,i1+1,i2,i3+1);
			else if(s2[i2]==s3[i3])
				return mergecheck(s1,s2,s3,i1,i2+1,i3+1);
			
			return false;
			
		}
		else if(i1<s1.length) 
			if(s1[i1]==s3[i3])
				return mergecheck(s1,s2,s3,i1+1,i2,i3+1);
			else return false;
		
		else if(i2<s2.length)
			if(s2[i2]==s3[i3])
				return mergecheck(s1,s2,s3,i1,i2+1,i3+1);
			else return false;
		
		return true;
		
	}
	
		
	
    public static boolean isInterleave_(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if((len1 + len2) != len3){ 
            return false;
        }
        boolean[][] dp = new boolean[len1+1][len2+1];
        dp[0][0] = true; 
        for(int i = 0; i < len1+1; i++){
            for(int j = 0; j < len2+1; j++){
                if((i-1) >= 0 && dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i-1+j)){
                    dp[i][j] = true;
                }
                if((j-1) >= 0 && dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1)){ 
                    dp[i][j] = true;
                } 
            }
        }
        return dp[len1][len2];
    }	
	
    
    public static boolean isInterleave__(String s1, String s2, String s3) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c3 = s3.toCharArray();
        if(c1.length + c2.length != c3.length)
            return false;
        HashMap<Integer, Boolean> cache = new HashMap<>();
        return dfs(cache, c1, 0, c2, 0, c3, 0);
        
    }
    public static boolean dfs(HashMap<Integer, Boolean> cache, char[] c1, int pos1, char[] c2, int pos2, char[] c3, int pos3){
        if(pos3==c3.length) return true;
        int key = pos1*c3.length+pos2;
        if(cache.containsKey(key)) return false;
        if(pos1<c1.length && c1[pos1]==c3[pos3] && dfs(cache, c1, pos1+1, c2, pos2, c3, pos3+1))
            return true;
        if(pos2<c2.length && c2[pos2]==c3[pos3] && dfs(cache, c1, pos1, c2, pos2+1, c3, pos3+1))
            return true;
        cache.put(key, false);
        return false;       
    }
    
	
    public static boolean isInterleave(String s1, String s2, String s3) {
    	if(s1.length()+s2.length()!=s3.length())
    		return false;
       
    	return mergecheck(s1.toCharArray(),s2.toCharArray(),s3.toCharArray(),0,0,0);
    }
    
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a="bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa";
		String b="babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab";
		String c="babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab";
		System.err.println(a);
		System.err.println(b);
		System.err.println(c);
		System.err.println(isInterleave__(a,b,c));
	}

}
