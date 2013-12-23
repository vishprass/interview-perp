public class problem7{
	public static void main(String[] args){
		long i=0;
		long j=2;
		long flag=0;
		while(true){
			flag=checkprime(j);
			if(flag==1)i++;
			if(i==10001)break;
			j++;
		}
		System.out.println(j);
	}
public static int checkprime(long num){
	for(int i=2;i<=num/2;i++)
		if(num%i==0)return 0;
	return 1;
}

}