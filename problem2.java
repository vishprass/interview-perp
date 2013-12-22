public class problem2{
	public static void main(String[] args){
		long sum=0;
		long curr;
		long prev=1;
		long sumfib=0;
		//int[] fib;
		//fib = new int[4000000];
		for(long index=0;index<4000000;index++){
			curr=sum+prev;
			prev=sum;
			sum = curr;

			if(sum>4000000)break;
			//fib[index]=sum;
			if(sum%2==0)
				sumfib+=sum;
		}
		System.out.println(sumfib);
	}
}