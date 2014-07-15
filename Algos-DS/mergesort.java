import java.util.*;
class Merge{
	public int[] mergearray(int a[],int low,int mid,int high){
		int i = low;
		int j = mid+1;
		int n =a.length;
		int[] b =  new int[n];
		for(int k=0;k<n;k++)
			b[k] = a[k];
		for(int k=0;k<n;k++){
			if(i > mid) a[k] = b[j++];
			else if(j > high) a[k] = b[i++];
			else if(b[i] > b[j]) a[k] = b[j++];
			else a[k] = b[i++];
		}
		return a;
	}
}
public class mergesort{
	public static void main(String args[]){
		int a[] = new int[]{1,3,5,7,9,11,13,0,0,0,0,0};
		int b[] = new int[]{2,4,6,8,10};
			for(int i=7;i<=11;i++)
			a[i]=b[i-7];
		Merge m = new Merge();
		a = m.mergearray(a,0,6,11);
		for(int i =0;i<a.length;i++)
			System.out.println(a[i]+"");
	}
}
