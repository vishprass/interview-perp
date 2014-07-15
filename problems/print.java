class print{
	public static void main(String[] args){
		int digit = 4;
		int first = 1234;
		System.out.println(first);
		for(int i=1;i<=digit;i++){
			int limit = first%Math.pow(10,i);
			for(int j=limit
