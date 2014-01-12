class overload{
	public void overloaddemo(){
	}
	
	public int test(int a,int b){
		return a+b;
	}
	
	public double test(double a,double b){
		return a+b;
	}
	
	public String test(String a, String b){
		return a+b;
	}
}

public class overloaddemo{
	public static void main(String args[]){
		overload old = new overload();
		System.out.println(old.test(10,20));
		System.out.println(old.test(10.00,20.00));
		System.out.println(old.test("abc-","cde"));
	}
}
		
