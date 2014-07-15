class phoneno{
	public static void main(String[] args){
		phoneno pho = new phoneno();
		int n = 8;
		for(long i=(long)Math.pow(10,n-1);i<(long)Math.pow(10,n)-1;i++){
			if(pho.isvalid(Long.toString(i))) System.out.println(""+i);
		}
	}
	public boolean isvalid(String phno){ 
		boolean four = false;
		if(phno.charAt(0)  == '4') four = true;
		char prev = phno.charAt(0);
		boolean valid = true;
		for(int i=1;i<phno.length();i++){
			if(phno.charAt(i) == '7' || phno.charAt(i) == '8' || phno.charAt(i) == '9'){
				//System.out.println("Not Valid");
				return false;
				//System.exit(0);
			}
			if(phno.charAt(i) == '4' && four == false){
                                //System.out.println("Not Valid");
				return false;
                                //System.exit(0);
                        }
			if(prev != '-' && prev == phno.charAt(i)){
                                //System.out.println("Not Valid");
				return false;
                                //System.exit(0);
                        }
			prev = phno.charAt(i);
		}
		//if(valid) System.out.println("Valid");
		return true;
	}
}	
