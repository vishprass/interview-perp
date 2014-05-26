class password{
	public static void main(String[] args){
		int apassword = 40988;
		int epassword = 409;
		boolean cond = true;
		int notworking=-1;
		while(cond){
			int a = apassword%10;
			int b = epassword%10;
			if(a == b){
				apassword = apassword/10;
				epassword = epassword/10;
				if(apassword == 0 && epassword == 0){System.out.println("valid and keyboard not working is"+notworking);cond = false;}
			}else{
				if(notworking == -1) notworking =a;
				if(notworking == a)apassword = apassword/10;
				else { System.out.println("not valid");cond = false;}
			}
		}
	}
}
