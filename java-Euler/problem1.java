public class problem1{
	public static void main(String[] args){
		int sum=0;
		int count=0;
		for(int index=3;index<1000;index=index+3){
			count++;
			if(index%5!=0){
				sum=sum+index;
			}
		}
		for(int index=5;index<1000;index=index+5){
			sum=sum+index;
			count++;
		}
		System.out.println(sum+" @ "+ count);
	}
}
