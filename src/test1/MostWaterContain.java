package test1;

public class MostWaterContain {

	static int cot = 0;
	
	public static int contain(int[]arr,int i,int j) {
		if(i>=j)return 0;
		int a,b,c;
		c = (j-i)*Math.min(arr[i], arr[j]);
		cot++;
		a=contain(arr,i+1,j);
		b=contain(arr,i,j-1);
		return Math.max(a, Math.max(b,c));
	}
	
	public static int contain2(int[]arr,int i,int j) {
		int max=-1,n=arr.length,c=0,s;
		for(i=0;i<n-1;i++)
			for(j=i+1;j<n;j++) {
				c = (j-i)*Math.min(arr[i], arr[j]);
				if(c>max) max=c;
				cot++;
			}
				
		return max;
	}	
	
	public static void main(String[] args) {
	
		int[] a= {1,8,6,2,5,4,8,3,7};
		System.err.println(contain2(a,0,a.length-1));
		System.err.println(cot);
	}

}
