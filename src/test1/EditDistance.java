package test1;


/**
 * 
 * @author zwp12
 *
 * https://leetcode-cn.com/problems/edit-distance/description/
 *
 * 动态规划编辑距离
 *
 */


public class EditDistance {
    public static int minDistance(String word1, String word2) {
    	int m = word1.length();
    	int n = word2.length();
    	int[][] v = new int[m+1][n+1];
    	for(int i=0;i<=m;i++)v[i][0]=i;
    	for(int i=0;i<=n;i++)v[0][i]=i;
    	char a;
    	for(int i =1;i<=m;i++) {
    		a = word1.charAt(i-1);
    		for(int j=1;j<=n;j++) {
    			if(a==word2.charAt(j-1)) v[i][j]=v[i-1][j-1];
    			else {
    				v[i][j] = Math.min(v[i-1][j-1], 
    									Math.min(v[i-1][j],
    											v[i][j-1]));
    				v[i][j]++;
    			}
    		}
    	}

        return v[m][n];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "intention";
		String b = "execution";
		System.err.println(minDistance(a,b));
	}
	
	///////////////// 最快方法 //////////////
	public  int minDistance_(String word1, String word2) {
		int l1=word1.length(),l2=word2.length();
		int[][]f=new int[l1+1][l2+1];
		 
		 return miniDistance(word1,word2,l1,l2,f);	        
	}
	 public  int miniDistance(String word1,String word2,int l1,int l2,int[][]f)
	 {
		 
		 if(l1==0)return l2;
		 if(l2==0)return l1;
		 if(f[l1][l2]>0)return f[l1][l2];
		 
		 int ans;
		 if(word1.charAt(l1-1)==word2.charAt(l2-1)) ans=miniDistance(word1,word2,l1-1,l2-1,f);
		 else
		 {
			 ans=Integer.min(Integer.min(miniDistance(word1,word2,l1,l2-1,f),miniDistance(word1,word2,l1-1,l2,f)), miniDistance(word1,word2,l1-1,l2-1,f))+1;
		 }
		 return f[l1][l2]=ans;
	 }
	
	

}
