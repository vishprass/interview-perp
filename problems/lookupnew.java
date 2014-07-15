class lookupnew{
	public static void main(String args[]){
		int num = 1;
		lookupnew lk = new lookupnew();
		for(int i=0;i<10;i++){
			System.out.println(num);
			num = lk.getnext(num);
		}
	}
	public int getnext(int num){
		String str = new String();
		str = Integer.toString(num);
		char newchar = 'a';
		char prevchar ='a';
		String newnum ="";
		int count=0;
		for(int i=0;i<str.length();i++){
			newchar = str.charAt(i);
			if(prevchar == 'a' || prevchar == newchar){
				count++;
				prevchar = newchar;
			}else{
				newnum += count+""+prevchar;
				count = 1;
				prevchar = newchar;
			}
		}
 		newnum = newnum+count+""+prevchar; 
		int ret = Integer.parseInt(newnum);	  
		return ret;
	}
}	
