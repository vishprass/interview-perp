class printnum{
	public static void main(String[] args){
		printnum num = new printnum();
		int[] a = new int[] {1,2,3,4,5,6,7,8,9};
		num.printnum("",0,3,a);
	}
	public void printnum(String prefix,int begin,int from,int[] a){
		for(int i=begin;i<a.length;i++){
			if(from == 1)
				System.out.println(prefix+a[i]);
			else
				printnum(prefix+a[i],a[i],from-1,a);
		}
	}
} 
