public class problem6{
	public static void main(String[] args){
		long sum1=0;long sum2=0;
		for(long i=1;i<=100;i++){
			sum1=sum1+(i*i);
			sum2=sum2+i;
		}
		System.out.println(sum1+"---"+sum2+"---");
		sum1=(sum2*sum2)-sum1;
		System.out.println(sum1);
	}


}