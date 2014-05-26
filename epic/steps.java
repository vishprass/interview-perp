class steps{
	public static void main(String[] args){
		int x=5;
		int y=100;
		int count =21;
		int i=3;
		int z=9;
		while(z<y){
			if(i%2==0){
				z += (i*x);
				count += (i*x);
			}else{
				z = z -(x+i);
				count += (x+i);
			}
			i++;
		}
		System.out.println(count +" steps taken");
	}
}		
