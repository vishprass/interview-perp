import java.lang.*;
class palin{
	public static void main(String[] args){
		palin pi = new palin();
		String str ="YAZBXBA";
		int length = pi.getpalin(str,0,str.length()-1);
		System.out.println(length+"");
	}
	public int getpalin(String str,int i,int j){
		if(i==j)
			return 1;
		if(str.charAt(i)==str.charAt(j) && i+1==j)
			return 2;
		if(str.charAt(i)==str.charAt(j))
			return (getpalin(str,i+1,j-1)+2);
		else
			return (int)(Math.max(getpalin(str,i,j-1),getpalin(str,i+1,j)));
	}
}
