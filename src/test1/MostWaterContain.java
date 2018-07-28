package test1;

public class MostWaterContain {

	
    public static int maxArea(int[] height) {
        int max=-1,i=0,j=height.length-1;
        while(i<j) {
        	max = Math.max(max, Math.min(height[i],height[j])*(j-i));
        	if(height[i]<height[j])
        		++i;
        	else
        		--j;	
        }
		return max;
    }

	
	
	
	public static void main(String[] args) {
	
		int[] a= {1,8,6,2,5,4,8,3,7};
		System.err.println(maxArea(a));
		
	}

}
