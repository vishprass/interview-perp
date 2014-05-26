import java.util.*;
class prb1{
	public static void main(String args[]){
		Scanner scanner = new Scanner( System.in );
		while(true){
			System.out.println("Enter the string");
			String str = scanner.nextLine();
			int len = str.length();
			int flag = 0;
			boolean[] a = new boolean[256];
			int val=0;
			for(int i =0;i< len;i++){
				val = str.charAt(i);
				if (a[val]) {flag =1;break;}
				else a[val] = true;
			}
			if(flag == 0){System.out.println("String has unique characters");}
			else{System.out.println((char)val + " is repeated");}
			System.out.println("Do you want to continue y/n");
			String cont = scanner.nextLine();
			if(cont.equals("y")) continue;
			else break;
		}
	}
}
