import java.util.*;
class longestpalin{
	public static void main(String args[]){
		String palin ="YAZBXBA";
		int[][] longest = new int[palin.length()][palin.length()];
		for(int i=0;i<palin.length();i++)
			longest[i][i]=1;
		for(int i=1;i<palin.length();i++){
			for(int j=0;j<palin.length()-i;j++){
				int k = i+j;
				if(palin.charAt(j) == palin.charAt(k) &&  i == 0)
					longest[j][k] = 2;
				else if(palin.charAt(j) == palin.charAt(k)){
					longest[j][k] = longest[j+1][k-1]+2;
					System.out.println(palin.substring(j,k+1));
				}
				else longest[j][k] = Math.max(longest[j][k-1],longest[j+1][k]);
			}
		}
		ArrayList pal = new ArrayList();
		for(int i=0;i<longest.length;i++)
			for(int j=0;j<longest[0].length-1;j++)
				pal.add(longest[i][j]);
		System.out.println(""+Collections.max(pal));
	}
}
