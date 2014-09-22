import java.io.*;
public class arr{
	public static void main(String[] args){
		int numarr[][] = {{1,2,3,4,6},{5,4,3,5,7},{6,5,9,8,9},{9,8,7,6,1},{1,8,3,6,2}};
		for(int i=0;i<numarr[0].length;i++){
			int j = 0;
			int k=i;
			while(k>=0 && j<numarr.length){
				System.out.print(numarr[j][k]);
				k--;
				j++;
			} 
			System.out.println("");
		}
		for(int j=1;j<numarr.length;j++){
			int k=j;
			int l=numarr[0].length-1;
			while(k<numarr.length){
				System.out.print(numarr[k][l]);
				k++;
				l--;
			}
			System.out.println("");
		}
	}
}
