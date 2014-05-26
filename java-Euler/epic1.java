import java.util.Scanner;
class epic1{
	public static void main(String args[]){
		System.out.println("Enter the no");
		Scanner sc = new Scanner(System.in);
    		double  i = sc.nextDouble();
		int a =(int) (i*10000);
		int b = 10000;
		boolean c =true;
		while(c){
			int factor = gcd(a,b);	
			if(factor == -1){
				c = false; continue;
			}
			a = a/factor;
			b = b/factor;
		}
		System.out.println(""+a+"/"+b);
	}
	public static int gcd(int a, int b){
		int i=2;
		while(i<a){
			if(a%i == 0 && b%i ==0)
			return i;
			i++;
		}
		return -1;
	}
}		
