public class problem4{
	public static void main(String[] args){
		long num1=999;
		long num2=999;
		long prod=1;
		long prevpalin=0;
		long palinnum1=0;
		long palinnum2=0;
		String num;
		String strrev;
		while(num1>=100 && num2>=100){
			prod=num1*num2;
			num=prod+"";
			strrev=new StringBuilder(num).reverse().toString();
			if(num.equals(strrev)){
				if(prod>prevpalin){
					prevpalin=prod;
					palinnum1=num1;
					palinnum2=num2;
				}
				num1--;
				num2=num1;
			}
			if(num2>100)
				num2--;
			else{
				num1--;
				num2=num1;
			}
			
		}
		System.out.println(prevpalin+"--"+palinnum1+"--"+palinnum2);
	}


}