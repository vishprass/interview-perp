public class prg2{
	public static void main(String args[]){
		//initial variables
		int[][] arr2d = new int[4][];
		
		//initiliztions
		arr2d[0] = new int[1];
		arr2d[1] = new int[2];
		arr2d[2] = new int[3];
		arr2d[3] = new int[4];
		
		//processing start
		for(int i=0;i<4;i++){
			for(int j=0;j<i+1;j++){
				arr2d[i][j]=j;
			}
		}
		
		//printing start
		for(int i=0;i<4;i++){
                        for(int j=0;j<i+1;j++){
                                System.out.print(arr2d[i][j]+"");
                        }
			System.out.println("");
                }
	}
}

