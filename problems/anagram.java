class anagram{
	public static void main(String[] args){
		char[] a = new char[] {'g','u','m'};
		for(int i=1;i<a.length;i++){
			char[] b =a;
			for(int j=i;j<a.length;j++){
				if(b[i-1] != b[j]){
					char temp = b[i-1];
					b[i-1] = b[j];
					b[j] = temp;
				}
				String str = new String(b);
				System.out.println(str);
			}
		}
	}
}
