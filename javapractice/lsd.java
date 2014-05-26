class lsdsort{
	public void Sort(String a[], int w){
		int n = a.length;
		String[] aux = new String[n];
		for(int i = w-1; i>= 0; i--){
			int[] count = new int[257];
			for(int j=0; j<n; j++)
				count[a[j].charAt(i) + 1]++;
			for(int k=0;k< 256; k++)
				count[k+1] += count[k];
			for(int l=0;l<n; l++)
				aux[count[a[l].charAt(i)]++] = a[l];
			for(int m=0;m<n;m++)
				a[m]=aux[m];
		}
		System.out.println("SOrted list is");
		for(int i=0;i<n;i++)
			System.out.println(a[i]);
	}
}
public class lsd{
	public static void main(String args[]){
		String[] a = {"1w2344","1w3242","1q4444","2w4444","6y5555"};
		lsdsort lsds = new lsdsort();
		lsds.Sort(a,6);
	}
}  	
