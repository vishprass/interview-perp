public class epicmatrix{
	public static void main(String args[]){
		char[][] mat = {{'s','i','l','k'},{'u','i','i','i'},{'i','t','n','c'},{'k','s','k','k'}};
		String search = "iik";
		char[] searchArray = search.toCharArray();
		int status =0;
		for(int i=0; i<mat.length;i++){
			for(int j=0; j<mat[0].length;j++){
				if(mat[i][j] == searchArray[0]){
					if(i-1 >=0 &&  mat[i-1][j] == searchArray[1])
						status = searchhorizontalreverse(mat,i,j,searchArray);
					if(status != 1){
						if(mat[i+1][j] == searchArray[1])
							status = searchhorizontal(mat,i,j,searchArray);
						if(status != 1){
							if(j-1 >=0 && mat[i][j-1] == searchArray[1])
								status = searchverticalreverse(mat,i,j,searchArray);
							if(status != 1){
								if(mat[i][j+1] == searchArray[1])
									status = searchvertical(mat,i,j,searchArray);
								if(status != 1){
									if(i-1>=0 && j-1>=0 && mat[i-1][j-1] == searchArray[1])
										status = searchsidereverse(mat,i,j,searchArray);
									if(status != 1){
										if(mat[i+1][j+1] == searchArray[1])
											status = searchside(mat,i,j,searchArray); 
									}
								}
							}
						}
					}				
				}
			}
		}
		if(status == 0)	System.out.println("Word not found");
	}
	public static int searchhorizontalreverse(char[][] mat, int m, int n, char[] searchArray){
		int j=2;
		for(int i=m-2; i>=0 && j<searchArray.length;i--,j++){
			if(i<0 || mat[i][n] != searchArray[j])
			return 0;
		}
		System.out.println("Found");
                return 1;
        }
        public static int  searchhorizontal(char[][] mat, int m, int n, char[] searchArray){
                int j=2;
                for(int i=m+2; i<mat.length && j<searchArray.length;i++,j++){
                        if(mat[i][n] != searchArray[j])
                        return 0;
                }
		System.out.println("Found");
                return 1;
        }
	public static int  searchverticalreverse(char[][] mat, int m, int n, char[] searchArray){
                int j=2;
                for(int i=n-2; i>=0 && j<searchArray.length;i--,j++){
                        if(i <0 || mat[m][i] != searchArray[j])
                        return 0;
                }
		System.out.println("Found");
                return 1;
        }
        public static int  searchvertical(char[][] mat, int m, int n, char[] searchArray){
                int j=2;
                for(int i=n+2; i<mat[m].length && j<searchArray.length;i++,j++){
                        if(mat[m][i] != searchArray[j])
                        return 0;
                }
		System.out.println("Found");
                return 1;
        }
	
	public static int  searchsidereverse(char[][] mat, int m, int n, char[] searchArray){
                int k=2;
                for(int i=m-2, j=n-2; i>=0 && j>=0 && k<searchArray.length;i--,j--,k++){
                        if(i<0 || j<0 || mat[i][j] != searchArray[k])
                        return 0;
                }
                System.out.println("Found");
                return 1;
        }
        public static int  searchside(char[][] mat, int m, int n, char[] searchArray){
                int k=2;
                for(int i=m+2, j=n+2; i<mat.length && j<mat[i].length && k<searchArray.length;i++,j++,k++){
                        if(mat[i][j] != searchArray[k])
                        return 0;
                }
                System.out.println("Found");
                return 1;

        }

}
