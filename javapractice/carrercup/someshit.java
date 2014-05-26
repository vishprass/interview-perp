class someshit{
	public static void main(String[] args){
		int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1,-5, 4};
		int sum = 0;
		int maxsum =0;
		for(int i=0;i<arr.length;i++){
			sum =arr[i];
			for(int j =i+1; j<arr.length;j++){
				sum += arr[j];
				if(sum > maxsum) maxsum = sum;
			
			}
		}
		System.out.println(maxsum+"");
	}
} 
