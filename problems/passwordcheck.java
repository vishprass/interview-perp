class passwordcheck{
	public static void main(String[] args){
		String password="Abc$bc88cd";
		boolean passflag = false;
		boolean digit=false;
		boolean lowerchar = false;
		boolean sequence = false;
		String prev ="";
		String prev1="";
		if(password.length()<5 && password.length()>12)
			passflag = false;
		else{
			for(int i=0;i<password.length();i++){
				if(Character.isDigit(password.charAt(i))){
					digit = true;
				}
				if(Character.isLowerCase(password.charAt(i))){
					lowerchar = true;
				}
				if(prev.contains(password.charAt(i)+"")){
						prev1+=password.charAt(i);
						if(prev1.length()>=2){
							int pos = prev.lastIndexOf(prev1);
						if(pos+prev1.length() == prev.length())
							sequence = true;
						}
				}
				else{
						prev = prev+prev1;
						prev1="";
						prev += password.charAt(i);
						System.out.println(prev);
				}
			}
		}
		if(digit && lowerchar && !sequence)
			System.out.println("Valid");
		else System.out.println("Invalid");
}
}
