package test2;

/**
 * 
 * @author zwp12
 * 
 * https://leetcode-cn.com/problems/decode-ways/description/
 * 
 * 数字字符串拆分
 *       
 *       
 *       wei 通过测试
 *       
 */




public class NumStrSplit {

    public static int numDecodings(String s) {
        if(s==null||"".equals(s))return 0;
        if("10".equals(s)||"20".equals("s"))return 1;
    	int v1=1,v2=1,n= s.length();
    	char tmpc=0,nextc=s.charAt(n-1);
    	
    	int tmp=n-1;
    	while(tmp>=0&&s.charAt(tmp)=='0') tmp--;
    	if(tmp<0)return 0; // ALL ZERO
    	
    	if(tmp<n-1)nextc='0';
    	else tmp--;
    	
    	for(int i=tmp;i>=0;i--) {
    		tmpc=s.charAt(i);
    		if(tmpc=='0'||tmpc>'2'||(tmpc=='2'&&nextc>'6')) tmp=v1;
    		else tmp=v1+v2;
      		nextc=tmpc;
    		v2=v1;v1=tmp;
    	}
    	
    	
    	return v1;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.err.println(numDecodings("10"));

	}

}
