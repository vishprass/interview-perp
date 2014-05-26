class smsnew{
	public static String chars[] = {"","","abc","def","ghi","jkl","mno","pqr","stu","vwxyz"};
	public static void main(String[] args){
		smsnew sms1 = new smsnew();
		System.out.println(sms1.print("","234"));
	}
	public String print(String prefix,String mess){
		if(mess.length() ==0){
			System.out.println(prefix);
		}else{
			for(int i=0;i<mess.length();i++){
				String ind = mess.charAt(i)+"";
				int index = Integer.parseInt(ind);
				String str = chars[index]; 
				for(int j=0;j<str.length();j++){
					System.out.println(print(""+str.charAt(j),mess.substring(1)));
				}
			}
		}
		return "";
	}
}
				

