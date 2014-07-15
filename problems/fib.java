class fib{
	public static void main(String[] args){
		int no =10;
		int[] f = new int[no];
		f[0] =0;
		System.out.println(""+f[0]);
		f[1]=1;
		System.out.println(""+f[1]);
		int i=2;
		while(i<no){
			f[i] = f[i-2]+f[i-1];
			System.out.println(f[i]);
			i++;
		}
	}
}
