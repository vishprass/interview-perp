class epiclove{
	public static void main(String args[]){
		char[][] strarr = {{'i','l','o','v','e'},{'d','i','n','t','e'},{'n','e','w','e','p'},{'a','i','v','r','i'},{'m','a','x','e','c'}};
		int mini=0, minj=0, maxi=4, maxj=4;
		while(mini != maxi || minj != maxj){
			for(int j =minj; j<maxj;j++)
				System.out.print(""+strarr[mini][j]);
			for(int i = mini;i<maxi;i++)
				System.out.print(""+strarr[i][maxj]);
			for(int j = maxj; j>minj; j--)
				System.out.print(""+strarr[maxi][j]);
			for(int i= maxi; i>mini ;i--)
				System.out.print(""+strarr[i][minj]);
			minj++;
			mini++;
			maxi--;
			maxj--;
		}
		System.out.println(""+strarr[maxi][maxj]);
	}
}
