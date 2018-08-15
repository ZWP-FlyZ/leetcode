package test4;

/**
 * 
 * @author zwp12
 *
 * https://leetcode-cn.com/problems/backspace-string-compare/description/
 * 字符串生成
 *
 */

public class BackSpaceString {

    public static boolean backspaceCompare(String S, String T) {
    	StringBuffer sbs = new StringBuffer();
    	StringBuffer sbt = new StringBuffer();
    	char[] sc = S.toCharArray();
    	char[] tc = T.toCharArray();
    	int i=0,j=0;
    	char tmp;
    	while(i<sc.length||j<tc.length) {
    		if(i<sc.length) {
    			tmp = sc[i++];
    			if(tmp!='#')
    				sbs.append(tmp);
    			else if(sbs.length()>0)
    				sbs.deleteCharAt(sbs.length()-1);
    		}
    		
    		if(j<tc.length){
    			tmp = tc[j++];
    			if(tmp!='#')
    				sbt.append(tmp);
    			else if(sbt.length()>0)
    				sbt.deleteCharAt(sbt.length()-1);
    		}
    	}
    	return sbs.toString().equals(sbt.toString());
    }
	
    /////////////// 最佳方法 ////////////////////
    
    
    public boolean backspaceCompare_(String S, String T) {
        return convert(S).equals(convert(T));
     }
     
     private String convert(String str) {
         int index = 0;
         char[] chars = new char[str.length()];
         for (int i=0; i<str.length(); i++) {
             char c = str.charAt(i);
             if (c != '#')
                 chars[index++] = c;
             else {
                 if (index > 0)
                     index--;
             }
         }
         return new String(chars,0,index);
     }
    
	
	public static void main(String[] args) {
		System.err.println(backspaceCompare("a###a","b#a"));
		// TODO Auto-generated method stub

	}

}
