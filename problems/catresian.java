import java.util.*;
class catresian{
	public static String[] str = {null,"vtfrq","ftk","wzbg","rs",null,"fir","p","lo","p"};
	public static void main(String args[]){
			System.out.println("enter no");
			Scanner sc = new Scanner(System.in);
			int no = sc.nextInt();
			printstrings("",Integer.toString(no));
	}
	public static void printstrings(String prefix,String num){
		if(num.length() == 0)
			System.out.println(prefix);
		else{
			int index = Integer.parseInt(num.charAt(0)+"");
			String temp = new String();
			temp = str[index];
			if(temp!=null){
				for(int i=0;i<temp.length();i++)
					printstrings(prefix+temp.charAt(i),num.substring(1,num.length()));
			}else{
				printstrings(prefix,num.substring(1,num.length()));
			}
		}
	}
}
