class lookup{
	public static void main(String args[]){
		int num = 1;
		lookup lk = new lookup();
		for(int i=0;i<10;i++){
			System.out.println(num);
			num = lk.getnext(num);
		}
	}
	public int getnext(int num){
		int[] a = new int[] {0,0,0,0,0,0,0,0,0};
		boolean cond = true;
		String str = Integer.toString(num);
		int len = str.length();
		String snum="";
		int newdigit = 0;
		int prev = -1;
		int count=0;
		while(cond){
			newdigit = num%(int)(Math.pow(10,len));
			if(prev == -1 || prev == newdigit){
				count++;
				System.out.println(count);
				prev = newdigit;
			}
			else{
				snum+=newdigit+""+count;
				count = 1;
				prev=newdigit;
			}
			len--;
			if(len == 0)cond = false;
		}
		snum+=newdigit+""+count;
		int ret = Integer.parseInt(snum);
		return ret;
	}
}	
