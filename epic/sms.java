class sms{
	public static void main(String[] args){
		String chars[] = {"","","abc","def","ghi","jkl","mno","pqr","stu","vwxyz"};
		String entered ="";
		char prev='@';
		String smsmess ="";
		int count =0;
		for(int i=0;i<entered.length();i++){
			char cur= entered.charAt(i);
			if(cur==prev || prev=='@'){
				count++;
				prev=cur;
			}
			else if(cur=='#'){
				int index = Integer.parseInt(""+prev);
				String str = chars[index]; 
				char temp = str.charAt(count-1);
				smsmess +=temp; 
				count=0;
				prev='@';
			}else if(cur=='*'){
                                int index = Integer.parseInt(""+prev);
                                String str = chars[index];
				char temp = str.charAt(count-1);
				smsmess +=temp+" ";
				count=0;
				prev='@';
			}else{
				int index = Integer.parseInt(""+prev);
                                String str = chars[index];
                                char temp = str.charAt(count-1);
                                smsmess +=temp;
                                count=1;
                                prev=cur;
			}
		}
		int index = Integer.parseInt(""+prev);
                                String str = chars[index];
                                char temp = str.charAt(count-1);
                                smsmess +=temp;

		System.out.println(smsmess);
	}
}
				

