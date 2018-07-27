package test1;

/**
 * 
 * @author zwp12
 *
 *https://leetcode-cn.com/problems/string-to-integer-atoi/description/
 * 字符串转Int32
 *
 */


public class MyAtoi {

	public static int MAX_INT_32 = Integer.MAX_VALUE;
	public static int MIN_INT_32 = Integer.MIN_VALUE;
	
	public static boolean isNum(char c) {
		if(c<'0' || c>'9')return false;
		else return true;
	}
	
	public static int char2int(char c) {
		if(c<'0' || c>'9')return -1;
		else return (int)(c-'0');		
	}
	
    public static int myAtoi(String str) {
        int index=0,m=str.length(),tmpi;
        long tmp = 0;
        char tmpc=0;
        int arrInd=1;
        int[] arr = new int[21];
        arr[0]=1;
        for(;;index++){
        	if(index==m) return 0;// 全空格或者空字符串
        	tmpc = str.charAt(index);
        	if(tmpc == ' ') continue; //非空格字符
        	else if(tmpc=='+'||tmpc=='-') {
        		if(index+1==m||!(isNum(str.charAt(index+1)))) // 无法转换
        			return 0;
        		else {
        			arr[0]=tmpc=='+'?1:-1;
        			index++;
        			break;
        		} 
        	}
        	else if(isNum(tmpc)) break;
        	else return 0;// 非正负号
        }
        
                
        
        while(index<m) {
        	tmpi=char2int(str.charAt(index++));
        	if(tmpi<0) break;//检查到非数字
        	if(arrInd==1&&tmpi==0)//前置0
        		continue;
        	
        	arr[arrInd++]=tmpi;
        	if(arrInd>15)
        		return arr[0]>0?MAX_INT_32:MIN_INT_32;
        	
        }
        for(int i=1;i<arrInd;i++)
        	tmp=tmp*10+arr[i];
        tmp*=arr[0];
        
        if(tmp>MAX_INT_32)return MAX_INT_32;
        else if(tmp<MIN_INT_32) return MIN_INT_32;
        else return (int)tmp;
    }
	
	
	public static void main(String[] args) {
		
		System.err.println(myAtoi("- sfa"));
		
	}
	
	
	/////////////最佳方法/////////////
	 public int myAtoi_(String str) {
	        int index = 0;
	        long out = 0;
	        boolean positive = true;
	        while (index < str.length() && str.charAt(index) == ' '){
	            ++index;
	        }
	        if (index < str.length() && str.charAt(index) == '-'){
	            positive = false;
	            ++index;
	        }
	        else if (index < str.length() && str.charAt(index) == '+'){
	            ++index;
	        }
	        while (index < str.length() && Character.isDigit(str.charAt(index))){
	            out = out * 10 + str.charAt(index) - '0';
	            if (out > Integer.MAX_VALUE){
	                return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
	            }
	            ++index;
	        }
	        return positive ? (int) out : (int) -out;
	    }
	
	
	
	

}
