import java.util.*;
class snake{
	public static int[][] a = new int[][] {{1,3,2,6,8},{-9,7,1,-1,2},{1,5,0,1,9}};
	public static ArrayList snakepath = new ArrayList();
	public static boolean set = false;
	public static void main(String[] args){
		snake sn = new snake();
		sn.snkpath(a.length,a[0].length,0,0);	
		for(int i=0;i<snakepath.size()-1;i++){
			System.out.print(snakepath.get(i)+",");
		}
		if(snakepath.size()>=1)
			System.out.print(snakepath.get(snakepath.size()-1)+"");
		System.out.println("");
	}
	public void snkpath(int row,int col,int i, int j){
		if(row>i && col>j){
			if(j+1<col && Math.abs(a[i][j]-a[i][j+1])==1){
				snakepath.add(a[i][j]);
				set =true;
				snkpath(row,col,i,j+1);
			}
			else if(i+1<row && Math.abs(a[i][j]-a[i+1][j])==1){
                                snakepath.add(a[i][j]);
				set = true;
                                snkpath(row,col,i+1,j);
                        }
			else if(i+1<row && j+1<col && Math.abs(a[i][j]-a[i+1][j+1])==1){
                                snakepath.add(a[i][j]);
				set = true;
                                snkpath(row,col,i+1,j+1);
                        }
			else if(i+1>=row && j+1>=col){return;}
			else{
				if(i+1>=row){if(set == true)snakepath.add(a[i][j]);return;}
				j++;
				snakepath.clear();
				set = false;
				snkpath(row,col,i,j);
			}
		}
	}
}
