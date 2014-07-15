class security{
	public static void main(String[] args){
		int[][] numpad = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		String allowed = "1579";
		String entered ="159";
		int maxerror=0;
		int j=0;
		for(int i=0;i<allowed.length();i++){
			if(allowed.charAt(i) == entered.charAt(j)){
				j++;
			}else{
				String ind = entered.charAt(j)+"";
				int index = (Integer.parseInt(ind))-1;
				int x = index/3;
				int y=0;
				if(index%3==0){
					if(index == 0 || index == 6) y =0;
					else y =2;
				} 
				else y=index%3;
				if(x-1 >=0 && entered.charAt(j) == ((char)numpad[x-1][y])){
					j++;
					maxerror++;
				}
				else if(x+1 <=2 && entered.charAt(j) == (char)numpad[x+1][y]){
                                        j++;
                                        maxerror++;
                                }
				else if(y-1 >=0 && entered.charAt(j) == (char)numpad[x][y-1]){
                                        j++;
                                        maxerror++;
                                }
                                else if(y+1 <=2 && entered.charAt(j) == (char)numpad[x][y+1]){
                                        j++;
                                        maxerror++;
                                }
				else if(x-1<0 || y-1<0 || x+1>2 || y+1>2){
					maxerror++;
				}
				else{
					System.out.println("Invalid");
					System.exit(0);
				}
			}
		}
		if(maxerror <=1)System.out.println("valid");
		else System.out.println("Invalid");
	}
}

