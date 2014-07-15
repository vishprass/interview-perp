class subbprobseq{
	public static void main(String[] args){
		int[] a = new int[] {1,7,6,3,5,8,9};
		int sum = 16;
		int n = a.length;
		int i=0;
		int newsum=0;
		String newsumpat ="";
		while(i<n){
			for(int j=i;j<n;j++){
				newsum += a[j];
				if(newsumpat == "") newsumpat = newsumpat+a[j];
				else newsumpat = newsumpat + "-" +a[j];
				if(newsum == sum){
					System.out.println(newsumpat);
					System.exit(0);
				}else if(newsum >sum){
					i++;
					newsum = 0;
					newsumpat = ""; 
					break;
				}
			}
		}
	}
}
