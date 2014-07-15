class coins{
	public static void main(String[] args){
		int[] coinsdeno = {1,2,3,5};
		int amount = 15;
		int[] amt = new int[amount+1];
		for(int i=1;i<amount+1;i++)
			amt[i] =0;
		for(int i=0;i<coinsdeno.length;i++)
			if(coinsdeno[i]<=amount)
			amt[coinsdeno[i]] = 1;
		int prev = -1;
		for(int i=1;i<=amount;i++){
			int min=0;
			for(int j=0; j<coinsdeno.length;j++){
				if(coinsdeno[j]<=i && amt[i]!=1){
					min = amt[i - coinsdeno[j]];
					if(prev>min || prev == -1)
						prev = min;
				}

			}	
			if(prev != -1)	
				amt[i] = min+1;
			prev = -1;
		}
		System.out.println("no of coins required for "+amount +" is "+amt[amt.length-1]);
	}
}	
