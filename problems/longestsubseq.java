class longestsubseq{
	public static void main(String[] args){
		int[] arr = new int[] {10,22,9,33,21,50,41,60,80};
		int[] subseq = new int[] {1,1,1,1,1,1,1,1,1};
		int prev = 0;	
		int num = 0;
		for(int i=1;i<arr.length;i++){
			for(int j=0;j<i;j++){
				if(arr[i]>arr[j]){
					num = Math.max(prev,subseq[j]);
					prev = subseq[j];
				}else break;
			}
			subseq[i] += num;
			num =0; 
		}
		for(int i=0;i<subseq.length;i++)
			System.out.println(""+subseq[i]);
	}
}
