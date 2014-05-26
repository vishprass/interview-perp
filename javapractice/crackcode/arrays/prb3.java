import java.util.*;
class prb3{
	public static void main(String args[]){
		String str ="vishinun";
		int val=0;
		boolean[] temp = new boolean[256];
		for(int i=0;i<str.length();i++){
			val = str.charAt(i); 
			if(temp[val]){str =str.replace(""+(char)val,"");i--;}
			else temp[val]=true;
		}
		System.out.println(str);
	}
}
