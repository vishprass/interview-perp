class anagrams{
  public static void main(String args[]){	
	String[] str = new String[] {"cat","dog","abc","atc","god","bac"};
	int[] a = new int[str.length];
	int sum;
	int n = str.length;
	for(int i =0;i<n; i++){
		sum=0;
		for(int j=0;j<str[i].length();j++)
			sum += (int) str[i].charAt(j);
		a[i]=sum;
	}
	String temp="";
	int temp1=0;
	for(int i=0;i<n;i++){
		for(int j=i+1;j<n;j++){
			if(a[i]>a[j]){
				temp = str[i];
				str[i] = str[j];
				str[j] = temp;
				temp1 = a[i];
				a[i] = a[j];
				a[j] = temp1;
			}
			if(a[i] == a[j]){
				if(str[i].compareTo(str[j])>0){
					System.out.println(str[i]+"---"+str[j]);
					temp = str[i];
                                	str[i] = str[j];
                                	str[j] = temp;
                                	temp1 = a[i];
                                	a[i] = a[j];
                                	a[j] = temp1;
				}
			}
		}
	}
	for(int i=0;i<n;i++)
		System.out.println(str[i]);
  }
}	
