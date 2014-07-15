class tictoe{
	public static void main(String args[]){
			int[][] game = new int[][]{{1,0,1,1,1,0,0,0},{0,1,1,0,0,0,1,0},{0,0,1,1,1,0,0,0},{1,1,1,1,0,0,1,1},{1,1,1,0,1,0,1,1},{0,0,0,1,1,1,0,0},{1,1,1,0,0,0,1,0},{1,0,0,0,1,1,1,1}};
			int[][] visited = new int[game.length][game[0].length];
			int XCount=0;
			int YCount=0;
			int XScore=0;
			int YScore=0;
			for(int i=0;i<game.length;i++){
				for(int j=0;j<game[0].length;j++){
					///row
					if(j-1 >=0){
						if(game[i][j-1] == 1 && game[i][j] == 1){
							XCount++;
							if(XCount == 3)XScore+=1;
							if(XCount == 8)XScore+=6;
						}
						if(game[i][j-1] == 0 && game[i][j] == 0){
                                                        YCount++;
                                                        if(YCount == 3)YScore+=1;
                                                        if(YCount == 6)YScore+=3;
                                                }
						if(game[i][j-1] == 1 && game[i][j] == 0){
							XCount =0;
							YCount++;
						}
						if(game[i][j-1] == 0 && game[i][j] == 1){
                                                        YCount =0;
                                                        XCount++;
                                                }
					}
					else{
						if(game[i][j] == 1)XCount =1;
						else YCount =1;
					}
					//visited[i][j]=1;
				}
				for(int j=0;j<game[0].length;j++){
                                        ///col
                                        if(j-1 >=0){
                                                if(game[j-1][i] == 1 && game[j][i] == 1){
                                                        XCount++;
                                                        if(XCount == 3)XScore+=1;
                                                        if(XCount == 8)XScore+=6;
                                                }
                                                if(game[j-1][i] == 0 && game[j][i] == 0){
                                                        YCount++;
                                                        if(YCount == 3)YScore+=1;
                                                        if(YCount == 6)YScore+=3;
                                                }
                                                if(game[j-1][i] == 1 && game[j][i] == 0){
                                                        YCount =0;
                                                        XCount++;
                                                }
                                                if(game[j-1][i] == 0 && game[j][i] == 1){
                                                        YCount =0;
                                                        XCount++;
                                                }
                                        }
                                        else{
                                                if(game[j][i] == 1)XCount =1;
                                                else YCount =1;
                                        }
					//visited[j][i]=1;
                                }
				
				for(int j=i;j<game[0].length;j++){
                                        ///diagonal
                                        if(j-1 >=0){
                                                if(visited[j][j]!=1 && game[j-1][j-1] == 1 && game[j][j] == 1){
                                                        XCount++;
                                                        if(XCount == 3)XScore+=1;
                                                        if(XCount == 8)XScore+=6;
                                                }
                                                if(visited[j][j]!=1 && game[j-1][j-1] == 0 && game[j][j] == 0){
                                                        YCount++;
                                                        if(YCount == 3)YScore+=1;
                                                        if(YCount == 6)YScore+=3;
                                                }
                                                if(visited[j][j]!=1 && game[j-1][j-1] == 1 && game[j][j] == 0){
                                                        XCount =0;
                                                        YCount++;
                                                }
                                                if(visited[j][j]!=1 && game[j-1][j-1] == 0 && game[j][j] == 1){
                                                        YCount =0;
                                                        XCount++;
                                                }
                                        }
                                        else{
                                                if(visited[j][j]!=1 && game[j][j] == 1) XCount =1;
                                                else if(visited[j][j]!=1 ) YCount =1;
                                        }
					visited[j][j]=1;
                                }
			}
			if(XScore >YScore){System.out.println("1 is winner with "+XScore+" points and 0 score is "+YScore);}
			else System.out.println("0 is winner with "+YScore+ " points and 1 score is "+XScore);

		}	
	}					
