public class problem5{
	public static void main(String[] args){
		long num1=20;
		int flag=1;
		while(true){
			for(int i=1; i<=20;i++){
				if(num1%i!=0)
					flag=0;
			}
			if(flag==1){
				break;
			}else{
				flag=1;
				num1=num1+20;
			}
		}
		System.out.println(num1);
	}


}